import classes.ListOverFlowException;
import classes.SLLIterator;
import classes.SinglyLinkedList;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class AutomatedProgram {

    private static SinglyLinkedList singlyLinkedList;
    private static String filename = "/Users/mac/Desktop/test5.txt";
    private static String report = "/Users/mac/Desktop/report.txt";
    private static FileReader fileReader;
    private static BufferedReader bufferedReader;
//    private static BufferedWriter bufferedWriter;
//    private static FileWriter fileWriter;

    public static void main(String[] args) throws IOException, InterruptedException {

        run();
    }

    private static void run() throws IOException, InterruptedException {

        fileReader = new FileReader(filename);
        bufferedReader = new BufferedReader(fileReader);
        int size = (int) Files.lines(Paths.get(filename)).count();
        System.out.println();
        System.out.println("\t\tHold on a second...");
        Thread.sleep(1000);
        System.out.println("\t\tStarting...");
        System.out.println();
        Thread.sleep(1000);
        System.out.println("\t\tSince there are " + size + " elements in the file so the list's size is set to it then");
        Thread.sleep(2000);
        singlyLinkedList = new SinglyLinkedList(size);
        System.out.println();
        Thread.sleep(3000);
        System.out.println("\n\t\t************************** WELCOME TO SINGLY LINKED LIST AREA **************************\n");
        Thread.sleep(3000);
        insertElement();
        Thread.sleep(4000);
        display();
        Thread.sleep(4000);
        iterate();
        Thread.sleep(4000);
        removeElement();
        Thread.sleep(1000);
    }

    private static void insertElement() throws IOException, InterruptedException {
        String line;
        bufferedReader = new BufferedReader(fileReader);

        System.out.println("\t\t\t\tINSERTING ELEMENTS PROCESS");
        System.out.println();
//        Thread.sleep(2000);
        while ((line = bufferedReader.readLine()) != null){
            //taking care of the space issue which could also be implemented in remove()
            if(singlyLinkedList.isFull()){
                System.out.println("\tSomething went wrong!<(^~^)> data could not be added!");
                throw new ListOverFlowException("List Overflow");

            }else if (singlyLinkedList.insertModifiedVersion7(line)){
                System.out.println("\tElement " + line + " successfully inserted <(^_^)>");
//                Thread.sleep(2000);
                System.out.println();
            }
        }
        bufferedReader.close();

    }

    private static void display() throws InterruptedException, IOException {

//        fileWriter = new FileWriter(report);
//        bufferedWriter = new BufferedWriter(fileWriter);
        System.out.println("\n\t\t\t\tDISPLAYING ALL THE ELEMENTS PROCESS");
        System.out.println();
//        Thread.sleep(2000);
        if(singlyLinkedList.isEmpty()){
            System.out.println("\tSorry no data, list is empty!<(^~^)>");
        }
        String words = singlyLinkedList.toString();
        System.out.println(singlyLinkedList.toString());
//        bufferedWriter.write(words + "\n\n");
        System.out.println();
//        while (singlyLinkedList.getIterator().hasNext()){
//        bufferedWriter.write(singlyLinkedList.toString());
//        }
//        bufferedWriter.close();
    }

    private static void iterate() throws InterruptedException, IOException {

//        fileWriter = new FileWriter(report);
//        bufferedWriter = new BufferedWriter(fileWriter);
        System.out.println();
        SLLIterator sllIterator = singlyLinkedList.getIterator();
        System.out.println("\t\t\tITERATING AND DISPLAYING ALL THE EXPECTED RETURNED ELEMENTS PROCESS");
        System.out.println();
//        Thread.sleep(2000);
        if(!sllIterator.hasNext()){
            System.out.println("\tSorry no expected next available<(^~^)>");

        }
        while (sllIterator.hasNext()){
            System.out.println("\t\tExpected data: " + sllIterator.next());
//            bufferedWriter.write("\t\tExpected data: " + sllIterator.next() + "\n\n");
            System.out.println();
        }
//        bufferedWriter.close();
    }

    private static void removeElement() throws IOException, InterruptedException {
        String line;
        long startTime = System.nanoTime();
        System.out.println("\n\t\t\tREMOVING ELEMENT PROCESS");
        System.out.println();
        fileReader = new FileReader(filename);
        bufferedReader = new BufferedReader(fileReader);
        while ((line = bufferedReader.readLine()) != null){
//            Thread.sleep(1000);

            if(singlyLinkedList.removeModifiedVersion7(line)){
                System.out.println("\t\tElement " + line + " successfully deleted!");
                System.out.println();
            }else {
                System.out.println("\tSorry no such data in the list!<(^~^)>");
                System.out.println();
            }
        }
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        int numberOfElements = (int)Files.lines(Paths.get(filename)).count();
        long averageNano = duration / numberOfElements;
        System.out.println();
        System.out.println("\t\tStart time in Nano: " + startTime);
        System.out.println("\t\tEnd time in Nano: " + endTime);
        System.out.println();
        System.out.println("\tTime removal of " + numberOfElements + " elements is: " + duration);
        System.out.println("\tAverage time for each removal with a " + numberOfElements + " elements is: " + averageNano);

    }

}
