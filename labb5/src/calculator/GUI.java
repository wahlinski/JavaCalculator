package calculator;
import javax.swing.BorderFactory;
import javax.swing.JButton;
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
import java.awt.Color;
import java.awt.Font;

public class GUI{
    private JFrame frame;
    private JPanel canvas;
    private JPanel keyPad;
    private JLabel display;
    private static Situation situation;
    private static final Insets insets = new Insets(0, 0, 0, 0);

    public GUI(){
        frame = new JFrame();
        canvas = createCanvas();
        display = createDisplay();
        situation = new Situation(display);
        keyPad = createKeyPad();
        GridBagConstraints displayGbc = new GridBagConstraints(0, 0, 1, 1, 0.2, 0.2,
        GridBagConstraints.CENTER, GridBagConstraints.BOTH, insets, 0, 0);
        GridBagConstraints keyPadGbc = new GridBagConstraints(0, 1, 1, 4, 0.8, 0.8,
        GridBagConstraints.CENTER, GridBagConstraints.BOTH, insets, 0, 0);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(canvas);
        canvas.add(display, displayGbc);
        canvas.add(keyPad, keyPadGbc);
        frame.setSize(600, 750);
        frame.setVisible(true);
    }
    private JPanel createCanvas(){
        canvas = new JPanel(new GridBagLayout());
        canvas.setSize(frame.getSize());
        return canvas;
    }
    private JLabel createDisplay(){
        display = new JLabel("0",SwingConstants.RIGHT);
        display.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        display.setFont(new Font("Arial", Font.PLAIN, 80));
        return display;
    }
    private JPanel createKeyPad(){
        keyPad = new JPanel(new GridLayout(4, 4));
        keyPad.add(new DigitButton("7", situation));
        keyPad.add(new DigitButton("8", situation));
        keyPad.add(new DigitButton("9", situation));
        keyPad.add(new BinOpButton("/", situation));
        keyPad.add(new DigitButton("4", situation));
        keyPad.add(new DigitButton("5", situation));
        keyPad.add(new DigitButton("6", situation));
        keyPad.add(new BinOpButton("/", situation));
        keyPad.add(new DigitButton("1", situation));
        keyPad.add(new DigitButton("2", situation));
        keyPad.add(new DigitButton("3", situation));
        keyPad.add(new BinOpButton("/", situation));
        keyPad.add(new DigitButton("0", situation));
        keyPad.add(new EqualsButton("=", situation));
        keyPad.add(new CancelButton("C", situation));
        keyPad.add(new BinOpButton("/", situation));
        return keyPad;
    }
}