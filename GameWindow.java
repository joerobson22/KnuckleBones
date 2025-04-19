
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.*;
import javax.swing.*;

public class GameWindow extends JFrame implements ActionListener {

    JButton[] gridButtons;
    JButton rollButton;

    JPanel mainPanel;
    JPanel gridPanel1;
    JPanel gridPanel2;
    JPanel rollPanel;

    JButton dice;

    int width = 500;
    int height = 700;

    int x;
    int y;

    //constructor
    public GameWindow(int x, int y) {
        this.x = x;
        this.y = y;

        //setup panels
        //init the central roll panel
        initRollPanel();

        //init the two grid panels with 3x3 JButton grids
        gridButtons = new JButton[x * y * 2];
        gridPanel1 = initGridPanel(gridPanel1, 0);
        gridPanel2 = initGridPanel(gridPanel2, x * y);

        initMainPanel();

        initSelf();
    }

    public void initRollPanel() {
        //roll panel: where you roll the dice
        rollPanel = new JPanel(new GridLayout(6, 5));
        for (int i = 0; i < 14; i++) {
            rollPanel.add(new Label());
        }

        rollButton = new JButton("Roll!");
        rollPanel.add(rollButton);

        //rollPanel.add(new Label());
        dice = new JButton();
        rollPanel.add(dice);

        for (int i = 0; i < 20; i++) {
            rollPanel.add(new Label());
        }
    }

    public JPanel initGridPanel(JPanel gridPanel, int p) {
        gridPanel = new JPanel(new GridLayout(x, y));

        for (int i = 0; i < x * y; i++) {
            JButton b = new JButton();
            b.addActionListener(this);

            gridButtons[p++] = b;

            gridPanel.add(b);
        }
        return gridPanel;
    }

    public void initMainPanel() {
        mainPanel = new JPanel(new GridLayout(3, 1));
        mainPanel.add(gridPanel1);
        mainPanel.add(rollPanel);
        mainPanel.add(gridPanel2);
    }

    public void initSelf() {
        //set main content pain
        this.setContentPane(mainPanel);
        //set size, visibility, title and close operation
        this.setSize(width, height);
        this.setVisible(true);
        this.setTitle("KNUCKLEBONES");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
    }

    public void roll() {

    }

    public void addDice(int i) {

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == rollButton) {
            roll();
        } else {
            for (int i = 0; i < x * y; i++) {
                if (e.getSource() == gridButtons[i]) {
                    //put dice here
                    addDice(i);
                }
            }
        }
    }
}
