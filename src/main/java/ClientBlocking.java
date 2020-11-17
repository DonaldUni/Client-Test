import java.io.*;
import java.net.Socket;

public class ClientBlocking {


    public void mainLoop(){

        try {

            Socket socket = new Socket("debby.vs.uni-due.de", 2223);

            BufferedReader socketReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter socketWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

            while (true){
                String lineFromServer = socketReader.readLine();
                System.out.println(lineFromServer);

                String lineFromConsole = consoleReader.readLine();
                socketWriter.write(lineFromConsole);
                socketWriter.write("\r\n");
                socketWriter.flush();

            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new ClientBlocking().mainLoop();
    }
}
