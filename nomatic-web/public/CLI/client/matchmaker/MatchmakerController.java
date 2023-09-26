package com.rayala30.nomatic.client.matchmaker;

import com.rayala30.nomatic.client.matchmaker.model.BJJScoreboardTimer;
import com.rayala30.nomatic.client.matchmaker.model.Match;
import com.rayala30.nomatic.client.matchmaker.model.athlete.Athlete;
import com.rayala30.nomatic.client.matchmaker.model.athlete.Belt;
import com.rayala30.nomatic.client.matchmaker.model.athlete.Weight;
import com.rayala30.nomatic.client.matchmaker.util.BasicConsole;
import com.rayala30.nomatic.client.matchmaker.util.*;


import java.time.LocalDate;

public class MatchmakerController {

    // Instance variables
    private final MatchmakerView view;




    // Constructor
    public MatchmakerController(BasicConsole console) {
        view = new MatchmakerView(console);
    }

    // Methods

    public void run() {
        displayStartingMenu();
    }


    private void displayStartingMenu() {
        final String WELCOME_MESSAGE = "Welcome to No-MAT-ic!";

        final String MATCHMAKER = "Access MATchmaker";
        final String LOAD_DB = "Access No-MAT-ic database";
        final String OPEN_MATCH = "Access OpenMATch program";
        final String EXIT = "Exit No-MAT-ic";     // use System.exit(0) for EXIT option?
        final String[] MENU_OPTIONS = {MATCHMAKER, LOAD_DB, EXIT};

        boolean finished = false;

        while(!finished) {
            String selection = view.getMenuSelection(WELCOME_MESSAGE, MENU_OPTIONS);

            if (selection.equals(MATCHMAKER)) {
                // Initialize currentMatch and athletes here
                view.printMessage("Initializing match set-up menu.");
                Match currentMatch = displayMatchSetupMenu();
                Athlete currentMatchAthleteOne = currentMatch.getAthleteOne();
                Athlete currentMatchAthleteTwo = currentMatch.getAthleteTwo();
                // Run and start match here
                runMatch(currentMatch, currentMatchAthleteOne, currentMatchAthleteTwo);
                // Run post match menu after match completes
                postMatchMenu(currentMatch);
            } else if (selection.equals(LOAD_DB)) {
                loadMatchDatabase();
            } else if (selection.equals(OPEN_MATCH)) {
                displayOpenMatSelectionMenu();
            } else {
                finished = true;
            }
        }
    }

    // TODO
    private void displayOpenMatSelectionMenu() {
        // Setup open match menu - If selected RUN openmatch Application
        // Option 1 = Available openmat event selection menu
        // Option 2 = Free-for-all (No Openmat)

        // create a RUN openmatch application method
    }

    private Match displayMatchSetupMenu() {
        // Initialize match
        Match currentMatch = new Match(); // Empty match values until setup complete
        // Prompt for Belt division
        Belt matchBelt = beltSetupMenu();
        currentMatch.setMatchBeltObject(matchBelt);
        // Prompt for Gender division
        String matchGender = genderSetupMenu();
        currentMatch.setMatchGender(matchGender);
        // Prompt for Age division
        String matchAge = ageSetupMenu();
        currentMatch.setMatchAge(matchAge);
        // Prompt for Weight division
        Weight matchWeight = weightSetUpMenu();
        currentMatch.setMatchWeightObject(matchWeight);
        // Prompt for Time
        int matchLength = timeSetupMenu();
        currentMatch.setMatchLength(matchLength);

        // Prompt for Athlete One
        Athlete athleteOne = athleteOneSetup(); // Create method and call service layer methods here?
        // TODO if there are existing athletes, create a separate method to pull or modify athleteOneSetup
        // Prompt for Athlete Two
        Athlete athleteTwo = athleteTwoSetup();

        // TODO modify Match constructor to get correct match parameters for DAO methods on MatchService to work
        // Set current match
        currentMatch = new Match(athleteOne, athleteTwo, matchBelt, matchWeight, matchAge, matchGender, matchLength);
        // Display currentMatch Information
        view.printMessage("");
        view.printMessage("Setting up match.");
        view.printMessage("");
        view.printMessage("MATCH SET FOR " + matchAge.toUpperCase() + " " + matchGender.toUpperCase() + " " + matchBelt.toString().toUpperCase() + " BELT DIVISION AT " + matchWeight.toString().toUpperCase() + "." );
        view.printMessage(athleteOne.getName().toUpperCase() + " VS. " + athleteTwo.getName().toUpperCase());
        view.printMessage("");

        return currentMatch;
    }

