package siam;

import siam.level.Board;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class Server extends Thread{
    ServerSocket conn = null;
    Socket sock1 = null;
    Socket sock2 = null;
    ObjectInputStream ois1 = null;
    ObjectOutputStream oos1 = null;
    ObjectInputStream ois2 = null;
    ObjectOutputStream oos2 = null;
    Board board;

    public Server(boolean variantMountainOn, boolean variantTileOn){
        int port = 12345;
        board = new Board(5,variantMountainOn, variantTileOn);
        try {
            conn = new ServerSocket(port);
        } catch(IOException e) {
            System.out.println("problème création socket serveur : "+e.getMessage());
            System.exit(1);
        }
    }

    public void run(){
        while (true) {
            try {
                sock1 = conn.accept();
                sock2 = conn.accept();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try{
                ois1 = new ObjectInputStream(sock1.getInputStream());
                oos1 = new ObjectOutputStream(sock1.getOutputStream());
                oos1.flush();
                ois2 = new ObjectInputStream(sock2.getInputStream());
                oos2 = new ObjectOutputStream(sock2.getOutputStream());
                oos2.flush();
                System.out.println("Connexion établie");
            }
            catch(IOException e) {
                System.err.println("Impossible d'établir la connexion : "+e.getMessage());
                System.exit(1);
            }
            Random random = new Random();

            int playerActive = random.nextInt(2);

            try {
                ois1.close();
                oos1.close();
                ois2.close();
                oos2.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
