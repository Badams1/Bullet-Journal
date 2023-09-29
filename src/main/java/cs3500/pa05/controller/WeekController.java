package cs3500.pa05.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import cs3500.pa05.model.Week;
import cs3500.pa05.model.addable.Addable;
import cs3500.pa05.model.addable.Event;
import cs3500.pa05.model.addable.Task;
import cs3500.pa05.model.days.Day;
import cs3500.pa05.model.days.DayEnum;
import cs3500.pa05.model.json.WeekJson;
import cs3500.pa05.view.View;
import cs3500.pa05.view.WeekView;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.UnaryOperator;
import java.util.regex.Pattern;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.stage.FileChooser;
import javafx.stage.Popup;
import javafx.stage.Stage;


/**
 * Controller for the week cs3500.pa05.view.
 */
public class WeekController implements Controller {

  @FXML
  private TextArea quotesAndNotes; // the quotes and notes text field
  @FXML
  private TextField weekName; // the week name text field
  @FXML
  private Button newEvent; // the new event button
  @FXML
  private Button newWeek; // the new week button
  @FXML
  private Button newTask; // the new task button
  @FXML
  private Button saveFile; // the save file button
  @FXML
  private Button openFile; // the open file button
  @FXML
  private Button createEventButton; // the create event button
  @FXML
  private Button createTaskButton; // the create task button


  @FXML
  private ListView<Addable> sunListView; // the list view for Sunday
  @FXML
  private ListView<Addable> monListView; // the list view for Monday
  @FXML
  private ListView<Addable> tueListView; // the list view for Tuesday
  @FXML
  private ListView<Addable> wedListView; // the list view for Wednesday
  @FXML
  private ListView<Addable> thuListView; // the list view for Thursday
  @FXML
  private ListView<Addable> friListView; // the list view for Friday
  @FXML
  private ListView<Addable> satListView; // the list view for Saturday
  @FXML
  private ListView<Addable> taskQueue; // the list view for the task queue

  @FXML
  private TextField taskName; // the text field for the task name
  @FXML
  private TextArea taskDescription; // the text field for the task description
  @FXML
  private CheckBox taskCheckBox; // the check box for the task

  @FXML
  private TextField titleEvent;
  @FXML
  private TextArea eventDescriptionText;
  @FXML
  private TextField startTimeText;
  @FXML
  private TextField durationText;
  @FXML
  private Button saveEvent;

  @FXML
  private TextField eventName; // the text field for the event name
  @FXML
  private TextArea eventDescription; // the text field for the event description
  @FXML
  private TextField startTimeField; // the text field for the start time
  @FXML
  private TextField durationField; // the text field for the duration
  @FXML
  private Button exitButton; // the exit button
  @FXML
  private MenuButton dayOfWeekButton; // the menu button for the day of the week
  @FXML
  private MenuItem sundayItem;
  @FXML
  private MenuItem mondayItem;
  @FXML
  private MenuItem tuesdayItem;
  @FXML
  private MenuItem wednesdayItem;
  @FXML
  private MenuItem thursdayItem;
  @FXML
  private MenuItem fridayItem;
  @FXML
  private MenuItem saturdayItem;
  @FXML
  private MenuButton dayOfWeekButton2; // the menu button for the day of the week
  @FXML
  private MenuItem sundayItem2;
  @FXML
  private MenuItem mondayItem2;
  @FXML
  private MenuItem tuesdayItem2;
  @FXML
  private MenuItem wednesdayItem2;
  @FXML
  private MenuItem thursdayItem2;
  @FXML
  private MenuItem fridayItem2;
  @FXML
  private MenuItem saturdayItem2;
  @FXML
  private MenuButton dayOfWeekButton3; // the menu button for the day of the week
  @FXML
  private MenuItem sundayItem3;
  @FXML
  private MenuItem mondayItem3;
  @FXML
  private MenuItem tuesdayItem3;
  @FXML
  private MenuItem wednesdayItem3;
  @FXML
  private MenuItem thursdayItem3;
  @FXML
  private MenuItem fridayItem3;
  @FXML
  private MenuItem saturdayItem3;
  @FXML
  private MenuButton dayOfWeekButton4; // the menu button for the day of the week
  @FXML
  private MenuItem sundayItem4;
  @FXML
  private MenuItem mondayItem4;
  @FXML
  private MenuItem tuesdayItem4;
  @FXML
  private MenuItem wednesdayItem4;
  @FXML
  private MenuItem thursdayItem4;
  @FXML
  private MenuItem fridayItem4;
  @FXML
  private MenuItem saturdayItem4;
  @FXML
  private Button settings;
  @FXML
  private Button saveSettings;
  @FXML
  private Label maxLabelTasks;
  @FXML
  private Slider tasksSlider;
  @FXML
  private Label maxLabelEvents;
  @FXML
  private Slider eventsSlider;
  @FXML
  private Label errorLabel;
  @FXML
  private ProgressBar sunProgress;
  @FXML
  private ProgressBar monProgress;
  @FXML
  private ProgressBar tueProgress;
  @FXML
  private ProgressBar wedProgress;
  @FXML
  private ProgressBar thurProgress;
  @FXML
  private ProgressBar friProgress;
  @FXML
  private ProgressBar satProgress;