    private void runMatch(Match currentMatch, Athlete athleteOne, Athlete athleteTwo) {
        // Set default points
        currentMatch.setAthleteOnePoints(0);
        currentMatch.setAthleteOnePoints(0);
        // Set default advantages
        currentMatch.setAthleteOneAdv(0);
        currentMatch.setAthleteTwoAdv(0);
        // Set default penalties
        currentMatch.setAthleteOnePenalty(0);
        currentMatch.setAthleteTwoPenalty(0);

        // Create new instance of BJJ timer
        int lengthOfRound = currentMatch.getMatchLength();

        final String SUBMISSION = "Submission";
        final String DISQUALIFICATION = "Disqualification";
        final String TIMER_END = "End match";

        final String[] MATCH_OPTIONS = {SUBMISSION, DISQUALIFICATION, TIMER_END};
        boolean matchOngoing = true;

        // SCOREBOARD & TIMER WILL NEED TO BE RUN ON SEPARATE JFRAME WINDOW
        BJJScoreboardTimer matchTimer = new BJJScoreboardTimer(lengthOfRound, currentMatch.getAthleteOne().getName(),
                currentMatch.getAthleteTwo().getName());

        while (matchOngoing) {

            final String[] ATHLETE_OPTIONS = {athleteOne.getName(), athleteTwo.getName()};

            view.promptForMatchAction();
            String action = view.getMenuSelection("MATCH ACTIONS", MATCH_OPTIONS);

            if (action.equals(SUBMISSION)) {
                matchTimer.setTimerCompleted(true);
                matchTimer.stopMatchTimer();
                // Athlete selection option
                String athleteSelection = view.getMenuSelection("ATHLETE SELECTION", ATHLETE_OPTIONS);

                view.printMessage("Submission win: ");
                if (athleteSelection.equals(athleteOne.getName())) {
                    view.printMessage(athleteOne.getName().toUpperCase() + " WINS!");
                    view.printMessage("Match over.");
                    currentMatch.setMatchWinner(athleteOne.getName());
                    currentMatch.setMatchWinnerId(athleteOne.getAthleteId());

                    currentMatch.setMatchWinMethod("Submission");

                    currentMatch.setMatchLoser(athleteTwo.getName());
                    currentMatch.setMatchLoserId(athleteTwo.getAthleteId());
                    matchOngoing = false;
                } else {
                    view.printMessage(athleteTwo.getName().toUpperCase() + " WINS!");
                    view.printMessage("Match over.");
                    currentMatch.setMatchWinner(athleteTwo.getName());
                    currentMatch.setMatchWinnerId(athleteTwo.getAthleteId());

                    currentMatch.setMatchWinMethod("Submission");

                    currentMatch.setMatchLoser(athleteOne.getName());
                    currentMatch.setMatchLoserId(athleteOne.getAthleteId());
                    matchOngoing = false;
                }
            } else if (action.equals(DISQUALIFICATION)) {
                matchTimer.setTimerCompleted(true);
                matchTimer.stopMatchTimer();
                // Athlete selection option
                String athleteSelection = view.getMenuSelection("ATHLETE SELECTION", ATHLETE_OPTIONS);

                view.printMessage("Disqualification for: " + athleteOne.getName());
                if (athleteSelection.equals(athleteOne.getName())) {
                    view.printMessage(athleteTwo.getName().toUpperCase() + " WINS!");
                    view.printMessage("Match over.");
                    currentMatch.setMatchWinner(athleteTwo.getName());
                    currentMatch.setMatchWinnerId(athleteTwo.getAthleteId());

                    currentMatch.setMatchWinMethod("Opponent DQ");

                    currentMatch.setMatchLoser(athleteOne.getName());
                    currentMatch.setMatchLoserId(athleteOne.getAthleteId());
                    matchOngoing = false;
                } else {
                    view.printMessage(athleteOne.getName().toUpperCase() + " WINS!");
                    view.printMessage("Match over.");
                    currentMatch.setMatchWinner(athleteOne.getName());
                    currentMatch.setMatchWinnerId(athleteOne.getAthleteId());

                    currentMatch.setMatchWinMethod("Opponent DQ");

                    currentMatch.setMatchLoser(athleteTwo.getName());
                    currentMatch.setMatchLoserId(athleteTwo.getAthleteId());
                    matchOngoing = false;
                }
            } else {
                matchTimer.setTimerCompleted(true);
                matchOngoing = false;
                view.printMessage("Match timer end!");
            }
        }
        // Get points from Scoreboard
        int athleteOnePoints = matchTimer.getScore(1);
        int athleteOneAdv = matchTimer.getAdvantages(1);
        int athleteOnePenalty = matchTimer.getPenalties(1);

        int athleteTwoPoints = matchTimer.getScore(2);
        int athleteTwoAdv = matchTimer.getAdvantages(2);
        int athleteTwoPenalty = matchTimer.getPenalties(2);

        // Close Scoreboard once match ends
        matchTimer.closeScoreboardTimer();

        // Once winner by overall score review is determined
        determineWinnerAtTimerEnd(currentMatch, athleteOnePoints, athleteOneAdv, athleteOnePenalty, athleteTwoPoints, athleteTwoAdv, athleteTwoPenalty);
    }

