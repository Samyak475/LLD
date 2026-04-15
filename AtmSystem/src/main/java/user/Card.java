package user;

public class Card {
    String cardId;
    String pinId="11475";
    String cvv;
    String cardName;
    Account account;
    public Boolean validatePin(String pin){return this.pinId.equalsIgnoreCase(pin);}
    public String getCardId() {
        return cardId;
    }

    public String getPinId() {
        return pinId;
    }

    public String getCvv() {
        return cvv;
    }

    public String getCardName() {
        return cardName;
    }

    public Account getAccount() {
        return account;
    }

    public Card(String cardId, String cvv, String cardName, Account account) {
        this.cardId = cardId;

        this.cvv = cvv;
        this.cardName = cardName;
        this.account = account;
    }
}

