
public abstract class Square {
	
	public String nameOfSquare;
	public int priceOfSquare;
	public int rentOfSquare;
	public int squareLocationOfPlayer;
	
	public Square(String nameOfSquare, int priceOfSquare, int rentOfSquare) {
		this.nameOfSquare = nameOfSquare;
	    this.priceOfSquare = priceOfSquare;
	    this.rentOfSquare = rentOfSquare;
	 }
	 
	 public String getName() {
		return this.nameOfSquare;
	 }
}
