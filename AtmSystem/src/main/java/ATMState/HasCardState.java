package ATMState;

import user.Card;

public class HasCardState implements AtmState{

    @Override
    public Boolean authenticatePin(Atm atm, Card card, String pin) {

        Boolean isValid = card.validatePin(pin);
        if(isValid){
            atm.setState(new SelectState());
            return true;
        }
        atm.setState(new IdleState());
        return false;
    }
}
