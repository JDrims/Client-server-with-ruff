import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Socket clientSocket = new Socket("netology.homework",10600);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

            Scanner scanner = new Scanner(System.in);
            String mes = in.readLine();
            System.out.println(mes);
            out.println(scanner.nextLine());
            mes = in.readLine();
            System.out.println(mes);
            out.println(scanner.nextLine());
            mes = in.readLine();
            System.out.println(mes);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}