package com.rayala30.nomatic.client.matchmaker.model.archive;

import com.rayala30.nomatic.client.matchmaker.model.athlete.Belt;
import com.rayala30.nomatic.client.matchmaker.model.athlete.Weight;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LiveMatch_Template {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        // create global error messages for error handling
        String errorMessage = "Invalid input. Please try again.";

        // NOMATIC MATCHMAKER WELCOME MESSAGE
        System.out.println("Welcome to the no-MAT-ic Mat(ch)Maker!");
        System.out.println();


        // Implement try-catch blocks

        //        String beltDivision = "";
        Belt beltDivision = Belt.White; // default value
        boolean missingBeltEntry = true;

        while (missingBeltEntry) {
            // enter belt division
            System.out.println("Please select match belt division");
            System.out.println("(1) White | (2) Blue | (3) Purple | (4) Brown | (5) Black");
            String beltInput = input.nextLine();

            try {
                if (beltInput.equals("1")) {
                    beltDivision = Belt.White;
                    missingBeltEntry = false;
                } else if (beltInput.equals("2")) {
                    beltDivision = Belt.Blue;
                    missingBeltEntry = false;
                } else if (beltInput.equals("3")) {
                    beltDivision = Belt.Purple;
                    missingBeltEntry = false;
                } else if (beltInput.equals("4")) {
                    beltDivision = Belt.Brown;
                    missingBeltEntry = false;
                } else if (beltInput.equals("5")) {
                    beltDivision = Belt.Black;
                    missingBeltEntry = false;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(errorMessage);
            }

        }

        System.out.println();

        String genderDivision = "";
        boolean missingGenderEntry = true;

        while (missingGenderEntry) {
            // enter gender division
            System.out.println("Please select gender division");
            System.out.print("(1) Male | (2) Female: ");
            String genderInput = input.nextLine();

            try {
                if (genderInput.equals("1")) {
                    genderDivision = "Male";
                    missingGenderEntry = false;
                } else if (genderInput.equals("2")) {
                    genderDivision = "Female";
                    missingGenderEntry = false;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(errorMessage);
            }
        }

        System.out.println();

        String ageDivision = "";
        boolean missingAgeEntry = true;
        while (missingAgeEntry) {
            // enter age division
            System.out.println("Please select age division");
            System.out.print("(1) Juvenile | (2) Adult | (3) Masters: ");
            String ageInput = input.nextLine();

            try {
                if (ageInput.equals("1")) {
                    ageDivision = "Juvenile";
                    missingAgeEntry = false;
                } else if (ageInput.equals("2")) {
                    ageDivision = "Adult";
                    missingAgeEntry = false;
                } else if (ageInput.equals("3")) {
                    ageDivision = "Masters";
                    missingAgeEntry = false;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(errorMessage);
            }
        }

        System.out.println();

//        String weightDivision = "";
        Weight weightDivision = Weight.Roosterweight;
        boolean missingWeightEntry = true;
        while (missingWeightEntry) {
            // enter weight division
            System.out.println("Please select weight division");
            System.out.println("(1) Roosterweight | (2) Light Featherweight | (3) Featherweight");
            System.out.println("(4) Lightweight | (5) Middleweight | (6) Medium Heavyweight");
            System.out.println("(7) Heavyweight | (8) Super Heavyweight | (9) Ultra Heavyweight | (10) Open Weight");
            String weightInput = input.nextLine();

            try {
                if (weightInput.equals("1")) {
                    weightDivision = Weight.Roosterweight;
                    missingWeightEntry = false;
                } else if (weightInput.equals("2")) {
                    weightDivision = Weight.Light_Featherweight;
                    missingWeightEntry = false;
                } else if (weightInput.equals("3")) {
                    weightDivision = Weight.Featherweight;
                    missingWeightEntry = false;
                } else if (weightInput.equals("4")) {
                    weightDivision = Weight.Lightweight;
                    missingWeightEntry = false;
                } else if (weightInput.equals("5")) {
                    weightDivision = Weight.Middleweight;
                    missingWeightEntry = false;
                } else if (weightInput.equals("6")) {
                    weightDivision = Weight.Medium_Heavyweight;
                    missingWeightEntry = false;
                } else if (weightInput.equals("7")) {
                    weightDivision = Weight.Heavyweight;
                    missingWeightEntry = false;
                } else if (weightInput.equals("8")) {
                    weightDivision = Weight.Super_Heavyweight;
                    missingWeightEntry = false;
                } else if (weightInput.equals("9")) {
                    weightDivision = Weight.Ultra_Heavyweight;
                    missingWeightEntry = false;
                } else if (weightInput.equals("10")) {
                    weightDivision = Weight.Open_Weight;
                    missingWeightEntry = false;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(errorMessage);
            }
        }

        System.out.println();



        // FIRST COMPETITOR
        String competitorOne = "";
        boolean missingFirstNameEntry = true;
        // while missingFirstNameEntry is TRUE, run below code
        while (missingFirstNameEntry) {
            // enter first athlete name
            System.out.print("Please enter name of Athlete One (First Last): ");
            String athleteOneName = input.nextLine();

            try {
                if (athleteOneName.isEmpty()) {
                    missingFirstNameEntry = true;
                }
                else {
                    competitorOne = athleteOneName;
                    missingFirstNameEntry = false;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(errorMessage);
            }
        }

        // SECOND COMPETITOR
        String competitorTwo = "";
        boolean missingSecondNameEntry = true;

        while (missingSecondNameEntry) {
            // enter second athlete name
            System.out.print("Please enter name of Athlete Two (First Last): ");
            String athleteTwoName = input.nextLine();

            try {
                if (athleteTwoName.isEmpty()) {
                    missingSecondNameEntry = true;
                }
                else {
                    competitorTwo = athleteTwoName;
                    missingSecondNameEntry = false;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(errorMessage);
            }
        }

        System.out.println();





        String timeEntry = "";
        int matchLength = 0; //milliseconds

        boolean missingTimeEntry = true;
        while(missingTimeEntry) {
            // select match time limit in minutes. enter time variable as milliseconds
            System.out.println("Select match length:");
            System.out.println("(A) 5:00 | (B) 6:00 | (C) 7:00 | (D) 8:00 | (E) 10:00");
            String timeInput = input.nextLine();

            try {
                if (timeInput.equalsIgnoreCase("A")) {
                    timeEntry = "5:00";
                    matchLength = 300000;
                    missingTimeEntry = false;
                }
                else if (timeInput.equalsIgnoreCase("B")) {
                    timeEntry = "6:00";
                    matchLength = 360000;
                    missingTimeEntry = false;
                }
                else if (timeInput.equalsIgnoreCase("C")) {
                    timeEntry = "7:00";
                    matchLength = 420000;
                    missingTimeEntry = false;
                }
                else if (timeInput.equalsIgnoreCase("D")) {
                    timeEntry = "8:00";
                    matchLength = 480000;
                    missingTimeEntry = false;
                }
                else if (timeInput.equalsIgnoreCase("E")) {
                    timeEntry = "10:00";
                    matchLength = 600000;
                    missingTimeEntry = false;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(errorMessage);
            }
        }

        System.out.println();

        // match set with names, gender, age, and weight
        System.out.println("Thank you. Now setting up match.");
        System.out.println();
        System.out.println("Match set for the " + genderDivision + " " + ageDivision + " " + beltDivision + " division at " + weightDivision
                + " for " + timeEntry + ".");
        System.out.println();
        System.out.println(competitorOne + " VS " + competitorTwo);
        System.out.println();

        System.out.println("Match START.");
        System.out.println();

        // create boolean and while state to run code if match still going
        boolean matchOngoing = true;
        // match will be ongoing until time runs out
        // create a timer class that is set to true when counting down starts

        // initialize competitor score
        int competitorOnePoints = 0;
        int competitorOnePenalty = 0;
        int competitorOneAdv = 0;

        int competitorTwoPoints = 0;
        int competitorTwoPenalty = 0;
        int competitorTwoAdv = 0;

        // while match is ongoing, run the code below
        while (matchOngoing) {
            // call action menu that displays throughout the match duration
            String action = "";
            promptForAction(action);
            action = input.nextLine();

            // if POINTS is selected action
            if (action.equals("1")) {
                System.out.println("Award points to: ");
                System.out.println("(1) " + competitorOne + " OR " + "(2) " + competitorTwo);
                String athleteSelection = input.nextLine();

                String pointSelection = "";
                int points = pointsCalculator(pointSelection);
                pointSelection = input.nextLine();

                if (athleteSelection.equals("1")) {
                    competitorOnePoints += points;
                }
                else if (athleteSelection.equals("2")) {
                    competitorTwoPoints += points;
                }
                else {
                    System.out.println(errorMessage);
                }
            }

            // if ADVANTAGE is selected action
            if (action.equals("2")) {
                System.out.println("Award advantage to: ");
                System.out.println("(1) " + competitorOne + " OR " + "(2) " + competitorTwo);
                String athleteSelection = input.nextLine();

                if (athleteSelection.equals("1")) {
                    competitorOneAdv ++;
                }
                else if (athleteSelection.equals("2")) {
                    competitorTwoAdv ++;
                }
                else {
                    System.out.println(errorMessage);
                }
            }

            // if PENALTY is selected action
            if (action.equals("3")) {
                System.out.println("Give penalty to: ");
                System.out.println("(1) " + competitorOne + " OR " + "(2) " + competitorTwo);
                String athleteSelection = input.nextLine();

                if (athleteSelection.equals("1")) {
                    competitorOnePenalty ++;
                }
                else if (athleteSelection.equals("2")) {
                    competitorTwoPenalty ++;
                }
                else {
                    System.out.println(errorMessage);
                }
            }

            // if SUBMISSION is selected action
            if (action.equals("S") || action.equals("s")) {
                System.out.println("Submission win by: ");
                System.out.println("(1) " + competitorOne + " OR " + "(2) " + competitorTwo);
                String athleteSelection = input.nextLine();

                if (athleteSelection.equals("1")) {
                    System.out.println(competitorOne.toUpperCase() + " wins!");
                    System.out.println("Match over.");
                    System.out.println();
                    matchOngoing = false;
                }
                else if (athleteSelection.equals("2")) {
                    System.out.println(competitorTwo.toUpperCase() + " wins!");
                    System.out.println("Match over.");
                    System.out.println();
                    matchOngoing = false;
                }
                else {
                    System.out.println(errorMessage);
                }
            }

            // if DISQUALIFICATION is selected action
            if (action.equals("D") || action.equals("d")) {
                System.out.println("Disqualification for: ");
                System.out.println("(1) " + competitorOne + " OR " + "(2) " + competitorTwo);
                String athleteSelection = input.nextLine();

                if (athleteSelection.equals("1")) {
                    System.out.println(competitorOne + " has been disqualified!");
                    System.out.println(competitorTwo.toUpperCase() + " wins!");
                    System.out.println("Match over.");
                    System.out.println();
                    matchOngoing = false;
                }
                else if (athleteSelection.equals("2")) {
                    System.out.println(competitorTwo + " has been disqualified!");
                    System.out.println(competitorOne.toUpperCase() + " wins!");
                    System.out.println("Match over.");
                    System.out.println();
                    matchOngoing = false;
                }
                else {
                    System.out.println(errorMessage);
                }
            }

            // if REVIEW is selected action
            if (action.equals("R") || action.equals("r")) {
                System.out.println("Edit score for: ");
                System.out.println("(1) " + competitorOne + " OR " + "(2) " + competitorTwo);
                String athleteSelection = input.nextLine();

                if (athleteSelection.equals("1")) {
                    String selection = "";
                    promptForReview(selection);
                    selection = input.nextLine();

                    if (selection.equals("1")) {
                        System.out.println("Enter point deduction: ");
                        String pointDeduction = input.nextLine();
                        competitorOnePoints -= Integer.parseInt(pointDeduction);
                    }
                    if (selection.equals("2")) {
                        System.out.println("Enter advantage deduction: ");
                        String advDeduction = input.nextLine();
                        competitorOneAdv -= Integer.parseInt(advDeduction);
                    }
                    if (selection.equals("3")) {
                        System.out.println("Enter penalty deduction: ");
                        String penDeduction = input.nextLine();
                        competitorOnePenalty -= Integer.parseInt(penDeduction);
                    }
                }

                if (athleteSelection.equals("2")) {
                    String selection = "";
                    promptForReview(selection);
                    selection = input.nextLine();

                    if (selection.equals("1")) {
                        System.out.println("Enter point deduction: ");
                        String pointDeduction = input.nextLine();
                        competitorTwoPoints -= Integer.parseInt(pointDeduction);
                    }
                    if (selection.equals("2")) {
                        System.out.println("Enter advantage deduction: ");
                        String advDeduction = input.nextLine();
                        competitorTwoAdv -= Integer.parseInt(advDeduction);
                    }
                    if (selection.equals("3")) {
                        System.out.println("Enter penalty deduction: ");
                        String penDeduction = input.nextLine();
                        competitorTwoPenalty -= Integer.parseInt(penDeduction);
                    }
                }
            }

            System.out.println(competitorOne);
            System.out.println("  Points: " + competitorOnePoints);
            System.out.println("  Advantages: " + competitorOneAdv);
            System.out.println("  Penalties: " + competitorOnePenalty);
            System.out.println();
            System.out.println(competitorTwo);
            System.out.println("  Points: " + competitorTwoPoints);
            System.out.println("  Advantages: " + competitorTwoAdv);
            System.out.println("  Penalties: " + competitorTwoPenalty);
            System.out.println();
        }

    }


    // Use File I/O to generate results log


        /*
        HELPER FUNCTIONS & METHODS BELOW
         */



    private static void promptForAction(String action) {
        // this menu will remain constant for the duration of match
        System.out.println("Choose action: ");
        System.out.println("(1) Points | (2) Advantage | (3) Penalty");
        System.out.println("(S)ubmission | (D)isqualification | (R)eview");
    }

    private static void promptForReview(String selection) {
        System.out.println("Choose category to review: ");
        System.out.println("(1) Points | (2) Advantage | (3) Penalty");
    }

    // create points calculator method
    private static int pointsCalculator(String pointSelection) {
        // create global error messages
        String errorMessage = "Invalid input. Please try again.";

        // create pointType map. pointTypes can be in an unordered data structure
        Map<String, Integer> pointTypes = new HashMap<>();
        // add values
        pointTypes.put("sweep", 2);
        pointTypes.put("takedown", 2);
        pointTypes.put("knee on belly", 2);
        pointTypes.put("guard pass", 3);
        pointTypes.put("mount", 4);
        pointTypes.put("back control", 4);

        System.out.println();

        System.out.println("Select point type: ");
        System.out.println("(S)weep | (T)akedown | (K)nee on Belly");
        System.out.println("(G)uard Pass | (M)ount | (B)ack Control");

        pointSelection = input.nextLine();

        int points = 0;

        if (pointSelection.equals("s") || pointSelection.equals("S")) {
            points += pointTypes.get("sweep");
            System.out.println("2 points for Sweep.");
        }
        else if (pointSelection.equals("t") || pointSelection.equals("T")) {
            points += pointTypes.get("takedown");
            System.out.println("2 points for Takedown.");
        }
        else if (pointSelection.equals("k") || pointSelection.equals("K")) {
            points += pointTypes.get("knee on belly");
            System.out.println("2 points for Knee on Belly.");
        }
        else if (pointSelection.equals("g") || pointSelection.equals("G")) {
            points += pointTypes.get("guard pass");
            System.out.println("3 points for Guard Pass.");
        }
        else if (pointSelection.equals("m") || pointSelection.equals("M")) {
            points += pointTypes.get("mount");
            System.out.println("4 points for Mount.");
        }
        else if (pointSelection.equals("b") || pointSelection.equals("B")) {
            points += pointTypes.get("back control");
            System.out.println("4 points for Back Control.");
        }
        else if (pointSelection.isEmpty()) {
            System.out.println(errorMessage);
        }
        else {
            System.out.println(errorMessage);
        }
        // this is returning one instance of the points everytime function is called.
        return points;
    }


    private static void Timer() {

    }


    private static void matchResults() {
        // create match report with score and winner.

        // enter match result into results database - <result, method> ex: Win via Points

        // enter competitor result into competitor database
    }

}
