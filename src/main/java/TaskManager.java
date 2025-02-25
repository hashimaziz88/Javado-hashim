import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class TaskManager {
    private ArrayList<Task> tasks; // hint: will change in iteration 3

    public TaskManager() {
        File file = new File("tasks.csv");
        FileWriter fr = null;
        boolean exists = file.exists();

        if (exists) {
            tasks = (ReadTasks("tasks.csv"));

        } else {
            try {
                fr = new FileWriter(file);

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    assert fr != null;
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }

            }

        }
        System.out.println();
    }

    public ArrayList<Task> ReadTasks(String args) {
        try {
            ArrayList<Task> data = new ArrayList<>();
            // replace with the path to your own CSV file
            File file = new File(args);
            Scanner s = new Scanner(file);

            while (s.hasNextLine()) {
                String lineData = s.nextLine();
//
                String[] lineDataSplit = lineData.split(",");
                data.add(new Task(lineDataSplit[0],lineDataSplit[1], Boolean.parseBoolean(lineDataSplit[2])));
            }

            s.close();
            return data;
        } catch (Exception e) {
            System.out.println(e);

        }
        return tasks;
    }

    public void addTask(Task task) {
        System.out.println("Adding task to taskManager: " + task.hashCode());
        tasks.add(task);
    }


    public ArrayList<Task> listTasks() {
//        return new ArrayList<>(tasks);
        if (tasks.isEmpty()) {
            System.out.println("The task list is currently empty. ");
        }

        for (Task task : tasks) {
            System.out.println(task.toString());
        }
        return tasks;
    }

    public void deleteTask(String task) {

        for (int i = 0; i < tasks.size(); i++) {
            Task task1 = tasks.get(i);
            if (task1.toString().equals(task.toString())) {
                tasks.remove(task1);
                return;
            }
               }
        throw new IllegalArgumentException("Task not found!");
    }

    public static void writeUsingFileWriter(ArrayList<Task> data) {
        File file = new File("tasks.csv");
        FileWriter fr = null;

        try {
            fr = new FileWriter(file);
            for (Task item : data) {
                String a = String.format("%s\n", item.getTitle());
                fr.write(a);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert fr != null;
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
    }

    public int processMenuChoice(int choice) throws IllegalArgumentException {
            if (choice < 0 || choice> 5){
                String s = "Invalid menu option!";
                throw new IllegalArgumentException(s);
            }
    return choice;

    }

    public void markTaskAsComplete(String taskString) {
        for (Task task : tasks) {
            System.out.println("Checking task: " + task.hashCode() + " - " + task);
            if (task.toString().equals(taskString)) {
                System.out.println("Match found! Marking as complete.");
                task.setComplete();
                return;
            }
        }
    }



    public void exit() {
        writeUsingFileWriter(tasks);
    }

}