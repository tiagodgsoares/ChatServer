import java.io.*;
import java.net.Socket;

public class ClientWorker implements Runnable {
    private Server server;
    private Socket clientSocket;
    private BufferedReader message;
    private PrintWriter printMessage;
    private String name;

    public ClientWorker(Socket clientSocket, Server server) {
        this.server = server;
        this.clientSocket = clientSocket;

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

            while (true) {
                String clientMessage = message.readLine();

                if (clientMessage.equals("/exit")) {
                    break;
                }

                this.server.broadcast(this.name + ": " + clientMessage, this);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);

        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public void getMessage(String message) {

        this.printMessage.println(message);

    }

}