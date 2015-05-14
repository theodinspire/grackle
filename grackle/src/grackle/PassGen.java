package grackle;

import java.util.Random;

public class PassGen {
	static Random rand = new Random(System.nanoTime());
	
	static String getPassword() {
		String password = Birds.getString(rand);
		if (password.length() < 7) password = Modifier.getModifier(rand) + password;
		password += String.format("%02d", rand.nextInt(100));
		return password;
	}

//	//	Main
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//	
//		Object[] options = {"Copy to Clipboard", "Generate another", "Close"};
//		int optionSelected = 1;
//	
//		String birdie = getPassword();
//	
//		while (optionSelected != 2) {
//			System.out.println(birdie);
//	
//			optionSelected = JOptionPane.showOptionDialog(null, 
//					"Password generated is:\n" + birdie,	//	Message test
//					"Password Generated",	//	--	--	--	--	Message title
//					JOptionPane.YES_NO_CANCEL_OPTION,	//	--	--	--	Message format
//					JOptionPane.QUESTION_MESSAGE,	//	--	--	Message type
//					null,	//	--	--	--	--	--	--	--	--	Message image (null for default)
//					options,	//	--	--	--	--	--	--	--	Message options
//					options[0]);	//	--	--	--	--	--	--	Message default option
//			if (optionSelected == 1) { 
//				birdie = getPassword();
//			}
//			else {
//				StringSelection pwdSelection = new StringSelection(birdie.toString());
//				Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
//				clpbrd.setContents(pwdSelection, null);
//			}
//		}
//	}

}
