package org.reimen2422.mvc.controllers;

import org.reimen2422.mvc.config.DatabaseConfig;
import org.reimen2422.mvc.models.database.Database;
import org.reimen2422.mvc.utils.Path;

import java.io.IOException;
import java.util.Scanner;

public class DatabaseController {
    public static Database database;

    public static Database selectDatabaseCommand(Database database) {
        DatabaseController.database = database;
        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.println("Database");
            System.out.println("[ Use:1, Back:0 ]");

            String inputString = scanner.next();
            int command = Integer.parseInt(inputString);
            boolean commandStatus = selectCommand(command);
            if (!commandStatus) {
                return DatabaseController.database;
            }
        }
    }

    public static boolean selectCommand(int command) {
        switch(command) {
            case 1:
                try {
                    database.use();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("+++ database.use() +++");
                return true;
            case 0:
                return false;
            default:
                System.out.println("default");
                return true;
        }
    }

}
