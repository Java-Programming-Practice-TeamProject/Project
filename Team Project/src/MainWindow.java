import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.ArrayList;
import java.time.LocalDate;

public class MainWindow {
	public static void main(String[] args) {
        MainFrame mf = new MainFrame();
    }
}

class MainFrame extends JFrame {
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
		gbl_ButtonPanel.columnWidths = new int[] {150, 200, 100, 100, 100, 100};
		gbl_ButtonPanel.rowHeights = new int[] {50, 20, 50};
		gbl_ButtonPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		gbl_ButtonPanel.rowWeights = new double[]{0.0, 0.0};
		ButtonPanel.setLayout(gbl_ButtonPanel);
		
		String[] names = scheduler.get_name();
		calendarComboBox = new JComboBox<String>(names);
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 0, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 0;
		gbc_comboBox.gridy = 2;
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
		gbc_yearSpinner.gridx = 1;
		gbc_yearSpinner.gridy = 0;
		yearSpinner.addChangeListener(new SpinnerChangeListener());
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
		gbc_monthSpinner.gridx = 2;
		gbc_monthSpinner.gridy = 0;
		monthSpinner.addChangeListener(new SpinnerChangeListener());
		ButtonPanel.add(monthSpinner, gbc_monthSpinner);
		
		JButton ShareButton = new JButton("Share");
		GridBagConstraints gbc_ShareButton = new GridBagConstraints();
		gbc_ShareButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_ShareButton.insets = new Insets(0, 0, 0, 5);
		gbc_ShareButton.gridx = 3;
		gbc_ShareButton.gridy = 2;
		ButtonPanel.add(ShareButton, gbc_ShareButton);
		
		JButton ChatButton = new JButton("Chat");
		GridBagConstraints gbc_ChatButton = new GridBagConstraints();
		gbc_ChatButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_ChatButton.insets = new Insets(0, 0, 0, 5);
		gbc_ChatButton.gridx = 4;
		gbc_ChatButton.gridy = 2;
		ButtonPanel.add(ChatButton, gbc_ChatButton);
		
		JButton AddButton = new JButton("Add");
		GridBagConstraints gbc_AddButton = new GridBagConstraints();
		gbc_AddButton.insets = new Insets(0, 0, 0, 5);
		gbc_AddButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_AddButton.gridx = 5;
		gbc_AddButton.gridy = 2;
		ButtonPanel.add(AddButton, gbc_AddButton);
		
		JPanel CalendarPanel = new JPanel();
		getContentPane().add(CalendarPanel, BorderLayout.CENTER);
		GridBagLayout gbl_CalendarPanel = new GridBagLayout();
		gbl_CalendarPanel.columnWidths = new int[] {50, 100, 100, 100, 100, 100, 100, 100};
		gbl_CalendarPanel.rowHeights = new int[] {50, 100, 100, 100, 100, 100, 100};
		gbl_CalendarPanel.columnWeights = new double[]{0.0};
		gbl_CalendarPanel.rowWeights = new double[]{0.0};
		CalendarPanel.setLayout(gbl_CalendarPanel);
		
		String Day = "일월화수목금토";
		for (int i = 0; i < 7; i++) {
			JButton Button = new JButton(Day.substring(i, i+1));
			GridBagConstraints gbc = new GridBagConstraints();
			gbc.fill = GridBagConstraints.BOTH;
			gbc.insets = new Insets(0, 0, 5, 5);
			gbc.gridx = i + 1;
			gbc.gridy = 0;
			Button.addActionListener(new DayOfWeekButtonClickListener());
			DayOfWeekButton.add(Button);
			CalendarPanel.add(Button, gbc);
		}
		
		for (int i = 1; i <= 6; i++) {
			JButton Button = new JButton("" + i);
			GridBagConstraints gbc = new GridBagConstraints();
			gbc.fill = GridBagConstraints.BOTH;
			gbc.insets = new Insets(0, 0, 5, 5);
			gbc.gridx = 0;
			gbc.gridy = i;
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
	
	class DayOfWeekButtonClickListener implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			
		}
	}
	
	class WeekButtonClickListener implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			
		}
	}
	
	class DayButtonClickListener implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			
		}
	}
	
	class SpinnerChangeListener implements ChangeListener {
		public void stateChanged(ChangeEvent e) {
			loadCalendar();
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
		
		if (start_pos == 7) start_pos = 0;
		for (int i = 0; i < date.lengthOfMonth(); i++) {
			JButton button = DayButton.get(start_pos + i);		
			button.setHorizontalAlignment(SwingConstants.LEFT);
			button.setVerticalAlignment(SwingConstants.TOP);
			ArrayList<Schedule> schedules = cal.read_schedule(date.plusDays(i));
			button.setText("<html><h2>" + (i + 1) + "</h2><br>"+ schedules.size() +"건</html>");
		}
	}
}
