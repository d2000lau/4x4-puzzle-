public class Board{
	
public final static int boardSize = 4;
public Tile blank;	
	
	private class Tile {
		public int xCoord;
		public int yCoord;
		
		public Tile (int value, int x, int y) {
			this.xCoord = x;
			this.yCoord = y;
		}
	}	
	
	//Generate board and fill tiles randomly
	private generatePuzzle(){
		
		
	}
	
	  //moves the tile and checks is the move is valid
	private move(Tile T){
		
		int dx = Math.abs(blank.xCoord - T.xCoord);
		int dy = Math.abs(blank.yCoord - T.yCoord);
		
		if(dx + dy = 1 && T.xCoord >= 0 && T.xCoord < boardSize && T.yCoord >= 0 && T.yCoord < boardSize){
			
		}
	}
	
	//swaps position of two tiles
	private swap (Tile t1, Tile t2){
		int temp1 = t1.xCoord;
		int temp2 = t1.yCoord;
		t1.xCoord = t2.xCoord;
		t1.yCoord = t2.yCoord;
		t2.xCoord = temp1;
		t2.yCoord = temp2;
  	
	}
	

	
	//get position of blank tile
	//swapping two tiles
	//direction that a piece can be moved, if any
	//move function that returns the direction the tile was moved (uses swap)
	//condition for goal state
	//get a copy of the current state of the board
	//for a specific tile, return all the allowed moves
	//get Manhattan distance
	//counts number of misplaced tiles (for manhattan)
	//
	
}
