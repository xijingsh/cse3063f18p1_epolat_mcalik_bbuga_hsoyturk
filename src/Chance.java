import java.util.Random;

public class Chance extends Square {

    private String[] chanceCard = new String[10];
    private int randomChanceCard;

    public Chance(String nameOfSquare) {
        super(nameOfSquare, 0, 0);
        chanceCard[0] = "Go on 5 squares.";
        chanceCard[1] = "Speeding Ticket! Pay 15 TL.";
        chanceCard[2] = "Go To Jail!";
        chanceCard[3] = "Move into Kentuck Avenue. If you pass the starting point, take 200 TL.";
        chanceCard[4] = "Go back 3 squares.";
        chanceCard[5] = "Move into Boardwalk and have fun!";
        chanceCard[6] = "You rented out your house, take 150 TL.";
        chanceCard[7] = "Move to the starting point and take 200 TL!";
        chanceCard[8] = "Move into New York RailRoad. If you pass the starting point, take 200 TL.";
        chanceCard[9] = "The bank pays profit share, 50 TL.";
    }

    public void doAction(Player player) {
        Random randomChance = new Random();
        int randomChanceCard = randomChance.nextInt(9) + 1;
        System.out.println(chanceCard[randomChanceCard]);
        if (randomChanceCard == 0) {
            player.setLocation(player, 5);
        } else if (randomChanceCard == 1) {
            player.getMoney().reduceMoney(15);
        } else if (randomChanceCard == 2) {
            player.initializeLocation(30);
        } else if (randomChanceCard == 3) {
            if (player.getLocation() > 21) {
                System.out.println("You passed the starting point and earned 200 TL!");
                player.getMoney().increaseMoney(200);
            }
            player.initializeLocation(21);
        } else if (randomChanceCard == 4) {
            if (player.getLocation() >= 3) {
                player.initializeLocation(player.getLocation() - 3);
            } else {
                player.initializeLocation(player.getLocation() + 37); //-3 + 40
            }
        } else if (randomChanceCard == 5) {
            player.initializeLocation(39);
        } else if (randomChanceCard == 6) {
            player.getMoney().increaseMoney(150);
        } else if (randomChanceCard == 7) {
            player.initializeLocation(0);
            player.getMoney().increaseMoney(200);
        } else if (randomChanceCard == 8) {
            if (player.getLocation() > 5) {
                System.out.println("You passed the starting point and earned 200 TL!");
                player.getMoney().increaseMoney(200);
            }
            player.initializeLocation(5);
        } else if (randomChanceCard == 9) {
            player.getMoney().increaseMoney(50);
        }
    }
}