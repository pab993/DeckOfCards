package domain;

import enums.TypeCard;

/**
 *
 * @author Reddude
 */
public class Card {

    private String type;

    private int number;
    
    public Card(int number){
        this.number = number;
        
        String typeCard = switch (number) {
            case 1 -> TypeCard.ACE.name();
            case 11 -> TypeCard.JACK.name();
            case 12 -> TypeCard.QUEEN.name();
            case 13 -> TypeCard.KING.name();
            default -> TypeCard.NUMBER.name();
        };
        
        this.type = typeCard;
    }
    
    public int getNumber(){
        return number;
    }
    
    public void setNumber(int number){
        this.number = number;
    }   
    
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    @Override
    public String toString() {
        String card;
        if(this instanceof HeartCard){
            card = "Heart Card: ";
        }else if(this instanceof ClubCard){
            card = "Club Card: ";
        }else if(this instanceof SpadeCard){
            card = "Spade Card: ";
        }else{
            card = "Diamond Card: ";
        }
        
        return card + "{Number: " + this.getNumber() + (this.getType().equalsIgnoreCase(TypeCard.NUMBER.name()) ? "" : (", Type: " + this.getType())) + "}";
    }
    
}
