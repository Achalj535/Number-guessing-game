/*
Number Guessing NUMBER.Game :-
           * Built a simple number guessing game.
           * Used Java Swing for GUI development including input forms and real-time error feedback.
           * Handled edge cases and exceptions gracefully to ensure robust user experience.
           * Help the gamer by giving suggestion for guessing the correct number.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

class Game {

    JFrame f = new JFrame("Number guessing game");
    JLabel cl, l, l1, l2, l3;
    JTextField name;
    JButton b1, b2;

    Game() {
        f.setLayout(null);
        f.getContentPane().setBackground(new Color(187, 175, 193));
        f.setSize(400, 400);
        f.setResizable(false);

        ImageIcon icon = new ImageIcon("/g.jpg");
        Image image = icon.getImage().getScaledInstance(60, 60, Image.SCALE_REPLICATE);
        ImageIcon reIcon = new ImageIcon(image);
        cl = new JLabel(reIcon);
        cl.setBounds(150, 240, 60, 60);

        l = new JLabel("Number Guessing Game!");
        l.setBounds(30, 30, 400, 40);
        l.setForeground(new Color(75, 55, 113, 255));
        l.setFont(new Font("Segoe UI Emoji", Font.BOLD, 28));
        f.add(l);

        l1 = new JLabel("Enter your name : ");
        l1.setBounds(30, 100, 180, 20);
        l1.setFont(new Font("Arial", Font.BOLD, 18));
        f.add(l1);

        name = new JTextField("");
        name.setBounds(200, 97, 150, 30);
        name.setFont(new Font("Arial", Font.BOLD, 18));
        name.setBackground(new Color(187, 175, 193));
        name.setBorder(BorderFactory.createLineBorder(Color.WHITE, 4));
        f.add(name);

        l2 = new JLabel();
        l2.setBounds(40, 170, 400, 30);
        l2.setFont(new Font("Arial", Font.BOLD, 16));
        l2.setForeground(new Color(0xBE7A0C5A, true));
        f.add(l2);

        l3 = new JLabel();
        l3.setBounds(50, 210, 400, 30);
        l3.setForeground(new Color(0xBE39142F, true));
        l3.setFont(new Font("Arial", Font.TYPE1_FONT, 24));

        b1 = new JButton("Yes");
        b1.setBounds(120, 310, 60, 30);
        b1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));

        b2 = new JButton("No");
        b2.setBounds(200, 310, 60, 30);
        b2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));

        // For entering the name of player
        name.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // sleep method throws an exception that's why i am using try... catch block
                try {
                    String s = name.getText();
                    if (s.isEmpty()) {
                        JOptionPane.showMessageDialog(f, "Please enter your name.");
                        return;
                    }
                    l2.setText("WELCOME " + s.toUpperCase() + " FOR PLAYING GAME!");
                    Thread.sleep(1000);
                    l3.setText("Are you ready to play ?");
                    f.add(l3);
                    f.add(cl);
                    f.add(b1);
                    f.add(b2);
                    f.repaint();
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(f, "Exception Occured...");
                }
            }
        });

        // what should be happend when yes button is pressed
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                b1.setBackground(new Color(0xCA40E6E6, true));
                try {
                    Thread.sleep(1000);
                    f.dispose();
                    new Advance();
                } catch (InterruptedException ex) {
                    JOptionPane.showMessageDialog(f, "Exception Occured!!");
                }
            }
        });

        // Exiting button is used to close the Frame.
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                b2.setBackground(new Color(0xD76395));
                JOptionPane.showMessageDialog(f, "You are exiting....");
                System.exit(0);
            }
        });

        // For Closing the Frame
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                JOptionPane.showMessageDialog(f, "You are exiting the game......");
                System.exit(0);
            }
        });
        f.setVisible(true);
    }
}

class Advance extends Game {

    JFrame j;
    JLabel l1, l2, l3, l4, l5, ll;
    JButton b1, b2, b3;

    Advance() {
        j = new JFrame();
        j.setLayout(null);
        j.getContentPane().setBackground(new Color(187, 175, 193));
        j.setSize(400, 400);
        j.setResizable(false);
        f.dispose();
        j.setVisible(true);

        l1 = new JLabel("Welcome For Playing Game!");
        l1.setBounds(10, 30, 400, 40);
        l1.setFont(new Font("Arial", Font.BOLD, 28));
        l1.setForeground(new Color(19, 102, 163));
        j.add(l1);

        l2 = new JLabel("Choose The Level ?");
        l2.setBounds(80, 100, 200, 20);
        l2.setFont(new Font("Arial", Font.BOLD, 20));
        j.add(l2);

        l3 = new JLabel("Beginner Level");
        l3.setBounds(50, 140, 180, 20);
        l3.setFont(new Font("Arial", Font.PLAIN, 16));
        j.add(l3);
        b1 = new JButton("1 - 50");
        b1.setBounds(190, 135, 80, 30);
        b1.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        j.add(b1);

        l4 = new JLabel("Intermediate Level");
        l4.setBounds(50, 180, 180, 20);
        l4.setFont(new Font("Arial", Font.PLAIN, 16));
        j.add(l4);
        b2 = new JButton("1 - 100");
        b2.setBounds(190, 175, 80, 30);
        b2.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        j.add(b2);

        l5 = new JLabel("Advance Level");
        l5.setBounds(50, 220, 180, 20);
        l5.setFont(new Font("Arial", Font.PLAIN, 16));
        j.add(l5);
        b3 = new JButton("1 - 1000");
        b3.setBounds(190, 215, 80, 30);
        b3.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        j.add(b3);

        ImageIcon icon1 = new ImageIcon("/l.png");
        Image image1 = icon1.getImage().getScaledInstance(280, 80, Image.SCALE_REPLICATE);
        ImageIcon reIcon1 = new ImageIcon(image1);
        ll = new JLabel(reIcon1);
        ll.setBounds(50, 280, 280, 80);
        j.add(ll);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                b1.setBackground(new Color(220, 190, 200));
                b1Action();

            }
        });

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                b2.setBackground(new Color(150, 200, 200));
                b2Action();

            }
        });

        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                b3.setBackground(new Color(220, 200, 170));
                b3Action();
            }
        });

    }

    public void b1Action() {
        JLabel heading, headicon, bl1;
        JTextField t;
        j.dispose();
        JFrame beginner = new JFrame();

        heading = new JLabel("Beginner Level ");
        heading.setFont(new Font("Arial", Font.BOLD, 26));
        heading.setForeground(new Color(0xFF026043, true));
        heading.setBounds(100, 40, 400, 30);

        ImageIcon icon1 = new ImageIcon("tt.png");
        Image image1 = icon1.getImage().getScaledInstance(250, 50, Image.SCALE_REPLICATE);
        ImageIcon reIcon1 = new ImageIcon(image1);

        headicon = new JLabel(reIcon1);
        headicon.setBounds(70, 90, 250, 50);
        beginner.add(heading);
        beginner.add(headicon);

        b1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        b2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        b3.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

        beginner.setLayout(null);
        beginner.getContentPane().setBackground(new Color(187, 175, 193));
        beginner.setSize(400, 400);
        beginner.setResizable(false);
        beginner.setVisible(true);

        // Generate random number between 1 - 50
        Random rand = new Random();
        int target = rand.nextInt(50) + 1;

        bl1 = new JLabel("\uD83E\uDD14 Guess the number (1-50)");
        bl1.setFont(new Font("Segoe UI Emoji", Font.BOLD, 20));
        bl1.setBounds(40, 160, 300, 50);
        beginner.add(bl1);
        t = new JTextField("");
        t.setFont(new Font("Arial", Font.BOLD, 20));
        t.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        t.setBounds(150, 200, 100, 30);
        beginner.add(t);

        int[] count = {0};
        // Actual logic for beginner level
        t.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = t.getText();

                try {
                    int num = Integer.parseInt(input);
                    if (num == target) {
                        count[0]++;

                        JLabel bl2 = new JLabel("Congratulations " + "!");
                        JLabel bl3 = new JLabel("you win the game in " + count[0] + " chances");
                        bl2.setFont(new Font("Segoe UI Emoji", Font.BOLD, 20));
                        bl3.setFont(new Font("Segoe UI Emoji", Font.BOLD, 20));
                        bl2.setBounds(80, 260, 300, 20);
                        bl3.setBounds(60, 290, 300, 20);
                        beginner.add(bl2);
                        beginner.add(bl3);

                        beginner.repaint();

                    } else if (num < target) {
                        count[0]++;
                        JOptionPane.showMessageDialog(beginner, "Guess number is smaller than actual number.");
                        t.setText("");

                        // With the help of chatGPT
                        int choice = JOptionPane.showConfirmDialog(beginner, "Do you want to see the correct number?", "Reveal Number",
                                JOptionPane.YES_NO_OPTION);
                        if (choice == JOptionPane.YES_OPTION) {
                            JOptionPane.showMessageDialog(beginner, "The correct number was: " + target);
                            JOptionPane.showMessageDialog(beginner, "Sorry! You loss the game..");
                            System.exit(0);
                        }
                    } else {
                        JOptionPane.showMessageDialog(beginner, "Guess number is greater than actual number.");
                        t.setText("");
                        count[0]++;

                        // With the help of chatGPT
                        int choice = JOptionPane.showConfirmDialog(beginner, "Do you want to see the correct number?", "Reveal Number",
                                JOptionPane.YES_NO_OPTION);
                        if (choice == JOptionPane.YES_OPTION) {
                            JOptionPane.showMessageDialog(beginner, "The correct number was: " + target);
                            JOptionPane.showMessageDialog(beginner, "Sorry! You loss the game..");
                            System.exit(0);
                        }
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(beginner, "Exception Occured!!");
                    t.setText("");
                }
            }
        });
    }

    public void b2Action() {
        JLabel bl1, heading, headicon;
        JTextField t;
        j.dispose();
        JFrame beginner = new JFrame();
        heading = new JLabel("Intermediate Level ");
        heading.setFont(new Font("Arial", Font.BOLD, 26));
        heading.setForeground(new Color(0xFF026043, true));
        heading.setBounds(80, 40, 400, 30);

        ImageIcon icon1 = new ImageIcon("tt1.png");
        Image image1 = icon1.getImage().getScaledInstance(250, 50, Image.SCALE_REPLICATE);
        ImageIcon reIcon1 = new ImageIcon(image1);

        headicon = new JLabel(reIcon1);
        headicon.setBounds(70, 90, 250, 50);
        beginner.add(heading);
        beginner.add(headicon);

        b1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        b2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        b3.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

        beginner.setLayout(null);
        beginner.getContentPane().setBackground(new Color(187, 175, 193));
        beginner.setSize(400, 400);
        beginner.setResizable(false);
        beginner.setVisible(true);

        // Generate random number between 1 - 100
        Random rand = new Random();
        int target = rand.nextInt(100) + 1;

        bl1 = new JLabel("\uD83E\uDD14 Guess the number (1-100)");
        bl1.setFont(new Font("Segoe UI Emoji", Font.BOLD, 20));
        bl1.setBounds(40, 160, 300, 50);
        beginner.add(bl1);
        t = new JTextField("");
        t.setFont(new Font("Arial", Font.BOLD, 24));
        t.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        t.setBounds(150, 200, 100, 30);
        beginner.add(t);

        int[] count = {0};
        // Actual logic for Intermediate level
        t.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = t.getText();
                try {
                    int num = Integer.parseInt(input);
                    if (num == target) {
                        count[0]++;
                        JLabel bl2 = new JLabel("Congratulations " + "!");
                        JLabel bl3 = new JLabel("you win the game in " + count[0] + " chances");
                        bl2.setFont(new Font("Segoe UI Emoji", Font.BOLD, 20));
                        bl3.setFont(new Font("Segoe UI Emoji", Font.BOLD, 20));
                        bl2.setBounds(60, 260, 300, 20);
                        bl3.setBounds(60, 290, 300, 20);
                        beginner.add(bl2);
                        beginner.add(bl3);

                        beginner.repaint();
                    } else if (num < target) {
                        count[0]++;
                        JOptionPane.showMessageDialog(beginner, "Guess number is smaller than actual number.");
                        t.setText("");
                        // With the help of chatGPT
                        int choice = JOptionPane.showConfirmDialog(beginner, "Do you want to see the correct number?", "Reveal Number",
                                JOptionPane.YES_NO_OPTION);
                        if (choice == JOptionPane.YES_OPTION) {
                            JOptionPane.showMessageDialog(beginner, "The correct number was: " + target);
                            JOptionPane.showMessageDialog(beginner, "Sorry! You loss the game..");

                            System.exit(0);
                        }
                    } else {
                        JOptionPane.showMessageDialog(beginner, "Guess number is greater than actual number.");
                        t.setText("");
                        count[0]++;

                        // With the help of chatGPT
                        int choice = JOptionPane.showConfirmDialog(beginner, "Do you want to see the correct number?", "Reveal Number",
                                JOptionPane.YES_NO_OPTION);
                        if (choice == JOptionPane.YES_OPTION) {
                            JOptionPane.showMessageDialog(beginner, "The correct number was: " + target);
                            JOptionPane.showMessageDialog(beginner, "Sorry! You loss the game..");

                            System.exit(0);
                        }
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(beginner, "Exception Occured!!");
                    t.setText("");
                }
            }
        });
    }

    public void b3Action() {
        JLabel bl1, heading, headicon;
        JTextField t;
        j.dispose();
        JFrame beginner = new JFrame();
        heading = new JLabel("Advance Level ");
        heading.setFont(new Font("Arial", Font.BOLD, 26));
        heading.setForeground(new Color(0xFF026043, true));
        heading.setBounds(100, 40, 400, 30);

        ImageIcon icon1 = new ImageIcon("tt2.png");
        Image image1 = icon1.getImage().getScaledInstance(250, 50, Image.SCALE_REPLICATE);
        ImageIcon reIcon1 = new ImageIcon(image1);

        headicon = new JLabel(reIcon1);
        headicon.setBounds(70, 90, 250, 50);
        beginner.add(heading);
        beginner.add(headicon);

        b1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        b2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        b3.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

        beginner.setLayout(null);
        beginner.getContentPane().setBackground(new Color(187, 175, 193));
        beginner.setSize(400, 400);
        beginner.setResizable(false);
        beginner.setVisible(true);

        // Generate random number between 1 - 50
        Random rand = new Random();
        int target = rand.nextInt(1000) + 1;

        bl1 = new JLabel("\uD83E\uDD14 Guess the number (1-1000)");
        bl1.setFont(new Font("Segoe UI Emoji", Font.BOLD, 20));
        bl1.setBounds(40, 160, 300, 50);
        beginner.add(bl1);
        t = new JTextField("");
        t.setFont(new Font("Arial", Font.BOLD, 24));
        t.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        t.setBounds(150, 200, 100, 30);
        beginner.add(t);

        int[] count = {0};
        // Actual logic for NUMBER.Advance level
        t.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = t.getText();
                try {
                    int num = Integer.parseInt(input);
                    if (num == target) {
                        count[0]++;
                        JLabel bl2 = new JLabel("Congratulations " + "!");
                        JLabel bl3 = new JLabel("you win the game in " + count[0] + " chances");
                        bl2.setFont(new Font("Segoe UI Emoji", Font.BOLD, 20));
                        bl3.setFont(new Font("Segoe UI Emoji", Font.BOLD, 20));
                        bl2.setBounds(60, 260, 300, 20);
                        bl3.setBounds(60, 290, 300, 20);
                        beginner.add(bl2);
                        beginner.add(bl3);
                        beginner.repaint();
                    } else if (num < target) {
                        count[0]++;
                        JOptionPane.showMessageDialog(beginner, "Guess number is smaller than actual number.");
                        t.setText("");
                        // With the help of chatGPT
                        int choice = JOptionPane.showConfirmDialog(beginner, "Do you want to see the correct number?", "Reveal Number",
                                JOptionPane.YES_NO_OPTION);
                        if (choice == JOptionPane.YES_OPTION) {
                            JOptionPane.showMessageDialog(beginner, "The correct number was: " + target);
                            JOptionPane.showMessageDialog(beginner, "Sorry! You loss the game..");

                            System.exit(0);
                        }
                    } else {
                        JOptionPane.showMessageDialog(beginner, "Guess number is greater than actual number.");
                        t.setText("");
                        count[0]++;

                        // With the help of chatGPT
                        int choice = JOptionPane.showConfirmDialog(beginner, "Do you want to see the correct number?", "Reveal Number",
                                JOptionPane.YES_NO_OPTION);
                        if (choice == JOptionPane.YES_OPTION) {
                            JOptionPane.showMessageDialog(beginner, "The correct number was: " + target);
                            JOptionPane.showMessageDialog(beginner, "Sorry! You loss the game..");

                            System.exit(0);
                        }
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(beginner, "Exception Occured!!");
                    t.setText("");
                }
            }
        });
    }
}

public class NumberGuessingGameDemo {

    public static void main(String[] args) {
        Game g = new Game();

    }
}
