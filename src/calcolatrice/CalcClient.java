package calcolatrice;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class CalcClient {

	public static void main(String args[]) {
		Socket c = null;
		BufferedReader b = null;
		PrintStream os = null;
		Scanner input= new Scanner(System.in);
		
		try{
			c = new Socket("localhost", 11111);
			b= new BufferedReader(new InputStreamReader(c.getInputStream()));
			os = new PrintStream(new BufferedOutputStream(c.getOutputStream())) ;
		}catch(IOException e){
			System.err.println(e.getMessage());
			System.exit(1);
		}
		
		System.out.println("Socket creata:" + c);
		System.out.println("Inserire formula.");
		
	}
}
