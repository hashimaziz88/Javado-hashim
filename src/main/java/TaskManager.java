import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class TaskManager {
    private List<String> tasks; // hint: will change in iteration 3


    public TaskManager() {
        // Initialize tasks list
        tasks = new ArrayList<>();
        tasks = (ReadTasks("/home/wt/Documents/hashim/DebugSquad/Javado-hashim/src/main/resources/task_read.csv"));
        System.out.println(tasks);
    }

    public List<String> ReadTasks(String args) {
        try {
            List<String> data = new ArrayList<>();
            // replace with the path to your own CSV file
            File file = new File(args);
            Scanner s = new Scanner(file);

            while (s.hasNextLine()) {
                List<String> lineData = Arrays.asList(s.nextLine().split(","));
                String lineData1 = lineData.get(1);
                data.add(lineData1);

            }

            s.close();
            return data;
        } catch (Exception e) {
            System.out.println(e);

        }
        return Collections.emptyList();
    }

    public void addTask(String task) {
        tasks.add(task);
    }

    public List<String> listTasks() {
        System.out.println(tasks.size());
//        return new ArrayList<>(tasks);
        if (tasks.isEmpty()) {
            System.out.println("The task list is currently empty. ");
        }
        for (String task : tasks) {

            System.out.println(task);
        }
        return new ArrayList<>(tasks);
    }

    public void deleteTask(String task) {
//        leave for iteration 4
    }

    public static void writeUsingFileWriter(List<String> data) {
        File file = new File("/home/wt/Documents/hashim/DebugSquad/Javado-hashim/src/main/resources/task_read.csv");
        FileWriter fr = null;

        try {
            fr = new FileWriter(file);
            int count = 0;
            for (String item : data) {
                count += 1;
                String a = String.format("%d,%s\n", count, item);
                System.out.print(a);
                fr.write(a);
            }

        } catch (IOException e) {
            e.printStackTrace();
            ;
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

    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();


    }
}