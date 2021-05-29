package domain;

import java.util.List;
import java.util.Random;


/**
 *
 * @author Reddude
 */
public class Deck {
    
    private List<Card> cards ;

    public List<Card> getCards(){
        return cards;
    }
    
    public void setCards(List<Card> cards){
        this.cards = cards;
    }
    
    public void shuffle(){
        Random rnd = new Random();
        
        for(int i=this.cards.size()-1; i>0; i--){
            int j = rnd.nextInt(this.cards.size());
            Card bufferCard = this.cards.get(i);
            this.cards.set(i, this.cards.get(j));
            this.cards.set(j, bufferCard);
        }
    }
    
    public Card dealOneCard(){
        if(!this.cards.isEmpty()){
            return this.cards.remove(0);
        }else{
            return null;
        }
    }
    
    
}
