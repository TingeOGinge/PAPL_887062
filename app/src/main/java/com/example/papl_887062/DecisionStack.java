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
    if(stack.empty() || !stackPeek(c)) {
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

  private Boolean stackPeek(Class current) {
    if (!stack.empty()) {
      return current == stack.peek();
    } else {
      return false;
    }
  }
}
