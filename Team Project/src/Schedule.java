public class Schedule {
    protected String name;
    protected boolean isImportant;
    protected String memo;
    /** 
     * 0. 반복X
     * 1. 매년 X월 Y일
     * 2. 매월 X일
     * 3. 매주 X요일
    */
    protected int repeatType;             

    /**
     * default constructor of class Schedule
     */
    public Schedule() {
        name = "";
        isImportant = false;
        memo = "";
        repeatType = 0;
    }

    /**
     * Another constructor of class Schedule
     * @param n         name of schedule
     * @param isImp     is important or not
     * @param m         memo about schedule
     * @param repeat    repeat type
     */
    public Schedule(String n, boolean isImp, String m, int repeat) {
        name = n;
        isImportant = isImp;
        memo = m;
        repeatType = repeat;
    }

    /**
     * getter of name
     * @return name of calendar
     */
    public String getName() {
        return name;
    }

    /**
     * getter of isImportant
     * @return isImportant of calendar
     */
    public boolean getIsImportant() {
        return isImportant;
    }

    /**
     * getter of memo
     * @return memo of calendar
     */
    public String getMemo() {
        return memo;
    }

    /**
     * getter of repeatType
     * @return repeatType of calendar
     */
    public int getRepeatType() {
        return repeatType;
    }

    /**
     * change value of each variable if it is not null
     * @param n         name of schedule
     * @param isImp     is important or not
     * @param m         memo about schedule
     * @param repeat    repeat type
     */
    public void modify_schedule(String n, boolean isImp, String m, int repeat) {
        name = n;
        isImportant = isImp;
        memo = m;
        repeatType = repeat;
    }
}
