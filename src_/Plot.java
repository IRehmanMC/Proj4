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
public class Plot {
	private int x, y, width, depth;
	public Plot(){
		y = 0;
		x = 0;
		depth =1;
		width = 1; 
	}
	public Plot(int x, int y, int width, int depth){
		this.y = y;
		this.x = x;
		this.depth = depth;
		this.width = width;
	}
	public Plot(Plot otherPlot){
		y = otherPlot.y;
		x = otherPlot.x;
		width = otherPlot.width;
		depth = otherPlot.depth;
	}
	
	public int getWidth() {
		return width;
	}
	public int getDepth() {
		return depth;
	}
	public int getY() {
		return y;
	}
	public int getX() {
		return x;
	}
	public boolean overlaps(Plot plot) {
		if (plot.x + plot.width <= x || x + width <= plot.x)
			return false;
		if (plot.y + plot.depth <= y || y + depth <= plot.y)
			return false;
		return true;
    }
	public boolean encompasses(Plot plot) {
		if(!(plot.x >= x && plot.y >= y))
			return false;
		if(!((plot.x + plot.width) <= (x + width) && (plot.y + plot.depth) <= (y + depth)))
			return false;

		return true;
	}
	
	
	//toString
	public String toString() {
		return x + "," + y + "," + width + "," + depth;
	}
	
	
	

}
