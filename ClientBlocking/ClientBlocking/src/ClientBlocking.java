import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ClientBlocking {

	public void mainloop() {
		try {
			Socket socket = new Socket("debby.vs.uni-due.de", 2223);

			BufferedReader socketReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			BufferedWriter socketWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

			BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

			while (true) {
				String lineFromServer = socketReader.readLine();
				System.out.println(lineFromServer);

				String lineFromConsole = consoleReader.readLine();
				socketWriter.write(lineFromConsole);
				socketWriter.write("\r\n");
				socketWriter.flush();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new ClientBlocking().mainloop();
	}
}
