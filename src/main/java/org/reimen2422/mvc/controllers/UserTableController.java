package org.reimen2422.mvc.controllers;

import org.reimen2422.mvc.config.DatabaseConfig;
import org.reimen2422.mvc.models.database.Database;
import org.reimen2422.mvc.models.database.schemamodels.usertype.User;
import org.reimen2422.mvc.models.database.schemamodels.usertype.User$;
import org.reimen2422.mvc.models.database.schemamodels.usertype.UserChild;
import org.reimen2422.mvc.models.database.table.usertype.UserTable;
import org.reimen2422.mvc.utils.Path;
import org.reimen2422.mvc.views.UsertypePrinter;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class UserTableController {
    private static Database database;
    private static UserTable userTable;
    private static Scanner scanner;

    public static void selectUserTableCommand(Database database) {
        UserTableController.database = database;
        UserTableController.userTable = new UserTable(UserTableController.database);

        scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");

        while(true) {
            System.out.println("Table -> User");
            System.out.println("[ Insert:1, Select:2, Delete:3, Back:0 ]");

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
                System.out.println("insert");
                User user = User$.getInstance().serializeModel(scanner.next());
                try {
                    userTable.insert(user);
                    System.out.println(user.toString());
                } catch (IOException e) {
                    e.printStackTrace();
                }

                System.out.println();
                return true;
            case 2:
                System.out.println("select all");
                List<User> userList = userTable.selectAll();
//                for(User userListItem : userList) {
//                    System.out.println(userListItem.toString());
//                }
                UsertypePrinter.printAll(userList);

                System.out.println();
                return true;
            case 3:
                System.out.println("delete by id");
                int id = new Integer(scanner.next());
                boolean existId = userTable.deleteById(id);
                if(!existId) {
                    System.out.println("Not exist ID");
                }

                System.out.println();
                return true;
            case 0:
                System.out.println("back\n");
                return false;
            default:
                System.out.println("default\n");
                return true;
        }
    }

}
