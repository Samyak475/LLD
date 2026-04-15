package ATMState;

import user.Card;

public class showBalanceState implements AtmState{

    @Override
    public Integer showBalance(Atm atm, Card  card){
        System.out.println("Current money in your card "+card.getAccount().getAcntMoney());
        atm.setState(new IdleState());
        return card.getAccount().getAcntMoney();
    }
}
