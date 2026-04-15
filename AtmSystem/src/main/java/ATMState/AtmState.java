package ATMState;

import user.Card;

import java.util.List;

public interface AtmState {
    public default void insertCard(Atm atm, Card card){throw  new IllegalArgumentException("Card Not inserted properly"); }
    public default Boolean authenticatePin(Atm atm,Card card, String pin){throw  new IllegalArgumentException("Pin entered is incorrect");}
    public default void selectOption(Atm atm,OptionsAvailable optionID){throw new IllegalArgumentException("Such option does not exit");}
    public default void showOptions(Atm atm, List<OptionsAvailable> optionsAvailables){}
    public default void enterAmount(Atm atm,Card card,int amount){throw new IllegalArgumentException("No Cash in this account");}

    public default Integer  showBalance(Atm atm, Card card){throw  new IllegalArgumentException("Your Account is empty");}

}
