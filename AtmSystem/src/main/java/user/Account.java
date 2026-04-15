package user;

public class Account {
    String acntId;
    String acntName;
    Integer acntMoney;
    public String getAcntId() {
        return acntId;
    }
    public void setAcntMoney(Integer amount){
        acntMoney=amount;
    }

    public String getAcntName() {
        return acntName;
    }

    public Account(String acntId, String acntName,Integer acntMoney) {
        this.acntId = acntId;
        this.acntName = acntName;
        this.acntMoney =acntMoney;
    }

    public Integer getAcntMoney() {
        return acntMoney;
    }
}
