package calculator.Buttons;

import java.awt.Color;
import java.util.function.IntBinaryOperator;
import calculator.Situation;
import calculator.State;

public class BinOpButton extends CalculatorButton{
    public BinOpButton(String label, Situation situation){
        //
        // Call to super constructor.
        // Super constructor sets preferred button size,
        // adds buttonActionListner to this button instance and
        // sets font type and size of button label.
        //
        super(label, situation);
    }
    @Override
    public void transition() {
        //
        // Overrides abstract method transition in parent class.
        //
        switch (situation.getState()){
            //
            // Decides action based on current calculator state.
            //
            case Input1:
                if(situation.getBinaryOperatorButton() != null){
                    // 
                    // If a binaryOperatorButton is already set in the situation instance
                    // said binaryOperatorButton is removed and the button is reset.
                    //
                    situation.getBinaryOperatorButton().resetButton();;
                    situation.setBinaryOperatorButton(null);
                }
                //
                // Moves calculator forward to "OpReady" state,
                // sets "this" as binaryOperatorButton in the situation instance,
                // "activates" "this" in GUI and
                // sets leftOperand to current int value of the string in the display window.
                //
                situation.setBinaryOperatorButton(this);
                situation.setState(State.OpReady);
                this.setBackground(Color.RED);
                this.setOpaque(true);
                situation.setLeftOperand(Integer.parseInt(situation.getDisplay().getText()));
                break;
            case OpReady:
                if(situation.getBinaryOperatorButton() != null && situation.getBinaryOperatorButton() != this){
                    //
                    // Changes current set binaryOperatorButton to this if it's not,
                    // resets previously set button and
                    // "activates" "this" in GUI.
                    //
                    situation.getBinaryOperatorButton().resetButton();
                    situation.setBinaryOperatorButton(this);
                    this.setBackground(Color.RED);
                    this.setOpaque(true);
                    break;
                } else if (situation.getBinaryOperatorButton() == null){
                    //
                    // Sets binaryOperatorButton to this if no button is set,
                    // "activates" "this" in GUI.
                    //
                    this.setBackground(Color.RED);
                    this.setOpaque(true);
                    situation.setBinaryOperatorButton(this);
                    break;
                }
                else {
                    //
                    // Does nothing if "this" is already the set binaryOperatorButton.
                    //
                    break;
                }
            case Input2:
                if(situation.getBinaryOperatorButton() != this){
                    //
                    // Changes current binaryOperatorButton to "this" if it's not this already,
                    // resets previously set binaryOperatorButton and 
                    // "activates" this in GUI.
                    //
                    situation.getBinaryOperatorButton().resetButton();
                    situation.setBinaryOperatorButton(this);
                    this.setBackground(Color.RED);
                    this.setOpaque(true);
                }
                break;
            case HasResult:
                if(situation.getBinaryOperatorButton() != null){
                    //
                    // Resets currently set binaryOperatorButton if there is one.
                    //
                    situation.getBinaryOperatorButton().resetButton();;
                    situation.setBinaryOperatorButton(null);
                }
                //
                // Sets binaryOperatorButton to this,
                // "activates" "this" in GUI,
                // changes state to OpReady and
                // sets leftOperand to current int value of String in display.
                //
                this.setBackground(Color.RED);
                this.setOpaque(true);
                situation.setBinaryOperatorButton(this);
                situation.setState(State.OpReady);
                situation.setLeftOperand(Integer.parseInt(situation.getDisplay().getText()));
                break;
        }
    }
    public IntBinaryOperator getBinaryOperator(){
        switch(this.getText()){
            case "+":
                //
                // Lambda statement to perform addition calculation
                //
                return (x, y) -> {return x + y;};
            case "-":
                //
                // Lambda statement to perform subtraction calculation
                //
                return (x, y) -> {return x - y;};
            case "*":
                //
                // Lambda statement to perform multiplication calculation
                //
                return (x, y) -> {return x * y;};
            case "/":
                //
                // Lambda statement to perform division calculation
                //
                return (x, y) -> {return x / y;};
            default:
                //
                // Should not happen, every button is one of the above.
                // If more button types are added expand this switch statement.
                //
                throw new RuntimeException();
        }
    }
    public void resetButton(){
        //
        // Resets this button back to its normal non "activated" state.
        //
        this.setBackground(null);
        this.setOpaque(false);
    }
}
