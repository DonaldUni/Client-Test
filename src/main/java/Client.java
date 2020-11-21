import java.io.*;
import java.net.Socket;

public class Client extends Thread {

    @Override
    public void run(){

        try{
            Socket socket = new Socket("localhost", 3000);

            BufferedReader socketReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter socketWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            new ConsoleReader(socketWriter).start();

            while (true){
                String line = socketReader.readLine();
                System.out.println(line);
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Client().start();
    }
}
