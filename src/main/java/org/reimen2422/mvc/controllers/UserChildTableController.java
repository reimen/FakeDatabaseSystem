package org.reimen2422.mvc.controllers;

import org.reimen2422.mvc.models.database.Database;
import org.reimen2422.mvc.models.database.schemamodels.usertype.UserChild;
import org.reimen2422.mvc.models.database.schemamodels.usertype.UserChild$;
import org.reimen2422.mvc.models.database.table.usertype.UserChildTable;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class UserChildTableController {
    private static UserChildTable userChildTable;
    private static Scanner scanner;

    public static void selectUserChildTableCommand(Database database) {
        UserChildTableController.userChildTable = new UserChildTable(database);

        scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");

        while(true) {
            System.out.println("Table -> UserChild");
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
                UserChild userChild = UserChild$.getInstance().serializeModel(scanner.next());
                try {
                    if(userChild != null) {
                        userChildTable.insert(userChild);
                        System.out.println(userChild.toString());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println();
                return true;
            case 2:
                System.out.println("select all");
                try {
                    userChildTable.create();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                List<UserChild> userChildList = userChildTable.selectAll();
                for(UserChild userChildListItem : userChildList) {
                    System.out.println(userChildListItem.toString());
                }

                System.out.println();
                return true;
            case 3:
                System.out.println("delete by id");
                try {
                    userChildTable.create();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                int id = new Integer(scanner.next());
                boolean existId = userChildTable.deleteById(id);
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
