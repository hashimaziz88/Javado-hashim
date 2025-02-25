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

    public Task(Task task) {
        this.title = task.getTitle();
        this.description = task.getDescription();
        this.status = task.isComplete();
    }


    public String getTitle() {

        return title.trim();
    }

    public String getDescription(){
        return description.trim();
    }

    public Boolean isComplete(){
        return this.status;
    }

    public void setComplete(){
        this.status = true;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%b", getTitle(), getDescription(),isComplete());
    }
}
