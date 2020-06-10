import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.border.CompoundBorder;
import javax.swing.JLabel;
import javax.swing.ScrollPaneConstants;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.time.LocalDateTime;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import net.miginfocom.swing.MigLayout;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Component;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import java.awt.Font;

public class WeeklyScheduleFrame {

	private JFrame frame;
	JPanel panel;

	/**
	 * test
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WeeklyScheduleFrame window = new WeeklyScheduleFrame();
					window.ShowWeeklyFrame(2);
					window.frame.setVisible(true);
					showweeklyschedule(panel,"11111222223333344444555556666677777",0 ,20, 30, Color.YELLOW,1,0,2);
					showweeklyschedule(panel,"ab",1 ,4, 5, Color.YELLOW,2,1,2);
					showweeklyschedule(panel,"1111122222333334",1 ,4, 8, Color.MAGENTA,2,0,2);
					showweeklyalldayschedule(panel,"Test1Test1Test1",5,Color.PINK,0);
					showweeklyalldayschedule(panel,"Test2Test2Test2",5,Color.WHITE,1);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		

	}
	*/
	
	public WeeklyScheduleFrame(ArrayList<ArrayList<Schedule>> schedule){
		int maxnumofallday = 0;
		for(int i=0;i<7;i++) {
			int numofallday = 0;
			for (Schedule s : schedule[i]) {
				if(s instanceof FullDaySchedule) {
					numofallday++;
				}
			}
			if(numofallday>maxnumofallday) {
				maxnumofallday = numofallday;
			}
		}
		ShowWeeklyFrame(maxnumofallday);
		for(int i=0;i<7;i++) {
			int alldayorder = 0;
			for(Schedule s : schedule[i]) {
				int[][] overlap = new int[96][100];
				if(s instanceof FullDaySchedule) {
					showweeklyalldayschedule(panel,s.getname(),i,s.getcolor(), alldayorder++);
				}else {
					LocalDateTime starttime = s.getTime();
					int intstarttime = starttime.getHour()*4+starttime.getMinute()%15;
					LocalDateTime endtime = s.getTime();
					int intendtime = endtime.getHour()*4+endtime.getMinute()%15;
					
					int order = 0;
					
					if(overlap[intstarttime][0]==0&&overlap[intendtime][0]==0) {
						order = 0;
						for(int j=intstarttime;j<intendtime;j++) {
							overlap[j][0]++;
						}
					}
					else if(overlap[intstarttime][0]!=0){
						int j = 0;
						while(overlap[intstarttime][j]!=0) {
							j++;
						}
						while(overlap[intendtime][j]!=0) {
							j++;
						}
						for(int k=intstarttime;k<intendtime;k++) {
							overlap[k][j]++;
						}
						order = j;
					}
					else if(overlap[intendtime][0]!=0) {
						int j = 0;
						while(overlap[intendtime][j]!=0) {
							j++;
						}
						while(overlap[intstarttime][j]!=0) {
							j++;
						}
						for(int k=intstarttime;k<intendtime;k++) {
							overlap[k][j]++;
						}
						order = j;
					}
					int num = 0;
					for(int j=0;j<96;j++) {
						int sum = 0;
						for(int k=0;k<100;k++) {
							sum+=overlap[j][k];
						}
						if(sum>num) {
							sum = num;
						}
					}
	
					
					showweeklyschedule(panel,s.getname(),i,intstarttime, intendtime, s.getcolor(), num, order, maxnumofallday);
				}
			}
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void ShowWeeklyFrame(int maxnumofallday) {
		frame = new JFrame();
		frame.getContentPane().setMinimumSize(new Dimension(1430, 700));
		frame.setMinimumSize(new Dimension(1430, 700));
		frame.getContentPane().setSize(new Dimension(500, 500));
		frame.setBounds(100, 100, 510, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		
		JPanel panel_1 = new JPanel();
		panel_1.setPreferredSize(new Dimension(1430, 500));
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
		
		JPanel panel_3 = new JPanel();
		panel_3.setMinimumSize(new Dimension(1400, 23));
		JScrollPane scrollPane = new JScrollPane(panel_3);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		panel_1.add(scrollPane);
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.X_AXIS));
		
		this.panel = new JPanel();
		JPanel panel_4 = this.panel;
		panel_3.add(panel_4);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		panel_4.setLayout(gbl_panel_4);
		
		JPanel first_panel = new JPanel();
		GridBagConstraints first_gridbag = new GridBagConstraints();
		first_gridbag.gridx = 0;
		first_gridbag.gridy = 0;
		panel_4.add(first_panel,first_gridbag);
		
		JPanel[] panel_times = new JPanel[96];
		GridBagConstraints[] times_constraints = new GridBagConstraints[96];
		for(int i=0;i<96;i++) {
			panel_times[i] = new JPanel();
			times_constraints[i] = new GridBagConstraints();
			times_constraints[i].gridx = 0;
			times_constraints[i].gridy = i+3+maxnumofallday;
			times_constraints[i].gridheight = 1;
			times_constraints[i].gridwidth = 1;
			
			String temp = Integer.toString(i/4);
			if(i/4<10)
				temp = "0".concat(temp);
			temp = temp.concat(":");
			if(i%4==0)
				temp = temp.concat("0");
			temp = temp.concat(Integer.toString(i%4 *15));
			panel_times[i].add(new JLabel(temp));
			
			panel_4.add(panel_times[i],times_constraints[i]);
		}
		
		JPanel[] panel_dates = new JPanel[8];
		GridBagConstraints[] dates_constraints = new GridBagConstraints[8];
		for(int i=0;i<7;i++) {
			panel_dates[i] = new JPanel();
			if(i%2==0)
				panel_dates[i].setBackground(Color.yellow);
			dates_constraints[i] = new GridBagConstraints();
			dates_constraints[i].gridx = i*6+1;
			dates_constraints[i].gridy = 0;
			dates_constraints[i].gridwidth = 6;
			dates_constraints[i].gridheight = 1;
			
			panel_4.add(panel_dates[i],dates_constraints[i]);
		}
		
		panel_dates[0].add(new JLabel("                         Sun                         "));
		panel_dates[1].add(new JLabel("                         Mon                         "));
		panel_dates[2].add(new JLabel("                         Tue                         "));
		panel_dates[3].add(new JLabel("                         Wed                         "));
		panel_dates[4].add(new JLabel("                         Thu                         "));
		panel_dates[5].add(new JLabel("                         Fri                         "));
		panel_dates[6].add(new JLabel("                         Sat                         "));
		
		JSeparator sep = new JSeparator(JSeparator.HORIZONTAL);
		GridBagConstraints gridsep = new GridBagConstraints();
		gridsep.gridx = 1;
		gridsep.gridy = 1;
		gridsep.gridheight = 1;
		gridsep.gridwidth = 6*7;
		sep.setPreferredSize(new Dimension(1400,1));
		panel_4.add(sep,gridsep);
		
		JSeparator sep1 = new JSeparator(JSeparator.HORIZONTAL);
		GridBagConstraints gridsep1 = new GridBagConstraints();
		gridsep1.gridx = 1;
		gridsep1.gridy = 2+maxnumofallday;
		gridsep1.gridheight = 1;
		gridsep1.gridwidth = 6*7;
		sep1.setPreferredSize(new Dimension(1400,1));
		panel_4.add(sep1,gridsep1);
	}
	/*
	 * panel : Gridbag panel
	 * name : name of schedule
	 * date : day of week : sun-0, mon-1, tue-2,..., sat-6
	 * starttime, endtime : hour*4+minute%15
	 * Color : color of calendar
	 * num : number of overlapped schedule
	 * order : order of this schedule among overlapped schedule
	 * numofallday : maximum number of allday schedule of the week
	 */
	static void showweeklyschedule(JPanel panel,String name,int date ,int starttime, int endtime, Color color,int num, int order, int numofallday) {
		JPanel paneltemp = new JPanel();
		
		paneltemp.setPreferredSize(new Dimension(210/num,(endtime-starttime)*30));
		paneltemp.setBackground(color);
		GridBagConstraints gridbagtemp = new GridBagConstraints();	
			
		gridbagtemp.gridy = 3+starttime+numofallday;
		gridbagtemp.gridheight = endtime-starttime;
		gridbagtemp.gridx = 1+date*6+order*(6/num);
		gridbagtemp.gridwidth = 6/num;		
		
		if (name.length()>8&&num>2){
			name = name.substring(0, 8)+"<br>"+name.substring(8,name.length());
		}
		name = "<html>"+name+"</html>";
		JLabel temp = new JLabel(name);
		temp.setFont(new Font("굴림",Font.PLAIN, 9));
		paneltemp.add(temp);
		panel.add(paneltemp,gridbagtemp);
		
	}
	/*
	 * panel : Gridbag panel
	 * name : name of schedule
	 * date : day of week : sun-0, mon-1, tue-2,..., sat-6
	 * Color : color of calendar
	 * order : order of this schedule among same day schedules
	 */
	static void showweeklyalldayschedule(JPanel panel,String name,int date ,Color color, int order) {
		JPanel paneltemp = new JPanel();
		
		paneltemp.setPreferredSize(new Dimension(210,30));
		paneltemp.setBackground(color);
		GridBagConstraints gridbagtemp = new GridBagConstraints();	
			
		gridbagtemp.gridy = 2+order;
		gridbagtemp.gridheight = 1;
		gridbagtemp.gridx = 1+date*6;
		gridbagtemp.gridwidth = 6;
		
		JLabel temp = new JLabel(name);
		temp.setFont(new Font("굴림",Font.PLAIN, 9));
		paneltemp.add(temp);
		panel.add(paneltemp,gridbagtemp);
	}
}
