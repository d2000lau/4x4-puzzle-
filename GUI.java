
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;
import java.util.Stack;
import java.util.TimerTask;
import java.util.Timer;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class GUI  {
    private Board currentBoard;
    private JFrame frame;
    private JPanel panel;
    private JLabel label;
    private JLabel[][] grid;
    private Graphics2D graphics2D;
    private Container container;
    private Random random;
    private Timer timer;
    private List<Board> solutions;
    private int counterSolution;

    public GUI(Board board) {
        counterSolution = 0;
        solutions = new ArrayList<>();
        timer = new Timer();
        currentBoard = board;
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        container = frame.getContentPane();
        random = new Random();
        drawGrid();
    }

    public void drawGrid() {
        container.removeAll();
        panel = null;
        panel = new JPanel();
        grid = new JLabel[4][4];
        container.setLayout(new FlowLayout());
        JLabel title = new JLabel("<html><font color='white'>15 PUZZLE<br/> &nbsp GAME</font></html>", SwingConstants.CENTER);
        title.setFont(new Font("DialogInput", Font.BOLD, 20));
        title.setBorder(BorderFactory.createLineBorder(Color.white));
        container.add(title);
        panel.setLayout(new GridLayout(0,4));
        for(int i =0; i<4;i++){
            for(int j = 0; j<4; j++){
                grid[i][j] = new JLabel("" + currentBoard.getValue(i,j), 4);
                grid[i][j].setFont(new Font("DialogInput", Font.BOLD, 35));
                float r = random.nextFloat();
                float g = random.nextFloat();
                float b = random.nextFloat();
                Color randomColor = new Color(r, g, b);
                grid[i][j].setForeground(randomColor);
                grid[i][j].setBorder(BorderFactory.createLineBorder(Color.pink));
                panel.add(grid[i][j]);
            }
        }
        panel.setBorder(BorderFactory.createTitledBorder("Game of the year 2069 v.4.2.0"));
        ((javax.swing.border.TitledBorder)panel.getBorder()).setTitleColor(Color.pink);
        container.add(panel);
        JPanel controls = new JPanel();
        controls.setLayout(new GridLayout(3, 1));
        JButton reset = new JButton("Reset");
        reset.setBorder(BorderFactory.createLineBorder(Color.red));
        reset.setPreferredSize(new Dimension(60,20));
        JButton solveA = new JButton("A* ");
        solveA.setBorder(BorderFactory.createLineBorder(Color.red));
        solveA.setPreferredSize(new Dimension(60,20));
        solveA.addActionListener(new SolveListener("AStar"));
        JButton solveDijkstra = new JButton("Dijkstra");
        solveDijkstra.setBorder(BorderFactory.createLineBorder(Color.red));
        solveDijkstra.setPreferredSize(new Dimension(60,20));
        controls.add(reset);
        controls.add(solveA);
        controls.add(solveDijkstra);

        container.add(controls);
        frame.getContentPane().setBackground(Color.pink);
        frame.setTitle("15 Puzzle Game");
        frame.setSize(450,300);
        frame.setVisible(true);
    }

    private class SolveListener implements ActionListener
    {
        private String action;

        /**
         * Takes in a strign to define which type of search it will execute.
         * @param algorithm String "BF" for breadth first search, "DF" for depth first and any other for A*
         */
        private SolveListener(String algorithm)
        {
            this.action = algorithm;
        }

        public void actionPerformed(ActionEvent e){
            if (action == "AStar") {
                AStar solve = new AStar(currentBoard);
                solutions = solve.solution();
            }
            counterSolution = solutions.size();
            for(int i =0; i<solutions.size(); i++){
                timer.schedule(new theTask(), 2000*i, 2000);
            }
        }
    }

    private class theTask extends TimerTask
    {
        public void run() {
            if (counterSolution > 0) {
                counterSolution = counterSolution - 1;
                currentBoard = solutions.get(counterSolution);
                drawGrid();
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[4][4];
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
        System.out.println(matrix.length);
        Board board = new Board(matrix);
        new GUI(board);
    }
}
