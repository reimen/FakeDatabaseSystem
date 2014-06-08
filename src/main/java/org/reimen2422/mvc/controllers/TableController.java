package org.reimen2422.mvc.controllers;

import org.reimen2422.mvc.config.DatabaseConfig;
import org.reimen2422.mvc.models.database.Database;
import org.reimen2422.mvc.utils.Path;

import java.io.IOException;
import java.util.Scanner;

public class TableController {
    private static Database database;

    public static void selectTableCommand(Database database) {
        TableController.database = database;

        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.println("Table");
            System.out.println("[ User:1, UserChild:2, Back:0 ]");

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
                UserTableController.selectUserTableCommand(database);
                return true;
            case 2:
                UserChildTableController.selectUserChildTableCommand(database);
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
