package com.example.papl_887062;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Message15 extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_message15);
    TextView tailoredMessage = findViewById(R.id.textView);
    tailoredMessage.setText(InputCalculation.getMessage());
  }

  public void onClickMessage(View view) {
    Class destination = (InputCalculation.getExerciseFlag()) ? Message16.class : Message17.class;
    Intent myIntent = new Intent(Message15.this, destination);
    startActivity(myIntent);
  }

  public void onClickBack(View view) {
    Class previous = ((DecisionStack) this.getApplication()).getPrevious(false);
    try {
      Intent i = new Intent(Message15.this, previous);
      startActivity(i);
    } catch (Exception e) {
      System.err.println(e);
    }
  }
}
