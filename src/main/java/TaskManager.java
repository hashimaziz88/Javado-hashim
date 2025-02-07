import java.io.File;
import java.io.IOException;
import java.util.*;

public class TaskManager {
    private List<String> tasks; // hint: will change in iteration 3


    public TaskManager() {
        // Initialize tasks list
        tasks = new ArrayList<>();
        String data =(ReadTasks("/home/wt/Documents/hashim/DebugSquad/Javado-hashim/src/main/resources/task_read.csv").toString());
        if(data.isEmpty()){
            tasks = new ArrayList<>();
        }
        tasks.add(data);
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

    public  List<String> listTasks() {
        System.out.println(tasks.size());
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
        TaskManager taskManager = new TaskManager();
        taskManager.listTasks();
    }
}