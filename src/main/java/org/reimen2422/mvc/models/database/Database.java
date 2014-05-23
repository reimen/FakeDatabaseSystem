package org.reimen2422.mvc.models.database;

import org.reimen2422.mvc.utils.Path;

import java.io.File;
import java.io.IOException;

/**
 * Created by hayashi on 2014/05/22.
 */
public class Database {

//    private String databasePath;
    private Path path;
    private File database;

    public Database(Path path) {
        this.path = new Path(path + "database/");
        database = new File(this.path.toString());
    }

    public void use() throws IOException {
        if(!database.exists()) {
//            if (!database.mkdir()) {
//                throw new IOException("Failed to create database.");
//            }
            boolean isMaking = database.mkdir();
            if(!isMaking) {
                throw new IOException("Try create Database but it's failed...");
            }
        }
    }

//    public void delete() throws IOException {
//        if(database.exists()) {
//            if (!database.delete()) {
//                throw new IOException("Failed to delete database.");
//            }
//        }
//    }

    public boolean delete() {
        return database.delete();
    }

    public Path getPath() {
        return path;
    }

}
