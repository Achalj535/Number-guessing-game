/*
Number Guessing NUMBER.Game :-
           * Built a simple number guessing game.
           * Used Java Swing for GUI development including input forms and real-time error feedback.
           * Handled edge cases and exceptions gracefully to ensure robust user experience.
           * Help the gamer by giving suggestion for guessing the correct number.
*/

// impoting packages requre for this project
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

class Game {
    JFrame f = new JFrame("Number guessing game");  // Title of the frame
    JLabel cl, l, l1, l2, l3;
    JTextField name;    // For entering name of player
    String player_name = "";    // To store name of player
    JButton b1, b2;     // For choice raady or not

    Game() {
        f.setLayout(null);
        f.getContentPane().setBackground(new Color(187, 175, 193)); // Set Background Colour
        f.setSize(400, 400); // Size of Frame
        f.setResizable(false);  // Make fixed size Frame

        // To adding the emoji to make the Frame attractive
        ImageIcon icon = new ImageIcon("g.jpg");
        Image image = icon.getImage().getScaledInstance(60, 60, Image.SCALE_REPLICATE);
        ImageIcon reIcon = new ImageIcon(image);
        cl = new JLabel(reIcon);    // adding imageicon to the label cl
        cl.setBounds(150, 240, 60, 60);

        // Simple label at top
        l = new JLabel("Number Guessing Game!");
        l.setBounds(30, 30, 400, 40);  // put label at top
        l.setForeground(new Color(75, 55, 113, 255));   // Setting background colour
        l.setFont(new Font("Segoe UI Emoji", Font.BOLD, 28)); // Setting font type and size
        f.add(l); // adding label to the Frame

        l1 = new JLabel("Enter your name : ");
        l1.setBounds(30, 100, 180, 20); // put label at perticular position
        l1.setFont(new Font("Arial", Font.BOLD, 18));   // Setting font type and size
        f.add(l1);  // adding label to the Frame

        name = new JTextField("");
        name.setBounds(200, 97, 150, 30);
        name.setFont(new Font("Arial", Font.BOLD, 18));
        name.setBackground(new Color(187, 175, 193)); // Setting background colour
        name.setBorder(BorderFactory.createLineBorder(Color.WHITE, 4)); // Setting border of white colour
        f.add(name);  // adding TextField to the Frame

        l2 = new JLabel();
        l2.setBounds(40, 170, 400, 30);
        l2.setFont(new Font("Arial", Font.BOLD, 16)); // Setting font type and size
        l2.setForeground(new Color(0xBE7A0C5A, true)); // Setting Foreground colour
        f.add(l2);  // adding label to the Frame

        l3 = new JLabel();
        l3.setBounds(50, 210, 400, 30);
        l3.setForeground(new Color(0xBE39142F, true));// Setting Foreground colour
        l3.setFont(new Font("Arial", Font.TYPE1_FONT, 24)); // Setting font type and size

        b1 = new JButton("Yes");
        b1.setBounds(120, 320, 60, 30);
        b1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));  // Setting border of Black colour

        b2 = new JButton("No");
        b2.setBounds(200, 320, 60, 30);
        b2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));  // Setting border of Black colour

        // For entering the name of player
        name.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // sleep method throws an exception that's why i am using try... catch block
                try {
                    player_name = name.getText();
                    String s = name.getText();
                    if (s.isEmpty()) {  // If user not enter name then it show msg
                        JOptionPane.showMessageDialog(f, "Please enter your name.");
                        return;
                    }else if(s.length()>10){ // If user enter to long name then it show msg
                        JOptionPane.showMessageDialog(f, "Your Name is too long..\nPlease enter nick name.");
                        name.setText("");
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
                b1.setBackground(new Color(0xCA40E6E6, true)); // changing background colour if button b1 is pressed
                try {
                    Thread.sleep(1000); // Waiting for 1second
                    f.dispose();    // Closing current Frame f
                    new Advance(player_name);   // Opeing new Frame by creating the object of class
                } catch (InterruptedException ex) {
                    //  If any problen occured then below exception msg show on Frame
                    JOptionPane.showMessageDialog(f, "Exception Occured!!");
                }
            }
        });

        // Exiting button is used to close the Frame.
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                b2.setBackground(new Color(0xD76395)); // changing background colour if button b2 is pressed
                JOptionPane.showMessageDialog(f, "You are exiting...."); // Before closing Frame This msg show on Frame
                System.exit(0);
            }
        });

        // For Closing the Frame
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // If user press cross icon then below msg show on Frame and then Frame get close
                JOptionPane.showMessageDialog(f, "You are exiting the game......");
                System.exit(0);
            }
        });
        // For make the Frame visible
        f.setVisible(true);
    }
}

