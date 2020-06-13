package scheduler;

import exception.*;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;

public class Scheduler {
    private ArrayList<Calendar> calendars;

    public Scheduler() {
        calendars = new ArrayList<>();
        calendars.add(new Calendar("default",Color.LIGHT_GRAY));
    }
    
    /**
     * get names of calendar
     * @return name	names of calendar
     */
    public String[] get_name() {
    	ArrayList<String> name = new ArrayList<>();
    	for (Calendar c : calendars) {
    		name.add(c.getName());
    	}
    	return name.toArray(new String[name.size()]);
    }
    
    /**
     * get calendar
     * @param name  name of calendar to get
     * @exception NoNameMatchException          �엯�젰�맂 �씠由꾩쓣 媛�吏� calendar媛� �뾾�쓣 �븣
     */
    public Calendar get_calendar(String name) {
    	for (Calendar c : calendars) {
    		if (name.equals(c.getName())) {
    			return c;
    		}
    	}
    	
    	throw new NoNameMatchException();
    }

    /**
     * make new calendar
     * @param name  name of new calendar  
     * @exception AlreadyDefinedException   �씠誘� 媛숈� �씠由꾩쓽 calendar媛� 議댁옱�븷 �븣
     * @exception NoNameEnteredException    �씠由꾩씠 �엯�젰�릺吏� �븡�븯�쓣 �븣
     */
    public void add_calendar(String name, Color color) {
        if (name.length() == 0 || name == null) {
            throw new NoNameEnteredException();
        }

        for (Calendar c : calendars) {
            if (name.equals(c.getName())) {
                throw new AlreadyDefinedException("'" + name + "' Calendar is already defined.");
            }
        }

        Calendar c = new Calendar(name,color);
        calendars.add(c);
    }

    /**
     * remove calendar
     * @param name  name of calendar to delete
     * @exception NoNameEnteredException        �씠由꾩씠 �엯�젰�릺吏� �븡�븯�쓣 �븣
     * @exception NoNameMatchException          �엯�젰�맂 �씠由꾩쓣 媛�吏� calendar媛� �뾾�쓣 �븣
     * @exception LastCalendarException         calendar媛� �븯�굹 �궓�븘 �엳�쓣 �븣
     */
    public void remove_calendar(String name) {
        if (name.length() == 0 || name == null) {
            throw new NoNameEnteredException();
        }

        if (calendars.size() == 1) {
            throw new LastCalendarException("There is only one calendar left.");
        }

        Iterator<Calendar> iter = calendars.iterator();
        while(iter.hasNext()) {
            Calendar c = iter.next();
            if (name.equals(c.getName())) {
                iter.remove();
                return;
            }
        }

        throw new NoNameMatchException("There is no calendar : '" + name + "'");
    }

    /**
     * change name of calendar
     * @param old_name  old name of calendar
     * @param new_name  new name of calendar
     * @exception NoNameMatchException                  old_name�쓣 媛�吏� calendar媛� �뾾�쓣 �븣
     * @exception NoNameEnteredException                old_name�씠�굹 new_name�씠 �엯�젰�릺吏� �븡�븯�쓣 �븣
     * @exception AlreadyDefinedException   			�씠誘� 媛숈� �씠由꾩쓽 calendar媛� 議댁옱�븷 �븣
     * @exception EmptyCalendarException                calendar媛� 鍮꾩뼱 �엳�쓣 �븣
     */
    public void modify_calendar(String old_name, String new_name) {
        if (old_name.length() == 0 || old_name == null || new_name.length() == 0 || new_name == null) {
            throw new NoNameEnteredException();
        }
        /*
        if (calendars.isEmpty()) {
            throw new EmptyCalendarException();
        }
        */
        for (Calendar c : calendars) {
            if (new_name.equals(c.getName())) {
                throw new AlreadyDefinedException();
            }
        }

        for (Calendar c : calendars) {
            if (old_name.equals(c.getName())) {
                c.setName(new_name);
                return;
            }
        }

        throw new NoNameMatchException();
    }
}