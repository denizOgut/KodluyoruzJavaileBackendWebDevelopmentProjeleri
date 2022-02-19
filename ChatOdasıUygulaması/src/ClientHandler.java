import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class ClientHandler implements Runnable {
    public static ArrayList<ClientHandler> clientHandlers = new ArrayList<>();
    private Socket socket;
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;
    private String clientUserName;

    public ClientHandler(Socket socket) throws IOException {
        this.socket = socket;
        this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.clientUserName = bufferedReader.readLine();
        clientHandlers.add(this);
        broadCastMessage("SERVER: " + this.clientUserName + " has entered the chat!");
    }

    @Override
    public void run() {
        String messageFromClient;
        while (this.socket.isConnected()) {
            try {
                messageFromClient = this.bufferedReader.readLine();
                broadCastMessage(messageFromClient);
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }
    }

    public void broadCastMessage(String messageToSend) throws IOException {
        for (ClientHandler clientHandler : clientHandlers) {
            if (!clientHandler.clientUserName.equals(this.clientUserName)) {
                clientHandler.bufferedWriter.write(messageToSend);
                clientHandler.bufferedWriter.newLine();
                clientHandler.bufferedWriter.flush();
            }
        }
    }
}
