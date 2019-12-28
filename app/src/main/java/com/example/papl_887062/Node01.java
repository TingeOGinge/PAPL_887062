package com.example.papl_887062;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Node01 extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_node01);
  }

  public void onClickBack(View view) {
    Intent node01ToMain = new Intent(Node01.this, MainActivity.class);
    startActivity(node01ToMain);
  }
}
