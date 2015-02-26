import javax.swing.SwingUtilities;
import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		
		int pass;
		int passAdmin = 1111;
		
		//JOptionPane.showMessageDialog(null, "Welcome to Our System", "ATM", 
	//			JOptionPane.INFORMATION_MESSAGE);
		
		pass = Integer.parseInt(JOptionPane.showInputDialog(null, "Please Enter Your PIN", "ATM",
				JOptionPane.QUESTION_MESSAGE));
		
		if(pass == passAdmin){
			
			JOptionPane.showMessageDialog(null, "Welcome Admin!");}
		
		ATM atm = new ATM();
		
		
		SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	atm.makeATMGui();
                atm.setVisible(true);

            }
        });

	}

}
