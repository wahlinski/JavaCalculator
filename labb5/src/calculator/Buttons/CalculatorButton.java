package calculator.Buttons;

import javax.swing.JButton;

import calculator.Situation;
import calculator.buttonActionListner;

public abstract class CalculatorButton extends JButton{
    Situation situation;
    public CalculatorButton(String label, Situation situation){
        super(label);
        this.situation = situation;
        this.addActionListener(new buttonActionListner());
    }
    public abstract void transition();
}
