
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Client extends Thread {

	@Override
	public void run() {
		try {
			Socket socket = new Socket("debby.vs.uni-due.de", 2223);

			BufferedReader socketReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			BufferedWriter socketWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			// start ConsoleReader.run() in own Thread, pass reference to socketWriter
			new ConsoleReader(socketWriter).start();

			while (true) {
				String line = socketReader.readLine();
				System.out.println(line);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		// start method run() as own Thread
		new Client().start();
	}
}
