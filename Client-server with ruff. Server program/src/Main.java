import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(10600)) {
            System.out.println("Server started");
                try (Socket clientSocket = serverSocket.accept();
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                ) {
                    System.out.println("New connection accepted");
                    out.println("Write your name");
                    final String name = in.readLine();
                    out.println("Are you child? (yes/no)");
                    final String answer = in.readLine();
                    if ("yes".equals(answer)) {
                        out.println(String.format("Welcome to the kids area, %s! Let's play!", name));
                    } else {
                        out.println(String.format("Welcome to the adult zone, %s! Have a good rest, or a good working day!", name));
                    }
                }
        }
    }
}