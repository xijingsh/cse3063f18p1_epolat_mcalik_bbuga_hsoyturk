
public class GoToJail extends Square {

	public GoToJail(String nameOfSquare) {
        super(nameOfSquare, 0, 0);
    }
	 public  void doAction(Player player){
		 System.out.println("Don't pass the starting point and collect 200 TL!");
		 player.setLocation(player,10);
	 }
}
