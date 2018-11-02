
public class Board {
	
	private Square[] squares = new Square[41];
    Dice dice = new Dice();
    private Player[] players;

	public Board(int playerNumber, String[] playerName, int startingMoney) {
        players = new Player[playerNumber];
        for (int i = 0; i < playerNumber; i++) {
            players[i] = new Player(i, playerName[i], startingMoney, 0);
        }
        squares = featureOfSquare();
        for (int i = 0; i < playerNumber; i++) {
            int currentLocation = movePlayerOnBoard(players[i]);
            System.out.println(players[i].getName() + " moves " + currentLocation + " steps into the " + squares[currentLocation].getName());
        }
    }

	public Square[] featureOfSquare(){
		for (int i = 1; i <= 40; i++) {
			if (i == 1) {
                squares[i] = new LoopInBoard("You pass the starting point!");
			}
			else if (i == 2 || i == 4 || i == 7 || i == 9 || i == 10 || i == 12 || i == 14 || i == 15 || i == 17 || i == 19 || i == 20 || i == 20 ||
					 i == 24 || i == 25 || i == 27 || i == 28 || i == 30 || i == 32 || i == 33 || i == 35 || i == 38 || i == 40) {
				squares[i] = new Avenue("A new Avenue!");
			}
			else if (i == 3 || i == 18 || i == 34) {
				squares[i] = new CommunityChest("A Community Chest Card!");
			}
			else if (i == 5) {
				squares[i] = new IncomeTax("Income Tax!");
			}
			else if (i == 6 || i == 16 || i == 26 || i == 36) {
				squares[i] = new RailRoad("A RailRoad!");
			}
			else if (i == 8 || i == 23 || i == 37) {
				squares[i] = new Chance("A Chance Card!");
			}
			else if (i == 11) {
				squares[i] = new Jail("In Jail, Just Visiting!");
			}
			else if (i == 13 || i == 29) {
				squares[i] = new Utilities("Utilities! (Electric / Water)");
			}
			else if (i == 21) {
				squares[i] = new FreeParking("Free Parking!");
			}
			else if (i == 31) {
				squares[i] = new GoToJail("Go To Jail!");
			}
			else if (i == 39) {
				squares[i] = new LuxuryTax("Luxury Tax!");
			}
		}
	return squares;
	}
	
	public int movePlayerOnBoard (Player player) {
		int firstDie, secondDie, moving;
		firstDie = player.SingleDie();
		secondDie = player.SingleDie();
		moving = firstDie + secondDie;
		player.setLocation(moving);
		int currentLocation = (int)(player.getLocation());
		return currentLocation;
	}
}