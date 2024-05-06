// Assignment: 11
// Name: Dean Prach 
// StudentID: 1222694057
// Lecture: MWF 10:10 - 11:00
// Description: This class will initialize the stack and a visited array and then check each element in the grid and increment it
// depending on the value entered by the user. This class also has a method called isVisited which returns false if the visited arraylist
// does not contain the node

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solver 
{

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

//Checks to see if a node has already been visited
public boolean isVisited(Node node)
{
	boolean result = false;
	for(int i = 0; i < visited.size(); i++)
	{
		if(node.getX() == visited.get(i).getX() && node.getY() == visited.get(i).getY())
		{
			result = true;
			break;
		}
	}
	return(result);
}

//This method will visit every node in a grid and store it into an array list. If the node NSEW of the current node has not been visited
//AND it meets the bounds of the grid the node will be added to the stack
public void depthFirstSearch()
{
	Node current;
	Node newNode;
	int newX;
	int newY;
	current = new Node(0,0);
	stack.push(current);
	while(!stack.isEmpty())
	{
		current = stack.peek();
		stack.pop();
		visited.add(current);
		//Test the spot below the current spot
		newX = current.getX();
		newY = current.getY() + 1;
		newNode = new Node(newX, newY);
		if(newX >= 0 && newY < width && newY >= 0 &&  newX < height && isVisited(newNode) == false)
		{
			stack.push(newNode);
			continue;
		}
		//Test the spot to the right of the current spot
		newX = current.getX() + 1;
		newY = current.getY();
		newNode = new Node(newX, newY);
		if(newX >= 0 && newY < width && newY >= 0 &&  newX < height && isVisited(newNode) == false)
		{
			stack.push(newNode);
			continue;
		}
		//Test the spot above the current spot
		newX = current.getX();
		newY = current.getY() - 1;
		newNode = new Node(newX, newY);
		if(newX >= 0 && newY < width && newY >= 0 &&  newX < height && isVisited(newNode) == false)
		{
			stack.push(newNode);
			continue;
		}
		//Test the spot to the left of the current spot
		newX = current.getX() - 1;
		newY = current.getY();
		newNode = new Node(newX, newY);
		if(newX >= 0 && newY < width && newY >= 0 &&  newX < height && isVisited(newNode) == false)
		{
			stack.push(newNode);
			continue;
		}


	}
	for(int i = 0; i < visited.size(); i++)
	{
		grid[visited.get(i).getX()][visited.get(i).getY()] = grid[visited.get(i).getX()][visited.get(i).getY()] + increment;
	}
}

//Reads the grid entered by the user
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

			for (int i = 0; i < height; i++) 
			{
				for (int j = 0; j < width; j++) 
				{
					line = reader.readLine();
					grid[i][j] = Integer.parseInt(line);
				}
			}

		} catch (IOException e) 
		{
			e.printStackTrace();
		}

	}

//Prints the grid created by the user
	public void printGrid() 
	{
		for (int i = 0; i < grid.length; i++) 
		{
			for (int j = 0; j < grid[0].length; j++) 
			{

				System.out.print(grid[i][j]);
				System.out.print('	');
			}
			System.out.println();
		}

		System.out.println();
	}

}
