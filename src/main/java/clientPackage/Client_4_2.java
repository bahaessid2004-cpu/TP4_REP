package clientPackage;
import java.net.*;
import java.util.Scanner;
public class Client_4_2 {

        public static void main(String[] args) {

            try {
                Scanner sc = new Scanner(System.in);
                System.out.print("Nom : ");
                String nom = sc.nextLine();

                DatagramSocket socket = new DatagramSocket();

                Thread reception = new Thread(() -> {
                    try {
                        while (true) {
                            byte[] buffer = new byte[1024];
                            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                            socket.receive(packet);
                            String msg = new String(packet.getData(), 0, packet.getLength());
                            System.out.println(msg);
                        }

                    }
                    catch (Exception e) {

                        e.printStackTrace();
                    }
                });

                reception.start();
                while (true) {
                    String texte = sc.nextLine();
                    String message = "[" + nom + "] : " + texte;

                    byte[] data = message.getBytes();
                    DatagramPacket packet = new DatagramPacket(data,data.length, InetAddress.getByName("localhost"), 1234);
                    socket.send(packet);
                }

            } catch (Exception e) {

                e.printStackTrace();
            }
        }
    }

