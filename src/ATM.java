import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

enum Note{
	notes500(500), notes200(200), notes100(100), notes50(50);
	private int amount;    

    Note(int amount) {        
        this.amount = amount;
   }
  
}

    
public class ATM extends JFrame implements ActionListener{
	private Note notes500 = Note.notes500;
	private Note notes200 = Note.notes200;
	private Note notes100 = Note.notes100;
	private Note notes50 = Note.notes50;
	private int countNotes500 = 2;
	private int countNotes200 = 4;
	private int countNotes100 = 7;
	private int countNotes50 = 10;
	int MAX_BALANCE = 3000;
	private int wid, addNote, b;
	private JButton addNotes, getCash, getBalance, getQuantity;
	private JLabel label;

	
	public int getCountNotes500() {
		return countNotes500;
	}
	

	public void setCountNotes500(int countNotes500) {
		this.countNotes500 = countNotes500;
	}

	public int getCountNotes200() {
		return countNotes200;
	}

	public void setCountNotes200(int countNotes200) {
		this.countNotes200 = countNotes200;
	}

	public int getCountNotes100() {
		return countNotes100;
	}

	public void setCountNotes100(int countNotes100) {
		this.countNotes100 = countNotes100;
	}

	public int getCountNotes50() {
		return countNotes50;
	}

	public void setCountNotes50(int countNotes50) {
		this.countNotes50 = countNotes50;
	}
	
