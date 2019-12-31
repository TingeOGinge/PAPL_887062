package com.example.papl_887062;

import android.app.Application;
import android.content.Context;

import java.util.EmptyStackException;
import java.util.Stack;

public class DecisionStack extends Application {
  private Stack<Class> stack;
  private static Context mContext;

  @Override
  public void onCreate() {
    super.onCreate();
    mContext = this;
    this.stack = new Stack<>();
  }

  public static Context getContext() {
    return mContext;
  }

  public void add(Class c) {
    if(!checkForDuplicate(c)) {
      stack.push(c);
    }
  }

  public Class getPrevious(Boolean popRequired) {
    try {
      if (popRequired) stack.pop();
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
