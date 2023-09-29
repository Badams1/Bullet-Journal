package cs3500.pa05.model.days;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import cs3500.pa05.model.addable.Event;
import cs3500.pa05.model.addable.Task;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a day in the Bullet Journal Application. Day of the week
 */
public class Day {

  private List<Task> tasks;
  private List<Event> events;

  private DayEnum day;


  /**
   * Constructor for a day.
   *
   * @param day the day of the week
   */
  public Day(DayEnum day) {
    this.day = day;
    this.tasks = new ArrayList<>();
    this.events = new ArrayList<>();
  }


  /**
   * Constructs a Day object.
   *
   * @param tasks  the list of tasks for the day
   * @param events the list of events for the day
   */
  @JsonCreator
  public Day(@JsonProperty("tasks") List<Task> tasks,
             @JsonProperty("events") List<Event> events,
             @JsonProperty("day") DayEnum day) {
    this.tasks = tasks;
    this.events = events;
    this.day = day;
  }

  /**
   * Constructs a Day object.
   *
   * @param tasks  the list of tasks for the day
   * @param events the list of events for the day
   */
  public Day(List<Task> tasks, List<Event> events) {
    this.tasks = tasks;
    this.events = events;
  }

  /**
   * Gets the tasks for the day.
   *
   * @return the list of tasks for the day
   */
  public List<Task> getTasks() {
    return this.tasks;
  }

  /**
   * Gets the events for the day.
   *
   * @return the list of events for the day
   */
  public List<Event> getEvents() {
    return this.events;
  }

  /**
   * Adds a task to the day.
   *
   * @param t the task to add
   */
  public void addTask(Task t) {
    this.tasks.add(t);
  }

  /**
   * Adds an event to the day.
   *
   * @param e the event to add
   */
  public void addEvent(Event e) {
    this.events.add(e);
  }


}

