package BankPackage;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import BankPackage.Manager.CustomerSummaryUI;

public class CustomerUI extends JFrame { // Every customer has a checking and saving account
	// totalCustomer will be used to create reports
	Scanner scan = new Scanner(System.in);

	/*
	 * --------------------------------Additional JFRAMES
	 * --------------------------------------------
	 */

	public class RegisterPageUI extends JFrame {
		public RegisterPageUI() {
			/*
			 * Make another JFrame
			 */
			JButton btn_register = new JButton("Register");
			JLabel name = new JLabel("Name");
			JLabel date = new JLabel("Date of Birth (Month/Day/Year)");
			JLabel age = new JLabel("Age");
			JLabel spaces = new JLabel("                                      ");
			JLabel currency = new JLabel("Currency");
			JLabel password = new JLabel("Password");

			JTextField name_field = new JTextField(8);
			JTextField currency_field = new JTextField(8);
			JTextField day_field = new JTextField(2);
			JTextField month_field = new JTextField(2);
			JTextField year_field = new JTextField(4);
			JTextField age_field = new JTextField(2);
			JPasswordField password_field_1 = new JPasswordField(8);

			JPanel panel = new JPanel();
			add(panel);

			panel.add(name);
			panel.add(name_field);
			panel.add(password);
			panel.add(password_field_1);
			panel.add(date);
			panel.add(month_field);
			panel.add(day_field);
			panel.add(year_field);
			panel.add(age);
			panel.add(age_field);
			panel.add(spaces);
			panel.add(currency);
			panel.add(currency_field);

			panel.add(btn_register);
			setSize(800, 400);
			setLocation(200, 100);
			setVisible(true);

			btn_register.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String inputName = name_field.getText();
					int inputDay = Integer.parseInt(day_field.getText());
					int inputMonth = Integer.parseInt(month_field.getText());
					int inputYear = Integer.parseInt(year_field.getText());
					int inputAge = Integer.parseInt(age_field.getText());
					String currency = currency_field.getText();
					Customer just_made = new Customer(inputName, inputDay, inputMonth, inputYear, inputAge, currency); // DELETE
																														// LATER,
																														// MODIFY
																														// to
																														// fit
																														// whatever
																														// is
																														// typed
																														// in
					just_made.Password = password_field_1.getText();
					Bank.Customers.add(just_made);
					CustomerHomepageUI registerpage = new CustomerHomepageUI(just_made);
					dispose();
				}

			});
		}
	}

	public class LoginPageUI extends JFrame {

		public LoginPageUI() {
			/*
			 * Ask for user info and bring them to their respective page
			 */
			JLabel user_field = new JLabel("Username");
			JLabel password_field = new JLabel("Password");
			JTextField text_field_1 = new JTextField(8);
			JPasswordField password_field_1 = new JPasswordField(8);
			JButton btn_Log_In = new JButton("Log In");

			user_field.setBounds(80, 70, 200, 30);
			password_field.setBounds(80, 110, 200, 30);
			text_field_1.setBounds(300, 70, 200, 30);
			password_field_1.setBounds(300, 110, 200, 30);
			JPanel panel = new JPanel();
			add(panel);
			panel.add(user_field);
			panel.add(text_field_1);
			panel.add(password_field);
			panel.add(password_field_1);
			panel.add(btn_Log_In);
			setSize(800, 800);
			setLocation(200, 100);
			setVisible(true);

			btn_Log_In.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// go to sign in page
					/*
					 * Do everything above except we need to register the data
					 */
					String input_name = text_field_1.getText(); // gets the name
					String password = password_field_1.getText(); // NOTE: Gotta handle null pnter
					if (Bank.findCustomer(input_name, password)) {
						Customer retrieving = Bank.retrieveCustomer(input_name, password);
						// i.e. check Bank.CustomerList if exist -> else -> error
						CustomerHomepageUI home_page = new CustomerHomepageUI(retrieving);
						System.out.println("Found him");
					}

					for (int i = 0; i < Bank.Customers.size(); i++) {
						System.out.println(Bank.Customers.get(i).getName());
					}
					System.out.println(input_name); // DELETE LATER
					System.out.println(Bank.findCustomer(input_name, password));
					System.out.println(password);
//				dispose();
					// else do nothing
				}
			});
		}
	}

	public class CreateCheckingsUI extends JFrame {
		// Creates a checkings account popup
		public CreateCheckingsUI(Customer info) {
			JButton Create_Checkings = new JButton("Create Checkings");
			JLabel l1 = new JLabel("Creating a Checking Account, please enter amount to deposit");
			JTextField initial_balance = new JTextField(8);
			l1.setBounds(50, 50, 100, 30);
			JPanel panel = new JPanel();
			add(panel);
			panel.add(l1);
			panel.add(initial_balance);
			panel.add(Create_Checkings);
			setSize(800, 400);
			setLocation(200, 100);
			setVisible(true);

			Create_Checkings.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					float amount = Float.parseFloat(initial_balance.getText());
					info.create_checking(amount);
					CheckingsUI checkings = new CheckingsUI(info.customer_checking);
					dispose();
				}

			});

		}
	}

	public class CreateSavingsUI extends JFrame {
		// Creates a savings account popup
		public CreateSavingsUI(Customer info) {
			JButton Create_Savings = new JButton("Create Savings");
			JLabel l1 = new JLabel("Creating a Savings Account, please enter amount to deposit");
			JTextField initial_balance = new JTextField(8);
			l1.setBounds(50, 50, 100, 30);
			JPanel panel = new JPanel();
			add(panel);
			panel.add(l1);
			panel.add(initial_balance);
			panel.add(Create_Savings);
			setSize(800, 400);
			setLocation(200, 100);
			setVisible(true);

			Create_Savings.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					float amount = Float.parseFloat(initial_balance.getText());
					info.create_saving(amount);
					SavingsUI checkings = new SavingsUI(info.customer_saving);
					dispose();
				}

			});

		}
	}

	public class SavingsUI extends JFrame {
		// if they have savings
		public SavingsUI(SavingAccount info) {

			// use revalidate(); to refresh page
			JTextField deposit_field_1 = new JTextField(8);
			JButton Deposit = new JButton("Deposit");
			JTextField withdraw_field_1 = new JTextField(8);
			JButton Withdraw = new JButton("Withdraw");

			JPanel panel = new JPanel();
			add(panel);

			JLabel intro = new JLabel("Your current Savings Balance is " + info.getBalance());
			panel.add(intro);

			panel.add(deposit_field_1);
			panel.add(Deposit);
			panel.add(withdraw_field_1);
			panel.add(Withdraw);
			setSize(800, 400);
			setLocation(200, 100);
			setVisible(true);

			Deposit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					float amount = Float.parseFloat(deposit_field_1.getText());
					info.deposit(amount);
					System.out.println(info.getBalance());
					intro.setText("Your current Savings Balance is " + info.getBalance());
				}
			});

			Withdraw.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					float amount = Float.parseFloat(deposit_field_1.getText());
					info.withdraw(amount);
					System.out.println(info.getBalance());
					intro.setText("Your current Savings Balance is " + info.getBalance());
				}
			});
		}
	}

	public class CheckingsUI extends JFrame {
		// if they have checkings
		public CheckingsUI(CheckingAccount info) {
			JTextField deposit_field_1 = new JTextField(8);
			JButton Deposit = new JButton("Deposit");
			JTextField withdraw_field_1 = new JTextField(8);
			JButton Withdraw = new JButton("Withdraw");

			JPanel panel = new JPanel();
			add(panel);

			JLabel intro = new JLabel("Your current Checkings Balance is " + info.getBalance());
			panel.add(intro);

			panel.add(deposit_field_1);
			panel.add(Deposit);
			panel.add(withdraw_field_1);
			panel.add(Withdraw);
			setSize(800, 400);
			setLocation(200, 100);
			setVisible(true);

			Deposit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					float amount = Float.parseFloat(deposit_field_1.getText());
					info.deposit(amount);
					System.out.println(info.getBalance());
					intro.setText("Your current Checkings Balance is " + info.getBalance());
				}
			});

			Withdraw.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					float amount = Float.parseFloat(deposit_field_1.getText());
					info.withdraw(amount);
					System.out.println(info.getBalance());
					intro.setText("Your current Savings Balance is " + info.getBalance());
				}
			});
		}
	}

	public class createLoansUI extends JFrame {
		public createLoansUI(Customer current, Loans modify) {
			JLabel interest_info = new JLabel("Choose the interest rate");
			JLabel amount = new JLabel("Enter amount to borrow");
			JTextField borrow = new JTextField(7);
			ButtonGroup interestOptions = new ButtonGroup();
			JRadioButton option1 = new JRadioButton("1 Month: 3% interest rate");
			JRadioButton option2 = new JRadioButton("3 Month: 5% interest rate");
			JRadioButton option3 = new JRadioButton("6 Month: 8% interest rate");
			interestOptions.add(option1);
			interestOptions.add(option2);
			interestOptions.add(option3);

			JPanel panel = new JPanel();
			add(panel);

			panel.add(interest_info);
			panel.add(interest_info);
			panel.add(borrow);
			panel.add(option1);
			panel.add(option2);
			panel.add(option3);
			panel.add(borrow);

			setSize(1200, 600);
			setLocation(200, 100);
			setVisible(true);

			option1.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					if (Integer.parseInt(borrow.getText()) != 0) {
						modify.value = Integer.parseInt(borrow.getText());
						modify.interest = (float) 0.03;
						modify.lengthOfLoan = 1;
						current.addLoan(modify);
						LoansListUI goBack = new LoansListUI(current);
						dispose();
					}

				}
			});

			option2.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					if (Integer.parseInt(borrow.getText()) != 0) {
						modify.value = Integer.parseInt(borrow.getText());
						modify.interest = (float) 0.05;
						modify.lengthOfLoan = 3;
						current.addLoan(modify);
						LoansListUI goBack = new LoansListUI(current);
						dispose();
					}
				}
			});

			option3.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					if (Integer.parseInt(borrow.getText()) != 0) {
						modify.value = Integer.parseInt(borrow.getText());
						modify.interest = (float) 0.08;
						modify.lengthOfLoan = 6;
						current.addLoan(modify);
						LoansListUI goBack = new LoansListUI(current);
						dispose();
					}

				}
			});

		}
	}

	public class LoansUI extends JFrame {
		public LoansUI(Customer current, Loans this_loan) {
			JTextField take_field_1 = new JTextField(8);
			JPanel panel = new JPanel();
			add(panel);
			panel.add(take_field_1);
			String report = "Current Loan's Value: " + this_loan.value +  "\n Current Loan's Interest: " + this_loan.interest;
			JTextArea area = new JTextArea(5, 20);
	        area.setEditable(false);
	        area.append(report);
	        panel.add(area);
			setSize(1200, 600);
			setLocation(200, 100);
			setVisible(true);
		}
	}

	public class LoansListUI extends JFrame {
		public LoansListUI(Customer current) {
			JButton makeLoan = new JButton("Request a Loan");
			JButton addCollateral = new JButton("Add Collateral");
			String condition = "not available";
			if(current.collateral == true) {
				condition = "available";
			}
			JLabel collateral = new JLabel("our collateral is " + condition);
			JPanel panel = new JPanel();
			add(panel);

			for (int i = 0; i < current.customer_loan.size(); i++) {
				panel.add(new JButton((i + 1) + " "));
			}
			for (int i = 0; i < panel.getComponentCount(); i++) {
				JButton toMod = (JButton) panel.getComponent(i);
				int currently = i;
				toMod.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						// Show info
						LoansUI summary = new LoansUI(current, current.customer_loan.get(currently));
						dispose();
					}
				});
			}
			
			panel.add(addCollateral);

			panel.add(makeLoan);
			panel.add(collateral);

			makeLoan.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Loans modify = new Loans(); // placeholder
					createLoansUI make = new createLoansUI(current, modify);
				}
			});

			setSize(800, 400);
			setLocation(200, 100);
			setVisible(true);
			
			addCollateral.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					if (current.collateral == false) {
						current.collateral = true;
					}
				}
			});
		}
	}
	/*
	 * ---------------------------------------------IMPORTANT
	 * JFRAME---------------------------------------
	 */

	public class CustomerHomepageUI extends JFrame {
		public CustomerHomepageUI(Customer current_customer) {
			/*
			 * Inside CustomerUI actual main interface - i.e. has to go through validation
			 * or make a new one TODO: * Make Loan Button
			 */
			JButton checking = new JButton("Checkings");
			JButton savings = new JButton("Savings");
			JButton loans = new JButton("Loan");
			JPanel panel = new JPanel();
			add(panel);
			panel.add(checking);
			panel.add(savings);
			panel.add(loans);
			panel.add(new JLabel("Welcome " + current_customer.getName()));
			setSize(800, 400);
			setLocation(200, 100);
			setVisible(true);

			checking.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.out.println(current_customer.customer_checking);
					if (current_customer.customer_checking == null) {
						// Customer needs to create 1
						CreateCheckingsUI making_one = new CreateCheckingsUI(current_customer);
					} else {
						CheckingsUI checking_in_use = new CheckingsUI(current_customer.customer_checking); // pass in
																											// that info
					}
				}
			});

			savings.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (current_customer.customer_saving == null) {
						// Customer needs to create 1
						CreateSavingsUI making_one = new CreateSavingsUI(current_customer);
					} else {
						SavingsUI checking_in_use = new SavingsUI(current_customer.customer_saving); // pass in that
																										// info
					}
				}
			});

			loans.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					LoansListUI loans = new LoansListUI(current_customer);
				}
			});

		}
	}

	/*
	 * --------------------------------MAIN JFRAME
	 * --------------------------------------------
	 */

	public CustomerUI() {
		JButton btn_login = new JButton("Log In");
		JButton btn_create_user = new JButton("Create a new account");
		JPanel panel = new JPanel();
		add(panel);

		panel.add(btn_login);
		panel.add(btn_create_user);
		setSize(800, 400);
		setLocation(200, 100);
		setVisible(true);

		btn_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// go to login page?
				/*
				 * Log in page, should bring them to their own special frame They can create
				 * Checkings/Savings Check their Accounts (both saving and checking) Check loan
				 * amount/Make loans
				 */
				LoginPageUI loginpage = new LoginPageUI();
				dispose();
			}
		});

		btn_create_user.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// go to sign in page
				/*
				 * Do everything above except we need to register the data
				 */
				RegisterPageUI registerpage = new RegisterPageUI();
				dispose();
			}

		});
	}
}