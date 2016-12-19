package eserciziBase;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientChat {

	public static void main(String[] args) {
		Socket s = null;
		BufferedReader inputStream = null;
		PrintStream outputStream = null;
		System.out.println("Prova");
		try {
			s = new Socket("localhost", 1025); // IP e porta del server 
			inputStream = new BufferedReader(new InputStreamReader(s.getInputStream())); 
		} catch (IOException e) { 
			System.out.println(e.getMessage()); 
			System.exit(1); 
			}
		System.out.println("Socket creata: " + s);
		try{
			BufferedOutputStream b = new BufferedOutputStream( s.getOutputStream()); 
			outputStream = new PrintStream(b, false); 
			String line;
			outputStream.println("Ciao");
			outputStream.flush();
			while(true){
				line= new Scanner(System.in).nextLine();
				outputStream.println(line);
				outputStream.flush();
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	

}
