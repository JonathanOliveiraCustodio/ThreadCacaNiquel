package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.text.NumberFormat;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import controller.CacaNiquelController;

public class PrincipalCacaNiquel extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtN1;
	private JTextField txtN2;
	private JTextField txtN3;
	private JLabel lblCash = new JLabel("Cash:");
	private JButton btnJogar = new JButton("Jogar");
	private Timer timer;
	private double Cash = 1000;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrincipalCacaNiquel frame = new PrincipalCacaNiquel();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public class Aguardar {
		Timer timer;

		public Aguardar(int seconds) {
			timer = new Timer();
			timer.schedule(new RemindTask(), seconds * 1000);
		}

		class RemindTask extends TimerTask {
			public void run() {
				Checar();
				timer.cancel(); // Terminate the timer thread
			}
		}

	}

	public void Checar() {

		if (txtN1.getText().equals(txtN2.getText()) && txtN3.getText().equals(txtN1.getText())) {

			JOptionPane.showMessageDialog(null, "Acertou !");
			Cash = 100000000;
			lblCash.setText("Cash "
					+ NumberFormat.getCurrencyInstance().format(Cash));
		} else {
			JOptionPane.showMessageDialog(null, "Perdeu, Tente Novamente !");

			lblCash.setText("Cash "
					+ NumberFormat.getCurrencyInstance().format(Cash));
			btnJogar.setEnabled(true);
			Cash -= 10;
		}
	}

	/**
	 * Create the frame.
	 */
	public PrincipalCacaNiquel() {
		
		setTitle("Ca\u00E7a Niquel");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 451, 304);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
	    
		
		
		setLocationRelativeTo(null);
		lblCash.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		lblCash.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblCash.setBounds(0, 25, 445, 17);
		contentPane.add(lblCash);

		txtN1 = new JTextField();
		txtN1.setEditable(false);
		txtN1.setHorizontalAlignment(SwingConstants.CENTER);
		txtN1.setFont(new Font("Calibri", Font.PLAIN, 59));
		txtN1.setBounds(94, 75, 62, 72);
		contentPane.add(txtN1);
		txtN1.setColumns(10);

		txtN2 = new JTextField();
		txtN2.setEditable(false);
		txtN2.setHorizontalAlignment(SwingConstants.CENTER);
		txtN2.setFont(new Font("Calibri", Font.PLAIN, 59));
		txtN2.setColumns(10);
		txtN2.setBounds(181, 75, 62, 72);
		contentPane.add(txtN2);

		txtN3 = new JTextField();
		txtN3.setEditable(false);
		txtN3.setHorizontalAlignment(SwingConstants.CENTER);
		txtN3.setFont(new Font("Calibri", Font.PLAIN, 59));
		txtN3.setColumns(10);
		txtN3.setBounds(273, 75, 62, 72);
		contentPane.add(txtN3);

		btnJogar.setFont(new Font("Calibri", Font.PLAIN, 14));
		btnJogar.setBounds(168, 201, 89, 23);
		contentPane.add(btnJogar);
		btnJogar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent args0) {
				CacaNiquelController Randomizar = new CacaNiquelController(
						txtN1, txtN2, txtN3);
				Randomizar.actionPerformed(null);
				btnJogar.setEnabled(false);
				lblCash.setText("Cash "
						+ NumberFormat.getCurrencyInstance().format(Cash));
				new Aguardar(3);
				System.out.println(Cash);
			}

		});

	}

}
