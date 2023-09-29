package cs3500.pa05.model.json;


import static org.junit.jupiter.api.Assertions.assertEquals;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import cs3500.pa05.model.addable.Event;
import cs3500.pa05.model.addable.Task;
import cs3500.pa05.model.days.Day;
import cs3500.pa05.model.days.DayEnum;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WeekJsonTest {


  ObjectMapper mapper;

  @BeforeEach
  void setUp() {
    mapper = new ObjectMapper();
  }

  @Test
  public void testCoordJson() {
    String weekName = "Week 1";
    Task task = new Task("task1", "description1", DayEnum.FRIDAY, false);
    Task task2 = new Task("task2", "description2", DayEnum.FRIDAY, false);
    Event event = new Event("event1", "description1", DayEnum.FRIDAY,
        "3 AM", "4");
    List<Task> tasks = List.of(task, task2);
    List<Event> events = List.of(event);
    Day day = new Day(tasks, events, DayEnum.FRIDAY);
    String weekNotesQuotes = "this is some notes and quotes";
    int maxDayTasks = 5;
    int maxDayEvents = 5;
    WeekJson weekJson = new WeekJson(weekName, List.of(day), weekNotesQuotes, maxDayTasks,
        maxDayEvents);

    /*
    try {
      this.mapper.enable(SerializationFeature.INDENT_OUTPUT);
      String weekString = mapper.writeValueAsString(weekJson);
      String expectedCoord = "{" + System.lineSeparator() +
          "  \"weekName\" : \"Week 1\"," + System.lineSeparator() +
          "  \"days\" : [ {" + System.lineSeparator() +
          "    \"tasks\" : [ {" + System.lineSeparator() +
          "      \"taskName\" : \"task1\"," + System.lineSeparator() +
          "      \"taskDescription\" : \"description1\"," + System.lineSeparator() +
          "      \"day\" : \"FRIDAY\"," + System.lineSeparator() +
          "      \"complete\" : false" + System.lineSeparator() +
          "    }, {" + System.lineSeparator() +
          "      \"taskName\" : \"task2\"," + System.lineSeparator() +
          "      \"taskDescription\" : \"description2\"," + System.lineSeparator() +
          "      \"day\" : \"FRIDAY\"," + System.lineSeparator() +
          "      \"complete\" : false" + System.lineSeparator() +
          "    } ]," + System.lineSeparator() +
          "    \"events\" : [ {" + System.lineSeparator() +
          "      \"eventName\" : \"event1\",\n" +
          "      \"eventDescription\" : \"description1\"," + System.lineSeparator() +
          "      \"day\" : \"FRIDAY\"," + System.lineSeparator() +
          "      \"startTime\" : \"3 AM\"," + System.lineSeparator() +
          "      \"duration\" : \"4\"" + System.lineSeparator() +
          "    } ]" + System.lineSeparator() +
          "  } ]," + System.lineSeparator() +
          "  \"weekNotesQuotes\" : \"this is some notes and quotes\"," + System.lineSeparator() +
          "  \"maxDayTasks\" : 5," + System.lineSeparator() +
          "  \"maxDayEvents\" : 5" + System.lineSeparator() +
          "}";
      assertEquals(expectedCoord, weekString);
    } catch (Exception e) {
      e.printStackTrace();
    }
    */

    assertEquals(weekName, weekJson.weekName());


  }


}