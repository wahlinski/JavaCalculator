package calculator.Buttons;

import calculator.Situation;

public class DigitButton extends CalculatorButton{
    private String label;
    private Situation situation;
    public DigitButton(String label, Situation situation){
        super(label, situation);
        this.label = label;
        this.situation = situation;
    }
    @Override
    public void transition() {
        switch (situation.getState()){
            case Input1:
                if (situation.getDisplay().getText().length() < 10){
                    if (situation.getDisplay().getText() == "0"){
                        situation.getDisplay().setText("");
                    }
                    situation.getDisplay().setText(situation.getDisplay().getText() + label);
                } 
                break;
            case OpReady:
            break;
            case Input2:
            break;
            case HasResult:
            break;
        }
    }
}
