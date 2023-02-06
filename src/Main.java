import java.util.ArrayList;
import java.util.Scanner;

//Aden Amin
//CSCI 2447
//I'm done with the tasks project
public class Main {
    static Scanner input = new Scanner(System.in);
    static ArrayList<String> tasks = new ArrayList<>();

    public static void main(String[] args) {
        tasks = new ArrayList<>();
        input = new Scanner(System.in);
        System.out.println("(1) Add a task");
        System.out.println("(2) Remove a task ");
        System.out.println("(3) Update a task");
        System.out.println("(4) List all task");
        System.out.println("(0) Exit");
        System.out.println("please make a selection");
        int userInput = input.nextInt();
        while(true) {
            if (userInput == 1) {
                addTask();
            } else if (userInput == 2) {
                removeTask();
            } else if (userInput == 3) {
                updateTask();
            } else if (userInput == 4) {
                listTasks();
            } else if (userInput == 0) {
                System.exit(0);
                System.out.println("IT'S OVER, THANK YOU ");
            }
            System.out.println("please make a selection");
            userInput = input.nextInt();

        }


    }


    static void addTask() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter task description:");
        String task = scanner.nextLine();
        tasks.add(task);
    }

    static void removeTask() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(tasks);
        System.out.println("Enter task number:");
        int taskNum = scanner.nextInt();
        if (taskNum < 0 || taskNum >= tasks.size()) {
            System.out.println("Invalid task number, please try again.");
        } else {
            tasks.remove(taskNum);
            System.out.println("Task removed successfully.");
        }

    }

    static void updateTask() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter task number:");
        int taskNum = scanner.nextInt();
        if (taskNum < 0 || taskNum >= tasks.size()) {
            System.out.println("Invalid task number, please try again.");
        } else {
            System.out.println("Enter new task description:");
            String task = scanner.next();
            tasks.set(taskNum, task);
            System.out.println("Task updated successfully.");

        }

    }

    static void listTasks() {
        System.out.println("Tasks:");
        System.out.println(tasks);

    }







}