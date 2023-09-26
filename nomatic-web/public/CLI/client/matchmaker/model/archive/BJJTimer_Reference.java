package com.rayala30.nomatic.client.matchmaker.model.archive;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class BJJTimer_Reference extends JFrame {
    private int totalRounds;
    private int roundDurationInSeconds;
    private int currentRound;
    private int secondsLeft;
    private boolean timerCompleted;

    private JLabel roundLabel;
    private JLabel timerLabel;
    private Timer timer;
    private boolean isPaused;

    public BJJTimer_Reference(int totalRounds, int roundDurationInSeconds) {
        this.totalRounds = totalRounds;
        this.roundDurationInSeconds = roundDurationInSeconds;
        this.currentRound = 1;
        this.secondsLeft = roundDurationInSeconds;
        this.timerCompleted = false;

        // Initialize pause state
        isPaused = false;
        // Add key listener to the frame to handle spacebar for pause and resume
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    togglePauseResume();
                }
            }
        });

        // Ensure the frame is focusable to capture key events
        setFocusable(true);

        roundLabel = new JLabel("ROUND " + currentRound);
        roundLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        roundLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(roundLabel, BorderLayout.NORTH);

        timerLabel = new JLabel(formatTime(secondsLeft));
        timerLabel.setFont(new Font("Arial", Font.PLAIN, 36));
        timerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(timerLabel, BorderLayout.CENTER);

        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (secondsLeft > 0) {
                    secondsLeft--;
                    timerLabel.setText(formatTime(secondsLeft));
                } else {
                    if (currentRound < totalRounds) {
                        currentRound++;
                        secondsLeft = roundDurationInSeconds;
                        roundLabel.setText("ROUND " + currentRound);
                    } else {
                        timer.stop();
                        timerCompleted = true;
                    }
                }
            }
        });

        timer.start();

        setTitle("Match Timer");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void togglePauseResume() {
        if (!timerCompleted) {
            if (isPaused) {
                // Resume the timer
                timer.start();
                isPaused = false;
            } else {
                // Pause the timer
                timer.stop();
                isPaused = true;
            }
        }
    }

    public boolean isTimerCompleted() {
        return timerCompleted;
    }

    private String formatTime(int seconds) {
        int minutes = seconds / 60;
        int remainingSeconds = seconds % 60;
        return String.format("%02d:%02d", minutes, remainingSeconds);
    }
}
