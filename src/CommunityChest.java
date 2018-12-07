import java.util.Random;

public class CommunityChest extends Square {

    private String[] communityCard = new String[10];
    private int randomCommunityCard;

    public CommunityChest(String nameOfSquare) {
        super(nameOfSquare, 0, 0);
        communityCard[0] = "Take 25 TL for consulting fee.";
        communityCard[1] = "Pay 100 TL for hospital bills.";
        communityCard[2] = "Take 100 TL for annual interest payment.";
        communityCard[3] = "Pay 50 TL for doctor's fee.";
        communityCard[4] = "Pay 50 TL for tuition fee.";
        communityCard[5] = "Error in bank account! Take 200 TL.";
        communityCard[6] = "Your payment came from insurance! Take 100 TL.";
        communityCard[7] = "You inherit 100 TL. ";
        communityCard[8] = "You have won second prize in a beauty contest collect 10 TL.";
        communityCard[9] = "You won 50tl from sale of stock";
    }

    public void doAction(Player player) {
        Random randomCommunity = new Random();
        int randomCommunityCard = randomCommunity.nextInt(9) + 1;
        System.out.println(communityCard[randomCommunityCard]);

        if (randomCommunityCard == 0) {
            player.getMoney().increaseMoney(25);
        } else if (randomCommunityCard == 1) {
            player.getMoney().reduceMoney(100);
        } else if (randomCommunityCard == 2) {
            player.getMoney().increaseMoney(100);
        } else if (randomCommunityCard == 3) {
            player.getMoney().reduceMoney(50);
        } else if (randomCommunityCard == 4) {
            player.getMoney().reduceMoney(50);
        } else if (randomCommunityCard == 5) {
            player.getMoney().increaseMoney(200);
        } else if (randomCommunityCard == 6) {
            player.getMoney().increaseMoney(100);
        } else if (randomCommunityCard == 7) {
            player.getMoney().increaseMoney(100);
        } else if (randomCommunityCard == 8) {
            player.getMoney().increaseMoney(10);
        } else if (randomCommunityCard == 9) {
            player.getMoney().increaseMoney(50);
        }
    }
}
