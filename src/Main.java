import java.util.Scanner;
// ניב קלבו ואורי ישראלוב
public class Main {
    public static final int EXPAND_ARRAY = 2;
    public static String[] expandArray(String[] array) {
        String[] temp = new String[array.length*EXPAND_ARRAY];
        for (int i = 0; i < array.length; i++) {
            temp[i] = array[i];
        }
        return temp;
    }
    public static int findArrayIndex(String[] array, String name) {
        int returnIndex = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null && array[i].equals(name)) {
                returnIndex = -2;
                break;
            } else if (array[i] == null) {
                returnIndex = i;
                break;
            }
        }
        return returnIndex;
    }
    public static String[] add(String[] array, String type) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the name of the " + type + ": ");
        String name = sc.nextLine();
        int index = findArrayIndex(array, name);
        while (index == -2) {
            System.out.print(type + " already exists, please choose another one(type -1 to exit): ");
            name = sc.nextLine();
            index = findArrayIndex(array, name);
        }
        if (!name.equals("-1")) {
            if (index == -1) {
                index = array.length;
                array = expandArray(array);
            }
            array[index] = name;
        }
        return array;
    }
    public static void AssignLecturer(String[] lecturers, String[] committees) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the name of the lecturer(type -1 to exit): ");
        String name = sc.nextLine();
        int index = findArrayIndex(lecturers, name);
        while (index != -2 && !name.equals("-1")) {
            System.out.println("lecturer not found, please choose another one: ");
            name = sc.nextLine();
            index = findArrayIndex(lecturers, name);
        }
        if (!name.equals("-1")) {
            System.out.print("Enter the name of the committee(type -1 to exit): ");
            name = sc.nextLine();
            index = findArrayIndex(committees, name);
            while (index != -2 && !name.equals("-1")) {
                System.out.println("committee not found, please choose another one: ");
                name = sc.nextLine();
                index = findArrayIndex(committees, name);
            }
        }
    }
    public static int countItems(String[] array) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                count++;
            }
        }
        return count;
    }
    public static void printArrayNames(String[] array) {
        int itemsNum = countItems(array);
        if (itemsNum > 0) {
            for (int i = 0; i < itemsNum - 1; i++) {
                System.out.print(array[i] + ", ");
            }
            System.out.print(array[itemsNum - 1]);
            System.out.println();
        }
    }
    public static int printMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("choose action:\n "
                            + "0 - Exit\n "
                            + "1 - Add lecturer\n "
                            + "2 - Add committee\n "
                            + "3 - Add study department\n "
                            + "4 - Assign lecturer to a committee\n "
                            + "5 - View salary average\n "
                            + "6 - View salary average for a specific department\n "
                            + "7 - View lecturer details\n "
                            + "8 - View committee details\n ");
        int action = sc.nextInt();
        while (!(action <= 8 && action >= 0)) {
            System.out.println("Please enter a valid option");
            action = sc.nextInt();
        }
        return action;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter the name of the collage: ");
        String name = scn.nextLine();
        String[] lecturers = new String[1];
        String[] committees = new String[1];
        String[] departments = new String[1];
        int parameter = printMenu();
        while (parameter != 0) {
            switch (parameter) {
                case 1:
                    lecturers = add(lecturers, "lecturer");
                    break;
                case 2:
                    committees = add(committees, "committee");
                    break;
                case 3:
                    departments = add(departments, "department");
                    break;
                case 4:
                    AssignLecturer(lecturers, committees);
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    printArrayNames(lecturers);
                    break;
                case 8:
                    printArrayNames(committees);
                    break;
            }
            parameter = printMenu();
        }
    }
}