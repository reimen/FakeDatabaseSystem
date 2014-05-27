package org.reimen2422.mvc.models.database.table;

import org.reimen2422.mvc.models.database.Database;
import org.reimen2422.mvc.models.database.schemamodels.SchemaModelInterface$;
import org.reimen2422.mvc.models.database.schemamodels.SchemaModelInterface;
import org.reimen2422.mvc.utils.Path;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Table<T extends SchemaModelInterface> {
    protected String name;
    protected Path path;
    protected Database database;
    protected File file;
    protected SchemaModelInterface$<T> schemaModelInterface$;

    public Table(Database database, SchemaModelInterface$<T> schemaModelInterface$) {
        this.name = schemaModelInterface$.getTableName();
        this.database = database;
        path = new Path(database.getPath() + name + ".dat");
        file = new File(path.toString());
        this.schemaModelInterface$ = schemaModelInterface$;
    }

    public String getName() {
        return name;
    }

    public boolean create() throws IOException {
        return file.createNewFile();
    }

    public boolean insert(T data) throws IOException {
        try {
            FileWriter fw = new FileWriter(file, true);
            if (!file.exists()) {
                create();
            }
            fw.write(data.toData() + "\n");
            fw.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<T> selectAll() {
        List<T> tableObjectList = new ArrayList<T>();
        try {
            Scanner scanner = new Scanner(file);
            scanner.useDelimiter("\n");
            while (scanner.hasNext()) {
                T tableObject = schemaModelInterface$.serializeModel(scanner.next());
                if (tableObject != null) {
                    tableObjectList.add(tableObject);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return tableObjectList;
    }

    public T selectById(int id) {
        List<T> tableObjectList = selectAll();
        for (T tableObject : tableObjectList) {
            if (tableObject.getId() == id) {
                return tableObject;
            }
        }
        return null;
    }

    public boolean deleteById(int id) {
        T targetObject = selectById(id);
        if(targetObject == null) return false;

        List<T> tableObjectList = selectAll();
        try {
            delete();
            for(T tableObject : tableObjectList) {
                if(tableObject.getId() != id) {
                    insert(tableObject);
                }
            }
            return true;
        } catch(IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete() throws IOException {
        return !file.exists() || file.delete();
    }
}
