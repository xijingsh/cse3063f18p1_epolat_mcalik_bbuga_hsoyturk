public class Money {
    private int moneyValue;

    public void reduceMoney(int a) {
        moneyValue -= a;
    }

    public void increaseMoney(int a) {
        moneyValue += a;
    }

    public int getMoney() {
        return moneyValue;
    }

    public void setMoney(int a) {
        this.moneyValue = a;
    }
}