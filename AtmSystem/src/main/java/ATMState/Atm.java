package ATMState;

import CoinsBased.Coins;

import javax.swing.plaf.SpinnerUI;
import java.security.PublicKey;
import java.util.HashMap;
import java.util.Map;

public class Atm {
AtmState state ;
Map<Coins,Integer >BalanceBasedOnCoins = new HashMap<>();
Integer totalAmountInAtm=0;

    public AtmState getState() {
        return state;
    }
    public void setTotalAmountInAtm(int amount){
        totalAmountInAtm = amount;
    }

    public Map<Coins, Integer> getBalanceBasedOnCoins() {
        return BalanceBasedOnCoins;
    }

    public Integer getTotalAmountInAtm() {
        return totalAmountInAtm;
    }

    public Atm() {


        this.state = new IdleState();
    }
    public void insertCoinInAtm(Coins coins){
        int curValue = BalanceBasedOnCoins.getOrDefault(coins,0);
        if(coins == Coins.HUNDRED){
            totalAmountInAtm+=100;
            curValue++;
            BalanceBasedOnCoins.put(coins,curValue);
        }
        else if(coins ==Coins.FIVE_HUNDRED){
            totalAmountInAtm+=500;
            curValue++;
            BalanceBasedOnCoins.put(coins,curValue);
        }
        else {
            totalAmountInAtm+=200;
            curValue++;
            BalanceBasedOnCoins.put(coins,curValue);
        }
    }


    public void setState(AtmState state){
        this.state = state;
    }

}
