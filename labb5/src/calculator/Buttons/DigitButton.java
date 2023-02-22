package calculator.Buttons;

import calculator.Situation;
import calculator.State;

public class DigitButton extends CalculatorButton{

    public DigitButton(String label, Situation situation){
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
            // Decides action based on current calculator state.
            //
            case Input1:
                if (situation.getDisplay().getText().length() < 10){
                    //
                    // Makes sure string length is small enough to fit valuewise in int variable type,
                    // adds button label ("number") to the end of the number in the display,
                    // if the only character in the display is a 0 it is replaced,
                    // thus preventing numbers from starting with a 0.
                    //
                    // Special case if this button is the o button, then display remains unchanged.
                    //
                    if (situation.getDisplay().getText().equals("0")){
                        situation.getDisplay().setText("");
                        if (this.getText() == "0"){
                            situation.getDisplay().setText("0");
                            break;
                        }
                    }
                    situation.getDisplay().setText(situation.getDisplay().getText() + this.getText());
                } 
                break;
            case OpReady:
                //
                // Changes state to "Input2" and
                // sets first character in the display to be the number represented by "this".
                //
                situation.setState(State.Input2);
                situation.getDisplay().setText(this.getText());
                break;
            case Input2:
                if (situation.getDisplay().getText().length() < 10){
                    //
                    // Makes sure string length is small enough to fit valuewise in int variable type,
                    // adds button label ("number") to the end of the number in the display,
                    // if the only character in the display is a 0 it is replaced,
                    // thus preventing numbers from starting with a 0.
                    //
                    // Special case if this button is the o button, then display remains unchanged.
                    //
                    if (situation.getDisplay().getText() == "0"){
                        situation.getDisplay().setText("");
                        if (this.getText() == "0"){
                            situation.getDisplay().setText("0");
                            break;
                        }
                    }
                    situation.getDisplay().setText(situation.getDisplay().getText() + this.getText());
                } 
                break;
            case HasResult:
                //
                // Changes state to "Input1" and
                // sets first character in the display to be the number represented by "this".
                //
                situation.setState(State.Input1);
                situation.getDisplay().setText(this.getText());
                break;
        }
    }
}
