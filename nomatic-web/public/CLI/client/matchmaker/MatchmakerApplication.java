package com.rayala30.nomatic.client.matchmaker;


import com.rayala30.nomatic.client.matchmaker.util.SystemInOutConsole;

/*
MatchMaker_main is the class that launches the LiveMatch by creating the objects needed to interact with the user and
file system and passing them to the application's controller object
 */
public class MatchmakerApplication {

    public static void main(String[] args) {
        SystemInOutConsole systemInOutConsole = new SystemInOutConsole();

        MatchmakerController controller = new MatchmakerController(systemInOutConsole);

        controller.run();

    }
}