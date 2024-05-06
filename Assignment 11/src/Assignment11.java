// Assignment: 11
// Name: Dean Prach 
// StudentID: 1222694057
// Lecture: MWF 10:10 - 11:00
// Description: This driver class will call the methods to print the original grid, depthFirstSearch, and then print the new grid.

public class Assignment11 
{

	public static void main(String[] args) 
	{
		Solver solver = new Solver();
		solver.readGrid();

		System.out.println("Original grid: ");
		solver.printGrid();

		solver.depthFirstSearch();

		System.out.println("Grid after increment: ");
		solver.printGrid();
	}
}