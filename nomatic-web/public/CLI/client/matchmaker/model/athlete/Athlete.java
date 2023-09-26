package com.rayala30.nomatic.client.matchmaker.model.athlete;

public class Athlete extends Biographic {

    private int athleteId;

    // Instance Variables
    private Belt belt;
    private Weight weight;

    // NOTE: When athletes are read, the DAO will join the match table and pull match wins, losses, and submissions
    // to save an additional lookup later. When you display an athlete, you want to see athlete match stats
    private int totalWins;
    private int totalLosses;
    private int bySubmissions;

    private int byDisqualifications;
    private int byPoints;
    private String affiliation;

    // Need to create separate "group" variables in order to extract data from database and assign them to Athlete attributes
    private String ageGroup;


    // Constructors
    public Athlete(String name, int age, String gender, Belt belt, Weight weight) {
        super(name, age, gender);
        this.belt = belt;
        this.weight = weight;
    }

    public Athlete(int athleteId, String name, String affiliation, String gender, int age, Belt belt, Weight weight,
                   int totalWins, int totalLosses, int bySubmissions, int byDisqualifications, int byPoints) {
        super(name, age, gender);
        this.athleteId = athleteId;
        this.belt = belt;
        this.weight = weight;
        this.totalWins = totalWins;
        this.totalLosses = totalLosses;
        this.bySubmissions = bySubmissions;
        this.byDisqualifications = byDisqualifications;
        this.byPoints = byPoints;
        this.affiliation = affiliation;
    }

    public Athlete(String name) {
        super(name);
    }

    public Athlete() {
        super();
    }

    // Getters

    public int getAthleteId() {
        return athleteId;
    }

    public String getAgeGroup() {
        return ageGroup;
    }

    public Belt getBelt() {
        return belt;
    }

    public String getAffiliation() {
        return affiliation;
    }

    public Weight getWeight() {
        return weight;
    }

    public int getTotalWins() {
        return totalWins;
    }

    public int getTotalLosses() {
        return totalLosses;
    }

    public int getBySubmissions() {
        return bySubmissions;
    }

    public int getByDisqualifications() {
        return byDisqualifications;
    }

    public int getByPoints() {
        return byPoints;
    }


    // Setters
    public void setAthleteId(int athleteId) {
        this.athleteId = athleteId;
    }

    public void setTotalWins(int totalWins) {
        this.totalWins = totalWins;
    }

    public void setTotalLosses(int totalLosses) {
        this.totalLosses = totalLosses;
    }

    public void setBySubmissions(int bySubmissions) {
        this.bySubmissions = bySubmissions;
    }

    public void setByDisqualifications(int byDisqualifications) {
        this.byDisqualifications = byDisqualifications;
    }

    public void setByPoints(int byPoints) {
        this.byPoints = byPoints;
    }

    public void setAffiliation(String affiliation) {
        this.affiliation = affiliation;
    }

    public void setToAgeGroup(int age) {
        String ageGroup;
        if (age < 18) {
            ageGroup = "Juvenile";
        } else if (age >= 18 && age < 30) {
            ageGroup = "Adult";
        } else {
            ageGroup = "Masters";
        }
        this.ageGroup = ageGroup;
    }

