package guii;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

class BankAccount{
	private double balance;
	
	//Initial balance
	public BankAccount(double initialBalance) {
		balance = initialBalance;
	}
	
	//DEPOSIT
	public void deposit(double amount) {
		balance += amount;
	}
	
	//WITHDRAWAL
	public boolean withdraw(double amount) {
		if(balance >= amount) {
			balance -= amount;
			return true;
		}
		else {
			return false;
		}
	}
	
	//CHECK BALANCE
	public double checkBalance() {
		return balance;
	}
}

class ATM{
	private BankAccount account;
	
	public ATM(BankAccount bankaccount) {
		account = bankaccount;
	}
	
	public void withdraw(double amount) {
		if(account.withdraw(amount)) {
			JOptionPane.showMessageDialog(null, "Withdrwawal Successful.");
		}
		else {
			JOptionPane.showMessageDialog(null, "Insufficient Funds.");
		}
	}
	
	public void deposit(double amount) {
		account.deposit(amount);
		JOptionPane.showMessageDialog(null, "Deposit Successful.");
	}
	
	public void checkBalance() {
		JOptionPane.showMessageDialog(null, "Your current balance is: " + account.checkBalance());
	}
}

//GUI for ATM
public class TASK3_ATM extends JFrame {
	private ATM atm;
	private final String correctPIN = "1234";
	
	public TASK3_ATM()
	{
		super("ATM Machine");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 200);
		setLayout(new FlowLayout());
		
		String enteredPIN = JOptionPane.showInputDialog("Enter your PIN:");
		if(enteredPIN != null && enteredPIN.equals(correctPIN)) {
			BankAccount banckaccount = new BankAccount(1000);
			atm = new ATM(banckaccount);
			
			JButton withdrawButton = new JButton("Withdraw");
			withdrawButton.addActionListener(new ActionListener(){
				
				public void actionPerformed(ActionEvent e) {
					String amountString = JOptionPane.showInputDialog("Enter withdrawl amount:");
					if(amountString != null) {
						double amount = Double.parseDouble(amountString);
						atm.withdraw(amount);
					}
				}
			});
			add(withdrawButton);
			
			JButton depositButton = new JButton("Deposit");
			depositButton.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					String amountString = JOptionPane.showInputDialog("Enter the amount to be deposited:");
					if (amountString != null) {
						double amount = Double.parseDouble(amountString);
						atm.deposit(amount);
					}
				}
			});
			add(depositButton);
			
			JButton checkBalanceButton = new JButton("Check Balance");
			checkBalanceButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					atm.checkBalance();
				}
			});
			add(checkBalanceButton);
		}
		else {
			JOptionPane.showMessageDialog(null, "Incorrect PIN. Exiting.");
            System.exit(0);	
            }
		
		JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Exit the program
            }
        });
        add(exitButton);
		
		setVisible(true);
	}
		
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	new TASK3_ATM();
            }
        });
	}

}
