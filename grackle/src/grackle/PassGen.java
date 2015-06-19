package grackle;

import java.util.Random;

public class PassGen {
	static Random rand = new Random();
	
	static String getPassword(int charLimit, int minChar, int digitWidth) {
		String password = Birds.getString(rand);
		while (password.length() > charLimit - digitWidth)
			password = Birds.getString(rand);
		
		if (password.length() <= minChar - digitWidth) {
			String candidate = Modifier.getModifier(rand);
			int count = 0;
			
			while ((candidate.length() + password.length() > charLimit - digitWidth
					|| candidate.length() + password.length() < minChar - digitWidth)
					&& count++ < 100)
				candidate = Modifier.getModifier(rand);
			if (count == 100)
				candidate = "";
			password = candidate + password;
		}
		
		password += String.format("%0" + digitWidth + "d", rand.nextInt(100));
		return password;
	}
	
	static String getPassword() {
		return getPassword(1028, 8, 2);
	}
	
	static String getPassword(int charLimit) {
		return getPassword(charLimit, 0, 2);
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
