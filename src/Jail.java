public class Jail extends Square {

    private int firstDie;
    private int secondDie;

    public Jail(String nameOfSquare) {
        super(nameOfSquare, 0, 0);
    }

    public void doAction(Player player, Board board) {

        if (player.IsPlayerInJail() == true) {
            System.out.println("\n••••••••••••••••••••••••••••••••••••••••••••••••••• ");
            System.out.println(player.getName() + " is still in the jail!");
            System.out.println("Roll the dice, if the dice become double, you can get away!");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException ex) {
            }
            firstDie = player.SingleDie();
            secondDie = player.SingleDie();
            player.DiceShape(firstDie, secondDie);

            if (firstDie == secondDie) {
                System.out.println("\nYou have been escaped! Next tour, you can continue.\n");
                player.rescueFromJail();
            } else {
                System.out.println("\nYou couldn't escape! Next tour, roll again!\n");
            }
        } else {
            System.out.println("But just visiting...");
        }
    }
}