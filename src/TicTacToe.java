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


    boolean gameOver = false;

    int turns = 0;  //listen for tie


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
                tile.setBackground(Color.darkGray);
                tile.setForeground(Color.gray);
                tile.setFont(new Font("Arial", Font.BOLD, 120 ));
                tile.setFocusable(false);
                //tile.setText(currentPlayer);

                tile.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if(gameOver) {
                            return;
                        }

                        JButton tile = (JButton) e.getSource();
                        
                        if (tile.getText() == "") { //check if button is empty, only then be able to place text                           
                            tile.setText(currentPlayer);
                            turns++;    //increment for tie
                            checkWinner();
                            if (!gameOver) {
                                currentPlayer = currentPlayer == playerX ? playerO : playerX;
                                textLabel.setText(currentPlayer + "'s turn.");
                            }
                        }

                    }



                });
            }

        }

    }

    void checkWinner() {
        //horizontal
        for(int r = 0; r<3; r++) {
            if (board[r][0].getText() == "") {
                continue;
            }
            if(board[r][0].getText() == board[r][1].getText() && board[r][1].getText() == board[r][2].getText()) {
                for(int i=0; i<3; i++) {
                    setWinner(board[r][i]);
                }
                gameOver = true;
                return;
            }

        }
        //vertical
        for(int c=0;c<3;c++) {
            if(board[0][c].getText() == "") {
                continue;
            }
            if(board[0][c].getText() == board[1][c].getText() && board[1][c].getText() == board[2][c].getText()) {
                for(int i=0; i<3; i++) {
                    setWinner(board[i][c]);
                }
                gameOver = true;
                return;
            }
        }
        //diagonally

        if(board[0][0].getText() == board[1][1].getText() &&
            board[1][1].getText() == board[2][2].getText() &&
            board[0][0].getText() != "") {
            for(int i=0; i<3; i++) {
                setWinner(board[i][i]);
            }
            gameOver = true;
            return;
        }
        //anti-diagonally

        if(board[0][2].getText() == board[1][1].getText() &&
            board[1][1].getText() == board[2][0].getText() &&
            board[0][2].getText() != "") {
            setWinner(board[0][2]);
            setWinner(board[1][1]);
            setWinner(board[2][0]);
            
            gameOver = true;
            return;
        }

        if (turns == 9) {
            for (int r=0;r<3;r++) {
                for (int c=0;c<3;c++) {
                    setTie(board[r][c]);
                } 
            }
            gameOver = true;
        }
        
        
    }
    void setWinner(JButton tile) {
        tile.setForeground(Color.green);
        tile.setBackground(Color.gray);
        textLabel.setText(currentPlayer + " is the winner!");

    }
    
    void setTie (JButton tile) {
        tile.setForeground(Color.orange);
        tile.setBackground(Color.gray);
        textLabel.setText("Tie!");

    }

}
