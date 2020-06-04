package scheduler;

import exception.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

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
	 * @param name name of calendar
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
	 * @param name new name of calendar
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
     * add new schedule
	 * time[year, month, date, hour, minute]
     * @param   all variables in class Schedule
     * @exception AlreadyDefinedException			이미 같은 이름의 일정이 존재할 때
     * @exception NoNameEnteredException			이름이 입력되지 않았을 때
     * @exception TimeAlreadyFullException		   	이미 그 시간에 일정이 존재할 때
     * @exception StartTimeAfterEndTimeException	시작 시간이 끝나는 시간보다 늦을 때
	 * @exception NotRepeatableException		 	일정이 반복 간격보다 길 때
     */
    public void add_schedule(String name, int[] start, int[] end, boolean isImp, boolean overlap, String memo, int repeat, boolean isAllDay) {
		LocalDateTime start_time, end_time;
		LocalDate time;
		Schedule new_schedule;
		
		if(name.length() == 0) {
    		throw new NoNameEnteredException();
    	}

		if (isAllDay) {
			time = LocalDate.of(start[0], start[1], start[2]);
			new_schedule = new FullDaySchedule(name, isImp, memo, repeat, time);
		} 
		else {
			start_time = LocalDateTime.of(start[0], start[1], start[2], start[3], start[4], 0, 0);
			end_time = LocalDateTime.of(end[0], end[1], end[2], end[3], end[4], 0, 0);
			if(start_time.isAfter(end_time)) {
				throw new StartTimeAfterEndTimeException();
			}
			switch (repeat) {
				case 1:
					if (ChronoUnit.YEARS.between(start_time, end_time) >= 1) {
						throw new NotRepeatableException();
					}
					break;
				case 2:
					if (ChronoUnit.MONTHS.between(start_time, end_time) >= 1) {
						throw new NotRepeatableException();
					}
					break;
				case 3:
					if (ChronoUnit.WEEKS.between(start_time, end_time) >= 1) {
						throw new NotRepeatableException();
					}
					break;
			}
			for (Schedule s : schedules) {
				if (s instanceof FullDaySchedule) {
					continue;
				}

				NormalSchedule temp = (NormalSchedule) s;

				if(name.equals(temp.getName())) {
					throw new AlreadyDefinedException();
				}
				
				if(temp.getCanBeOverlapped() && overlap) {
					continue;
				}

				if(start_time.equals(temp.getStartTime()) || end_time.equals(temp.getEndTime())) {
					throw new TimeAlreadyFullException();
				}
	
				if(temp.getStartTime().isAfter(start_time)) {
					if(end_time.isAfter(temp.getStartTime())) {
						throw new TimeAlreadyFullException();
					}
				}
				else {
					if(temp.getEndTime().isAfter(start_time)) {
						throw new TimeAlreadyFullException();
					}
				}
			}
			new_schedule = new NormalSchedule(name, isImp, overlap, memo, repeat, start_time, end_time);
		}

    	schedules.add(new_schedule);
    }

	/**
	 * delete schedule
	 * @param name name of schedule to delete
	 * @exception NoNameEnteredException 이름이 입력되지 않았을 때
	 * @exception NoNameMatchException   입력된 이름을 가진 schedule이 없을 때
	 */
	public void remove_schedule(String name) {
		if (name == null) {
			throw new NoNameEnteredException();
		}

		Iterator<Schedule> iter = schedules.iterator();
		while (iter.hasNext()) {
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
	 * @param all variables in class Schedule & new name of schedule
	 * @exception NoNameEnteredException        	이름이 입력되지 않았을 때
	 * @exception AlreadyDefinedException        	이미 같은 이름의 일정이 존재할 때
	 * @exception TimeAlreadyFullException       	이미 그 시간에 일정이 존재할 때
	 * @exception StartTimeAfterEndTimeException 	시작 시간이 끝나는 시간보다 늦을 때
	 * @exception NoNameMatchException           	입력된 이름을 가진 schedule이 없을 때
	 * @exception NotRepeatableException		 	일정이 반복 간격보다 길 때
	 */
	public void modify_schedule(String name, String new_name, int[] start, int[] end, boolean isImp, boolean overlap,
			String memo, int repeat, boolean isAllDay) {
		if (new_name == null) {
			throw new NoNameEnteredException();
		}

		remove_schedule(name);
		add_schedule(new_name, start, end, isImp, overlap, memo, repeat, isAllDay);
	}

	/**
	 * read schedule from arraylist 'schedules' on specific date
	 * @param today		specific date
	 * @return			schedules on specific date
	 */
	public ArrayList<Schedule> read_schedule(LocalDate today) {
		ArrayList<Schedule> schedule_of_day = new ArrayList<>();

		for (Schedule s : schedules) {
			boolean flag = false;
			switch (s.getRepeatType()) {
				case 0:
					if (s instanceof NormalSchedule) {
						LocalDate start_time = ((NormalSchedule) s).getStartTime().toLocalDate();
						LocalDate end_time = ((NormalSchedule) s).getEndTime().toLocalDate();
						
						if (start_time.equals(today) || end_time.equals(today) || (start_time.isBefore(today) && end_time.isAfter(today))) {
							flag = true;
						}
					} else {
						LocalDate time = ((FullDaySchedule) s).getTime();

						if (time.equals(today)) {
							flag = true;
						}
					}
					break;
				case 1:
					if (s instanceof NormalSchedule) {
						LocalDate start_time = ((NormalSchedule) s).getStartTime().toLocalDate();
						LocalDate end_time = ((NormalSchedule) s).getEndTime().toLocalDate();
						int start_month = start_time.getMonthValue(), start_day = start_time.getDayOfMonth();
						int end_month = end_time.getMonthValue(), end_day = end_time.getDayOfMonth();
						int today_month = today.getMonthValue(), today_day = today.getDayOfMonth();

						if (start_month > end_month) {
							if (today_month < end_month) {
								today_month += 12;
							}
							end_month += 12;
						}

						if (start_month == today_month && start_day <= today_day) {
							flag = true;
						} else if (end_month == today_month && today_day <= end_day) {
							flag = true;
						} else if (start_month < today_month && today_month < end_month) {
							flag = true;
						}
					} else {
						LocalDate time = ((FullDaySchedule) s).getTime();
						int time_month = time.getMonthValue(), time_day = time.getDayOfMonth();
						int today_month = today.getMonthValue(), today_day = today.getDayOfMonth();

						if (today_month == time_month && today_day == time_day) {
							flag = true;
						}
					}
					break;
				case 2:
					if (s instanceof NormalSchedule) {
						LocalDate start_time = ((NormalSchedule) s).getStartTime().toLocalDate();
						LocalDate end_time = ((NormalSchedule) s).getEndTime().toLocalDate();
						int start_day = start_time.getDayOfMonth(), end_day = end_time.getDayOfMonth(), today_day = today.getDayOfMonth();

						if (start_day > end_day) {
							if (today_day <= end_day || start_day <= today_day) {
								flag = true;
							}
						}
						else {
							if (start_day <= today_day && today_day <= end_day) {
								flag = true;
							}
						}
					} else {
						LocalDate time = ((FullDaySchedule) s).getTime();
						int time_day = time.getDayOfMonth(), today_day = today.getDayOfMonth();

						if (time_day == today_day) {
							flag = true;
						}
					}
					break;
				case 3:
					if (s instanceof NormalSchedule) {
						LocalDate start_time = ((NormalSchedule) s).getStartTime().toLocalDate();
						LocalDate end_time = ((NormalSchedule) s).getEndTime().toLocalDate();
						int start_day_week = start_time.getDayOfWeek().getValue(), end_day_week = end_time.getDayOfWeek().getValue(), today_day_week = today.getDayOfWeek().getValue();

						if (start_day_week > end_day_week) {
							if (today_day_week <= end_day_week || start_day_week <= today_day_week) {
								flag = true;
							}
						} else {
							if (start_day_week <= today_day_week && today_day_week <= end_day_week) {
								flag = true;
							}
						}
					} else {
						LocalDate time = ((FullDaySchedule) s).getTime();
						int time_day_week = time.getDayOfWeek().getValue(), today_day_week = today.getDayOfWeek().getValue();

						if (time_day_week == today_day_week) {
							flag = true;
						}
					}
					break;
			}
			if (flag) {
				schedule_of_day.add(s);
			}
		}

		return schedule_of_day;
	}
}
