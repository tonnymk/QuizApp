package com.example.android.quizapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.android.quizapp.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    /**
     * Evaluates the answers provided and gives a score. The result is passes to ResultActivity for display
     * @param view - current view
     */
    public void evaluateQuiz(View view) {
        RadioGroup qn1RadioGroup = findViewById(R.id.q1_radio_group);
        RadioGroup qn2RadioGroup = findViewById(R.id.q2_radio_group);
        RadioGroup qn3RadioGroup = findViewById(R.id.q3_radio_group);
        RadioGroup qn4RadioGroup = findViewById(R.id.q4_radio_group);
        RadioGroup qn5RadioGroup = findViewById(R.id.q5_radio_group);
        RadioGroup qn6RadioGroup = findViewById(R.id.q6_radio_group);
        RadioGroup qn7RadioGroup = findViewById(R.id.q7_radio_group);
        RadioGroup qn8RadioGroup = findViewById(R.id.q8_radio_group);

        CheckBox diabetesCheckBox = findViewById(R.id.diabetes_check);
        CheckBox heartDxCheckBox = findViewById(R.id.hdx_check);
        CheckBox htnCheckBox = findViewById(R.id.htn_check);
        CheckBox strokeCheckBox = findViewById(R.id.stroke_check);
        CheckBox osteoporosisCheckBox = findViewById(R.id.osteoporosis_check);


        if(!allQuestionsAreFilled()){
            return;
        }

        int score = 0;

        //Score question 1
        if (((RadioButton)findViewById(qn1RadioGroup.getCheckedRadioButtonId())).getText().toString().equals(getString(R.string.choice_once_a_day))){
            score += 1;
        }else if (((RadioButton)findViewById(qn1RadioGroup.getCheckedRadioButtonId())).getText().toString().equals(getString(R.string.choice_more_than_once_a_day))){
            score += 0;
        }else if (((RadioButton)findViewById(qn1RadioGroup.getCheckedRadioButtonId())).getText().toString().equals(getString(R.string.choice_rarely))){
            score += 3;
        }else if (((RadioButton)findViewById(qn1RadioGroup.getCheckedRadioButtonId())).getText().toString().equals(getString(R.string.choice_never))){
            score += 5;
        }


        //Score question 2
        if (((RadioButton)findViewById(qn2RadioGroup.getCheckedRadioButtonId())).getText().toString().equals(getString(R.string.choice_once_a_day))){
            score += 0;
        }else if (((RadioButton)findViewById(qn2RadioGroup.getCheckedRadioButtonId())).getText().toString().equals(getString(R.string.choice_more_than_once_a_day))){
            score += 0;
        }else if (((RadioButton)findViewById(qn2RadioGroup.getCheckedRadioButtonId())).getText().toString().equals(getString(R.string.choice_rarely))){
            score += 3;
        }else if (((RadioButton)findViewById(qn2RadioGroup.getCheckedRadioButtonId())).getText().toString().equals(getString(R.string.choice_never))){
            score += 5;
        }


        //Score question 3
        if (((RadioButton)findViewById(qn3RadioGroup.getCheckedRadioButtonId())).getText().toString().equals(getString(R.string.choice_once_a_year))){
            score += 1;
        }else if (((RadioButton)findViewById(qn3RadioGroup.getCheckedRadioButtonId())).getText().toString().equals(getString(R.string.choice_more_than_once_a_year))){
            score += 0;
        }else if (((RadioButton)findViewById(qn3RadioGroup.getCheckedRadioButtonId())).getText().toString().equals(getString(R.string.choice_rarely))){
            score += 3;
        }else if (((RadioButton)findViewById(qn3RadioGroup.getCheckedRadioButtonId())).getText().toString().equals(getString(R.string.choice_never))){
            score += 5;
        }


        //Score question 4
        if (((RadioButton)findViewById(qn4RadioGroup.getCheckedRadioButtonId())).getText().toString().equals(getString(R.string.choice_yes))){
            score += 5;
        }else if (((RadioButton)findViewById(qn4RadioGroup.getCheckedRadioButtonId())).getText().toString().equals(getString(R.string.choice_no))){
            score += 0;
        }else if (((RadioButton)findViewById(qn4RadioGroup.getCheckedRadioButtonId())).getText().toString().equals(getString(R.string.choice_sometimes))){
            score += 2;
        }


        //Score question 5
        if (((RadioButton)findViewById(qn5RadioGroup.getCheckedRadioButtonId())).getText().toString().equals(getString(R.string.choice_yes))){
            score += 5;
        }else if (((RadioButton)findViewById(qn5RadioGroup.getCheckedRadioButtonId())).getText().toString().equals(getString(R.string.choice_no))){
            score += 0;
        }else if (((RadioButton)findViewById(qn5RadioGroup.getCheckedRadioButtonId())).getText().toString().equals(getString(R.string.choice_not_sure))){
            score += 2;
        }

        //Score question 6
        if (((RadioButton)findViewById(qn6RadioGroup.getCheckedRadioButtonId())).getText().toString().equals(getString(R.string.choice_yes))){
            score += 5;
        }else if (((RadioButton)findViewById(qn6RadioGroup.getCheckedRadioButtonId())).getText().toString().equals(getString(R.string.choice_no))){
            score += 0;
        }else if (((RadioButton)findViewById(qn6RadioGroup.getCheckedRadioButtonId())).getText().toString().equals(getString(R.string.choice_not_sure))){
            score += 2;
        }


        //Score question 7
        if (((RadioButton)findViewById(qn7RadioGroup.getCheckedRadioButtonId())).getText().toString().equals(getString(R.string.choice_yes))){
            score += 3;
        }else if (((RadioButton)findViewById(qn7RadioGroup.getCheckedRadioButtonId())).getText().toString().equals(getString(R.string.choice_no))){
            score += 0;
        }else if (((RadioButton)findViewById(qn7RadioGroup.getCheckedRadioButtonId())).getText().toString().equals(getString(R.string.choice_not_sure))){
            score += 1;
        }


        //Score question 8
        if (((RadioButton)findViewById(qn8RadioGroup.getCheckedRadioButtonId())).getText().toString().equals(getString(R.string.choice_yes))){
            score += 5;
        }else if (((RadioButton)findViewById(qn8RadioGroup.getCheckedRadioButtonId())).getText().toString().equals(getString(R.string.choice_no))){
            score += 0;
        }else if (((RadioButton)findViewById(qn8RadioGroup.getCheckedRadioButtonId())).getText().toString().equals(getString(R.string.choice_not_any_more))){
            score += 2;
        }


        //Score question 9
        if (diabetesCheckBox.isChecked()){
            score += 2;
        }
        if (heartDxCheckBox.isChecked()){
            score += 2;
        }
        if (htnCheckBox.isChecked()){
            score += 2;
        }
        if (strokeCheckBox.isChecked()){
            score += 2;
        }
        if (osteoporosisCheckBox.isChecked()){
            score += 2;
        }


        RadioGroup genderRadioGroup = findViewById(R.id.gender_radio_group);
        TextView nameTextView = findViewById(R.id.full_name_textview);
        TextView ageTextView = findViewById(R.id.age_textview);

        RadioButton genderButton = findViewById(genderRadioGroup.getCheckedRadioButtonId());


        Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
        intent.putExtra(MyExtras.SCORE.name(), score);
        intent.putExtra(MyExtras.FULL_NAME.name(), nameTextView.getText().toString());
        intent.putExtra(MyExtras.AGE.name(), ageTextView.getText().toString());
        intent.putExtra(MyExtras.GENDER.name(), genderButton.getText().toString());
        startActivity(intent);


    }


    /**
     * Checks whether all the questions and other required fields are properly filled
     * @return true if all questions are filled or display appropriate alert and false
     */
    private boolean allQuestionsAreFilled(){
        RadioGroup qn1RadioGroup = findViewById(R.id.q1_radio_group);
        RadioGroup qn2RadioGroup = findViewById(R.id.q2_radio_group);
        RadioGroup qn3RadioGroup = findViewById(R.id.q3_radio_group);
        RadioGroup qn4RadioGroup = findViewById(R.id.q4_radio_group);
        RadioGroup qn5RadioGroup = findViewById(R.id.q5_radio_group);
        RadioGroup qn6RadioGroup = findViewById(R.id.q6_radio_group);
        RadioGroup qn7RadioGroup = findViewById(R.id.q7_radio_group);
        RadioGroup qn8RadioGroup = findViewById(R.id.q8_radio_group);

        RadioGroup genderRadioGroup = findViewById(R.id.gender_radio_group);
        TextView nameTextView = findViewById(R.id.full_name_textview);
        TextView ageTextView = findViewById(R.id.age_textview);



        if (qn1RadioGroup.getCheckedRadioButtonId()==-1){
            showAlert("Alert", getString(R.string.alert_message, 1));
            return false;
        }

        if (qn2RadioGroup.getCheckedRadioButtonId()==-1){
            showAlert("Alert", getString(R.string.alert_message, 2));
            return false;
        }


        if (qn3RadioGroup.getCheckedRadioButtonId()==-1){
            showAlert("Alert", getString(R.string.alert_message, 3));
            return false;
        }


        if (qn4RadioGroup.getCheckedRadioButtonId()==-1){
            showAlert("Alert", getString(R.string.alert_message, 4));
            return false;
        }

        if (qn5RadioGroup.getCheckedRadioButtonId()==-1){
            showAlert("Alert", getString(R.string.alert_message, 5));
            return false;
        }

        if (qn6RadioGroup.getCheckedRadioButtonId()==-1){
            showAlert("Alert", getString(R.string.alert_message, 6));
            return false;
        }

        if (qn7RadioGroup.getCheckedRadioButtonId()==-1){
            showAlert("Alert", getString(R.string.alert_message, 7));
            return false;
        }

        if (qn8RadioGroup.getCheckedRadioButtonId()==-1){
            showAlert("Alert", getString(R.string.alert_message, 8));
            return false;
        }

        if (nameTextView.getText().toString().trim().isEmpty()){
            showAlert("Alert", getString(R.string.no_name_message));
            return false;
        }

        if (ageTextView.getText().toString().trim().isEmpty()){
            showAlert("Alert", getString(R.string.no_age_message));
            return false;
        }

        if (genderRadioGroup.getCheckedRadioButtonId()==-1){
            showAlert("Alert", getString(R.string.no_gender_message));
            return false;
        }

        return true;
    }


    /**
     * Displays an alert
     * @param title - Title of the alert
     * @param message - Contents of the alert
     */
    private void showAlert(String title, String message){

        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(this, android.R.style.Theme_Material_Dialog_Alert);
        } else {
            builder = new AlertDialog.Builder(this);
        }
        builder.setTitle(title)
                .setMessage(message)
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // continue with delete
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }
}
