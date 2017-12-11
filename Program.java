import classes.ListOverFlowException;
import classes.SLLIterator;
import classes.SinglyLinkedList;
import java.io.IOException;
import java.util.Scanner;

public class Program {

    private static  Scanner scanner = new Scanner(System.in);
    private static  Scanner scanner1 = new Scanner(System.in);
    private static SinglyLinkedList singlyLinkedList;

    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println();
        System.out.print("\t\tEnter the size of the list: ");
        int size = scanner1.nextInt();
        singlyLinkedList = new SinglyLinkedList(size);
        System.out.println();
        System.out.println("\n\t\t************************ WELCOME TO SINGLY LINKED LIST AREA ************************\n");
//        String[] elements = {"Fluorine","Neon","Sodium","Magnesium","Aluminium","Silicon"};
        MainMenu();
        int choice;

        while((choice = scanner1.nextInt())!= 0){

            if(choice == 1){
                insertElement();

            }else if (choice == 2){
               display();

            }else if (choice == 3){
               iterate();

            }else if (choice == 4){
               removeElement();
            }
        }
        scanner1.close();
        scanner.close();
    }

    private static void MainMenu() {
        System.out.println("\t---------------------------------------");
        System.out.println("\t\t\t1 - Insert an element");
        System.out.println("\t\t\t2 - Display elements");
        System.out.println("\t\t\t3 - Iterate through elements");
        System.out.println("\t\t\t4 - Remove an element");
        System.out.println("\t\t\t0 - Quit\n");
        System.out.print("\t\t\tEnter your choice --> ");
        System.out.println("\n");
        System.out.println("\t---------------------------------------");
    }

    private static void insertElement() {

        System.out.print("\n\tEnter an elemment: ");
        String data = scanner.next();
        //taking care of the space issue which could also be implemented in remove()
        if(singlyLinkedList.isFull()){
            System.out.println("\tSomething went wrong!<(^~^)> data could not be added!");
            throw new ListOverFlowException("List Overflow");

        }else if (singlyLinkedList.insertModifiedVersion7(data)){
            System.out.println("\tElement successfully inserted <(^_^)>");
            System.out.println();
        }
        MainMenu();
    }

    private static void display(){

        System.out.println("\n\t\tAll the Elements");
        if(singlyLinkedList.isEmpty()){
            System.out.println("\tSorry no data, list is empty!<(^~^)>");
        }
        System.out.println(singlyLinkedList.toString());
//                System.out.print("Returned data: "+ singlyLinkedList.getIterator().next());
        System.out.println();
        MainMenu();
    }

    private static void iterate(){

        System.out.println();
        SLLIterator sllIterator = singlyLinkedList.getIterator();
        if(!sllIterator.hasNext()){
            System.out.println("\tSorry no expected next available<(^~^)>");
//            break;
        }
        while (sllIterator.hasNext()){
            System.out.println("Expected data: " + sllIterator.next());
            System.out.println();
        }
        MainMenu();
    }

    private static void removeElement() {
        System.out.print("\n\tEnter the element to be removed: ");
        String data = scanner.next();
        if(singlyLinkedList.removeModifiedVersion7(data)){
            System.out.println("\tElement successfully deleted!");
        }else {
            System.out.println("\tSorry no such data in the list!<(^~^)>");
        }
        MainMenu();
    }

}