  @FXML
  private TextField titleTask;
  @FXML
  private TextArea taskDescriptionText;
  @FXML
  private CheckBox taskCheckBox2;
  @FXML
  private Button saveTask;

  @FXML
  private Label sunProgText;
  @FXML
  private Label monProgText;
  @FXML
  private Label tueProgText;
  @FXML
  private Label wedProgText;
  @FXML
  private Label thuProgText;
  @FXML
  private Label friProgText;
  @FXML
  private Label satProgText;

  private double numTasksCompleteMon;
  private double numTasksCompleteTue;
  private double numTasksCompleteWed;
  private double numTasksCompleteThu;
  private double numTasksCompleteFri;
  private double numTasksCompleteSat;
  private double numTasksCompleteSun;

  private int maxTasks;
  private int maxEvents;
  private Map<String, Double> taskDayMap;
  private Map<String, Double> eventDayMap;

  private final Stage stage;

  private Week week;
  private Day sunday;
  private Day monday;
  private Day tuesday;
  private Day wednesday;
  private Day thursday;
  private Day friday;
  private Day saturday;
  private boolean loadingPrev;
  private File fileToLoad;

  private static final Pattern LINK_PATTERN =
      Pattern.compile("((http|https)://)?[a-zA-Z0-9]+(\\.[a-zA-Z]+)+(/[a-zA-Z0-9]*)*");

  @FXML
  private ToggleButton weekStartToggle;

  /**
   * Constructor for initializing the week controller for a previous week.
   *
   * @param stage the stage
   * @param file  the file chosen
   */
  public WeekController(Stage stage, File file, boolean loadingPrev) {
    this.loadingPrev = loadingPrev;
    this.fileToLoad = file;
    this.stage = stage;
    this.maxEvents = 20;
    this.maxTasks = 20;
    this.week = new Week();


    this.taskDayMap = new HashMap<>();
    taskDayMap.put("SUNDAY", 0.0);
    taskDayMap.put("MONDAY", 0.0);
    taskDayMap.put("TUESDAY", 0.0);
    taskDayMap.put("WEDNESDAY", 0.0);
    taskDayMap.put("THURSDAY", 0.0);
    taskDayMap.put("FRIDAY", 0.0);
    taskDayMap.put("SATURDAY", 0.0);

    this.eventDayMap = new HashMap<>();
    eventDayMap.put("SUNDAY", 0.0);
    eventDayMap.put("MONDAY", 0.0);
    eventDayMap.put("TUESDAY", 0.0);
    eventDayMap.put("WEDNESDAY", 0.0);
    eventDayMap.put("THURSDAY", 0.0);
    eventDayMap.put("FRIDAY", 0.0);
    eventDayMap.put("SATURDAY", 0.0);

    this.numTasksCompleteMon = 0.0;
    this.numTasksCompleteTue = 0.0;
    this.numTasksCompleteWed = 0.0;
    this.numTasksCompleteThu = 0.0;
    this.numTasksCompleteFri = 0.0;
    this.numTasksCompleteSat = 0.0;
    this.numTasksCompleteSun = 0.0;
  }

