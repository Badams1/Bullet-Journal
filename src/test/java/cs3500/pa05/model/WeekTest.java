package cs3500.pa05.model;


import static org.junit.jupiter.api.Assertions.assertEquals;

import cs3500.pa05.model.days.Day;
import cs3500.pa05.model.days.DayEnum;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests for the Week class.
 */
class WeekTest {

  Week week;
  Week week2;

  @BeforeEach
  void setUp() {
    week = new Week();
    week2 = new Week("Week 1", List.of(new Day(DayEnum.MONDAY)),
        "This is a note", 5, 5);

  }

  @Test
  void getWeekName() {
    week.setWeekName("Week 1");
    assertEquals("Week 1", week.getWeekName());
  }

  @Test
  void getWeekNotesQuotes() {
    week.setWeekNotesQuotes("This is a note");
    assertEquals("This is a note", week.getWeekNotesQuotes());
  }

  @Test
  void setWeekName() {
    week.setWeekName("Week 1");
    assertEquals("Week 1", week.getWeekName());
  }

  @Test
  void setDays() {
    Day day = new Day(DayEnum.FRIDAY);
    Day day2 = new Day(DayEnum.MONDAY);
    List<Day> days = List.of(day, day2);
    week.setDays(days);
    assertEquals(days, week.getDays());
  }

  @Test
  void setWeekNotesQuotes() {
    week.setWeekNotesQuotes("This is a note");
    assertEquals("This is a note", week.getWeekNotesQuotes());
  }

  @Test
  void setMaxDayTasks() {
    week.setMaxDayTasks(5);
    assertEquals(5, week.getMaxDayTasks());
  }

  @Test
  void setMaxDayEvents() {
    week.setMaxDayEvents(5);
    assertEquals(5, week.getMaxDayEvents());
  }
}