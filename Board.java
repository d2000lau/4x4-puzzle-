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
		if(dx + dy = 1 && T.xCoord < 0 && T.xCoord >= boardSize && T.yCoord < 0 && T.yCoord >= boardSize){
			
		}
	}
	
	
	
	//COPIED!! STILL NEEDS TO BE CHANGED
	public boolean isValidMove(TilePos p) {
		if( ( p.xCoord < 0) || (p.xCoord >= boardSize) ) {
			return false;
		}
		if( ( p.yCoord < 0) || (p.yCoord >= boardSize) ) {
			return false;
		}
		int dx = blank.xCoord - p.xCoord;
		int dy = blank.yCoord - p.yCoord;
		if( (Math.abs(dx) + Math.abs(dy) != 1 ) || (dx*dy != 0) ) {
			return false;
		}
		return true;
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
