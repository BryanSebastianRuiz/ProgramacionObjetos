import java.time.LocalDate;

public class Task {
    private int taskId;
    private LocalDate date;
    private String name;
    private String description;
    private boolean completed;
    private int priority;

    public Task(int taskId, LocalDate date, String name, String description, boolean completed, int priority) {
        this.taskId = taskId;
        this.date = date;
        this.name = name;
        this.description = description;
        this.completed = completed;
        this.priority = priority;
    }

    // Getters and setters to access and modify the attributes

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskId=" + taskId +
                ", date=" + date +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", completed=" + completed +
                ", priority=" + priority +
                '}';
    }
}
