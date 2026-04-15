package dispenseCoin;

import CoinsBased.Coins;

import java.util.Map;

public class OneHundredDispense extends DispenseCoins{
    public OneHundredDispense(DispenseCoins dispenseCoins){
        super(dispenseCoins);
    }

    @Override
    public Boolean dispenseCoins(Map<Coins,Integer> coinsIntegerMap , int amount){
        int fiveHundredNotePresent = coinsIntegerMap.get(Coins.HUNDRED);
        int fiveHundredNoteRequired = amount/100;
        int fiveHundredNoteGiven = Integer.min(fiveHundredNotePresent,fiveHundredNoteRequired);
        int amountInFiveHundredNote = 100*fiveHundredNoteGiven;
        System.out.println("here for dispense for 100 "+ fiveHundredNoteGiven+" "+ fiveHundredNoteRequired +" "+ fiveHundredNotePresent);

        amount = amount-amountInFiveHundredNote;

//        nextCoin.dispenseCoins(coinsIntegerMap,amount);
        if(amount>0)return false;
        coinsIntegerMap.put(Coins.HUNDRED,fiveHundredNotePresent-fiveHundredNoteGiven);

        return true;
    }
}
