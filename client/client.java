package client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

import server.pendulum;
public class client {
    public static void main(String[] args) {
    int NUMBER_GAME =3;
    try {
        Registry registry = LocateRegistry.getRegistry("127.0.0.1", 9000);
        pendulum game = (pendulum)registry.lookup("GAME");
        System.out.println("***************Bienvenue dans le jue de pendule version JAVA RMI*************************\n\n");
        System.out.println(game.StartGame()+"\n\n");
        int count = game.getCount();
        while(count !=-1 && count !=-1 && count <NUMBER_GAME){
            System.out.println("Trouver le mot: "+game.getWordPlay());
            System.out.print("Veuiilez enter une lettre: ");
            Scanner scanner = new Scanner(System.in);
            String word = scanner.nextLine();
            if(1<word.length()){
                System.out.println("\nLe jeu n'accepte que des lettres");
            }else{
                count = game.Play(word.charAt(0));
                if(count!=0 && count !=-1){
                    System.out.println("Il vous reste "+ (NUMBER_GAME - count));
                }
            }
        }
        if(count==-2){
            System.out.println("Vous avez gagné le jeu!!!");
        }else if (NUMBER_GAME<=count){
            System.out.println("oups vous avez perdu le jeu!!!");
        }else{
            System.out.println("Desolé le serveur à mis fin au jeu");
        }
    } catch (Exception e) {
        System.out.println("Exception in client side" + e);
    }
}
}
