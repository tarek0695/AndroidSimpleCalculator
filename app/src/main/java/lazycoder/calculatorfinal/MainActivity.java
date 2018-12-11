package lazycoder.calculatorfinal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //Declaring variable
    Button btnClear;
    TextView tvProcessor, tvResult;
    Button btnOne, btnTwo, btnThree, btnFour, btnFive, btnSix, btnSeven, btnEight, btnNine, btnZero;
    String processor;
    boolean isSmallBracket = false;
    Button btnMultiply, btnMinus, btnPlus, btnDivide, btnDecimal, btnBack, btnSmallBracket, btnEqual, btnParcentage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Assinging variable
        btnClear = findViewById(R.id.btn_delete);
        tvProcessor = findViewById(R.id.tv_process);
        tvResult = findViewById(R.id.tv_result);

        tvProcessor.setText("");
        tvResult.setText("");


        //Assinging variable
        btnOne = findViewById(R.id.btn1);
        btnTwo = findViewById(R.id.btn2);
        btnThree = findViewById(R.id.btn3);
        btnFour = findViewById(R.id.btn4);
        btnFive = findViewById(R.id.btn5);
        btnSix = findViewById(R.id.btn6);
        btnSeven = findViewById(R.id.btn7);
        btnEight = findViewById(R.id.btn8);
        btnNine = findViewById(R.id.btn9);
        btnZero = findViewById(R.id.btn0);

        btnPlus = findViewById(R.id.btn_plus);
        btnMinus = findViewById(R.id.btn_minus);
        btnMultiply = findViewById(R.id.btn_multiply);
        btnDivide = findViewById(R.id.btn_divide);

        btnDecimal = findViewById(R.id.btn_decimal);
        btnBack = findViewById(R.id.btn_back);

        btnSmallBracket = findViewById(R.id.btn_small_bracket);
        btnParcentage = findViewById(R.id.btn_parcentage);

        btnEqual = findViewById(R.id.btn_equal);

        // calling onClick() method
        btnClear.setOnClickListener(this);
        btnOne.setOnClickListener(this);
        btnTwo.setOnClickListener(this);
        btnThree.setOnClickListener(this);
        btnFour.setOnClickListener(this);
        btnFive.setOnClickListener(this);
        btnSix.setOnClickListener(this);
        btnSeven.setOnClickListener(this);
        btnEight.setOnClickListener(this);
        btnNine.setOnClickListener(this);
        btnZero.setOnClickListener(this);

        btnPlus.setOnClickListener(this);
        btnMinus.setOnClickListener(this);
        btnMultiply.setOnClickListener(this);
        btnDivide.setOnClickListener(this);

        btnDecimal.setOnClickListener(this);
        btnBack.setOnClickListener(this);
        btnSmallBracket.setOnClickListener(this);
        btnParcentage.setOnClickListener(this);

        btnEqual.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.btn_delete:
                // do your code
                tvProcessor.setText("");
                tvResult.setText("");
                break;

            case R.id.btn1:
                processor = tvProcessor.getText().toString();
                tvProcessor.setText(processor + "1");
                break;

            case R.id.btn2:
                processor = tvProcessor.getText().toString();
                tvProcessor.setText(processor + "2");
                break;

            case R.id.btn3:
                processor = tvProcessor.getText().toString();
                tvProcessor.setText(processor + "3");
                break;


            case R.id.btn4:
                processor = tvProcessor.getText().toString();
                tvProcessor.setText(processor + "4");
                break;


            case R.id.btn5:
                processor = tvProcessor.getText().toString();
                tvProcessor.setText(processor + "5");
                break;


            case R.id.btn6:
                processor = tvProcessor.getText().toString();
                tvProcessor.setText(processor + "6");
                break;


            case R.id.btn7:
                processor = tvProcessor.getText().toString();
                tvProcessor.setText(processor + "7");
                break;


            case R.id.btn8:
                processor = tvProcessor.getText().toString();
                tvProcessor.setText(processor + "8");
                break;


            case R.id.btn9:
                processor = tvProcessor.getText().toString();
                tvProcessor.setText(processor + "9");
                break;


            case R.id.btn0:
                processor = tvProcessor.getText().toString();
                tvProcessor.setText(processor + "0");
                break;

            case R.id.btn_plus:
                processor = tvProcessor.getText().toString();
                tvProcessor.setText(processor + "+");
                break;

            case R.id.btn_minus:
                processor = tvProcessor.getText().toString();
                tvProcessor.setText(processor + "-");
                break;

            case R.id.btn_multiply:
                processor = tvProcessor.getText().toString();
                tvProcessor.setText(processor + "*");
                break;

            case R.id.btn_divide:
                processor = tvProcessor.getText().toString();
                tvProcessor.setText(processor + "/");
                break;

            case R.id.btn_decimal:
                processor = tvProcessor.getText().toString();
                tvProcessor.setText(processor + ".");
                break;

            case R.id.btn_parcentage:
                processor = tvProcessor.getText().toString();
                tvProcessor.setText(processor + "%");
                break;

            case R.id.btn_back:
                processor = tvProcessor.getText().toString();
                if(processor.length()>0){
                    processor = processor.substring(0,processor.length()-1);
                    tvProcessor.setText(processor);
                }
                break;

            case R.id.btn_small_bracket:
                if (isSmallBracket){
                    processor = tvProcessor.getText().toString();
                    tvProcessor.setText(processor + ")");
                    isSmallBracket = false;
                }  else {
                    processor = tvProcessor.getText().toString();
                    tvProcessor.setText(processor + "(");
                    isSmallBracket = true;
                }
                break;

            case R.id.btn_equal:
                processor = tvProcessor.getText().toString();
                processor = processor.replaceAll("X", "*");
                processor = processor.replaceAll("%", "/100");

                Context rhino = Context.enter();
                rhino.setOptimizationLevel(-1);
                String result = "";

                try{
                    Scriptable scope = rhino.initStandardObjects();
                    result = rhino.evaluateString(scope, processor, "JavaScript", 1, null).toString();
                }catch (Exception e){
                    result = "Error";
                }
                tvResult.setText(result);
                break;
        }
    }
}
