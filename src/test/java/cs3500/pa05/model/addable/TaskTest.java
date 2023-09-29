package cs3500.pa05.model.addable;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import cs3500.pa05.model.days.DayEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TaskTest {

  Task task;
  Task task2;

  Task task3;

  @BeforeEach
  void setUp() {
    task = new Task("task1", "description1", DayEnum.MONDAY, false);
    task2 = new Task("task2", "description2", DayEnum.TUESDAY, true);
    task3 = new Task();
    task3.setDay(DayEnum.MONDAY);
    task3.setTaskName("task3");
    task3.setTaskDescription("description3");
    task3.setComplete(true);
  }


  @Test
  void testToString() {
    assertEquals("Task task1", task.toString());
    assertEquals("Task task2", task2.toString());
  }

  @Test
  void getTaskName() {
    assertEquals("task1", task.getTaskName());
    assertEquals("task2", task2.getTaskName());
    assertEquals("task3", task3.getTaskName());
  }

  @Test
  void setTaskName() {
    task.setTaskName("task3");
    task2.setTaskName("task4");
    assertEquals("task3", task.getTaskName());
    assertEquals("task4", task2.getTaskName());
  }

  @Test
  void getTaskDescription() {
    assertEquals("description1", task.getTaskDescription());
    assertEquals("description2", task2.getTaskDescription());
    assertEquals("description3", task3.getTaskDescription());
  }

  @Test
  void setTaskDescription() {
    task.setTaskDescription("description3");
    task2.setTaskDescription("description4");
    assertEquals("description3", task.getTaskDescription());
    assertEquals("description4", task2.getTaskDescription());
  }

  @Test
  void isComplete() {
    assertFalse(task.isComplete());
    assertTrue(task2.isComplete());
    assertTrue(task3.isComplete());
  }

  @Test
  void setComplete() {
    task.setComplete(true);
    task2.setComplete(false);
    assertTrue(task.isComplete());
    assertFalse(task2.isComplete());
  }

  @Test
  void setDay() {
    task.setDay(DayEnum.TUESDAY);
    task2.setDay(DayEnum.WEDNESDAY);
    assertEquals(DayEnum.TUESDAY, task.getDay());
    assertEquals(DayEnum.WEDNESDAY, task2.getDay());
  }
}