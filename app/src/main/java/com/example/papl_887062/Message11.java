package com.example.papl_887062;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Message11 extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_message11);
  }

  public void onClickMessage(View view) {
    InputCalculation.setMessage(getResources().getString(R.string.message11_TMessage));
    InputCalculation.recommendBasicWorkouts();
    Intent myIntent = new Intent(Message11.this, ExerciseThen.class);
    startActivity(myIntent);
  }

  public void onClickBack(View view) {
    Class previous = ((DecisionStack) this.getApplication()).getPrevious(false);
    try {
      Intent i = new Intent(Message11.this, previous);
      startActivity(i);
    } catch (Exception e) {
      System.err.println(e);
    }
  }
}
