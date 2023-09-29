package cs3500.pa05.model.addable;

import static org.junit.jupiter.api.Assertions.assertEquals;

import cs3500.pa05.model.days.DayEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EventTest {

  Event event;
  Event event2;
  Event event3;


  @BeforeEach
  public void setUp() {
    event = new Event("event1", "description1", DayEnum.MONDAY,
        "12:00", "1");
    event2 = new Event("event2", "description2", DayEnum.TUESDAY,
        "1:00", "2");
    event3 = new Event();
    event3.setDay(DayEnum.MONDAY);
    event3.setEventName("event3");
    event3.setEventDescription("description3");
    event3.setStartTime("2:00");
    event3.setDuration("3");
  }

  @Test
  public void testToString() {
    assertEquals("Event event1", event.toString());
    assertEquals("Event event2", event2.toString());
    assertEquals("Event event3", event3.toString());
  }

  @Test
  public void testGetEventName() {
    assertEquals("event1", event.getEventName());
    assertEquals("event2", event2.getEventName());
    assertEquals("event3", event3.getEventName());
  }

  @Test
  public void testSetEventName() {
    event.setEventName("event3");
    event2.setEventName("event4");
    assertEquals("event3", event.getEventName());
    assertEquals("event4", event2.getEventName());

  }

  @Test
  public void testGetEventDescription() {
    assertEquals("description1", event.getEventDescription());
    assertEquals("description2", event2.getEventDescription());
  }

  @Test
  public void testSetEventDescription() {
    event.setEventDescription("description3");
    event2.setEventDescription("description4");
    assertEquals("description3", event.getEventDescription());
    assertEquals("description4", event2.getEventDescription());
  }

  @Test
  public void testGetStartTime() {
    assertEquals("12:00", event.getStartTime());
    assertEquals("1:00", event2.getStartTime());
  }

  @Test
  public void testSetStartTime() {
    event.setStartTime("2:00");
    event2.setStartTime("3:00");
    assertEquals("2:00", event.getStartTime());
    assertEquals("3:00", event2.getStartTime());
  }

  @Test
  public void testGetDuration() {
    assertEquals("1", event.getDuration());
    assertEquals("2", event2.getDuration());
  }

  @Test
  public void testSetDuration() {
    event.setDuration("3");
    event2.setDuration("4");
    assertEquals("3", event.getDuration());
    assertEquals("4", event2.getDuration());
  }

  @Test
  public void testSetDay() {
    event.setDay(DayEnum.TUESDAY);
    event2.setDay(DayEnum.WEDNESDAY);
    assertEquals(DayEnum.TUESDAY, event.getDay());
    assertEquals(DayEnum.WEDNESDAY, event2.getDay());
  }
}