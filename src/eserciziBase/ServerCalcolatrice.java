package eserciziBase;
import java.io.*;
import java.net.*;

public class ServerCalcolatrice {
	public static void main(String args[]) {
		ServerSocket serverSock = null;
		Socket cs = null;
		System.err.println("Creazione ServerSocket");
		try {
			serverSock = new ServerSocket(11111);
		} catch (IOException e) {
			System.err.println(e.getMessage());
			System.exit(1);
		}
		while (true) {
			System.out.println("Attesa connessione...");
			try {
				cs = serverSock.accept();
			} catch (IOException e) {
				System.out.println("Connessione fallita");
				System.exit(2);
			}
			System.out.println("Connessione da " + cs);
			try {
				BufferedReader b = new BufferedReader(new
				InputStreamReader(
				cs.getInputStream()));
				BufferedOutputStream ob = new BufferedOutputStream(
				cs.getOutputStream());
				PrintStream os = new PrintStream(ob, false);
				String line;
				int y, x = 0;
				do {
					line = new String(b.readLine());
					y = Integer.parseInt(line);
					System.out.println("Value: " + y);
					x += y;
				} while (y != 0);
				os.println("Somma = " + x);
				os.flush();
				os.close();
				b.close();
				cs.close();
			} catch (Exception e) {
				System.out.println("Errore: " + e);
				System.exit(3);
			}
		}
	}
}
