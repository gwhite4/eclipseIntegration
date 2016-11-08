/*
 * Programmer: Gabriel White
 * Program Name: Floor.java
 * 
 */

public class Floor {
	//warehouse locations and names
	public static Floor shelfArea = new Floor(13,6);
	public static Floor chargers = new Floor(10,9);
	public static Floor shippingDock = new Floor(1,10);
	public static Floor belt = new Floor(2,3);
	public static Floor pack = new Floor(5,6);
	public static Floor pick = new Floor(5,1);
	public static Floor receivingDock = new Floor(18,10);
	public static Floor highway1 = new Floor(14,1.5);
	public static Floor highway2 = new Floor(8,3);
	public static Floor highway3 = new Floor(17.5,6);
	public static Floor highway4 = new Floor(12,7.5);
	public static Floor highway5 = new Floor(3,3.5);
	//(x,y) coordinates
	public double xCoor, yCoor;
	
	public Floor(double x, double y) {
		xCoor = x;
		yCoor = y;
	}
	
	public double getXCoor() {
		return this.xCoor;
	}
	
	public double getYCoor() {
		return this.yCoor;
	}
	
	//returns the next area for the robot
	public Floor path(Floor current) {
		Floor nextArea = new Floor(0,0);
		if(current == shelfArea) nextArea = highway4;
		else if(current == chargers) nextArea = highway2;
		else if(current == highway2) nextArea = highway5;
		else if(current == highway5) nextArea = pick;
		else if(current == pick) nextArea = highway1;
		else if(current == highway1) nextArea = highway3;
		else if(current == highway3) nextArea = shelfArea;
		else if(current == highway4) nextArea = highway2;
		
		return nextArea;
	}
	
	//returns a String object to print the current location.
	public String printAreaName() {
		String area = "";
		if(this == highway4) area = "Highway 4";
		else if(this == chargers) area = "Chargers";
		else if(this == highway5) area = "Highway 5";
		else if(this == pick) area = "Pick";
		else if(this == highway1) area = "Highway 1";
		else if(this == highway3) area = "Highway 3";
		else if(this == shelfArea) area = "Shelf Area";
		else if(this == highway2) area = "Highway 2";
		else if(this == shippingDock) area = "Shipping Dock";
		else if(this == receivingDock) area = "Receiving Dock";
		else if(this == belt) area = "Belt";
		else if(this == pack) area = "Pack";
		
		return area;
	}
	
	//for testing purposes
	public static void main(String[] args) {
		System.out.println(shelfArea.getXCoor());
		System.out.println(chargers.getYCoor());
		Floor test = new Floor(0,0);
		test = test.path(pick);
		System.out.println(test.printAreaName());
		
	}
	
}