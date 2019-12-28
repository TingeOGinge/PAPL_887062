package com.example.papl_887062;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
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

  public void onClickOption3(View view) {
    openOptionDialog(view, Node02.class);
  }

  public void openOptionDialog(View view, final Class destination) {
    AlertDialog.Builder builder = new AlertDialog.Builder(this);
    builder.setTitle("Option Description")
        .setMessage(view.getContentDescription())
        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.cancel();
            Intent in = new Intent(Node01.this, destination);
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
