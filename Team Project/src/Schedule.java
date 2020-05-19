public class Schedule {
    private String name;
    private int[] time = new int[7];    //year, month, date, start_hour, start_min, end_hour, end_min
    private boolean isImportant;        //true means important, and false means not important
    private String place;
    private String memo;

    /**
     * default constructor of class Schedule
     */
    public Schedule() {
        name = "";
        isImportant = false;
        place = "";
        memo = "";
    }

    /**
     * Another constructor of class Schedule
     * @param n     name of Schedule
     * @param t     time of Schedule
     * @param isImp is important or not
     * @param p     place of schedule
     * @param m     memo about schedule
     */
    public Schedule(String n, int[] t, boolean isIm, String p, String m) {
        name = n;
        System.arraycopy(t, 0, time, 0, 7);
        isImportant = isIm;
        place = p;
        memo = m;
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
     * getter of isImportant
     * @return isImportant of calendar
     */
    public boolean getIsImportant() {
        return isImportant;
    }

    /**
     * getter of place
     * @return place of calendar
     */
    public String getPlace() {
        return place;
    }

    /**
     * getter of memo
     * @return memo of calendar
     */
    public String getMemo() {
        return memo;
    }

    /**
     * change value of each variable if it is not null
     * @param n     name of Schedule
     * @param t     time of Schedule
     * @param isImp is important or not
     * @param p     place of schedule
     * @param m     memo about schedule
     */
    public void modify_chedule(String n, int[] t, boolean isImp, String p, String m) {
        if (n != null) {
            name = n;
        }
        if (t[0] != 0) {
            System.arraycopy(t, 0, time, 0, 7);
        }
        if (isImp != isImportant) {
            isImp = isImportant;
        }
        if (p != null) {
            place = p;
        }
        if (m != null) {
            memo = m;
        }
    }
}
