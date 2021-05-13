package View;

import javax.swing.*;

import jogoAdivinhacao.Modo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class janelaTeste extends JFrame {
	public janelaTeste () {super("Feito para pessoas que odeiam a EA games");}
	
	private JPanel painel = new JPanel();
	private JLabel charadaTxt = new JLabel ("Qual é o número secreto:");
	private JLabel dicaTxt = new JLabel("Dica?");
	private JButton btnDificuldade = new JButton("Confirmar dificuldade");
	private JButton btnVerificar = new JButton("Verificar");
	private JTextField txtCampoValor = new JTextField(5);
	// dificuldade
	private ButtonGroup seletor = new ButtonGroup();
	private JRadioButton d1 = new JRadioButton("Fácil ~ 0 - 50");
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
		
		// Básico da janela
		interagir(); // e as interações
		getContentPane().add(painel);
		setResizable(false);
		setBounds(300,300,400,150);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	// Método de interações
	public void interagir (){
		//Efeito do botão
		btnDificuldade.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// se o ButtonGroup estiver com alguma opção marcada o botão será liberado
				if (!seletor.isSelected(null)) {
					btnVerificar.setEnabled(true);
					txtCampoValor.setEnabled(true);
				}	
				
			} // fim do Override
		}); // fim da interação de btnDificuldade
		
		btnVerificar.addActionListener(new ActionListener() {
			// Objeto da Classe do algoritmo do game
			Modo jogo = new Modo();
			@Override
			public void actionPerformed(ActionEvent e) {
				// Condições para re-rolar o jogo
				// numSecreto = 0 / tentativas = 0 / valor digitado = numSecreto
				if (jogo.getNumSecreto() == 0 || jogo.getTotalTentativas() == 0 || jogo.getValor() == jogo.getNumSecreto()) {
					// executa o método mencionado e seta um valor aleatório
					jogo.setNumSecreto(verificaSeletor());
					// reseta as tentativas
					jogo.setTotalTentativas(5);
				}
				// Linha de teste apenas, não quebre o game
				// System.out.println(jogo.getNumSecreto());
				
				// pega o campo em String e converte dentro do método mencionado
				jogo.verificaJogada(txtCampoValor.getText());
				
				// Caso o jogador perca, o botão será desativado
				if(jogo.getTotalTentativas() == 0) {
					btnVerificar.setEnabled(false);
				}
			}
		});
		
	} // fim do método interagirDificuldade
	
	public int verificaSeletor() {
		Modo jogo = new Modo();
		// Para o número secreto ser selecionado é necessário que a dificuldade seja definida
		if (d1.isSelected() == true ) {jogo.modoJogo(1);}
		else if (d2.isSelected() == true) {jogo.modoJogo(2);}
		else if (d3.isSelected() == true) {jogo.modoJogo(3);}
		else if (d4.isSelected() == true) {jogo.modoJogo(4);}
		else if (d5.isSelected() == true) {jogo.modoJogo(5);}
		
		// o método retorna o numero gerado na execução de um dos if's
		return jogo.getNumSecreto();
	}
		
	
	public static void main (String [] args) {
		janelaTeste jT = new janelaTeste();
		jT.init();
		
	}
}
