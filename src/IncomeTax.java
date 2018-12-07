
public class IncomeTax extends Square {

    public IncomeTax(String nameOfSquare) {
        super(nameOfSquare, 0, 0);
    }

    public void doAction(Player player) {
        System.out.println("You paid 200 TL for Income Tax!");
        player.getMoney().reduceMoney(200);
    }
}
