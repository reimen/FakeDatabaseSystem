package org.reimen2422.mvc.models.database;

import org.reimen2422.mvc.models.modelclass.TableModelInterface;
import org.reimen2422.mvc.models.modelclass.TableObjectInterface;
import org.reimen2422.mvc.utils.Path;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Table<T extends TableObjectInterface> {
    protected String name;
    protected Path path;
    protected Database database;
    protected File file;
    protected TableModelInterface<T> tableModelInterface;

    public Table(Database database, TableModelInterface<T> tableModelInterface) {
        this.name = tableModelInterface.getTableName();
        this.database = database;
        path = new Path(database.getPath() + name + ".dat");
        file = new File(path.toString());
        this.tableModelInterface = tableModelInterface;
    }

    public String getName() {
        return name;
    }

    public boolean create() throws IOException {
        return file.createNewFile();
    }

    public boolean insert(T data) throws IOException {
//        if (file.exists()) {
//            try {
//                FileWriter fw = new FileWriter(file, true);
//                fw.write(data.toData() + "\n");
//                fw.close();
//                return true;
//            } catch(IOException e) {
//                return false;
//            }
//        }
//        return false;

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

//    public List<User> selectAll() {
////        List list = new ArrayList();
////        このコードはユーザに依存してしまっている
////        解決策の１つはListの型でインターフェースを指定する
////        ただしUser.serializeはどうしても依存してしまう
////        そこでこのクラスをabstractクラスとして定義し、
////        UserTableやAdminTableで必要なメソッドを定義する
//        List<User> userList = new ArrayList<User>();
//        try{
//            Scanner scanner = new Scanner(file);
//            scanner.useDelimiter("\n");
//            while(scanner.hasNext()) {
////                list.add(User.serialize(scanner.next()));
//                User user = User.serialize(scanner.next());
//                if(user != null) {
//                    userList.add(user);
//                }
//            }
//        } catch(FileNotFoundException e){
//            e.printStackTrace();
//        }
//        return userList;
//    }

    public List<T> selectAll() {
        List<T> tableObjectList = new ArrayList<T>();
        try {
            Scanner scanner = new Scanner(file);
            scanner.useDelimiter("\n");
            while (scanner.hasNext()) {
                T tableObject = tableModelInterface.serializeModel(scanner.next());
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

    public boolean delete() throws IOException {
        return !file.exists() || file.delete();
    }
}
