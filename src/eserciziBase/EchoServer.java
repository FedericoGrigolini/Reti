package eserciziBase;
import java.io.*; 
import java.net.*;

public class EchoServer {
	
	public static void main(String[] args) {
		ServerSocket serverSock = null;
		Socket cs = null;
		System.out.print("Creazione ServerSocket...");
		BufferedInputStream in = null;
		BufferedOutputStream out = null;
		
		try{
			serverSock=new ServerSocket(11111);
		}catch(IOException e){
			System.err.println(e.getMessage()); 
			System.exit(1);
		}
		
		System.out.print("Attesa connessione...");
		
		try{
			cs=serverSock.accept();
		}catch(IOException e){
			System.err.println("Connessione Fallita"); 
			System.exit(2);
		}
		
		System.out.println("Connessione da "+ cs);
		
		try{
			out = new BufferedOutputStream(cs.getOutputStream());
			in = new BufferedInputStream(cs.getInputStream());
			BufferedReader d = new BufferedReader(new InputStreamReader(in));
			PrintStream os = new PrintStream(out,false);
			//ricezione stringa
			String text=new String(d.readLine());
			System.out.println(text);
			//invio della nuova stringa in maiuscolo
			os.println(text.toUpperCase());
			os.println("Stop");
			//chiudo
			os.close();
			cs.close();
		}catch(Exception e){
			System.err.println(e.getMessage()); 
			System.exit(3);
		}
	}
	
	
	
}
