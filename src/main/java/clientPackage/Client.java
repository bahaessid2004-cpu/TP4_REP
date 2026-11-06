package clientPackage;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;
public class Client {

        public static void main(String[] args) {

            try {
                Scanner sc = new Scanner(System.in);
                System.out.print("Nom utilisateur : ");
                String username = sc.nextLine();
                DatagramSocket socket = new DatagramSocket();
                InetAddress serverAddress = InetAddress.getByName("localhost");

                while (true) {

                    System.out.print("> ");
                    String msg = sc.nextLine();
                    String message = username + " : " + msg;
                    byte[] data = message.getBytes();
                    DatagramPacket packet = new DatagramPacket(data, data.length, serverAddress, 1234);

                    socket.send(packet);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

