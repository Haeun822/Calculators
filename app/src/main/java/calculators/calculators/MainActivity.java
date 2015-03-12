package calculators.calculators;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends Activity {

    String[] data = new String[2];
    char operator;

    int dataPointer = 0;

    TextView output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        data[0] = data[1] = "0";
        output = (TextView)findViewById(R.id.output);
    }

    public void calculate(float a, float b, char op){
        if(op == '/')
            output.setText(a/b + "");
        else if(op == '*')
            output.setText(a*b + "");
        else if(op == '-')
            output.setText(a-b + "");
        else if(op == '+')
            output.setText((a+b) + "");
        else if(op == '%')
            output.setText((a%b) + "");
    }

    public void operatorClicked(View v){
        int id = v.getId();

        if(id == R.id.reset){
            data[0] = data[1] = "0";
            dataPointer = 2;
            output.setText("0");
        }
        else if(id == R.id.result){
            if(dataPointer == 0){
                output.setText(data[0]);
                data[0] = "0";
            }
            else if(dataPointer != 2){
                float data1, data2;

                data1 = Float.parseFloat(data[0]);
                data2 = Float.parseFloat(data[1]);

                calculate(data1, data2, operator);

                data[0] = data[1] = "0";
                dataPointer = 2;
            }
        }
        else if(id == R.id.back){
            int dataLength = data[dataPointer].length();
            if(dataLength > 0)
                data[dataPointer] = data[dataPointer].substring(0, dataLength-1);
        }
        else{
            if(dataPointer == 2){
                data[0] = output.getText().toString();
            }
            else if(dataPointer == 1){
                float data1, data2;

                data1 = Float.parseFloat(data[0]);
                data2 = Float.parseFloat(data[1]);

                calculate(data1, data2, operator);

                data[0] = output.getText().toString();
                data[1] = "0";
            }

            if(id == R.id.division) operator = '/';
            else if(id == R.id.multiply) operator = '*';
            else if(id == R.id.minus) operator = '-';
            else if(id == R.id.plus) operator = '+';
            else if(id == R.id.modulus) operator = '%';

            dataPointer = 1;
        }
    }

    public void numberClicked(View v){
        if(dataPointer == 2) dataPointer = 0;
        switch (v.getId()){
            case R.id.doubleZero:
                data[dataPointer] += "00";
                break;
            case R.id.zero:
                data[dataPointer] += "0";
                break;
            case R.id.one:
                data[dataPointer] += "1";
                break;
            case R.id.two:
                data[dataPointer] += "2";
                break;
            case R.id.three:
                data[dataPointer] += "3";
                break;
            case R.id.four:
                data[dataPointer] += "4";
                break;
            case R.id.five:
                data[dataPointer] += "5";
                break;
            case R.id.six:
                data[dataPointer] += "6";
                break;
            case R.id.seven:
                data[dataPointer] += "7";
                break;
            case R.id.eight:
                data[dataPointer] += "8";
                break;
            case R.id.nine:
                data[dataPointer] += "9";
                break;
            case R.id.point:
                data[dataPointer] += ".";
                break;
        }
    }
}
