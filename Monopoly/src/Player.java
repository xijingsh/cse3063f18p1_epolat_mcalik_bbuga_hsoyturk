
public class Player {
	Dice dice = new Dice();
	private int nthPlayer;
	private String name;
    private Money money = new Money();
    Square square;
    int location = 0;
    
	 public Player(int nthPlayer, String name, int startingMoney, int location) {
	 	this.nthPlayer = nthPlayer;
	    this.name = name;
	    this.money.setMoney(startingMoney);
	    setLocation(location);
	 }
	 
	 public int getLocation() {
		 return location;
	 }
	 
     public void setLocation(int newLocation) {
        location = getLocation() + newLocation;
        if (location >= 41) {
        	location -= 40;
			return;
		}
        return;
	    }
     
	 public int SingleDie() {
		 return dice.getDiceValue();
     }
	 
     public String getName() {
	    return name;
     }
}
