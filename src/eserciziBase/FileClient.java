package eserciziBase;

import java.io.*;
import java.net.*;

public class FileClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Socket s = null;
		BufferedReader b = null;
		PrintStream os = null;
		
		try {
			s = new Socket("localhost", 11111); // IP e porta del server
			b = new BufferedReader(new InputStreamReader(s.getInputStream()));
			os = new PrintStream(new BufferedOutputStream(s.getOutputStream()));
		} catch (IOException e) {
			System.err.println(e.getMessage());
			System.exit(1);
		}
		System.out.println("Socket creata: " + s);
		// --- controllo argomenti
		if (args.length == 0) {
			os.println("Missing file name");
			os.flush();
			os.close();
			try {
				b.close();
				s.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
			System.exit(1);
		}
		
		// --- invio messaggio
		System.out.println("Sending " + args[0]);
		os.println(args[0]);
		os.flush();
		
		// --- stampa risposta del server
		System.out.println("Attesa risposta...");
		String line = null;
		try {
			while ((line = b.readLine()) != null) {
				System.out.println("Messaggio: " + line);
			}
			b.close();
			os.close();
			s.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}

}
