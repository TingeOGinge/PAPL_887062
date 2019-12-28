package com.example.papl_887062;

import androidx.appcompat.app.AppCompatActivity;

import android.content.*;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
  }

  public void onClickHomepageText(View view) {
    Intent myIntent = new Intent(MainActivity.this, Node01.class);
    startActivity(myIntent);
  }
}
