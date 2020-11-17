import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleReader extends Thread {
	
	private BufferedWriter socketWriter;
	
	public ConsoleReader(BufferedWriter socketWriter) {
		this.socketWriter = socketWriter;
	}

	@Override
	public void run() {
		BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
		try {
			while (true) {
				String line = consoleReader.readLine();
				
				this.socketWriter.write(line);
				this.socketWriter.write("\r\n");
				this.socketWriter.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}