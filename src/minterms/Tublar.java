package minterms;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Tublar {
	private JTextArea steps_text ;
	Test test1 = new Test();
	Fullfunction fullfunction = new Fullfunction();
	private JFrame frmTublarMethod;
	private JTextField numOfVariables;
	private JLabel lblNewLabel;
	private JTextField miniterms;
	private JLabel lblResult;
	private JTextField result;
	private JScrollPane scrollPane;
	private JTextField dontcare;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					Tublar window = new Tublar();
					window.frmTublarMethod.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Tublar() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frmTublarMethod = new JFrame();
		frmTublarMethod.setTitle("tublar method");
		frmTublarMethod.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 14));
		frmTublarMethod.setBounds(100, 100, 750, 445);
		frmTublarMethod.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTublarMethod.getContentPane().setLayout(null);

		JLabel lblNumberOfVariables = new JLabel("number of variables");
		lblNumberOfVariables.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNumberOfVariables.setBounds(21, 26, 136, 35);
		frmTublarMethod.getContentPane().add(lblNumberOfVariables);

		numOfVariables = new JTextField();
		numOfVariables.setBounds(198, 35, 186, 20);
		frmTublarMethod.getContentPane().add(numOfVariables);
		numOfVariables.setColumns(10);

		JButton btnNewButton = new JButton("get result");
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
			final String numOfvariables = numOfVariables.getText();
			final String minterms = miniterms.getText();
			final String dont_care = dontcare.getText();
			final String res = test1.mainfunction((minterms+","+dont_care), numOfvariables);
			final String stepss = test1.stepssss;
			steps_text.setText(stepss);

			result.setText(res);


			}
		});
		btnNewButton.setBounds(164, 313, 89, 23);
		frmTublarMethod.getContentPane().add(btnNewButton);

		lblNewLabel = new JLabel("min terms");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(21, 72, 126, 20);
		frmTublarMethod.getContentPane().add(lblNewLabel);

		miniterms = new JTextField();
		miniterms.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		miniterms.setBounds(198, 74, 186, 20);
		frmTublarMethod.getContentPane().add(miniterms);
		miniterms.setColumns(10);

		lblResult = new JLabel("result");
		lblResult.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblResult.setBounds(21, 169, 60, 20);
		frmTublarMethod.getContentPane().add(lblResult);

		result = new JTextField();
		result.setBounds(198, 177, 186, 65);
		frmTublarMethod.getContentPane().add(result);
		result.setColumns(10);

		JLabel lblSteps = new JLabel("steps");
		lblSteps.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSteps.setBounds(444, 39, 46, 14);
		frmTublarMethod.getContentPane().add(lblSteps);

				scrollPane = new JScrollPane();
				scrollPane.setBounds(509, 39, 186, 225);
				frmTublarMethod.getContentPane().add(scrollPane);

				steps_text = new JTextArea();
				scrollPane.setViewportView(steps_text);

				dontcare = new JTextField();
				dontcare.setBounds(198, 115, 186, 20);
				frmTublarMethod.getContentPane().add(dontcare);
				dontcare.setColumns(10);

				JLabel lblDontCare = new JLabel("don't care");
				lblDontCare.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblDontCare.setBounds(21, 118, 79, 14);
				frmTublarMethod.getContentPane().add(lblDontCare);
	}
}
