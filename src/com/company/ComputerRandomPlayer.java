package com.company;

import java.util.Random;

public class ComputerRandomPlayer implements Player {

   public void play(TicTacToeGame game){

       if (game.getGameState() == GameState.PLAYING){
           System.out.println("Au tour du robot");

           boolean Valable_random = false ;
           while (Valable_random==false){
               System.out.println(game.toString());
               Random case_rand = new Random();
               int case_random = case_rand.nextInt(3*3);
               if (game.valueAt(case_random)==CellValue.EMPTY){
                   game.play(case_random);
                   Valable_random = true;

               }

           }



       }


    }

}