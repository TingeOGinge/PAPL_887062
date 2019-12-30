package com.example.papl_887062;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.*;
import android.os.Bundle;
import android.view.View;

public class Node01 extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_node01);
    ((DecisionStack) this.getApplication()).add(Node01.class);
  }

  public void onClickBack(View view) {
    Class previous = ((DecisionStack) this.getApplication()).getPrevious(true);
    try {
      Intent node01ToMain = new Intent(Node01.this, previous);
      startActivity(node01ToMain);
    } catch (Exception e) {
      System.err.println(e);
    }
  }

  public void onClickOption1(View view) {
    InputCalculation.setMessage(getResources().getString(R.string.node01_01_TMessage));
    InputCalculation.recommendIntenseWorkouts();
    openOptionDialog(view, ExerciseThen.class);
  }

  public void onClickOption2(View view) {
    openOptionDialog(view, Message01.class);
  }

  public void onClickOption3(View view) {
    openOptionDialog(view, Node03.class);
  }

  public void openOptionDialog(View view, final Class destination) {
    AlertDialog.Builder builder = new AlertDialog.Builder(this);
    builder.setTitle("Option Description")
        .setMessage(view.getContentDescription())
        .setPositiveButton("Select", new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.cancel();
            Intent in = new Intent(Node01.this, destination);
            startActivity(in);
          }
        })
        .setNegativeButton("Back", new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.cancel();
          }
        });
    builder.show();
  }
}
