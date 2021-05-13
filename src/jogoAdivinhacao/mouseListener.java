package jogoAdivinhacao;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;

public class mouseListener implements MouseListener{

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		JOptionPane.showMessageDialog(null, "Ainda não arrumei", "O mesmo se aplica a Nintendo", 0);	
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

}
