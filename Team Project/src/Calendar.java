import java.util.ArrayList;

public class Calendar {
    private ArrayList<Schedule> schedule = new ArrayList<>();
    private String name;

    /**
     * Default constructor for class Calendar
     */
    public Calendar() {
        name = "";
    }

    /**
     * Another constructor for class Calendar
     * @param name  name of calendar 
     */
    public Calendar(String name) {
        this.name = name;
    }

    /**
     * getter of name
     * @return name of calendar
     */
    public String getName() {
        return name;
    }

    /**
     * setter of name
     * @param name  new name of calendar  
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * add new schedule
     * @param   all variables in class Schedule
     * @exception AlreadyDefinedException
     *      이미 같은 이름의 일정이 존재할 때
     * @exception NoNameEnteredException
     *      이름이 입력되지 않았을 때
     * @exception NoTimeEnteredException
     *      시간이 입력되지 않았을 때
     * @exception TimeAlreadyFullException
     *      이미 그 시간에 일정이 존재할 때
     * @exception StartTimeAfterEndTimeException
     *      시작 시간이 끝나는 시간보다 늦을 때
     */
    public void add() {}

    /**
     * delete schedule
     * @param name  name of calendar to delete
     * @exception NoNameEnteredException
     *      이름이 입력되지 않았을 때
     */
    public void remove(String name) {}

    /**
     * change details of schedule
     * @param   all variables in class Schedule
     * @exception TimeAlreadyFullException
     *      이미 그 시간에 일정이 존재할 때
     * @exception StartTimeAfterEndTimeException
     *      시작 시간이 끝나는 시간보다 늦을 때
     */
    public void modify() {}
}