public class Schedule {
    private String name;
    private int[] time = new int[5];    //year, month, date, start_time, end_time
    private boolean isImportant;        //true means important, and false means not important
    private int repeat;
    private String place;
    private String memo;

    /**
     * default constructor of class Schedule
     */
    public Schedule() {
        name = "";
        isImportant = false;
        repeat = 0;
        place = "";
        memo = "";
    }

    /**
     * Another constructor of class Schedule
     * @param name  name of Schedule
     * @param time  time of Schedule
     * @param isImportant   is important or not
     * @param repeat    repeat
     * @param place     place of schedule
     * @param memo      memo about schedule
     */
    public Schedule(String name, int[] time, boolean isImportant, int repeat, String place, String memo) {
        this.name = name;
        System.arraycopy(time, 0, this.time, 0, 5);
        this.isImportant = isImportant;
        this.repeat = repeat;
        this.place = place;
        this.memo = memo;
    }

    /**
     * getter of name
     * @return name of calendar
     */
    public String getName() {
        return name;
    }

    /**
     * getter of time
     * @return time of calendar
     */
    public int[] getTime() {
        return time;
    }

    /**
     * change value of each variable if it is not null
     * @param name  name of Schedule
     * @param time  time of Schedule
     * @param isImportant   is important or not
     * @param repeat    repeat
     * @param place     place of schedule
     * @param memo      memo about schedule
     */
    public void modify(String name, int[] time, boolean isImportant, int repeat, String place, String memo) {}
}