    private void determineWinnerAtTimerEnd(Match match, int athleteOnePts, int athleteOneAdv, int athleteOnePen, int athleteTwoPts,
                                           int athleteTwoAdv, int athleteTwoPen) {
        if (athleteOnePts == athleteTwoPts) {
            if (athleteOneAdv == athleteTwoAdv) {
                if (athleteOnePen == athleteTwoPen) {
                    view.printMessage("Match result by referee decision");
                    view.promptToSelectWinner();
                    // Prompt to select winner
                    final String[] ATHLETE_OPTIONS = {match.getAthleteOne().getName(), match.getAthleteTwo().getName()};
                    String athleteSelection = view.getMenuSelection("ATHLETE SELECTION", ATHLETE_OPTIONS);

                    if (athleteSelection.equals(match.getAthleteOne().getName())) {
                        // Set winner
                        match.setMatchWinnerId(match.getAthleteOneId());
                        match.setMatchWinner(match.getAthleteOne().getName());
                        // Set loser
                        match.setMatchLoserId(match.getAthleteTwoId());
                        match.setMatchLoser(match.getAthleteTwo().getName());
                    } else {
                        // Set winner
                        match.setMatchWinnerId(match.getAthleteTwoId());
                        match.setMatchWinner(match.getAthleteTwo().getName());
                        // Set loser
                        match.setMatchLoserId(match.getAthleteOneId());
                        match.setMatchLoser(match.getAthleteOne().getName());
                    }
                } else {
                    if (athleteOnePen > athleteTwoPen) {
                        // Set winner
                        match.setMatchWinnerId(match.getAthleteTwoId());
                        match.setMatchWinner(match.getAthleteTwo().getName());
                        // Set loser
                        match.setMatchLoserId(match.getAthleteOneId());
                        match.setMatchLoser(match.getAthleteOne().getName());
                    } else {
                        // Set winner
                        match.setMatchWinnerId(match.getAthleteOneId());
                        match.setMatchWinner(match.getAthleteOne().getName());
                        // Set loser
                        match.setMatchLoserId(match.getAthleteTwoId());
                        match.setMatchLoser(match.getAthleteTwo().getName());
                    }
                }
            }
            else {
                if (athleteOneAdv > athleteTwoAdv) {
                    // Set winner
                    match.setMatchWinnerId(match.getAthleteOneId());
                    match.setMatchWinner(match.getAthleteOne().getName());
                    // Set loser
                    match.setMatchLoserId(match.getAthleteTwoId());
                    match.setMatchLoser(match.getAthleteTwo().getName());
                } else {
                    // Set winner
                    match.setMatchWinnerId(match.getAthleteTwoId());
                    match.setMatchWinner(match.getAthleteTwo().getName());
                    // Set loser
                    match.setMatchLoserId(match.getAthleteOneId());
                    match.setMatchLoser(match.getAthleteOne().getName());
                }
            }
        }
        else {
            if (athleteOnePts > athleteTwoPts) {
                // Set winner
                match.setMatchWinnerId(match.getAthleteOneId());
                match.setMatchWinner(match.getAthleteOne().getName());
                // Set loser
                match.setMatchLoserId(match.getAthleteTwoId());
                match.setMatchLoser(match.getAthleteTwo().getName());
            } else {
                // Set winner
                match.setMatchWinnerId(match.getAthleteTwoId());
                match.setMatchWinner(match.getAthleteTwo().getName());
                // Set loser
                match.setMatchLoserId(match.getAthleteOneId());
                match.setMatchLoser(match.getAthleteOne().getName());
            }
        }
    }

