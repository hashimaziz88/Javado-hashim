public class Task {
    //    leave empty this is for iteration 3
    private String title;
    private String description;
    private boolean status;

    public Task(String title, String description, boolean status) {
        this.title = title;
        this.description = description;
        this.status = status;
    }


    public String getLineData() {
        return lineData.trim();
    }

    @Override
    public String toString() {
        return lineData;
    }
}
