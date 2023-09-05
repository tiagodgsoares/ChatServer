import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    private ServerSocket serverSocket = null;
    public static final int PORT = 8046;
    private ClientWorker clientWorker;
    private CopyOnWriteArrayList<ClientWorker> clients;

    public static void main(String[] args) {

        Server server = new Server();
        server.connect();
    }

    public void connect() {

        try {
            serverSocket = new ServerSocket(PORT);
            clients = new CopyOnWriteArrayList<>();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        while (true) {
            try {

                this.clientWorker = new ClientWorker(serverSocket.accept(), this);
                clients.add(clientWorker);

                ExecutorService pool = Executors.newCachedThreadPool();
                pool.submit(clientWorker);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }

    public void broadcast(String message, ClientWorker clientMessage) {

        for (ClientWorker client : clients) {

            if(client != clientMessage) {
                client.getMessage(message);
            }
        }
    }

}
