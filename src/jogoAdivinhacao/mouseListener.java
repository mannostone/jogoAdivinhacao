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
		// Nada relevante
		String meme = "";
		int numMeme = (int) (Math.random()*5);
		
		if (numMeme == 1) meme = "Neste Projeto também odiamos a Nintendo";
		else if (numMeme == 2) meme = "Você foi banido da Live do Cellbit";
		else if (numMeme == 3) meme = "DaviG0d só faz live de FreeFire";
		else if (numMeme == 4) meme = "Piratear jogos da EA não é crime";
		else if (numMeme == 5) meme = "Isso é uma !('afirmativa')";
		else meme = "Nada para ler aqui";
		
		// Ainda vou tratar
		JOptionPane.showMessageDialog(null, "Ainda não arrumei", meme, 0);
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

}
