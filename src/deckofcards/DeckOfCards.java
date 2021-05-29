package deckofcards;

import domain.Card;
import domain.ClubCard;
import domain.Deck;
import domain.DiamondCard;
import domain.HeartCard;
import domain.SpadeCard;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Reddude
 */
public class DeckOfCards {

    public static void main(String[] args) { 
        boolean backToLoop = true;

        while(backToLoop){
            
            String response = loop();
            
            if(response.equalsIgnoreCase("stop")){
                backToLoop = false;
            }
            
        }
        
        
    }
    
    // Loop manager method that drives our application
    public static String loop(){
        Deck deck = init();
        do{
            System.out.println("Current number of cards in the desk: " + deck.getCards().size());
            System.out.println("What do you want to do? \n "
                + "If you want to shuffle the deck, type: shuffle \n "
                + "If you want to deal a card, type: deal \n "
                + "If you want to restart the deck, type: restart \n\n");
            
            Scanner consola = new Scanner(System.in);
            String instruction = consola.nextLine();
            
            if(instruction.equalsIgnoreCase("shuffle")){
                deck.shuffle();
                System.out.println("The deck has been shuffle.");
            }
            else if(instruction.equalsIgnoreCase("deal")){
                System.out.println(deck.dealOneCard());
            }
            else if(instruction.equalsIgnoreCase("restart")){
                deck = init();
                System.out.println("The deck has been restarted");
            }
            else{
                System.out.println("Sorry, I did not understand your command :(");
            }
            
        }while(!deck.getCards().isEmpty());
        
        String nextStep = "unknown";
        
        while(nextStep.equalsIgnoreCase("unknown")){
            System.out.println("There are no more cards. What do you want to do now? \n"
                + "If you want to stop, type: stop \n "
                + "If you want to restart the deck, type: restart \n\n");
            
            Scanner consola = new Scanner(System.in);
            String instruction = consola.nextLine();
            
            if(instruction.equalsIgnoreCase("stop")){
                System.out.println("Ok, bye!");
                nextStep = "stop";
            }else if(instruction.equalsIgnoreCase("restart")){
                System.out.println("Let's do this again! \n\n");
                nextStep = "restart";
            }else{
                System.out.println("Sorry, I did not understand your command :(");
            }
        }
        
        return nextStep;
    }
    
    // Method in charge of initializing the deck
    public static Deck init(){
        System.out.println("Preparing the deck...");
        
        Deck deck = new Deck();
        List<Card> listOfCards = new ArrayList<>();
        
        for(int i=1;i<=13;i++){
            ClubCard cc = new ClubCard(i);
            DiamondCard dc = new DiamondCard(i);
            HeartCard hc = new HeartCard(i);
            SpadeCard sc = new SpadeCard(i);
            
            listOfCards.add(cc);
            listOfCards.add(dc);
            listOfCards.add(hc);
            listOfCards.add(sc);
        }
        deck.setCards(listOfCards);
        
        return deck;
    }
    
}
