package com.example.papl_887062;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Node07 extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_node07);
    ((DecisionStack) this.getApplication()).add(Node07.class);
  }

  public void onClickBack(View view) {
    Class previous = ((DecisionStack) this.getApplication()).getPrevious(true);
    try {
      Intent node01ToMain = new Intent(Node07.this, previous);
      startActivity(node01ToMain);
    } catch (Exception e) {
      System.err.println(e);
    }
  }
}
