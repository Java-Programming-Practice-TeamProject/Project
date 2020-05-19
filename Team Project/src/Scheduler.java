import java.util.ArrayList;
import java.util.Iterator;

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
    public void add_calendar(String name) {
        if (name.length() == 0 || name == null) {
            throw new NoNameEnteredException();
        }

        for (Calendar c : calendars) {
            if (name.equals(c.getName())) {
                throw new AlreadyDefinedException();
            }
        }

        Calendar c = new Calendar(name);
        calendars.add(c);
    }

    /**
     * remove calendar
     * @param name  name of calendar to delete
     * @exception NoNameEnteredException
     *      이름이 입력되지 않았을 때
     * @exception NotCalendarNameException
     *      입력된 이름을 가진 calendar가 없을 때
     * @exception EmptyCalendarException
     *      calendar가 비어 있을 때
     */
    public void remove_calendar(String name) {
        if (name.length() == 0 || name == null) {
            throw new NoNameEnteredException();
        }

        if (calendars.isEmpty()) {
            throw new EmptyCalendarException();
        }

        Iterator<Calendar> iter = calendars.iterator();
        while(iter.hasNext()) {
            Calendar c = iter.next();
            if (name.equals(c.getName())) {
                iter.remove();
                return;
            }
        }

        throw new NotCalendarNameException();
    }

    /**
     * change name of calendar
     * @param old_name  old name of calendar
     * @param new_name  new name of calendar
     * @exception NotCalendarNameWithOldNameException
     *      old_name을 가진 calendar가 없을 때
     * @exception AlreadyDefinedWithNewNameException
     *      new_name과 같은 이름의 calendar가가 존재할 때
     * @exception NoNameEnteredException
     *      old_name이나 new_name이 입력되지 않았을 때
     * @exception EmptyCalendarException
     *      calendar가 비어 있을 때
     */
    public void modify_calendar(String old_name, String new_name) {
        if (old_name.length() == 0 || old_name == null || new_name.length() == 0 || new_name == null) {
            throw new NoNameEnteredException();
        }

        if (calendars.isEmpty()) {
            throw new EmptyCalendarException();
        }

        for (Calendar c : calendars) {
            if (new_name.equals(c.getName())) {
                throw new AlreadyDefinedWithNewNameException();
            }
        }

        for (Calendar c : calendars) {
            if (old_name.equals(c.getName())) {
                c.setName(new_name);
                return;
            }
        }

        throw new NotCalendarNameException();
    }
}

class AlreadyDefinedException extends RuntimeException {
    AlreadyDefinedException() {
        super();
    }
    AlreadyDefinedException(String message) {
        super(message);
    }
}

class NoNameEnteredException extends RuntimeException {
    NoNameEnteredException() {
        super();
    }
    NoNameEnteredException(String message) {
        super(message);
    }
}

class NotCalendarNameException extends RuntimeException {
    NotCalendarNameException() {
        super();
    }
    NotCalendarNameException(String message) {
        super(message);
    }
}

class NotCalendarNameWithOldNameException extends RuntimeException {
    NotCalendarNameWithOldNameException() {
        super();
    }
    NotCalendarNameWithOldNameException(String message) {
        super(message);
    }
}

class AlreadyDefinedWithNewNameException extends RuntimeException {
    AlreadyDefinedWithNewNameException() {
        super();
    }
    AlreadyDefinedWithNewNameException(String message) {
        super(message);
    }
}

class EmptyCalendarException extends RuntimeException {
    EmptyCalendarException() {
        super();
    }
    EmptyCalendarException(String message) {
        super(message);
    }
}