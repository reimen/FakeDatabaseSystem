package org.reimen2422.mvc.controllers;

import org.reimen2422.mvc.config.DatabaseConfig;
import org.reimen2422.mvc.models.database.Database;
import org.reimen2422.mvc.utils.Path;

import java.io.IOException;
import java.util.Scanner;

public class ApplicationController {
    private static Database database = new Database(new Path(DatabaseConfig.PROJECT_PATH));

    public static void main(String[] args) {
        try {
            database.use();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("[ Database:1, Table:2, Exit:0 ]");

            String inputString = scanner.next();
            int command = Integer.parseInt(inputString);
            boolean commandStatus = selectCommand(command);
            if (!commandStatus) {
                break;
            }
        }

    }

    public static boolean selectCommand(int command) {
        switch(command) {
            case 1:
                database = DatabaseController.selectDatabaseCommand(database);
                return true;
            case 2:
                TableController.selectTableCommand(database);
                return true;
            case 0:
                System.out.println("exit");
                return false;
            default:
                System.out.println("default");
                return true;
        }
    }
}
