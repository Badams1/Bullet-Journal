package cs3500.pa05.model.days;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class DayEnumTest {


  @Test
  void getDay() {
    assertEquals("Monday", DayEnum.MONDAY.getDay());
    assertEquals("Tuesday", DayEnum.TUESDAY.getDay());
    assertEquals("Wednesday", DayEnum.WEDNESDAY.getDay());
    assertEquals("Thursday", DayEnum.THURSDAY.getDay());
    assertEquals("Friday", DayEnum.FRIDAY.getDay());
    assertEquals("Saturday", DayEnum.SATURDAY.getDay());
    assertEquals("Sunday", DayEnum.SUNDAY.getDay());
  }


  @Test
  void valueOf() {
    assertEquals(DayEnum.MONDAY, DayEnum.valueOf("MONDAY"));
    assertEquals(DayEnum.TUESDAY, DayEnum.valueOf("TUESDAY"));
    assertEquals(DayEnum.WEDNESDAY, DayEnum.valueOf("WEDNESDAY"));
    assertEquals(DayEnum.THURSDAY, DayEnum.valueOf("THURSDAY"));
    assertEquals(DayEnum.FRIDAY, DayEnum.valueOf("FRIDAY"));
    assertEquals(DayEnum.SATURDAY, DayEnum.valueOf("SATURDAY"));
    assertEquals(DayEnum.SUNDAY, DayEnum.valueOf("SUNDAY"));

  }
}