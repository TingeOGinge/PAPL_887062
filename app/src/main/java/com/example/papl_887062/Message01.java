package com.example.papl_887062;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Message01 extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_message01);
  }

  public void onClickMessage(View view) {
    Intent myIntent = new Intent(Message01.this, Node02.class);
    startActivity(myIntent);
  }

  public void onClickBack(View view) {
    Class previous = ((DecisionStack) this.getApplication()).getPrevious();
    try {
      Intent i = new Intent(Message01.this, previous);
      startActivity(i);
    } catch (Exception e) {
      System.err.println(e);
    }
  }
}
