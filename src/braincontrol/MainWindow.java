package braincontrol;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.JProgressBar;
import javax.swing.JButton;
import javax.swing.JCheckBox;

public class MainWindow {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
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
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u8111\u6CE2\u63A7\u5236");
		frame.setBounds(100, 100, 816, 576);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenu mnFile = new JMenu("\u6587\u4EF6");
		menuBar.add(mnFile);

		JMenu mnOption = new JMenu("\u9009\u9879");
		menuBar.add(mnOption);

		JMenu mnHelp = new JMenu("\u5E2E\u52A9");
		menuBar.add(mnHelp);

		JToolBar toolBar = new JToolBar();
		toolBar.setFloatable(false);
		frame.getContentPane().add(toolBar, BorderLayout.NORTH);

		final JToggleButton btnTrain = new JToggleButton("\u8BAD\u7EC3");
		btnTrain.setIcon(new ImageIcon(".\\asset\\train.png"));
		btnTrain.setSelected(true);
		toolBar.add(btnTrain);

		final JToggleButton btnTest = new JToggleButton("\u6D4B\u8BD5");
		btnTest.setIcon(new ImageIcon(".\\asset\\run.png"));
		toolBar.add(btnTest);

		final JPanel panelCard = new JPanel();
		frame.getContentPane().add(panelCard, BorderLayout.CENTER);
		panelCard.setLayout(new CardLayout(0, 0));

		JPanel panelTrain = new JPanel();
		panelCard.add(panelTrain, "train");
		panelTrain.setLayout(new BorderLayout(0, 0));

		JPanel panelTrainWest = new JPanel();
		panelTrain.add(panelTrainWest, BorderLayout.WEST);
		panelTrainWest.setSize(300, 300);
		panelTrainWest.setLayout(new BorderLayout(0, 0));

		JTextField labelTrainWest = new JTextField("\u4FE1\u53F7\u8F93\u5165");
		labelTrainWest.setForeground(Color.BLACK);
		labelTrainWest.setBackground(Color.WHITE);
		labelTrainWest.setEditable(false);
		labelTrainWest.setEnabled(false);
		labelTrainWest.setHorizontalAlignment(SwingConstants.CENTER);
		panelTrainWest.add(labelTrainWest, BorderLayout.NORTH);

		Component horizontalStrutTrainWest = Box.createHorizontalStrut(150);
		panelTrainWest.add(horizontalStrutTrainWest, BorderLayout.SOUTH);

		JPanel panelTrainEast = new JPanel();
		panelTrain.add(panelTrainEast, BorderLayout.EAST);
		panelTrainEast.setLayout(new BorderLayout(0, 0));

		JTextField labelTrainNorth = new JTextField("\u5B66\u4E60\u72B6\u6001");
		labelTrainNorth.setForeground(Color.BLACK);
		labelTrainNorth.setBackground(Color.WHITE);
		labelTrainNorth.setEditable(false);
		labelTrainNorth.setEnabled(false);
		labelTrainNorth.setHorizontalAlignment(SwingConstants.CENTER);
		panelTrainEast.add(labelTrainNorth, BorderLayout.NORTH);

		Component horizontalStrutTrainNorth = Box.createHorizontalStrut(150);
		panelTrainEast.add(horizontalStrutTrainNorth, BorderLayout.SOUTH);
		
		JPanel panelControl = new JPanel();
		panelTrainEast.add(panelControl, BorderLayout.CENTER);
		FlowLayout fl_panelControl = new FlowLayout(FlowLayout.CENTER, 5, 5);
		panelControl.setLayout(fl_panelControl);
		
		JButton btnStartTraining = new JButton("\u5F00\u59CB\u8BAD\u7EC3");
		btnStartTraining.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JCheckBox checkBox = new JCheckBox("\u97F3\u6548");
		panelControl.add(checkBox);
		panelControl.add(btnStartTraining);

		JPanel panelTrainSouth = new JPanel();
		panelTrainSouth.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelTrain.add(panelTrainSouth, BorderLayout.SOUTH);
		panelTrainSouth.setLayout(new BorderLayout(0, 0));

		JTextArea txtCmdTrain = new JTextArea();
		txtCmdTrain.setRows(6);
		txtCmdTrain.setText("Command");
		panelTrainSouth.add(txtCmdTrain, BorderLayout.NORTH);

