import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import java.awt.CardLayout;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;

public class ShowSchedule {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShowSchedule window = new ShowSchedule();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ShowSchedule() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 371, 534);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		JPanel panel_1 = new JPanel();
		JScrollPane scrollPane = new JScrollPane(panel_1);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2);
		
		JPanel panel_3_1_1 = new JPanel();
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Time");
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Name");
		
		JCheckBox chckbxNewCheckBox_1_1 = new JCheckBox("");
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		GroupLayout gl_panel_3_1_1 = new GroupLayout(panel_3_1_1);
		gl_panel_3_1_1.setHorizontalGroup(
			gl_panel_3_1_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 357, Short.MAX_VALUE)
				.addGroup(gl_panel_3_1_1.createSequentialGroup()
					.addGap(19)
					.addComponent(lblNewLabel_1_1_1)
					.addGap(5)
					.addComponent(lblNewLabel_2_1_1)
					.addGap(5)
					.addComponent(chckbxNewCheckBox_1_1))
				.addComponent(textField_2, GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE)
		);
		gl_panel_3_1_1.setVerticalGroup(
			gl_panel_3_1_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 123, Short.MAX_VALUE)
				.addGroup(gl_panel_3_1_1.createSequentialGroup()
					.addGroup(gl_panel_3_1_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_3_1_1.createSequentialGroup()
							.addGap(9)
							.addComponent(lblNewLabel_1_1_1))
						.addGroup(gl_panel_3_1_1.createSequentialGroup()
							.addGap(9)
							.addComponent(lblNewLabel_2_1_1))
						.addGroup(gl_panel_3_1_1.createSequentialGroup()
							.addGap(5)
							.addComponent(chckbxNewCheckBox_1_1)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_3_1_1.setLayout(gl_panel_3_1_1);
		
		JPanel panel_3_2 = new JPanel();
		
		JLabel lblNewLabel_1_2 = new JLabel("Time");
		
		JLabel lblNewLabel_2_2 = new JLabel("Name");
		
		JCheckBox chckbxNewCheckBox_2 = new JCheckBox("");
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		GroupLayout gl_panel_3_2 = new GroupLayout(panel_3_2);
		gl_panel_3_2.setHorizontalGroup(
			gl_panel_3_2.createParallelGroup(Alignment.LEADING)
				.addGap(0, 357, Short.MAX_VALUE)
				.addGroup(gl_panel_3_2.createSequentialGroup()
					.addGap(19)
					.addComponent(lblNewLabel_1_2)
					.addGap(5)
					.addComponent(lblNewLabel_2_2)
					.addGap(5)
					.addComponent(chckbxNewCheckBox_2))
				.addComponent(textField_3, GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE)
		);
		gl_panel_3_2.setVerticalGroup(
			gl_panel_3_2.createParallelGroup(Alignment.LEADING)
				.addGap(0, 103, Short.MAX_VALUE)
				.addGroup(gl_panel_3_2.createSequentialGroup()
					.addGroup(gl_panel_3_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_3_2.createSequentialGroup()
							.addGap(9)
							.addComponent(lblNewLabel_1_2))
						.addGroup(gl_panel_3_2.createSequentialGroup()
							.addGap(9)
							.addComponent(lblNewLabel_2_2))
						.addGroup(gl_panel_3_2.createSequentialGroup()
							.addGap(5)
							.addComponent(chckbxNewCheckBox_2)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField_3, GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE))
		);
		panel_3_2.setLayout(gl_panel_3_2);
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_3_1_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_3_2, GroupLayout.PREFERRED_SIZE, 357, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addComponent(panel_3_1_1, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_3_2, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
					.addGap(142))
		);
		panel_2.setLayout(gl_panel_2);
		
		JPanel panel = new JPanel();
		panel_1.add(panel);
		
		JPanel panel_3_1 = new JPanel();
		
		JLabel lblNewLabel_1_1 = new JLabel("Time");
		
		JLabel lblNewLabel_2_1 = new JLabel("Name");
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("");
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		GroupLayout gl_panel_3_1 = new GroupLayout(panel_3_1);
		gl_panel_3_1.setHorizontalGroup(
			gl_panel_3_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3_1.createSequentialGroup()
					.addGap(19)
					.addComponent(lblNewLabel_1_1)
					.addGap(5)
					.addComponent(lblNewLabel_2_1)
					.addGap(5)
					.addComponent(chckbxNewCheckBox_1))
				.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE)
		);
		gl_panel_3_1.setVerticalGroup(
			gl_panel_3_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3_1.createSequentialGroup()
					.addGroup(gl_panel_3_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_3_1.createSequentialGroup()
							.addGap(9)
							.addComponent(lblNewLabel_1_1))
						.addGroup(gl_panel_3_1.createSequentialGroup()
							.addGap(9)
							.addComponent(lblNewLabel_2_1))
						.addGroup(gl_panel_3_1.createSequentialGroup()
							.addGap(5)
							.addComponent(chckbxNewCheckBox_1)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(113, Short.MAX_VALUE))
		);
		panel_3_1.setLayout(gl_panel_3_1);
		
		JPanel panel_3 = new JPanel();
		
		JLabel lblNewLabel_1 = new JLabel("Time");
		
		JLabel lblNewLabel_2 = new JLabel("Name");
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("");
		
		textField = new JTextField();
		textField.setColumns(10);
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGap(19)
					.addComponent(lblNewLabel_1)
					.addGap(5)
					.addComponent(lblNewLabel_2)
					.addGap(5)
					.addComponent(chckbxNewCheckBox))
				.addComponent(textField, GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_3.createSequentialGroup()
							.addGap(9)
							.addComponent(lblNewLabel_1))
						.addGroup(gl_panel_3.createSequentialGroup()
							.addGap(9)
							.addComponent(lblNewLabel_2))
						.addGroup(gl_panel_3.createSequentialGroup()
							.addGap(5)
							.addComponent(chckbxNewCheckBox)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField, GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE))
		);
		panel_3.setLayout(gl_panel_3);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_3_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 357, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(panel_3_1, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
					.addGap(142))
		);
		panel.setLayout(gl_panel);
		
		JButton btnNewButton = new JButton("+");
		frame.getContentPane().add(btnNewButton, BorderLayout.SOUTH);
		
		JLabel lblNewLabel = new JLabel("2020.05.27");
		frame.getContentPane().add(lblNewLabel, BorderLayout.NORTH);
	}

}
