package runner;

import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
//Server Socket Object is present in this package
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class Server_Main {

	private static ServerSocket ss;
	static PrintWriter pw;
	public static JTextField jtf;
	static JTextArea jta ;

	public static void main(String[] args) throws IOException {

		System.out.println("Server signing ON");
		System.out.println((new SimpleDateFormat("MM/dd/yyyy hh:mm:ss")).format(new Date(((new Date()).getTime()))));

		JFrame j1 = new JFrame("Server Application");
		jta = new JTextArea();
		j1.add(BorderLayout.CENTER, jta);
		
		JPanel jp = new JPanel();
		jtf = new JTextField(10);
		JButton jb = new JButton("Send");
		
		jp.add(jtf);
		jp.add(jb);
		j1.add(BorderLayout.SOUTH, jp);

		L2 l = new L2();
		jb.addActionListener(l);


		j1.setVisible(true);
		j1.setSize(500, 500);
		j1.setLocation(510, 0);
		j1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		ss = new ServerSocket(9081);
		Socket soc = ss.accept();
		System.out.println("Server says connection established");

		BufferedReader br = new BufferedReader(new InputStreamReader(soc.getInputStream()));
		pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(soc.getOutputStream())), true);
		
		
		
		
		
		
		
		
		
		
		String str = br.readLine();

		while (!str.equals("end")) {
			jta.append("Client said : " + str + "\n");
			//pw.println(str);
			str = br.readLine();
		}
		pw.println(str);
		System.out.println("Server signing OFF from main class");
		System.exit(0);

	}
}
