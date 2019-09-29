package projeto01;
import javax.swing.JOptionPane;

public class calcularDesconto {

	//Classe utilizada para calcular a valor de desconto
	
	/**
	 * @author Leonardo Pereira da silva.
	 * @version 1.0
	 * */
	
	public static Float calcular(Float numero, Float desconto) {
		Float res = numero * desconto;
		Float result = numero - res;
		JOptionPane.showMessageDialog(null, "O valor do Produto: " + "R$" + result);
		return numero;
	}

	public static void escolherDesconto(Object escolhido, Float valor) {
		Float[] desc = new Float[] { 0.05F, 0.1F, 0.2F, 0.5F };
		if (escolhido == "5%") {
			calcular(valor, desc[0]);
		} else if (escolhido == "10%") {
			calcular(valor, desc[1]);
		} else if (escolhido == "20%") {
			calcular(valor, desc[2]);
		} else if (escolhido == "50%") {
			calcular(valor, desc[3]);
		}
		return;
	}

	public static void main(String[] args) {

		Object[] opcoes = new Object[] { "5%", "10%", "20%", "50%" };
		Object codigo;
		String[] msg = new String[] { "Valor do desconto\r\n", "Valor do Produto: R$", "Você deseja sair!", "Tchau!",
				"calcular desconto" };
		String[] msgErro = new String[] { "[ERRO!] - Valor do Produto incorreto",
				"[ERRO!] - Codigo de desconto incorreto", "[ERRO!]" };
		Integer resposta = 1;
		Float Valor = 0F;
		do {
			try {
				Valor = Float.parseFloat(JOptionPane.showInputDialog(null, msg[1], msg[4], JOptionPane.PLAIN_MESSAGE));

				if (Valor < 0)
					throw new Exception();
			} catch (NullPointerException e) {
				resposta = JOptionPane.showConfirmDialog(null, msg[2], null, JOptionPane.YES_NO_OPTION);
				if (resposta == JOptionPane.YES_OPTION) {
					JOptionPane.showMessageDialog(null, msg[3]);
					System.exit(0);
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, msgErro[0]);
			}
			try {
				codigo = JOptionPane.showInputDialog(null, msg[0], msg[4], JOptionPane.PLAIN_MESSAGE, null, opcoes,
						"1 - 5%\r\n");

				if (codigo.equals("5%") || codigo.equals("10%") || codigo.equals("20%") || codigo.equals("50%")) {
					escolherDesconto(codigo, Valor);
				}
			} catch (Exception e) {
				resposta = JOptionPane.showConfirmDialog(null, msg[2], null, JOptionPane.YES_NO_OPTION);
				if (resposta == JOptionPane.YES_OPTION) {
					JOptionPane.showMessageDialog(null, msg[3]);
					System.exit(0);
				}
			}
		} while (resposta == JOptionPane.NO_OPTION);
	}
}