class Advance extends Game {
    JFrame j; //New referance variable for Frame Creating is created
    JLabel l1, l2, l3, l4, l5, ll; // Only for text
    JButton b1, b2, b3; // This button show different levels
    String name = "";   // To store user name
    DBHelper db = new DBHelper();  // For Storing the result in database

    Advance(String name) {
        this.name = name; // User entered name storing in name variable
        j = new JFrame(); // actual object is creating
        j.setLayout(null); // For Place the components on Frame
        j.getContentPane().setBackground(new Color(187, 175, 193)); // Set Background Colour
        j.setSize(400, 400);// Size of Frame
        j.setResizable(false); // Make fixed size Frame
        f.dispose(); // Closing First Frame
        j.setVisible(true); // Make Frame j visible

        l1 = new JLabel("Welcome For Playing Game!");
        l1.setBounds(10, 30, 400, 40);  // put label at perticular position
        l1.setFont(new Font("Arial", Font.BOLD, 28)); // Setting font type and size
        l1.setForeground(new Color(19, 102, 163)); // Set Foreground Colour
        j.add(l1);  // adding label to the Frame

        l2 = new JLabel("Choose The Level ?");  // put label at perticular position
        l2.setBounds(80, 100, 200, 20);
        l2.setFont(new Font("Arial", Font.BOLD, 20)); // Setting font type and size
        j.add(l2);  // adding label to the Frame

        l3 = new JLabel("Beginner Level");  // put label at perticular position
        l3.setBounds(50, 140, 180, 20);
        l3.setFont(new Font("Arial", Font.PLAIN, 16)); // Setting font type and size
        j.add(l3);  // adding label to the Frame

        b1 = new JButton("1 - 50");
        b1.setBounds(190, 135, 80, 30);   // put Button at perticular position
        b1.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        j.add(b1);  // adding Button to the Frame

        l4 = new JLabel("Intermediate Level");
        l4.setBounds(50, 180, 180, 20); // put label at perticular position
        l4.setFont(new Font("Arial", Font.PLAIN, 16)); // Setting font type and size
        j.add(l4);  // adding label to the Frame

        b2 = new JButton("1 - 100");
        b2.setBounds(190, 175, 80, 30);   // put Button at perticular position
        b2.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        j.add(b2);  // adding Button to the Frame

        l5 = new JLabel("Advance Level");
        l5.setBounds(50, 220, 180, 20);   // put Label at perticular position
        l5.setFont(new Font("Arial", Font.PLAIN, 16)); // Setting font type and size
        j.add(l5);  // adding label to the Frame

        b3 = new JButton("1 - 1000");
        b3.setBounds(190, 215, 80, 30);   // put Button at perticular position
        b3.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        j.add(b3);  // adding Button to the Frame

        // To adding the image to make the Frame attractive
        ImageIcon icon1 = new ImageIcon("l.png");
        Image image1 = icon1.getImage().getScaledInstance(280, 80, Image.SCALE_REPLICATE);
        ImageIcon reIcon1 = new ImageIcon(image1);
        ll = new JLabel(reIcon1);
        ll.setBounds(50, 280, 280, 80); // put label at perticular position
        j.add(ll); // adding the Label l1 on Frame j

        // what should be happend when button b1 is pressed
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // When button b1 pressed then background colour get changed
                b1.setBackground(new Color(220, 190, 200));
                b1Action(); // Method Call

            }
        });

        // what should be happend when button b2 is pressed
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // When button b2 pressed then background colour get changed
                b2.setBackground(new Color(150, 200, 200));
                b2Action(); // Method Call

            }
        });

        // what should be happend when button b3 is pressed
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // When button b3 pressed then background colour get changed
                b3.setBackground(new Color(220, 200, 170));
                b3Action(); // Method Call
            }
        });

    }


    // Actual Logic When button b1 Pressed
    public void b1Action() {
        JLabel heading, headicon, bl1;
        JTextField t;
        j.dispose(); // Closing current Frame
        JFrame beginner = new JFrame();  // Creating new Frame

        heading = new JLabel("Beginner Level ");
        heading.setFont(new Font("Arial", Font.BOLD, 26));  // Setting font type and size
        heading.setForeground(new Color(0xFF026043, true)); // Setting Foreground colour
        heading.setBounds(100, 40, 400, 30); // put label at perticular position

        ImageIcon icon1 = new ImageIcon("tt.png");
        Image image1 = icon1.getImage().getScaledInstance(250, 50, Image.SCALE_REPLICATE); //To make fixe size image
        ImageIcon reIcon1 = new ImageIcon(image1);  // converting image into icon

        headicon = new JLabel(reIcon1);
        headicon.setBounds(70, 90, 250, 50);  // put label at perticular position
        beginner.add(heading);  // adding the Label heading on Frame beginner
        beginner.add(headicon); // adding the Label headicon on Frame beginner

        b1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));  // Setting border of Black colour
        b2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));  // Setting border of Black colour
        b3.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));  // Setting border of Black colour

        beginner.setLayout(null);
        beginner.getContentPane().setBackground(new Color(187, 175, 193)); // Setting Background colour
        beginner.setSize(400, 400); //Size of Frame
        beginner.setResizable(false);  // Make Fixed size of Frame
        beginner.setVisible(true); // Make Frame visible

        // Generate random number between 1 - 50
        Random rand = new Random();
        int target = rand.nextInt(50) + 1;

        bl1 = new JLabel("\uD83E\uDD14 Guess the number (1-50)");
        bl1.setFont(new Font("Segoe UI Emoji", Font.BOLD, 20)); // Setting font type and size
        bl1.setBounds(40, 160, 300, 50);  // put label at perticular position
        beginner.add(bl1);  // adding the Label bl1 on Frame beginner

        t = new JTextField("");
        t.setFont(new Font("Arial", Font.BOLD, 20));  // Setting font type and size
        t.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        t.setBounds(150, 200, 100, 30);
        beginner.add(t); // adding the TextField t on Frame beginner

        int[] count = {0};
        // Actual logic for beginner level
        t.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = t.getText();

                try {
                    int num = Integer.parseInt(input);
                    if (num == target) {// if correct number guess
                        count[0]++;  // then count is increment by 1

                        JLabel bl2 = new JLabel("Congratulations " + name + " !");
                        JLabel bl3 = new JLabel("you win the game in " + count[0] + " chances");
                        bl2.setFont(new Font("Segoe UI Emoji", Font.BOLD, 20));  // Setting font type and size
                        bl3.setFont(new Font("Segoe UI Emoji", Font.BOLD, 20));  // Setting font type and size
                        bl2.setBounds(60, 260, 300, 20);  // put label at perticular position
                        bl3.setBounds(40, 290, 300, 20);  // put label at perticular position
                        beginner.add(bl2);  // adding the Label bl2 on Frame beginner
                        beginner.add(bl3);  // adding the Label bl3 on Frame beginner

                        db.saveResult(name, count[0], "Win");  // Calling to the function to store data into database

                        beginner.repaint();
                         // To add delay of 3 second
                        Timer timer = new Timer(3000, new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent evt) {
                                beginner.dispose();  //Close current Frame
                                System.exit(0);  // Exits the entire game/application
                            }
                        });
                        timer.setRepeats(false); // Run only once
                        timer.start();  // to start the timer
                    } else if (num < target) {// if number is less than target number
                        count[0]++;  // then count increment by 1
                        // Show this msg on Frame
                        JOptionPane.showMessageDialog(beginner, "Guess number is smaller than actual number.");
                         // Clear the TextField
                        t.setText("");

                        // With the help of chatGPT
                        int choice = JOptionPane.showConfirmDialog(beginner, "Do you want to see the correct number?", "Reveal Number",
                                JOptionPane.YES_NO_OPTION);
                        if (choice == JOptionPane.YES_OPTION) {
                            JOptionPane.showMessageDialog(beginner, "The correct number was: " + target);
                            JOptionPane.showMessageDialog(beginner, "Sorry! You loss the game..");
                            db.saveResult(name, count[0], "Loss");
                            System.exit(0);
                        }
                    } else {
                        JOptionPane.showMessageDialog(beginner, "Guess number is greater than actual number.");
                         // Clear the TextField
                        t.setText("");
                        count[0]++;  // count increment by 1

                        // With the help of chatGPT
                        int choice = JOptionPane.showConfirmDialog(beginner, "Do you want to see the correct number?", "Reveal Number",
                                JOptionPane.YES_NO_OPTION);
                        if (choice == JOptionPane.YES_OPTION) {
                            JOptionPane.showMessageDialog(beginner, "The correct number was: " + target);
                            JOptionPane.showMessageDialog(beginner, "Sorry! You loss the game..");
                            db.saveResult(name, count[0], "Loss");
                            System.exit(0);
                        }
                    }
                } catch (Exception ex) { // To Handle Exception
                    JOptionPane.showMessageDialog(beginner, "Exception Occured!!");
                    t.setText("");
                }
            }
        });
    }

    public void b2Action() {
        JLabel bl1, heading, headicon;
        JTextField t;
        j.dispose();  // Closing current Frame
        JFrame beginner = new JFrame();  // Creating new Frame
        heading = new JLabel("Intermediate Level ");
        heading.setFont(new Font("Arial", Font.BOLD, 26));  // Setting font type and size
        heading.setForeground(new Color(0xFF026043, true));  // Set Foreground Colour
        heading.setBounds(80, 40, 400, 30);  // put label at perticular position

        ImageIcon icon1 = new ImageIcon("tt1.png");
        Image image1 = icon1.getImage().getScaledInstance(250, 50, Image.SCALE_REPLICATE);  //To make fixe size image
        ImageIcon reIcon1 = new ImageIcon(image1); // converting image into icon

        headicon = new JLabel(reIcon1);
        headicon.setBounds(70, 90, 250, 50);  // put label at perticular position
        beginner.add(heading);  //add Label to Frame (beginner)
        beginner.add(headicon);  //add Label to Frame (beginner)

        b1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));  // Setting border of Black colour
        b2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));  // Setting border of Black colour
        b3.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));  // Setting border of Black colour

        beginner.setLayout(null);
        beginner.getContentPane().setBackground(new Color(187, 175, 193));
        beginner.setSize(400, 400);
        beginner.setResizable(false);
        beginner.setVisible(true);

        // Generate random number between 1 - 100
        Random rand = new Random();
        int target = rand.nextInt(100) + 1;

        bl1 = new JLabel("\uD83E\uDD14 Guess the number (1-100)");
        bl1.setFont(new Font("Segoe UI Emoji", Font.BOLD, 20));  // Setting font type and size
        bl1.setBounds(40, 160, 300, 50);  // put label at perticular position
        beginner.add(bl1);
        t = new JTextField("");
        t.setFont(new Font("Arial", Font.BOLD, 24));  // Setting font type and size
        t.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2)); // Setting border of Black colour
        t.setBounds(150, 200, 100, 30);  // put TextField at perticular position
        beginner.add(t);

        int[] count = {0}; // To store the Score count

        // Actual logic for Intermediate level
        t.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = t.getText();  // Retrive the text present on textfield (t)
                try {
                    int num = Integer.parseInt(input);  // Converting String to Integer

                    if (num == target) {  // if correct number guess
                        count[0]++;  // then count is increment by 1
                        JLabel bl2 = new JLabel("Congratulations " + name + "!");
                        JLabel bl3 = new JLabel("you win the game in " + count[0] + " chances");
                        bl2.setFont(new Font("Segoe UI Emoji", Font.BOLD, 20));  // Setting font type and size
                        bl3.setFont(new Font("Segoe UI Emoji", Font.BOLD, 20));  // Setting font type and size
                        bl2.setBounds(60, 260, 300, 20);  // put Label at perticular position
                        bl3.setBounds(40, 290, 300, 20);  // put Label at perticular position
                        beginner.add(bl2); //add Label to Frame (beginner)
                        beginner.add(bl3); //add Label to Frame (beginner)

                        db.saveResult(name, count[0], "Win");  // Calling to the function to store data into database

                        beginner.repaint();
                        // To add delay of 3 second
                        Timer timer = new Timer(3000, new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent evt) {
                                beginner.dispose();  //Close current Frame
                                System.exit(0);  // Exits from the entire game
                            }
                        });
                        timer.setRepeats(false); // Run only once
                        timer.start();  // Start the timer

                    } else if (num < target) {  // if number is less than target number
                        count[0]++;  // then count increment by 1
                        // Show this msg on Frame
                        JOptionPane.showMessageDialog(beginner, "Guess number is smaller than actual number.");
                        // Clear the TextField
                        t.setText("");

                        // With the help of chatGPT
                        int choice = JOptionPane.showConfirmDialog(beginner, "Do you want to see the correct number?", "Reveal Number",
                                JOptionPane.YES_NO_OPTION);
                        if (choice == JOptionPane.YES_OPTION) {
                            JOptionPane.showMessageDialog(beginner, "The correct number was: " + target);
                            JOptionPane.showMessageDialog(beginner, "Sorry! You loss the game..");

                            db.saveResult(name, count[0], "Loss"); // Calling to the function to store data into database
                            System.exit(0);  // Exiting From game
                        }

                    } else {
                        JOptionPane.showMessageDialog(beginner, "Guess number is greater than actual number.");
                        // Clear the TextField
                        t.setText("");
                        count[0]++; // count increment by 1

                        // With the help of chatGPT
                        int choice = JOptionPane.showConfirmDialog(beginner, "Do you want to see the correct number?", "Reveal Number",
                                JOptionPane.YES_NO_OPTION);
                        if (choice == JOptionPane.YES_OPTION) {
                            JOptionPane.showMessageDialog(beginner, "The correct number was: " + target);
                            JOptionPane.showMessageDialog(beginner, "Sorry! You loss the game..");

                            db.saveResult(name, count[0], "Loss"); // Calling to the function to store data into database

                            System.exit(0);  // Exiting From game
                        }
                    }
                } catch (Exception ex) {// To Handle Exception
                    JOptionPane.showMessageDialog(beginner, "Exception Occured!!");
                    t.setText("");
                }
            }
        });
    }

    public void b3Action() {
        JLabel bl1, heading, headicon;
        JTextField t;
        j.dispose();  // Closing current Frame
        JFrame beginner = new JFrame();  // Creating new Frame
        heading = new JLabel("Advance Level ");
        heading.setFont(new Font("Arial", Font.BOLD, 26));  // Setting font type and size
        heading.setForeground(new Color(0xFF026043, true));   // Set Foreground Colour
        heading.setBounds(100, 40, 400, 30);  // put label at perticular position

        ImageIcon icon1 = new ImageIcon("tt2.png");
        Image image1 = icon1.getImage().getScaledInstance(250, 50, Image.SCALE_REPLICATE);  //To make fixe size image
        ImageIcon reIcon1 = new ImageIcon(image1);  // converting image into icon

        headicon = new JLabel(reIcon1);
        headicon.setBounds(70, 90, 250, 50);  // put label at perticular position
        beginner.add(heading); //add Label to Frame (beginner)
        beginner.add(headicon); //add Label to Frame (beginner)

        b1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));  // Setting border of Black colour
        b2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));  // Setting border of Black colour
        b3.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));  // Setting border of Black colour

        beginner.setLayout(null);
        beginner.getContentPane().setBackground(new Color(187, 175, 193));  // Setting background Colour
        beginner.setSize(400, 400);  // Set Size of Frame
        beginner.setResizable(false);  // Make Fixe Frame
        beginner.setVisible(true); // Make Frame visible

        // Generate random number between 1 - 50
        Random rand = new Random();
        int target = rand.nextInt(1000) + 1;

        bl1 = new JLabel("\uD83E\uDD14 Guess the number (1-1000)");
        bl1.setFont(new Font("Segoe UI Emoji", Font.BOLD, 20));  // Setting font type and size
        bl1.setBounds(40, 160, 300, 50);  // put label at perticular position
        beginner.add(bl1);//add Label to Frame (beginner)

        t = new JTextField("");
        t.setFont(new Font("Arial", Font.BOLD, 24));  // Setting font type and size
        t.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));  // Setting border of Black colour
        t.setBounds(150, 200, 100, 30);  // put TextField at perticular position
        beginner.add(t); //add TextField to Frame (beginner)

        int[] count = {0};// To store the Score count

        // Actual logic for NUMBER.Advance level
        t.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = t.getText(); // Retrive the text present on textfield (t)
                try {
                    // Converting String to Integer
                    int num = Integer.parseInt(input);
                    if (num == target) {// if correct number guess
                        count[0]++;  // then count is increment by 1

                        JLabel bl2 = new JLabel("Congratulations " + name + "!");
                        JLabel bl3 = new JLabel("you win the game in " + count[0] + " chances");
                        bl2.setFont(new Font("Segoe UI Emoji", Font.BOLD, 20));  // Setting font type and size
                        bl3.setFont(new Font("Segoe UI Emoji", Font.BOLD, 20));  // Setting font type and size
                        bl2.setBounds(60, 260, 300, 20); // put Label at perticular position
                        bl3.setBounds(40, 290, 300, 20); // put Label at perticular position
                        beginner.add(bl2);  //add Label to Frame (beginner)
                        beginner.add(bl3);  //add Label to Frame (beginner)

                        db.saveResult(name, count[0], "Win");  // Calling to the function to store data into database

                        beginner.repaint();
                        Timer timer = new Timer(3000, new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent evt) {
                                beginner.dispose();  // Close current Frame
                                System.exit(0);  // Exits the entire game
                            }
                        });
                        timer.setRepeats(false); // Run only once
                        timer.start(); // start the timer
                    } else if (num < target) {// if number is less than target number
                        count[0]++;  // then count increment by 1
                        // Show this msg on Frame
                        JOptionPane.showMessageDialog(beginner, "Guess number is smaller than actual number.");
                        // Clear the TextField
                        t.setText("");
                        // With the help of chatGPT
                        int choice = JOptionPane.showConfirmDialog(beginner, "Do you want to see the correct number?", "Reveal Number",
                                JOptionPane.YES_NO_OPTION);
                        if (choice == JOptionPane.YES_OPTION) {
                            JOptionPane.showMessageDialog(beginner, "The correct number was: " + target);
                            JOptionPane.showMessageDialog(beginner, "Sorry! You loss the game..");
                            db.saveResult(name, count[0], "Loss");  // Calling to the function to store data into database
                            System.exit(0);  // Exits the entire game
                        }
                    } else {
                        JOptionPane.showMessageDialog(beginner, "Guess number is greater than actual number.");
                        // Clear the TextField
                        t.setText("");
                        count[0]++;  //count increment by 1

                        // With the help of chatGPT
                        int choice = JOptionPane.showConfirmDialog(beginner, "Do you want to see the correct number?", "Reveal Number",
                                JOptionPane.YES_NO_OPTION);
                        if (choice == JOptionPane.YES_OPTION) {
                            JOptionPane.showMessageDialog(beginner, "The correct number was: " + target);
                            JOptionPane.showMessageDialog(beginner, "Sorry! You loss the game..");

                            db.saveResult(name, count[0], "Loss");  // Calling to the function to store data into database

                            System.exit(0);  // Exits the entire game
                        }
                    }
                } catch (Exception ex) {// To Handle Exception
                    JOptionPane.showMessageDialog(beginner, "Exception Occured!!");
                    t.setText("");  // Clear the TextField
                }
            }
        });
    }
}

public class NumberGuessingGameDemo {

    public static void main(String[] args) {
        new Game();

    }
}
