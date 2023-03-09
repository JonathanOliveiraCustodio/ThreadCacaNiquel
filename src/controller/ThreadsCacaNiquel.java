package controller;

import javax.swing.JTextField;

public class ThreadsCacaNiquel extends Thread {

	private JTextField txtNumero;

	public ThreadsCacaNiquel(JTextField txtNumero) {
		this.txtNumero = txtNumero;

	}
		

	private void Jogar() {
			
		int sorteio = 0;
		String Resultado = "";

		for (int j = 0; j <= 20; j++) {

			txtNumero.setText(Integer.toString(sorteio = (int) (1 + Math
					.random() * 7)));
			Resultado = Integer.toString(sorteio);
			try {
				Thread.sleep(100);
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		

	}

	public void run() {
		Jogar();
	}

}
