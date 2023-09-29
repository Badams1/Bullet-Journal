package cs3500.pa05.model.days;

/**
 * Represents the days of the week.
 */
@SuppressWarnings("MissingJavadoc")
public enum DayEnum {
  SUNDAY("Sunday"),
  MONDAY("Monday"),
  TUESDAY("Tuesday"),
  WEDNESDAY("Wednesday"),
  THURSDAY("Thursday"),
  FRIDAY("Friday"),
  SATURDAY("Saturday");

  private String day;

  /**
   * initializes a dayEnum
   *
   * @param day the day
   */
  DayEnum(String day) {
    this.day = day;
  }

  /**
   * gets the day
   *
   * @return the day
   */
  public String getDay() {
    return day;
  }
}
