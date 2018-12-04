
public class GoToJail extends Square {
	
	private int firstDie;
	private int secondDie;

	public GoToJail(String nameOfSquare) {
        super(nameOfSquare, 0, 0);
    }
	public  void doAction(Player player){
		 
		System.out.println("Don't pass the starting point and collect 200 TL!");
		System.out.println("Roll the dice, if the dice become double, you can get away!");
		player.playerInJail();
		player.initializeLocation(10);
		try {
			Thread.sleep(3000);
		}
		catch(InterruptedException ex) { 
		} 
		firstDie = player.SingleDie();
		secondDie = player.SingleDie();
		player.DiceShape(firstDie, secondDie);

		if (firstDie == secondDie ) {
			System.out.println("\nYou have been escaped! Next tour, you can continue.\n");
			player.rescueFromJail();
		}
		else {
			System.out.println("\nYou couldn't escape! Next tour, roll again!");
			System.out.println("If the dice become double, you can get away!");
		}
	 }
}
