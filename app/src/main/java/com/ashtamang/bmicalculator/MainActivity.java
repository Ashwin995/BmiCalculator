package com.ashtamang.bmicalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    Button btnCalculate;
    TextView tvOutput;
    EditText etMass, etHeight;
    float result;
    float n1,n2;
    String bmi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        etMass=(EditText)findViewById(R.id.etMass);
        etHeight=(EditText)findViewById(R.id.etHeight);
        tvOutput=(TextView)findViewById(R.id.tvOutput);
        btnCalculate=(Button)findViewById(R.id.btnCalculate);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Validation
                if(etMass.getText().toString().matches("") )
                {
                    etMass.setError("Enter weight");
                    return;
                }
                if(etHeight.getText().toString().matches("") )
                {
                    etHeight.setError("Enter Height");
                    return;
                }

                BmiCalculation();
            }

            public void BmiCalculation(){
                n1=Integer.parseInt(etMass.getText().toString());
                n2=Float.parseFloat(etHeight.getText().toString());
                result=n1/(n2*n2);
                if(result>=25 && result<29.9)
                    bmi="overweight";
                else if(result>=18.5 && result<24.9)
                    bmi="healthy / Normal Weight";
                else if(result>18.5)
                    bmi="Under Weight";


                tvOutput.setText("BMI=" + new DecimalFormat("##.##").format(result)+"\n"+bmi);

            }
        });
    }
}
