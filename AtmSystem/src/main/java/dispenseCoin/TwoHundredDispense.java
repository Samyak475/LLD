package dispenseCoin;

import CoinsBased.Coins;

import java.util.Map;

public class TwoHundredDispense extends DispenseCoins{
    public TwoHundredDispense(DispenseCoins dispenseCoins){
        super(dispenseCoins);
    }
    @Override
    public Boolean dispenseCoins(Map<Coins,Integer> coinsIntegerMap , int amount){
        int fiveHundredNotePresent = coinsIntegerMap.get(Coins.TWO_HUNDRED);
        int fiveHundredNoteRequired = amount/200;
        int fiveHundredNoteGiven = Integer.min(fiveHundredNotePresent,fiveHundredNoteRequired);
        int amountInFiveHundredNote = 200*fiveHundredNoteGiven;
        System.out.println("here for dispense for 200 "+ fiveHundredNoteGiven+" "+ fiveHundredNoteRequired +" "+ fiveHundredNotePresent);
        amount = amount-amountInFiveHundredNote;
        Boolean isValid =nextCoin.dispenseCoins(coinsIntegerMap,amount);
        if(!isValid)return false;
        coinsIntegerMap.put(Coins.TWO_HUNDRED,fiveHundredNotePresent-fiveHundredNoteGiven);
        return true;
    }
}
