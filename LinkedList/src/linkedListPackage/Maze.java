package linkedListPackage;

import java.util.*;

public class Maze {
    private static final int SIZE = 10; // Size of the maze
    private static final char WALL = '#';
    private static final char PATH = ' ';
    private static final char START = 'S';
    private static final char END = 'E';

    private char[][] maze;

    public Maze() {
        maze = new char[SIZE][SIZE];
        initializeMaze();
        generateMaze();
        generatePath();
    }

    private void initializeMaze() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                maze[i][j] = WALL;
            }
        }
    }

    private void generateMaze() {
        Random random = new Random();

        for (int i = 1; i < SIZE - 1; i += 2) {
            for (int j = 1; j < SIZE - 1; j += 2) {
                maze[i][j] = PATH;

                // Randomly connect adjacent cells
                if (i < SIZE - 2) {
                    int randomIndex = i + 2 + random.nextInt(SIZE - i - 2) / 2 * 2;
                    maze[randomIndex][j] = PATH;
                }

                if (j < SIZE - 2) {
                    int randomIndex = j + 2 + random.nextInt(SIZE - j - 2) / 2 * 2;
                    maze[i][randomIndex] = PATH;
                }
            }
        }

        maze[1][0] = START; // Start position
        maze[SIZE - 2][SIZE - 1] = END; // End position
    }

    private void generatePath() {
        Stack<int[]> stack = new Stack<>();
        int[] start = { 1, 0 };
        stack.push(start);

        while (!stack.isEmpty()) {
            int[] current = stack.peek();
            int x = current[0];
            int y = current[1];

            if (x == SIZE - 2 && y == SIZE - 1) {
                break; // Reached the end position
            }

            boolean moved = false;

            // Check adjacent cells
            if (x > 1 && maze[x - 2][y] == PATH) {
                stack.push(new int[] { x - 2, y }); // Move up
                moved = true;
            } else if (x < SIZE - 2 && maze[x + 2][y] == PATH) {
                stack.push(new int[] { x + 2, y }); // Move down
                moved = true;
            } else if (y > 0 && maze[x][y - 1] == PATH) {
                stack.push(new int[] { x, y - 1 }); // Move left
                moved = true;
            } else if (y < SIZE - 1 && maze[x][y + 1] == PATH) {
                stack.push(new int[] { x, y + 1 }); // Move right
                moved = true;
            }

            if (!moved) {
                stack.pop(); // Dead end, backtrack
            }
        }

        // Mark the path in the maze
        while (!stack.isEmpty()) {
            int[] position = stack.pop();
            maze[position[0]][position[1]] = PATH;
        }
    }

    public void printMaze() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(maze[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
    	Maze mazeGenerator = new Maze();
        mazeGenerator.printMaze();
    }
}
