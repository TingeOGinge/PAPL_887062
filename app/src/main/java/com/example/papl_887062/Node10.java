package com.example.papl_887062;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Node10 extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_node10);
    ((DecisionStack) this.getApplication()).add(Node10.class);
  }

  public void onClickBack(View view) {
    Class previous = ((DecisionStack) this.getApplication()).getPrevious(true);
    try {
      Intent node01ToMain = new Intent(Node10.this, previous);
      startActivity(node01ToMain);
    } catch (Exception e) {
      System.err.println(e);
    }
  }

  public void onClickOption1(View view) {
    InputCalculation.setMessage(getResources().getString(R.string.node10_01_TMessage));
    InputCalculation.recommendBasicWorkouts();
    openOptionDialog(view, ExerciseThen.class);
  }

  public void onClickOption2(View view) {
    openOptionDialog(view, Message10.class);
  }

  public void onClickOption3(View view) {
    InputCalculation.setMessage(getResources().getString(R.string.node10_03_TMessage));
    InputCalculation.addNhsLink(getResources().getString(R.string.tetraplegiaUrl1),
        getResources().getString(R.string.tetraplegiaMessage1));
    openOptionDialog(view, DontExercise.class);
  }

  public void openOptionDialog(View view, final Class destination) {
    AlertDialog.Builder builder = new AlertDialog.Builder(this);
    builder.setTitle("Option Description")
        .setMessage(view.getContentDescription())
        .setPositiveButton("Select", new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.cancel();
            Intent in = new Intent(Node10.this, destination);
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
}