    private void postMatchMenu(Match match) {
        final String SAVE = "Save this match";
        final String NEXT = "Create next match";
        final String EXIT = "Exit MatchMaker";
        final String[] POST_OPTIONS = {SAVE, NEXT, EXIT};

        String selection = view.getMenuSelection("POST-MATCH ACTIONS", POST_OPTIONS);

        if (selection.equals(SAVE)) {
            saveMatch(match);
        } else if (selection.equals(NEXT)) {
            // Initialize currentMatch and athletes here
            view.printMessage("Initializing match set-up menu.");
            Match currentMatch = displayMatchSetupMenu();
            Athlete currentMatchAthleteOne = currentMatch.getAthleteOne();
            Athlete currentMatchAthleteTwo = currentMatch.getAthleteTwo();
            // Run and start match here
            runMatch(currentMatch, currentMatchAthleteOne, currentMatchAthleteTwo);
            // Run post match menu
            // After match completes, run postMatchMenu
            postMatchMenu(currentMatch);
        } else {
            view.printMessage("Program closing.");
            System.exit(0);
        }
    }

    private void saveMatch(Match savedMatch) {
        // TODO saveMatch not working until database is configured

        // Match winners and losers are set during match end
        savedMatch.setPublic(view.promptForYesNo("Should this be a public match? (Y or N) "));
        savedMatch.setMatchDate(LocalDate.now());
        savedMatch.setLocation(view.promptForValue("Please enter a match location: "));

        // Principal principalAthleteOne = (Principal) savedMatch.getAthleteOne();
        // Principal principalAthleteTwo = (Principal) savedMatch.getAthleteTwo();

        // matchService.addMatch(savedMatch, principalAthleteOne, principalAthleteTwo);
        // matchService.updateBlankMatch(savedMatch);
    }

    // TODO loadMatchDatabase
    private void loadMatchDatabase() {
        // MatchService to be used for database access
        final String SEARCH_ALL_PUBLIC = "Search all public matches";
        final String SEARCH_BY_ID = "Search match by ID";
        final String SEARCH_BY_ATHLETE_ID = "Search matches by Athlete ID";

        final String[] SEARCH_OPTIONS = {SEARCH_ALL_PUBLIC, SEARCH_BY_ID, SEARCH_BY_ATHLETE_ID};
        String selection = view.getMenuSelection("SEARCH OPTIONS", SEARCH_OPTIONS);


        // Integrate MatchService class here
    }

    private Athlete athleteOneSetup() {
        // TODO update once User Authentication classes are completed
        // Athlete user information will be extracted within this method

        String name = view.promptToUpdateAthleteOne();
        return new Athlete(name);
    }

