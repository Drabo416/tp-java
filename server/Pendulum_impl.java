package server;

import java.rmi.RemoteException;
import java.util.Random;

public class Pendulum_impl implements pendulum {
    public String word;
    public int count;
    public String wordPlay;
    public String[] Tableau = {"TABLE", "CHAISE", "REVEIL", "ORDINATEUR", "PAILLASSON", "DOUCHE", "REFRIGERATEUR"};
    public String[] indice = {"j’ai quatre pieds, mais je ne marche pas. Je suis utile quand il est temps de manger.", " mes quatre pattes servent à vous reposer.", "mon travail consiste à mettre fin au sommeil.", " je peux vous emmener dans des endroits que vous n’avez jamais vus, mais vous devez d’abord taper votre mot de passe sur mon écran. Ou : Avec moi, on peut jouer ou travailler. J’ai un écran et une souris.", "je suis un ami pour les parents qui aiment les choses soignées. Ils aiment vraiment quand vous vous essuyez les pieds sur moi. Ou : les chaussures aiment me piétiner !", "je rends possible d’avoir de la nourriture fraîche. Tout le monde est d’accord pour dire que je suis quelqu’un de froid. Ou : derrière une porte où il fait froid même en plein été."};
    public Pendulum_impl(){
        
    }
    public String StartGame() throws RemoteException {
        Random rand = new Random(); //instance of random class
        int upperbound =this.Tableau.length-1;
        int int_random = rand.nextInt(upperbound); 
        this.word = this.Tableau[int_random];
        this.wordPlay="";
        for(int  i =0; i<this.word.length(); i++ ){
            this.wordPlay = this.wordPlay +"-";
        }
        this.count =0;
        return this.indice[int_random];
    }

    public void EndGame() throws RemoteException{
        this.word= "";
        this.count =-1;
    }

    public int Play(Character word) throws RemoteException{
        word = Character.toUpperCase(word);
        System.out.println(word);
        int index = this.word.indexOf(Character.toUpperCase(word));
        if(index!=-1){
            String newWordPlay ="";
            int letterFind =0;

            for(int i =0; i<this.word.length();i++){
                if(this.word.charAt(i)==word){
                    newWordPlay = newWordPlay + word;
                    letterFind++;
                }else if(this.wordPlay.charAt(i)!='-'){
                    newWordPlay = newWordPlay+ this.word.charAt(i);
                    letterFind++;
                }else{
                    newWordPlay = newWordPlay+ "-";
                }
            }
            this.wordPlay = newWordPlay;
            if(letterFind==this.word.length()){
                this.count =-2;
            }else{
                this.count =0;
            }
        }else{
            this.count+=1;
        }
        // if(word == this.word){
        //     this.count =0;
        // }
        // else{
        //     this.count+=1;
        // }
        // System.out.println();
        return this.count;

    }

    public String getWordPlay () {
        return this.wordPlay;
    }

    public int getCount(){
        return this.count;
    }
}
