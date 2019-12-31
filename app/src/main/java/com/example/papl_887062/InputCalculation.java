package com.example.papl_887062;

import android.content.res.Resources;

import java.util.ArrayList;

public class InputCalculation{
  private static String message;
  private static ArrayList<String> content;
  private static Boolean exerciseFlag;
  private static Resources context;

  public InputCalculation() {
    content = new ArrayList<>();
    context = DecisionStack.getContext().getResources();
  }

  static String getMessage() {
    return message;
  }

  static void setMessage(String m) {
    message = m;
  }

  static String getRecommendation() {
    return (!content.isEmpty()) ? content.remove(0) : null;
  }

  static void setExerciseFlag(Boolean b) {
    exerciseFlag = b;
  }

  static Boolean getExerciseFlag() {
    return exerciseFlag;
  }

  static String createFullWorkout(String m1, String m2, String m3, String a1, String a2,
                                          String a3) {
    return String.format("%1$s\n" +
        "%2$s %3$s \n" +
        "%2$s %4$s \n" +
        "%2$s %5$s \n" +
        "\n%6$s\n" +
        "%7$s %8$s \n" +
        "%7$s %9$s \n" +
        "%7$s %10$s \n",
        context.getString(R.string.mainExerciseTitle), context.getString(R.string.mainRepScheme),
        m1, m2, m3,
        context.getString(R.string.accessoryExerciseTitle), context.getString(R.string.accessoryRepScheme),
        a1, a2, a3);
  }

  static void recommendIntenseWorkouts() {
    recommendFullWorkouts();
    recommendUpperLowerSplit();
  }

  static void recommendModerateWorkouts() {
    recommendBodyweight();
    recommendCardio();
    recommendFullWorkouts();
  }

  static void recommendBasicWorkouts() {
    recommendEasyExercise();
    recommendBodyweight();
  }

  static void recommendFullWorkouts() {
    content.add(createFullWorkout(
        context.getString(R.string.backSquat),
        context.getString(R.string.bbBench),
        context.getString(R.string.bbRow),
        context.getString(R.string.wLunges),
        context.getString(R.string.inclineDbBench),
        context.getString(R.string.lPulldown)
    ));
    content.add(createFullWorkout(
        context.getString(R.string.deadlift),
        context.getString(R.string.bbOhp),
        context.getString(R.string.pullups),
        context.getString(R.string.frontSquat),
        context.getString(R.string.dbOhp),
        context.getString(R.string.seatedRow)
    ));
  }

  static void recommendUpperLowerSplit() {
    content.add(createFullWorkout(
        context.getString(R.string.bbBench),
        context.getString(R.string.bbOhp),
        context.getString(R.string.dbRow),
        context.getString(R.string.inclineDbBench),
        context.getString(R.string.dbOhp),
        context.getString(R.string.pendlay)
    ));
    content.add(createFullWorkout(
        context.getString(R.string.bbOhp),
        context.getString(R.string.bbBench),
        context.getString(R.string.pullups),
        context.getString(R.string.dips),
        context.getString(R.string.dbOhp),
        context.getString(R.string.bbRow)
    ));
    content.add(createFullWorkout(
        context.getString(R.string.backSquat),
        context.getString(R.string.deadlift),
        context.getString(R.string.frontSquat),
        context.getString(R.string.splitSquat),
        context.getString(R.string.hamstringCurl),
        context.getString(R.string.plank30)
    ));
    content.add(createFullWorkout(
        context.getString(R.string.deadlift),
        context.getString(R.string.romDeadlift),
        context.getString(R.string.frontSquat),
        context.getString(R.string.wLunges),
        context.getString(R.string.gobletSquat),
        context.getString(R.string.plank30)
    ));
  }

  static void recommendCardio() {
    content.add(context.getString(R.string.cardio1));
    content.add(context.getString(R.string.cardio2));
  }

  static void recommendEasyExercise() {
    content.add(context.getString(R.string.easyWorkout1));
    content.add(context.getString(R.string.easyWorkout2));
  }

  static void recommendBodyweight() {
    content.add(createFullWorkout(
        context.getString(R.string.airSquat),
        context.getString(R.string.pushups),
        context.getString(R.string.invertRow),
        context.getString(R.string.pistols),
        context.getString(R.string.diamondPushups),
        context.getString(R.string.plank30)
    ));
  }

}
