package com.example.papl_887062;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
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

  public void onClickOption1(View view) {
    InputCalculation.setMessage(getResources().getString(R.string.node07_01_TMessage));
    InputCalculation.recommendIntenseWorkouts();
    openOptionDialog(view, ExerciseThen.class);
  }

  public void onClickOption2(View view) {
    InputCalculation.setMessage(getResources().getString(R.string.node07_02_TMessage));
    Resources resources = getResources();
    InputCalculation.addNhsLink(resources.getString(R.string.tiredUrl1), resources.getString(R.string.tiredMessage1));
    InputCalculation.addNhsLink(resources.getString(R.string.tiredUrl2), resources.getString(R.string.tiredMessage2));
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
            Intent in = new Intent(Node07.this, destination);
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

