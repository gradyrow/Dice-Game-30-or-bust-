/*
Grayden Rowedder
CSC160 Computer Science I
Nov 20, 2020
(30 or Bust Final)
*/
package com.company;
import java.util.Random;
import java.util.Scanner;
public class DiceGame {
    public static void main(String[] args) {
        Player a = new Player();               //Setting up classes
        Player b = new Player();
        Scanner N = new Scanner(System.in);
        Random rand = new Random();
        System.out.print("Hello, what is the name of the first player? ");
        String n = N.nextLine();
        a.setName1(n);
        Scanner N2 = new Scanner(System.in);
        System.out.print("What is the name of the second player? ");
        String n2 = N2.nextLine();
        b.setName1(n2);
        System.out.println("Welcome players " + a.getName1() + " and " + b.getName1() + "!");
        System.out.println("The goal of this game is to accumulate a player score of exactly 30. The first player to score exactly 30 is the Winner!");
        System.out.println("You will roll a pair of dice, then you must choose the score of one of the dice or the total of the two dice.");
        System.out.println("This value is added to your player score. If your score goes over 30, your score is reset to zero. Player turn ");
        System.out.println("changes after each roll of the dice. You win when you accumulate a score of exactly 30.");
        System.out.println("Here we go!");
        boolean win1 = false;
        while (!win1) {                                                   //Loop for playing game
            System.out.println("Player " + a.getName1() + ", it is your turn!");
            System.out.println("Your score is: " + a.getPoints1());
            System.out.println("Your roll:");
            int d1 = rand.nextInt(5) + 1;                           //Dice Code
            int d2 = rand.nextInt(5) + 1;
            int d3 = d2 + d1;
            System.out.println("Die 1: " + d1);
            System.out.println("Die 2: " + d2);
            System.out.println("Total: " + (d3));
            Scanner choice = new Scanner(System.in);
            System.out.print("Do you wish to (1) Keep die 1, (2) Keep die 2, (3) Keep the total? (Respond with 1 or 2 or 3): ");
            int c = choice.nextInt();                                     //Which choice for points
            if (c == 1) a.add(d1);
            if (c == 2) a.add(d2);
            if (c == 3) a.add(d3);
            if (a.getPoints1() > 30) a.add(-a.getPoints1());
            if (a.getPoints1() == 30) win1 = true;
            else if (a.getPoints1() > 30) {                               //Reset points
                win1 = false;
                System.out.println("Your score is: " + a.getPoints1() + ", your score is now reset to 0!"); }
            else {
                System.out.println("Your total: " + a.getPoints1()); }
            if (!win1) {                                                 //Player 2 loop
                System.out.println("Player " + b.getName1() + ", it is your turn!");
                System.out.println("Your score is: " + b.getPoints1());
                System.out.println("Your roll:");
                int d4 = rand.nextInt(5) + 1;                     //Dice Code
                int d5 = rand.nextInt(5) + 1;
                int d6 = d4 + d5;
                System.out.println("Die 1: " + d4);
                System.out.println("Die 2: " + d5);
                System.out.println("Total: " + (d6));
//                Scanner choice2 = new Scanner(System.in);
                System.out.print("Do you wish to (1) Keep die 1, (2) Keep die 2, (3) Keep the total? (Respond with 1 or 2 or 3): ");
                int c2 = choice.nextInt();                               //Points
                if (c2 == 1) b.add(d4);
                if (c2 == 2) b.add(d5);
                if (c2 == 3) b.add(d6);
                if (b.getPoints1() > 30) b.add(-b.getPoints1());
                if (b.getPoints1() == 30) win1 = true;
                else if (b.getPoints1() > 30) {
                    win1 = false;
                    System.out.println("Your score is: " + b.getPoints1() + ", your score is now reset to 0!"); }
                else {
                    win1 = false;
                    System.out.println("Your total: " + b.getPoints1()); } }
            if (a.getPoints1() == 30)
                System.out.println("Your total: " + a.getPoints1() + "! Congratulations, you WIN!!");
            if (b.getPoints1() == 30)
                System.out.println("Your total: " + b.getPoints1() + "! Congratulations, you WIN!!");
        }
    }
}
