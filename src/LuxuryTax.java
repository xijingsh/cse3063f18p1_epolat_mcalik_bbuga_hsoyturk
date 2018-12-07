
public class LuxuryTax extends Square {

    public LuxuryTax(String nameOfSquare) {
        super(nameOfSquare, 0, 0);
    }

    public void doAction(Player player) {
        System.out.println("You paid 100 TL for Luxury Tax!");
        player.getMoney().reduceMoney(100);
    }
}
