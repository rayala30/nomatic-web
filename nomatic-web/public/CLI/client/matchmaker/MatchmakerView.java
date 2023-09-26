package com.rayala30.nomatic.client.matchmaker;

/*
LiveMatchView is a class that the LiveMatchController uses for gathering athlete information from the user
and presenting match information to the user. It requires an object that implements the BasicConsole interface
to handle the mechanics of reading from and writing to the console.
 */

import com.rayala30.nomatic.client.matchmaker.util.BasicConsole;

// TODO update with color UI

public class MatchmakerView {

    // initialize BasicConsole
    private final BasicConsole console;

    // create constructor
    public MatchmakerView(BasicConsole console) {
        this.console = console;
    }

    public String promptForFileName() {
        return console.promptForString("Enter the file name: ");
    }

    public String promptForValue(String messagePrompt) {
        return console.promptForString(messagePrompt);
    }

    public void printMessage(String message) {
        console.printMessage(message);
    }

    public void printErrorMessage(String message) {
        console.printErrorMessage(message);
    }

    public void printDivider() {
        console.printDivider();
    }

    public String getMenuSelection(String menuTitle, String[] options) {
        console.printBanner(menuTitle);
        return console.getMenuSelection(options);
    }

    public boolean promptForYesNo(String prompt) {
        return console.promptForYesNo(prompt);
    }

    public int promptForInteger(String prompt) {
        return console.promptForInteger(prompt);
    }

    public void promptToUpdateWeight() {
        console.printMessage(""); // Empty line
        console.printMessage("Select weight division.");
    }

    public void promptToUpdateGender() {
        console.printMessage(""); // Empty line
        console.printMessage("Select gender division.");
    }

    public void promptToUpdateAge() {
        console.printMessage(""); // Empty line
        console.printMessage("Select age division.");
    }

    public void promptToUpdateBelt() {
        console.printMessage(""); // Empty line
        console.printMessage("Select belt division.");
    }

    public String promptToUpdateAthleteOne() {
        String athleteOnePrompt = console.promptForString("Enter Athlete One name (First Last): ");
        return athleteOnePrompt;
    }

    public String promptToUpdateAthleteTwo() {
        String athleteTwoPrompt = console.promptForString("Enter Athlete Two name (First Last): ");
        return athleteTwoPrompt;
    }

    public void promptToSelectWinner() {
        console.printMessage(""); // Empty line
        console.printMessage("Select match winner.");
    }

    public void promptToUpdateMatchLength() {
        console.printMessage(""); // Empty line
        console.printMessage("Select match length.");
    }

    public void promptForMatchAction() {
        console.printMessage("");
        console.printMessage("Choose match action: ");
    }

    public void promptForPointAction() {
        console.printMessage("");
        console.printMessage("Select point type: ");
    }

    public void promptForPointReview() {
        console.printMessage("");
        console.printMessage("Choose category to review: ");
    }

}
