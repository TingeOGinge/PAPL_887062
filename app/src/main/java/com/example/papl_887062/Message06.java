package com.example.papl_887062;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;

public class Message06 extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_message06);
  }

  public void onClickMessage(View view) {
    InputCalculation.setMessage(getResources().getString(R.string.message06_TMessage));
    Resources resources = getResources();
    InputCalculation.addNhsLink(resources.getString(R.string.unwellUrl1), resources.getString(R.string.unwellMessage1));
    InputCalculation.addNhsLink(resources.getString(R.string.unwellUrl2), resources.getString(R.string.unwellMessage2));
    Intent myIntent = new Intent(Message06.this, DontExercise.class);
    startActivity(myIntent);
  }

  public void onClickBack(View view) {
    Class previous = ((DecisionStack) this.getApplication()).getPrevious(false);
    try {
      Intent i = new Intent(Message06.this, previous);
      startActivity(i);
    } catch (Exception e) {
      System.err.println(e);
    }
  }
}
