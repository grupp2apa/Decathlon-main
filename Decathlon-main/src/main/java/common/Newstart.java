package common;

import java.util.Scanner;

public class Newstart {

    static Scanner scan = new Scanner(System.in);
    //Create a global array
    //private static Ship[] dock1 = new Ship[10];

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        //Repeat until the program gets closed
        while (true){
            System.out.println("Choose an option: 1-3");
            System.out.println("1. Dock");
            System.out.println("2. Undock");
            System.out.println("3. Status");
            System.out.println("4. Exit");

            int menu = scan.nextInt();

            switch (menu) {
                case 1:
                    System.out.println("1. Dock");
                    dock();
                    break;
                case 2:
                    System.out.println("2. Undock");
                    break;
                case 3:
                    System.out.println("3. Status");
                    printArray();
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("No such option");
                    break;
            }
        }

    }

    public static void dock(){

        System.out.println("Enter ship's name: ");
        String name = scan.nextLine();

        System.out.println("Enter ship's size: ");
        String size = scan.nextLine();

        System.out.println("Enter the ships dock:");

        //Check if the dock number is valid
        int i = Integer.valueOf(scan.nextLine());
        //if (i >= 0 && i < 10 && dock1[i] == null){
            //Add ship to the dock
            //dock1[i] = new Ship(name, size);
        //}
        //else{
            System.out.println("Couldn't dock");
        //}

    }

    public static void printArray(){

        System.out.println("Docks:");

       // for (int i = 0; i < dock1.length ; i++) {

         //   if (dock1[i] != null){
                
           //     System.out.println(i + ".: " + dock1[i].getShipName() + "(" + dock1[i].getShipSize() + ")");
            //}
            //else {
              //  System.out.println(i + ".: Empty");
            }

        }
    
    


