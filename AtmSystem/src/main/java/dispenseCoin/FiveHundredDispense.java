package dispenseCoin;

import CoinsBased.Coins;

import java.util.Map;

public class FiveHundredDispense extends DispenseCoins{
    public FiveHundredDispense(DispenseCoins dispenseCoins){
        super(dispenseCoins);
    }

    @Override
    public Boolean dispenseCoins(Map<Coins,Integer> coinsIntegerMap , int amount){
        int fiveHundredNotePresent = coinsIntegerMap.get(Coins.FIVE_HUNDRED);
        int fiveHundredNoteRequired = amount/500;
        int fiveHundredNoteGiven = Integer.min(fiveHundredNotePresent,fiveHundredNoteRequired);
        int amountInFiveHundredNote = 500*fiveHundredNoteGiven;
        System.out.println("here for dispense for 500 "+ fiveHundredNoteGiven+" "+ fiveHundredNoteRequired +" "+ fiveHundredNotePresent);
        amount = amount-amountInFiveHundredNote;

        Boolean isValid =nextCoin.dispenseCoins(coinsIntegerMap,amount);

        if(!isValid)return false;
        coinsIntegerMap.put(Coins.FIVE_HUNDRED,fiveHundredNotePresent-fiveHundredNoteGiven);
return true;

    }
}
