package com.rayala30.nomatic.client.matchmaker.model.archive;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BJJScoreboard_Reference extends JFrame {
    private JLabel competitor1Label;
    private JLabel competitor2Label;

    private int competitor1Points;
    private int competitor2Points;
    private int competitor1Advantages;
    private int competitor2Advantages;
    private int competitor1Penalties;
    private int competitor2Penalties;

    public BJJScoreboard_Reference() {
        competitor1Label = new JLabel("Competitor 1");
        competitor1Label.setFont(new Font("Arial", Font.BOLD, 18));
        competitor1Label.setHorizontalAlignment(SwingConstants.CENTER);

        competitor2Label = new JLabel("Competitor 2");
        competitor2Label.setFont(new Font("Arial", Font.BOLD, 18));
        competitor2Label.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(4, 3));
        mainPanel.add(new JLabel()); // Empty cell
        mainPanel.add(competitor1Label);
        mainPanel.add(competitor2Label);
        // Points Panel
        mainPanel.add(new JLabel("Points"));
        mainPanel.add(createPointsPanel(1));
        mainPanel.add(createPointsPanel(2));
        // Advantages Panel
        mainPanel.add(new JLabel("Advantages"));
        mainPanel.add(createAdvantagesPanel(1));
        mainPanel.add(createAdvantagesPanel(2));
        // Penalties Panel
        mainPanel.add(new JLabel("Penalties"));
        mainPanel.add(createPenaltiesPanel(1));
        mainPanel.add(createPenaltiesPanel(2));

        add(mainPanel);

        setTitle("BJJ Scoreboard");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(BJJScoreboard_Reference::new);
    }
}
