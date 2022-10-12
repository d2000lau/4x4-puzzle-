public class Board{
public final static int boardSize = 4;
	private class TilePosition {
		public int xCoord;
		public int yCoord;
		
		public TilePos(int x, int y) {
			this.xCoord = x;
			this.yCoord = y;
		}
	}	
	
	private generatePuzzle(){
		
	}
	
	//COPIED!! STILL NEEDS TO BE CHANGED
	public boolean isValidMove(TilePos p) {
		if( ( p.xCoord < 0) || (p.x >= DIMS) ) {
			return false;
		}
		if( ( p.y < 0) || (p.y >= DIMS) ) {
			return false;
		}
		int dx = blank.x - p.x;
		int dy = blank.y - p.y;
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
