package grackle;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class GrackleMainJPanel extends JPanel {
	private static final long serialVersionUID = 3724992122744789847L;
	
	private Image background = Toolkit.getDefaultToolkit().createImage(Grackle.class.getResource("resources/images/grackle.jpg"));
			//(getClass().getResource("/resources/images/grackle.jpg"));
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(background, 0, 0, this);
	}
}
