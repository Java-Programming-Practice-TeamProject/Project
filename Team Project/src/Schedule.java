import java.time.LocalDateTime;

public class Schedule {
    private String name;
    private LocalDateTime start_time;
    private LocalDateTime end_time;
    private boolean isImportant;
    private boolean canBeOverlapped;    
    private String place;
    private String memo;

    /**
     * default constructor of class Schedule
     * start_time, end_time -> current time
     */
    public Schedule() {
        name = "";
        start_time = LocalDateTime.now();
        end_time = start_time;
        isImportant = false;
        canBeOverlapped = false;
        place = "";
        memo = "";
    }

    /**
     * Another constructor of class Schedule
     * @param n         name of Schedule
     * @param start     start time of Schedule
     * @param end       end time of Schedule
     * @param isImp     is important or not
     * @param overlap   can be overlapped or not
     * @param p         place of schedule
     * @param m         memo about schedule
     */
    public Schedule(String n, LocalDateTime start, LocalDateTime end, boolean isImp, boolean overlap, String p, String m) {
        name = n;
        start_time = start;
        end_time = end;
        isImportant = isImp;
        canBeOverlapped = overlap;
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
     * getter of start_time
     * @return start_time of calendar
     */
    public LocalDateTime getStartTime() {
        return start_time;
    }

    /**
     * getter of end_time
     * @return end_time of calendar
     */
    public LocalDateTime getEndTime() {
        return end_time;
    }

    /**
     * getter of isImportant
     * @return isImportant of calendar
     */
    public boolean getIsImportant() {
        return isImportant;
    }

    /**
     * getter of canBeOverlapped
     * @return canBeOverlapped of calendar
     */
    public boolean getCanBeOverlapped() {
        return canBeOverlapped;
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
     * @param overlap   can be overlapped or not
     * @param p     place of schedule
     * @param m     memo about schedule
     */
    public void modify_schedule(String n, LocalDateTime start, LocalDateTime end, boolean isImp, boolean overlap, String p, String m) {
        if (n != null) {
            name = n;
        }

        if (!start_time.equals(start)) {
            start_time = start;
        }
        if (!end_time.equals(end)) {
            end_time = end;
        }

        if (isImp != isImportant) {
            isImp = isImportant;
        }

        if (canBeOverlapped != overlap) {
            canBeOverlapped = overlap;          //불가능으로 바꿨을때 이미 겹쳐있는 일정은?
        }

        if (p != null) {
            place = p;
        }

        if (m != null) {
            memo = m;
        }
    }
}
