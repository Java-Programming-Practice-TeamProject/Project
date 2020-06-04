package window;

import scheduler.*;
import java.util.ArrayList;
import java.awt.Dimension;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class WeeklyScheduleFrame extends JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = 160699328481387563L;
	private JTable table_2;
	private JTable table_3;

	public WeeklyScheduleFrame(ArrayList<ArrayList<Schedule>> schedule) {
		getContentPane().setMinimumSize(new Dimension(600, 700));
		setMinimumSize(new Dimension(600, 700));
		getContentPane().setSize(new Dimension(500, 500));
		setBounds(100, 100, 510, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(600, 150));
		getContentPane().add(panel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setPreferredSize(new Dimension(3000, 50));
		panel_2.setSize(new Dimension(500, 100));
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uC77C");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(35, 22, 75, 15);
		panel_2.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uC6D4");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(112, 22, 75, 15);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\uD654");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(188, 22, 75, 15);
		panel_2.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\uC218");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(265, 22, 75, 15);
		panel_2.add(lblNewLabel_3);
		
		JLabel lblNewLabel_1_1 = new JLabel("\uBAA9");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setBounds(340, 22, 75, 15);
		panel_2.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("\uAE08");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setBounds(415, 22, 75, 15);
		panel_2.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_4 = new JLabel("\uD1A0");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(499, 22, 75, 15);
		panel_2.add(lblNewLabel_4);
		
		JPanel panel_1 = new JPanel();
		panel_1.setPreferredSize(new Dimension(600, 500));
		getContentPane().add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
		
		JPanel panel_3 = new JPanel();
		panel_3.setMinimumSize(new Dimension(500, 23));
		JScrollPane scrollPane = new JScrollPane(panel_3);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		panel_1.add(scrollPane);
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.X_AXIS));
		
		table_2 = new JTable();
		table_2.setModel(new DefaultTableModel(
			new Object[][] {
				{"00:00"},
				{"00:15"},
				{"00:30"},
				{"00:45"},
				{"01:00"},
				{"01:15"},
				{"01:30"},
				{"01:45"},
				{"02:00"},
				{"02:15"},
				{"02:30"},
				{"02:45"},
				{"03:00"},
				{"03:15"},
				{"03:30"},
				{"03:45"},
				{"04:00"},
				{"04:15"},
				{"04:30"},
				{"04:45"},
				{"05:00"},
				{"05:15"},
				{"05:30"},
				{"05:45"},
				{"06:00"},
				{"06:15"},
				{"06:30"},
				{"06:45"},
				{"07:00"},
				{"07:15"},
				{"07:30"},
				{"07:45"},
				{"08:00"},
				{"08:15"},
				{"08:30"},
				{"08:45"},
				{"09:00"},
				{"09:15"},
				{"09:30"},
				{"09:45"},
				{"10:00"},
				{"10:15"},
				{"10:30"},
				{"10:45"},
				{"11:00"},
				{"11:15"},
				{"11:30"},
				{"11:45"},
				{"12:00"},
				{"12:15"},
				{"12:30"},
				{"12:45"},
				{"13:00"},
				{"13:15"},
				{"13:30"},
				{"13:45"},
				{"14:00"},
				{"14:15"},
				{"14:30"},
				{"14:45"},
				{"15:00"},
				{"15:15"},
				{"15:30"},
				{"15:45"},
				{"16:00"},
				{"16:15"},
				{"16:30"},
				{"16:45"},
				{"17:00"},
				{"17:15"},
				{"17:30"},
				{"17:45"},
				{"18:00"},
				{"18:15"},
				{"18:30"},
				{"18:45"},
				{"19:00"},
				{"19:15"},
				{"19:30"},
				{"19:45"},
				{"20:00"},
				{"20:15"},
				{"20:30"},
				{"20:45"},
				{"21:00"},
				{"21:15"},
				{"21:30"},
				{"21:45"},
				{"22:00"},
				{"22:15"},
				{"22:30"},
				{"22:45"},
				{"23:00"},
				{"23:15"},
				{"23:30"},
				{"23:45"},
			},
			new String[] {
				"New column"
			}
		));
		table_2.getColumnModel().getColumn(0).setPreferredWidth(30);
		panel_3.add(table_2);
		
		String[][] scheduleArray = new String[96][7];
		for(int i = 0; i < 7; i++) {
			for(Schedule s : schedule.get(i)) {
				if (s instanceof FullDaySchedule) {
					continue;
				}
				int start_hour = ((NormalSchedule) s).getStartTime().getHour(), start_min = ((NormalSchedule) s).getStartTime().getMinute();
				int end_hour = ((NormalSchedule) s).getEndTime().getHour(), end_min = ((NormalSchedule) s).getEndTime().getMinute();
				int start_x = (start_hour * 60 + start_min) / 15, end_x = (end_hour * 60 + end_min) / 15;
				for (int j = start_x; j < end_x; j++) {
					scheduleArray[j][i] = s.getName();
				}
			}
		}

		table_3 = new JTable();
		table_3.setModel(new DefaultTableModel(
			scheduleArray,
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		panel_3.add(table_3);
	}
}
