package dispenseCoin;

import CoinsBased.Coins;

import java.util.Map;

public class DispenseCoins {
     DispenseCoins nextCoin;
    public   DispenseCoins(DispenseCoins dispenseCoins){
        nextCoin = dispenseCoins;
    }

    public Boolean dispenseCoins(Map<Coins,Integer> coinsIntegerMap , int Amount){
        if(nextCoin !=null){
            nextCoin.dispenseCoins( coinsIntegerMap , Amount);
        }
        return true;
    }
}
