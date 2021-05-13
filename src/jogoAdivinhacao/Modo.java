package jogoAdivinhacao;

import javax.swing.JOptionPane;

public class Modo {
	
	private int valor;
	private int numSecreto;
	private int totalTentativas = 5;
	
	public void modoJogo(int seletor) {				        
			// F�cil
			if (seletor == 1) numSecreto = (int) (Math.random()*50); // N�meros de 0-50
			// Normal
			else if (seletor == 2) numSecreto = (int) (Math.random()*100);   
			// Dificil 
			else if (seletor == 3)	numSecreto = (int) (Math.random()*300); // N�meros de 0-300    
			// Muito Dificil
			else if (seletor == 4) numSecreto = (int) (Math.random()*1000); // N�meros de 0-1000
			// Pra que esse manno?
			else if (seletor == 5) numSecreto = (int) (Math.random()*10000); // N�meros de 0 - 10000
		} // Encerramento do seletor de dificuldades	

	public void verificaJogada (String valorString) {
			// converte o valor passado via JTextField
			valor = Integer.parseInt(valorString);
			
			// Condi��es
			if(valor == numSecreto) {JOptionPane.showMessageDialog (null, "Voc� acertou o n�mero!\nN�mero secreto:" + numSecreto);}
			else if (valor > numSecreto) {JOptionPane.showMessageDialog(null, "Voc� errou, o seu chute foi maior que o n�mero secreto\nRestam " + (totalTentativas-1) + " Tentativas");}
			else if (valor < numSecreto) {JOptionPane.showMessageDialog(null, "Voc� errou, o seu chute foi menor que o n�mero secreto\nRestam " + (totalTentativas-1) + " Tentativas");}
			// Toda vez que chamado subtrai 1 do total de tentativas
			totalTentativas--;
			
			if (totalTentativas == 0 && valor != numSecreto) JOptionPane.showMessageDialog(null, "O n�mero secreto era " + numSecreto);
	}





	public int getValor() {return valor;}
	public void setValor(int valor) {this.valor = valor;}
	public int getNumSecreto() {return numSecreto;}
	public void setNumSecreto(int numSecreto) {this.numSecreto = numSecreto;}
	public int getTotalTentativas() {return totalTentativas;}
	public void setTotalTentativas(int totalTentativas) {this.totalTentativas = totalTentativas;}

	}
