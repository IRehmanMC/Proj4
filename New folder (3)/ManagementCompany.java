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
public class ManagementCompany {
	//static constants
	public static final int MAX_PROPERTY = 5;
    public static final int MGMT_WIDTH = 10;
    public static final int MGMT_DEPTH = 10;
    
	//fields
    private String name;
    private String taxID;
    private double mgmFeePer;
    private Property[] properties;
    private Plot plot;
    private int numberOfProperties;
    
    //constructors
    public ManagementCompany() {
        name = "";
        taxID = "";
        mgmFeePer = 0.0;
        plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
        properties = new Property[MAX_PROPERTY];
        numberOfProperties = 0;
    }
    public ManagementCompany(String namein, String taxIDin, double mgmFeePerin) {
        name = namein;
        taxID = taxIDin;
        mgmFeePer = mgmFeePerin;
        plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
        properties = new Property[MAX_PROPERTY];
        numberOfProperties = 0;
    }
    public ManagementCompany(String namein, String taxIDin, double mgmFeePerin, int xin, int yin, int widthin, int depthin) {
        name = namein;
        taxID = taxIDin;
        mgmFeePer = mgmFeePerin;
        plot = new Plot(xin, yin, widthin, depthin);
        properties = new Property[MAX_PROPERTY];
        numberOfProperties = 0;
    }
    public ManagementCompany(ManagementCompany otherCompany) {
    	name = otherCompany.name;
        taxID = otherCompany.taxID;
        mgmFeePer = otherCompany.mgmFeePer;
        plot = new Plot(otherCompany.plot);
        properties = new Property[MAX_PROPERTY];
        for (int i=0; i <= (otherCompany.numberOfProperties-1); i++) {
        	properties[i] = new Property(otherCompany.properties[i]);
        }
        numberOfProperties = otherCompany.numberOfProperties;
    }
	public String getName() {
		return name;
	}
	public String getTaxID() {
		return taxID;
	}
	public double getMgmFeePer() {
		return mgmFeePer;
	}
	public Property[] getProperties() {
		return properties;
	}
	public Plot getPlot() {
		return plot;
	}
	int getPropertiesCount() {
		return numberOfProperties;
	}

	public int addProperty(Property property) {
		if(numberOfProperties == MAX_PROPERTY)
			return -1;
		if(property == null) 
			return -2;
		if(!plot.encompasses(property.getPlot()))
			return -3;
		for(int i =0; i <= (numberOfProperties-1); i++) {
			if(property.getPlot().overlaps(properties[i].getPlot()))
				return -4;
		}
		numberOfProperties+=1;
		properties[numberOfProperties-1] = new Property(property);
		return (numberOfProperties-1);
	}
	
	public int addProperty(String namein, String cityin, double rentin, String ownerin) {
		return addProperty(new Property(namein, cityin, rentin, ownerin));
	}
	
	public int addProperty(String namein, String cityin, double rentin, String ownerin, int xin, int yin, int widthin, int depthin) {
		return addProperty(new Property(namein, cityin, rentin, ownerin, xin, yin, widthin, depthin));
	}
	
	public Property getHighestRentPropperty() {
		//checks which property has the highest rent and returns it
		Property high = properties[0];
		for (int i = 1; i <= (numberOfProperties-1); i++) {
			if(properties[i].getRentAmount() > high.getRentAmount())
				high = properties[i];
		}
		return high;
	}
	
	public double getTotalRent() {
		double tot = 0;
		for (int i = 0; i <= (numberOfProperties-1); i++) {
			tot = tot + properties[i].getRentAmount();
		}
		return tot;
	}
	
	boolean isMangementFeeValid() {
		if ((mgmFeePer >= 0) && (mgmFeePer <= 100))
			return true;
		return false;
	}
	boolean isPropertiesFull() {
		if(numberOfProperties == MAX_PROPERTY)
			return true;
		return false;
	}
	void removeLastProperty() {
		//reduce number of properties and making the last property null
		properties[numberOfProperties-1] = null;
		numberOfProperties-=1;
	}

	
	
	
    //toString
	public String toString() {
		String str = "";
		//lists all properties
		for(int i =0; i <= (numberOfProperties-1); i++)
			str += properties[i].toString() + "\n";
		
		return "List of the properties for " + name + ", taxID: " + taxID + "\n"
				+ "______________________________________________________\n"
				+ str
				+ "______________________________________________________\n"
				+"\n"
				+ " total management Fee: " + (getTotalRent()*mgmFeePer/100.0);
	}

}
