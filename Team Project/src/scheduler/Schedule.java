package scheduler;

import java.awt.Color;

public class Schedule {
    protected String name;
    protected boolean isImportant;
    protected String memo;
    protected Color color;
    /** 
     * 0. 諛섎났X
     * 1. 留ㅻ뀈 X�썡 Y�씪
     * 2. 留ㅼ썡 X�씪
     * 3. 留ㅼ＜ X�슂�씪
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
    public Schedule(String n, boolean isImp, String m, int repeat, Color c) {
        name = n;
        isImportant = isImp;
        memo = m;
        repeatType = repeat;
        color = c;
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
     * getter of color
     * @return color of calendar
     */
    public Color getcolor() {
        return color;
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
