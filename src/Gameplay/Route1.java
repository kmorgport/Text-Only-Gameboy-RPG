package Gameplay;

import pc.Computer;
import pokemon.Pidgey;
import pokemon.Pokemon;
import trainers.Trainer;
import util.Input;

import java.util.Scanner;

public class Route1 {
    Input io;
    Scanner scanner = new Scanner(System.in);
    public Route1(){};

    public void navigateRoute1FirstTime(Trainer player, Trainer rival, Computer computer){
        System.out.println("The first steps of a new adventure await!!");
    }

    public void tallFieldNavigation(Trainer player){
        while(true){
            int random = (int) Math.floor(Math.random()*99)+1;
            if(random<=18){
                encounterMonster(player);
            }
        }
    }

    public void encounterMonster(Trainer player){
        WildBattle battle = new WildBattle();
        int random = (int) Math.floor(Math.random()*99)+1;
        int wildLevel = (int) Math.floor(Math.random()*4)+1;
        int wildHpRandom = (int) Math.floor(Math.random()*15)+1;
        int wildAttRandom = (int) Math.floor(Math.random()*15)+1;
        int wildDefRandom = (int) Math.floor(Math.random()*15)+1;
        int wildSpAttRandom = (int) Math.floor(Math.random()*15)+1;
        int wildSpDefRandom = (int) Math.floor(Math.random()*15)+1;
        int wildSpeedRandom = (int) Math.floor(Math.random()*15)+1;
        if(random>=1&&random<=60){
            Pokemon pidgey = new Pidgey(wildLevel,wildHpRandom,wildAttRandom,wildDefRandom,wildSpAttRandom,wildSpDefRandom,wildSpeedRandom);
            battle.wildMonsterBattle(player,pidgey);
        }else if(random>=61&&random<=100){
        }

    }
}
