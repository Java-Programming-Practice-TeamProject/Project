import java.util.ArrayList;

public class Scheduler {
    private ArrayList<Calendar> calendar = new ArrayList<>();

    /**
     * make new calendar
     * @param name  name of new calendar  
     * @exception AlreadyDefinedException
     *      이미 같은 이름의 calendar가 존재할 때
     * @exception NoNameEnteredException
     *      이름이 입력되지 않았을 때
     */
    public void add(String name) {}

    /**
     * remove calendar
     * @param name  name of calendar to delete
     * @exception NoNameEnteredException
     *      이름이 입력되지 않았을 때
     */
    public void remove(String name) {}

    /**
     * change name of calendar
     * @param old_name  old name of calendar
     * @param new_name  new name of calendar
     */
    public void modify(String old_name, String new_name) {}
}