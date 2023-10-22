/*
 * Class: CMSC203 
 * Instructor: Dr. Kuijt 
 * Description: property class
 * Due: 10/22/2023
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Ilyas Rehman
*/

public class Property {
	private String propertyName;
	private String city;
	private double rentAmount;
	private String owner;
	private Plot plot; 
	Property(){
		propertyName = "";
		city = "";
		rentAmount = 0.00;
		owner = "";
		plot = new Plot();
	}
	Property(String propertyNamein, String cityin, double rentAmountin, String ownerin){
		propertyName = propertyNamein;
		city = cityin;
		rentAmount = rentAmountin;
		owner = ownerin;
		plot = new Plot();
	}
	Property(String propertyNamein, String cityin, double rentAmountin, String ownerin, int xin, int yin, int widthin, int depthin){
		propertyName = propertyNamein;
		city = cityin;
		rentAmount = rentAmountin;
		owner = ownerin;
		plot = new Plot(xin, yin, widthin, depthin);
	}
	Property(Property otherProperty){
	propertyName = otherProperty.propertyName;
	city = otherProperty.city;
	rentAmount = otherProperty.rentAmount;
	owner = otherProperty.owner;
	plot = new Plot(otherProperty.plot);
	}
	public String getPropertyName() {
		return propertyName;
	}
	public String getCity() {
		return city;
	}
	public double getRentAmount() {
		return rentAmount;
	}
	public String getOwner() {
		return owner;
	}
	public Plot getPlot() {
		return plot;
	}
	public String toString() {
		return propertyName + "," + city + "," + owner +  "," + rentAmount;
	} 
}
