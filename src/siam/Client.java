package siam;

import siam.audio.Music;
import siam.audio.SoundsLibrary;
import siam.player.Theme;

import javax.swing.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client extends Thread{
    Socket sock;
    ObjectInputStream ois;
    ObjectOutputStream oos;
    Game game;
    boolean yourTurn;

    public Client(int port, String ip, JFrame frame, Music music, SoundsLibrary soundsLibrary, boolean songEnable,
                  boolean variantMoutains, boolean variantPiece, boolean variantTile, Theme theme, String name) {
        try {
            sock = new Socket(ip,port);
            oos = new ObjectOutputStream(sock.getOutputStream());
            ois = new ObjectInputStream(sock.getInputStream());
            oos.flush();
            try {
                oos.writeBoolean(variantMoutains);
                oos.writeBoolean(variantPiece);
                oos.writeBoolean(variantTile);
                String otherName = (String)ois.readObject();
                if(ois.readInt() == 0) {
                    game = new Game(frame, music, soundsLibrary, songEnable, variantMoutains, variantPiece, variantTile, theme, name, otherName);
                    yourTurn = true;
                }
                else{
                    game = new Game(frame, music, soundsLibrary, songEnable, variantMoutains, variantPiece, variantTile, theme, otherName, name);
                    yourTurn = false;
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch(IOException e) {
            System.out.println("problème de connexion au serveur : "+e.getMessage());
            System.exit(1);
        }
    }

    public Client(int port, String ip, JFrame frame, Music music, SoundsLibrary soundsLibrary, boolean songEnable,
                  Theme theme, String name){
        try {
            sock = new Socket(ip,port);
            oos = new ObjectOutputStream(sock.getOutputStream());
            ois = new ObjectInputStream(sock.getInputStream());
            oos.flush();
            try {
                boolean variantMoutains = ois.readBoolean();
                boolean variantPiece = ois.readBoolean();
                boolean variantTile = ois.readBoolean();
                String otherName = (String)ois.readObject();
                if(ois.readInt() == 0) {
                    game = new Game(frame, music, soundsLibrary, songEnable, variantMoutains, variantPiece, variantTile, theme, name, otherName);
                    yourTurn = true;
                }
                else{
                    game = new Game(frame, music, soundsLibrary, songEnable, variantMoutains, variantPiece, variantTile, theme, otherName, name);
                    yourTurn = false;
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch(IOException e) {
            System.out.println("problème de connexion au serveur : "+e.getMessage());
            System.exit(1);
        }
    }

    public void run(){
        while(game.isRunning()){
            System.out.println("running");
            if(yourTurn){
                requestOut();
            }
            else{
                requestIn();
            }
        }
        try {
            ois.close();
            oos.close();
        } catch (IOException e) {
            System.err.println("Erreur fermeture flux : "+e.getMessage());
        }
    }

    public void requestOut(){

    }

    public void requestIn(){

    }
}
