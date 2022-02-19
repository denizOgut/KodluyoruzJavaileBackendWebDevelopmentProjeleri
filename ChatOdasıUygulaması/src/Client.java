import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    private Socket socket;
    private BufferedWriter bufferedWriter;
    private BufferedReader bufferedReader;
    private String userName;

    public Client(Socket socket, String userName) throws IOException {
        this.socket = socket;
        this.userName = userName;
        this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

    }

    public void  sendMessage() throws IOException {
        this.bufferedWriter.write(userName);
        this.bufferedWriter.newLine();
        this.bufferedWriter.flush();

        Scanner scanner = new Scanner(System.in);
        while (socket.isConnected())
        {
            String messageToSend = scanner.nextLine();
            this.bufferedWriter.write(this.userName + ": " + messageToSend);
            this.bufferedWriter.newLine();
            this.bufferedWriter.flush();
        }
    }
    public void listenForMessage()
    {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String messageFromGroupChat;
                while(socket.isConnected())
                {
                    try {
                        messageFromGroupChat = bufferedReader.readLine();
                        System.out.println(messageFromGroupChat);

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your username for the group chat: ");
        String userName = scanner.nextLine();
        Socket socket = new Socket("localhost",8080);
        Client client = new Client(socket,userName);
        client.listenForMessage();
        client.sendMessage();
    }
}
