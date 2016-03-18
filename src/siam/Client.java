package siam;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client extends Thread{
    Socket sock;
    ObjectInputStream ois;
    ObjectOutputStream oos;

    public Client(int port, String ip) {
        try {
            sock = new Socket(ip,port);
        } catch(IOException e) {
            System.out.println("problème de connexion au serveur : "+e.getMessage());
            System.exit(1);
        }

        try {
            oos = new ObjectOutputStream(sock.getOutputStream());
            ois = new ObjectInputStream(sock.getInputStream());
            oos.flush();
            oos.writeObject("test");
            System.out.println((String)ois.readObject());
            oos.flush();
            ois.close();
            oos.close();
        }
        catch(IOException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        Client c2 = new Client(12345,"localhost");
    }
}
