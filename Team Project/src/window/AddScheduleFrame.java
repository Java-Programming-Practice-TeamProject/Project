package window;

import java.awt.BorderLayout;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.swing.*;
import javax.swing.GroupLayout.*;
import javax.swing.LayoutStyle.*;
import javax.swing.event.*;

public class AddScheduleFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2554199206713652387L;
	private JButton SubmitButton;
	private JComboBox<String> CalendarComboBox, RepeatComboBox;
	private JCheckBox[] CheckBox; //TODO, FD, OL, Imp
	private JTextField NameTextField, MemoTextField;
	private JSpinner[] StartTimeSpinner;
	private JSpinner[] EndTimeSpinner;
	
	public JButton getSubmitButton() {
		return SubmitButton;
	}
	
	public String getCalendarName() {
		return CalendarComboBox.getSelectedItem().toString();
	}
	
	public String getName() {
		return NameTextField.getText();
	}
	
	public String getMemo() {
		return MemoTextField.getText();
	}
	
	public JCheckBox[] getCheckBox() {
		return CheckBox;
	}
	
	public int getRepeat() {
		if (RepeatComboBox.getSelectedItem().toString().equals("None")) {
			return 0;
		} else if (RepeatComboBox.getSelectedItem().toString().equals("Every year")) {
			return 1;
		} else if (RepeatComboBox.getSelectedItem().toString().equals("Every month")) {
			return 2;
		} else  {
			return 3;
		}
	}
	
	public int[] getTime(boolean mode) {
		int[] time = new int[5];
		JSpinner[] spinner = StartTimeSpinner;
		if (mode) {
			spinner = EndTimeSpinner;
		}
		for (int i = 0; i < 5; i++) {
			time[i] = (int) spinner[i].getValue();
		}
		return time;
	}

	public AddScheduleFrame(String[] names) {
		setBounds(100, 100, 294, 609);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel panel_2 = new JPanel();
		getContentPane().add(panel_2, BorderLayout.SOUTH);

		SubmitButton = new JButton("Submit");
		panel_2.add(SubmitButton);

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.WEST);

		JLabel NameLbl = new JLabel("Name");
		JLabel TdLbl = new JLabel("TODO");
		JLabel FdLbl = new JLabel("Full day");
		JLabel TLbl = new JLabel("Time");
		JLabel ImpLbl = new JLabel("Important");
		JLabel RLbl = new JLabel("Repeat");
		JLabel CalLbl = new JLabel("Calendar");
		JLabel OLbl = new JLabel("Overlap");
		JLabel MemoLbl = new JLabel("Memo");
		
		CheckBox = new JCheckBox[4];
		CheckBox[0] = new JCheckBox("");
		CheckBox[1] = new JCheckBox("");
		CheckBox[2] = new JCheckBox("");
		CheckBox[3] = new JCheckBox("");
		
		CalendarComboBox = new JComboBox<String>(names);

		LocalDateTime today = LocalDateTime.now();
		StartTimeSpinner = new JSpinner[5];
		StartTimeSpinner[0] = new JSpinner(new SpinnerNumberModel(today.getYear(), null, null, 1));
		StartTimeSpinner[0].setEditor(new JSpinner.NumberEditor(StartTimeSpinner[0], "####"));
		StartTimeSpinner[0].addChangeListener(new StartSpinnerChangeListener());
		StartTimeSpinner[1] = new JSpinner(new SpinnerNumberModel(today.getMonthValue(), 1, 12, 1));
		StartTimeSpinner[1].setEditor(new JSpinner.NumberEditor(StartTimeSpinner[1], "00"));
		StartTimeSpinner[1].addChangeListener(new StartSpinnerChangeListener());
		StartTimeSpinner[2] = new JSpinner(new SpinnerNumberModel(today.getDayOfMonth(), 1, today.toLocalDate().lengthOfMonth(), 1));
		StartTimeSpinner[2].setEditor(new JSpinner.NumberEditor(StartTimeSpinner[2], "00"));
		StartTimeSpinner[3] = new JSpinner(new SpinnerNumberModel(today.getHour(), 0, 23, 1));
		StartTimeSpinner[3].setEditor(new JSpinner.NumberEditor(StartTimeSpinner[3], "00"));
		StartTimeSpinner[4] = new JSpinner(new SpinnerNumberModel(0, 0, 45, 15));

		EndTimeSpinner = new JSpinner[5];
		for (JSpinner s : EndTimeSpinner) {
			s = new JSpinner();
		}
		EndTimeSpinner[0] = new JSpinner(new SpinnerNumberModel(today.getYear(), null, null, 1));
		EndTimeSpinner[0].setEditor(new JSpinner.NumberEditor(EndTimeSpinner[0], "####"));
		EndTimeSpinner[0].addChangeListener(new EndSpinnerChangeListener());
		EndTimeSpinner[1] = new JSpinner(new SpinnerNumberModel(today.getMonthValue(), 1, 12, 1));
		EndTimeSpinner[1].setEditor(new JSpinner.NumberEditor(EndTimeSpinner[1], "00"));
		EndTimeSpinner[1].addChangeListener(new EndSpinnerChangeListener());
		EndTimeSpinner[2] = new JSpinner(new SpinnerNumberModel(today.getDayOfMonth(), 1, LocalDate.of((int) EndTimeSpinner[0].getValue(), (int) EndTimeSpinner[1].getValue(), 1).lengthOfMonth(), 1));
		EndTimeSpinner[2].setEditor(new JSpinner.NumberEditor(EndTimeSpinner[2], "00"));
		EndTimeSpinner[3] = new JSpinner(new SpinnerNumberModel(today.getHour(), 0, 23, 1));
		EndTimeSpinner[3].setEditor(new JSpinner.NumberEditor(EndTimeSpinner[3], "00"));
		EndTimeSpinner[4] = new JSpinner(new SpinnerNumberModel(0, 0, 45, 15));

		RepeatComboBox = new JComboBox<String>();
		RepeatComboBox
				.setModel(new DefaultComboBoxModel<String>(new String[] { "None", "Every year", "Every month", "Every week" }));

		JSpinner RepeatSpinner = new JSpinner();
		/*
		if (RepeatComboBox.getSelectedItem().toString().equals("None")) {
		} else if (RepeatComboBox.getSelectedItem().toString().equals("Every year")) {
			RepeatSpinner.setModel(new SpinnerDateModel(new Date(1591023600000L), null, null, Calendar.DAY_OF_YEAR));
			RepeatSpinner.setEditor(new JSpinner.DateEditor(RepeatSpinner, "MM/dd"));
		} else if (RepeatComboBox.getSelectedItem().toString().equals("Every month")) {
			RepeatSpinner.setModel(new SpinnerDateModel(new Date(1591023600000L), null, null, Calendar.DAY_OF_MONTH));
			RepeatSpinner.setEditor(new JSpinner.DateEditor(RepeatSpinner, "dd"));
		} else if (RepeatComboBox.getSelectedItem().toString().equals("Every week")) {
			RepeatSpinner.setModel(new SpinnerDateModel(new Date(1591023600000L), null, null, Calendar.DAY_OF_WEEK));
			RepeatSpinner.setEditor(new JSpinner.DateEditor(RepeatSpinner, "E"));
		}
		*/

		MemoTextField = new JTextField();
		MemoTextField.setColumns(10);
		NameTextField = new JTextField();
		NameTextField.setColumns(10);
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel
								.createSequentialGroup().addGap(
										5)
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING).addComponent(MemoLbl)
										.addComponent(ImpLbl).addComponent(CalLbl)
										.addGroup(gl_panel.createSequentialGroup()
												.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
														.addComponent(TdLbl, GroupLayout.PREFERRED_SIZE, 46,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(NameLbl, GroupLayout.PREFERRED_SIZE, 68,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																FdLbl, GroupLayout.PREFERRED_SIZE, 54,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(TLbl).addComponent(RLbl).addComponent(OLbl))
												.addGap(12)
												.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
														.addComponent(CheckBox[2]).addGroup(gl_panel
																.createParallelGroup(Alignment.LEADING).addComponent(
																		CheckBox[1])
																.addComponent(CheckBox[0])
																.addComponent(
																		NameTextField, GroupLayout.PREFERRED_SIZE,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.PREFERRED_SIZE)
																.addGroup(gl_panel.createSequentialGroup()
																		.addGroup(gl_panel
																				.createParallelGroup(Alignment.LEADING)
																				.addGroup(gl_panel
																						.createSequentialGroup()
																						.addComponent(
																								EndTimeSpinner[0],
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE)
																						.addPreferredGap(
																								ComponentPlacement.UNRELATED)
																						.addGroup(gl_panel
																								.createParallelGroup(
																										Alignment.LEADING)
																								.addGroup(gl_panel
																										.createSequentialGroup()
																										.addComponent(
																												EndTimeSpinner[3],
																												GroupLayout.PREFERRED_SIZE,
																												GroupLayout.DEFAULT_SIZE,
																												GroupLayout.PREFERRED_SIZE)
																										.addPreferredGap(
																												ComponentPlacement.UNRELATED)
																										.addComponent(
																												EndTimeSpinner[4],
																												GroupLayout.PREFERRED_SIZE,
																												GroupLayout.DEFAULT_SIZE,
																												GroupLayout.PREFERRED_SIZE))
																								.addGroup(gl_panel
																										.createSequentialGroup()
																										.addComponent(
																												EndTimeSpinner[1],
																												GroupLayout.PREFERRED_SIZE,
																												GroupLayout.DEFAULT_SIZE,
																												GroupLayout.PREFERRED_SIZE)
																										.addPreferredGap(
																												ComponentPlacement.UNRELATED)
																										.addComponent(
																												EndTimeSpinner[2],
																												GroupLayout.PREFERRED_SIZE,
																												GroupLayout.DEFAULT_SIZE,
																												GroupLayout.PREFERRED_SIZE))))
																				.addGroup(Alignment.TRAILING, gl_panel
																						.createSequentialGroup()
																						.addComponent(RepeatComboBox, 0,
																								77, Short.MAX_VALUE)
																						.addPreferredGap(
																								ComponentPlacement.RELATED)
																						.addComponent(RepeatSpinner,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE))
																				.addComponent(CheckBox[3])
																				.addGroup(gl_panel
																						.createSequentialGroup()
																						.addComponent(
																								StartTimeSpinner[0],
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE)
																						.addPreferredGap(
																								ComponentPlacement.UNRELATED)
																						.addGroup(gl_panel
																								.createParallelGroup(
																										Alignment.LEADING)
																								.addGroup(gl_panel
																										.createSequentialGroup()
																										.addComponent(
																												StartTimeSpinner[3],
																												GroupLayout.PREFERRED_SIZE,
																												GroupLayout.DEFAULT_SIZE,
																												GroupLayout.PREFERRED_SIZE)
																										.addPreferredGap(
																												ComponentPlacement.UNRELATED)
																										.addComponent(
																												StartTimeSpinner[4],
																												GroupLayout.PREFERRED_SIZE,
																												GroupLayout.DEFAULT_SIZE,
																												GroupLayout.PREFERRED_SIZE))
																								.addGroup(gl_panel
																										.createSequentialGroup()
																										.addComponent(
																												StartTimeSpinner[1],
																												GroupLayout.PREFERRED_SIZE,
																												GroupLayout.DEFAULT_SIZE,
																												GroupLayout.PREFERRED_SIZE)
																										.addPreferredGap(
																												ComponentPlacement.UNRELATED)
																										.addComponent(
																												StartTimeSpinner[2],
																												GroupLayout.PREFERRED_SIZE,
																												GroupLayout.DEFAULT_SIZE,
																												GroupLayout.PREFERRED_SIZE))))
																				.addComponent(CalendarComboBox,
																						GroupLayout.PREFERRED_SIZE, 87,
																						GroupLayout.PREFERRED_SIZE)
																				.addComponent(MemoTextField,
																						GroupLayout.PREFERRED_SIZE, 184,
																						GroupLayout.PREFERRED_SIZE))
																		.addPreferredGap(
																				ComponentPlacement.RELATED))))))
								.addGap(1091)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addGap(9)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(NameLbl).addComponent(
								NameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_panel
								.createParallelGroup(Alignment.BASELINE).addComponent(CheckBox[0]).addComponent(TdLbl))
						.addGap(18)
						.addGroup(gl_panel
								.createParallelGroup(Alignment.LEADING).addComponent(FdLbl).addComponent(CheckBox[1]))
						.addGap(18)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(TLbl)
								.addComponent(StartTimeSpinner[0], GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(StartTimeSpinner[1], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(StartTimeSpinner[2], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(StartTimeSpinner[3], GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(StartTimeSpinner[4], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(EndTimeSpinner[0], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(EndTimeSpinner[1], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(EndTimeSpinner[2], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(EndTimeSpinner[3], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(EndTimeSpinner[4], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(CalLbl).addComponent(
								CalendarComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_panel
								.createParallelGroup(Alignment.BASELINE).addComponent(OLbl).addComponent(CheckBox[2]))
						.addGap(18)
						.addGroup(gl_panel
								.createParallelGroup(Alignment.BASELINE).addComponent(ImpLbl).addComponent(CheckBox[3]))
						.addGap(18)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(RepeatComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(RLbl).addComponent(RepeatSpinner, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING).addComponent(MemoLbl).addComponent(
								MemoTextField, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(18, Short.MAX_VALUE)));
		panel.setLayout(gl_panel);

	}
	
	class StartSpinnerChangeListener implements ChangeListener {
		public void stateChanged(ChangeEvent e) {
			StartTimeSpinner[2].setModel(new SpinnerNumberModel(1, 1, LocalDate.of((int) StartTimeSpinner[0].getValue(), (int) StartTimeSpinner[1].getValue(), 1).lengthOfMonth(), 1));
		}
	}
	
	class EndSpinnerChangeListener implements ChangeListener {
		public void stateChanged(ChangeEvent e) {
			EndTimeSpinner[2].setModel(new SpinnerNumberModel(1, 1, LocalDate.of((int) EndTimeSpinner[0].getValue(), (int) EndTimeSpinner[1].getValue(), 1).lengthOfMonth(), 1));
		}
	}
}
