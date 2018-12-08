
public class Player {

    Dice dice = new Dice();
    private int nthPlayer;
    private String name;
    private Money money = new Money();
    private int location = 0;
    private int movedSquare;
    private int jailTour = 0;
    private boolean IsPlayerInJail = false;

    public Player(int nthPlayer, String name, int startingMoney) {
        this.nthPlayer = nthPlayer;
        this.name = name;
        this.money.setMoney(startingMoney);
        initializeLocation(location);
    }

    public int getLocation() {
        return location;
    }

    public void initializeLocation(int location) {
        this.location = location;
    }

    public void setLocation(Player player, int newLocation) {
        howManySquarePlayerMoved(newLocation);
        this.location = getLocation() + newLocation;
        if (location > 39) {
            location = location % 40;
            player.getMoney().increaseMoney(200);
            System.out.println("You have passed the starting point and earned 200 TL!");
        }
    }

    public int howManySquarePlayerMoved(int movedSquare) { //for utilities
        this.movedSquare = movedSquare;
        return movedSquare;
    }

    public int SingleDie() {
        return dice.getDiceValue();
    }

    public int DiceShape(int dice_1, int dice_2) {
        return dice.getDiceShape(dice_1, dice_2);
    }

    public String getName() {
        return name;
    }

    public Money getMoney() {
        return this.money;
    }

    public boolean IsPlayerInJail() {
        if (this.IsPlayerInJail == true) {
            this.jailTour++; //it increases query and jail.
            if (jailTour == 5) {
                rescueFromJail();
                System.out.println("You have been waited 3 tours! Next tour, you can continue the game.");
            }
        }
        return IsPlayerInJail;
    }

    public void rescueFromJail() {
        this.IsPlayerInJail = false;
        jailTour = 0;
    }

    public void playerInJail() {
        this.IsPlayerInJail = true;
    }
}