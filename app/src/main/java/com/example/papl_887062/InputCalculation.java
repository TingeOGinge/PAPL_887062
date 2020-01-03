package com.example.papl_887062;

import android.content.res.Resources;
import android.text.Html;
import android.text.Spanned;
import java.util.ArrayList;

public class InputCalculation{
  private static String message;
  private static ArrayList<String> workoutContent;
  private static Boolean exerciseFlag;
  private static Resources context;
  private static Spanned nhsLinks;
  private static String nhsLinkContent;

  public InputCalculation() {
    workoutContent = new ArrayList<>();
    context = DecisionStack.getContext().getResources();
    nhsLinkContent = "Helpful Links: <br><br>";
  }

  public static String getMessage() {
    return message;
  }

  public static void setMessage(String m) {
    message = m;
  }

  public static String getRecommendation() {
    return (!workoutContent.isEmpty()) ? workoutContent.remove(0) : null;
  }

  public static void addNhsLink(String link, String message) {
    nhsLinkContent += String.format("<a href='%1$s'>%2$s</a><br><br>", link, message);
  }

  public static Spanned getNhsLinks() {
    if (android.os.Build.VERSION.SDK_INT >= 24) {
      nhsLinks = (Html.fromHtml(nhsLinkContent, Html.FROM_HTML_MODE_LEGACY));
    } else {
      nhsLinks = (Html.fromHtml(nhsLinkContent));
    }
    return nhsLinks;
  }

  public static void setExerciseFlag(Boolean b) {
    exerciseFlag = b;
  }

  public static Boolean getExerciseFlag() {
    return exerciseFlag;
  }

  public static String createFullWorkout(String m1, String m2, String m3, String a1, String a2,
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

  public static void recommendIntenseWorkouts() {
    recommendFullWorkouts();
    recommendUpperLowerSplit();
  }

  public static void recommendModerateWorkouts() {
    recommendBodyweight();
    recommendCardio();
    recommendFullWorkouts();
  }

  public static void recommendBasicWorkouts() {
    recommendEasyExercise();
    recommendBodyweight();
  }

  public static void recommendFullWorkouts() {
    workoutContent.add(createFullWorkout(
        context.getString(R.string.backSquat),
        context.getString(R.string.bbBench),
        context.getString(R.string.bbRow),
        context.getString(R.string.wLunges),
        context.getString(R.string.inclineDbBench),
        context.getString(R.string.lPulldown)
    ));
    workoutContent.add(createFullWorkout(
        context.getString(R.string.deadlift),
        context.getString(R.string.bbOhp),
        context.getString(R.string.pullups),
        context.getString(R.string.frontSquat),
        context.getString(R.string.dbOhp),
        context.getString(R.string.seatedRow)
    ));
  }

  public static void recommendUpperLowerSplit() {
    workoutContent.add(createFullWorkout(
        context.getString(R.string.bbBench),
        context.getString(R.string.bbOhp),
        context.getString(R.string.dbRow),
        context.getString(R.string.inclineDbBench),
        context.getString(R.string.dbOhp),
        context.getString(R.string.pendlay)
    ));
    workoutContent.add(createFullWorkout(
        context.getString(R.string.bbOhp),
        context.getString(R.string.bbBench),
        context.getString(R.string.pullups),
        context.getString(R.string.dips),
        context.getString(R.string.dbOhp),
        context.getString(R.string.bbRow)
    ));
    workoutContent.add(createFullWorkout(
        context.getString(R.string.backSquat),
        context.getString(R.string.deadlift),
        context.getString(R.string.frontSquat),
        context.getString(R.string.splitSquat),
        context.getString(R.string.hamstringCurl),
        context.getString(R.string.plank30)
    ));
    workoutContent.add(createFullWorkout(
        context.getString(R.string.deadlift),
        context.getString(R.string.romDeadlift),
        context.getString(R.string.frontSquat),
        context.getString(R.string.wLunges),
        context.getString(R.string.gobletSquat),
        context.getString(R.string.plank30)
    ));
  }

  public static void recommendCardio() {
    workoutContent.add(context.getString(R.string.cardio1));
    workoutContent.add(context.getString(R.string.cardio2));
  }

  public static void recommendEasyExercise() {
    workoutContent.add(context.getString(R.string.easyWorkout1));
    workoutContent.add(context.getString(R.string.easyWorkout2));
  }

  public static void recommendBodyweight() {
    workoutContent.add(createFullWorkout(
        context.getString(R.string.airSquat),
        context.getString(R.string.pushups),
        context.getString(R.string.invertRow),
        context.getString(R.string.pistols),
        context.getString(R.string.diamondPushups),
        context.getString(R.string.plank30)
    ));
  }

}
