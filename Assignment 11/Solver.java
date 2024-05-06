import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solver {

	// ********************** ADD YOUR CODE HERE **********************
private Stack<Node> stack;
private int[][] grid;
private int height;
private int width;
private int increment;
private ArrayList<Node> visited;

public Solver()
{
	stack = new Stack<>();
	visited = new ArrayList<>();

}

public boolean isVisited(Node node)
{
	for(int i = 0; i < visited.size(); i++)
	{
		if(node == visited.get(i))
		{
			return(true);
		}
	}
	return(false);
}

public void depthFirstSearch()
{
	Node test;
	int newX;
	int newY;
	test = new Node(0,0);
	stack.push(test);
	while(!stack.isEmpty())
	{
		test = stack.pop();
		visited.add(test);
		newX = test.getX();
		newY = test.getY() + 1;
		if(newX > 0 && newY > 0 && Node(newX,newY).isVisited() == false)
		{
			Node newNode = new Node(newX,newY);
			stack.push(newNode);
		}
		newX = test.getX() + 1;
		newY = test.getY();
		if(newX > 0 && newY > 0 && Node(newX,newY).isVisited() == false)
		{
			Node newNode = new Node(newX,newY);
			stack.push(newNode);
		}
		newX = test.getX();
		newY = test.getY() - 1;
		if(newX > 0 && newY > 0 && isVisited(Node(newX,newY)) == false)
		{
			Node newNode = new Node(newX,newY);
			stack.push(newNode);
		}
		newX = test.getX() - 1;
		newY = test.getY();
		if(newX > 0 && newY > 0 && Node(newX,newY).isVisited() == false)
		{
			Node newNode = new Node(newX,newY);
			stack.push(newNode);
		}


	}
}




	// ************************************************************************************
	// ************** Utility method to read grid from user input *************************
	// ************************************************************************************
	public void readGrid() {

		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Height of the grid: ");
			String line = reader.readLine();
			height = Integer.parseInt(line);

			System.out.println("Width of the grid: ");
			line = reader.readLine();
			width = Integer.parseInt(line);
			grid = new int[height][width];

			System.out.println("Increment Factor: ");
			line = reader.readLine();
			increment = Integer.parseInt(line);

			System.out.println("Now enter the grid row by row:");

			for (int i = 0; i < height; i++) {
				for (int j = 0; j < width; j++) {
					line = reader.readLine();
					grid[i][j] = Integer.parseInt(line);
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// ************************************************************************************
	// ************** Utility method to print grid ****************************************
	// ************************************************************************************
	public void printGrid() {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {

				System.out.print(grid[i][j]);
				System.out.print('	');
			}
			System.out.println();
		}

		System.out.println();
	}

}