  /**
   * Constructor for initializing the week controller for a new week.
   *
   * @param stage the stage
   */
  public WeekController(Stage stage) {
    this.loadingPrev = false;
    this.stage = stage;
    this.maxEvents = 20;
    this.maxTasks = 20;
    this.week = new Week();
    initializeNewWeek();

    this.taskDayMap = new HashMap<>();
    taskDayMap.put("SUNDAY", 0.0);
    taskDayMap.put("MONDAY", 0.0);
    taskDayMap.put("TUESDAY", 0.0);
    taskDayMap.put("WEDNESDAY", 0.0);
    taskDayMap.put("THURSDAY", 0.0);
    taskDayMap.put("FRIDAY", 0.0);
    taskDayMap.put("SATURDAY", 0.0);

    this.eventDayMap = new HashMap<>();
    eventDayMap.put("SUNDAY", 0.0);
    eventDayMap.put("MONDAY", 0.0);
    eventDayMap.put("TUESDAY", 0.0);
    eventDayMap.put("WEDNESDAY", 0.0);
    eventDayMap.put("THURSDAY", 0.0);
    eventDayMap.put("FRIDAY", 0.0);
    eventDayMap.put("SATURDAY", 0.0);

    this.numTasksCompleteMon = 0.0;
    this.numTasksCompleteTue = 0.0;
    this.numTasksCompleteWed = 0.0;
    this.numTasksCompleteThu = 0.0;
    this.numTasksCompleteFri = 0.0;
    this.numTasksCompleteSat = 0.0;
    this.numTasksCompleteSun = 0.0;
  }


  /**
   * runs the WeekController and displays it to the user
   *
   * @throws IllegalStateException if state is illegal
   * @throws IOException           if wrong IO
   */
  @Override
  public void run() throws IllegalStateException, IOException {
    if (loadingPrev) {
      initializePrevWeek(this.fileToLoad);
    }
    initNewWeekButton();
    initSaveFile();
    initOpen();
    popupInitTask();
    popupInitEvent();
    popupInitSettings();
    initListViews();
    initLink();
    initKeyBoardShortCuts();
  }

  private void initNewWeekButton() {
    // make the newWeek button have this event handler
    newWeek.setOnAction(event -> {
      // create a new week
      newWeek();
    });
  }

  private void newWeek() {
    Controller weekController = new WeekController(this.stage);
    View weekView = new WeekView(weekController);

    try {
      // load and place the view's scene onto the stage
      this.stage.setScene(weekView.load());

      // fetch the view's controller
      weekController.run();
      // render the stage
      this.stage.show();
    } catch (IllegalStateException | IOException e) {
      System.err.println("Unable to load GUI.");
    }

  }

  private void initLink() {
    UnaryOperator<TextFormatter.Change> linkFilter = change -> {
      String newText = change.getControlNewText();
      if (LINK_PATTERN.matcher(newText).matches()) {
        System.out.println("FOUND" + newText);

        change.setRange(change.getRangeStart(), change.getRangeEnd());
        change.setText(newText);
        change.setAnchor(change.getRangeEnd());
        change.setCaretPosition(change.getRangeEnd());
        Hyperlink hyperlink = createHyperlink(newText);
        change.getControl().setUserData(hyperlink.getUserData());
      }
      return change;
    };
    TextFormatter formatter = new TextFormatter(linkFilter);

    taskDescription.setTextFormatter(formatter);
    eventDescription.setTextFormatter(formatter);
  }

  private Hyperlink createHyperlink(String linkText) {
    Hyperlink hyperlink = new Hyperlink(linkText);
    hyperlink.setOnAction(event -> {
      handleLinkClick(hyperlink.getText());
    });
    hyperlink.setUserData(hyperlink.getText());
    return hyperlink;
  }


  /**
   * initializes the list Views based on their given fields
   */
  private void initListViews() {
    setListViews(monListView);
    setListViews(thuListView);
    setListViews(wedListView);
    setListViews(tueListView);
    setListViews(friListView);
    setListViews(satListView);
    setListViews(sunListView);
  }

