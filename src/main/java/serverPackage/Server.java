package serverPackage;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
public class Server {
        public static void main(String[] args) {
            try {
                DatagramSocket serverSocket = new DatagramSocket(1234);

                System.out.println("Serveur UDP démarré sur le port 1234...");

                byte[] buffer = new byte[1024];

                while (true) {
                    DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                    serverSocket.receive(packet);
                    String message = new String(packet.getData(), 0, packet.getLength());
                    System.out.println("Message reçu de " + packet.getAddress().getHostAddress() + ":" + packet.getPort() + " -> " + message
                    );
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

