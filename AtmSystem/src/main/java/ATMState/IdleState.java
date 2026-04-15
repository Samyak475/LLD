package ATMState;

import user.Card;

public class IdleState implements AtmState{

    @Override
    public void insertCard(Atm atm, Card card){
        System.out.println("Pls insert your card ");
        atm.setState(new HasCardState());
    }
}
