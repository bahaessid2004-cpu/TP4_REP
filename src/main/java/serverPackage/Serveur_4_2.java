package serverPackage;
import java.net.*;
import java.util.HashSet;
import java.util.Set;

public class Serveur_4_2 {
    static Set<SocketAddress> clients = new HashSet<>();

        public static void main(String[] args) {

            try {

                DatagramSocket socket = new DatagramSocket(1234);

                System.out.println("Serveur Chat UDP lancé");

                byte[] buffer = new byte[1024];

                while (true) {
                    DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                    socket.receive(packet);
                    SocketAddress expediteur = packet.getSocketAddress();
                    clients.add(expediteur);
                    String message = new String(packet.getData(), 0, packet.getLength());
                    System.out.println(message);
                    for (SocketAddress client : clients) {
                        if (!client.equals(expediteur)) {
                            byte[] data = message.getBytes();
                            DatagramPacket p = new DatagramPacket(data, data.length);
                            p.setSocketAddress(client);

                            socket.send(p);
                        }
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