    public void setToWeightClass(double weight) {

        // Need Age and Gender before determining weight class
        boolean isJuvenileGroup = ageGroup.equalsIgnoreCase("Juvenile");
        boolean isAdultGroup = ageGroup.equalsIgnoreCase("Adult");
        boolean isMastersGroup = ageGroup.equalsIgnoreCase("Masters");
        boolean isMale = getGender().equalsIgnoreCase("Male");
        boolean isFemale = getGender().equalsIgnoreCase("Female");

        // WEIGHT CLASSES FOR JUVENILE AGE
        if (isJuvenileGroup) {
            if (isMale) {
                if (weight <= 118.0) {
                    this.weight = Weight.Roosterweight;
                }
                else if (weight > 118.0 && weight <= 129.0) {
                    this.weight = Weight.Light_Featherweight;
                }
                else if (weight > 129.0 && weight <= 141.6) {
                    this.weight = Weight.Featherweight;
                }
                else if (weight > 141.6 && weight <= 152.6) {
                    this.weight = Weight.Lightweight;
                }
                else if (weight > 152.6 && weight <= 163.6) {
                    this.weight = Weight.Middleweight;
                }
                else if (weight > 163.6 && weight <= 175.0) {
                    this.weight = Weight.Medium_Heavyweight;
                }
                else if (weight > 175.0 && weight <= 186.0) {
                    this.weight = Weight.Heavyweight;
                }
                else if (weight > 186.0 && weight <= 197.0) {
                    this.weight = Weight.Super_Heavyweight;
                }
                else {
                    this.weight = Weight.Ultra_Heavyweight;
                }
            }

            if (isFemale) {
                if (weight <= 98.0) {
                    this.weight = Weight.Roosterweight;
                }
                else if (weight > 98.0 && weight <= 106.6) {
                    this.weight = Weight.Light_Featherweight;
                }
                else if (weight > 106.6 && weight <= 116.0) {
                    this.weight = Weight.Featherweight;
                }
                else if (weight > 116.0 && weight <= 125.0) {
                    this.weight = Weight.Lightweight;
                }
                else if (weight > 125.0 && weight <= 133.6) {
                    this.weight = Weight.Middleweight;
                }
                else if (weight > 133.6 && weight <= 143.6) {
                    this.weight = Weight.Medium_Heavyweight;
                }
                else if (weight > 143.6 && weight <= 152.0) {
                    this.weight = Weight.Heavyweight;
                }
                else {
                    this.weight = Weight.Super_Heavyweight;
                }
            }
        }

        // WEIGHT CLASSES FOR ADULT & MASTERS AGE
        if (isAdultGroup || isMastersGroup) {
            if (isMale) {
                if (weight <= 127.0) {
                    this.weight = Weight.Roosterweight;
                }
                else if (weight > 127.0 && weight <= 141.6) {
                    this.weight = Weight.Light_Featherweight;
                }
                else if (weight > 141.6 && weight <= 154.6) {
                    this.weight = Weight.Featherweight;
                }
                else if (weight > 154.6 && weight <= 168.0) {
                    this.weight = Weight.Lightweight;
                }
                else if (weight > 168.0 && weight <= 181.6) {
                    this.weight = Weight.Middleweight;
                }
                else if (weight > 181.6 && weight <= 195.0) {
                    this.weight = Weight.Medium_Heavyweight;
                }
                else if (weight > 195.0 && weight <= 208.0) {
                    this.weight = Weight.Heavyweight;
                }
                else if (weight > 208.0 && weight <= 222.0) {
                    this.weight = Weight.Super_Heavyweight;
                }
                else {
                    this.weight = Weight.Ultra_Heavyweight;
                }
            }

            else if (isFemale) {
                if (weight <= 108.0) {
                    this.weight = Weight.Roosterweight;
                }
                else if (weight > 108.0 && weight <= 118.0) {
                    this.weight = Weight.Light_Featherweight;
                }
                else if (weight > 118.0 && weight <= 129.0) {
                    this.weight = Weight.Featherweight;
                }
                else if (weight > 129.0 && weight <= 141.6) {
                    this.weight = Weight.Lightweight;
                }
                else if (weight > 141.6 && weight <= 152.6) {
                    this.weight = Weight.Middleweight;
                }
                else if (weight > 152.6 && weight <= 163.6) {
                    this.weight = Weight.Medium_Heavyweight;
                }
                else if (weight > 163.6 && weight <= 175.0) {
                    this.weight = Weight.Heavyweight;
                }
                else {
                    this.weight = Weight.Super_Heavyweight;
                }
            }

        }

    }


    public void setToBeltRank(String belt) {
        if (belt.equalsIgnoreCase("White")) {
            this.belt = Belt.White;
        }
        else if (belt.equalsIgnoreCase("Blue")) {
            this.belt = Belt.Blue;
        }
        else if (belt.equalsIgnoreCase("Purple")) {
            this.belt = Belt.Purple;
        }
        else if (belt.equalsIgnoreCase("Brown")) {
            this.belt = Belt.Brown;
        }
        else if (belt.equalsIgnoreCase("Black")) {
            this.belt = Belt.Black;
        }
    }


    // Methods

    public String displayAthleteInformation() {
        return "Athlete Information -  " + System.lineSeparator() +
                "Name: " + getName() + System.lineSeparator() +
                "Age: " + getAge() + System.lineSeparator() +
                "Gender: " + getGender() + System.lineSeparator() +
                "Belt: " + belt + System.lineSeparator();
    }

}
