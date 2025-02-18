import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class TaskManager {
    private ArrayList<Task> tasks; // hint: will change in iteration 3

    public TaskManager() {
        // Initialize tasks list
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
    }

    public ArrayList<Task> ReadTasks(String args) {
        try {
            ArrayList<Task> data = new ArrayList<>();
            // replace with the path to your own CSV file
            File file = new File(args);
            Scanner s = new Scanner(file);

            while (s.hasNextLine()) {
                String lineData = s.nextLine();
                data.add(new Task(lineData));
                System.out.println(lineData);
            }

            s.close();
            return data;
        } catch (Exception e) {
            System.out.println(e);

        }
        return tasks;
    }

    public void addTask(String task) {
        tasks.add(new Task(task));
    }

    public ArrayList<Task> listTasks() {
//        return new ArrayList<>(tasks);
        if (tasks.isEmpty()) {
            System.out.println("The task list is currently empty. ");
        }

        for (Task task : tasks) {
            System.out.println(task);
        }
        return tasks;
    }

    public void deleteTask(String task) {
        if (tasks.isEmpty()) {
            System.out.println("The task list is currently empty. ");
        }
        for (int i = 0; i < tasks.size(); i++) {
            Task task1 = tasks.get(i);
            if (task1.toString().equals(task)) {
                tasks.remove(task1);
            }
        }

    }

    public static void writeUsingFileWriter(ArrayList<Task> data) {
        File file = new File("tasks.csv");
        FileWriter fr = null;

        try {
            fr = new FileWriter(file);
            for (Task item : data) {
                String a = String.format("%s\n", item.getLineData());
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

    public void exit() {
        writeUsingFileWriter(tasks);
    }
}