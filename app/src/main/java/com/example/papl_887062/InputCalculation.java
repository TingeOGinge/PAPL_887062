package com.example.papl_887062;

import java.util.ArrayList;

public class InputCalculation {
  private static String message;
  private static ArrayList<String> content = new ArrayList<>();
  private static Boolean exerciseFlag;

  public static String getMessage() {
    return message;
  }

  public static void setMessage(String m) {
    message = m;
  }

  public static String getRecommendation() {
    return (!content.isEmpty()) ? content.remove(0) : null;
  }

  public static void setExerciseFlag(Boolean b) {
    exerciseFlag = b;
  }

  public static Boolean getExerciseFlag() {
    return exerciseFlag;
  }

  private static String createFullWorkout(String m1, String m2, String m3, String a1, String a2, String a3) {
    return String.format("Main exercises: \n" +
        "3x5 %s \n" +
        "3x5 %s \n" +
        "3x5 %s \n" +
        "\n" +
        "Accessories (optional) \n" +
        "4x8 %s \n" +
        "4x8 %s \n" +
        "4x8 %s \n",
        m1, m2, m3, a1, a2, a3);
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
    content.add(createFullWorkout(
        "Back Squat",
        "Bench Press",
        "Barbell Row",
        "Weighted Lunges",
        "Incline Dumbbell Bench Press",
        "Lateral Pulldown"
    ));
    content.add(createFullWorkout(
        "Deadlift",
        "Barbell Overhead Press",
        "Pull Ups (weighted if applicable)",
        "Front Squat",
        "Dumbbell Overhead Press",
        "Seated Row"
    ));
  }

  public static void recommendUpperLowerSplit() {
    content.add(createFullWorkout(
        "Bench Press",
        "Barbell Overhead Press",
        "Dumbbell Row",
        "Incline Dumbbell Bench Press",
        "Dumbbell Overhead Press",
        "Pendlay Row"
    ));
    content.add(createFullWorkout(
        "Barbell Overhead Press",
        "Bench Press",
        "Pull Ups (weighted if applicable)",
        "Dips",
        "Dumbbell Overhead Press",
        "Barbell Row"
    ));
    content.add(createFullWorkout(
        "Back Squat",
        "Deadlift",
        "Front Squat",
        "Split Squat",
        "Hamstring Curl",
        "30s Planks"
    ));
    content.add(createFullWorkout(
        "Conventional Deadlift",
        "Romanian Deadlift",
        "Front Squat",
        "Walking Lunges",
        "Goblet Squat",
        "30s Planks"
    ));
  }

  public static void recommendCardio() {
    content.add(
        "20 Minutes Stationary Bike\n" +
            "HIIT Circuit: \n" +
            "21 - 15 - 9 \n" +
            "Kettlebell Swings \n" +
            "Burpees \n" +
            "Double Unders"
    );
    content.add(
        "30 Minutes Treadmill\n" +
            "HIIT Circuit: \n" +
            "3 Rounds For Time: \n" +
            "20m Sled Push \n" +
            "10 Pull Ups\n" +
            "10 Burpees"
    );
  }

  public static void recommendEasyExercise() {
    content.add(
        "Dynamic Stretching to Warm Up \n" +
            "Go Jogging \n" +
            "It really is that simple"
    );
    content.add(
        "Yoga: Sun Salutations \n" +
            "Mountain Pose \n" +
            "Upward Salute \n" +
            "Standing Forward Bend \n" +
            "Plank Pose \n" +
            "Upward Facing Dog \n" +
            "Downward Facing Dog \n" +
            "Standing Forward Bend \n" +
            "Repeat as needed"
    );
  }

  public static void recommendBodyweight() {
    content.add(createFullWorkout(
        "Air Squats",
        "Push Ups",
        "Inverted Rows (Pull Ups if possible)",
        "Pistol Squats",
        "Diamond Push Ups",
        "30 Second Planks"
    ));
  }

}
