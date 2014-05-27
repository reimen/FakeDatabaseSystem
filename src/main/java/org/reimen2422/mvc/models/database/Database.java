package org.reimen2422.mvc.models.database;

import org.reimen2422.mvc.utils.Path;

import java.io.File;
import java.io.IOException;

public class Database {

    private Path path;
    private File database;

    public Database(Path path) {
        this.path = new Path(path + "database/");
        database = new File(this.path.toString());
    }

    public void use() throws IOException {
        if(!database.exists()) {
            boolean isMaking = database.mkdir();
            if(!isMaking) {
                throw new IOException("Try create Database but it's failed...");
            }
        }
    }

    public boolean delete() {
        return database.delete();
    }

    public Path getPath() {
        return path;
    }

}
