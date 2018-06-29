package com.example.android.quizapp;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);



        int score = getIntent().getIntExtra(MyExtras.SCORE.name(), -1);
        String fullName = getIntent().getStringExtra(MyExtras.FULL_NAME.name());
        String age = getIntent().getStringExtra(MyExtras.AGE.name());
        String gender = getIntent().getStringExtra(MyExtras.GENDER.name());




        TextView nameTextView = (TextView)findViewById(R.id.result_name_textview);
        TextView ageGenderTextView = (TextView)findViewById(R.id.result_age_gender_textview);
        TextView resultTextView = (TextView)findViewById(R.id.result_textview);
        TextView commentTextView = (TextView)findViewById(R.id.result_comment_textview);
        ImageView icon = (ImageView) findViewById(R.id.result_icon);

        nameTextView.setText(fullName);
        ageGenderTextView.setText(String.format("%s Years - %s", age, gender));


        if (score<5){
            resultTextView.setText("LOW RISK");
            commentTextView.setText("Keep it up!!!");
            icon.setImageResource(R.drawable.low_risk);
        }else if (score<10){
            resultTextView.setText("MODERATE RISK");
            commentTextView.setText("Please visit a dentist ASAP!!!");
            icon.setImageResource(R.drawable.moderate_risk);
        }else {
            resultTextView.setText("HIGH RISK");
            commentTextView.setText("Please visit a dentist ASAP!!!");
            icon.setImageResource(R.drawable.high_risk);
        }


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /**
     * Closes the result activity and resets the quiz
     * @param view
     */
    public void startNewQuiz(View view) {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }
}
