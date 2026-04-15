package ATMState;

import CoinsBased.Coins;
import dispenseCoin.DispenseCoins;
import dispenseCoin.FiveHundredDispense;
import dispenseCoin.OneHundredDispense;
import dispenseCoin.TwoHundredDispense;
import user.Card;

import java.sql.SQLOutput;
import java.util.Map;

public class CashState implements AtmState{
    @Override
    public void enterAmount(Atm atm, Card card, int amount){
        Map<Coins, Integer>moneyInBankAsCoin=atm.getBalanceBasedOnCoins();
        Integer moneyInBank = atm.totalAmountInAtm;
        Boolean balanceAvailableInAtm = verifyAmount(moneyInBank,amount);
        Boolean balanceAvailableInAccount = verifyAmount(card.getAccount().getAcntMoney(),amount);
        if(!balanceAvailableInAccount){
            System.out.println("NoBalanceAvaibleInAccount , Gareeb saale daale ");
//            return 0;
        }
        else if(!balanceAvailableInAtm){
            System.out.println("No Balance Available in Atm , Gareeb hai Bank");
//            return 0;
        }
        else {
            System.out.println("Cash given with amount " + amount);
            DispenseCoins dispenseCoins = new FiveHundredDispense(new TwoHundredDispense(new OneHundredDispense(null)));
            Boolean isPossible = dispenseCoins.dispenseCoins(atm.getBalanceBasedOnCoins(), amount);
            if(!isPossible){
                System.out.println("Doesnot have given amount with correct demomination");
            }
          else {
                atm.setTotalAmountInAtm(moneyInBank - amount);
                card.getAccount().setAcntMoney(card.getAccount().getAcntMoney() - amount);
            }
        }
        atm.setState(new IdleState());
    }
    public Boolean verifyAmount(int amount1, int amount2){
        return amount1>=amount2;
    }
}
