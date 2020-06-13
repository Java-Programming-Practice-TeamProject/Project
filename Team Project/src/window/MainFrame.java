package window;

import scheduler.*;
import exception.AlreadyDefinedException;
import exception.NoNameEnteredException;

import java.awt.*;
import java.awt.event.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.*;
import javax.swing.event.*;

import java.util.ArrayList;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class MainFrame extends JFrame {
	private static final long serialVersionUID = 26869752226168311L;

	Scheduler scheduler = new Scheduler();
	JComboBox<String> calendarComboBox;
	JSpinner yearSpinner, monthSpinner;
	ArrayList<JButton> DayOfWeekButton = new ArrayList<>();
	ArrayList<JButton> WeekButton = new ArrayList<>();
	ArrayList<JButton> DayButton = new ArrayList<>();
	private String name = "";
	Socket socket;
	Sender sender;
	ReceiveThread receive;
	String[] user_names;

	public static void main(String[] args) {
		try {
			new MainFrame();
		} catch (Exception e) {

		}
	}

	public MainFrame() {
		try {
			socket = new Socket("localhost", 5000);
		} catch (IOException e1) {
		}

		getContentPane().setLayout(new BorderLayout(0, 20));

		JPanel ButtonPanel = new JPanel();
		getContentPane().add(ButtonPanel, BorderLayout.NORTH);
		ButtonPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
		GridBagLayout gbl_ButtonPanel = new GridBagLayout();
		gbl_ButtonPanel.columnWidths = new int[] { 50, 150, 200, 150, 100, 100 };
		gbl_ButtonPanel.rowHeights = new int[] { 50, 20, 50 };
		gbl_ButtonPanel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 };
		gbl_ButtonPanel.rowWeights = new double[] { 0.0, 0.0 };
		ButtonPanel.setLayout(gbl_ButtonPanel);

		calendarComboBox = new JComboBox<String>(scheduler.get_name());
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 0, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 2;
		calendarComboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				loadCalendar();
			}
		});
		ButtonPanel.add(calendarComboBox, gbc_comboBox);

		LocalDate today = LocalDate.now();
		SpinnerModel yearModel = new SpinnerNumberModel(today.getYear(), null, null, 1);
		yearSpinner = new JSpinner(yearModel);
		yearSpinner.setEditor(new JSpinner.NumberEditor(yearSpinner, "####"));
		yearSpinner.setFont(new Font("굴림", Font.PLAIN, 30));
		JSpinner.DefaultEditor yearSpinnerEditor = (JSpinner.DefaultEditor) yearSpinner.getEditor();
		yearSpinnerEditor.getTextField().setHorizontalAlignment(JTextField.CENTER);
		yearSpinnerEditor.getTextField().setEditable(false);
		GridBagConstraints gbc_yearSpinner = new GridBagConstraints();
		gbc_yearSpinner.insets = new Insets(0, 0, 0, 5);
		gbc_yearSpinner.fill = GridBagConstraints.BOTH;
		gbc_yearSpinner.gridx = 2;
		gbc_yearSpinner.gridy = 0;
		yearSpinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				loadCalendar();
			}
		});
		ButtonPanel.add(yearSpinner, gbc_yearSpinner);

		SpinnerModel monthModel = new SpinnerNumberModel(today.getMonthValue(), 1, 12, 1);
		monthSpinner = new JSpinner(monthModel);
		monthSpinner.setEditor(new JSpinner.NumberEditor(monthSpinner, "00"));
		monthSpinner.setFont(new Font("굴림", Font.PLAIN, 30));
		JSpinner.DefaultEditor monthSpinnerEditor = (JSpinner.DefaultEditor) monthSpinner.getEditor();
		monthSpinnerEditor.getTextField().setHorizontalAlignment(JTextField.CENTER);
		monthSpinnerEditor.getTextField().setEditable(false);
		GridBagConstraints gbc_monthSpinner = new GridBagConstraints();
		gbc_monthSpinner.insets = new Insets(0, 0, 0, 5);
		gbc_monthSpinner.fill = GridBagConstraints.BOTH;
		gbc_monthSpinner.gridx = 3;
		gbc_monthSpinner.gridy = 0;
		monthSpinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				loadCalendar();
			}
		});
		ButtonPanel.add(monthSpinner, gbc_monthSpinner);

		JButton ShareButton = new JButton("Share");
		GridBagConstraints gbc_ShareButton = new GridBagConstraints();
		gbc_ShareButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_ShareButton.insets = new Insets(0, 0, 0, 5);
		gbc_ShareButton.gridx = 4;
		gbc_ShareButton.gridy = 2;
		ButtonPanel.add(ShareButton, gbc_ShareButton);
		ShareButton.addActionListener(new ShareButtonClickListener());
		/*
		 * JButton ChatButton = new JButton("Chat"); GridBagConstraints gbc_ChatButton =
		 * new GridBagConstraints(); gbc_ChatButton.fill =
		 * GridBagConstraints.HORIZONTAL; gbc_ChatButton.insets = new Insets(0, 0, 0,
		 * 5); gbc_ChatButton.gridx = 4; gbc_ChatButton.gridy = 2;
		 * ButtonPanel.add(ChatButton, gbc_ChatButton);
		 */
		JButton AddButton = new JButton("Add");
		GridBagConstraints gbc_AddButton = new GridBagConstraints();
		gbc_AddButton.insets = new Insets(0, 0, 0, 5);
		gbc_AddButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_AddButton.gridx = 5;
		gbc_AddButton.gridy = 2;
		AddButton.addActionListener(new AddButtonClickListener());
		ButtonPanel.add(AddButton, gbc_AddButton);

		JPanel CalendarPanel = new JPanel();
		getContentPane().add(CalendarPanel, BorderLayout.CENTER);
		GridBagLayout gbl_CalendarPanel = new GridBagLayout();
		gbl_CalendarPanel.columnWidths = new int[] { 50, 100, 100, 100, 100, 100, 100, 100 };
		gbl_CalendarPanel.rowHeights = new int[] { 50, 100, 100, 100, 100, 100, 100 };
		gbl_CalendarPanel.columnWeights = new double[] { 0.0 };
		gbl_CalendarPanel.rowWeights = new double[] { 0.0 };
		CalendarPanel.setLayout(gbl_CalendarPanel);

		String[] Day = { "Sun", "Mon", "Tue", "Wed", "Thr", "Fri", "Sat" };
		// String Day = "일월화수목금토";
		for (int i = 0; i < 7; i++) {
			JLabel Label = new JLabel(Day[i]);
			GridBagConstraints gbc = new GridBagConstraints();
			gbc.fill = GridBagConstraints.BOTH;
			gbc.insets = new Insets(0, 0, 5, 5);
			gbc.gridx = i + 1;
			gbc.gridy = 0;
			Label.setHorizontalAlignment(JLabel.CENTER);
			Label.setVerticalAlignment(JLabel.CENTER);
			// Button.addActionListener(new DayOfWeekButtonClickListener());
			// DayOfWeekButton.add(Button);
			CalendarPanel.add(Label, gbc);
		}

		for (int i = 1; i <= 6; i++) {
			JButton Button = new JButton("" + i);
			GridBagConstraints gbc = new GridBagConstraints();
			gbc.fill = GridBagConstraints.BOTH;
			gbc.insets = new Insets(0, 0, 5, 5);
			gbc.gridx = 0;
			gbc.gridy = i;
			Button.setHorizontalAlignment(JLabel.CENTER);
			Button.setVerticalAlignment(JLabel.CENTER);
			Button.addActionListener(new WeekButtonClickListener());
			WeekButton.add(Button);
			CalendarPanel.add(Button, gbc);
		}

		for (int i = 1; i <= 6; i++) {
			for (int j = 1; j <= 7; j++) {
				JButton Button = new JButton("");
				GridBagConstraints gbc = new GridBagConstraints();
				gbc.fill = GridBagConstraints.BOTH;
				gbc.insets = new Insets(0, 0, 5, 5);
				gbc.gridx = j;
				gbc.gridy = i;
				Button.addActionListener(new DayButtonClickListener());
				DayButton.add(Button);
				CalendarPanel.add(Button, gbc);
			}
		}
		loadCalendar();

		while (true) {
			try {
				read_name();
				sender = new Sender();
				break;
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, e.toString(), "Exception", JOptionPane.ERROR_MESSAGE);
			}
		}

		JLabel NameLabel = new JLabel("User: " + name);
		NameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		NameLabel.setFont(new Font("굴림", Font.PLAIN, 16));
		GridBagConstraints gbc_NameLabel = new GridBagConstraints();
		gbc_NameLabel.insets = new Insets(0, 0, 5, 5);
		gbc_NameLabel.gridx = 1;
		gbc_NameLabel.gridy = 1;
		ButtonPanel.add(NameLabel, gbc_NameLabel);
		pack();
		setVisible(true);

		receive = new ReceiveThread();
		receive.start();
		receive.setDaemon(true);
	}

	class WeekButtonClickListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int year = (int) yearSpinner.getValue(), month = (int) monthSpinner.getValue();
			Calendar cal = scheduler.get_calendar(calendarComboBox.getSelectedItem().toString());
			ArrayList<ArrayList<Schedule>> schedule = new ArrayList<>();
			JButton button = (JButton) e.getSource();
			int i = Integer.parseInt(button.getText()) - 1;

			for (int j = 0; j < 7; j++) {
				JButton db = DayButton.get(7 * i + j);
				if (db.getText().isEmpty()) {
					schedule.add(new ArrayList<Schedule>());
					continue;
				}
				String day = db.getText().substring(10, 12);
				if (day.charAt(1) == '<') {
					day = day.substring(0, 1);
				}
				LocalDate today = LocalDate.of(year, month, Integer.parseInt(day));
				schedule.add(cal.read_schedule(today));
			}

			// WeeklyScheduleFrame wsf = new WeeklyScheduleFrame(schedule);
			// wsf.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			// wsf.setVisible(true);
		}
	}

	class DayButtonClickListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int year = (int) yearSpinner.getValue(), month = (int) monthSpinner.getValue();
			Calendar cal = scheduler.get_calendar(calendarComboBox.getSelectedItem().toString());
			JButton button = (JButton) e.getSource();

			if (button.getText().isEmpty()) {
				return;
			}
			String day = button.getText().substring(10, 12);
			if (day.charAt(1) == '<') {
				day = day.substring(0, 1);
			}

			LocalDate today = LocalDate.of(year, month, Integer.parseInt(day));
			ArrayList<Schedule> s = cal.read_schedule(today);
			if (s.size() == 0) {
				return;
			}

			ShowScheduleFrame ssf = new ShowScheduleFrame(s, cal.getName());
			ssf.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			ssf.setVisible(true);
		}
	}

	class AddButtonClickListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			EditCalendarAndSchduleFrame ecsf = new EditCalendarAndSchduleFrame();
			ecsf.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			ecsf.getAddScheduleButton().addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String[] names = scheduler.get_name();
					AddScheduleFrame asf = new AddScheduleFrame(names, calendarComboBox.getSelectedItem().toString());
					asf.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
					asf.getSubmitButton().addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							Calendar c = scheduler.get_calendar(asf.getCalendarName());
							JCheckBox[] cb = asf.getCheckBox();
							try {
								c.add_schedule(asf.getName(), asf.getTime(false), asf.getTime(true), cb[3].isSelected(),
										cb[2].isSelected(), asf.getMemo(), asf.getRepeat(), cb[1].isSelected());
								asf.setVisible(false);
								asf.dispose();
								loadCalendar();
							} catch (RuntimeException e1) {
								JOptionPane.showMessageDialog(asf, e1.toString(), "Exception",
										JOptionPane.ERROR_MESSAGE);
							}
						}
					});
					asf.setVisible(true);
				}
			});
			ecsf.getSubmitButton().addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						String[] textField = ecsf.getTextField();
						if (textField[0].length() != 0 && textField[1].length() == 0) {
							scheduler.add_calendar(textField[0]);
							calendarComboBox.addItem(textField[0]);
						} else if (textField[0].length() == 0 && textField[1].length() != 0) {
							scheduler.remove_calendar(textField[1]);
							calendarComboBox.removeItem(textField[1]);
						}
						ecsf.setVisible(false);
						ecsf.dispose();
					} catch (RuntimeException e1) {
						JOptionPane.showMessageDialog(ecsf, e1.toString(), "Exception", JOptionPane.ERROR_MESSAGE);
					}
				}
			});
			ecsf.setVisible(true);
		}
	}

	class ShareButtonClickListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			ShareFrame sf = new ShareFrame(scheduler, user_names, name);
			sf.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			sf.getSendBtn().addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String[] selected = sf.getComboBox();
					Calendar cal = scheduler.get_calendar(selected[1]);
					Schedule sch = cal.get_Schedule(selected[2]);
					try {
						sender.sendSchedule(sch, selected[0]);
					} catch (Exception e2) {
					}

					sender = null;
					sf.setVisible(false);
					sf.dispose();
				}
			});
			sf.setVisible(true);
		}
	}

	public void loadCalendar() {
		int year = (int) yearSpinner.getValue(), month = (int) monthSpinner.getValue();
		Calendar cal = scheduler.get_calendar(calendarComboBox.getSelectedItem().toString());
		LocalDate date = LocalDate.of(year, month, 1);
		int start_pos = date.getDayOfWeek().getValue();

		for (JButton b : DayButton) {
			b.setText("");
		}

		if (start_pos == 7)
			start_pos = 0;
		for (int i = 0; i < date.lengthOfMonth(); i++) {
			JButton button = DayButton.get(start_pos + i);
			button.setHorizontalAlignment(SwingConstants.LEFT);
			button.setVerticalAlignment(SwingConstants.TOP);
			ArrayList<Schedule> schedules = cal.read_schedule(date.plusDays(i));
			if (schedules.size() == 0) {
				button.setText("<html><h2>" + (i + 1) + "</h2></html>");
			} else if (schedules.size() == 1) {
				button.setText("<html><h2>" + (i + 1) + "</h2><br>" + schedules.size() + " thing</html>");
			} else {
				button.setText("<html><h2>" + (i + 1) + "</h2><br>" + schedules.size() + " things</html>");
			}
		}
	}

	public void read_name() {
		name = JOptionPane.showInputDialog("이름을 입력하세요.");
		if (name.length() == 0) {
			throw new NoNameEnteredException();
		}
	}

	class Sender {
		DataOutputStream dos;
		DataInputStream dis;

		public Sender() throws IOException {
			dos = new DataOutputStream(socket.getOutputStream());
			dis = new DataInputStream(socket.getInputStream());

			dos.writeUTF(name);
			dos.flush();
			boolean isValid = dis.readBoolean();
			if (!isValid) {
				throw new AlreadyDefinedException();
			}
		}

		public void sendSchedule(Schedule s, String name) {
			try {
				dos.writeUTF(name);
				dos.writeUTF(s.getName());
				dos.writeBoolean(s.getIsImportant());
				dos.writeUTF(s.getMemo());
				dos.writeInt(s.getRepeatType());
				dos.flush();
				if (s instanceof FullDaySchedule) {
					LocalDate time = ((FullDaySchedule) s).getTime();
					int[] start = { time.getYear(), time.getMonthValue(), time.getDayOfMonth() };
					dos.writeBoolean(true);
					for (int i = 0; i < 3; i++) {
						dos.writeInt(start[i]);
					}
				} else {
					LocalDateTime start = ((NormalSchedule) s).getStartTime();
					LocalDateTime end = ((NormalSchedule) s).getEndTime();
					int[] start_time = { start.getYear(), start.getMonthValue(), start.getDayOfMonth(), start.getHour(),
							start.getMinute() };
					int[] end_time = { end.getYear(), end.getMonthValue(), end.getDayOfMonth(), end.getHour(),
							end.getMinute() };
					dos.writeBoolean(false);
					for (int i = 0; i < 5; i++) {
						dos.writeInt(start_time[i]);
						dos.writeInt(end_time[i]);
					}
					dos.writeBoolean(((NormalSchedule) s).getCanBeOverlapped());
				}
				dos.flush();
			} catch (Exception e) {

			}
		}
	}

	class ReceiveThread extends Thread {
		DataInputStream dis;
		DataOutputStream dos;
		Boolean isImp;
		String memo;
		int RepeatType;
		boolean isFullDay;
		int[] start, end;
		boolean canBeOverlapped;

		public ReceiveThread() {
			try {
				dis = new DataInputStream((socket.getInputStream()));
				dos = new DataOutputStream(socket.getOutputStream());
			} catch (IOException e) {
			}
			System.out.println("receive on");
		}

		public void run() {
			try {
				while (true) {
					int mode = dis.readInt();
					if (mode == 0) {
						int size = dis.readInt();
						user_names = new String[size];
						for (int i = 0; i < size; i++) {
							user_names[i] = dis.readUTF();
						}
					} else if (mode == 1) {
						name = dis.readUTF();
						isImp = dis.readBoolean();
						memo = dis.readUTF();
						RepeatType = dis.readInt();
						isFullDay = dis.readBoolean();
						if (isFullDay) {
							start = new int[3];
							for (int i = 0; i < 3; i++) {
								start[i] = dis.readInt();
							}
						} else {
							start = new int[5];
							end = new int[5];
							for (int i = 0; i < 5; i++) {
								start[i] = dis.readInt();
								end[i] = dis.readInt();
							}
							canBeOverlapped = dis.readBoolean();
						}
						ReceiveFrame rf = new ReceiveFrame(scheduler.get_name());
						rf.setDefaultCloseOperation(2);
						rf.getAddBtn().addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								String selected_name = rf.getCalComboBox();
								Calendar cal = scheduler.get_calendar(selected_name);
								if (isFullDay) {
									cal.add_schedule(name, start, start, isImp, true, memo, RepeatType, true);
								} else {
									cal.add_schedule(name, start, end, isImp, canBeOverlapped, memo, RepeatType, false);
								}
								rf.setVisible(false);
								rf.dispose();
								loadCalendar();
							}
						});
						rf.setVisible(true);
					}

				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("receive off");
		}
	}

}
