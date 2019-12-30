package com.example.papl_887062;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.view.View;

public class Node04 extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_node04);
    ((DecisionStack) this.getApplication()).add(Node04.class);
  }

  public void onClickOption1(View view) {
    InputCalculation.setMessage(getResources().getString(R.string.node04_01_TMessage));
    openOptionDialog(view, ExerciseThen.class);
  }

  public void onClickOption2(View view) {
    InputCalculation.setMessage(
        "Being unwell sucks. You've made the right decision not to exercise today.\n" +
            "Drink plenty of fluids and get plenty of rest"
    );
    openOptionDialog(view, Message06.class);
  }

  public void onClickOption3(View view) {
    openOptionDialog(view, Message07.class);
  }

  public void openOptionDialog(View view, final Class destination) {
    AlertDialog.Builder builder = new AlertDialog.Builder(this);
    builder.setTitle("Option Description")
        .setMessage(view.getContentDescription())
        .setPositiveButton("Select", new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.cancel();
            Intent in = new Intent(Node04.this, destination);
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
    Class previous = ((DecisionStack) this.getApplication()).getPrevious(true);
    try {
      Intent i = new Intent(Node04.this, previous);
      startActivity(i);
    } catch (Exception e) {
      System.err.println(e);
    }
  }
}