  /**
   * sets the List Views
   *
   * @param listView a view of lists
   */
  private void setListViews(ListView<Addable> listView) {
    listView.setOnMouseClicked(event -> {
      if (event.getClickCount() == 2 && !listView.getSelectionModel().isEmpty()) {
        Addable selectedItem = listView.getSelectionModel().getSelectedItem();
        if (selectedItem instanceof Task) {
          try {
            showTaskMiniviewer((Task) selectedItem);
          } catch (IOException e) {
            throw new RuntimeException(e);
          }
        } else {
          try {
            showEventMiniviewer((Event) selectedItem);
          } catch (IOException e) {
            throw new RuntimeException(e);
          }
        }
      }
    });
  }

  /**
   * shows the miniviewer for a selected event
   *
   * @param selectedItem a event
   * @throws IOException if the IO is not accepted
   */
  private void showEventMiniviewer(Event selectedItem) throws IOException {
    Popup popup = new Popup();
    FXMLLoader loader = new FXMLLoader(getClass().getClassLoader()
        .getResource("EventPopup.fxml"));
    loader.setController(this);
    Scene s = loader.load();
    popup.getContent().add(s.getRoot());
    saveEvent.setOnAction(e -> saveEvent(popup, selectedItem));
    initPopHelper(popup, mondayItem4, dayOfWeekButton4, tuesdayItem4, wednesdayItem4, thursdayItem4,
        fridayItem4, saturdayItem4, sundayItem4);

    titleEvent.setText(selectedItem.getEventName());
    eventDescriptionText.setText(selectedItem.getEventDescription());
    startTimeText.setText(selectedItem.getStartTime());
    durationText.setText(selectedItem.getDuration());
    makePopup(popup);
  }

  /**
   * shows the miniviewer for a selected task
   *
   * @param selectedItem a task
   * @throws IOException if the IO is not accepted
   */
  private void showTaskMiniviewer(Task selectedItem) throws IOException {
    Popup popup = new Popup();
    FXMLLoader loader = new FXMLLoader(getClass().getClassLoader()
        .getResource("TaskPopup.fxml"));
    loader.setController(this);
    Scene s = loader.load();
    popup.getContent().add(s.getRoot());
    saveTask.setOnAction(e -> saveTasks(popup, selectedItem));
    initPopHelper(popup, mondayItem3, dayOfWeekButton3, tuesdayItem3, wednesdayItem3, thursdayItem3,
        fridayItem3, saturdayItem3, sundayItem3);

    titleTask.setText(selectedItem.getTaskName());
    taskDescriptionText.setText(selectedItem.getTaskDescription());
    taskCheckBox2.setSelected(selectedItem.isComplete());
    makePopup(popup);
  }

  /**
   * saves the file when the save button is pressed
   */
  private void initSaveFile() {
    saveFile.setOnAction(e -> {
      save();
    });
  }

  private void initOpen() {
    openFile.setOnAction(e -> {
      open();
    });
  }

  private void open() {
    FileChooser fileChooser = new FileChooser();
    fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
    FileChooser.ExtensionFilter extensionFilter =
        new FileChooser.ExtensionFilter("Bujo Files (*.bujo)", "*.bujo");
    fileChooser.getExtensionFilters().add(extensionFilter);
    File selectedFile = fileChooser.showOpenDialog(stage);

    if (selectedFile.length() != 0) {
      Controller weekController = new WeekController(this.stage, selectedFile, true);
      View weekView = new WeekView(weekController);

      try {
        this.stage.setScene(weekView.load());
        weekController.run();
        this.stage.show();
      } catch (IllegalStateException | IOException e) {
        System.err.println("Unable to load GUI.");
      }
    } else {
      Alert alert = new Alert(Alert.AlertType.ERROR);
      alert.setTitle("Error");
      alert.setHeaderText("Invalid File");
      alert.setContentText("The file you selected is invalid. Please select a valid file.");
      alert.showAndWait();
    }
  }

