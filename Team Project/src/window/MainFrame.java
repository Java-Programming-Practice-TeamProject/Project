package window;

import scheduler.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.time.LocalDate;

public class MainFrame extends JFrame {
	private static final long serialVersionUID = 26869752226168311L;

	Scheduler scheduler = new Scheduler();
	JComboBox<String> calendarComboBox;
	JSpinner yearSpinner, monthSpinner;
	ArrayList<JButton> DayOfWeekButton = new ArrayList<>();
	ArrayList<JButton> WeekButton = new ArrayList<>();
	ArrayList<JButton> DayButton = new ArrayList<>();

	public MainFrame() {
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
		yearSpinner.setFont(new Font("援대┝", Font.PLAIN, 30));
		JSpinner.DefaultEditor yearSpinnerEditor = (JSpinner.DefaultEditor) yearSpinner.getEditor();
		yearSpinnerEditor.getTextField().setHorizontalAlignment(JTextField.CENTER);
		yearSpinnerEditor.getTextField().setEditable(false);
		GridBagConstraints gbc_yearSpinner = new GridBagConstraints();
		gbc_yearSpinner.insets = new Insets(0, 0, 0, 5);
		gbc_yearSpinner.fill = GridBagConstraints.BOTH;
		gbc_yearSpinner.gridx = 2;
		gbc_yearSpinner.gridy = 0;
		yearSpinner.addChangeListener(new ChangeListener(){
			public void stateChanged(ChangeEvent e) {
				loadCalendar();
			}
		});
		ButtonPanel.add(yearSpinner, gbc_yearSpinner);

		SpinnerModel monthModel = new SpinnerNumberModel(today.getMonthValue(), 1, 12, 1);
		monthSpinner = new JSpinner(monthModel);
		monthSpinner.setEditor(new JSpinner.NumberEditor(monthSpinner, "00"));
		monthSpinner.setFont(new Font("援대┝", Font.PLAIN, 30));
		JSpinner.DefaultEditor monthSpinnerEditor = (JSpinner.DefaultEditor) monthSpinner.getEditor();
		monthSpinnerEditor.getTextField().setHorizontalAlignment(JTextField.CENTER);
		monthSpinnerEditor.getTextField().setEditable(false);
		GridBagConstraints gbc_monthSpinner = new GridBagConstraints();
		gbc_monthSpinner.insets = new Insets(0, 0, 0, 5);
		gbc_monthSpinner.fill = GridBagConstraints.BOTH;
		gbc_monthSpinner.gridx = 3;
		gbc_monthSpinner.gridy = 0;
		monthSpinner.addChangeListener(new ChangeListener(){
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
		// String Day = "�씪�썡�솕�닔紐⑷툑�넗";
		for (int i = 0; i < 7; i++) {
			JLabel Label = new JLabel(Day[i]);
			GridBagConstraints gbc = new GridBagConstraints();
			gbc.fill = GridBagConstraints.BOTH;
			gbc.insets = new Insets(0, 0, 5, 5);
			gbc.gridx = i + 1;
			gbc.gridy = 0;
			Label.setHorizontalAlignment(JLabel.CENTER);
			Label.setVerticalAlignment(JLabel.CENTER);
			//Button.addActionListener(new DayOfWeekButtonClickListener());
			//DayOfWeekButton.add(Button);
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

		pack();
		setVisible(true);
	}

	class WeekButtonClickListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int year = (int) yearSpinner.getValue(), month = (int) monthSpinner.getValue();
			String selectedcal = calendarComboBox.getSelectedItem().toString();
			ArrayList<ArrayList<Schedule>> schedule = new ArrayList<>();
			if(selectedcal.equals("default")) {
				for(int k=0;k<scheduler.get_name().length;k++) {
					Calendar cal  = scheduler.get_calendar((scheduler.get_name()[k]));
					JButton button = (JButton) e.getSource();
					int i = Integer.parseInt(button.getText()) - 1;
					
					for(int j=0;j<7;j++) {
						schedule.add(new ArrayList<Schedule>());
					}

					for (int j = 0; j < 7; j++) {
						JButton db = DayButton.get(7 * i + j);
						if (db.getText().isEmpty()) {
							continue;
						}
						String day = db.getText().substring(10, 12);
						if (day.charAt(1) == '<') {
							day = day.substring(0, 1);
						}

						LocalDate today = LocalDate.of(year, month, Integer.parseInt(day));
						schedule.get(j).addAll(cal.read_schedule(today));
					}
				}
			}
			else {
				Calendar cal = scheduler.get_calendar(selectedcal);
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
			}
			WeeklyScheduleFrame wsf = new WeeklyScheduleFrame(schedule);
			wsf.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			wsf.setVisible(true);
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
										cb[2].isSelected(), asf.getMemo(), asf.getRepeat(), cb[1].isSelected(),c.getColor());
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
						Color calcolor;
						switch (Integer.parseInt(textField[2])) {
							case 0:
								calcolor = Color.MAGENTA;
								break;
							case 1:
								calcolor = Color.PINK;
								break;
							case 2:
								calcolor = Color.RED;
								break;
							case 3:
								calcolor = Color.ORANGE;
								break;
							case 4:
								calcolor = Color.YELLOW;
								break;
							case 5:
								calcolor = Color.GREEN;
								break;
							case 6:
								calcolor = Color.CYAN;
								break;
							case 7:
								calcolor = Color.BLUE;
								break;
							case 8:
								calcolor = Color.LIGHT_GRAY;
								break;
							case 9:
								calcolor = Color.GRAY;
								break;
							case 10:
								calcolor = Color.DARK_GRAY;
								break;
							default:
								calcolor = Color.LIGHT_GRAY;
						}
						if (textField[0].length() != 0 && textField[1].length() == 0) {
							scheduler.add_calendar(textField[0],calcolor);
							calendarComboBox.addItem(textField[0]);
						}
						else if (textField[0].length() == 0 && textField[1].length() != 0) {
							scheduler.remove_calendar(textField[1]);
							calendarComboBox.removeItem(textField[1]);
						}
						ecsf.setVisible(false);
						ecsf.dispose();
					} catch (RuntimeException e1) {
						JOptionPane.showMessageDialog(ecsf, e1.toString(), "Exception",
										JOptionPane.ERROR_MESSAGE);
					}	
				}
			});
			ecsf.setVisible(true);
		}
	}

	class SubmitButtonClickListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

		}
	}

	public void loadCalendar() {
		int year = (int) yearSpinner.getValue(), month = (int) monthSpinner.getValue();
		String selectedItem = calendarComboBox.getSelectedItem().toString();
		if(selectedItem.equals("default")) {
			LocalDate date = LocalDate.of(year, month, 1);
			int start_pos = date.getDayOfWeek().getValue();
	
			for (JButton b : DayButton) {
				b.setText("");
			}
	
			start_pos %= 7;
			
			for (int i = 0; i < date.lengthOfMonth(); i++) {
				JButton button = DayButton.get(start_pos + i);
				button.setHorizontalAlignment(SwingConstants.LEFT);
				button.setVerticalAlignment(SwingConstants.TOP);
				ArrayList<Schedule> schedules = new ArrayList<Schedule>();
				for(int j=0;j<scheduler.get_name().length;j++) {
					schedules.addAll(scheduler.get_calendar(scheduler.get_name()[j]).read_schedule(date.plusDays(i)));
				}
				if (schedules.size() == 0) {
					button.setText("<html><h2>" + (i + 1) + "</h2></html>");
				} else if (schedules.size() == 1) {
					button.setText("<html><h2>" + (i + 1) + "</h2><br>" + schedules.size() + " thing</html>");
				} else {
					button.setText("<html><h2>" + (i + 1) + "</h2><br>" + schedules.size() + " things</html>");
				}
			}
		}
		else {
			Calendar cal = scheduler.get_calendar(selectedItem);
			LocalDate date = LocalDate.of(year, month, 1);
			int start_pos = date.getDayOfWeek().getValue();
	
			for (JButton b : DayButton) {
				b.setText("");
			}
	
			start_pos %= 7;
			
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
	}
}
