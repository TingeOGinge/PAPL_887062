package com.example.papl_887062;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ExerciseThen extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_exercise_then);
    ((DecisionStack) this.getApplication()).add(ExerciseThen.class);
  }

  public void onClickMessage(View view) {
    Intent myIntent = new Intent(ExerciseThen.this, Message15.class);
    startActivity(myIntent);
  }

  public void onClickBack(View view) {
    Class previous = ((DecisionStack) this.getApplication()).getPrevious(true);
    try {
      Intent node01ToMain = new Intent(ExerciseThen.this, previous);
      startActivity(node01ToMain);
    } catch (Exception e) {
      System.err.println(e);
    }
  }
}
