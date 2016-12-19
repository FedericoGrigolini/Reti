package eserciziBase;

import java.net.*;
import java.io.*;
 
class ServerChat {
	public static void main(String args[]) throws Exception {
		ServerSocket conn = new ServerSocket( 1025 );
		new server1( conn.accept() ).run();
	}
}

class server1 {
	Socket s;	
	server1(Socket s) {
		this.s = s;
	}
	public void run() {
		String from;
		BufferedReader in=null;
		PrintStream out=null;
		try {
			in = new BufferedReader(new InputStreamReader(s.getInputStream()));
			out = new PrintStream(s.getOutputStream());
			System.out.println("Connected");
			while( (from=in.readLine()) != null && !from.equals("")) {
				System.out.println( from );
				out.println(from);
			}
			s.close();
		 }
		 catch(IOException e) {}
		 System.out.println("Disconnected");
	}
 }
