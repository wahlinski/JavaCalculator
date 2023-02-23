package calculator;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import calculator.Buttons.BinOpButton;
import calculator.Buttons.CancelButton;
import calculator.Buttons.DigitButton;
import calculator.Buttons.EqualsButton;

import javax.swing.SwingConstants;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.function.IntBinaryOperator;
import java.awt.Color;
import java.awt.Font;

public class GUI{
    private JFrame frame;
    private JPanel canvas;
    private JPanel keyPad;
    private static Situation situation;
    private static final Insets insets = new Insets(0, 0, 0, 0);

    public GUI(){
        //
        // Creates the frame,
        // creates the contentPane of the frame (canvas),
        // creates the display element,
        // creates the keyPad (containing all GUI buttons the can be interacted with)
        // creates 2 GridBagConstraints,
        // sets defaultClosingOperation of the frame (and the program),
        // adds the display element and the keyPad to the frame contentPane (canvas),
        //  GridBagConstraints are used to specify layout,
        // sets size of the frame,
        // sets frame to be visible and
        // adjuts frame size to fit contained components.
        //
        frame = new JFrame();
        canvas = createCanvas();
        situation = new Situation(createDisplay());
        situation.getDisplay().setText(Integer.toString(situation.getLeftOperand()));
        keyPad = createKeyPad();
        GridBagConstraints displayGbc = new GridBagConstraints(0, 0, 1, 1, 0.10, 0.10,
        GridBagConstraints.CENTER, GridBagConstraints.BOTH, insets, 0, 0);
        GridBagConstraints keyPadGbc = new GridBagConstraints(0, 1, 1, 4, 0.90, 0.90,
        GridBagConstraints.CENTER, GridBagConstraints.BOTH, insets, 0, 0);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(canvas);
        canvas.add(situation.getDisplay(), displayGbc);
        canvas.add(keyPad, keyPadGbc);
        frame.setSize(600, 750);
        frame.setVisible(true);
        frame.pack();
    }
    private JPanel createCanvas(){
        //
        // Creates a new JPanel, specifying usage of the GridBagLayout,
        // sets JPanel size to container JFrame and
        // returns created canvas.
        //
        canvas = new JPanel(new GridBagLayout());
        canvas.setSize(frame.getSize());
        return canvas;
    }
    private JLabel createDisplay(){
        //
        // Creates new JLabel, with starting string that is the string representation of the leftOperand
        //  sets the text in the JLabel to be adjusted to the right,
        // create a border to the JLabel that is 2 pixels thick and black.
        // sets font size and type for the JLabel and
        // returns finished JLabel.
        //
        JLabel display = new JLabel("",SwingConstants.RIGHT);
        display.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        display.setFont(new Font("Arial", Font.PLAIN, 80));
        return display;
    }
    private JPanel createKeyPad(){
        //
        // Creates a JPanel with a 4x4 gridLayout,
        // adds the 16 calculatorButton to the JPanel in the correct order and
        // returns the finishied keyPad.
        //
        // binOpButtons receive their respective mathematical operations,
        //  these come in the form of IntBinaryOperator().
        //
        // New button should be added here if calculator is ever expanded.
        //
        keyPad = new JPanel(new GridLayout(4, 4));
        keyPad.add(new DigitButton("7", situation));
        keyPad.add(new DigitButton("8", situation));
        keyPad.add(new DigitButton("9", situation));

        keyPad.add(new BinOpButton("/", situation, 
        new IntBinaryOperator() { 
            @Override public int applyAsInt(int x, int y) { return x/y;} 
        }));

        keyPad.add(new DigitButton("4", situation));
        keyPad.add(new DigitButton("5", situation));
        keyPad.add(new DigitButton("6", situation));

        keyPad.add(new BinOpButton("*", situation, 
        new IntBinaryOperator() { 
            @Override public int applyAsInt(int x, int y) { return x*y;} 
        }));

        keyPad.add(new DigitButton("1", situation));
        keyPad.add(new DigitButton("2", situation));
        keyPad.add(new DigitButton("3", situation));

        keyPad.add(new BinOpButton("-", situation, 
        new IntBinaryOperator() { 
            @Override public int applyAsInt(int x, int y) { return x-y;} 
        }));

        keyPad.add(new DigitButton("0", situation));
        keyPad.add(new EqualsButton("=", situation));
        keyPad.add(new CancelButton("C", situation));

        keyPad.add(new BinOpButton("+", situation, 
        new IntBinaryOperator() { 
            @Override public int applyAsInt(int x, int y) { return x+y;} 
        }));

        return keyPad;
    }
}