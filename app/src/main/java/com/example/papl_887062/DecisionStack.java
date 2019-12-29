package com.example.papl_887062;

import android.app.Application;

import java.util.EmptyStackException;
import java.util.Stack;

public class DecisionStack extends Application {
  private Stack<Class> stack;

  public DecisionStack() {
    this.stack = new Stack<>();
  }

  public void add(Class c) {
    if(!checkForDuplicate(c)) {
      stack.push(c);
    }
  }

  public Class getPrevious() {
    try {
      stack.pop();
      return stack.peek();
    } catch (EmptyStackException e) {
      System.err.println(e);
      return null;
    }
  }

  private Boolean checkForDuplicate(Class current) {
    return !stack.empty() && current == stack.peek();
  }
}
