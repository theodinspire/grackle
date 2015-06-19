package grackle;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Component;

public class Grackle {
	
	private String password;

	private JFrame frmGrackle;
	
	static private Image icon = Toolkit.getDefaultToolkit().getImage("src/resources/grackleicon.jpg");
	//static private Image backgound = Toolkit.getDefaultToolkit().getImage("src/resources/grackle.jpg");
	//static private ImageIcon background = new ImageIcon("src/resources/grackle.jpg");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Grackle window = new Grackle();
					window.frmGrackle.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Grackle() {
		System.out.println(System.getProperty("user.dir"));
		password = generateNewPassword();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGrackle = new JFrame("Grackle");
		frmGrackle.setResizable(false);
		frmGrackle.setBounds(100, 100, 450, 150);
		frmGrackle.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGrackle.setIconImage(icon);
		
		//	Background panel for image
		GrackleMainJPanel mainPanel = new GrackleMainJPanel();
		mainPanel.setLayout(new BorderLayout());
		frmGrackle.getContentPane().add(mainPanel, BorderLayout.CENTER);
		/**************************************************************/
		
		//	Panel for displaying password
		JPanel PassPanel = new JPanel();
		PassPanel.setOpaque(false);
		mainPanel.add(PassPanel, BorderLayout.CENTER);
		PassPanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblPassword = new JLabel(password);
		lblPassword.setAlignmentX(Component.CENTER_ALIGNMENT);
		PassPanel.add(lblPassword);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		/********************************************************/
		
		//	Button panel
		JPanel optionPanel = new JPanel();
		optionPanel.setOpaque(false);
		mainPanel.add(optionPanel, BorderLayout.SOUTH);
		optionPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnCopyToClipboard = new JButton("Copy to Clipboard");
		btnCopyToClipboard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				copyToClipboard();
			}
		});
		optionPanel.add(btnCopyToClipboard);
		
		JButton btnGenerateNew = new JButton("Generate New");
		btnGenerateNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				password = generateNewPassword();
				lblPassword.setText(password);
			}
		});
		optionPanel.add(btnGenerateNew);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				copyToClipboard();
				frmGrackle.dispatchEvent(new WindowEvent(frmGrackle, WindowEvent.WINDOW_CLOSING));
			}
		});
		optionPanel.add(btnClose);
	}
	
	private void copyToClipboard() {
		StringSelection pwdSelection = new StringSelection(password);
		Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
		clpbrd.setContents(pwdSelection, null);
	}
	
	private static String generateNewPassword() {
		return PassGen.getPassword(16);
	}

}
