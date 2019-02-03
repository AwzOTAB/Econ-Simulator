import java.awt.EventQueue;
import java.util.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Color;
import diffutils.*;
import src.me.xdrop.fuzzywuzzy.FuzzySearch;

public class GUI {

	private JFrame frame;
	private JTextField txtInput;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
		
	}

	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//create labels for all variables that needs to be stored, setText(gettext + 1);
		
		frame = new JFrame();
		frame.setBounds(100, 100, 549, 434);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblCurrentPhase = new JLabel("Current Phase: ");
		lblCurrentPhase.setBounds(29, 19, 107, 16);
		frame.getContentPane().add(lblCurrentPhase);
		lblCurrentPhase.setVisible(false);
		
		JLabel phaseLabel = new JLabel("New label");
		phaseLabel.setBounds(138, 19, 193, 16);
		frame.getContentPane().add(phaseLabel);
		phaseLabel.setVisible(false);
		
		JLabel mainLabel = new JLabel("Welcome to the Economy Simulator!");
		mainLabel.setVerticalAlignment(SwingConstants.TOP);
		mainLabel.setBounds(20, 47, 489, 128);
		frame.getContentPane().add(mainLabel);
		
		txtInput = new JTextField();
		txtInput.setBounds(198, 349, 150, 26);
		frame.getContentPane().add(txtInput);
		txtInput.setColumns(10);
		txtInput.setVisible(false);
		
		ArrayList<String> hints = new ArrayList<String>();
		hints.add("<html>Profits from the market still remain weak during the Reflation Phase.</html>");
		hints.add("<html>The yield curve steepens as the Central Bank fully promotes growth in the economy by initiating its expansionary policies.</html>");
		hints.add("<html>Real yields plummet as the GDP growth of the economy becomes sluggish.</html>");
		hints.add("<html>Accelerating economic growth provides plenty of room for industries to develop as well.</html>");
		hints.add("<html>The yield curve tend to shifts upwards and flatten during the Overheat Phase.</html>");
		hints.add("<html>When inflation undergoes considerable growth, investing in real assets is a better choice.</html>");
		hints.add("<html>Not many investment choices are able to maintain their stable positive return in the Stagflation Phase of the economy.</html>");
		hints.add("<html>Low productivity contributes heavily to the stock market slumps of this economy.</html>");
		hints.add("<html>The rallying of bond returns is delayed often because the Central Bank refuses to ease its contractionary policies until inflation has peaked.</html>");
		
		JButton btnContinue = new JButton("Continue");
		btnContinue.setBounds(214, 379, 117, 29);
		frame.getContentPane().add(btnContinue);
		btnContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainLabel.setText("<html>In this simulation, you will learn a lot of useful, practical, and interesting economic facts that will also help you out in the real world. Let's first start by entering your name: </html>");
				btnContinue.setVisible(false);
				txtInput.setVisible(true);
				
			}
			
		});	
		
		JButton name = new JButton("Continue");
		name.setBounds(214, 379, 117, 29);
		frame.getContentPane().add(name);
		name.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
							
					if(txtInput.getText().equals(""))
						{
							mainLabel.setText("Please enter your name.");
						}
					else
						{
							mainLabel.setText(txtInput.getText() + ", Nice to meet you.");
							name.setVisible(false);
							txtInput.setVisible(false);
						}
				}
		});
			
		JButton turns1 = new JButton("Continue");
		turns1.setBounds(214, 379, 117, 29);
		frame.getContentPane().add(turns1);
		turns1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {	
					mainLabel.setText("<html>This simulation is turn-based. For how many turns do you want to simulate? (each turn lasts for approximately half a minute) :</html>");
					txtInput.setVisible(true);
					turns1.setVisible(false);
				}
		});
			
		JButton turns2 = new JButton("Continue");
		turns2.setBounds(214, 379, 117, 29);
		frame.getContentPane().add(turns2);
			
		JLabel lblTurn = new JLabel("Turn:");
		lblTurn.setBounds(390, 19, 61, 16);
		frame.getContentPane().add(lblTurn);
		lblTurn.setVisible(false);
			
		JLabel turnNo = new JLabel("0");
		turnNo.setBounds(431, 19, 61, 16);
		frame.getContentPane().add(turnNo);
		turnNo.setVisible(false);
		
		JLabel turnStorage = new JLabel("0");
		turnStorage.setBounds(463, 19, 61, 16);
		frame.getContentPane().add(turnStorage);
		turnStorage.setVisible(false);
			
		JLabel FstLabel = new JLabel("Cash Portfolio:");
		FstLabel.setBounds(93, 221, 416, 18);
		frame.getContentPane().add(FstLabel);
		FstLabel.setVisible(false);
			
		JLabel SndLabel = new JLabel("Stocks Portfolio:");
		SndLabel.setBounds(93, 242, 410, 16);
		frame.getContentPane().add(SndLabel);
		SndLabel.setVisible(false);
			
		JLabel TrdLabel = new JLabel("Bonds Portfolio:");
		TrdLabel.setBounds(93, 262, 399, 16);
		frame.getContentPane().add(TrdLabel);
		TrdLabel.setVisible(false);
			
		JLabel FthLabel = new JLabel("Commodities Portfolio:");
		FthLabel.setBounds(93, 281, 425, 16);
		frame.getContentPane().add(FthLabel);
		FthLabel.setVisible(false);
		
		
	
			
		turns2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
						try{
							if(txtInput.getText().equals(""))
							{
								mainLabel.setText("Please enter the number of turns you want the simulator to run.");
							}
							else if(Integer.parseInt(txtInput.getText()) < 8)
							{
								mainLabel.setText("<html>It's recommended that you at least play for 8 turns. It's for your learning.</html>");
							}
							else if(Integer.parseInt(txtInput.getText()) > 30)
							{
								mainLabel.setText("<html>You will have already learned almost every concept in this simulation by Turn 30.</html>");
							}
							else
							{
								turnStorage.setText(txtInput.getText());
								mainLabel.setText("<html>You will only have one Portfolio to start with, the Cash Portfolio. How much cash would you like to start the simulation with? </html>");
								turns2.setVisible(false);
							}
						}catch(Exception e1){
							JOptionPane.showMessageDialog(null, "Invalid input. Try again.");
							}
						}
		});
		
		
			
			JButton startingCash = new JButton("Continue");
			startingCash.setBounds(214, 379, 117, 29);
			frame.getContentPane().add(startingCash);
			
			JLabel cashchange = new JLabel("0.0");
			cashchange.setBounds(419, 222, 73, 16);
			frame.getContentPane().add(cashchange);
			cashchange.setVisible(false);
			
			JLabel stockschange = new JLabel("0.0");
			stockschange.setBounds(419, 242, 73, 16);
			frame.getContentPane().add(stockschange);
			stockschange.setVisible(false);
			
			JLabel bondschange = new JLabel("0.0");
			bondschange.setBounds(418, 262, 81, 16);
			frame.getContentPane().add(bondschange);
			bondschange.setVisible(false);
			
			JLabel comchange = new JLabel("0.0");
			comchange.setBounds(419, 281, 73, 16);
			frame.getContentPane().add(comchange);
			comchange.setVisible(false);
			
			textField = new JTextField();
			textField.setBounds(198, 151, 150, 26);
			frame.getContentPane().add(textField);
			textField.setColumns(10);
			textField.setVisible(false);
			
			
			JButton btnBuyHint = new JButton("Get Hint");
			btnBuyHint.setBounds(225, 179, 96, 29);
			frame.getContentPane().add(btnBuyHint);
			btnBuyHint.setVisible(false);
			
			JButton hintButton = new JButton("Continue");
			hintButton.setBounds(214, 379, 117, 29);
			frame.getContentPane().add(hintButton);
			hintButton.setVisible(false);
			
			JLabel lblTotal = new JLabel("Total Balance & Net Profit:");
			lblTotal.setBounds(182, 302, 327, 16); 
			frame.getContentPane().add(lblTotal);
			lblTotal.setVisible(false);
			
			JLabel totalStorage = new JLabel("");
			totalStorage.setBounds(41, 384, 61, 16);
			frame.getContentPane().add(totalStorage);
			totalStorage.setVisible(false);
			
			
			
			startingCash.setVisible(true);
			startingCash.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
							try{
								if(txtInput.getText().equals(""))
								{
									mainLabel.setText("<html>Please enter the amount of money you want to start the simulation with</html>.");
								}
								else if(Integer.parseInt(txtInput.getText()) < 100000)
								{
									mainLabel.setText("<html>You're too conservative. Put at least a hundred thousand!</html>");
								}
								else if(Integer.parseInt(txtInput.getText()) > 5000000)
								{
									mainLabel.setText("<html>Maximum principal is five million!</html>");
								}
								else
								{
									mainLabel.setText("<html>Your principal is $" + Double.parseDouble(txtInput.getText()) + ", and this simulation will last for "+ turnStorage.getText() + " turns. Good luck and have fun!</html>");
									txtInput.setVisible(false);
									startingCash.setVisible(false);
									
									CashPortfolio $c = new CashPortfolio("Cash Portfolio", Double.parseDouble(txtInput.getText()));
									StocksPortfolio $s = new StocksPortfolio("Stocks Portfolio", 0);
									BondsPortfolio $b = new BondsPortfolio("Bonds Portfolio", 0);
									CommoditiesPortfolio $com = new CommoditiesPortfolio("Commodities Portfolio", 0);
									
									JButton turnLoop = new JButton("Continue");
									turnLoop.setBounds(214, 379, 117, 29);
									frame.getContentPane().add(turnLoop);
									
									JLabel phaseCounterStorage = new JLabel("0");
									phaseCounterStorage.setBounds(6, 392, 61, 16);
									frame.getContentPane().add(phaseCounterStorage);
									phaseCounterStorage.setVisible(false);
									
									
									JButton btnYes = new JButton("Yes");
									btnYes.setBounds(122, 357, 117, 29);
									frame.getContentPane().add(btnYes);
									btnYes.setVisible(false);
									
									JButton btnNo = new JButton("No");
									btnNo.setBounds(300, 357, 117, 29);
									frame.getContentPane().add(btnNo);
									btnNo.setVisible(false);
									
									JButton changeStart = new JButton("Continue");
									changeStart.setVisible(true);
									changeStart.setBounds(214, 379, 117, 29);
									frame.getContentPane().add(changeStart);
									
									JLabel cashStor = new JLabel("0.0");
									cashStor.setBounds(6, 392, 61, 16);
									frame.getContentPane().add(cashStor);
									cashStor.setVisible(false);
									
									JLabel stocksStor = new JLabel("0.0");
									stocksStor.setBounds(6, 392, 61, 16);
									frame.getContentPane().add(stocksStor);
									stocksStor.setVisible(false);
									
									JLabel bondsStor = new JLabel("0.0");
									bondsStor.setBounds(6, 392, 61, 16);
									frame.getContentPane().add(bondsStor);
									bondsStor.setVisible(false);
									
									JLabel comStor = new JLabel("0.0");
									comStor.setBounds(6, 392, 61, 16);
									frame.getContentPane().add(comStor);
									comStor.setVisible(false);
									
									JLabel[] storage = {cashStor, stocksStor, bondsStor, comStor};
									
									turnLoop.addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent e) {
											
											int phaseCounter = Integer.parseInt(phaseCounterStorage.getText());
											String[] phase = {"Reflation","Recovery","Overheat","Stagflation"};
											Portfolio[] assets = {$c, $s, $b, $com};
											
											//game begins
											
												if(Integer.parseInt(turnStorage.getText()) == Integer.parseInt(turnNo.getText()))
												{
													mainLabel.setText("Thank you so much for playing my game!");
													turnLoop.setVisible(false);
													lblCurrentPhase.setVisible(false);
													phaseLabel.setVisible(false);
													lblTurn.setVisible(false);
													turnNo.setVisible(false);
													JLabel[] labels = {FstLabel, SndLabel, TrdLabel, FthLabel};
													JLabel[] changes = {cashchange, stockschange, bondschange, comchange};
													double[] value = new double[4];
													int a = Integer.parseInt(turnNo.getText());
													
													for(int i = 0; i < 4; i++)
													{
														if(a != 1)
														{
															double xx = Math.round(assets[i].get$() * 100.0) / 100.0;
															value[i] = xx;
															labels[i].setVisible(true);
															
															String str = "Balance in " + assets[i].getName() + ": $" + xx;
															
															
															if(Double.parseDouble(storage[i].getText()) != 0.0)
															{
																if(Double.parseDouble(storage[i].getText()) == assets[i].get$())
																{
																	changes[i].setText("  (+0.00%)");
																	str += changes[i].getText();
																	labels[i].setText("<html> "+ str +" </html>");
																	labels[i].setForeground(Color.BLACK);
																}
																
																else if(assets[i].get$() > Double.parseDouble(storage[i].getText()))
																{
																	
																	double n = 100 * (assets[i].get$() - Double.parseDouble(storage[i].getText()))/Double.parseDouble(storage[i].getText());
																	changes[i].setText("    (+" + (Math.round(n * 100.0) / 100.0) + "%)");
																	str += changes[i].getText();
																	labels[i].setText("<html> "+ str +" </html>");
																	labels[i].setForeground(new Color(60, 179, 113));
																}
																
																else
																{
																	double n = 100 * ((Double.parseDouble(storage[i].getText()) - (assets[i].get$()))/Double.parseDouble(storage[i].getText()));
																	changes[i].setText("    (-" + (Math.round(n * 100.0) / 100.0) + "%)");
																	str += changes[i].getText();
																	labels[i].setText("<html> "+ str +" </html>");
																	labels[i].setForeground(Color.RED);
																}
															}
															else
															{
																changes[i].setText("");
																str += changes[i].getText();
																labels[i].setText("<html> "+ str +" </html>");
																labels[i].setForeground(Color.BLACK);
															}
															
															changes[i].setVisible(false);
															
														}
														else
														{
															double x1 = Math.round(assets[i].get$() * 100.0) / 100.0;
															value[i] = x1;
															labels[i].setVisible(true);
															
															String str = "Balance in " + assets[i].getName() + ": $" + x1;
															labels[i].setText("<html> "+ str +" </html>");
															
														}
														
														
														double total = 0;
														
														for(int j = 0; j < 4; j++)
														{
															total += assets[j].get$();
														}
														double totalRound = Math.round(total * 100.0) / 100.0;
														
														String str = "Total Balance and Net Profit: $" + totalRound;
														lblTotal.setBounds(111, 302, 386, 16);
														if(Double.parseDouble(totalStorage.getText()) == total)
														{
															str += "  (+0.00%)";
															lblTotal.setText("<html> "+ str +" </html>");
															lblTotal.setForeground(Color.BLACK);
														}
														
														else if(Double.parseDouble(totalStorage.getText()) < total)
														{
															double n = 100 * (total - Double.parseDouble(totalStorage.getText()))/Double.parseDouble(totalStorage.getText());
															str += "    (+" + (Math.round(n * 100.0) / 100.0) + "%)";
															lblTotal.setText("<html> "+ str +" </html>");
															lblTotal.setForeground(new Color(60, 179, 113));
														}
														
														else
														{
															double n = 100 * (Double.parseDouble(totalStorage.getText()) - total)/Double.parseDouble(totalStorage.getText());
															str += "    (-" + (Math.round(n * 100.0) / 100.0) + "%)";
															lblTotal.setText("<html> "+ str +" </html>");
															lblTotal.setForeground(Color.RED);
														}
														
														lblTotal.setVisible(true);

													}
													sort(value, labels);
													
													double total = 0;
													for(int i = 0; i < 4; i++)
													{
														total += assets[i].get$();
													}
													double diff = 100 * (total - Double.parseDouble(totalStorage.getText()))/Double.parseDouble(totalStorage.getText());
													
													if(diff < -1.5)
													{
														mainLabel.setText("<html> Your net loss is " + (Math.round(diff * 100.0) / 100.0) + "%. However, people who lost the most are also the ones that learns the most. Reflect on your decisions and hope for a better result in another try!</html>");
													}
													else if(diff < 0)
													{
														mainLabel.setText("<html> Your net loss is " + (Math.round(diff * 100.0) / 100.0) + "%. Although it may not seem like a big deal to lose this much percentage of your principal, in real life, the amount of time you've spent on achieving this result will be the more significant cost. Reflect on your decisions and hope for a better result in another try!</html>");
													}
													else if(diff < 1.5)
													{
														mainLabel.setText("<html> Your net gain is " + (Math.round(diff * 100.0) / 100.0) + "%. Congratulations on your gain! However, if this was your annual profit rate in the real world, then you are barely surviving the average inflation rate in the real economy. You can definitely manage your money efficiently through investing, now lets try to MAKE money through investing!</html>");
													}
													else if(diff < 3)
													{
														mainLabel.setText("<html> Your net gain is " + (Math.round(diff * 100.0) / 100.0) + "%. Congratulations on your gain! Considering how much you've earned by your investments, you might just have a chance of becoming a full-time investor! </html>");
													}
													else
													{
														mainLabel.setText("<html> Your net gain is " + (Math.round(diff * 100.0) / 100.0) + "%. Your achievements have definitely revealed how familiar you are with the economy and the investment clock. You know when and what to invest in, and have emerged victorious. Congrats!</html>");
													}
													
												 
												}
												else
												{
												// printing getPhase();
												//intro to phases, and how many turns each phase lasts 
												
												//shows the labels, phase, and turn number of the simulation
												lblCurrentPhase.setVisible(true); 
												phaseLabel.setVisible(true); 
												lblTurn.setVisible(true); 
												turnNo.setVisible(true);
												
												//updates the new phase and turn number that are being displayed onto the screen
												phaseLabel.setText(phase[phaseCounter]); 
												int x = Integer.parseInt(turnNo.getText()) + 1;
												turnNo.setText("" + x);
												

												String turnstr = turnspecificComments(Integer.parseInt(turnNo.getText()));
												
												//calls a void method that displays different messages based on the turn number (the progression of the simulation)
												int a = Integer.parseInt(turnNo.getText());
												
												//updates directions and notifications
												
												mainLabel.setText(turnstr + "<html> The economy is in the " + phase[phaseCounter] + " phase. Your balance in each portfolio are as follows: </html>" );
												
												
												//makes the next 'Continue' button visible, which will prompt the user to change their investment plans
												changeStart.setVisible(true);
												
												//creating an array of JLabels and an empty double array for future use
												JLabel[] labels = {FstLabel, SndLabel, TrdLabel, FthLabel};
												JLabel[] changes = {cashchange, stockschange, bondschange, comchange};
												double[] value = new double[4];
												
												
												
												for(int i = 0; i < 4; i++)
												{
													if(a != 1)
													{
														double xx = Math.round(assets[i].get$() * 100.0) / 100.0;
														value[i] = xx;
														labels[i].setVisible(true);
														
														String str = "Balance in " + assets[i].getName() + ": $" + xx;
														
														
														if(Double.parseDouble(storage[i].getText()) != 0.0)
														{
															if(Double.parseDouble(storage[i].getText()) == assets[i].get$())
															{
																changes[i].setText("  (+0.00%)");
																str += changes[i].getText();
																labels[i].setText("<html> "+ str +" </html>");
																labels[i].setForeground(Color.BLACK);
															}
															
															else if(assets[i].get$() > Double.parseDouble(storage[i].getText()))
															{
																
																double n = 100 * (assets[i].get$() - Double.parseDouble(storage[i].getText()))/Double.parseDouble(storage[i].getText());
																changes[i].setText("    (+" + (Math.round(n * 100.0) / 100.0) + "%)");
																str += changes[i].getText();
																labels[i].setText("<html> "+ str +" </html>");
																labels[i].setForeground(new Color(60, 179, 113));
															}
															
															else
															{
																double n = 100 * ((Double.parseDouble(storage[i].getText()) - (assets[i].get$()))/Double.parseDouble(storage[i].getText()));
																changes[i].setText("    (-" + (Math.round(n * 100.0) / 100.0) + "%)");
																str += changes[i].getText();
																labels[i].setText("<html> "+ str +" </html>");
																labels[i].setForeground(Color.RED);
															}
														}
														else
														{
															changes[i].setText("");
															str += changes[i].getText();
															labels[i].setText("<html> "+ str +" </html>");
															labels[i].setForeground(Color.BLACK);
														}
														
														changes[i].setVisible(false);
														
													}
													else
													{
														double x1 = Math.round(assets[i].get$() * 100.0) / 100.0;
														value[i] = x1;
														labels[i].setVisible(true);
														
														String str = "Balance in " + assets[i].getName() + ": $" + x1;
														labels[i].setText("<html> "+ str +" </html>");
														
													}

												}
												
												if(a != 1)
												{
													double total = 0;
													for(int i = 0; i < 4; i++)
													{
														total += assets[i].get$();
													}
													double totalRound = Math.round(total * 100.0) / 100.0;
													
													String str = "Total Balance and Net Profit: $" + totalRound;
													lblTotal.setBounds(111, 302, 386, 16);
													if(Double.parseDouble(totalStorage.getText()) == total)
													{
														str += "  (+0.00%)";
														lblTotal.setText("<html> "+ str +" </html>");
														lblTotal.setForeground(Color.BLACK);
													}
													
													else if(Double.parseDouble(totalStorage.getText()) < total)
													{
														double n = 100 * (total - Double.parseDouble(totalStorage.getText()))/Double.parseDouble(totalStorage.getText());
														str += "    (+" + (Math.round(n * 100.0) / 100.0) + "%)";
														lblTotal.setText("<html> "+ str +" </html>");
														lblTotal.setForeground(new Color(60, 179, 113));
													}
													
													else
													{
														double n = 100 * (Double.parseDouble(totalStorage.getText()) - total)/Double.parseDouble(totalStorage.getText());
														str += "    (-" + (Math.round(n * 100.0) / 100.0) + "%)";
														lblTotal.setText("<html> "+ str +" </html>");
														lblTotal.setForeground(Color.RED);
													}
													
													lblTotal.setVisible(true);
													
												}
												else
												{
													double total = 0;
													for(int i = 0; i < 4; i++)
													{
														total += assets[i].get$();
													}
													double totalRound = Math.round(total * 100.0) / 100.0;
													lblTotal.setText("Total Balance: $" + totalRound);
													lblTotal.setVisible(true);
													totalStorage.setText("" + total);
												}
												
												sort(value, labels);

												if(a > 2)
												{
													hintButton.setVisible(true);
												}
												else
												{
													//makes the next 'Continue' button visible, which will prompt the user to change their investment plans
													changeStart.setVisible(true);
												}
												
												hintButton.addActionListener(new ActionListener() {
													public void actionPerformed(ActionEvent e) {
														//ADD THE HINT MECH HERE
														hintButton.setVisible(false);
														btnBuyHint.setVisible(true);
														changeStart.setVisible(true);
														textField.setVisible(true);
														mainLabel.setText("<html> If you would like some hints & tips about the economy, type in what you want to know more about in the following box. If not, press Continue. Think before you click Get Hint to generate your hint since you only have one chance to get a hint each turn! </html> ");
														
														btnBuyHint.addActionListener(new ActionListener() {
															public void actionPerformed(ActionEvent e) {
																if((textField.getText()).equals(""))
																{
																	mainLabel.setText("Please enter what you want to be hinted on. Or press Continue.");
																	
																}
																else
																{
																	String print = "";
																	String y = "" + FuzzySearch.extractOne(textField.getText(), hints);
																	for(int i = 0; i < y.length(); i++)
																	{
																		if(y.indexOf(':') == i)
																		{
																			print = y.substring(i);
																			break;
																		}
																	}
																	
																	mainLabel.setText("<html> Hint" + print + "</html>");
																	btnBuyHint.setVisible(false);
																	textField.setVisible(false);
																	//remove the printed thing from the list
																	hints.remove(print);
																	
																	changeStart.setVisible(true);
																}
															}
														});
														
														}
													});
												
												
												//the next 'Continue' button that asks if the user wants to change their investment plans
												//makes the 'Yes' and 'No' buttons visible to the user
												changeStart.addActionListener(new ActionListener() {
													public void actionPerformed(ActionEvent e) {
														changeStart.setVisible(false);
														txtInput.setVisible(false);
														btnYes.setVisible(true);
														btnNo.setVisible(true);
														btnBuyHint.setVisible(false);
														textField.setVisible(false);
														
														mainLabel.setText("<html>Would you like to change your investments plans? </html>");
														
														String sub;
														String str;
														for(int i = 0; i < 4; i ++)
														{
															str = labels[i].getText();
															labels[i].setForeground(Color.BLACK);
															if(str.indexOf('(') != -1)
															{
																sub = str.substring(0, str.indexOf('('));
																labels[i].setText(sub);
															}
														}
														
														String sub1;
														String str1 = lblTotal.getText();
														lblTotal.setForeground(Color.BLACK);
														if(str1.indexOf('(') != -1)
														{
															sub1 = str1.substring(0, str1.indexOf('('));
															lblTotal.setText(sub1);
														}
														
													}
													
												});
												
												//make button here
												
												
												turnLoop.setVisible(false);
												}
											}
											
										});

									
									btnNo.addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent e) {
											mainLabel.setText("<html>You chose not to change your current investment plan. Press continue to proceed. </html>");
											btnNo.setVisible(false);
											btnYes.setVisible(false);
											txtInput.setVisible(false);
											FstLabel.setVisible(false);
											SndLabel.setVisible(false);
											TrdLabel.setVisible(false);
											FthLabel.setVisible(false);
											lblTotal.setVisible(false);
											Portfolio[] assets = {$c, $s, $b, $com};
											JLabel[] changes = {cashchange, stockschange, bondschange, comchange};
											JLabel[] storage = {cashStor, stocksStor, bondsStor, comStor};
											int phaseCounter = Integer.parseInt(phaseCounterStorage.getText());
											//investments takes effect 
											
											for(int i = 0; i < 4; i++)
											{
												storage[i].setText("" + assets[i].get$());
											}
											
											int a = Integer.parseInt(turnNo.getText());
											
											if(a != 0)
											{
												if(phaseCounter == 0)
												{
													for(int j = 0; j < 4; j++)
													{
														assets[j].ref();
													}
	
												}
												else if(phaseCounter == 1)
												{
													for(int j = 0; j < 4; j++)
													{
														assets[j].rec();
													}
												}
												else if(phaseCounter == 2)
												{
													for(int j = 0; j < 4; j++)
													{
														assets[j].ovr();
													}
												}
												else
												{
													for(int j = 0; j < 4; j++)
													{
														assets[j].stg();
													}
												}
											}
											
											//phase change after even turns
											
											if(a % 2 == 0)
											{
												phaseCounter++;
											}
											
											if(phaseCounter == 4)
											{
												phaseCounter = 0;
											}
											phaseCounterStorage.setText("" + phaseCounter);
											turnLoop.setVisible(true);
										}
									});
									
									
									btnYes.addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent e) {
											mainLabel.setText("<html>Click on what you want to invest in.</html>");
											JLabel[] labels = {FstLabel, SndLabel, TrdLabel, FthLabel};
											
											
											
											JButton btnCash = new JButton("CASH");
											btnCash.setBounds(69, 151, 117, 47);
											frame.getContentPane().add(btnCash);
											btnCash.setVisible(false);
											
											JButton btnStocks = new JButton("STOCKS");
											btnStocks.setBounds(69, 322, 117, 47);
											frame.getContentPane().add(btnStocks);
											btnStocks.setVisible(false);
											
											JButton btnBonds = new JButton("BONDS");
											btnBonds.setBounds(360, 151, 117, 47);
											frame.getContentPane().add(btnBonds);
											btnBonds.setVisible(false);
											
											JButton btnCommodities = new JButton("COMMODITIES");
											btnCommodities.setBounds(360, 322, 117, 45);
											btnCommodities.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
											frame.getContentPane().add(btnCommodities);
											btnCommodities.setVisible(false);
											
											btnCash.setVisible(true);
											btnStocks.setVisible(true);
											btnBonds.setVisible(true);
											btnCommodities.setVisible(true);
											btnNo.setVisible(false);
											btnYes.setVisible(false);
											
											JButton btnCash2 = new JButton("CASH");
											btnCash2.setBounds(69, 151, 117, 47);
											frame.getContentPane().add(btnCash2);
											btnCash2.setVisible(false);
											
											JButton btnStocks2 = new JButton("STOCKS");
											btnStocks2.setBounds(69, 322, 117, 47);
											frame.getContentPane().add(btnStocks2);
											btnStocks2.setVisible(false);
											
											JButton btnBonds2 = new JButton("BONDS");
											btnBonds2.setBounds(360, 151, 117, 47);
											frame.getContentPane().add(btnBonds2);
											btnBonds2.setVisible(false);
											
											JButton btnCommodities2 = new JButton("COMMODITIES");
											btnCommodities2.setBounds(360, 322, 117, 45);
											btnCommodities2.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
											frame.getContentPane().add(btnCommodities2);
											btnCommodities2.setVisible(false);
											
											JButton amountInput = new JButton("Continue");
											amountInput.setBounds(214, 379, 117, 29);
											frame.getContentPane().add(amountInput);
											amountInput.setVisible(false);
											
											JLabel[] changes = {cashchange, stockschange, bondschange, comchange};
											JButton[] buttons = {btnCash, btnStocks, btnBonds, btnCommodities};
											JButton[] buttons2 = {btnCash2, btnStocks2, btnBonds2, btnCommodities2};
											Portfolio[] assets = {$c, $s, $b, $com};
											
											int count = 0;
											for(int i = 0; i < 4; i++)
											{
												if(assets[i].get$() == 0)
												{
													count++;
												}
											}
											
											if(count == 3)
											{
												for(int i = 0; i < 4; i++)
												{
													if(assets[i].get$() != 0)
													{
														buttons[i].setVisible(false);
													}
												}
											}
											
											//DEP INDEX CHANGES-solved
											btnCash.addActionListener(new ActionListener() {
												public void actionPerformed(ActionEvent e) {
													investmentChange(mainLabel, buttons, buttons2, amountInput, changeStart, labels, 0, assets, $c, changes);
												}
											});
											btnStocks.addActionListener(new ActionListener() {
												public void actionPerformed(ActionEvent e) {
													investmentChange(mainLabel, buttons, buttons2, amountInput, changeStart, labels, 1, assets, $s, changes);
												}
											});
											btnBonds.addActionListener(new ActionListener() {
												public void actionPerformed(ActionEvent e) {
													investmentChange(mainLabel, buttons, buttons2, amountInput, changeStart, labels, 2, assets, $b, changes);
												}
											});
											btnCommodities.addActionListener(new ActionListener() {
												public void actionPerformed(ActionEvent e) {
													investmentChange(mainLabel, buttons, buttons2, amountInput, changeStart, labels, 3, assets, $com, changes);
												}
											});
											
										}
									});
									
								}
							}catch(Exception e1){
								JOptionPane.showMessageDialog(null, "Invalid input. Try again.");
								}
							}
						
			});
			
	}
	
	
	//DEP INDEX CHANGES---solllveed
	public void investmentChange(JLabel mainLabel, JButton[] buttons, JButton[] buttons2, JButton amountInput, JButton changeStart, JLabel[] labels, int depIndex, Portfolio[] assets, Portfolio $, JLabel[] changes)
	{
		mainLabel.setText("<html>Click on where you want to withdraw the money from.</html>");
		for(int i = 0; i < 4; i++)
		{
			buttons[i].setVisible(false);
			if(assets[i].get$() != 0)
			{
				buttons2[i].setVisible(true);
			}
			
		}
		buttons2[depIndex].setVisible(false);
		
		buttons2[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//PROBLEM HERE, depIndex changes----sollvleeeddddd
				amountChange(mainLabel, amountInput, buttons2, assets[0], $, labels, changeStart, assets, changes);
			}
		});
		buttons2[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				amountChange(mainLabel, amountInput, buttons2, assets[1], $, labels, changeStart, assets, changes);
			}
		});
		buttons2[2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				amountChange(mainLabel, amountInput, buttons2, assets[2], $, labels, changeStart, assets, changes);
			}
		});
		buttons2[3].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				amountChange(mainLabel, amountInput, buttons2, assets[3], $, labels, changeStart, assets, changes);
			}
		});
		
	}
	//DEP INDEXES DONT CHANGE ---solllveeeddd 
	public void amountChange(JLabel mainLabel, JButton amountInput, JButton[] buttons2, Portfolio withdraw, Portfolio deposit, JLabel[] labels, JButton changeStart, Portfolio[] assets, JLabel[] changes)
	{
		mainLabel.setText("<html>How much do you want to withdraw from your " + withdraw.getName() + " to invest into your " + deposit.getName() + "?</html>");
		txtInput.setVisible(true);
		amountInput.setVisible(true);

		JButton btnwithall = new JButton("Withdraw & Invest All");
		btnwithall.setBounds(358, 349, 150, 46);
		frame.getContentPane().add(btnwithall);
		btnwithall.setVisible(true);
		
		for(int i = 0; i < 4; i++)
		{
			buttons2[i].setVisible(false);
		}
		
		amountInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try{
				if(txtInput.getText().equals(""))
				{
					mainLabel.setText("<html>Please enter the amount of money you want to withdraw and invest</html>.");
				}
				else if(Integer.parseInt(txtInput.getText()) > withdraw.get$())
				{
					mainLabel.setText("<html>Insufficient Funds.</html>");
				}
				else if(Integer.parseInt(txtInput.getText()) < 0)
				{
					mainLabel.setText("<html>Invalid Input.</html>");
				}
				else
				{
					double x = Double.parseDouble(txtInput.getText());
					mainLabel.setText("<html>You have withdrawn $" + x + " from your " + withdraw.getName() + " Portfolio and invested that amount into your " + deposit.getName() + " Portfolio. The following shows your current balances: </html>");
					amountInput.setVisible(false);
					txtInput.setVisible(false);								
					withdraw.withdraw$(x);
					deposit.deposit$(x);
					double[] value = new double[4];
					btnwithall.setVisible(false);
					
					for(int i = 0; i < 4; i++)
					{
						double y = Math.round(assets[i].get$() * 100.0) / 100.0;
						value[i] = y;
						String str = "Balance in " + assets[i].getName() + ": $" + y;
						labels[i].setText("<html> "+ str +" </html>");
					}
					sort(value, labels);
					changeStart.setVisible(true);
					
					for (int i = 0; i < value.length; i++)
			        {
						labels[i].setVisible(true);
			        }
					
				}
				}catch(Exception e1){
					JOptionPane.showMessageDialog(null, "Invalid input. Try again.");
				}
																														
			}
		});
		
		btnwithall.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
					double x = withdraw.get$();
					double round = Math.round(x * 100.0) / 100.0;
					mainLabel.setText("<html>You have withdrawn $" + round + " from your " + withdraw.getName() + " Portfolio and invested that amount into your " + deposit.getName() + " Portfolio. The following shows your current balances: </html>");
					amountInput.setVisible(false);
					txtInput.setVisible(false);								
					withdraw.withdraw$(x);
					deposit.deposit$(x);
					double[] value = new double[4];
					
					for(int i = 0; i < 4; i++)
					{
						double y = Math.round(assets[i].get$() * 100.0) / 100.0;
						value[i] = y;
						String str = "Balance in " + assets[i].getName() + ": $" + y;
						labels[i].setText("<html> "+ str +" </html>");
					}
					sort(value, labels);
					changeStart.setVisible(true);
					btnwithall.setVisible(false);
					for (int i = 0; i < value.length; i++)
			        {
						labels[i].setVisible(true);
			        }
																														
			}
		});
	}
	
	/**
	 * This is a void method that creates a single-use button that displays a message in the GUI when clicked
	 * @param label  the label for where the message is displayed
	 * @param prompt  the message that is being displayed
	 */
	
	public void newContinue(JLabel label, String prompt)
	{
		//creates and adds button to GUI 
		JButton btnContinue = new JButton("Continue");
		btnContinue.setBounds(214, 379, 117, 29);
		frame.getContentPane().add(btnContinue);
		
		//adds an action to the button (code that will be executed only after the button is clicked)
		btnContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				label.setText(prompt);
				btnContinue.setVisible(false);
			}
			
		});
	}
	
	public String turnspecificComments(int i)
	{
		if(i == 0)
		{
			return "<html> ??? </html>";
		}
		else if (i == 1)
		{
			return "<html>In this simulation, each economic phase will last two turns, and different phases will have different effects on each of your portfolios. In each turn, you will be provided with the chance to adjust the balances of your portfolios. Make cautious decisions on how to manage your money based on the current phase of the economy. The economy is currently in the Reflation Phase. Your balance in each portfolio are as follows: </html>";
		}
		else if (i == 2)
		{
			return "<html>The precentages on the right of each of your portfolios show your profit/loss of that portfolio after the previous turn. The percentage next to your total balance shows your net profit/loss so far."; //describe percentages
		}
		else
		{
			return "";
		}
	}
	
	public void sort(double[] value, JLabel[] labels)
	{
		boolean b;
        do
        {
        	b = false;
        	for (int j = 0; j < value.length-1; j++)
        	{    
        		if (value[j] < value[j+1])
		            {
		                // swapping takes place for values
		                double temp = value[j];
		                value[j] = value[j+1];
		                value[j+1] = temp;
		                
		                // swapping takes place for STRINGS INSIDE THE LABELS
		                String temp2 = labels[j].getText();
		                labels[j].setText(labels[j+1].getText());
		                labels[j+1].setText(temp2);
		              
		                //swapp colors
		                Color temp3 = labels[j].getForeground();
		                labels[j].setForeground(labels[j+1].getForeground());
		                labels[j+1].setForeground(temp3);
		                
		                b = true;
		            }
        	}
        }
        while(b);
 
	}
}