	public ATM() {
        this.setTitle("ATM Admin");
        this.setLayout(new GridLayout(1, 2));
        this.setSize(1000, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
	
	public void makeATMGui(){	       
        label = new JLabel();        
		add(label);		
		label.setFont(new Font("Tahoma", Font.BOLD, 16));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(4, 1));
		addNotes = new JButton("Add notes");
		getCash = new JButton("Get cash");
		getBalance = new JButton("Get balance");
		getQuantity = new JButton("Get quantity");	
		buttonPanel.add(addNotes);
		buttonPanel.add(getCash);
		buttonPanel.add(getBalance);
		buttonPanel.add(getQuantity);		
		this.add(buttonPanel);
		addNotes.addActionListener(this);
		getCash.addActionListener(this);
		getBalance.addActionListener(this);
		getQuantity.addActionListener(this);
		this.setResizable(false);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
	
		if(source == addNotes){
		
		addNote = Integer.parseInt(JOptionPane.showInputDialog(null, "Please add notes divisible by 50",
					"ATM",JOptionPane.INFORMATION_MESSAGE));
		
				if((MAX_BALANCE + addNote)<3000&&MAX_BALANCE%50==0&&(MAX_BALANCE + addNote)%50==0){
					b = MAX_BALANCE + addNote;		
				label.setText("Notes have been successfully added");
			}
			else if(MAX_BALANCE%50 == 0&&(MAX_BALANCE + addNote)>=3000){
				label.setText("Quantity of notes should not exceed 3000 HRV");
			} 
			else{
				label.setText("Notes are not divisible by 50");
			}

		
		}	
			if(source == getCash){
	
			wid = Integer.parseInt(JOptionPane.showInputDialog(null, "Please Enter Amount of Cash Withdrawals",
					"ATM",JOptionPane.INFORMATION_MESSAGE));
			if(wid<=MAX_BALANCE&&wid%50==0){
				b = MAX_BALANCE - wid;
				label.setText("Please take Your money");
			}
			else if(wid<=MAX_BALANCE&&wid%50!=0){
				JOptionPane.showMessageDialog(null,"Please enter a number divisible by 50", "ATM", JOptionPane.INFORMATION_MESSAGE);
			}
		else{
			label.setText("This operation can't be performed" );
		}
		}
			
			else if(source == getBalance){
				label.setText("Your Balance is  " + b + " HVR");
				}
			
			else if(source == getQuantity){
				
				String f = JOptionPane.showInputDialog(null, "Please select notes:\n"+"[1] '500 notes'\n"+
						"[2] '200 notes'\n"+"[3] '100 notes'\n"+"[4] '50 notes'\n",
						"ATM",JOptionPane.QUESTION_MESSAGE);
							
							int num = Integer.parseInt(f);
							if(num == 1){
								
								 if(b < 500){
										JOptionPane.showMessageDialog(null, "Quantity of '500 notes' is " + 0 + " item");
									    }
								 if(b == 500){
								JOptionPane.showMessageDialog(null, "Quantity of '500 notes' is " + 1 + " item");
							    }
								else if (b > 500){
									JOptionPane.showMessageDialog(null, "Quantity of '500 notes' is " + getCountNotes500() + " items");
								}
								}
							
							if(num == 2){
								
								if(b < 200){
									JOptionPane.showMessageDialog(null, "Quantity of '200 notes' is " + 0 + " item");
								    }
								 if(b >= 200 && b < 400){
										JOptionPane.showMessageDialog(null, "Quantity of '200 notes' is " + 1 + " item");
									    }
								 else if(b >= 400 && b < 600){
										JOptionPane.showMessageDialog(null, "Quantity of '200 notes' is " + 2 + " items");
								    }
								 else if(b >= 600 && b < 800){
										JOptionPane.showMessageDialog(null, "Quantity of '200 notes' is " + 3 + " items");
								    }
								 
								 else if(b > 800){
								JOptionPane.showMessageDialog(null, "Quantity of '200 notes' is " + getCountNotes200() + " items");
							}
							}
							if(num == 3){
								
								if(b < 100){
									JOptionPane.showMessageDialog(null, "Quantity of '100 notes' is " + 0 + " item");
								    }
								if(b >= 100 && b < 200){
									JOptionPane.showMessageDialog(null, "Quantity of '100 notes' is " + 1 + " item");
								    }
								if(b >= 200 && b < 300){
									JOptionPane.showMessageDialog(null, "Quantity of '100 notes' is " + 2 + " items");
								    }
								if(b >= 300 && b < 400){
									JOptionPane.showMessageDialog(null, "Quantity of '100 notes' is " + 3 + " items");
								    }
								if(b >= 400 && b < 500){
									JOptionPane.showMessageDialog(null, "Quantity of '100 notes' is " + 4 + " items");
								}
									
								if(b >= 500 && b < 600){
									JOptionPane.showMessageDialog(null, "Quantity of '100 notes' is " + 5 + " items");
									    }	
								if(b >= 600 && b < 700){
									JOptionPane.showMessageDialog(null, "Quantity of '100 notes' is " + 6 + " items");
									    }	
								    
								else if(b >= 700){
								JOptionPane.showMessageDialog(null, "Quantity of '100 notes' is " + getCountNotes100() + " items");
							}
							}
							if(num == 4){
								
								if(b == 50){
									JOptionPane.showMessageDialog(null, "Quantity of '50 notes' is " + 1 + " item");
								    }
								if(MAX_BALANCE == 100){
									JOptionPane.showMessageDialog(null, "Quantity of '50 notes' is " + 2 + " items");
								    }
								
								if(b == 150){
									JOptionPane.showMessageDialog(null, "Quantity of '50 notes' is " + 3 + " items");
								    }
								
								if(b == 200){
									JOptionPane.showMessageDialog(null, "Quantity of '50 notes' is " + 4 + " items");
								    }
								
								if(b == 250){
									JOptionPane.showMessageDialog(null, "Quantity of '50 notes' is " + 5 + " items");
								    }
								
								if(b == 300){
										JOptionPane.showMessageDialog(null, "Quantity of '50 notes' is " + 6 + " items");
								    }
								
								if(b == 350){
									JOptionPane.showMessageDialog(null, "Quantity of '50 notes' is " + 7 + " items");
								    }
								
								if(b == 400){
									JOptionPane.showMessageDialog(null, "Quantity of '50 notes' is " + 8 + " items");
								    }
								
								if(b == 450){
									JOptionPane.showMessageDialog(null, "Quantity of '50 notes' is " + 9+ " items");
								    }
								else{
								JOptionPane.showMessageDialog(null, "Quantity of '50 notes' is " + getCountNotes50() + " items");
							} 
							
							}
			}
	}
}