    private Athlete athleteTwoSetup() {
        // TODO update once User Authentication classes are completed
        // Athlete user information will be extracted within this method

        String name = view.promptToUpdateAthleteTwo();
        return new Athlete(name);
    }

    private Weight weightSetUpMenu() {
        Weight weightDivision = null;
        view.promptToUpdateWeight();

        final String ROOSTERWEIGHT = Weight.Roosterweight.toString();
        final String LIGHT_FEATHERWEIGHT = Weight.Light_Featherweight.toString().replaceAll("_", "-");
        final String FEATHERWEIGHT = Weight.Featherweight.toString();
        final String LIGHTWEIGHT = Weight.Lightweight.toString();
        final String MIDDLEWEIGHT = Weight.Middleweight.toString();
        final String MEDIUM_HEAVYWEIGHT = Weight.Medium_Heavyweight.toString().replaceAll("_", "-");
        final String HEAVYWEIGHT = Weight.Heavyweight.toString();
        final String SUPER_HEAVYWEIGHT = Weight.Super_Heavyweight.toString().replaceAll("_", "-");
        final String ULTRA_HEAVYWEIGHT = Weight.Ultra_Heavyweight.toString().replaceAll("_", "-");
        final String OPEN_WEIGHT = Weight.Open_Weight.toString().replaceAll("_", "-");

        final String[] WEIGHT_OPTIONS = {ROOSTERWEIGHT, LIGHT_FEATHERWEIGHT, FEATHERWEIGHT, LIGHTWEIGHT, MIDDLEWEIGHT,
                MEDIUM_HEAVYWEIGHT, HEAVYWEIGHT, SUPER_HEAVYWEIGHT, ULTRA_HEAVYWEIGHT, OPEN_WEIGHT
        };

        String selection = view.getMenuSelection("WEIGHT DIVISIONS", WEIGHT_OPTIONS);

        if (selection.equals(ROOSTERWEIGHT)) {
            weightDivision = Weight.Roosterweight;
            view.printMessage("Weight division set to Roosterweight.");
        } else if (selection.equals(LIGHT_FEATHERWEIGHT)) {
            weightDivision = Weight.Light_Featherweight;
            view.printMessage("Weight division set to Light-Featherweight.");
        } else if (selection.equals(FEATHERWEIGHT)) {
            weightDivision = Weight.Featherweight;
            view.printMessage("Weight division set to Featherweight.");
        } else if (selection.equals(LIGHTWEIGHT)) {
            weightDivision = Weight.Lightweight;
            view.printMessage("Weight division set to Lightweight.");
        } else if (selection.equals(MIDDLEWEIGHT)) {
            weightDivision = Weight.Middleweight;
            view.printMessage("Weight division set to Middleweight.");
        } else if (selection.equals(MEDIUM_HEAVYWEIGHT)) {
            weightDivision = Weight.Medium_Heavyweight;
            view.printMessage("Weight division set to Medium-Heavyweight.");
        } else if (selection.equals(HEAVYWEIGHT)) {
            weightDivision = Weight.Heavyweight;
            view.printMessage("Weight division set to Heavyweight.");
        } else if (selection.equals(SUPER_HEAVYWEIGHT)) {
            weightDivision = Weight.Super_Heavyweight;
            view.printMessage("Weight division set to Super-Heavyweight.");
        } else if (selection.equals(ULTRA_HEAVYWEIGHT)) {
            weightDivision = Weight.Ultra_Heavyweight;
            view.printMessage("Weight division set to Ultra-Heavyweight.");
        } else if (selection.equals(OPEN_WEIGHT)) {
            weightDivision = Weight.Open_Weight;
            view.printMessage("Weight division set to Open-Weight.");
        }

        return weightDivision;
    }

