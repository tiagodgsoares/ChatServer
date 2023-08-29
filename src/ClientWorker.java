import java.io.*;
import java.net.Socket;

public class ClientWorker implements Runnable {
    private Server server;
    private BufferedReader message;
    private PrintWriter printMessage;
    private String name;

    public ClientWorker(Socket clientSocket, Server server) {
        this.server = server;
        try {
            this.printMessage = new PrintWriter(clientSocket.getOutputStream(),true);
            this.message = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void run() {

        this.printMessage.println("Type your name: ");
        try {
            this.name = this.message.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        while (true) {

            try {
                this.server.broadcast(this.name + ": " + message.readLine(), this);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void getMessage(String message) {

        this.printMessage.println(message);

    }

}