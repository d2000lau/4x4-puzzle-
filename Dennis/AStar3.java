public class AStar {
    private Search current;

    /**
     * solves the board using A* algorithm
     * @param start starting board matrix
     */
    public AStar(Board start) {
        MinPQ<Search> minPQ = new MinPQ<>();
        current = new Search(start, null);  // initialization
        minPQ.insert(current);
        Search twinNode = new Search(start.twin(), null); // exchanging two positions
        MinPQ<Search> minTwinNode = new MinPQ<>();
        minTwinNode.insert(twinNode);

        boolean check = false;
        while (!check) {
            current = minPQ.delMin();  //  least  value
            if (current.board.isGoal()){
                check = true;
            } else{
                insertNeighbor(current, minPQ);
            }
            // computation on new board after restructure
            twinNode = minTwinNode.delMin();   //  least value
            if (twinNode.board.isGoal()){
                check = true;
            } else{
                insertNeighbor(twinNode, minTwinNode);
            }

        }
    }

    public static void main(String[] args) {
        int [][]matrix = new int[4][4];
        matrix[0][0] = 1;
        matrix[0][1] = 2;
        matrix[0][2] = 3;
        matrix[0][3] = 4;
        matrix[1][0] = 5;
        matrix[1][1] = 0;
        matrix[1][2] = 7;
        matrix[1][3] = 8;
        matrix[2][0] = 9;
        matrix[2][1] = 6;
        matrix[2][2] = 11;
        matrix[2][3] = 12;
        matrix[3][0] =13;
        matrix[3][1] = 10;
        matrix[3][2] =14;
        matrix[3][3] = 15;

        Board board = new Board(matrix);
        AStar solve = new AStar(board);
        Iterable<Board> iteration = solve.solution();
        for (Board x : iteration) {
            System.out.println(x.toString());
        }
    }

    /**
     *
     * @param current current node
     * @param pMinPQ least priority node value
     */
    private void insertNeighbor(Search current, MinPQ<Search> pMinPQ) {
        Iterable<Board> boards = current.board.neighbors(); // all neighbor
        for (Board neighborsBoard : boards) {
            if (current.previous == null ||
                    !neighborsBoard.equals(current.previous.board))   // prevent  backtrack
                pMinPQ.insert(new Search(neighborsBoard, current));  // add neighbor priority queue
        }
    }

    /**
     *
     * @return returns true if board is solvable, false otherwise
     */
    public boolean solveCheck(){
        return current.board.isGoal();
    }

    /**
     *
     * @return returns sequence of optimal shortest solution, return null if cant solve
     */
    public Iterable<Board> solution() {
        if (!solveCheck())
            return null;
        Stack<Board> stack = new Stack<>();
        while (current != null) {
            stack.push(current.board);
            current = current.previous;
        }
        return stack;
    }

    private class Search implements Comparable<Search> {
        private final Board board;
        private final int priority;
        private final int moves;
        private Search previous = null;

        public Search(Board board, Search previous) {
            this.board = board;
            this.previous = previous;
            if (previous == null){
                moves = 0;
            }
            else{
                moves = previous.moves + 1;
            }
            priority = board.manhattan() + moves;
        }

        /**
         *
         * @param y the object to be compared.
         * @return returns -1 if smaller than y, 1 if greater
         */
        public int compareTo(Search y) {
            return Integer.compare(this.priority, y.priority);
        }
    }
}
