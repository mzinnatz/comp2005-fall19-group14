package blokus;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class BlokusPiece
{
   public static final int SHAPE_SIZE = 7;
   public static final int PIECE = 3;
   public static final int ADJACENT = 2;
   public static final int CORNER = 1;
   public static final int BLANK = 0;
   
   public static final int DEFAULT_RESOLUTION = 120;
   
   private int[][] grid;
   private int color;
   
   public BlokusPiece(int[][] shape, int color)
   {
      if (shape.length != SHAPE_SIZE || shape[0].length != SHAPE_SIZE)
      {
         throw new IllegalArgumentException("Shape array must be 7x7.");
      }
      
      grid = (int[][]) shape.clone();
      this.color = color;
   }
   
   public void rotateClockwise()
   {
      int[][] temp = new int[SHAPE_SIZE][SHAPE_SIZE];
      
      for (int x = 0; x < SHAPE_SIZE; x++)
         for (int y = 0; y < SHAPE_SIZE; y++)
            temp[SHAPE_SIZE - y - 1][x] = grid[x][y];
            
      grid = temp;
   }
   
   public void rotateCounterClockwise()
   {
      int[][] temp = new int[SHAPE_SIZE][SHAPE_SIZE];
      
      for (int x = 0; x < SHAPE_SIZE; x++)
         for (int y = 0; y < SHAPE_SIZE; y++)
            temp[y][SHAPE_SIZE - x - 1] = grid[x][y];
            
      grid = temp;
   }
   
   public void flipOver()
   {
      int[][] temp = new int[SHAPE_SIZE][SHAPE_SIZE];
      
      for (int x = 0; x < SHAPE_SIZE; x++)
         for (int y = 0; y < SHAPE_SIZE; y++)
            temp[SHAPE_SIZE - x - 1][y] = grid[x][y];
            
      grid = temp;
   }
   
   public int getValue(int x, int y)
   {
      return grid[x][y];
   }
   
   
   public String toString()
   {
      StringBuffer sb = new StringBuffer();
      for (int y = 0; y < SHAPE_SIZE; y++)
      {
         for (int x = 0; x < SHAPE_SIZE; x++)
         {
            sb.append(grid[x][y]);
            sb.append(" ");
         }
         sb.append("\n");
      }
      return sb.toString();
   }
   
   public static int[][][] getAllShapes()
   {
      int[][][] shapes = new int[21][SHAPE_SIZE][SHAPE_SIZE];
      int i = 0;
      
      shapes[i++] = new int[][] { // * * * * *
         {0, 0, 0, 0, 0, 0, 0},
         {0, 0, 0, 0, 0, 0, 0},
         {1, 2, 2, 2, 2, 2, 1},
         {2, 3, 3, 3, 3, 3, 2},
         {1, 2, 2, 2, 2, 2, 1},
         {0, 0, 0, 0, 0, 0, 0},
         {0, 0, 0, 0, 0, 0, 0}
      };
      
      shapes[i++] = new int[][] { // * * * *
         {0, 0, 0, 0, 0, 0, 0}, //   *
         {0, 1, 2, 1, 0, 0, 0},
         {0, 2, 3, 2, 2, 2, 1},
         {0, 2, 3, 3, 3, 3, 2},
         {0, 1, 2, 2, 2, 2, 1},
         {0, 0, 0, 0, 0, 0, 0},
         {0, 0, 0, 0, 0, 0, 0}
      };
      
      shapes[i++] = new int[][] { //   * * *
         {0, 0, 1, 2, 1, 0, 0},   // * *
         {0, 0, 2, 3, 2, 0, 0},
         {0, 0, 2, 3, 2, 1, 0},
         {0, 0, 2, 3, 3, 2, 0},
         {0, 0, 1, 2, 3, 2, 0},
         {0, 0, 0, 1, 2, 1, 0},
         {0, 0, 0, 0, 0, 0, 0}
      };
      
      shapes[i++] = new int[][] { //   *
         {0, 0, 0, 0, 0, 0, 0}, // * * * *
         {0, 0, 1, 2, 1, 0, 0},
         {0, 1, 2, 3, 2, 2, 1},
         {0, 2, 3, 3, 3, 3, 2},
         {0, 1, 2, 2, 2, 2, 1},
         {0, 0, 0, 0, 0, 0, 0},
         {0, 0, 0, 0, 0, 0, 0}
      };
      
      shapes[i++] = new int[][] { //   *
         {0, 0, 0, 0, 0, 0, 0}, // * * *
         {0, 0, 1, 2, 1, 0, 0}, //   *
         {0, 1, 2, 3, 2, 1, 0},
         {0, 2, 3, 3, 3, 2, 0},
         {0, 1, 2, 2, 3, 2, 0},
         {0, 0, 0, 1, 2, 1, 0},
         {0, 0, 0, 0, 0, 0, 0}
      };
      
      shapes[i++] = new int[][] { // *
         {0, 0, 0, 0, 0, 0, 0}, // * * *
         {0, 0, 1, 2, 1, 0, 0}, //   *
         {0, 1, 2, 3, 2, 1, 0},
         {0, 2, 3, 3, 3, 2, 0},
         {0, 1, 2, 3, 2, 1, 0},
         {0, 0, 1, 2, 1, 0, 0},
         {0, 0, 0, 0, 0, 0, 0}
      };
      
      shapes[i++] = new int[][] { // * * *
         {0, 0, 0, 0, 0, 0, 0},   // *   *
         {0, 0, 0, 0, 0, 0, 0},
         {0, 1, 2, 2, 2, 1, 0},
         {0, 2, 3, 3, 3, 2, 0},
         {0, 2, 3, 2, 3, 2, 0},
         {0, 1, 2, 1, 2, 1, 0},
         {0, 0, 0, 0, 0, 0, 0}
      };
      
      shapes[i++] = new int[][] { // * *
         {0, 0, 0, 0, 0, 0, 0}, // * * *
         {0, 0, 0, 0, 0, 0, 0},
         {0, 1, 2, 2, 2, 1, 0},
         {0, 2, 3, 3, 3, 2, 0},
         {0, 1, 2, 3, 3, 2, 0},
         {0, 0, 1, 2, 2, 1, 0},
         {0, 0, 0, 0, 0, 0, 0}
      };
      
      shapes[i++] = new int[][] { //   *
         {0, 0, 0, 0, 0, 0, 0}, //   * *
         {0, 0, 0, 1, 2, 1, 0}, // * *
         {0, 0, 1, 2, 3, 2, 0},
         {0, 1, 2, 3, 3, 2, 0},
         {0, 2, 3, 3, 2, 1, 0},
         {0, 1, 2, 2, 1, 0, 0},
         {0, 0, 0, 0, 0, 0, 0}
      };
      
      shapes[i++] = new int[][] { // *
         {0, 0, 0, 0, 0, 0, 0},   // * * *
         {0, 0, 1, 2, 1, 0, 0},   // *
         {0, 0, 2, 3, 2, 0, 0},
         {0, 1, 2, 3, 2, 1, 0},
         {0, 2, 3, 3, 3, 2, 0},
         {0, 1, 2, 2, 2, 1, 0},
         {0, 0, 0, 0, 0, 0, 0}
      };
      
      shapes[i++] = new int[][] { // *
         {0, 0, 1, 2, 1, 0, 0},   // *
         {0, 0, 2, 3, 2, 0, 0},   // * * *
         {0, 0, 2, 3, 2, 2, 1},
         {0, 0, 2, 3, 3, 3, 2},
         {0, 0, 1, 2, 2, 2, 1},
         {0, 0, 0, 0, 0, 0, 0},
         {0, 0, 0, 0, 0, 0, 0}
      };
      
      shapes[i++] = new int[][] { // *
         {0, 0, 0, 0, 0, 0, 0},   // * * *
         {0, 0, 1, 2, 2, 1, 0},   //     *
         {0, 0, 2, 3, 3, 2, 0},
         {0, 1, 2, 3, 2, 1, 0},
         {0, 2, 3, 3, 2, 0, 0},
         {0, 1, 2, 2, 1, 0, 0},
         {0, 0, 0, 0, 0, 0, 0}
      };
      
      
      shapes[i++] = new int[][] { // * * * *
         {0, 0, 1, 2, 1, 0, 0},   // 
         {0, 0, 2, 3, 2, 0, 0},
         {0, 0, 2, 3, 2, 0, 0},
         {0, 0, 2, 3, 2, 0, 0},
         {0, 0, 2, 3, 2, 0, 0},
         {0, 0, 1, 2, 1, 0, 0},
         {0, 0, 0, 0, 0, 0, 0}
      };
      
      shapes[i++] = new int[][] { // * *
         {0, 0, 0, 0, 0, 0, 0},   //   * *
         {0, 0, 1, 2, 2, 1, 0},
         {0, 1, 2, 3, 3, 2, 0},
         {0, 2, 3, 3, 2, 1, 0},
         {0, 1, 2, 2, 1, 0, 0},
         {0, 0, 0, 0, 0, 0, 0},
         {0, 0, 0, 0, 0, 0, 0}
      };
      
      shapes[i++] = new int[][] { // * *
         {0, 0, 0, 0, 0, 0, 0}, //   * *
         {0, 1, 2, 2, 1, 0, 0},
         {0, 2, 3, 3, 2, 0, 0},
         {0, 2, 3, 3, 2, 0, 0},
         {0, 1, 2, 2, 1, 0, 0},
         {0, 0, 0, 0, 0, 0, 0},
         {0, 0, 0, 0, 0, 0, 0}
      };
      
      shapes[i++] = new int[][] { // *
         {0, 0, 0, 0, 0, 0, 0}, // * * *
         {0, 0, 1, 2, 1, 0, 0},
         {0, 1, 2, 3, 2, 1, 0},
         {0, 2, 3, 3, 3, 2, 0},
         {0, 1, 2, 2, 2, 1, 0},
         {0, 0, 0, 0, 0, 0, 0},
         {0, 0, 0, 0, 0, 0, 0}
      };
      
      shapes[i++] = new int[][] { //   *
         {0, 0, 0, 0, 0, 0, 0}, // * * *
         {0, 0, 0, 0, 0, 0, 0},
         {0, 1, 2, 2, 2, 2, 0},
         {0, 2, 3, 3, 3, 2, 0},
         {0, 1, 2, 2, 3, 2, 0},
         {0, 0, 0, 1, 2, 1, 0},
         {0, 0, 0, 0, 0, 0, 0}
      };
      
      shapes[i++] = new int[][] { // 
         {0, 0, 0, 0, 0, 0, 0},   // * * *
         {0, 0, 0, 0, 0, 0, 0},
         {0, 1, 2, 2, 2, 1, 0},
         {0, 2, 3, 3, 3, 2, 0},
         {0, 1, 2, 2, 2, 1, 0},
         {0, 0, 0, 0, 0, 0, 0},
         {0, 0, 0, 0, 0, 0, 0}
      };
      
      shapes[i++] = new int[][] { // *
         {0, 0, 0, 0, 0, 0, 0},   // * *
         {0, 0, 1, 2, 1, 0, 0},
         {0, 0, 2, 3, 2, 1, 0},
         {0, 0, 2, 3, 3, 2, 0},
         {0, 0, 1, 2, 2, 1, 0},
         {0, 0, 0, 0, 0, 0, 0},
         {0, 0, 0, 0, 0, 0, 0}
      };
      
      shapes[i++] = new int[][] { // * *
         {0, 0, 0, 0, 0, 0, 0},   // 
         {0, 0, 1, 2, 1, 0, 0},
         {0, 0, 2, 3, 2, 0, 0},
         {0, 0, 2, 3, 2, 0, 0},
         {0, 0, 1, 2, 1, 0, 0},
         {0, 0, 0, 0, 0, 0, 0},
         {0, 0, 0, 0, 0, 0, 0}
      };
      
      shapes[i++] = new int[][] { // *
         {0, 0, 0, 0, 0, 0, 0},   // 
         {0, 0, 0, 0, 0, 0, 0},
         {0, 0, 1, 2, 1, 0, 0},
         {0, 0, 2, 3, 2, 0, 0},
         {0, 0, 1, 2, 1, 0, 0},
         {0, 0, 0, 0, 0, 0, 0},
         {0, 0, 0, 0, 0, 0, 0}
      };
      
      return shapes;
   }
}