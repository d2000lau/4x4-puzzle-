public class Board{
public final static int boardSize = 4;
	private class Tile {
		public int xCoord;
		public int yCoord;
		
		public Tile (int x, int y, int value) {
			this.xCoord = x;
			this.yCoord = y;
		}
	}	
	
	private generatePuzzle(){
		
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
