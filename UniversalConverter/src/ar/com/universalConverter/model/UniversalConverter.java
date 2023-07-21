package ar.com.universalConverter.model;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import java.awt.CardLayout;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.SpringLayout;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JEditorPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import ar.com.universalConverter.model.UniversalConverter.ConvertsTo;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class UniversalConverter {

	private JFrame frame;
	private JLabel resultLabel;
	private JComboBox currencyTo;
	private JComboBox currency;
	private JTextField inputValue;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UniversalConverter window = new UniversalConverter();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public enum ConvertsTo{
		dolar,
		peso,
		euro		
	}
	public  enum ConvertsFrom{
		peso,
		dolar,
		euro
	}

	/**
	 * Create the application.
	 */
	public UniversalConverter() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(Color.BLACK);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		frame.setBounds(100, 100, 795, 446);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		inputValue = new JTextField();
		inputValue.setBounds(25, 86, 76, 19);
		inputValue.setText("0.00");
		frame.getContentPane().add(inputValue);
		inputValue.setColumns(10);
		
		currencyTo = new JComboBox<ConvertsFrom>(ConvertsFrom.values());
		currencyTo.setBounds(471, 86, 120, 19);
		frame.getContentPane().add(currencyTo);
		
		JButton submitButton = new JButton("Convertir");
		submitButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		submitButton.setBounds(485, 137, 106, 21);
		submitButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				try {
				ConvertsTo div1 = (ConvertsTo)currency.getSelectedItem();
				String currency = div1.toString();
				ConvertsFrom div2 = (ConvertsFrom)currencyTo.getSelectedItem();
				String currencyTo = div2.toString();
							
				double userInput = Double.parseDouble(inputValue.getText());
						
				Operacion convert = new Operacion();
				
				convert.setValue((double) userInput);
				convert.setCurrency(currency);
				convert.setCurrencyTo(currencyTo);
				
				
				String resultText = String.valueOf(convert.submit());
				
				resultLabel.setText(resultText);
				
				}catch(NumberFormatException error){
					resultLabel.setText("Ingrese solo números");			
				}
			}
		});

		frame.getContentPane().add(submitButton);
		
		currency = new JComboBox<ConvertsTo>(ConvertsTo.values());
		currency.setBounds(237, 86, 106, 19);
		frame.getContentPane().add(currency);
		
		resultLabel = new JLabel("Ingrese valor...");
		resultLabel.setBounds(163, 145, 224, 44);
		frame.getContentPane().add(resultLabel);;
		
	}
}
