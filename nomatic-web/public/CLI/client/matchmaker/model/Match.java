package com.rayala30.nomatic.client.matchmaker.model;

import com.rayala30.nomatic.client.matchmaker.model.athlete.Athlete;
import com.rayala30.nomatic.client.matchmaker.model.athlete.Belt;
import com.rayala30.nomatic.client.matchmaker.model.athlete.Weight;


import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Match {

    // Instance variables
    private boolean isPublic;
    private int athleteOneId;

    private Athlete athleteOne;
    private int athleteTwoId;

    private Athlete athleteTwo;

    private LocalDate matchDate;
    private String location;
    private int matchId;

    // matchWinner may need to be tied to an Athlete ID and be an int type. This is needed to tabulate user wins.
    private String matchWinner;
    private int matchWinnerId;

    // matchWinner may need to be tied to an Athlete ID and be an int type. This is needed to tabulate user losses.
    private String matchLoser;
    private int matchLoserId;

    private String matchWinMethod;
    private Belt matchBelt;
    private int matchLength;
    private Weight matchWeight;
    private String matchAge;
    private String matchGender;
    private int athleteOnePoints;
    private int athleteTwoPoints;
    private int athleteOneAdv;
    private int athleteTwoAdv;
    private int athleteOnePenalty;
    private int athleteTwoPenalty;


    // Constructors

    public Match() {
    }

    // This constructor set is for initial the command line Matchmaker setup
    public Match(Athlete athleteOne, Athlete athleteTwo, Belt matchBelt, Weight matchWeight, String matchAge, String matchGender, int matchLength) {
        this.athleteOne = athleteOne;
        this.athleteTwo = athleteTwo;
        this.matchBelt = matchBelt;
        this.matchLength = matchLength;
        this.matchWeight = matchWeight;
        this.matchAge = matchAge;
        this.matchGender = matchGender;
    }

    // This constructor is for the DAO constructor
    public Match(boolean isPublic, int matchId, LocalDate matchDate, int athleteOneId, int athleteTwoId, String location, int matchWinnerId, String matchWinner, int matchLoserId, String matchLoser, String matchWinMethod, Belt matchBelt, Weight matchWeight, String matchAge, int matchLength, int athleteOnePoints, int athleteTwoPoints, int athleteOneAdv, int athleteTwoAdv, int athleteOnePenalty, int athleteTwoPenalty) {
        this.isPublic = isPublic;
        this.matchDate = matchDate;
        this.athleteOneId = athleteOneId;
        this.athleteTwoId = athleteTwoId;
        this.location = location;
        this.matchId = matchId;
        this.matchWinnerId = matchWinnerId;
        this.matchWinner = matchWinner;
        this.matchLoserId = matchLoserId;
        this.matchLoser = matchLoser;
        this.matchWinMethod = matchWinMethod;
        this.matchBelt = matchBelt;
        this.matchLength = matchLength;
        this.matchWeight = matchWeight;
        this.matchAge = matchAge;
        this.athleteOnePoints = athleteOnePoints;
        this.athleteTwoPoints = athleteTwoPoints;
        this.athleteOneAdv = athleteOneAdv;
        this.athleteTwoAdv = athleteTwoAdv;
        this.athleteOnePenalty = athleteOnePenalty;
        this.athleteTwoPenalty = athleteTwoPenalty;
    }

    // Getters


    public boolean isPublic() {
        return isPublic;
    }

    public Athlete getAthleteOne() {
        return athleteOne;
    }
    public Athlete getAthleteTwo() {
        return athleteTwo;
    }
    public LocalDate getMatchDate() {
        return matchDate;
    }
    public int getAthleteOneId() {
        return athleteOneId;
    }
    public int getAthleteTwoId() {
        return athleteTwoId;
    }
    public String getLocation() {
        return location;
    }
    public int getMatchLength() {
        return matchLength;
    }
    public Weight getMatchWeight() {
        return matchWeight;
    }

    // Need to create a Getter that translates/converts Weight to a SQL-readable String object for SQL query in JdbcMatchDao
    public String getSQLMatchWeight() {
        String weightString = "";
        if (matchWeight == Weight.Roosterweight) {
            weightString = "Roosterweight";
        }
        else if (matchWeight == Weight.Light_Featherweight) {
            weightString = "Light-Featherweight";
        }
        else if (matchWeight == Weight.Featherweight) {
            weightString = "Featherweight";
        }
        else if (matchWeight == Weight.Lightweight) {
            weightString = "Lightweight";
        }
        else if (matchWeight == Weight.Middleweight) {
            weightString = "Middleweight";
        }
        else if (matchWeight == Weight.Medium_Heavyweight) {
            weightString = "Medium-Heavyweight";
        }
        else if (matchWeight == Weight.Heavyweight) {
            weightString = "Heavyweight";
        }
        else if (matchWeight == Weight.Super_Heavyweight) {
            weightString = "Super-Heavyweight";
        }
        else if (matchWeight == Weight.Ultra_Heavyweight) {
            weightString = "Ultra-Heavyweight";
        }
        else if (matchWeight == Weight.Open_Weight) {
            weightString = "Open-Weight";
        }
        return weightString;
    }

    public String getMatchAge() {
        return matchAge;
    }
    public String getMatchGender() {
        return matchGender;
    }
    public Belt getMatchBelt() {
        return matchBelt;
    }

    // Need to create a Getter that translates/converts Belt to a SQL-readable String object for SQL query in JdbcMatchDao
    public String getSQLMatchBelt() {
        String beltString = "";
        if (matchBelt == Belt.White) {
            beltString = "White";
        }
        else if (matchBelt == Belt.Blue) {
            beltString = "Blue";
        }
        else if (matchBelt == Belt.Purple) {
            beltString = "Purple";
        }
        else if (matchBelt == Belt.Brown) {
            beltString = "Brown";
        }
        else if (matchBelt == Belt.Black) {
            beltString = "Black";
        }
        return beltString;
    }

    public int getAthleteOnePoints() {
        return athleteOnePoints;
    }

    public int getAthleteTwoPoints() {
        return athleteTwoPoints;
    }

    public int getAthleteOneAdv() {
        return athleteOneAdv;
    }

    public int getAthleteTwoAdv() {
        return athleteTwoAdv;
    }

    public int getAthleteOnePenalty() {
        return athleteOnePenalty;
    }

    public int getAthleteTwoPenalty() {
        return athleteTwoPenalty;
    }

    public int getMatchId() {
        return matchId;
    }

    public String getMatchWinner() {
        return matchWinner;
    }

    public int getMatchWinnerId() {
        return matchWinnerId;
    }

    public String getMatchLoser() {
        return matchLoser;
    }

    public int getMatchLoserId() {
        return matchLoserId;
    }

    public String getMatchWinMethod() {
        return matchWinMethod;
    }


    // Setters
    public void setPublic(boolean aPublic) {
        isPublic = aPublic;
    }

    public void setMatchLength(int matchLength) {
        this.matchLength = matchLength;
    }

    public void setMatchWeight(String matchWeight) {
        if (matchWeight.equalsIgnoreCase("Roosterweight")) {
            this.matchWeight = Weight.Roosterweight;
        }
        else if (matchWeight.equalsIgnoreCase("Light-Featherweight")) {
            this.matchWeight = Weight.Light_Featherweight;
        }
        else if (matchWeight.equalsIgnoreCase("Featherweight")) {
            this.matchWeight = Weight.Featherweight;
        }
        else if (matchWeight.equalsIgnoreCase("Lightweight")) {
            this.matchWeight = Weight.Lightweight;
        }
        else if (matchWeight.equalsIgnoreCase("Middleweight")) {
            this.matchWeight = Weight.Middleweight;
        }
        else if (matchWeight.equalsIgnoreCase("Medium-Heavyweight")) {
            this.matchWeight = Weight.Medium_Heavyweight;
        }
        else if (matchWeight.equalsIgnoreCase("Heavyweight")) {
            this.matchWeight = Weight.Heavyweight;
        }
        else if (matchWeight.equalsIgnoreCase("Super-Heavyweight")) {
            this.matchWeight = Weight.Super_Heavyweight;
        }
        else if (matchWeight.equalsIgnoreCase("Ultra-Heavyweight")) {
            this.matchWeight = Weight.Ultra_Heavyweight;
        }
        else if (matchWeight.equalsIgnoreCase("Open-Weight")) {
            this.matchWeight = Weight.Open_Weight;
        }
    }

    public void setMatchAge(String matchAge) {
        this.matchAge = matchAge;
    }

    public void setAthleteOne(Athlete athleteOne) {
        this.athleteOne = athleteOne;
    }

    public void setAthleteTwo(Athlete athleteTwo) {
        this.athleteTwo = athleteTwo;
    }

    public void setMatchDate(LocalDate matchDate) {
        this.matchDate = matchDate;
    }

    public void setAthleteOneId(int athleteOneId) {
        this.athleteOneId = athleteOneId;
    }

    public void setAthleteTwoId(int athleteTwoId) {
        this.athleteTwoId = athleteTwoId;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setMatchBeltObject(Belt belt) {
        this.matchBelt = belt;
    }

    public void setMatchBelt(String matchBelt) {
        if (matchBelt.equalsIgnoreCase("White")) {
            this.matchBelt = Belt.White;
        }
        else if (matchBelt.equalsIgnoreCase("Blue")) {
            this.matchBelt = Belt.Blue;
        }
        else if (matchBelt.equalsIgnoreCase("Purple")) {
            this.matchBelt = Belt.Purple;
        }
        else if (matchBelt.equalsIgnoreCase("Brown")) {
            this.matchBelt = Belt.Brown;
        }
        else if (matchBelt.equalsIgnoreCase("Black")) {
            this.matchBelt = Belt.Black;
        }
    }

    public void setMatchGender(String matchGender) {
        this.matchGender = matchGender;
    }

    public void setAthleteOnePoints(int athleteOnePoints) {
        this.athleteOnePoints = athleteOnePoints;
    }

    public void setAthleteTwoPoints(int athleteTwoPoints) {
        this.athleteTwoPoints = athleteTwoPoints;
    }

    public void setAthleteOneAdv(int athleteOneAdv) {
        this.athleteOneAdv = athleteOneAdv;
    }

    public void setAthleteTwoAdv(int athleteTwoAdv) {
        this.athleteTwoAdv = athleteTwoAdv;
    }

    public void setAthleteOnePenalty(int athleteOnePenalty) {
        this.athleteOnePenalty = athleteOnePenalty;
    }

    public void setAthleteTwoPenalty(int athleteTwoPenalty) {
        this.athleteTwoPenalty = athleteTwoPenalty;
    }

    public void setMatchId(int matchId) {
        this.matchId = matchId;
    }

    public void setMatchWinner(String matchWinner) {
        this.matchWinner = matchWinner;
    }

    public void setMatchWinnerId(int matchWinnerId) {
        this.matchWinnerId = matchWinnerId;
    }

    public void setMatchLoser(String matchLoser) {
        this.matchLoser = matchLoser;
    }

    public void setMatchLoserId(int matchLoserId) {
        this.matchLoserId = matchLoserId;
    }

    public void setMatchWinMethod(String matchWinMethod) {
        this.matchWinMethod = matchWinMethod;
    }

    public void setSQLMatchBelt(String matchBelt) {
        if (matchBelt.equalsIgnoreCase("White")) {
            this.matchBelt = Belt.White;
        }
        else if (matchBelt.equalsIgnoreCase("Blue")) {
            this.matchBelt = Belt.Blue;
        }
        else if (matchBelt.equalsIgnoreCase("Purple")) {
            this.matchBelt = Belt.Purple;
        }
        else if (matchBelt.equalsIgnoreCase("Brown")) {
            this.matchBelt = Belt.Brown;
        }
        else if (matchBelt.equalsIgnoreCase("Black")) {
            this.matchBelt = Belt.Black;
        }
    }

    public void setSQLMatchWeight(String matchWeight) {
        if (matchWeight.equalsIgnoreCase("Roosterweight")) {
            this.matchWeight = Weight.Roosterweight;
        }
        else if (matchWeight.equalsIgnoreCase("Light-Featherweight")) {
            this.matchWeight = Weight.Light_Featherweight;
        }
        else if (matchWeight.equalsIgnoreCase("Featherweight")) {
            this.matchWeight = Weight.Featherweight;
        }
        else if (matchWeight.equalsIgnoreCase("Lightweight")) {
            this.matchWeight = Weight.Lightweight;
        }
        else if (matchWeight.equalsIgnoreCase("Middleweight")) {
            this.matchWeight = Weight.Middleweight;
        }
        else if (matchWeight.equalsIgnoreCase("Medium-Heavyweight")) {
            this.matchWeight = Weight.Medium_Heavyweight;
        }
        else if (matchWeight.equalsIgnoreCase("Heavyweight")) {
            this.matchWeight = Weight.Heavyweight;
        }
        else if (matchWeight.equalsIgnoreCase("Super-Heavyweight")) {
            this.matchWeight = Weight.Super_Heavyweight;
        }
        else if (matchWeight.equalsIgnoreCase("Ultra-Heavyweight")) {
            this.matchWeight = Weight.Ultra_Heavyweight;
        }
        else if (matchWeight.equalsIgnoreCase("Open-Weight")) {
            this.matchWeight = Weight.Open_Weight;
        }
    }

    public void setMatchWeightObject(Weight weight) {
        this.matchWeight = weight;
    }


    // Methods

    public static int pointsCalculator(String pointSelection) {
        int points = 0;
        // Create pointType map
        Map<String, Integer> pointTypes = new HashMap<>();
        // Add point values
        pointTypes.put("sweep", 2);
        pointTypes.put("takedown", 2);
        pointTypes.put("knee on belly", 2);
        pointTypes.put("guard pass", 3);
        pointTypes.put("mount", 4);
        pointTypes.put("back control", 4);

        if (pointSelection.equalsIgnoreCase("sweep")) {
            points = pointTypes.get("sweep");
        } else if (pointSelection.equalsIgnoreCase("takedown")) {
            points = pointTypes.get("takedown");
        } else if (pointSelection.equalsIgnoreCase("knee on belly")) {
            points = pointTypes.get("knee on belly");
        } else if (pointSelection.equalsIgnoreCase("guard pass")) {
            points = pointTypes.get("guard pass");
        } else if (pointSelection.equalsIgnoreCase("mount")) {
            points = pointTypes.get("mount");
        } else if (pointSelection.equalsIgnoreCase("back control")) {
            points = pointTypes.get("back control");
        }
        return points;
    }

    public String displayScore(Athlete athlete, int athletePoints, int athleteAdvantages, int athletePenalties) {
        return athlete.getName().toUpperCase() + System.lineSeparator()
                + "Points: " + athletePoints + System.lineSeparator()
                + "Advantages: " + athleteAdvantages + System.lineSeparator()
                + "Penalties: " + athletePenalties + System.lineSeparator();
    }


}

