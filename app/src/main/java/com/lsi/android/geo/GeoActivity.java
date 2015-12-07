package com.lsi.android.geo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class GeoActivity extends AppCompatActivity {
    private Button btnTrue;
    private Button btnFalse;
    private ImageButton btnNext;
    private ImageButton btnPrevious;
    private TextView txtQuestion;
    private int currentIndex=0;

    private Question[] questions={
         new Question(R.string.question_guayaquil,true),
         new Question(R.string.question_capital,false),
         new Question(R.string.question_manta,true),
         new Question(R.string.question_volcan,false),
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geo);

        btnTrue = (Button) findViewById(R.id.btnTrue);
        btnTrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(GeoActivity.this, R.string.incorrect_toast, Toast.LENGTH_LONG).show();

            }
        });
        btnFalse = (Button) findViewById(R.id.btnFalse);
        btnFalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(GeoActivity.this, R.string.correct_toast, Toast.LENGTH_LONG).show();
            }
        });
        btnNext = (ImageButton) findViewById(R.id.next_button);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(GeoActivity.this, R.string.next_button, Toast.LENGTH_LONG).show();
                updateQuestion();
            }
        });
        btnPrevious = (ImageButton) findViewById(R.id.previous_button);
        btnPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(GeoActivity.this, R.string.next_button, Toast.LENGTH_LONG).show();
                updateQuestion();
            }
        });
        txtQuestion = (TextView) findViewById(R.id.textQuestion);
        updateQuestion();
     }

    private void  updateQuestion(){
        int question=questions[currentIndex].getQuestionId();
        txtQuestion.setText(question);
    }
    private void  checkAnswer(boolean press){
        boolean isTrue=questions[currentIndex].isTrue();
        int messageId=0;
        if (press==isTrue){
            messageId=R.string.correct_toast;
        }else{
            messageId=R.string.incorrect_toast;
        }
        Toast.makeText(this,messageId,Toast.LENGTH_SHORT).show();
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_geo, menu);
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
}
