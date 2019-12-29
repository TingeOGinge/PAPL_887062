package com.example.papl_887062;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Node04 extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_node04);
    ((DecisionStack) this.getApplication()).add(Node04.class);
  }

  public void onClickBack(View view) {
    Class previous = ((DecisionStack) this.getApplication()).getPrevious();
    try {
      Intent i = new Intent(Node04.this, previous);
      startActivity(i);
    } catch (Exception e) {
      System.err.println(e);
    }
  }
}