package runner;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class L2 implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {

		try {

			String str1 = Server_Main.jtf.getText();
			Server_Main.jta.append("Server : " + str1 + "\n");
			Server_Main.jtf.setText("");
			Server_Main.pw.println(str1);
			
			if(str1.equals("end"))
			{
				System.out.println("Server signing OFF from Listener class");
				Server_Main.pw.println(str1);
				System.exit(0);
			}
	
		} catch (Exception e1) {
			System.out.println("Exception Printed");
		}
	}

}
