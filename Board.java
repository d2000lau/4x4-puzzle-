public class Board{
	
public final static int boardSize = 4;
public Tile blank;	
public List<Tile> allTiles;	
	
	private class Tile {
		public int xCoord;
		public int yCoord;
		public int value;
		
		public Tile (int number, int x, int y) {
			this.xCoord = x;
			this.yCoord = y;
			this.value = number;
		}
	}	
	
	//Generate board and fill tiles randomly
	private generatePuzzle(){
		
		//Add all tiles to public list
		//Check is board is solvable, if not make new one
		//solvable if Xblank=0,2 and inversion odd or xblank=1,3 and inversions even
	}
	
	private boolean isSolvable(List<Tile> board){
		int inversions = 0;
		int temp = board.get(0).value;
		
		for(Tile T : board){
			if(T.value > temp){
				inversion++;
			}
			temp = T.value;
		}
		
		if(blank.xCoord = 0 || blank.xCoord = 2 && inversions % 2 != 0){
			return true;
		}
		else if (blank.xCoord = 1 || blank.xCoord = 3 && inversions % 2 == 0){
			return true;
		}
		
		return false;
	}
	
	  //moves the tile and checks is the move is valid
	private move(Tile T){
		
		int dx = Math.abs(blank.xCoord - T.xCoord);
		int dy = Math.abs(blank.yCoord - T.yCoord);
		
		if(dx + dy = 1 && T.xCoord >= 0 && T.xCoord < boardSize && T.yCoord >= 0 && T.yCoord < boardSize){
			swap(T, blank);
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
	
	//Check is board is solved
	private boolean solved(List<Tile> board){
		//trying to assign tiles to their correct coordinates
	List<Tile> correctTiles = new List<Tile>(15);
		for(int i =0; i<4; i++){
			for(int j =0; i<4; j++){
				correctTiles.add()
			}
		}
		
		//if the tiles in board equal correctTiles then puzzle solved, otherwise not
			
		
	}
	
	private getCorrectCoordinates(Tile t){
		Map<Integer, String>  = new HashMap<Integer, String>();
		
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
