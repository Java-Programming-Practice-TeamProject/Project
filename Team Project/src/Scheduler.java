import java.util.ArrayList;

public class Scheduler {
    private ArrayList<Calendar> calendars = new ArrayList<>();

    /**
     * make new calendar
     * @param name  name of new calendar  
     * @exception AlreadyDefinedException
     *      이미 같은 이름의 calendar가 존재할 때
     * @exception NoNameEnteredException
     *      이름이 입력되지 않았을 때
     */
    public void add_calendar(String name) {}

    /**
     * remove calendar
     * @param name  name of calendar to delete
     * @exception NoNameEnteredException
     *      이름이 입력되지 않았을 때
     * @exception NoNameMatchException
     *      입력된 이름을 가진 calendar가 없을 때
     */
    public void remove_calendar(String name) {}

    /**
     * change name of calendar
     * @param old_name  old name of calendar
     * @param new_name  new name of calendar
     * @exception NoNameMatchException
     *      old_name을 가진 calendar가 없을 때
     * @exception AlreadyDefinedWithNewNameException
     *      new_name과 같은 이름의 calendar가가 존재할 때
     * @exception NoNameEnteredException
     *      이름이 입력되지 않았을 때
     */
    public void modify_calendar(String old_name, String new_name) {}
}
