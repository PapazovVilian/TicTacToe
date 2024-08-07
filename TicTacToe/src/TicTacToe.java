import java.awt.*;
import java.awt.event.*;
import javax.swing.*;




public class TicTacToe {
    //board dimentions, height +50 for title text
    int boardWidth = 600;
    int boardHeight = 650;

    JFrame frame = new JFrame();

    TicTacToe() {
        frame.setVisible(true);
        frame.setSize(boardWidth, boardHeight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());


    }



}
