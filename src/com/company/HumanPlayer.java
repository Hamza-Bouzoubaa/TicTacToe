package com.company;

import java.io.Console;
import java.util.Scanner;


public class HumanPlayer implements Player {



    public void play(TicTacToeGame game){


        if (game.getGameState() == GameState.PLAYING){
            System.out.println(game.toString());
            if (game.getLevel()%2==0)
                System.out.println("au tour de X");
            else
                System.out.println("au tour de O");
            boolean input_valable= false;
            while (input_valable==false){
                System.out.println("case à choisir   : ");
                Scanner input = new Scanner(System.in);
                int valeur = input.nextInt();
                int case_jouer = valeur;

                if (case_jouer< game.lines*game.columns && case_jouer>0 && game.valueAt(case_jouer-1)==CellValue.EMPTY){
                    game.play(case_jouer-1);
                    input_valable = true;


                }
                else {
                    System.out.println("La case que vous avez selectionné n'est pas jouable, veuillez en choisir une autre");
                }


            }

        }
        else
            System.out.println("erro");




    }
}