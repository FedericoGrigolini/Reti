package eserciziBase;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ServerSocket serverSock = null;
		Socket c = null;
		System.err.println("Creazione ServerSocket");
		try {
			serverSock = new ServerSocket(11111);
		} catch (IOException e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}
		while (true) {
			System.out.println("Attesa connessione...");
			try {
				c = serverSock.accept();
			} catch (IOException e) {
				System.out.println("Connessione fallita");
				System.exit(2);
			}
			System.out.println("Connessione da " + c);
		// --- inizio colloquio col client
			BufferedReader is = null;
			PrintStream os = null;
			try {
				BufferedInputStream ib = new BufferedInputStream(c.getInputStream());
				is = new BufferedReader(new InputStreamReader(c.getInputStream()));
				BufferedOutputStream ob = new BufferedOutputStream(c.getOutputStream());
				os = new PrintStream(ob, false);
		// --- ricezione nome file dal client
				String n = new String(is.readLine());
				System.out.println("File: " + n);
		// --- controllo esistenza file
				if (n.equals("Missing file name")) {
					os.flush();
					os.close();
					is.close();
					c.close();
				}
				// --- invio del file al client
				is = new BufferedReader(new InputStreamReader(new FileInputStream(n)));
				String r = null;
				while ((r = is.readLine()) != null) {
				os.println(r);
				}
				os.flush();
				os.close();
				is.close();
				c.close();
			} catch (FileNotFoundException e) {
				System.out.println("File non trovato");
				os.println("File non trovato");
				os.flush();
				os.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		
	}

}
