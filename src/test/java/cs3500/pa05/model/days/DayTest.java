package cs3500.pa05.model.days;


import static org.junit.jupiter.api.Assertions.assertEquals;

import cs3500.pa05.model.addable.Event;
import cs3500.pa05.model.addable.Task;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DayTest {

  Day day;
  Event event;
  Event event2;

  Task task;
  Task task2;

  @BeforeEach
  void setUp() {
    day = new Day(DayEnum.MONDAY);
    event = new Event("event1", "description1", DayEnum.MONDAY,
        "1:00 AM", "2");
    event2 = new Event("event2", "description2", DayEnum.MONDAY,
        "3:00 AM", "4");
    task = new Task("task1", "description1", DayEnum.MONDAY, false);
    task2 = new Task("task2", "description2", DayEnum.MONDAY, false);

  }

  @Test
  void getTasks() {
    day.addTask(task);
    day.addTask(task2);
    assertEquals(2, day.getTasks().size());
    assertEquals(task, day.getTasks().get(0));
    assertEquals(task2, day.getTasks().get(1));
  }

  @Test
  void getEvents() {
    day.addEvent(event);
    day.addEvent(event2);
    assertEquals(2, day.getEvents().size());
    assertEquals(event, day.getEvents().get(0));
    assertEquals(event2, day.getEvents().get(1));
  }
}