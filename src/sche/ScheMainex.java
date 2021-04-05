package sche;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

public class ScheMainex{

	private JFrame frame;
	private JLabel timeblock;
	private JLabel sayingBlock;
	private JTextField title;
	private JLabel vert;
	private JLabel horz;
	private JLabel emphasis;

	int i = 0; // ±Û±Í µ¹¸®±â
	int l = 0; // Å×¸¶ º¯°æ
	boolean c = true; // ½Ã°è ÀÛµ¿
	int dayofweek; // ¿äÀÏ;
	int min; // ºÐ Á¤¼ö
	int ampm; // ¿ÀÀü¿ÀÈÄ Á¤¼ö
	int hour; // ½Ã°£ Á¤¼ö
	String AmPm; // ¿ÀÀü¿ÀÈÄ ¹®ÀÚ
	double hortimeCount; // ¼öÁ÷¼± À§Ä¡ °áÁ¤
	int dayCount;
	int grCount;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScheMainex window = new ScheMainex();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void saying() {

		String[] say = new String[6];
		say[0] = "Áñ°Å¿ò°ú Çàµ¿¸¸À¸·Îµµ, ½Ã°£Àº ºÎÁ·ÇÏ´Ù.";
		say[1] = "¹«¾ùº¸´Ùµµ, ÁØºñ°¡ ¼º°øÀÇ ¿­¼èÀÌ´Ù.";
		say[2] = "¿ì¸®°¡ ½ÇÆÐ¿¡¼­ ¹è¿ì¸é, ½ÇÆÐ´Â ¼º°øÀÌ µÈ´Ù.";
		say[3] = "ÇÑ ¹ø ½ÇÆÐ¿Í ¿µ¿øÇÑ ½ÇÆÐ¸¦ È¥µ¿ÇÏÁö ¸¶¶ó.";
		say[4] = "ÃÖ´ëÇÑÀÇ »îÀ» »ì°í, ÃÖ´ëÇÑ ±àÁ¤ÀûÀÎ °Í¿¡ ÁýÁßÇÏÀÚ.";
		say[5] = "ÀÛÀº ±âÈ¸·Î ºÎÅÍ Á¾Á¾ À§´ëÇÑ ¾÷ÀûÀÌ ½ÃÀÛµÈ´Ù";

		Thread saying = new Thread() { // ¸í¾ð
			public void run() {
				try {

					while (true) {
						if (i != 5) {
							i++;
						} else {
							i = 0;
						}
						sayingBlock.setText("- " + say[i] + " -");
						sleep(10000);
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		saying.start();

	}

	public void fontColor() {
		Thread fontColor = new Thread() {
			public void run() {
				try {
					while (true) { // °­Á¶¼±
						if (dayCount == 1) {

						}

						sleep(1000);
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
			}

		};
		fontColor.start();
	}

	public void clock() { // ½Ã°è, ¼öÁ÷¼±, ¼öÆò¼±
		Thread clock = new Thread() {
			public void run() {
				try {
					while (c == true) {
						Calendar cal = new GregorianCalendar();
						int day = cal.get(Calendar.DAY_OF_MONTH);
						int month = cal.get(Calendar.MONTH);
						int sec = cal.get(Calendar.SECOND);
						min = cal.get(Calendar.MINUTE);
						hour = cal.get(Calendar.HOUR);
						ampm = cal.get(Calendar.AM_PM);
						AmPm = ampm == Calendar.AM ? "AM" : "PM";
						dayofweek = cal.get(Calendar.DAY_OF_WEEK);
						hortimeCount = (double) min;

						String Tempoampam = "";
						if (ampm == 1) {
							Tempoampam = "¿ÀÈÄ";
						} else if (ampm == 0) {
							Tempoampam = "¿ÀÀü";
						}

						timeblock.setText(" \" " + Tempoampam + " " + hour + "½Ã " + min + "ºÐ " + sec + "ÃÊ " + "\" ");

						
						if (min < 10) {
							hortimeCount = hour + (hortimeCount / 100);
						} else if (min >= 10) {
							hortimeCount = hour + (hortimeCount / 100);
						}

						System.out.println(AmPm);
						System.out.println(hortimeCount);

						if ((8.20 <= hortimeCount) && (hortimeCount <= 9.09) && AmPm == "AM") { // 1±³½Ã
							horz.setBounds(12, 138, 477, 40);
							grCount = 1;
						} else if ((9.10 <= hortimeCount) && (hortimeCount <= 10.09) && AmPm == "AM") { // 2±³½Ã
							horz.setBounds(12, 188, 477, 40);
							grCount = 2;
						} else if ((10.10 <= hortimeCount) && (hortimeCount <= 11.09) && AmPm == "AM") { // 3±³½Ã
							horz.setBounds(12, 238, 477, 40);
							grCount = 3;
						} else if ((11.10 <= hortimeCount) && (hortimeCount <= 11.59) && (0.01 <= hortimeCount) && (hortimeCount <= 0.10)) { // 4±³½Ã
							horz.setBounds(12, 288, 477, 40);
							grCount = 4;
						} else if ((0.10 <= hortimeCount) && (hortimeCount <= 1.09) && AmPm == "PM") { // Á¡½É
							horz.setBounds(12, 338, 477, 40);
							grCount = 10;
						} else if ((1.10 <= hortimeCount) && (hortimeCount <= 1.59) && AmPm == "PM") { // 5±³½Ã
							horz.setBounds(12, 388, 477, 40);
							grCount = 5;
						} else if ((2.0 <= hortimeCount) && (hortimeCount <= 2.59) && AmPm == "PM") { // 6±³½Ã
							horz.setBounds(12, 438, 477, 40);
							grCount = 6;
						} else if ((3.0 <= hortimeCount) && (hortimeCount <= 3.59) && AmPm == "PM") { // 7±³½Ã
							horz.setBounds(12, 488, 477, 40);
							grCount = 7;
						}

						if (dayofweek == 2) { // ¿ù¿äÀÏ
							vert.setBounds(101, 103, 68, 420);
							dayCount = 1;
						} else if (dayofweek == 3) { // È­¿äÀÏ
							vert.setBounds(181, 103, 68, 420);
							dayCount = 2;
						} else if (dayofweek == 4) { // ¼ö¿äÀÏ
							vert.setBounds(261, 103, 68, 420);
							dayCount = 3;
						} else if (dayofweek == 5) { // ¸ñ¿äÀÏ
							vert.setBounds(341, 103, 68, 420);
							dayCount = 4;
						} else if (dayofweek == 6) { // ±Ý¿äÀÏ
							vert.setBounds(421, 103, 68, 420);
							dayCount = 5;
						}

						sleep(1000);
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		clock.start();

	}

	/**
	 * Create the application.
	 */
	public ScheMainex() {
		initialize();
		clock();
		saying();
		fontColor();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		EtchedBorder eborder;
		eborder = new EtchedBorder(EtchedBorder.RAISED);

		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 520, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		frame.setTitle("ÀÏÁ¤Ç¥");

		timeblock = new JLabel();
		timeblock.setVerticalAlignment(SwingConstants.TOP);
		timeblock.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 14));
		timeblock.setForeground(Color.BLACK);
		timeblock.setBackground(SystemColor.menu);
		timeblock.setText("time");
		timeblock.setBounds(156, 10, 200, 40);
		timeblock.setHorizontalAlignment(JLabel.CENTER);
		frame.getContentPane().add(timeblock);

		sayingBlock = new JLabel("saying");
		sayingBlock.setHorizontalAlignment(JLabel.CENTER);
		sayingBlock.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 13));
		sayingBlock.setBounds(12, 621, 477, 40);
		sayingBlock.setHorizontalAlignment(JLabel.CENTER);
		frame.getContentPane().add(sayingBlock);

		JCheckBox just1 = new JCheckBox("\uC790\uAC00\uC9C4\uB2E8");
		just1.setForeground(Color.BLACK);
		just1.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 12));
		just1.setBounds(404, 10, 85, 23);
		just1.setBorderPainted(true);
		frame.getContentPane().add(just1);

		JCheckBox just2 = new JCheckBox("\uC870\uD68C\uCCB4\uD06C");
		just2.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 12));
		just2.setBounds(404, 42, 85, 23);
		just2.setBorderPainted(true);
		frame.getContentPane().add(just2);

		JCheckBox just3 = new JCheckBox("\uC885\uB840\uCCB4\uD06C");
		just3.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 12));
		just3.setBounds(404, 72, 85, 23);
		just3.setBorderPainted(true);
		frame.getContentPane().add(just3);

		title = new JTextField();
		title.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 20));
		title.setBackground(SystemColor.menu);
		title.setText("\uC2DC\uAC04\uD45C");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setBounds(156, 40, 200, 40);
		frame.getContentPane().add(title);
		title.setColumns(10);

		JLabel lblNewLabel = new JLabel("<HTML><body><center>1\uAD50\uC2DC<br>8:20~9:10</center></body></html>");
		lblNewLabel.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 11));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBackground(Color.LIGHT_GRAY);
		lblNewLabel.setBounds(12, 138, 77, 40);
		lblNewLabel.setBorder(eborder);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("<HTML><body><center>2\uAD50\uC2DC<br>9:20~10:10</center></body></html>");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 11));
		lblNewLabel_1.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_1.setBounds(12, 188, 77, 40);
		lblNewLabel_1.setBorder(eborder);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("<HTML><body><center>3\uAD50\uC2DC<br>10:20~11:10</center></body></html>");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 11));
		lblNewLabel_2.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_2.setBounds(12, 238, 77, 40);
		lblNewLabel_2.setBorder(eborder);
		frame.getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("<HTML><body><center>4\uAD50\uC2DC<br>11:20~12:10</center></body></html>");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setForeground(Color.BLACK);
		lblNewLabel_3.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 11));
		lblNewLabel_3.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_3.setBounds(12, 288, 77, 40);
		lblNewLabel_3.setBorder(eborder);
		frame.getContentPane().add(lblNewLabel_3);

		JLabel lblNewLabel_3_1 = new JLabel("<HTML><body><center>5\uAD50\uC2DC<br>1:10~2:0</center></body></html>");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setForeground(Color.BLACK);
		lblNewLabel_3_1.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 11));
		lblNewLabel_3_1.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_3_1.setBounds(12, 388, 77, 40);
		lblNewLabel_3_1.setBorder(eborder);
		frame.getContentPane().add(lblNewLabel_3_1);

		JLabel lblNewLabel_3_2 = new JLabel("<HTML><body><center>6\uAD50\uC2DC<br>2:10~3:0</center></body></html>");
		lblNewLabel_3_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_2.setForeground(Color.BLACK);
		lblNewLabel_3_2.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 11));
		lblNewLabel_3_2.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_3_2.setBounds(12, 438, 77, 40);
		lblNewLabel_3_2.setBorder(eborder);
		frame.getContentPane().add(lblNewLabel_3_2);

		JLabel lblNewLabel_3_3 = new JLabel(
				"<HTML><body><center>\uC810\uC2EC\uC2DC\uAC04<br>12:20~1:10</center></body></html>");
		lblNewLabel_3_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_3.setForeground(Color.BLACK);
		lblNewLabel_3_3.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 11));
		lblNewLabel_3_3.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_3_3.setBounds(12, 338, 77, 40);
		lblNewLabel_3_3.setBorder(eborder);
		frame.getContentPane().add(lblNewLabel_3_3);

		JLabel lblNewLabel_3_2_1 = new JLabel("<HTML><body><center>7\uAD50\uC2DC<br>3:10~4:0</center></body></html>");
		lblNewLabel_3_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_2_1.setForeground(Color.BLACK);
		lblNewLabel_3_2_1.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 11));
		lblNewLabel_3_2_1.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_3_2_1.setBounds(12, 488, 77, 40);
		lblNewLabel_3_2_1.setBorder(eborder);
		frame.getContentPane().add(lblNewLabel_3_2_1);

		JButton lightControl = new JButton("Å×¸¶ º¯°æ");
		lightControl.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 11));
		lightControl.setBounds(12, 8, 85, 23);
		frame.getContentPane().add(lightControl);

		JLabel mons = new JLabel("\uC6D4\uC694\uC77C");
		mons.setHorizontalAlignment(SwingConstants.CENTER);
		mons.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 13));
		mons.setBounds(101, 103, 68, 23);
		mons.setBorder(eborder);
		frame.getContentPane().add(mons);

		JLabel lblNewLabel_4_1 = new JLabel("\uD654\uC694\uC77C");
		lblNewLabel_4_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_1.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 13));
		lblNewLabel_4_1.setBounds(181, 103, 68, 23);
		lblNewLabel_4_1.setBorder(eborder);
		frame.getContentPane().add(lblNewLabel_4_1);

		JLabel lblNewLabel_4_2 = new JLabel("\uC218\uC694\uC77C");
		lblNewLabel_4_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_2.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 13));
		lblNewLabel_4_2.setBounds(261, 103, 68, 23);
		lblNewLabel_4_2.setBorder(eborder);
		frame.getContentPane().add(lblNewLabel_4_2);

		JLabel lblNewLabel_4_3 = new JLabel("\uBAA9\uC694\uC77C");
		lblNewLabel_4_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_3.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 13));
		lblNewLabel_4_3.setBounds(341, 103, 68, 23);
		lblNewLabel_4_3.setBorder(eborder);
		frame.getContentPane().add(lblNewLabel_4_3);

		JLabel fri = new JLabel("\uAE08\uC694\uC77C");
		fri.setHorizontalAlignment(SwingConstants.CENTER);
		fri.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 13));
		fri.setBounds(421, 103, 68, 23);
		fri.setBorder(eborder);
		frame.getContentPane().add(fri);

		JTextPane memopad = new JTextPane();
		memopad.setForeground(new Color(0, 0, 0));
		memopad.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 14));
		memopad.setText("\uD574\uC57C \uD560 \uAC83");
		memopad.setBounds(12, 538, 477, 82);
		memopad.setBorder(eborder);
		frame.getContentPane().add(memopad);

		JLabel t1_1 = new JLabel("\uC2A4\uC571");
		t1_1.setHorizontalAlignment(SwingConstants.CENTER);
		t1_1.setForeground(Color.BLACK);
		t1_1.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 11));
		t1_1.setBackground(Color.LIGHT_GRAY);
		t1_1.setBounds(101, 138, 68, 40);
		frame.getContentPane().add(t1_1);

		JLabel t1_2 = new JLabel("\uC2A4\uC571");
		t1_2.setHorizontalAlignment(SwingConstants.CENTER);
		t1_2.setForeground(Color.BLACK);
		t1_2.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 11));
		t1_2.setBackground(Color.LIGHT_GRAY);
		t1_2.setBounds(101, 188, 68, 40);
		frame.getContentPane().add(t1_2);

		JLabel t1_3 = new JLabel("\uC2A4\uC571");
		t1_3.setHorizontalAlignment(SwingConstants.CENTER);
		t1_3.setForeground(Color.BLACK);
		t1_3.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 11));
		t1_3.setBackground(Color.LIGHT_GRAY);
		t1_3.setBounds(101, 238, 68, 40);
		frame.getContentPane().add(t1_3);

		JLabel t1_4 = new JLabel("\uAD6D\uC0AC");
		t1_4.setHorizontalAlignment(SwingConstants.CENTER);
		t1_4.setForeground(Color.BLACK);
		t1_4.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 11));
		t1_4.setBackground(Color.LIGHT_GRAY);
		t1_4.setBounds(101, 288, 68, 40);
		frame.getContentPane().add(t1_4);

		JLabel t1_5 = new JLabel("\uC218\uD559");
		t1_5.setHorizontalAlignment(SwingConstants.CENTER);
		t1_5.setForeground(Color.BLACK);
		t1_5.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 11));
		t1_5.setBackground(Color.LIGHT_GRAY);
		t1_5.setBounds(101, 388, 68, 40);
		frame.getContentPane().add(t1_5);

		JLabel t1_6 = new JLabel("\uC0AC\uD68C");
		t1_6.setHorizontalAlignment(SwingConstants.CENTER);
		t1_6.setForeground(Color.BLACK);
		t1_6.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 11));
		t1_6.setBackground(Color.LIGHT_GRAY);
		t1_6.setBounds(101, 438, 68, 40);
		frame.getContentPane().add(t1_6);

		JLabel t1_7 = new JLabel("\uC601\uC5B4");
		t1_7.setHorizontalAlignment(SwingConstants.CENTER);
		t1_7.setForeground(Color.BLACK);
		t1_7.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 11));
		t1_7.setBackground(Color.LIGHT_GRAY);
		t1_7.setBounds(101, 488, 68, 40);
		frame.getContentPane().add(t1_7);

		JLabel t2_7 = new JLabel("\uC0AC\uD68C");
		t2_7.setHorizontalAlignment(SwingConstants.CENTER);
		t2_7.setForeground(Color.BLACK);
		t2_7.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 11));
		t2_7.setBackground(Color.LIGHT_GRAY);
		t2_7.setBounds(181, 488, 68, 40);
		frame.getContentPane().add(t2_7);

		JLabel t2_6 = new JLabel("\uC9C4\uB85C");
		t2_6.setHorizontalAlignment(SwingConstants.CENTER);
		t2_6.setForeground(Color.BLACK);
		t2_6.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 11));
		t2_6.setBackground(Color.LIGHT_GRAY);
		t2_6.setBounds(181, 438, 68, 40);
		frame.getContentPane().add(t2_6);

		JLabel t2_5 = new JLabel("\uBB38\uD559");
		t2_5.setHorizontalAlignment(SwingConstants.CENTER);
		t2_5.setForeground(Color.BLACK);
		t2_5.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 11));
		t2_5.setBackground(Color.LIGHT_GRAY);
		t2_5.setBounds(181, 388, 68, 40);
		frame.getContentPane().add(t2_5);

		JLabel t2_4 = new JLabel("\uCCB4\uC721");
		t2_4.setHorizontalAlignment(SwingConstants.CENTER);
		t2_4.setForeground(Color.BLACK);
		t2_4.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 11));
		t2_4.setBackground(Color.LIGHT_GRAY);
		t2_4.setBounds(181, 288, 68, 40);
		frame.getContentPane().add(t2_4);

		JLabel t2_3 = new JLabel("\uC218\uD559");
		t2_3.setHorizontalAlignment(SwingConstants.CENTER);
		t2_3.setForeground(Color.BLACK);
		t2_3.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 11));
		t2_3.setBackground(Color.LIGHT_GRAY);
		t2_3.setBounds(181, 238, 68, 40);
		frame.getContentPane().add(t2_3);

		JLabel t2_1 = new JLabel("\uACFC\uD559");
		t2_1.setHorizontalAlignment(SwingConstants.CENTER);
		t2_1.setForeground(Color.BLACK);
		t2_1.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 11));
		t2_1.setBackground(Color.LIGHT_GRAY);
		t2_1.setBounds(181, 138, 68, 40);
		frame.getContentPane().add(t2_1);

		JLabel t2_2 = new JLabel("\uC601\uC5B4");
		t2_2.setHorizontalAlignment(SwingConstants.CENTER);
		t2_2.setForeground(Color.BLACK);
		t2_2.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 11));
		t2_2.setBackground(Color.LIGHT_GRAY);
		t2_2.setBounds(181, 188, 68, 40);
		frame.getContentPane().add(t2_2);

		JLabel t3_7 = new JLabel("\uACF5\uC5C5");
		t3_7.setHorizontalAlignment(SwingConstants.CENTER);
		t3_7.setForeground(Color.BLACK);
		t3_7.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 11));
		t3_7.setBackground(Color.LIGHT_GRAY);
		t3_7.setBounds(261, 488, 68, 40);
		frame.getContentPane().add(t3_7);

		JLabel t3_6 = new JLabel("\uC77C\uC5B4");
		t3_6.setHorizontalAlignment(SwingConstants.CENTER);
		t3_6.setForeground(Color.BLACK);
		t3_6.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 11));
		t3_6.setBackground(Color.LIGHT_GRAY);
		t3_6.setBounds(261, 438, 68, 40);
		frame.getContentPane().add(t3_6);

		JLabel t3_5 = new JLabel("\uD2B9\uC0C9");
		t3_5.setHorizontalAlignment(SwingConstants.CENTER);
		t3_5.setForeground(Color.BLACK);
		t3_5.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 11));
		t3_5.setBackground(Color.LIGHT_GRAY);
		t3_5.setBounds(261, 388, 68, 40);
		frame.getContentPane().add(t3_5);

		JLabel t3_4 = new JLabel("\uACFC\uD559");
		t3_4.setHorizontalAlignment(SwingConstants.CENTER);
		t3_4.setForeground(Color.BLACK);
		t3_4.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 11));
		t3_4.setBackground(Color.LIGHT_GRAY);
		t3_4.setBounds(261, 288, 68, 40);
		frame.getContentPane().add(t3_4);

		JLabel t3_3 = new JLabel("\uC601\uC0C1");
		t3_3.setHorizontalAlignment(SwingConstants.CENTER);
		t3_3.setForeground(Color.BLACK);
		t3_3.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 11));
		t3_3.setBackground(Color.LIGHT_GRAY);
		t3_3.setBounds(261, 238, 68, 40);
		frame.getContentPane().add(t3_3);

		JLabel t3_1 = new JLabel("\uC601\uC0C1");
		t3_1.setHorizontalAlignment(SwingConstants.CENTER);
		t3_1.setForeground(Color.BLACK);
		t3_1.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 11));
		t3_1.setBackground(Color.LIGHT_GRAY);
		t3_1.setBounds(261, 138, 68, 40);
		frame.getContentPane().add(t3_1);

		JLabel t3_2 = new JLabel("\uC601\uC0C1");
		t3_2.setHorizontalAlignment(SwingConstants.CENTER);
		t3_2.setForeground(Color.BLACK);
		t3_2.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 11));
		t3_2.setBackground(Color.LIGHT_GRAY);
		t3_2.setBounds(261, 188, 68, 40);
		frame.getContentPane().add(t3_2);

		JLabel t4_7 = new JLabel("\uC601\uC5B4");
		t4_7.setHorizontalAlignment(SwingConstants.CENTER);
		t4_7.setForeground(Color.BLACK);
		t4_7.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 11));
		t4_7.setBackground(Color.LIGHT_GRAY);
		t4_7.setBounds(341, 488, 68, 40);
		frame.getContentPane().add(t4_7);

		JLabel t4_6 = new JLabel("\uACF5\uC5C5");
		t4_6.setHorizontalAlignment(SwingConstants.CENTER);
		t4_6.setForeground(Color.BLACK);
		t4_6.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 11));
		t4_6.setBackground(Color.LIGHT_GRAY);
		t4_6.setBounds(341, 438, 68, 40);
		frame.getContentPane().add(t4_6);

		JLabel t4_5 = new JLabel("\uAD6D\uC0AC");
		t4_5.setHorizontalAlignment(SwingConstants.CENTER);
		t4_5.setForeground(Color.BLACK);
		t4_5.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 11));
		t4_5.setBackground(Color.LIGHT_GRAY);
		t4_5.setBounds(341, 388, 68, 40);
		frame.getContentPane().add(t4_5);

		JLabel t4_4 = new JLabel("\uC2A4\uC571");
		t4_4.setHorizontalAlignment(SwingConstants.CENTER);
		t4_4.setForeground(Color.BLACK);
		t4_4.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 11));
		t4_4.setBackground(Color.LIGHT_GRAY);
		t4_4.setBounds(341, 288, 68, 40);
		frame.getContentPane().add(t4_4);

		JLabel t4_3 = new JLabel("\uC2A4\uC571");
		t4_3.setHorizontalAlignment(SwingConstants.CENTER);
		t4_3.setForeground(Color.BLACK);
		t4_3.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 11));
		t4_3.setBackground(Color.LIGHT_GRAY);
		t4_3.setBounds(341, 238, 68, 40);
		frame.getContentPane().add(t4_3);

		JLabel t4_1 = new JLabel("\uC77C\uC5B4");
		t4_1.setHorizontalAlignment(SwingConstants.CENTER);
		t4_1.setForeground(Color.BLACK);
		t4_1.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 11));
		t4_1.setBackground(Color.LIGHT_GRAY);
		t4_1.setBounds(341, 138, 68, 40);
		frame.getContentPane().add(t4_1);

		JLabel t4_2 = new JLabel("\uBB38\uD559");
		t4_2.setHorizontalAlignment(SwingConstants.CENTER);
		t4_2.setForeground(Color.BLACK);
		t4_2.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 11));
		t4_2.setBackground(Color.LIGHT_GRAY);
		t4_2.setBounds(341, 188, 68, 40);
		frame.getContentPane().add(t4_2);

		JLabel t5_6 = new JLabel("\uB3D9\uC544\uB9AC");
		t5_6.setHorizontalAlignment(SwingConstants.CENTER);
		t5_6.setForeground(Color.BLACK);
		t5_6.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 11));
		t5_6.setBackground(Color.LIGHT_GRAY);
		t5_6.setBounds(421, 438, 68, 40);
		frame.getContentPane().add(t5_6);

		JLabel t5_5 = new JLabel("\uC790\uC728");
		t5_5.setHorizontalAlignment(SwingConstants.CENTER);
		t5_5.setForeground(Color.BLACK);
		t5_5.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 11));
		t5_5.setBackground(Color.LIGHT_GRAY);
		t5_5.setBounds(421, 388, 68, 40);
		frame.getContentPane().add(t5_5);

		JLabel t5_4 = new JLabel("\uC218\uD559");
		t5_4.setHorizontalAlignment(SwingConstants.CENTER);
		t5_4.setForeground(Color.BLACK);
		t5_4.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 11));
		t5_4.setBackground(Color.LIGHT_GRAY);
		t5_4.setBounds(421, 288, 68, 40);
		frame.getContentPane().add(t5_4);

		JLabel t5_3 = new JLabel("\uC751\uD504");
		t5_3.setHorizontalAlignment(SwingConstants.CENTER);
		t5_3.setForeground(Color.BLACK);
		t5_3.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 11));
		t5_3.setBackground(Color.LIGHT_GRAY);
		t5_3.setBounds(421, 238, 68, 40);
		frame.getContentPane().add(t5_3);

		JLabel t5_1 = new JLabel("\uC751\uD504");
		t5_1.setHorizontalAlignment(SwingConstants.CENTER);
		t5_1.setForeground(Color.BLACK);
		t5_1.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 11));
		t5_1.setBackground(Color.LIGHT_GRAY);
		t5_1.setBounds(421, 138, 68, 40);
		frame.getContentPane().add(t5_1);

		JLabel t5_2 = new JLabel("\uC751\uD504");
		t5_2.setHorizontalAlignment(SwingConstants.CENTER);
		t5_2.setForeground(Color.BLACK);
		t5_2.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 11));
		t5_2.setBackground(Color.LIGHT_GRAY);
		t5_2.setBounds(421, 188, 68, 40);
		frame.getContentPane().add(t5_2);

		horz = new JLabel("");
		horz.setBounds(12, 138, 477, 40);
		horz.setBorder(eborder);
		frame.getContentPane().add(horz);

		JButton ClockControl_1 = new JButton("½Ã°è Á¤Áö");
		ClockControl_1.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 11));
		ClockControl_1.setBounds(12, 42, 85, 23);
		frame.getContentPane().add(ClockControl_1);

		vert = new JLabel("");
		vert.setBounds(101, 103, 68, 425);
		vert.setBorder(eborder);
		frame.getContentPane().add(vert);

		emphasis = new JLabel("");
		emphasis.setOpaque(true);
		emphasis.setBounds(101, 138, 68, 40);
		emphasis.setBackground(new Color(128, 255, 192));
		emphasis.setVisible(false);
		frame.getContentPane().add(emphasis);

		ClockControl_1.addActionListener(new ActionListener() {

			@Override // ½Ã°£ Á¤Áö
			public void actionPerformed(ActionEvent e) {
				if (c == true) {
					ClockControl_1.setText("½Ã°è ½ÃÀÛ");
					c = false;
				} else if (c == false) {
					ClockControl_1.setText("½Ã°è Á¤Áö");
					c = true;
					clock();
				}

			}
		});

		lightControl.addActionListener(new ActionListener() {

			@Override // Å×¸¶ º¯°æ
			public void actionPerformed(ActionEvent e) {
				if (l == 0) {
					frame.getContentPane().setBackground(Color.DARK_GRAY);
					title.setBackground(SystemColor.gray);
					memopad.setBackground(Color.GRAY);
					l = 1;
				} else if (l == 1) {
					frame.getContentPane().setBackground(Color.WHITE);
					title.setBackground(SystemColor.menu);
					memopad.setBackground(Color.WHITE);
					l = 0;
				}

			}
		});

	}
}