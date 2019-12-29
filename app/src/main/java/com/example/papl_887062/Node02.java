package com.example.papl_887062;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Node02 extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_node02);
    ((DecisionStack) this.getApplication()).add(Node02.class);
  }

  public void onClickOption1(View view) {
    openOptionDialog(view, Node04.class);
  }

  public void openOptionDialog(View view, final Class destination) {
    AlertDialog.Builder builder = new AlertDialog.Builder(this);
    builder.setTitle("Option Description")
        .setMessage(view.getContentDescription())
        .setPositiveButton("Select", new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.cancel();
            Intent in = new Intent(Node02.this, destination);
            startActivity(in);
          }
        })
        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.cancel();
          }
        });
    builder.show();
  }

  public void onClickBack(View view) {
    Class previous = ((DecisionStack) this.getApplication()).getPrevious();
    try {
      Intent i = new Intent(Node02.this, previous);
      startActivity(i);
    } catch (Exception e) {
      System.err.println(e);
    }
  }
}
