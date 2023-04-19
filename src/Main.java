import java.util.*;

public class Main {
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        TaskCollection tasks = new TaskCollection();

        System.out.println("Please choose an option:");
        System.out.println("(1) Add a task.");
        System.out.println("(2) Remove a task.");
        System.out.println("(3) Update a task.");
        System.out.println("(4) List all task.");
        System.out.println("(5) List by priority");
        System.out.println("(0) Exit.");

        try {
            int userInput = input.nextInt();
            input.nextLine();

            while (true) {
                if (userInput == 1) {
                    addTask(tasks);
                } else if (userInput == 0) {
                    System.exit(0);
                } else if (userInput == 2) {
                    removeTask(tasks);
                } else if (userInput == 4) {
                    listTask(tasks);
                } else if (userInput == 3) {
                    updateTask(tasks);
                } else if (userInput == 5) {
                    prioCheck(tasks);
                }

                System.out.println("Please make another selection");
                userInput = input.nextInt();
                input.nextLine();
            }
        } catch (Exception e) {
            System.out.println("something went wrong");
        }
    }

    private static void addTask(TaskCollection tasks) {
        System.out.println("Please enter a title for your new task");
        String title = input.nextLine();

        System.out.println("Please enter a description of the task");
        String desc = input.nextLine();

        System.out.println("Please enter a priority for the task");
        int prio = input.nextInt();
        input.nextLine();

        Task aNewTask = new Task(title, desc, prio);

        tasks.add(aNewTask);
    }

    private static void removeTask(TaskCollection tasks) {
        System.out.println("Enter the task index to remove");
        int rem = input.nextInt();
        tasks.remove(rem);
    }

    private static void listTask(TaskCollection tasks) {
        System.out.println(tasks);
    }

    private static void updateTask(TaskCollection tasks) {
        System.out.println("What index would you like to replace?");
        int ind = input.nextInt();
        input.nextLine();

        System.out.println("Please enter a title for your new task");
        String title = input.nextLine();

        System.out.println("Please enter a description of the task");
        String desc = input.nextLine();

        System.out.println("Please enter a priority for the task");
        int prio = input.nextInt();
        input.nextLine();

        Task aNewTask = new Task(title, desc, prio);
        tasks.set(ind, aNewTask);
    }

    private static void prioCheck(TaskCollection tasks) {
        System.out.println("What priority would you like me to find?");
        int userInput = input.nextInt();

        for (Task item : tasks) {
            int prio = item.getPriority();
            if (prio == userInput) {
                System.out.println(item);
            }
        }
    }
}

class Task implements Comparable<Task> {
    private String title;
    private String desc;
    private int priority;

    public Task(String title, String desc, int priority) {
        this.title = title;
        this.desc = desc;
        this.priority = priority;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getPriority() {
        return
                priority;
    }
    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Task{" +
                "title='" + title + '\'' +
                ", desc='" + desc + '\'' +
                ", priority=" + priority +
                '}';
    }

    @Override
    public int compareTo(Task other) {
        if (this.priority != other.priority) {
            return other.priority - this.priority;
        }
        return this.title.compareTo(other.title);
    }
}

class TaskCollection implements Iterable<Task> {
    private List<Task> tasks;

    public TaskCollection() {
        tasks = new ArrayList<>();
    }

    public void add(Task task) {
        tasks.add(task);
        Collections.sort(tasks);
    }

    public Task get(int index) {
        return tasks.get(index);
    }

    public void remove(int index) {
        tasks.remove(index);
    }

    public void set(int index, Task task) {
        tasks.set(index, task);
        Collections.sort(tasks);
    }

    public int size() {
        return tasks.size();
    }

    @Override
    public Iterator<Task> iterator() {
        return tasks.iterator();
    }

    @Override
    public String toString() {
        return tasks.toString();
    }
}