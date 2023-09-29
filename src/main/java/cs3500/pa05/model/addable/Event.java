package cs3500.pa05.model.addable;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import cs3500.pa05.model.days.DayEnum;

/**
 * Represents an event in the Bullet Journal Application.
 */
public class Event implements Addable {

  private String eventName;
  private String eventDescription;
  private DayEnum day;
  private String startTime;
  private String duration;

  /**
   * Constructs an Event object.
   */
  public Event() {

  }

  /**
   * Constructs an Event object.
   *
   * @param name        the name of the event
   * @param description the description of the event
   * @param day         the day of the event
   * @param startTime   the start time of the event
   * @param duration    the duration of the event
   */
  @JsonCreator
  public Event(@JsonProperty("eventName") String name,
               @JsonProperty("eventDescription") String description,
               @JsonProperty("day") DayEnum day,
               @JsonProperty("startTime") String startTime,
               @JsonProperty("duration") String duration) {
    this.eventName = name;
    this.eventDescription = description;
    this.day = day;
    this.startTime = startTime;
    this.duration = duration;
  }

  @Override
  public String toString() {
    return "Event " + eventName;
  }

  /**
   * Gets the name of the event.
   *
   * @return the name of the event
   */
  public String getEventName() {
    return eventName;
  }

  /**
   * Sets the name of the event.
   *
   * @param eventName the name of the event
   */
  public void setEventName(String eventName) {
    this.eventName = eventName;
  }

  /**
   * Gets the description of the event.
   *
   * @return the description of the event
   */
  public String getEventDescription() {
    return eventDescription;
  }

  /**
   * Sets the description of the event.
   *
   * @param eventDescription the description of the event
   */
  public void setEventDescription(String eventDescription) {
    this.eventDescription = eventDescription;
  }

  /**
   * Gets the Start Time of the event.
   *
   * @return the Start Time of the event
   */
  public String getStartTime() {
    return startTime;
  }

  /**
   * Sets the Start Time of the event.
   *
   * @param startTime the Start Time of the event
   */
  public void setStartTime(String startTime) {
    this.startTime = startTime;
  }

  /**
   * Gets the duration of the event.
   *
   * @return the duration of the event
   */
  public String getDuration() {
    return duration;
  }

  /**
   * Sets the duration of the event.
   *
   * @param duration the duration of the event
   */
  public void setDuration(String duration) {
    this.duration = duration;
  }


  /**
   * Sets the day of the event.
   *
   * @param day the day of the event
   */
  public void setDay(DayEnum day) {
    this.day = day;
  }
  /**
   * Gets the day of the event.
   *
   * @return the day of the event
   */
  public DayEnum getDay() {
    return day;
  }
}




