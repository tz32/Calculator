package android.calculator;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends Activity implements View.OnClickListener {

    View view;
    TextView answertext;
    Random rand;

    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    Button button9;
    Button button0;
    Button buttonminus;
    Button buttonplus;
    Button buttonequals;
    Button buttonclear;
    Button buttonbackspace;
    Button buttonplusminus;
    Button buttonmult;
    Button buttondivide;
    Button buttondecimal;
    Button buttonbuttoncolor;
    Button buttontextcolor;
    Button buttonreset;

    int red, green, blue;


    float value1 = 0;
    float value2 = 0;
    String currentoperator = "none";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        view = this.getWindow().getDecorView();

        rand = new Random();

        answertext = (TextView) findViewById(R.id.answertext);

        button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);

        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(this);

        button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(this);

        button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(this);

        button5 = (Button) findViewById(R.id.button5);
        button5.setOnClickListener(this);

        button6 = (Button) findViewById(R.id.button6);
        button6.setOnClickListener(this);

        button7 = (Button) findViewById(R.id.button7);
        button7.setOnClickListener(this);

        button8 = (Button) findViewById(R.id.button8);
        button8.setOnClickListener(this);

        button9 = (Button) findViewById(R.id.button9);
        button9.setOnClickListener(this);

        button0 = (Button) findViewById(R.id.button0);
        button0.setOnClickListener(this);

        buttonminus = (Button) findViewById(R.id.buttonminus);
        buttonminus.setOnClickListener(this);

        buttonplus = (Button) findViewById(R.id.buttonplus);
        buttonplus.setOnClickListener(this);

        buttonequals = (Button) findViewById(R.id.buttonequals);
        buttonequals.setOnClickListener(this);

        buttonclear = (Button) findViewById(R.id.buttonclear);
        buttonclear.setOnClickListener(this);

        buttonbackspace = (Button) findViewById(R.id.buttonbackspace);
        buttonbackspace.setOnClickListener(this);

        buttonplusminus = (Button) findViewById(R.id.buttonplusminus);
        buttonplusminus.setOnClickListener(this);

        buttonmult = (Button) findViewById(R.id.buttonmult);
        buttonmult.setOnClickListener(this);

        buttondivide = (Button) findViewById(R.id.buttondivide);
        buttondivide.setOnClickListener(this);

        buttondecimal = (Button) findViewById(R.id.buttondecimal);
        buttondecimal.setOnClickListener(this);

        buttonbuttoncolor = (Button) findViewById(R.id.buttonbuttoncolor);
        buttonbuttoncolor.setOnClickListener(this);

        buttontextcolor = (Button) findViewById(R.id.buttontextcolor);
        buttontextcolor.setOnClickListener(this);

        buttonreset = (Button) findViewById(R.id.buttonreset);
        buttonreset.setOnClickListener(this);

        setBackgroundColor(0, 0, 0);

        setTextColors(255, 255, 255);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.button1:
                answertext.append("1");
                break;

            case R.id.button2:
                answertext.append("2");
                break;

            case R.id.button3:
                answertext.append("3");
                break;

            case R.id.button4:
                answertext.append("4");
                break;

            case R.id.button5:
                answertext.append("5");
                break;

            case R.id.button6:
                answertext.append("6");
                break;

            case R.id.button7:
                answertext.append("7");
                break;

            case R.id.button8:
                answertext.append("8");
                break;

            case R.id.button9:
                answertext.append("9");
                break;

            case R.id.button0:
                answertext.append("0");
                break;

            case R.id.buttonminus:
                if ((answertext.getText().length() > 0) && (!(answertext.getText().toString().equals("."))) && (!(answertext.getText().toString().equals("-.")))){
                    if (currentoperator == "none") {
                        value1 = Float.parseFloat(answertext.getText().toString());
                        currentoperator = "-";
                        answertext.setText("");
                    } else {
                        value2 = Float.parseFloat(answertext.getText().toString());
                        performOperation();
                        currentoperator = "-";
                    }
                }
                break;

            case R.id.buttonplus:
                if ((answertext.getText().length() > 0) && (!(answertext.getText().toString().equals("."))) && (!(answertext.getText().toString().equals("-.")))){
                    if (currentoperator == "none") {
                        value1 = Float.parseFloat(answertext.getText().toString());
                        currentoperator = "+";
                        answertext.setText("");
                    } else {
                        value2 = Float.parseFloat(answertext.getText().toString());
                        performOperation();
                        currentoperator = "+";
                    }
                }
                break;

            case R.id.buttonequals:
                if ((answertext.getText().length() > 0) && (!(answertext.getText().toString().equals("."))) && (!(answertext.getText().toString().equals("-.")))){
                    if (currentoperator == "none") {
                        value1 = Float.parseFloat(answertext.getText().toString());
                        //currentoperator = "none";
                        //answertext.setText("");
                    } else {
                        value2 = Float.parseFloat(answertext.getText().toString());
                        performOperation();
                        currentoperator = "none";
                    }
                }
                break;

            case R.id.buttonclear:
                answertext.setText("");
                value1 = 0;
                value2 = 0;
                currentoperator = "none";
                break;

            case R.id.buttonbackspace:
                if (answertext.getText().length() > 0)
                    answertext.setText(answertext.getText().subSequence(0, answertext.length() - 1));
                break;


            case R.id.buttonplusminus:
                if (answertext.getText().length() > 0) {
                    if ((answertext.getText().charAt(0) != '-')) {
                        answertext.setText("-" + answertext.getText());
                    }
                    else {
                        answertext.setText(answertext.getText().subSequence(1, answertext.getText().length()));
                    }
                }
                break;

            case R.id.buttonmult:
                if ((answertext.getText().length() > 0) && (!(answertext.getText().toString().equals("."))) && (!(answertext.getText().toString().equals("-.")))){
                    if (currentoperator == "none") {
                        value1 = Float.parseFloat(answertext.getText().toString());
                        currentoperator = "*";
                        answertext.setText("");
                    } else {
                        value2 = Float.parseFloat(answertext.getText().toString());
                        performOperation();
                        currentoperator = "*";
                    }
                }
                break;

            case R.id.buttondivide:
                if ((answertext.getText().length() > 0) && (!(answertext.getText().toString().equals("."))) && (!(answertext.getText().toString().equals("-.")))){
                    if (currentoperator == "none") {
                        value1 = Float.parseFloat(answertext.getText().toString());
                        currentoperator = "/";
                        answertext.setText("");
                    } else {
                        value2 = Float.parseFloat(answertext.getText().toString());
                        performOperation();
                        currentoperator = "/";
                    }
                }
                break;

            case R.id.buttonbuttoncolor:
                red = rand.nextInt(255);
                green = rand.nextInt(255);
                blue = rand.nextInt(255);

                setBackgroundColor(red, green, blue);



                break;

            case R.id.buttontextcolor:
                red = rand.nextInt(255);
                green = rand.nextInt(255);
                blue = rand.nextInt(255);

                setTextColors(red, green, blue);
                break;

            case R.id.buttonreset:
                setBackgroundColor(0, 0, 0);
                setTextColors(255, 255, 255);
                break;

            case R.id.buttondecimal:
                if (!containsdecimal(answertext.getText()))
                    answertext.append(".");

                break;

            default:

                break;
        }
    }

    private void setTextColors(int red, int green, int blue) {
        answertext.setTextColor(Color.rgb(red, green, blue));

        button0.setTextColor(Color.rgb(red, green, blue));
        button1.setTextColor(Color.rgb(red, green, blue));
        button2.setTextColor(Color.rgb(red, green, blue));
        button3.setTextColor(Color.rgb(red, green, blue));
        button4.setTextColor(Color.rgb(red, green, blue));
        button5.setTextColor(Color.rgb(red, green, blue));
        button6.setTextColor(Color.rgb(red, green, blue));
        button7.setTextColor(Color.rgb(red, green, blue));
        button8.setTextColor(Color.rgb(red, green, blue));
        button9.setTextColor(Color.rgb(red, green, blue));
        button0.setTextColor(Color.rgb(red, green, blue));
        buttonbackspace.setTextColor(Color.rgb(red, green, blue));
        buttonclear.setTextColor(Color.rgb(red, green, blue));
        buttonplusminus.setTextColor(Color.rgb(red, green, blue));
        buttondivide.setTextColor(Color.rgb(red, green, blue));
        buttonmult.setTextColor(Color.rgb(red, green, blue));
        buttonminus.setTextColor(Color.rgb(red, green, blue));
        buttonplus.setTextColor(Color.rgb(red, green, blue));
        buttonequals.setTextColor(Color.rgb(red, green, blue));
        buttondecimal.setTextColor(Color.rgb(red, green, blue));
        buttonbuttoncolor.setTextColor(Color.rgb(red, green, blue));
        buttontextcolor.setTextColor(Color.rgb(red, green, blue));
        buttonreset.setTextColor(Color.rgb(red, green, blue));
    }

    private void setBackgroundColor(int red, int green, int blue) {
        view.setBackgroundColor(Color.rgb(red, green, blue));

        button0.setBackgroundColor(Color.rgb(red, green, blue));
        button1.setBackgroundColor(Color.rgb(red, green, blue));
        button2.setBackgroundColor(Color.rgb(red, green, blue));
        button3.setBackgroundColor(Color.rgb(red, green, blue));
        button4.setBackgroundColor(Color.rgb(red, green, blue));
        button5.setBackgroundColor(Color.rgb(red, green, blue));
        button6.setBackgroundColor(Color.rgb(red, green, blue));
        button7.setBackgroundColor(Color.rgb(red, green, blue));
        button8.setBackgroundColor(Color.rgb(red, green, blue));
        button9.setBackgroundColor(Color.rgb(red, green, blue));
        button0.setBackgroundColor(Color.rgb(red, green, blue));
        buttonbackspace.setBackgroundColor(Color.rgb(red, green, blue));
        buttonclear.setBackgroundColor(Color.rgb(red, green, blue));
        buttonplusminus.setBackgroundColor(Color.rgb(red, green, blue));
        buttondivide.setBackgroundColor(Color.rgb(red, green, blue));
        buttonmult.setBackgroundColor(Color.rgb(red, green, blue));
        buttonminus.setBackgroundColor(Color.rgb(red, green, blue));
        buttonplus.setBackgroundColor(Color.rgb(red, green, blue));
        buttonequals.setBackgroundColor(Color.rgb(red, green, blue));
        buttondecimal.setBackgroundColor(Color.rgb(red, green, blue));
        buttonbuttoncolor.setBackgroundColor(Color.rgb(red, green, blue));
        buttontextcolor.setBackgroundColor(Color.rgb(red, green, blue));
        buttonreset.setBackgroundColor(Color.rgb(red, green, blue));
    }

    private boolean containsdecimal(CharSequence text) {
        for (int i = 0; i < text.length(); i++)
        {
            if (text.charAt(i) == ('.'))
                return true;
        }
        return false;
    }

    private void performOperation() {
        switch (currentoperator)
        {
            case "+":
                value1 = value1 + value2;
                answertext.setText(Float.toString(value1));
                break;
            case "-":
                value1 = value1 - value2;
                answertext.setText(Float.toString(value1));
                break;
            case "/":
                value1 = value1 / value2;
                answertext.setText(Float.toString(value1));
                break;
            case "*":
                value1 = value1 * value2;
                answertext.setText(Float.toString(value1));
                break;

        }
    }
}
