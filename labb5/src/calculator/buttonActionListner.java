package calculator;

import java.awt.event.*;
import calculator.Buttons.*;

public class buttonActionListner implements ActionListener{
    public void actionPerformed(ActionEvent e){
        //
        // Calls transition method in the CalculatorButton instance where the ActionEvent originated.
        //
       ((CalculatorButton)e.getSource()).transition(); 
    }
}
