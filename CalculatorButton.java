package calculator.Buttons;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.Dimension;
import calculator.Situation;
import calculator.buttonActionListner;

public abstract class CalculatorButton extends JButton{
    Situation situation;
    public CalculatorButton(String label, Situation situation){
        //
        // Makes call to super constructor, creating a JButton instance,
        // add an instance of buttonActionListner to "this",
        // sets preferred button size and
        // sets font size and type of button text.
        //
        super(label);
        this.situation = situation;
        this.addActionListener(new buttonActionListner());
        this.setPreferredSize(new Dimension(150,150));
        this.setFont(new Font("Arial", Font.PLAIN, 80));
    }
    // 
    // Abstract method that should be implemented by inheritors of this class.
    //
    public abstract void transition();
}
