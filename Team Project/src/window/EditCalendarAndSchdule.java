import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import java.awt.Component;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.MultipleGradientPaint.ColorSpaceType;

public class EditCalendarAndSchdule {

	private JFrame frame;
	private JTextField textField_2;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditCalendarAndSchdule window = new EditCalendarAndSchdule();
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
	public EditCalendarAndSchdule() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		BorderLayout borderLayout = (BorderLayout) frame.getContentPane().getLayout();
		borderLayout.setVgap(20);
		frame.setBounds(100, 100, 328, 273);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 10));
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.NORTH);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_7 = new JPanel();
		panel_2.add(panel_7, BorderLayout.NORTH);
		
		JLabel lblNewLabel_1 = new JLabel("Add Calendar");
		lblNewLabel_1.setPreferredSize(new Dimension(90, 15));
		panel_7.add(lblNewLabel_1);
		
		JPanel panel_8 = new JPanel();
		panel_2.add(panel_8, BorderLayout.SOUTH);
		panel_8.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_2 = new JLabel("Name");
		lblNewLabel_2.setPreferredSize(new Dimension(50, 15));
		panel_8.add(lblNewLabel_2);
		
		textField = new JTextField();
		panel_8.add(textField);
		textField.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Red", "Yellow", "Green", "Blue", "Puple"}));
		panel_8.add(comboBox);
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_5 = new JPanel();
		panel_3.add(panel_5, BorderLayout.NORTH);
		
		JLabel lblNewLabel_3 = new JLabel("Delete Calendar");
		lblNewLabel_3.setPreferredSize(new Dimension(100, 15));
		panel_5.add(lblNewLabel_3);
		
		JPanel panel_6 = new JPanel();
		panel_3.add(panel_6, BorderLayout.SOUTH);
		
		JLabel lblNewLabel_4 = new JLabel("Name");
		lblNewLabel_4.setPreferredSize(new Dimension(50, 15));
		panel_6.add(lblNewLabel_4);
		
		textField_2 = new JTextField();
		panel_6.add(textField_2);
		textField_2.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		panel.add(panel_4, BorderLayout.SOUTH);
		panel_4.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("Add Schedule");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setPreferredSize(new Dimension(90, 15));
		panel_4.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("Cilck");
		panel_4.add(btnNewButton_1);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		
		JButton btnNewButton = new JButton("New button");
		panel_1.add(btnNewButton);
	}

}
