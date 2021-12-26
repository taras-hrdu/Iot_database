package com.hrudzinskyi.view;

public final class Menu {

    private Menu() {}

    public static void displayMenu() {
        System.out.println("  Table                     |   Method\n" +
                "|--------------------------------------|---------------|\n" +
                "| 1: type_of_equipment                 |   1: GET ALL  |\n" +
                "| 2: equipment                         |   2: GET      |\n" +
                "| 3: user                              |   3: CREATE   |\n" +
                "| 4: laser_cutter                      |   4: UPDATE   |\n" +
                "| 5: equipment_transfer                |   5: DELETE   |\n" +
                "| 6: repairs_worker                    |_______________|\n" +
                "| 7: repair                            |   Quit - exit |\n" +
                "|--------------------------------------|---------------|\n"
        );
    }
}