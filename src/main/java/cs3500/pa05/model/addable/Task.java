package cs3500.pa05.model.addable;

import com.fasterxml.jackson.annotation.JsonProperty;
import cs3500.pa05.model.days.DayEnum;

/**
 * Represents a task in the Bullet Journal Application.
 */
public class Task implements Addable {

  private String taskName;
  private String taskDescription;
  private DayEnum day;
  private boolean isComplete;

  /**
   * Constructs a Task object.
   */
  public Task() {

  }

  /**
   * Constructs a Task object.
   *
   * @param name        the name of the task
   * @param description the description of the task
   * @param day         the day of the task
   * @param isComplete  whether the task is complete or not
   */
  public Task(@JsonProperty("taskName") String name,
              @JsonProperty("taskDescription") String description,
              @JsonProperty("day") DayEnum day,
              @JsonProperty("isComplete") boolean isComplete) {
    this.taskName = name;
    this.taskDescription = description;
    this.day = day;
    this.isComplete = isComplete;
  }

  @Override
  public String toString() {
    return "Task " + taskName;
  }

  /**
   * Gets the name of the task.
   *
   * @return the name of the task
   */
  public String getTaskName() {
    return taskName;
  }

  /**
   * Sets the name of the task.
   *
   * @param taskName the name of the task
   */
  public void setTaskName(String taskName) {
    this.taskName = taskName;
  }

  /**
   * Gets the description of the task.
   *
   * @return the description of the task
   */
  public String getTaskDescription() {
    return taskDescription;
  }

  /**
   * Sets the description of the task.
   *
   * @param taskDescription the description of the task
   */
  public void setTaskDescription(String taskDescription) {
    this.taskDescription = taskDescription;
  }

  /**
   * Gets the isComplete of the task.
   *
   * @return the isComplete of the task
   */
  public boolean isComplete() {
    return this.isComplete;
  }

  /**
   * Sets the isComplete of the task.
   *
   * @param complete the isComplete of the task
   */
  public void setComplete(boolean complete) {
    isComplete = complete;
  }

  /**
   * Sets the day of the task.
   *
   * @param day the day of the task
   */
  public void setDay(DayEnum day) {
    this.day = day;
  }

  /**
   * Gets the day of the task.
   *
   * @return the day of the task
   */
  public DayEnum getDay() {
    return day;
  }
}
