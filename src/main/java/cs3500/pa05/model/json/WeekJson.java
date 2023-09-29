package cs3500.pa05.model.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import cs3500.pa05.model.days.Day;
import java.util.List;

/**
 * JSON format of this record: Represents a week in json format.
 *
 * @param weekName        the name of the week
 * @param days            the list of days in the week
 * @param weekNotesQuotes the notes and quotes for the week
 */
public record WeekJson(

    @JsonProperty("weekName") String weekName,
    @JsonProperty("days") List<Day> days,
    @JsonProperty("weekNotesQuotes") String weekNotesQuotes,
    @JsonProperty("maxDayTasks") int maxDayTasks,
    @JsonProperty("maxDayEvents") int maxDayEvents) {
}
