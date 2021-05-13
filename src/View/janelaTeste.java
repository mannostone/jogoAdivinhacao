package View;

import javax.swing.*;

import jogoAdivinhacao.Modo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class janelaTeste extends JFrame {
	public janelaTeste () {super("Feito para pessoas que odeiam a EA games");}
	
	private JPanel painel = new JPanel();
	private JLabel charadaTxt = new JLabel ("Qual � o n�mero secreto:");
	private JLabel dicaTxt = new JLabel("Dica?");
	private JButton btnDificuldade = new JButton("Confirmar dificuldade");
	private JButton btnVerificar = new JButton("Verificar");
	private JTextField txtCampoValor = new JTextField(5);
	// dificuldade
	private ButtonGroup seletor = new ButtonGroup();
	private JRadioButton d1 = new JRadioButton("F�cil ~ 0 - 50");
	private JRadioButton d2 = new JRadioButton("Normal ~ 0 - 100");
	private JRadioButton d3 = new JRadioButton("Dificil ~ 0 - 300");
	private JRadioButton d4 = new JRadioButton("Muito Dificil ~ 0 - 1000");
	private JRadioButton d5 = new JRadioButton("???? ~ 0 - 10000");
		
	public void init () {
		painel.add(charadaTxt);
		painel.add(txtCampoValor); txtCampoValor.setEnabled(false);
		painel.add(btnVerificar); btnVerificar.setEnabled(false);
		painel.add(dicaTxt);
		painel.add(btnDificuldade);
		// agrupando no seletor de dificuldade
		seletor.add(d1);
		seletor.add(d2);
		seletor.add(d3);
		seletor.add(d4);
		seletor.add(d5);
		// adicionando no painel
		painel.add(d1);
		painel.add(d2);
		painel.add(d3);
		painel.add(d4);
		painel.add(d5);
		
		// Efeito ao passar por cima
		jogoAdivinhacao.mouseListener mL = new jogoAdivinhacao.mouseListener();
		dicaTxt.addMouseListener(mL);
		
		// B�sico da janela
		interagir(); // e as intera��es
		getContentPane().add(painel);
		setResizable(false);
		setBounds(300,300,400,150);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	// M�todo de intera��es
	public void interagir (){
		//Efeito do bot�o
		btnDificuldade.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// se o ButtonGroup estiver com alguma op��o marcada o bot�o ser� liberado
				if (!seletor.isSelected(null)) {
					btnVerificar.setEnabled(true);
					txtCampoValor.setEnabled(true);
				}	
				
			} // fim do Override
		}); // fim da intera��o de btnDificuldade
		
		btnVerificar.addActionListener(new ActionListener() {
			// Objeto da Classe do algoritmo do game
			Modo jogo = new Modo();
			@Override
			public void actionPerformed(ActionEvent e) {
				// Condi��es para re-rolar o jogo
				// numSecreto = 0 / tentativas = 0 / valor digitado = numSecreto
				if (jogo.getNumSecreto() == 0 || jogo.getTotalTentativas() == 0 || jogo.getValor() == jogo.getNumSecreto()) {
					// executa o m�todo mencionado e seta um valor aleat�rio
					jogo.setNumSecreto(verificaSeletor());
					// reseta as tentativas
					jogo.setTotalTentativas(5);
				}
				// Linha de teste apenas, n�o quebre o game
				// System.out.println(jogo.getNumSecreto());
				
				// pega o campo em String e converte dentro do m�todo mencionado
				jogo.verificaJogada(txtCampoValor.getText());
				
				// Caso o jogador perca, o bot�o ser� desativado
				if(jogo.getTotalTentativas() == 0) {
					btnVerificar.setEnabled(false);
				}
			}
		});
		
	} // fim do m�todo interagirDificuldade
	
	public int verificaSeletor() {
		Modo jogo = new Modo();
		// Para o n�mero secreto ser selecionado � necess�rio que a dificuldade seja definida
		if (d1.isSelected() == true ) {jogo.modoJogo(1);}
		else if (d2.isSelected() == true) {jogo.modoJogo(2);}
		else if (d3.isSelected() == true) {jogo.modoJogo(3);}
		else if (d4.isSelected() == true) {jogo.modoJogo(4);}
		else if (d5.isSelected() == true) {jogo.modoJogo(5);}
		
		// o m�todo retorna o numero gerado na execu��o de um dos if's
		return jogo.getNumSecreto();
	}
		
	
	public static void main (String [] args) {
		janelaTeste jT = new janelaTeste();
		jT.init();
		
	}
}