		JPanel panelTrainCenter = new JPanel();
		panelTrainCenter.setBorder(new BevelBorder(BevelBorder.LOWERED, null,
				null, null, null));
		panelTrainCenter.setForeground(new Color(192, 192, 192));
		panelTrainCenter.setBackground(Color.WHITE);
		panelTrain.add(panelTrainCenter, BorderLayout.CENTER);
		panelTrainCenter.setLayout(new BorderLayout(0, 0));

		JLabel lblActionTips = new JLabel("\u52A8\u4F5C\u63D0\u793A");
		lblActionTips.setHorizontalAlignment(SwingConstants.CENTER);
		panelTrainCenter.add(lblActionTips, BorderLayout.NORTH);
		
		JProgressBar progressBar = new JProgressBar();
		panelTrainCenter.add(progressBar, BorderLayout.SOUTH);

		JPanel panelTest = new JPanel();
		panelCard.add(panelTest, "test");
		panelTest.setLayout(new BorderLayout(0, 0));

		JPanel panelTestWest = new JPanel();
		panelTest.add(panelTestWest, BorderLayout.WEST);
		panelTestWest.setSize(300, 300);
		panelTestWest.setLayout(new BorderLayout(0, 0));

		JTextField labelTestWest = new JTextField("\u4FE1\u53F7\u8F93\u5165");
		labelTestWest.setForeground(Color.BLACK);
		labelTestWest.setBackground(Color.WHITE);
		labelTestWest.setEditable(false);
		labelTestWest.setEnabled(false);
		labelTestWest.setHorizontalAlignment(SwingConstants.CENTER);
		panelTestWest.add(labelTestWest, BorderLayout.NORTH);

		Component horizontalStrutTestWest = Box.createHorizontalStrut(150);
		panelTestWest.add(horizontalStrutTestWest, BorderLayout.SOUTH);

		JPanel panelTestEast = new JPanel();
		panelTest.add(panelTestEast, BorderLayout.EAST);
		panelTestEast.setLayout(new BorderLayout(0, 0));

		JTextField labelTestNorth = new JTextField("\u63A7\u5236\u8F93\u51FA");
		labelTestNorth.setForeground(Color.BLACK);
		labelTestNorth.setBackground(Color.WHITE);
		labelTestNorth.setEditable(false);
		labelTestNorth.setEnabled(false);
		labelTestNorth.setHorizontalAlignment(SwingConstants.CENTER);
		panelTestEast.add(labelTestNorth, BorderLayout.NORTH);

		Component horizontalStrutTestNorth = Box.createHorizontalStrut(150);
		panelTestEast.add(horizontalStrutTestNorth, BorderLayout.SOUTH);

		JPanel panelTestSouth = new JPanel();
		panelTestSouth.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelTest.add(panelTestSouth, BorderLayout.SOUTH);
		panelTestSouth.setLayout(new BorderLayout(0, 0));

		JTextArea txtCmdTest = new JTextArea();
		txtCmdTest.setRows(6);
		txtCmdTest.setText("Command");
		panelTestSouth.add(txtCmdTest, BorderLayout.NORTH);

		JPanel panelTestCenter = new JPanel();
		panelTestCenter.setBorder(new BevelBorder(BevelBorder.LOWERED, null,
				null, null, null));
		panelTestCenter.setForeground(Color.LIGHT_GRAY);
		panelTestCenter.setBackground(Color.BLACK);
		panelTest.add(panelTestCenter, BorderLayout.CENTER);
		
		JLabel lblCamera = new JLabel("\u6444\u50CF\u5934\u89C6\u9891\u56FE\u50CF");
		lblCamera.setForeground(Color.WHITE);
		panelTestCenter.add(lblCamera);

		btnTrain.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				btnTrain.setSelected(true);
				btnTest.setSelected(false);
				CardLayout layout = (CardLayout) panelCard.getLayout();
				layout.show(panelCard, "train");
			}
		});
		
		btnTest.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				btnTrain.setSelected(false);
				btnTest.setSelected(true);
				CardLayout layout = (CardLayout) panelCard.getLayout();
				layout.show(panelCard, "test");
			}
		});
	}

}
