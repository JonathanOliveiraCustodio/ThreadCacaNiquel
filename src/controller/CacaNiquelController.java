package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;


public class CacaNiquelController implements ActionListener {

	private JTextField txtN1;
	private JTextField txtN2;
	private JTextField txtN3;
	
	public CacaNiquelController(JTextField txtN1, JTextField txtN2,JTextField txtN3){
		this.txtN1=txtN1;
		this.txtN2=txtN2;
		this.txtN3=txtN3;
		
	}
	
	private void chamaThreads(){
		Thread t1 = new ThreadsCacaNiquel(txtN1);
		Thread t2 = new ThreadsCacaNiquel(txtN2);
		Thread t3 = new ThreadsCacaNiquel(txtN3);
		t1.start();
		t2.start();
		t3.start();		
		
	}
	

	public void actionPerformed(ActionEvent arg0) {
		chamaThreads();
		
	}

}
