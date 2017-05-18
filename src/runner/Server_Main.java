package runner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//Server Socket Object is present in this package
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Server_Main {

	private static ServerSocket ss;

	public static void main(String[] args) throws IOException {
		
		System.out.println("Server signing ON");
		System.out.println((new SimpleDateFormat("MM/dd/yyyy hh:mm:ss")).format(
								new Date(((new Date()).getTime()))));

		ss = new ServerSocket(9081);
		Socket soc = ss.accept();
		System.out.println("Server says connection established");
		
		BufferedReader br = new BufferedReader(
								new InputStreamReader(
									soc.getInputStream()
								)
							);
		
		String str = br.readLine();
		
		while(!str.equals("end"))
		{
			System.out.println("Server received : " + str);	
			str = br.readLine();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		System.out.println("Server signing OFF");

	}
}
