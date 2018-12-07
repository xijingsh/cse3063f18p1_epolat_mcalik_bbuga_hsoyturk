
public class Board {

    private Square[] squares = new Square[40];
    Dice dice = new Dice();
    private Player[] players;
    private int playerNumberInTheGame;
    public Square firstOne = new Avenue("trying", 0, 0);
    private int previousMoney;

    public Board(int playerNumber, String[] playerName, int startingMoney) {
        players = new Player[playerNumber];
        for (int i = 0; i < playerNumber; i++) {
            players[i] = new Player(i, playerName[i], startingMoney);
            playerNumberInTheGame = playerNumber;
        }
        squares = featureOfSquare();

        while (playerNumberInTheGame != 1) {
            for (int i = 0; i < playerNumber; i++) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException ex) {
                }
                if (players[i].IsPlayerInJail()) {
                    squares[10].doAction(players[i]);
                } else {
                    System.out.println("••••••••••••••••••••••••••••••••••••");
                    int currentLocation = movePlayerOnBoard(players[i]);
                    System.out.println(players[i].getName() + " moves to the " + currentLocation + ".square " + squares[currentLocation].getName());
                    System.out.println("Money: " + players[i].getMoney().getMoney() + "\n");
                    previousMoney = players[i].getMoney().getMoney();
                    if (currentLocation == 12) {
                        if (squares[28].getOwner() != null) {
                            squares[currentLocation].bothOfUtilityBelongsToSameOwner((squares[28].getOwner().getName()));
                        }
                    } else if (currentLocation == 28) {
                        if (squares[28].getOwner() != null) {
                            squares[currentLocation].bothOfUtilityBelongsToSameOwner((squares[28].getOwner().getName()));
                        }
                    }
                    squares[currentLocation].doAction(players[i]);
                    if (previousMoney != players[i].getMoney().getMoney()) {
                        System.out.println("The new money amount: " + players[i].getMoney().getMoney() + "\n");
                    }
                }
                for (int j = 0; j < playerNumber; j++) {
                    playerNumberInTheGame = playerNumber;
                    int playersMoney = players[j].getMoney().getMoney();
                    if (playersMoney <= 0) {
                        playerNumberInTheGame = playerNumberInTheGame - 1;
                    }
                }
            }
        }
    }

    public Square[] featureOfSquare() {

        for (int i = 0; i <= 39; i++) {

            if (i == 0) {
                squares[i] = new LoopInBoard("You pass the starting point!");
            } else if (i == 1 || i == 3 || i == 6 || i == 8 || i == 9 || i == 11 || i == 13 || i == 14 || i == 16 || i == 18 || i == 19 || i == 21 ||
                    i == 23 || i == 24 || i == 26 || i == 27 || i == 29 || i == 31 || i == 32 || i == 34 || i == 37 || i == 39) {
                String avenueName = (String) firstOne.nameOfAvenue(i);
                int avenueRent = firstOne.rentOfAvenue(i);
                int avenuePrice = firstOne.priceOfAvenue(i);
                squares[i] = new Avenue(avenueName, avenuePrice, avenueRent);
            } else if (i == 2 || i == 17 || i == 33) {
                squares[i] = new CommunityChest("A Community Chest Card!");
            } else if (i == 4) {
                squares[i] = new IncomeTax("Income Tax!");
            } else if (i == 5 || i == 15 || i == 25 || i == 35) {
                String RailRoadName = (String) firstOne.nameOfAvenue(i);
                int RailRoadRent = firstOne.rentOfAvenue(i);
                int RailRoadPrice = firstOne.priceOfAvenue(i);
                squares[i] = new RailRoad(RailRoadName, RailRoadPrice, RailRoadRent);
            } else if (i == 7 || i == 22 || i == 36) {
                squares[i] = new Chance("A Chance Card!");
            } else if (i == 10) {
                squares[i] = new Jail("Jail!");
            } else if (i == 12 || i == 28) {
                String utilityName = (String) firstOne.nameOfAvenue(i);
                int utilityRent = firstOne.rentOfAvenue(i);
                int utilityPrice = firstOne.priceOfAvenue(i);
                squares[i] = new Utilities(utilityName, utilityPrice, utilityRent);
            } else if (i == 20) {
                squares[i] = new FreeParking("Free Parking!");
            } else if (i == 30) {
                squares[i] = new GoToJail("Go To Jail!");
            } else if (i == 38) {
                squares[i] = new LuxuryTax("Luxury Tax!");
            }
        }
        return squares;
    }

    public int movePlayerOnBoard(Player player) {
        int firstDie, secondDie, moving;
        firstDie = player.SingleDie();
        secondDie = player.SingleDie();
        player.DiceShape(firstDie, secondDie);
        moving = firstDie + secondDie;
        System.out.println("\n               " + firstDie + " - " + secondDie + "!");
        player.setLocation(player, moving);
        int currentLocation = (int) (player.getLocation());
        return currentLocation;
    }
}