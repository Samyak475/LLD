package user;

public class User {
    String userId;
    String userName;
    Card card;
    Account  account;

    public Card getCard() {
        return card;
    }

    public Account getAccount() {
        return account;
    }

    public User(String userId, String userName, Card card, Account account) {
        this.userId = userId;
        this.userName = userName;
        this.card = card;
        this.account = account;
    }

    public User(String userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

}
