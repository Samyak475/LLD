package ATMState;

import java.util.List;

public class SelectState implements  AtmState{

    @Override
    public void showOptions(Atm atm, List<OptionsAvailable>optionsAvailables){
        System.out.println("Below are currently available options in this ATM :- ");
        optionsAvailables.forEach(options-> System.out.println("Option :- "+ options));
    }
    @Override
    public void selectOption(Atm atm,OptionsAvailable optionsAvailable){
        if(optionsAvailable == OptionsAvailable.CASH_WITHDRWAL){
            atm.setState(new CashState());
        }
        else if(optionsAvailable == OptionsAvailable.CHECK_BALANCE){
            atm.setState(new showBalanceState());
        }
        else {
            System.out.println("this is invalid option pls re-insert your card");
            atm.setState(new IdleState());
        }
        return ;
    }

}
