package eserciziBase;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ClientCalcolatrice {

	public static void main(String args[]) {
		Socket c = null;
		BufferedReader b = null;
		PrintStream os = null;
		Scanner input= new Scanner(System.in);

		//String str=input.nextLine();
		try {
			c = new Socket("localhost", 11111); // IP e porta del server
			b = new BufferedReader(new InputStreamReader(c.getInputStream()));
			os = new PrintStream(new BufferedOutputStream(c.getOutputStream()));
		} catch (IOException e) {
			System.err.println(e.getMessage());
			System.exit(1);
		}
		System.out.println("Socket creata: " + c);
		// invio valori al server (da linea comandi)
		for (int i = 0; i < args.length; i++) {
			System.out.println("Sending " + args[i]);
			os.println(args[i]);
		}
		os.println("0");
		os.flush();
		System.out.println("Attesa risposta...");
		String line = null;
		try {
			line = new String(b.readLine());
			b.close();
			os.close();
			c.close();
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
		System.out.println("Msg dal server: " + line);
	}

}
