import java.util.ArrayList;
import java.util.Iterator;

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
    public void add_schedule(String name, int time[], boolean isImportant, String place, String memo) {
    	if(name == null) {
    		throw new NoNameEnteredException();
    	}
    	
    	if(time == null) {
    		throw new NoTimeEnteredException();
    	}

    	if((time[3]>time[5])||(time[3]==time[5])&&(time[4]>time[6])) {
    		throw new StartTimeAfterEndTimeException();
    	}
    	
    	for (Schedule s : schedules) {
    		if(name.equals(s.getName())) {
    			throw new AlreadyDefinedException();
    		}
    		if(time[0] == s.getTime()[0] && time[1] == s.getTime()[1] && time[2] == s.getTime()[2]) {
    			/* when start time is same */
    			if(time[3] == s.getTime()[3] && time[4] == s.getTime()[4])
    				throw new TimeAlreadyFullException();
    			/* when end time is same */
    			if(time[5] == s.getTime()[5] && time[6] == s.getTime()[6])
    				throw new TimeAlreadyFullException();
    			
    			Schedule faster,slower;
    			if(time[3]>s.getTime()[3]||(time[3]==s.getTime()[3]&&time[4]>s.getTime()[4])) {
    				faster = s;
    				slower = this;
    			}
    			else {
    				faster = this;
    				slower = s;
    			}
    			if(faster.getTime()[5]>slower.getTime()[3]||
    					((faster.getTime()[5]==slower.getTime()[3])&&(faster.getTime()[6]>slower.getTime()[4]))){
    				throw new TimeAlreadyFullException();
    			}
    		}
    	}
    	
    	Schedule s = new Schedule(name, time, isImportant, place, memo);
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
    public void modify_schedule(String name, String new_name,int time[], boolean isImportant, String place, String memo) {
    	if(name == null || new_name == null) {
    		throw new NoNameEnteredException();
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
    		if(time[0] == s.getTime()[0] && time[1] == s.getTime()[1] && time[2] == s.getTime()[2]) {
    			/* when start time is same */
    			if(time[3] == s.getTime()[3] && time[4] == s.getTime()[4])
    				throw new TimeAlreadyFullException();
    			/* when end time is same */
    			if(time[5] == s.getTime()[5] && time[6] == s.getTime()[6])
    				throw new TimeAlreadyFullException();
    			
    			Schedule faster,slower;
    			if(time[3]>s.getTime()[3]||(time[3]==s.getTime()[3]&&time[4]>s.getTime()[4])) {
    				faster = s;
    				slower = this;
    			}
    			else {
    				faster = this;
    				slower = s;
    			}
    			if(faster.getTime()[5]>slower.getTime()[3]||
    					((faster.getTime()[5]==slower.getTime()[3])&&(faster.getTime()[6]>slower.getTime()[4]))){
    				throw new TimeAlreadyFullException();
    			}
    		}
    	}
    	
    	if(flag==false) {
    		throw new NoNameMatchException();
    	}
    	
    	if(time!=null) {
    		if((time[3]>time[5])||(time[3]==time[5])&&(time[4]>time[6])) {
        		throw new StartTimeAfterEndTimeException();
        	}
    	}
    	
    	sch.modify_schedule(new_name, time, isImportant, place, memo);

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
