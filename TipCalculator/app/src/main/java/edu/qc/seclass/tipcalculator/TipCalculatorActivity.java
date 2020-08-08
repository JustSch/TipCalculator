package edu.qc.seclass.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TipCalculatorActivity extends AppCompatActivity {
    private EditText checkAmountValue;
    private EditText partySizeValue;
    private Button buttonCompute;
    private EditText fifteenPercentTipValue;
    private EditText twentyPercentTipValue;
    private EditText twentyfivePercenTipValue;
    private EditText fifteenPercentTotalValue;
    private EditText twentyPercentTotalValue;
    private EditText twentyfivePercentTotalValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_calculator);

        checkAmountValue = findViewById(R.id.checkAmountValue);
        partySizeValue = findViewById(R.id.partySizeValue);
        buttonCompute = findViewById(R.id.buttonCompute);
        fifteenPercentTipValue = findViewById(R.id.fifteenPercentTipValue);
        twentyPercentTipValue = findViewById(R.id.twentyPercentTipValue);
        twentyfivePercenTipValue = findViewById(R.id.twentyfivePercentTipValue);
        fifteenPercentTotalValue = findViewById(R.id.fifteenPercentTotalValue);
        twentyPercentTotalValue = findViewById(R.id.twentyPercentTotalValue);
        twentyfivePercentTotalValue = findViewById(R.id.twentyfivePercentTotalValue);

        buttonCompute.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (validCheck(checkAmountValue,partySizeValue)){
                    calculateTip(checkAmountValue,partySizeValue,fifteenPercentTipValue,
                            fifteenPercentTotalValue,twentyfivePercenTipValue,twentyfivePercentTotalValue,
                            twentyPercentTipValue,twentyPercentTotalValue);
                }
                else {
                    Toast.makeText(v.getContext(),"Empty or incorrect value(s)!",Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    private void calculateTip(EditText checkAmountValue, EditText partySizeValue,
                              EditText fifteenPercentTipValue, EditText fifteenPercentTotalValue,
                              EditText twentyfivePercenTipValue, EditText twentyfivePercentTotalValue,
                              EditText twentyPercentTipValue, EditText twentyPercentTotalValue){

        int amountValue = Integer.parseInt(checkAmountValue.getText().toString());
        int partySize = Integer.parseInt(partySizeValue.getText().toString());

        double totalBeforeTip = amountValue/partySize;

        double fifteenPercentTip = totalBeforeTip * 0.15;
        double twentyPercentTip = totalBeforeTip * 0.20;
        double twentyfivePercentTip = totalBeforeTip * 0.25;

        fifteenPercentTipValue.setText(String.valueOf(Math.round(fifteenPercentTip)));
        twentyPercentTipValue.setText(String.valueOf(Math.round(twentyPercentTip)));
        twentyfivePercenTipValue.setText(String.valueOf(Math.round(twentyfivePercentTip)));

        fifteenPercentTotalValue.setText(String.valueOf(Math.round(totalBeforeTip+fifteenPercentTip)));
        twentyPercentTotalValue.setText(String.valueOf(Math.round(totalBeforeTip+twentyPercentTip)));
        twentyfivePercentTotalValue.setText(String.valueOf(Math.round(totalBeforeTip+twentyfivePercentTip)));

    }
    private Boolean validCheck(EditText checkAmountValue, EditText partySizeValue){
        String checkAmount = checkAmountValue.getText().toString();
        String partySize = partySizeValue.getText().toString();
        if (checkAmount.isEmpty() || partySize.isEmpty()) {
            return false;
        }
        try {
            Integer.parseInt(checkAmount);
        }
        catch(NumberFormatException e){
            return false;
        }

        try {
            Integer.parseInt(partySize);
        }
        catch(NumberFormatException e){
            return false;
        }

        return true;
    }
}
