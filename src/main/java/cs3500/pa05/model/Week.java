package cs3500.pa05.model;

import cs3500.pa05.model.days.Day;
import java.util.List;

/**
 * Represents a week in the bullet journal.
 */
public class Week {

  private String weekName;
  private List<Day> days;


  private String weekNotesQuotes;

  private int maxDayTasks;

  private int maxDayEvents;


  /**
   * Constructor for a week. Empty for initialization purposes.
   */
  public Week() {

  }

  /**
   * Constructor for a week.
   *
   * @param weekName        the name of the week
   * @param days            the list of days in the week
   * @param weekNotesQuotes the notes and quotes for the week
   */
  public Week(String weekName, List<Day> days, String weekNotesQuotes, int maxDayTasks,
              int maxDayEvents) {
    this.weekName = weekName;
    this.days = days;
    this.weekNotesQuotes = weekNotesQuotes;
    this.maxDayTasks = maxDayTasks;
    this.maxDayEvents = maxDayEvents;
  }

  /**
   * Gets the name of the week.
   *
   * @return the name of the week
   */
  public String getWeekName() {
    return this.weekName;
  }

  /**
   * Gets the notes and quotes for the week.
   *
   * @return the notes and quotes for the week
   */
  public String getWeekNotesQuotes() {
    return this.weekNotesQuotes;
  }

  /**
   * Sets the name of the week.
   *
   * @param weekName the name of the week
   */
  public void setWeekName(String weekName) {
    this.weekName = weekName;
  }

  /**
   * Sets the list of days in the week.
   *
   * @param days the list of days in the week
   */
  public void setDays(List<Day> days) {
    this.days = days;
  }

  /**
   * Gets the list of days in the week.
   */
  public List<Day> getDays() {
    return this.days;
  }

  /**
   * Sets the notes and quotes for the week.
   *
   * @param weekNotesQuotes the notes and quotes for the week
   */
  public void setWeekNotesQuotes(String weekNotesQuotes) {
    this.weekNotesQuotes = weekNotesQuotes;
  }

  /**
   * Sets the max number of tasks per day.
   *
   * @param maxDayTasks the max number of tasks per day
   */
  public void setMaxDayTasks(int maxDayTasks) {
    this.maxDayTasks = maxDayTasks;
  }

  /**
   * Gets the max number of tasks per day.
   */
  public int getMaxDayTasks() {
    return this.maxDayTasks;
  }

  /**
   * Sets the max number of events per day.
   *
   * @param maxDayEvents the max number of events per day
   */
  public void setMaxDayEvents(int maxDayEvents) {
    this.maxDayEvents = maxDayEvents;
  }

  /**
   * Gets the max number of events per day.
   */
  public int getMaxDayEvents() {
    return this.maxDayEvents;
  }
}