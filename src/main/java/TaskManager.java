import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TaskManager {
    private List<String> tasks; // hint: will change in iteration 3


    public TaskManager() {
        // Initialize tasks list
        tasks = new ArrayList<>();
    }

    public static void  ReadTasks(String args) throws IOException {
        Scanner sc = new Scanner(new File("/home/wt/Documents/hashim/DebugSquad/Javado-hashim/src/main/resources/task_read.csv"));
        sc.useDelimiter(",");   //sets the delimiter pattern
        while (sc.hasNext())  //returns a boolean value
        {
            String task = Arrays.toString(sc.next().split(","));
            System.out.println(task);

            //find and returns the next complete token from this scanner
        }

        sc.close();
    }

    public void addTask(String task) {
        tasks.add(task);
    }

    public  List<String> listTasks() {
//
//        return new ArrayList<>(tasks);
        for (String task: tasks){
            System.out.println(task);
        }
        return new ArrayList<>(tasks);
    }

    public void deleteTask(String task){
//        leave for iteration 4
    }

    public void exit() {
        // leave for iteration 2
    }

    public static void main(String[] args) throws IOException {
        ReadTasks("resources/tasks_read.csv");
    }
}