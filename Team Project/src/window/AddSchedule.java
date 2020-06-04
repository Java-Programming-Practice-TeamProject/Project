import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import net.miginfocom.swing.MigLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import javax.swing.SpinnerNumberModel;
import javax.swing.DefaultComboBoxModel;

public class AddSchedule {

	private JFrame frame;
	private JTextField NametextField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddSchedule window = new AddSchedule();
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
	public AddSchedule() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 294, 609);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		frame.getContentPane().add(panel_2, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("Submit");
		panel_2.add(btnNewButton);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.WEST);
		
		JLabel Name = new JLabel("Name");
		
		JLabel lblNewLabel_1 = new JLabel("TODO");
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("");
		
		JLabel lblNewLabel_2 = new JLabel("Full day");
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("");
		
		JLabel lblNewLabel_3 = new JLabel("Time");
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerDateModel(new Date(1591023600000L), null, null, Calendar.YEAR));
		spinner.setEditor(new JSpinner.DateEditor(spinner, "yyyy"));
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerDateModel(new Date(1591023600000L), null, null, Calendar.MONTH));
		spinner_1.setEditor(new JSpinner.DateEditor(spinner_1, "MM"));
		
		JSpinner spinner_2 = new JSpinner();
		spinner_2.setModel(new SpinnerDateModel(new Date(1591023600000L), null, null, Calendar.DAY_OF_MONTH));
		spinner_2.setEditor(new JSpinner.DateEditor(spinner_2, "dd"));
		
		JSpinner spinner_3 = new JSpinner();
		spinner_3.setModel(new SpinnerDateModel(new Date(1591023600000L), null, null, Calendar.HOUR_OF_DAY));
		spinner_3.setEditor(new JSpinner.DateEditor(spinner_3, "HH"));
		
		JSpinner spinner_4 = new JSpinner();
		spinner_4.setModel(new SpinnerNumberModel(0, 0, 45, 15));
		
		JSpinner spinner_5 = new JSpinner();
		spinner_5.setModel(new SpinnerDateModel(new Date(1591023600000L), null, null, Calendar.YEAR));
		spinner_5.setEditor(new JSpinner.DateEditor(spinner_5, "yyyy"));

		
		JSpinner spinner_1_1 = new JSpinner();
		spinner_1_1.setModel(new SpinnerDateModel(new Date(1591023600000L), null, null, Calendar.HOUR_OF_DAY));
		spinner_1_1.setEditor(new JSpinner.DateEditor(spinner_1_1, "MM"));

		
		JSpinner spinner_2_1 = new JSpinner();
		spinner_2_1.setModel(new SpinnerDateModel(new Date(1591023600000L), null, null, Calendar.DAY_OF_MONTH));
		spinner_2_1.setEditor(new JSpinner.DateEditor(spinner_2_1, "dd"));

		
		JSpinner spinner_3_1 = new JSpinner();
		spinner_3_1.setModel(new SpinnerDateModel(new Date(1591023600000L), null, null, Calendar.MONTH));
		spinner_3_1.setEditor(new JSpinner.DateEditor(spinner_3_1, "HH"));

		
		JSpinner spinner_4_1 = new JSpinner();
		spinner_4_1.setModel(new SpinnerNumberModel(0, 0, 45, 15));

		
		JLabel lblNewLabel_4 = new JLabel("Calendar");
		
		JComboBox comboBox = new JComboBox();
		
		JLabel lblNewLabel_5 = new JLabel("Overlap");
		
		JCheckBox chckbxNewCheckBox_2 = new JCheckBox("");
		
		JLabel lblNewLabel_6 = new JLabel("Important");
		
		JCheckBox chckbxNewCheckBox_3 = new JCheckBox("");
		
		JLabel lblNewLabel_7 = new JLabel("Repeat");
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"None","Every year", "Every month", "Every week"}));
		
		JSpinner spinner_6 = new JSpinner();
		if(comboBox_1.getSelectedItem().toString().equals("None")) {
		}
		else if(comboBox_1.getSelectedItem().toString().equals("Every year")) {
			spinner_6.setModel(new SpinnerDateModel(new Date(1591023600000L), null, null, Calendar.DAY_OF_YEAR));
			spinner_6.setEditor(new JSpinner.DateEditor(spinner_6, "MM/dd"));
		}
		else if(comboBox_1.getSelectedItem().toString().equals("Every month")) {
			spinner_6.setModel(new SpinnerDateModel(new Date(1591023600000L), null, null, Calendar.DAY_OF_MONTH));
			spinner_6.setEditor(new JSpinner.DateEditor(spinner_6, "dd"));
		}
		else if(comboBox_1.getSelectedItem().toString().equals("Every week")) {
			spinner_6.setModel(new SpinnerDateModel(new Date(1591023600000L), null, null, Calendar.DAY_OF_WEEK));
			spinner_6.setEditor(new JSpinner.DateEditor(spinner_6, "E"));
		}

		
		JLabel lblNewLabel_8 = new JLabel("Memo");
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		NametextField = new JTextField();
		NametextField.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_8)
						.addComponent(lblNewLabel_6)
						.addComponent(lblNewLabel_4)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
								.addComponent(Name, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_3)
								.addComponent(lblNewLabel_7)
								.addComponent(lblNewLabel_5))
							.addGap(12)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(chckbxNewCheckBox_2)
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
									.addComponent(chckbxNewCheckBox_1)
									.addComponent(chckbxNewCheckBox)
									.addComponent(NametextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGroup(gl_panel.createSequentialGroup()
										.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
											.addGroup(gl_panel.createSequentialGroup()
												.addComponent(spinner_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.UNRELATED)
												.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
													.addGroup(gl_panel.createSequentialGroup()
														.addComponent(spinner_3_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.UNRELATED)
														.addComponent(spinner_4_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
													.addGroup(gl_panel.createSequentialGroup()
														.addComponent(spinner_1_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.UNRELATED)
														.addComponent(spinner_2_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
											.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
												.addComponent(comboBox_1, 0, 77, Short.MAX_VALUE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(spinner_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
											.addComponent(chckbxNewCheckBox_3)
											.addGroup(gl_panel.createSequentialGroup()
												.addComponent(spinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.UNRELATED)
												.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
													.addGroup(gl_panel.createSequentialGroup()
														.addComponent(spinner_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.UNRELATED)
														.addComponent(spinner_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
													.addGroup(gl_panel.createSequentialGroup()
														.addComponent(spinner_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.UNRELATED)
														.addComponent(spinner_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
											.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
											.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(ComponentPlacement.RELATED))))))
					.addGap(1091))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(9)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(Name)
						.addComponent(NametextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(chckbxNewCheckBox)
						.addComponent(lblNewLabel_1))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_2)
						.addComponent(chckbxNewCheckBox_1))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(spinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(spinner_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(spinner_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(spinner_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(spinner_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(spinner_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(spinner_1_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(spinner_2_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(spinner_3_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(spinner_4_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_5)
						.addComponent(chckbxNewCheckBox_2))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_6)
						.addComponent(chckbxNewCheckBox_3))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_7)
						.addComponent(spinner_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_8)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(18, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		

	}

}
