import java.util.ArrayList;
import java.util.Iterator;
import java.time.LocalDateTime;

public class Calendar {
    private ArrayList<Schedule> schedules;
	private String name;

    /**
     * Default constructor for class Calendar
     */
    public Calendar() {
        name = "";
        schedules = new ArrayList<>();
    }

    /**
     * Another constructor for class Calendar
     * @param name  name of calendar 
     */
    public Calendar(String name) {
        this.name = name;
        schedules = new ArrayList<>();
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
	 * time[year, month, date, hour, minute]
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
    public void add_schedule(String name, int[] start, int[] end, boolean isImp, boolean overlap, String place, String memo, boolean isAllDay) {
		LocalDateTime start_time, end_time;
		
		if(name == null) {
    		throw new NoNameEnteredException();
    	}
    	
    	if(start == null || end == null) {
    		throw new NoTimeEnteredException();
		}
		
		if (isAllDay) {
			start_time = LocalDateTime.of(start[0], start[1], start[2], 0, 0, 0, 0);
			end_time = LocalDateTime.of(end[0], end[1], end[2], 23, 59, 59, 999999999);
		} 
		else {
			start_time = LocalDateTime.of(start[0], start[1], start[2], start[3], start[4], 0, 0);
			end_time = LocalDateTime.of(end[0], end[1], end[2], end[3], end[4], 59, 999999999);
		}

    	if(start_time.isAfter(end_time)) {
    		throw new StartTimeAfterEndTimeException();
    	}
    	
    	for (Schedule s : schedules) {
    		if(name.equals(s.getName())) {
    			throw new AlreadyDefinedException();
    		}
			
			if(start_time.equals(s.getStartTime()) || end_time.equals(s.getEndTime())) {
				throw new TimeAlreadyFullException();
			}

			if(s.getStartTime().isAfter(start_time)) {
				if(end_time.isAfter(s.getStartTime())) {
					throw new TimeAlreadyFullException();
				}
			}
			else {
				if(s.getEndTime().isAfter(start_time)) {
					throw new TimeAlreadyFullException();
				}
			}
    	}
    	
    	Schedule s = new Schedule(name, start_time, end_time, isImp, overlap, place, memo);
    	schedules.add(s);
    }

    /**
     * delete schedule
     * @param name  name of schedule to delete
     * @exception NoNameEnteredException
     *      이름이 입력되지 않았을 때
     * @exception NoNameMatchException
     *      입력된 이름을 가진 schedule이 없을 때
     */
    public void remove_schedule(String name) {
    	if(name == null) {
    		throw new NoNameEnteredException();
    	}
    	
    	Iterator<Schedule> iter = schedules.iterator();
        while(iter.hasNext()) {
        	Schedule s = iter.next();
            if (name.equals(s.getName())) {
                iter.remove();
                return;
            }
        }

        throw new NoNameMatchException();
    }

    /**
     * change details of schedule
     * @param   all variables in class Schedule & new name of schedule
     * @exception NoNameEnteredException
     *      이름이 입력되지 않았을 때
     * @exception AlreadyDefinedException
     *      이미 같은 이름의 일정이 존재할 때
     * @exception TimeAlreadyFullException
     *      이미 그 시간에 일정이 존재할 때
     * @exception StartTimeAfterEndTimeException
     *      시작 시간이 끝나는 시간보다 늦을 때
     * @exception NoNameMatchException
     *      입력된 이름을 가진 schedule이 없을 때
     */
    public void modify_schedule(String name, String new_name, int[] start, int[] end, boolean isImp, boolean overlap, String place, String memo, boolean isAllDay) {
		LocalDateTime start_time, end_time;
		
		if(name == null || new_name == null) {
    		throw new NoNameEnteredException();
		}
		
		if (isAllDay) {
			start_time = LocalDateTime.of(start[0], start[1], start[2], 0, 0, 0, 0);
			end_time = LocalDateTime.of(end[0], end[1], end[2], 23, 59, 59, 999999999);
		} 
		else {
			start_time = LocalDateTime.of(start[0], start[1], start[2], start[3], start[4], 0, 0);
			end_time = LocalDateTime.of(end[0], end[1], end[2], end[3], end[4], 59, 999999999);
		}

    	if(start_time.isAfter(end_time)) {
    		throw new StartTimeAfterEndTimeException();
    	}
    	
    	Schedule sch;
    	boolean flag = false;
    	for(Schedule s : schedules) {
    		if(name.equals(s.getName())) {
    			sch = s;
    			flag = true;
    		}
    		if(new_name.equals(s.getName())) {
    			throw new AlreadyDefinedException();
			}
			
    		if(start_time.equals(s.getStartTime()) || end_time.equals(s.getEndTime())) {
				throw new TimeAlreadyFullException();
			}

			if(s.getStartTime().isAfter(start_time)) {
				if(end_time.isAfter(s.getStartTime())) {
					throw new TimeAlreadyFullException();
				}
			}
			else {
				if(s.getEndTime().isAfter(start_time)) {
					throw new TimeAlreadyFullException();
				}
			}
    	}
    	
    	if(flag == false) {
    		throw new NoNameMatchException();
		}
    	
    	sch.modify_schedule(new_name, start_time, end_time, isImp, overlap, place, memo);
    }
}


class AlreadyDefinedException extends RuntimeException{
	AlreadyDefinedException(){
		super();
	}
	AlreadyDefinedException(String message){
		super(message);
	}
}
class NoNameEnteredException extends RuntimeException{
	NoNameEnteredException(){
		super();
	}
	NoNameEnteredException(String message){
		super(message);
	}
}
class NoTimeEnteredException extends RuntimeException{
	NoTimeEnteredException(){
		super();
	}
	NoTimeEnteredException(String message){
		super(message);
	}
}
class TimeAlreadyFullException extends RuntimeException{
	TimeAlreadyFullException(){
		super();
	}
	TimeAlreadyFullException(String message){
		super(message);
	}
}
class StartTimeAfterEndTimeException extends RuntimeException{
	StartTimeAfterEndTimeException(){
		super();
	}
	StartTimeAfterEndTimeException(String message){
		super(message);
	}
}
class NoNameMatchException extends RuntimeException{
	NoNameMatchException(){
		super();
	}
	NoNameMatchException(String message){
		super(message);
	}
}
