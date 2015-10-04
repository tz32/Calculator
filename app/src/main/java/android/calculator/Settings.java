package android.calculator;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;

import java.util.Random;

public class Settings extends Activity implements View.OnClickListener {

    View view;

    Button buttonbgcolor;
    Button buttonbuttoncolor;
    Button buttontextcolor;
    Button buttonback;

    Random rand = new Random();
    int bgred, bggreen, bgblue;
    int textred, textgreen, textblue;
    int buttonred, buttongreen, buttonblue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        view = this.getWindow().getDecorView();

        buttonbgcolor = (Button) findViewById(R.id.buttonbgcolor);
        buttonbgcolor.setOnClickListener(this);

        buttonbuttoncolor = (Button) findViewById(R.id.buttonbuttoncolor);
        buttonbuttoncolor.setOnClickListener(this);

        buttontextcolor = (Button) findViewById(R.id.buttontextcolor);
        buttontextcolor.setOnClickListener(this);

        buttonback = (Button) findViewById(R.id.buttonback);
        buttonback.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.buttonbgcolor:
                bgred = rand.nextInt();
                bggreen = rand.nextInt();
                bgblue = rand.nextInt();

                view.setBackgroundColor(Color.rgb(bgred, bggreen, bgblue));

                break;

            case R.id.buttonbuttoncolor:
                buttonred = rand.nextInt();
                buttongreen = rand.nextInt();
                buttonblue = rand.nextInt();

                buttonback.setBackgroundColor(Color.rgb(buttonred, buttongreen, buttonblue));
                buttonbgcolor.setBackgroundColor(Color.rgb(buttonred, buttongreen, buttonblue));
                buttonbuttoncolor.setBackgroundColor(Color.rgb(buttonred, buttongreen, buttonblue));
                buttontextcolor.setBackgroundColor(Color.rgb(buttonred, buttongreen, buttonblue));

                break;

            case R.id.buttontextcolor:
                textred = rand.nextInt();
                textgreen = rand.nextInt();
                textblue = rand.nextInt();

                buttonback.setTextColor(Color.rgb(textred, textgreen, textblue));
                buttonbgcolor.setTextColor(Color.rgb(textred, textgreen, textblue));
                buttonbuttoncolor.setTextColor(Color.rgb(textred, textgreen, textblue));
                buttontextcolor.setTextColor(Color.rgb(textred, textgreen, textblue));

                break;

            case R.id.buttonback:



                Intent intent = new Intent(Settings.this, MainActivity.class);
                intent.putExtra("bgred", bgred);
                intent.putExtra("bggreen", bggreen);
                intent.putExtra("bgblue", bgblue);
                intent.putExtra("buttonred", buttonred);
                intent.putExtra("buttongreen", buttongreen);
                intent.putExtra("buttonblue", buttonblue);
                intent.putExtra("textred", textred);
                intent.putExtra("textgreen", textgreen);
                intent.putExtra("textblue", textblue);

                startActivity(intent);
                break;

            default:
                break;

        }
    }
}
