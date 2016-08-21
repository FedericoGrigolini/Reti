package eserciziBase;
import java.io.*;
import java.net.*;


public class EsempioURL {
	public static void main(String args[]){
		String indirizzo;
		if (args.length >0){
			indirizzo = args[0];
		}else{
			System.out.println("Uso : EsempioURL URL");
			return;
		}
		
		URL u= null;
		try {
			u=new URL(indirizzo);
			System.out.println("URL aperto: "+u);
		}catch(MalformedURLException e){
			System.out.println("URL errato: " + u);
			System.exit(0);
		}
		
		URLConnection c = null;
		BufferedReader bstream = null;
		
		try {
			System.out.print("Connessione in corso...");
			c=u.openConnection();
			c.connect();
			System.out.println("OK");
			BufferedInputStream b = new BufferedInputStream(c.getInputStream());
			bstream=new BufferedReader(new InputStreamReader(b));
			System.out.println("Lettura dati");
			String s;
			while((s=bstream.readLine())!= null){
				System.out.println(s);
			}
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
	}
}
