package com.company;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe{

   /**
     * <b>main</b> of the application. Creates the instance of  GameController 
     * and starts the game. If two parameters line  and column
     * are passed, they are used. 
     * Otherwise, a default value is used. Defaults values are also
     * Otherwise, a default value is used. Defaults values are also
     * used if the paramters are too small (less than 2).
     * 
     * @param args
     *            command line parameters
     */
     public static void main(String[] args) {

        StudentInfo.display();

        TicTacToeGame game;
        int lines = 3;
        int columns = 3;
        int win = 3;

   
        try{
            if (args.length >= 2) {
                lines = Integer.parseInt(args[0]);
                if(lines<2){
                    System.out.println("Invalid argument, using default...");
                    lines = 3;
                }
                columns = Integer.parseInt(args[1]);
                if(columns<2){
                    System.out.println("Invalid argument, using default...");
                    columns = 3;
                }
            }
            if (args.length >= 3){
                win = Integer.parseInt(args[2]);
                if(win<2){
                    System.out.println("Invalid argument, using default...");
                    win = 3;
                }
            } 
            if (args.length > 3){
                System.out.println("Too many arguments. Only the first 3 are used.");
            } 

        } catch(NumberFormatException e){
            System.out.println("Invalid argument, using default...");
            lines   = 3;
            columns  = 3;
            win = 3;
        }

         boolean rejouer  = true;

            game = new TicTacToeGame(lines, columns,win);
            HumanPlayer Human = new HumanPlayer();
            ComputerRandomPlayer Robot = new ComputerRandomPlayer();

         while ( rejouer==true){
             Player[] players;
             players  = new Player[]{Human, Robot};
             Random random = new Random();
             int random_player =  random.nextInt(2);

             while(game.getGameState()==GameState.PLAYING){

                 System.out.println(players[random_player]);
                 players[random_player].play(game);
                 if (random_player==0) {
                     random_player=1;
                 }
                 else
                     random_player=0;

             }
             System.out.println("La partie est finie");
             System.out.println(game.toString());
             if (game.getGameState()==GameState.OWIN){
                 System.out.println("0 a gagné");
             }
             if (game.getGameState()==GameState.XWIN){
                 System.out.println("X à gagné");
             }
             if (game.getGameState()==GameState.DRAW){
                 System.out.println("Match nul");
             }
             System.out.println("Voulez-vous rejouer?");
             System.out.println("Si Oui faites (K)");
             Scanner input = new Scanner(System.in);
             String choix = input.nextLine();
             if ((choix=="k" )|| (choix =="K")){
                 rejouer = true ;
             }
             else
                 rejouer = false;




        }



     }

}