    private Belt beltSetupMenu() {
        Belt beltDivision = null;
        view.promptToUpdateBelt();

        final String WHITE_BELT = Belt.White.toString();
        final String BLUE_BELT = Belt.Blue.toString();
        final String PURPLE_BELT = Belt.Purple.toString();
        final String BROWN_BELT = Belt.Brown.toString();
        final String BLACK_BELT = Belt.Black.toString();

        final String[] BELT_OPTIONS = {WHITE_BELT, BLUE_BELT, PURPLE_BELT, BROWN_BELT, BLACK_BELT};

        String selection = view.getMenuSelection("BELT DIVISIONS", BELT_OPTIONS);

        if (selection.equals(WHITE_BELT)) {
            beltDivision = Belt.White;
            view.printMessage("Belt division set to White.");
        }
        else if (selection.equals(BLUE_BELT)) {
            beltDivision = Belt.Blue;
            view.printMessage("Belt division set to Blue.");
        }
        else if (selection.equals(PURPLE_BELT)) {
            beltDivision = Belt.Purple;
            view.printMessage("Belt division set to Purple.");
        }
        else if (selection.equals(BROWN_BELT)) {
            beltDivision = Belt.Brown;
            view.printMessage("Belt division set to Brown.");
        }
        else if (selection.equals(BLACK_BELT)) {
            beltDivision = Belt.Black;
            view.printMessage("Belt division set to Black.");
        }

        return beltDivision;
    }

    private String ageSetupMenu() {
        String ageDivision = "";
        view.promptToUpdateAge();

        final String JUVENILE_DIVISION = "Juvenile";
        final String ADULT_DIVISION = "Adult";
        final String MASTERS_DIVISION = "Masters";
        final String[] AGE_DIVISIONS = {JUVENILE_DIVISION, ADULT_DIVISION, MASTERS_DIVISION};

        String selection = view.getMenuSelection("AGE DIVISIONS", AGE_DIVISIONS);

        if (selection.equals(JUVENILE_DIVISION)) {
            ageDivision = JUVENILE_DIVISION;
            view.printMessage("Age division set to Juvenile.");
        } else if (selection.equals(ADULT_DIVISION)) {
            ageDivision = ADULT_DIVISION;
            view.printMessage("Age division set to Adult.");
        } else if (selection.equals(MASTERS_DIVISION)) {
            ageDivision = MASTERS_DIVISION;
            view.printMessage("Age division set to Masters");
        }

        return ageDivision;
    }

    private String genderSetupMenu() {
        String genderDivision;
        view.promptToUpdateGender();

        final String MALE_DIVISION = "Male";
        final String FEMALE_DIVISION = "Female";

        final String[] GENDER_OPTIONS = {MALE_DIVISION, FEMALE_DIVISION};

        String selection = view.getMenuSelection("GENDER DIVISIONS", GENDER_OPTIONS);

        if (selection.equals(MALE_DIVISION)) {
            genderDivision = MALE_DIVISION;
            view.printMessage("Gender division set to Male.");
        } else {
            genderDivision = FEMALE_DIVISION;
            view.printMessage("Gender division set to Female.");
        }

        return genderDivision;
    }

    private int timeSetupMenu() {
        // timerLength is in seconds
        int timerLength = 0;
        view.promptToUpdateMatchLength();

        final String FIVE = "5:00";
        final String SIX = "6:00";
        final String SEVEN = "7:00";
        final String EIGHT = "8:00";
        final String TEN = "10:00";
        final String[] TIME_OPTIONS = {FIVE, SIX, SEVEN, EIGHT, TEN};

        String selection = view.getMenuSelection("MATCH LENGTH", TIME_OPTIONS);

        if (selection.equals(FIVE)) {
            timerLength = 300;
            view.printMessage("Match set for 5:00.");
        } else if (selection.equals(SIX)) {
            timerLength = 360;
            view.printMessage("Match set for 6:00.");
        } else if (selection.equals(SEVEN)) {
            timerLength = 420;
            view.printMessage("Match set for 7:00.");
        } else if (selection.equals(EIGHT)) {
            timerLength = 480;
            view.printMessage("Match set for 8:00.");
        } else if (selection.equals(TEN)) {
            timerLength = 600;
            view.printMessage("Match set for 10:00.");
        }

        return timerLength;
    }

}