  /**
   * saves the file by serializing the planner data as a weekJson
   */
  private void save() {
    week.setWeekNotesQuotes(quotesAndNotes.getText());
    week.setWeekName(weekName.getText());
    var writer = new ObjectMapper();
    try {
      writer.enable(SerializationFeature.INDENT_OUTPUT);
      if (!weekName.getText().isEmpty()) {
        String stringWithoutSpaces = weekName.getText().replaceAll("\\s", "");
        writer.writeValue(new File(stringWithoutSpaces + ".bujo"), week);
        saveAlert();
      } else {
        writer.writeValue(new File("Week.bujo"), week);
        saveAlert();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  @FXML
  private void saveAlert() {
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("File Saved");
    alert.setHeaderText("File Saved");
    alert.setContentText("The file was saved successfully!");
    alert.showAndWait();
  }

  /**
   * Initializes the new week.
   */
  @FXML
  public void initializeNewWeek() {
    this.saturday = new Day(DayEnum.SATURDAY);
    this.sunday = new Day(DayEnum.SUNDAY);
    this.monday = new Day(DayEnum.MONDAY);
    this.tuesday = new Day(DayEnum.TUESDAY);
    this.wednesday = new Day(DayEnum.WEDNESDAY);
    this.thursday = new Day(DayEnum.THURSDAY);
    this.friday = new Day(DayEnum.FRIDAY);
    List<Day> days = new ArrayList<>();
    days.add(sunday);
    days.add(monday);
    days.add(tuesday);
    days.add(wednesday);
    days.add(thursday);
    days.add(friday);
    days.add(saturday);
    this.week.setDays(days);
  }

  /**
   * Initializes the previous week.
   *
   * @param inputFile the file name to initialize from
   */
  @FXML
  public void initializePrevWeek(File inputFile) {
    var reader = new ObjectMapper();
    try {
      WeekJson weekJson = reader.readValue(inputFile, WeekJson.class);
      System.out.println(weekJson);
      this.sunday = weekJson.days().get(0);
      this.monday = weekJson.days().get(1);
      this.tuesday = weekJson.days().get(2);
      this.wednesday = weekJson.days().get(3);
      this.thursday = weekJson.days().get(4);
      this.friday = weekJson.days().get(5);
      this.saturday = weekJson.days().get(6);

      loadPrevListViews();
      loadPrevNotes();
      loadPrevWeekName();
      loadPrevTaskQueue();


    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  private void loadPrevListViews() {
    this.monListView.getItems().addAll(monday.getTasks());
    this.monListView.getItems().addAll(monday.getEvents());
    this.tueListView.getItems().addAll(tuesday.getTasks());
    this.tueListView.getItems().addAll(tuesday.getEvents());
    this.wedListView.getItems().addAll(wednesday.getTasks());
    this.wedListView.getItems().addAll(wednesday.getEvents());
    this.thuListView.getItems().addAll(thursday.getTasks());
    this.thuListView.getItems().addAll(thursday.getEvents());
    this.friListView.getItems().addAll(friday.getTasks());
    this.friListView.getItems().addAll(friday.getEvents());
    this.satListView.getItems().addAll(saturday.getTasks());
    this.satListView.getItems().addAll(saturday.getEvents());
    this.sunListView.getItems().addAll(sunday.getTasks());
    this.sunListView.getItems().addAll(sunday.getEvents());
  }

  private void loadPrevWeekName() {
    this.week.setWeekName(week.getWeekName());
    this.weekName.setText(week.getWeekName());

  }

  private void loadPrevTaskQueue() {
    this.taskQueue.getItems().addAll(monday.getTasks());
    this.taskQueue.getItems().addAll(tuesday.getTasks());
    this.taskQueue.getItems().addAll(wednesday.getTasks());
    this.taskQueue.getItems().addAll(thursday.getTasks());
    this.taskQueue.getItems().addAll(friday.getTasks());
    this.taskQueue.getItems().addAll(saturday.getTasks());
    this.taskQueue.getItems().addAll(sunday.getTasks());

  }

  private void loadPrevNotes() {

    this.quotesAndNotes.setText(week.getWeekNotesQuotes());
  }

  /**
   * initializes the settings for a popup
   *
   * @throws IOException if the IO is wrong
   */
  private void popupInitSettings() throws IOException {
    Popup popup = new Popup();
    settings.setOnAction(e -> makePopup(popup));
    FXMLLoader loader =
        new FXMLLoader(getClass().getClassLoader().getResource("SettingsPopup.fxml"));
    loader.setController(this);
    Scene s = loader.load();
    popup.getContent().add(s.getRoot());
    saveSettings.setOnAction(e -> saveSettings());
    exitButton.setOnAction(e -> exitPopup(popup));
  }


  /**
   * saves the settings
   */
  private void saveSettings() {
    int maxValueTasks = (int) tasksSlider.getValue();
    maxLabelTasks.setText("Maximum: " + maxValueTasks);
    this.maxTasks = maxValueTasks;
    week.setMaxDayTasks(maxValueTasks);

    int maxValueEvents = (int) eventsSlider.getValue();
    maxLabelEvents.setText("Maximum: " + maxValueEvents);
    this.maxEvents = maxValueEvents;
    week.setMaxDayEvents(maxValueEvents);
  }

  /**
   * initializes the buttons text to the day of week selected
   *
   * @param item   a MenuItem
   * @param button the selected button
   */
  private void dayOfWeekInit(MenuItem item, MenuButton button) {
    button.setText(item.getText());
  }

  /**
   * initializes an event popup
   *
   * @throws IOException if theres an exception
   */
  @FXML
  private void popupInitEvent() throws IOException {
    Popup popup = new Popup();
    newEvent.setOnAction(e -> makePopup(popup));
    FXMLLoader loader =
        new FXMLLoader(getClass().getClassLoader().getResource("EventCreationPopup.fxml"));
    loader.setController(this);
    Scene s = loader.load();
    popup.getContent().add(s.getRoot());
    createEventButton.setOnAction(e -> {
      try {
        createNewEvent(popup);
      } catch (IOException ex) {
        throw new RuntimeException(ex);
      }
    });
    initPopHelper(popup, mondayItem, dayOfWeekButton, tuesdayItem, wednesdayItem, thursdayItem,
        fridayItem, saturdayItem, sundayItem);
  }

  /**
   * initializes a task popup
   *
   * @throws IOException ...
   */
  @FXML
  private void popupInitTask() throws IOException {
    Popup popup = new Popup();
    newTask.setOnAction(e -> makePopup(popup));
    FXMLLoader loader =
        new FXMLLoader(getClass().getClassLoader().getResource("TaskCreationPopup.fxml"));
    loader.setController(this);
    Scene s = loader.load();
    popup.getContent().add(s.getRoot());
    createTaskButton.setOnAction(e -> {
      try {
        createNewTask(popup);
      } catch (IOException ex) {
        throw new RuntimeException(ex);
      }
    });
    initPopHelper(popup, mondayItem2, dayOfWeekButton2, tuesdayItem2, wednesdayItem2, thursdayItem2,
        fridayItem2, saturdayItem2, sundayItem2);
  }

  /**
   * saves the tasks and hides the task poput
   *
   * @param popup the task popup
   */
  @FXML
  private void saveTasks(Popup popup, Task task) {
    task.setTaskName(titleTask.getText());
    task.setTaskDescription(taskDescriptionText.getText());
    task.setComplete(taskCheckBox2.isSelected());
    task.setDay(DayEnum.valueOf(dayOfWeekButton3.getText()));

    popup.hide();
  }

  @FXML
  private void saveEvent(Popup popup, Event event) {
    event.setEventName(titleEvent.getText());
    event.setEventDescription(eventDescriptionText.getText());
    event.setDay(DayEnum.valueOf(dayOfWeekButton4.getText()));
    event.setStartTime(startTimeText.getText());
    event.setDuration(durationText.getText());

    popup.hide();
  }


  /**
   * Helps initialize the action handlers for the popup.
   *
   * @param popup2     the popup
   * @param item       the menu item
   * @param menuButton the menu button
   * @param item2      the menu item
   * @param item3      the menu item
   * @param item4      the menu item
   * @param item5      the menu item
   * @param item6      the menu item
   * @param item7      the menu item
   */
  private void initPopHelper(Popup popup2, MenuItem item, MenuButton menuButton,
                             MenuItem item2, MenuItem item3,
                             MenuItem item4, MenuItem item5, MenuItem item6,
                             MenuItem item7) {
    exitButton.setOnAction(e -> exitPopup(popup2));

    item.setOnAction(e -> dayOfWeekInit(item, menuButton));
    item2.setOnAction(e -> dayOfWeekInit(item2, menuButton));
    item3.setOnAction(e -> dayOfWeekInit(item3, menuButton));
    item4.setOnAction(e -> dayOfWeekInit(item4, menuButton));
    item5.setOnAction(e -> dayOfWeekInit(item5, menuButton));
    item6.setOnAction(e -> dayOfWeekInit(item6, menuButton));
    item7.setOnAction(e -> dayOfWeekInit(item7, menuButton));
  }

  /**
   * shows the given popup on the stage
   *
   * @param popup the given popup
   */
  @FXML
  private void makePopup(Popup popup) {
    popup.show(this.stage);
  }

  @FXML
  private void createNewEvent(Popup popup) throws IOException {

    DayEnum selectedDay = DayEnum.valueOf(dayOfWeekButton.getText());


    if (eventDayMap.get(selectedDay.toString()) > maxEvents) {
      showErrorPopup("events", maxEvents, selectedDay);
    } else {
      Addable event = new Event();

      switch (selectedDay) {
        case SUNDAY -> addToDay(event, true, false, sunListView, "SUNDAY",
            sunday, numTasksCompleteSun, sunProgress, sunProgText);
        case MONDAY -> addToDay(event, true, false, monListView, "MONDAY",
            monday, numTasksCompleteMon, monProgress, monProgText);
        case TUESDAY -> addToDay(event, true, false, tueListView, "TUESDAY",
            tuesday, numTasksCompleteTue, tueProgress, tueProgText);
        case WEDNESDAY -> addToDay(event, true, false, wedListView, "WEDNESDAY",
            wednesday, numTasksCompleteWed, wedProgress, wedProgText);
        case THURSDAY -> addToDay(event, true, false, thuListView, "THURSDAY",
            thursday, numTasksCompleteThu, thurProgress, thuProgText);
        case FRIDAY -> addToDay(event, true, false, friListView, "FRIDAY",
            friday, numTasksCompleteFri, friProgress, friProgText);
        case SATURDAY -> addToDay(event, true, false, satListView, "SATURDAY",
            saturday, numTasksCompleteSat, satProgress, satProgText);
        default -> System.err.println("Error: Day of the week not found");
      }
      popup.hide();
    }

  }

  /**
   * shows an error popup
   *
   * @param type type of error
   * @param max  max number of events allowed in a day
   * @param day  the given day
   * @throws IOException throws IOException
   */
  @FXML
  public void showErrorPopup(String type, int max, DayEnum day) throws IOException {
    Popup popup = new Popup();
    FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("ErrorPopup.fxml"));
    loader.setController(this);
    Scene s = loader.load();
    popup.getContent().add(s.getRoot());
    errorLabel.setText("Oops! You have exceeded " + max + " " + type + " for " + day.getDay());
    exitButton.setOnAction(e -> exitPopup(popup));

    makePopup(popup);
  }

  //todo implement warning for unfilled fields
  @FXML
  private void createNewTask(Popup popup) throws IOException {

    DayEnum selectedDay = DayEnum.valueOf(dayOfWeekButton2.getText());
    if (taskDayMap.get(selectedDay.toString()) > maxTasks) {
      showErrorPopup("tasks", maxTasks, selectedDay);
    } else {
      Addable task = new Task();
      switch (selectedDay) {
        case SUNDAY -> addToDay(task, false, taskCheckBox.isSelected(), sunListView, "SUNDAY",
            sunday, numTasksCompleteSun, sunProgress, sunProgText);
        case MONDAY -> addToDay(task, false, taskCheckBox.isSelected(), monListView, "MONDAY",
            monday, numTasksCompleteMon, monProgress, monProgText);
        case TUESDAY -> addToDay(task, false, taskCheckBox.isSelected(), tueListView, "TUESDAY",
            tuesday, numTasksCompleteTue, tueProgress, tueProgText);
        case WEDNESDAY -> addToDay(task, false, taskCheckBox.isSelected(), wedListView, "WEDNESDAY",
            wednesday, numTasksCompleteWed, wedProgress, wedProgText);
        case THURSDAY -> addToDay(task, false, taskCheckBox.isSelected(), thuListView, "THURSDAY",
            thursday, numTasksCompleteThu, thurProgress, thuProgText);
        case FRIDAY -> addToDay(task, false, taskCheckBox.isSelected(), friListView, "FRIDAY",
            friday, numTasksCompleteFri, friProgress, friProgText);
        case SATURDAY -> addToDay(task, false, taskCheckBox.isSelected(), satListView, "SATURDAY",
            saturday, numTasksCompleteSat, satProgress, satProgText);
        default -> System.err.println("Error: Day of the week not found");
      }
      popup.hide();

    }

  }

  /**
   * exits the given popup
   *
   * @param popup the given popup
   */
  @FXML
  private void exitPopup(Popup popup) {
    popup.hide();
  }

  /**
   * adds a task or event to a day
   *
   * @param objectToAdd a task or event
   * @param isEvent     true = event, false = task
   * @param isSelected  seleceted if user clicks it
   * @param listView    the listView which contains it
   * @param dayString   the Day of week for the object
   * @param day         the dy
   * @param numTasks    the numTasks on that day
   * @param progressBar the progressBar for that day
   */
  @FXML
  private void addToDay(Addable objectToAdd, boolean isEvent, boolean isSelected,
                        ListView<Addable> listView,
                        String dayString, Day day, double numTasks, ProgressBar progressBar,
                        Label dayProgText) {
    if (isEvent) {
      ((Event) objectToAdd).setEventName(eventName.getText());
      ((Event) objectToAdd).setEventDescription(eventDescription.getText());
      ((Event) objectToAdd).setStartTime(startTimeField.getText());
      ((Event) objectToAdd).setDuration(durationField.getText());
      listView.getItems().add(objectToAdd);
      eventDayMap.put(dayString, eventDayMap.get(dayString) + 1);
      day.addEvent((Event) objectToAdd);
    } else {
      if (isSelected) {
        numTasks++;
        ((Task) objectToAdd).setComplete(true);
      }
      ((Task) objectToAdd).setTaskName(taskName.getText());
      ((Task) objectToAdd).setTaskDescription(taskDescription.getText());
      listView.getItems().add(objectToAdd);
      taskQueue.getItems().add(objectToAdd);
      taskDayMap.put(dayString, taskDayMap.get(dayString) + 1);
      progressBar.setProgress(numTasks / taskDayMap.get(dayString));
      day.addTask((Task) objectToAdd);
      dayProgText.setText(numTasks + "/" + taskDayMap.get(dayString) + " tasks complete");
    }
  }

  @FXML
  private void handleLinkClick(String link) {
    try {
      URI uri = new URI(link);
      Desktop.getDesktop().browse(uri);
    } catch (IOException | URISyntaxException e) {
      Alert alert = new Alert(Alert.AlertType.ERROR);
      alert.setTitle("Error");
      alert.setHeaderText("Failed to open link");
      alert.setContentText("An error occurred while opening the link in a web browser.");
      alert.showAndWait();
    }
  }

  private void initKeyBoardShortCuts() {
    KeyCodeCombination saveShortcut =
        new KeyCodeCombination(KeyCode.S, KeyCombination.SHORTCUT_DOWN);
    saveFile.setOnKeyPressed(event -> {
      if (saveShortcut.match(event)) {
        save();
      }
    });
    KeyCodeCombination openShortcut =
        new KeyCodeCombination(KeyCode.S, KeyCombination.SHORTCUT_DOWN);
    openFile.setOnKeyPressed(event -> {
      if (saveShortcut.match(event)) {
        open();
      }
    });
    KeyCodeCombination newEventShortcut =
        new KeyCodeCombination(KeyCode.S, KeyCombination.SHORTCUT_DOWN);
    newEvent.setOnKeyPressed(event -> {
      if (saveShortcut.match(event)) {
        Popup popup = new Popup();
        try {
          createNewEvent(popup);
        } catch (IOException e) {
          throw new RuntimeException(e);
        }
      }
    });
    KeyCodeCombination newTaskShortCut =
        new KeyCodeCombination(KeyCode.S, KeyCombination.SHORTCUT_DOWN);
    newTask.setOnKeyPressed(event -> {
      if (saveShortcut.match(event)) {
        Popup popup = new Popup();
        try {
          createNewTask(popup);
        } catch (IOException e) {
          throw new RuntimeException(e);
        }
      }
    });
  }

}
