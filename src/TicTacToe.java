import java.awt.*;
import java.awt.event.*;
import javax.swing.*;




public class TicTacToe {
    //board dimentions, height +50 for title text
    int boardWidth = 600;
    int boardHeight = 650;

    JFrame frame = new JFrame("TIC TAC TOE"); //main window
    JLabel textLabel = new JLabel(); //game title text
    JPanel textPanel = new JPanel(); //panel for the text
    JPanel boardPanel = new JPanel(); //game board panel

    JButton[][] board = new JButton [3][3]; //game tiles as buttons
    String playerX = "X";
    String playerO = "O";
    String currentPlayer = playerX; //starting player


    TicTacToe() {

        //game window
        frame.setVisible(true);
        frame.setSize(boardWidth, boardHeight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        //title text formating
        textLabel.setBackground(Color.gray);
        textLabel.setForeground(Color.blue);
        textLabel.setFont(new Font("Arial", Font.BOLD, 50));
        textLabel.setHorizontalAlignment(JLabel.CENTER);
        textLabel.setText("TIC TAC TOE");
        textLabel.setOpaque(true);

        //panel formating
        textPanel.setLayout(new BorderLayout());
        textPanel.add(textLabel);
        frame.add(textPanel, BorderLayout.NORTH);
        
        //game board panel formating
        boardPanel.setLayout(new GridLayout(3,3));
        boardPanel.setBackground(Color.darkGray);
        frame.add(boardPanel);

        //game as 2dim array
        for(int r = 0; r<3; r++){
            for(int c = 0; c<3; c++){
                JButton tile = new JButton();
                board[r][c] = tile;
                boardPanel.add(tile);

                //tile properties
                tile.setBackground(Color.gray);
            }

        }

    }



}
