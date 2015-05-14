package grackle;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
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

public class Grackle {
	
	private String password;

	private JFrame frmGrackle;

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
		password = PassGen.getPassword();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGrackle = new JFrame("Erikson Password Generator");
		frmGrackle.setTitle("Grackle");
		frmGrackle.setBounds(100, 100, 450, 150);
		frmGrackle.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frmGrackle.getContentPane().add(panel, BorderLayout.SOUTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblPassword = new JLabel(password);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		frmGrackle.getContentPane().add(lblPassword, BorderLayout.CENTER);
		
		JButton btnCopyToClipboard = new JButton("Copy to Clipboard");
		btnCopyToClipboard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				copyToClipboard();
			}
		});
		panel.add(btnCopyToClipboard);
		
		JButton btnGenerateNew = new JButton("Generate New");
		btnGenerateNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				generateNewPassword();
				lblPassword.setText(password);
			}
		});
		panel.add(btnGenerateNew);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				copyToClipboard();
				frmGrackle.dispatchEvent(new WindowEvent(frmGrackle, WindowEvent.WINDOW_CLOSING));
			}
		});
		panel.add(btnClose);
	}
	
	private void copyToClipboard() {
		StringSelection pwdSelection = new StringSelection(password);
		Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
		clpbrd.setContents(pwdSelection, null);
	}
	
	private void generateNewPassword() {
		password = PassGen.getPassword();
	}

}
