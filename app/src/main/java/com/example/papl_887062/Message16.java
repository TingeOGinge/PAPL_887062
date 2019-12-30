package com.example.papl_887062;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class Message16 extends AppCompatActivity {
  private TextView workoutTV;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_message16);
    ((DecisionStack) this.getApplication()).add(Message16.class);
    workoutTV = findViewById(R.id.textView);
    workoutTV.setText(InputCalculation.getRecommendation());
  }

  public void onClickAccept(View view) {
    Intent i = new Intent(Message16.this, AcceptWorkout.class);
    startActivity(i);
  }

  public void getNextRecommendation(View view) {
    String tvContent = InputCalculation.getRecommendation();
    if (tvContent != null) {
      workoutTV.setText(tvContent);
    } else {
      workoutTV.setText(R.string.noRecommendations);
      Button acceptButton = findViewById(R.id.button);
      acceptButton.setEnabled(false);
      Button rejectButton = findViewById(R.id.button2);
      rejectButton.setText(R.string.finishButton);
      rejectButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
          Intent myIntent = new Intent(Message16.this, MainActivity.class);
          startActivity(myIntent);
        }
      });
    }
  }

  public void onClickBack(View view) {
    Class previous = ((DecisionStack) this.getApplication()).getPrevious(false);
    try {
      Intent i = new Intent(Message16.this, previous);
      startActivity(i);
    } catch (Exception e) {
      System.err.println(e);
    }
  }
}
