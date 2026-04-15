import ATMState.Atm;
import ATMState.OptionsAvailable;
import ATMState.showBalanceState;
import CoinsBased.Coins;
import user.Account;
import user.Card;
import user.User;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class AtmRoom {
    public static void main(String []args){
        Account account = new Account("355","SamyakAccount",3000);
        Card card  = new Card("097","475","safiro",account);
        User user = new User("codeartist","samyakJain",card, account);
        List<OptionsAvailable>optionsAvailables = Arrays.asList(OptionsAvailable.CASH_WITHDRWAL,OptionsAvailable.CHECK_BALANCE);
        Atm atm= new Atm();
        atm.insertCoinInAtm(Coins.HUNDRED);
        atm.insertCoinInAtm(Coins.HUNDRED);
        atm.insertCoinInAtm(Coins.HUNDRED);
        atm.insertCoinInAtm(Coins.HUNDRED);
        atm.insertCoinInAtm(Coins.HUNDRED);
        atm.insertCoinInAtm(Coins.TWO_HUNDRED);
        atm.insertCoinInAtm(Coins.TWO_HUNDRED);
        atm.insertCoinInAtm(Coins.FIVE_HUNDRED);

        System.out.println("Atm is in state+ "+atm.getState());
        System.out.println("Pls insert your card:+ ");
        atm.getState().insertCard(atm,card);
        System.out.println("Atm is in state+ "+atm.getState());

        atm.getState().authenticatePin(atm,card,"11475");
        System.out.println("Atm is in state+ "+atm.getState());

        atm.getState().showOptions(atm,optionsAvailables);
        System.out.println("Atm is in state+ "+atm.getState());

        atm.getState().selectOption(atm,OptionsAvailable.CASH_WITHDRWAL);
        System.out.println("Atm is in state+ "+atm.getState());

        atm.getState().enterAmount(atm,card,1200);
        System.out.println("Atm is in state+ "+atm.getState());
        atm.setState(new showBalanceState());
        System.out.println("Atm is in state+ "+atm.getState());
        atm.getState().showBalance(atm,card);
        System.out.println("Atm is in state+ "+atm.getState());


    }
}
