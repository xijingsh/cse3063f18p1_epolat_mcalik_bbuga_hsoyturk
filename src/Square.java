
public abstract class Square {
	
	private String nameOfSquare;
	private int priceOfSquare;
	private int rentOfSquare;
	private int isItHasOwner = 0;
	private Player owner;
	private String[] avenues = new String[40];
	private int[] priceOfAvenue = new int[40];
	private int[] rentOfAvenue = new int[40];
	private String otherUtilityOwner = "";
	
	
	public Square(String nameOfSquare, int priceOfSquare, int rentOfSquare) {
		this.nameOfSquare = nameOfSquare;
	    this.priceOfSquare = priceOfSquare;
	    this.rentOfSquare = rentOfSquare;
	}
	 
	public String getName() {
		return this.nameOfSquare;
	}
	 
	public Player getOwner() {
		return this.owner;
	}
	 
	public void setOwner(Player player) {
		this.owner = player;
		player.getMoney().reduceMoney(this.priceOfSquare);
		this.isItHasOwner = 1;
	}
	 
	public int hasOwner() {
		return this.isItHasOwner;
	}
	 
	public int getPrice() {
	    return this.priceOfSquare;
	}

	public int getRent() {
	    return this.rentOfSquare;
	}
	 
	public String nameOfAvenue(int location) {
		
		avenues[1] = "Mediterranean Avenue";
		avenues[3] = "Baltic Avenue";
		avenues[5] = "New York RailRoad";
		avenues[6] = "Oriental Avenue";
		avenues[8] = "Vermont Avenue";
		avenues[9] = "Connecticut Avenue";
		avenues[11] = "St.Charles Place";
		avenues[12] = "Electric Company";
		avenues[13] = "States Avenue";
		avenues[14] = "Virginia Avenue";
		avenues[15] = "Pennsylvania RailRoad";
		avenues[16] = "St.James Place";
		avenues[18] = "Tennessee Avenue";
		avenues[19] = "New York Avenue";
		avenues[21] = "Kentucky Avenue";
		avenues[23] = "Indiana Avenue";
		avenues[24] = "Illinois Avenue";
		avenues[25] = "B. & O. RailRoad";
		avenues[26] = "Atlantic Avenue";
		avenues[27] = "Ventnor Avenue";
		avenues[28] = "Water Works";
		avenues[29] = "Marvin Gardens";
		avenues[31] = "Pacific Avenue";
		avenues[32] = "North Carolina Avenue";
		avenues[34] = "Pennsylvania Avenue";
		avenues[35] = "Short Line RailRoad";
		avenues[37] = "Park Place";
		avenues[39] = "BoardWalk";
		return avenues[location];
	}
	
	public int priceOfAvenue(int location) {
		
		priceOfAvenue[1] = 60;
		priceOfAvenue[3] = 60;
		priceOfAvenue[5] = 200;
		priceOfAvenue[6] = 100;
		priceOfAvenue[8] = 100;
		priceOfAvenue[9] = 120;
		priceOfAvenue[11] = 140;
		priceOfAvenue[12] = 150;
		priceOfAvenue[13] = 140;
		priceOfAvenue[14] = 160;
		priceOfAvenue[15] = 200;
		priceOfAvenue[16] = 180;
		priceOfAvenue[18] = 180;
		priceOfAvenue[19] = 200;
		priceOfAvenue[21] = 220;
		priceOfAvenue[23] = 220;
		priceOfAvenue[24] = 240;
		priceOfAvenue[25] = 200;
		priceOfAvenue[26] = 260;
		priceOfAvenue[27] = 260;
		priceOfAvenue[28] = 150;
		priceOfAvenue[29] = 280;
		priceOfAvenue[31] = 300;
		priceOfAvenue[32] = 300;
		priceOfAvenue[34] = 320;
		priceOfAvenue[35] = 200;
		priceOfAvenue[37] = 350;
		priceOfAvenue[39] = 400;
		return priceOfAvenue[location];
	}
	
	public int rentOfAvenue(int location) {
		
		rentOfAvenue[1] = 2;
		rentOfAvenue[3] = 4;
		rentOfAvenue[5] = 25;
		rentOfAvenue[6] = 6;
		rentOfAvenue[8] = 6;
		rentOfAvenue[9] = 8;
		rentOfAvenue[11] = 10;
		rentOfAvenue[12] = 15;
		rentOfAvenue[13] = 10;
		rentOfAvenue[14] = 12;
		rentOfAvenue[15] = 25;
		rentOfAvenue[16] = 14;
		rentOfAvenue[18] = 14;
		rentOfAvenue[19] = 16;
		rentOfAvenue[21] = 18;
		rentOfAvenue[23] = 18;
		rentOfAvenue[24] = 20;
		rentOfAvenue[25] = 25;
		rentOfAvenue[26] = 22;
		rentOfAvenue[27] = 22;
		rentOfAvenue[28] = 15;
		rentOfAvenue[29] = 24;
		rentOfAvenue[31] = 26;
		rentOfAvenue[32] = 26;
		rentOfAvenue[34] = 28;
		rentOfAvenue[35] = 25;
		rentOfAvenue[37] = 35;
		rentOfAvenue[39] = 50;
		return rentOfAvenue[location];
	}

	public String bothOfUtilityBelongsToSameOwner(String otherUtilityOwner) {
		return this.otherUtilityOwner = otherUtilityOwner;
	}
	
	public String bothOfUtilityBelongsToSameOwner() {
		return otherUtilityOwner;
	}
	
	public abstract void doAction(Player player, Board board);
	 
}