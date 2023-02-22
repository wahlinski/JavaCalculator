package calculator.Buttons;

import calculator.Situation;
import calculator.State;

public class CancelButton extends CalculatorButton{
    public CancelButton(String label, Situation situation){
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
        switch (situation.getState()){
            //
            // Overrides abstract method transition in parent class.
            //
            case Input1:
                //
                // Sets leftOperand to 0,
                // changes display string to "0",
                // resets binaryOperatorButton and
                // changes state to "Input1"
                //
                situation.setLeftOperand(0);
                situation.getDisplay().setText("0");
                situation.setBinaryOperatorButton(null);
                situation.setState(State.Input1);
                break;
            case OpReady:
                //
                // Sets leftOperand to 0,
                // changes display string to "0",
                // resets binaryOperatorButton and
                // changes state to "Input1"
                //
                situation.setLeftOperand(0);
                situation.getDisplay().setText("0");
                situation.setBinaryOperatorButton(null);
                situation.setState(State.Input1);
                break;
            case Input2:
                //
                // Sets leftOperand to 0,
                // changes display string to "0",
                // resets binaryOperatorButton and
                // changes state to "Input1"
                //
                situation.setLeftOperand(0);
                situation.getDisplay().setText("0");
                situation.setBinaryOperatorButton(null);
                situation.setState(State.Input1);
                break;
            case HasResult:
                //
                // Sets leftOperand to 0,
                // changes display string to "0",
                // resets binaryOperatorButton and
                // changes state to "Input1"
                //
                situation.setLeftOperand(0);
                situation.getDisplay().setText("0");
                situation.setBinaryOperatorButton(null);
                situation.setState(State.Input1);
                break;
        }
    }
}
