package eserciziBase;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class Client {

	public static void main(String[] args) {
		Socket s = null;
		BufferedReader inputStream = null;
		PrintStream outputStream = null;
		
		try {
			s = new Socket("localhost", 11111); // IP e porta del server 
			inputStream = new BufferedReader(new InputStreamReader(s.getInputStream())); 
		} catch (IOException e) { 
			System.out.println(e.getMessage()); 
			System.exit(1); 
			}
		System.out.println("Socket creata: " + s);
			// invio 
		try { 
			BufferedOutputStream b = new BufferedOutputStream( s.getOutputStream()); 
			outputStream = new PrintStream(b, false); 
			outputStream.println("pippo"); 
			outputStream.flush(); // ricezione 
			String line; 
			while ((line = inputStream.readLine()) != null) { 
				System.out.println("Ricevuto: " + line); 
				if (line.equals("Stop")) 
					break; 
			} 
			outputStream.close(); // chiusura output 
			inputStream.close(); // chiusura input 
			s.close(); // chiusura socket 
			} catch (IOException e) { 
				System.out.println("Error:" + e.getMessage()); 
			}
	}

}
