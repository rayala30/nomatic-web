package com.rayala30.nomatic.client.matchmaker.model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class BJJScoreboardTimer extends JFrame {
    // TODO Create Stop/Resume Buttons for ScoreboardTimer



    // Scoreboard Instance Variables
    private JLabel competitor1Label;
    private JLabel competitor2Label;
    private int competitor1Points;
    private int competitor2Points;
    private int competitor1Advantages;
    private int competitor2Advantages;
    private int competitor1Penalties;
    private int competitor2Penalties;

    // Timer Instance Variables
    private int roundDurationInSeconds;
    private int secondsLeft;
    private boolean timerCompleted;
    private JLabel timerLabel;
    private Timer timer;
    private boolean isPaused;

    public void setTimerCompleted(boolean timerCompleted) {
        this.timerCompleted = timerCompleted;
    }

    // Constructor
    public BJJScoreboardTimer(int roundDurationInSeconds, String athleteOneName, String athleteTwoName) {
        this.roundDurationInSeconds = roundDurationInSeconds;
        this.secondsLeft = roundDurationInSeconds;
        this.timerCompleted = false;
        //Initialize timer pause state
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

        // Timer labels
        timerLabel = new JLabel(formatTime(secondsLeft));
        timerLabel.setFont(new Font("Arial", Font.PLAIN, 36));
        timerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(timerLabel, BorderLayout.CENTER);

        // Competitor labels
        competitor1Label = new JLabel(athleteOneName);
        competitor1Label.setFont(new Font("Arial", Font.BOLD, 18));
        competitor1Label.setHorizontalAlignment(SwingConstants.CENTER);

        competitor2Label = new JLabel(athleteTwoName);
        competitor2Label.setFont(new Font("Arial", Font.BOLD, 18));
        competitor2Label.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(5, 3));
        mainPanel.add(new JLabel()); // Empty cell
        mainPanel.add(competitor1Label);
        mainPanel.add(competitor2Label);
        // Points Panel
        mainPanel.add(new JLabel("POINTS: "));
        mainPanel.add(createPointsPanel(1));
        mainPanel.add(createPointsPanel(2));
        // Advantages Panel
        mainPanel.add(new JLabel("ADVANTAGES: "));
        mainPanel.add(createAdvantagesPanel(1));
        mainPanel.add(createAdvantagesPanel(2));
        // Penalties Panel
        mainPanel.add(new JLabel("PENALTIES: "));
        mainPanel.add(createPenaltiesPanel(1));
        mainPanel.add(createPenaltiesPanel(2));
        // Timer Panel
        mainPanel.add(new JLabel("TIME: "));
        mainPanel.add(timerLabel);

        add(mainPanel);


        // Timer Start
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (secondsLeft > 0) {
                    secondsLeft--;
                    timerLabel.setText(formatTime(secondsLeft));
                } else {
                    timer.stop();
                    timerCompleted = true;
                }
            }
        });

        timer.start();

        setTitle("Match Scoreboard");
        setSize(600, 400);
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

    public void stopMatchTimer() {
        if (timerCompleted) {
            timer.stop();
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



    private JPanel createPointsPanel(int competitor) {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 3));

        JButton plusButton = new JButton("+");
        JButton minusButton = new JButton("-");
        JLabel scoreLabel = new JLabel("0");
        scoreLabel.setHorizontalAlignment(SwingConstants.CENTER);

        plusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adjustScore(competitor, 1);
                scoreLabel.setText(Integer.toString(getScore(competitor)));
            }
        });

        minusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adjustScore(competitor, -1);
                scoreLabel.setText(Integer.toString(getScore(competitor)));
            }
        });

        panel.add(plusButton);
        panel.add(scoreLabel);
        panel.add(minusButton);

        return panel;
    }

    private JPanel createAdvantagesPanel(int competitor) {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 3));

        JButton plusButton = new JButton("+");
        JButton minusButton = new JButton("-");
        JLabel advantagesLabel = new JLabel("0");
        advantagesLabel.setHorizontalAlignment(SwingConstants.CENTER);

        plusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adjustAdvantages(competitor, 1);
                advantagesLabel.setText(Integer.toString(getAdvantages(competitor)));
            }
        });

        minusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adjustAdvantages(competitor, -1);
                advantagesLabel.setText(Integer.toString(getAdvantages(competitor)));
            }
        });

        panel.add(plusButton);
        panel.add(advantagesLabel);
        panel.add(minusButton);

        return panel;
    }

    private JPanel createPenaltiesPanel(int competitor) {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 3));

        JButton plusButton = new JButton("+");
        JButton minusButton = new JButton("-");
        JLabel penaltiesLabel = new JLabel("0");
        penaltiesLabel.setHorizontalAlignment(SwingConstants.CENTER);

        plusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adjustPenalties(competitor, 1);
                penaltiesLabel.setText(Integer.toString(getPenalties(competitor)));
            }
        });

        minusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adjustPenalties(competitor, -1);
                penaltiesLabel.setText(Integer.toString(getPenalties(competitor)));
            }
        });

        panel.add(plusButton);
        panel.add(penaltiesLabel);
        panel.add(minusButton);

        return panel;
    }

    public void adjustScore(int competitor, int change) {
        if (competitor == 1) {
            competitor1Points += change;
        } else if (competitor == 2) {
            competitor2Points += change;
        }
    }

    public int getScore(int competitor) {
        return (competitor == 1) ? competitor1Points : competitor2Points;
    }

    public void adjustAdvantages(int competitor, int change) {
        if (competitor == 1) {
            competitor1Advantages += change;
        } else if (competitor == 2) {
            competitor2Advantages += change;
        }
    }

    public int getAdvantages(int competitor) {
        return (competitor == 1) ? competitor1Advantages : competitor2Advantages;
    }

    public void adjustPenalties(int competitor, int change) {
        if (competitor == 1) {
            competitor1Penalties += change;
        } else if (competitor == 2) {
            competitor2Penalties += change;
        }
    }

    public int getPenalties(int competitor) {
        return (competitor == 1) ? competitor1Penalties : competitor2Penalties;
    }


    public void closeScoreboardTimer() {
        dispose();
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater((Runnable) new BJJScoreboardTimer(30, "Test 1", "Test 2"));
    }
}
