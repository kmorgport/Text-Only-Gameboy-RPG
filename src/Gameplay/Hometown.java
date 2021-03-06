package Gameplay;
import pc.Computer;
import pokemon.Bulbasaur;
import pokemon.Charmander;
import pokemon.Pokemon;
import pokemon.Squirtle;
import trainers.Trainer;
import util.Input;

import java.util.Scanner;

public class Hometown {
    Input io;
    Scanner scanner = new Scanner(System.in);
    public Hometown(){}

    public void homeTownFirstVisit(Trainer player, Trainer rival, Computer computer){
        io = new Input();
            centerOfTown(player,rival,computer);
            returnToLab(player,rival,computer);
            centerOfTown2(player,rival,computer);
    }

    public void centerOfTown(Trainer player, Trainer rival, Computer computer){
        System.out.println("You arrive in the center of town");
        scanner.nextLine();
        boolean loop = true;
        while(loop){
            System.out.println("Your HOME is to the WEST , to the EAST you see your rival, " + rival.getName() + "'s house. To the SOUTH you see PROFESSOR LIVEOAK'S lab and the bay that leads to the Kanjoh sea. \nTo the NORTH you see a lone road leading out of town to some fields.");
            System.out.println("Which path do you choose?: NORTH -- EAST -- SOUTH -- WEST");
            String answ = io.getString();
            switch(answ.toUpperCase()){
                case "NORTH":
                    leaveHomeTown(player,rival,computer);
                    loop = false;
                    break;
                case "EAST":
                    headToRivalsHouse(player,rival,computer);
                    break;
                case "SOUTH":
                    headToSouthernHalfOfTown(player, rival,computer);
                    break;
                case "WEST":
                    System.out.println("You head back home..");
                    loop=false;
                    PlayerHouseDownstairs home = new PlayerHouseDownstairs();
                    home.navigateLowerFloor(player,rival,computer);
                    break;
                default:
                    System.out.println("Ooops, there was a typo");

            }
        }
    }

    public void centerOfTown2(Trainer player, Trainer rival, Computer computer){
        scanner.nextLine();
        boolean loop = true;
        while(loop){
            System.out.println("Your HOME is to the WEST , to the EAST you see your rival, " + rival.getName() + "'s house. To the SOUTH you see PROFESSOR LIVEOAK'S lab and the bay that leads to the Kanjoh sea. \nTo the NORTH is ROUTE 1 leading to VIRIDIAN CITY.");
            System.out.println("Which path do you choose?: NORTH -- EAST -- SOUTH -- WEST");
            String answ = io.getString();
            switch(answ.toUpperCase()){
                case "NORTH":
                    Route1 route1 = new Route1();
                    route1.navigateRoute1FirstTime(player, rival, computer);
                    loop = false;
                    break;
                case "EAST":
                    headToRivalsHouse(player,rival,computer);
                    break;
                case "SOUTH":
                    headToSouthernHalfOfTown(player, rival,computer);
                    break;
                case "WEST":
                    System.out.println("You head back home..");
                    loop=false;
                    PlayerHouseDownstairs home = new PlayerHouseDownstairs();
                    home.navigateLowerFloor2(player,rival,computer);
                    break;
                default:
                    System.out.println("Ooops, there was a typo");

            }
        }
    }


    public void leaveHomeTown(Trainer player, Trainer rival, Computer computer){
        System.out.println(" - - - - - - - -");
        System.out.println("You start heading towards the grassy path leaving Pallet Town, excited to start your new adventure!");
        scanner.nextLine();
        System.out.println("As soon as your foot steps into the tall grass you hear a voice shouting your name:");
        scanner.nextLine();
        System.out.println("PROF LIVEOAK: " + player.getName() + "!!" + player.getName() + "!! Stop!!\nDon't go out!");
        scanner.nextLine();
        System.out.println("PROF LIVEOAK runs up to you, slightly out of breath.");
        scanner.nextLine();
        System.out.println("PROF LIVEOAK: It's unsafe! Wild POKEMON live in tall grass! You need your own\nPOKEMON for your protection. I know! Here, come with me!");
        scanner.nextLine();
        //go to lab method

    }


    public void returnToLab(Trainer player, Trainer rival, Computer computer){
        io = new Input();
        int playerHpRandom = (int) Math.floor(Math.random()*15)+1;
        int playerAttRandom = (int) Math.floor(Math.random()*15)+1;
        int playerDefRandom = (int) Math.floor(Math.random()*15)+1;
        int playerSpAttRandom = (int) Math.floor(Math.random()*15)+1;
        int playerSpDefRandom = (int) Math.floor(Math.random()*15)+1;
        int playerSpeedRandom = (int) Math.floor(Math.random()*15)+1;
        int rivalHpRandom = (int) Math.floor(Math.random()*15)+1;
        int rivalAttRandom = (int) Math.floor(Math.random()*15)+1;
        int rivalDefRandom = (int) Math.floor(Math.random()*15)+1;
        int rivalSpAttRandom = (int) Math.floor(Math.random()*15)+1;
        int rivalSpDefRandom = (int) Math.floor(Math.random()*15)+1;
        int rivalSpeedRandom = (int) Math.floor(Math.random()*15)+1;

        boolean loop = true;
        String blue = rival.getName().toUpperCase();
        System.out.println("PROF LIVEOAK leads you out of the tall grass back to his lab in the southern half of town.");
        scanner.nextLine();
        System.out.println("As he leads you up the stairs to the floor where his lab is, you see " + blue + " standing there impatiently. Shifting his weight from foot to foot.");
        scanner.nextLine();
        System.out.println(blue + ": Gramps! C'mon! I'm tired of waiting!!");
        scanner.nextLine();
        System.out.println("PROF LIVEOAK: " + blue + "? OH! that's right! I told you you could come too!");
        scanner.nextLine();
        System.out.println(blue + "'s face turned red, you can't tell if he's embarrassed or angry, maybe both?");
        scanner.nextLine();
        System.out.println("Professor Liveoak turns to you...");
        scanner.nextLine();
        System.out.println("PROF LIVEOAK: " + player.getName().toUpperCase() + "! There are 3 POKEMON here! They are inside the POKEBALLS! When I was young, I was a serious TRAINER!\nI travelled the world with my POKEMON partners going on adventures!\nThese 3 POKEMON are descendents of those POKEMON! Choose one " + player.getName().toUpperCase() + " choose whichever one you'd like!");
        scanner.nextLine();
        System.out.println(blue + ": GRAMPS?! WHAT ABOUT ME?!");
        scanner.nextLine();
        System.out.println("PROF LIVEOAK: BE PATIENT...." + "I mean, " + rival.getName() + " you can have one too after he's selected.");
        scanner.nextLine();
        System.out.println("You approach the table nervously, you can feel " + blue + "'s eyes boring DIGLET tunnels into the back of your skull.");
        System.out.println("There are placards in front of the 3 POKEBALLS");
        System.out.println("Who do you choose?");
        while(loop){
            System.out.println("-- BULBASAUR -- CHARMANDER -- SQUIRTLE --");
            String playerChoice = io.getString();
            switch(playerChoice.toUpperCase()){
                case "BULBASAUR":
                    System.out.println("Do you choose the Photosynthesizing Therapsid: BULBASAUR? Y/N");
                    while(true){
                        String answ = io.getString();
                        if(answ.toLowerCase().equals("y")||answ.toLowerCase().equals("yes")){
                            Pokemon bulbasaur = new Bulbasaur(5,playerHpRandom,playerAttRandom,playerDefRandom,playerSpAttRandom,playerSpDefRandom,playerSpeedRandom);
                            player.addPokemonToTeam(bulbasaur);
                            System.out.println("You chose BULBASAUR!!");
                            loop = false;
                            break;
                        }else if(answ.toLowerCase().equals("n")||answ.toLowerCase().equals("no")){
                            System.out.println("Who do you choose?");
                            break;
                        }else{
                            System.out.println("Ooops, there was a typo");
                            scanner.nextLine();
                            System.out.println("Do you want BULBASAUR? Y/N");
                        }
                    }
                    break;
                case "CHARMANDER":
                    System.out.println("Do you choose hard mo...I mean, the Flame tailed Theropod: CHARMANDER? Y/N");
                    while(true){
                        String answ = io.getString();
                        if(answ.toLowerCase().equals("y")||answ.toLowerCase().equals("yes")){
                            Pokemon  charmander = new Charmander(5,playerHpRandom,playerAttRandom,playerDefRandom,playerSpAttRandom,playerSpDefRandom,playerSpeedRandom);
                            player.addPokemonToTeam(charmander);
                            System.out.println("You chose CHARMANDER!!");
                            loop = false;
                            break;
                        }else if(answ.toLowerCase().equals("n")||answ.toLowerCase().equals("no")){
                            System.out.println("Who do you choose?");
                            break;
                        }else{
                            System.out.println("Ooops, there was a typo");
                            scanner.nextLine();
                            System.out.println("Do you want CHARMANDER? Y/N");
                        }
                    }
                    break;
                case "SQUIRTLE":
                    System.out.println("Do you choose the Tiny Water Turtle (wait what's a turtle....) : SQUIRTLE? Y/N");
                    while(true){
                        String answ = io.getString();
                        if(answ.toLowerCase().equals("y")||answ.toLowerCase().equals("yes")){
                            Pokemon squirtle = new Squirtle(5,playerHpRandom,playerAttRandom,playerDefRandom,playerSpAttRandom,playerSpDefRandom,playerSpeedRandom);
                            player.addPokemonToTeam(squirtle);
                            System.out.println("You chose SQUIRTLE!!");
                            loop = false;
                            break;
                        }else if(answ.toLowerCase().equals("n")||answ.toLowerCase().equals("no")){
                            System.out.println("Who do you choose?");
                            break;
                        }else{
                            System.out.println("Ooops, there was a typo");
                            scanner.nextLine();
                            System.out.println("Do you want SQUIRTLE? Y/N");
                        }
                    }
                    break;
                case "PIKACHU":
                    System.out.println("Oh, you think you're clever don't you?");
                    scanner.nextLine();
                    System.out.println("You realize the first Gym leader here uses GROUND types right?");
                    scanner.nextLine();
                    System.out.println("No judgement, but you probably want to stick with BULBASAUR or SQUIRTLE.");
                    System.out.println("Who do you choose?");
                    break;
                default:
                    System.out.println("Ooops, there was a typo");
                    scanner.nextLine();
                    System.out.println("Who do you choose?");
            }
        }
        System.out.println(blue + ": All right! It's MY turn now!");
        System.out.println(blue + " gets a mischievous look in his eye.");
        scanner.nextLine();
        System.out.println(blue + ": I think I'll pick....");
        switch(player.retrieveTeamStarter().getName()){
            case "Bulbasaur":
                Pokemon charmander = new Charmander(5,rivalHpRandom,rivalAttRandom,rivalDefRandom,rivalSpAttRandom,rivalSpDefRandom,rivalSpeedRandom);
                rival.addPokemonToTeam(charmander);
                break;
            case "Charmander":
                Pokemon squirtle = new Squirtle(5,rivalHpRandom,rivalAttRandom,rivalDefRandom,rivalSpAttRandom,rivalSpDefRandom,rivalSpeedRandom);
                rival.addPokemonToTeam(squirtle);
                break;
            case "Squirtle":
                Pokemon bulbasaur = new Bulbasaur(5,rivalHpRandom,rivalAttRandom,rivalDefRandom,rivalSpAttRandom,rivalSpDefRandom,rivalSpeedRandom);
                rival.addPokemonToTeam(bulbasaur);
                break;
        }
        System.out.println(blue + " chose " + rival.retrieveTeamStarter().getName() + "!");
        scanner.nextLine();
        System.out.println("PROF LIVEOAK: Now if a wild POKEMON appears, your POKEMON can help protect you!");
        System.out.println("You get ready to leave when you hear "+blue+" call your name..");
        scanner.nextLine();
        System.out.println(blue + ": " + player.getName().toUpperCase() + "! Let's check out our POKEMON! Come on! I'll take you on!");
        Battle battle = new Battle();
        scanner.nextLine();
        boolean outcome = battle.revisedPokemonBattle(player,rival);
        if(outcome){
            System.out.println(blue + ": SERIOUSLY?! I picked the wrong POKEMON!!");
        }else{
            System.out.println(blue + ": YEAH! Am I great or what!");
        }
        System.out.println(rival.getName().toUpperCase() + ": Okay! I'm going to make my " + rival.retrieveTeamStarter().getName().toUpperCase() + " fight to toughen it up!");
        scanner.nextLine();
        System.out.println(rival.getName().toUpperCase() + ": Smell y'all later!");
        scanner.nextLine();
        System.out.println("PROF LIVEOAK: " + rival.getName().toUpperCase() + "! Wait!");
        scanner.nextLine();
        System.out.println(rival.getName().toUpperCase() + " is already out of earshot.");
        scanner.nextLine();
        System.out.println("PROF LIVEOAK: That boy....well anyways,");
        scanner.nextLine();
        System.out.println("He turns to you...");
        scanner.nextLine();
        System.out.println("PROF LIVEOAK: " + player.getName().toUpperCase() + "! Now that you have your first POKEMON, I need you to do me a huge favor!");
        scanner.nextLine();
        System.out.println("PROF LIVEOAK: I need you to go to VIRIDIAN CITY and pick up a package for me!");
        scanner.nextLine();
        System.out.println(". . . .");
        scanner.nextLine();
        System.out.println("PROF LIVEOAK: Don't worry, now that you have your first POKEMON the wild POKEMON Route 1 won't be a bother.");
        scanner.nextLine();
        System.out.println("PROF LIVEOAK: All right, see you soon!");
        scanner.nextLine();
        System.out.println("You return to the center of the city...");


    }

    public void headToRivalsHouse(Trainer player, Trainer rival, Computer computer){
        boolean loop = true;
        System.out.println("You head over to " + rival.getName() + "'s house. Everyone in town refers to y'all as rivals but you never really understood why. \nPROF LIVEOAK has been friends with your family since even your mom was very little. " + rival.getName() + "'s father never really liked you or your family. Maybe that was why.");
        scanner.nextLine();
        System.out.println("You see DAISY, " + rival.getName() + "'s sister sitting inside. She sees you and waves and gestures to come inside. Would you like to go inside and say hello?");
        while(loop){
            System.out.println("Enter Y/N");
            System.out.println(" ");
            String answ = io.getString();
            if(answ.toLowerCase().equals("y")||answ.toLowerCase().equals("yes")){
                System.out.println("You head inside the LIVEOAK residence and look around");
                scanner.nextLine();
                System.out.println("The house is decorated with items and artifacts that PROF LIVEOAK has collected from around the world.");
                scanner.nextLine();
                System.out.println("A small yellow totem with jagged white teeth, an old hand painted scroll of a giant bird POKEMON with golden feathers painted with mother of CLOYSTER\nso that the wings shine like rainbows.");
                System.out.println("...");
                System.out.println("You see a pedestal holding a small piece of rock inside a glass case");
                scanner.nextLine();
                System.out.println("Something.... draws you towards it.");
                scanner.nextLine();
                System.out.println("The rock looks almost volcanic, like the pieces that wash up from CINNABAR. On the rock are etchings, angular squarish things, writing perhaps?\nYou can't read it. But you can faintly make out the shape of a POKEMON. It looks like it could be a MEOWTH....\nno, the tail is too long and slender, and where is the signature \"coin\" shaped crest on its forehead? You hear footsteps behind you...");
                scanner.nextLine();
                System.out.println("DAISY: You know it's a good thing you're so nice and friendly. One of these days that curiosity is gonna get you into trouble!");
                scanner.nextLine();
                System.out.println("You ask her how she's doing");
                scanner.nextLine();
                System.out.println("DAISY: I'm fine, but you probably came by to see GRANDPA didn't you? Well I don't know where he is at the moment...\nBut " + rival.getName() + " is at Grandpa's lab. Maybe he knows where he is!");
                scanner.nextLine();
                System.out.println("DAISY: All right see you later!");
                scanner.nextLine();
                loop = false;
            }else if(answ.toLowerCase().equals("n")||answ.toLowerCase().equals("no")){
                System.out.println("DAISY has always been like a big sister to you even when the whole town treats you kinda funny. But you have places to be!");
                scanner.nextLine();
                System.out.println("You head back to the center of town.");
                scanner.nextLine();
                loop = false;
            }else{
                System.out.println("Oops, there was a typo!");
            }
        }
    }

    public void headToSouthernHalfOfTown(Trainer player, Trainer rival, Computer computer){
        boolean southernLoop = true;
        System.out.println(" ");
        System.out.println("You head to the southern half of Pallet Town");
        scanner.nextLine();
        System.out.println("You see PROF LIVEOAK's lab to the EAST side of town and to the WEST of town is the bay leading to the Kanjoh Sea. Town Center is behind you");
        scanner.nextLine();
        System.out.println(" ");
        while(southernLoop){
            System.out.println("Where would you like to go?");
            System.out.println("LAB -- BAY -- CENTER");
            String answ = io.getString();
            switch(answ.toUpperCase()){
                case "LAB":
                    visitLab(player,rival,computer);
                    southernLoop = false;
                    break;
                case "BAY":
                    visitBay(player,rival,computer);
                    southernLoop = false;
                    break;
                case "CENTER":
                    //return to Town
                    southernLoop = false;
                    break;
                default:
                    System.out.println("Sorry, there might be a typo.");
                    System.out.println("");
            }

        }
    }

    public void visitBay(Trainer player, Trainer rival, Computer computer){
        boolean convoLoop = true;
        System.out.println("You approach the bay. The water looks crystal clear. In the far off distance you can almost make out the shape of the first island in the Cinnabar archipocho\n...archipello...archi....dang it, that word is always hard for you to pronounce...");
        scanner.nextLine();
        System.out.println("You see a stout man standing by the shore, he smells.....kinda ODD...ISHLY, like an ODDISH or something....");
        scanner.nextLine();
        while(convoLoop){
            System.out.println("Speak to the man? Y/N");
            String answ = io.getString();
            if(answ.toLowerCase().equals("y")||answ.toLowerCase().equals("yes")){
                convoLoop = false;
                System.out.println("You approach the man to say hello");
                scanner.nextLine();
                System.out.println("MAN: Oh hey there little dude!");
                scanner.nextLine();
                System.out.println("MAN: You coming out to see the sea too? I like coming here to think.");
                scanner.nextLine();
                System.out.println(". . .");
                scanner.nextLine();
                System.out.println("MAN: Think about what? Oh I dunno, like you know how we can store POKEMON and ITEMS as virtual data and then render them back into matter?");
                scanner.nextLine();
                System.out.println("MAN: They say the energy field that causes POKEMON to EVOLVE is what allows them to be stored as energy in POKEBALLS. That's why they don't work on people.");
                scanner.nextLine();
                System.out.println("MAN: What if we're all already inside one giant POKEBALL little dude? But they forgot to let us out....");
                scanner.nextLine();
                System.out.println("The man continues to stare out at the sea....He's nice enough...but kinda weird....this must be why your Mom cautioned you when talking to strangers.....");
                scanner.nextLine();
                boolean loop = true;
                while(loop){
                    System.out.println("There's not much else to do here, head to the LAB? Y/N");
                    answ = io.getString();
                    if(answ.toLowerCase().equals("y")||answ.toLowerCase().equals("yes")){
                        loop = false;
                        visitLab(player, rival, computer);
                    }else if(answ.toLowerCase().equals("n")||answ.toLowerCase().equals("no")){
                        loop = false;
                        System.out.println("Let's head back to the center of town then...");
                        //return to center of town;
                    }else{
                        System.out.println("Oops, there's a typo!");
                    }
                }
            }else if(answ.toLowerCase().equals("n")||answ.toLowerCase().equals("no")){
                convoLoop = false;
                System.out.println("He seems lost in thought, best not to bother him.");
                scanner.nextLine();
                System.out.println("Let's head to the LAB!");
                scanner.nextLine();
                visitLab(player,rival,computer);

            }else{
                System.out.println("Oops, there's a typo!");
            }
        }

    }

    public void visitLab(Trainer player, Trainer rival, Computer computer){
        boolean southernLoop = true;
        boolean northernLoop = true;
        boolean inspectLoop = true;
        System.out.println("You approach PROF LIVEOAK's lab. You look across the road to see a large pasture of POKEMON. A TAUROS feeds silently while a flock of PIDGEY flies by.");
        scanner.nextLine();
        System.out.println("You approach the large glass doors of the laboratory, do you go inside? Y/N");
        String yesNo = io.getString();
        if(yesNo.toLowerCase().equals("y")||yesNo.toLowerCase().equals("yes")){
            System.out.println("You enter the lab, a giant metal and glass structure with large floor to ceiling windows that look out into the sprawling fields below.");
            scanner.nextLine();
            System.out.println("You look around and see several research associates analyzing data on large monitors. Who do you want to talk to?");
            while(southernLoop){
                String rivalName = rival.getName();
                System.out.println("--ScientistA--ScientistB--ScientistC--");
                String answ = io.getString();
                switch(answ.toUpperCase()){
                    case "SCIENTISTA":
                        System.out.println("I study POKEMON endemic to KANTO in PROF LIVEOAK's lab!");
                        scanner.nextLine();
                        System.out.println("Did you know that KANTO once had almost 300 kinds of POKEMON native to this region?");
                        scanner.nextLine();
                        System.out.println("Do you want to talk to anyone else? Y/N");
                        answ = io.getString();
                        if(answ.toLowerCase().equals("yes")||answ.toLowerCase().equals("y")){
                            break;
                        }else if(answ.toLowerCase().equals("no")||answ.toLowerCase().equals("n")){
                            southernLoop = false;
                            break;
                        }else{
                            System.out.println("Oops! There's a typo!");
                            System.out.println("");
                            break;
                        }
                    case "SCIENTISTB":
                        System.out.println("I help PROF LIVEOAK study the KANTO POKEMON repopulation program!");
                        scanner.nextLine();
                        System.out.println("Did you know that many species that used to live in KANTO are still alive and thriving in other parts of the world?");
                        scanner.nextLine();
                        System.out.println(" ");
                        System.out.println("Do you want to talk to anyone else? Y/N");
                        answ = io.getString();
                        if(answ.toLowerCase().equals("yes")||answ.toLowerCase().equals("y")){
                            break;
                        }else if(answ.toLowerCase().equals("no")||answ.toLowerCase().equals("n")){
                                 southernLoop = false;
                                break;
                        }else{
                            System.out.println("Oops! There's a typo!");
                            System.out.println("");
                            break;
                    }
                    case "SCIENTISTC":
                        System.out.println("PROF LIVEOAK is the authority on POKEMON migrations! His colleagues across the world hold him in high regard!");
                        scanner.nextLine();
                        System.out.println("Did you know PROF LIVEOAK traveled the world to study where KANTO's POKEMON originated?");
                        scanner.nextLine();
                        System.out.println(" ");
                        System.out.println("Do you want to talk to anyone else? Y/N");
                        answ = io.getString();
                        if(answ.toLowerCase().equals("yes")||answ.toLowerCase().equals("y")){
                            break;
                        }else if(answ.toLowerCase().equals("no")||answ.toLowerCase().equals("n")){
                            southernLoop = false;
                            break;
                        }else{
                            System.out.println("Oops! There's a typo!");
                            System.out.println("");
                            break;
                    }
                    default:
                        System.out.println("Oops! There's a typo!");
                        System.out.println("");

                }
            }
            System.out.println("You walk north further into the lab. You see a table with three POKEBALLS resting on top. " + rival.getName() + " is standing flipping thru his phone,\n it sounds like he is watching a match.");
            scanner.nextLine();
            while(northernLoop){
                System.out.println("What do you do?");
                System.out.println("--INSPECT--RIVAL");
                String answ = io.getString();
                if(answ.toUpperCase().equals("INSPECT")){
                    System.out.println(" ");
                    while(inspectLoop){
                        System.out.println("What would you like to inspect?");
                        System.out.println("--TABLE--COMPUTER--DESK--DISPLAY");
                        answ = io.getString();
                        switch(answ.toUpperCase()){
                            case "TABLE":
                                System.out.println("You approach the three POKEBALLS closer. You haven't actually ever held one before. Are they...vibrating?");
                                scanner.nextLine();
                                System.out.println("You reach out to touch one...actually....on second thought, maybe not");
                                scanner.nextLine();
                                System.out.println("Do you want to inspect anything else? Y/N");
                                answ = io.getString();
                                if(answ.toLowerCase().equals("yes")||answ.toLowerCase().equals("y")){
                                    break;
                                }else if(answ.toLowerCase().equals("no")||answ.toLowerCase().equals("n")){
                                    inspectLoop = false;
                                    break;
                                }else{
                                    System.out.println("Oops! There's a typo!");
                                }
                            case "COMPUTER":
                                System.out.println("You approach the computer, the screen is locked");
                                scanner.nextLine();
                                System.out.println("You see a picture of PROF LIVEOAK with DAISY and " + rival.getName() + " MAGIKARP fishing.");
                                scanner.nextLine();
                                System.out.println("...");
                                System.out.println("There's another picture on his desk.");
                                scanner.nextLine();
                                System.out.println("Huh, it's a picture of him with you and your mom from when you were very little. Your snowsuit makes you look like a little TEDIURSA and you're building \nsnow SNORUNTS!");
                                scanner.nextLine();
                                System.out.println("That's so weird.....you've never seen this picture before....");
                                scanner.nextLine();
                                System.out.println("Do you want to inspect anything else? Y/N");
                                answ = io.getString();
                                if(answ.toLowerCase().equals("yes")||answ.toLowerCase().equals("y")){
                                    break;
                                }else if(answ.toLowerCase().equals("no")||answ.toLowerCase().equals("n")){
                                    inspectLoop = false;
                                    break;
                                }else{
                                    System.out.println("Oops! There's a typo!");
                                }
                            case "DESK":
                                System.out.println("You approach the desk, you see what looks like a red tablet lying on top");
                                scanner.nextLine();
                                System.out.println("It looks expensive, best not to touch it");
                                scanner.nextLine();
                                System.out.println("Do you want to inspect anything else? Y/N");
                                answ = io.getString();
                                if(answ.toLowerCase().equals("yes")||answ.toLowerCase().equals("y")){
                                    break;
                                }else if(answ.toLowerCase().equals("no")||answ.toLowerCase().equals("n")){
                                    inspectLoop = false;
                                    break;
                                }else{
                                    System.out.println("Oops! There's a typo!");
                                }
                            case "DISPLAY":
                                System.out.println("You see a glass display that looks like it's hooked up to expensive equipment, what's inside....");
                                scanner.nextLine();
                                System.out.println("It's just....a single piece of pinkish-white hair? What's so special about that?");
                                scanner.nextLine();
                                System.out.println("Do you want to inspect anything else? Y/N");
                                answ = io.getString();
                                if(answ.toLowerCase().equals("yes")||answ.toLowerCase().equals("y")){
                                    break;
                                }else if(answ.toLowerCase().equals("no")||answ.toLowerCase().equals("n")){
                                    inspectLoop = false;
                                    break;
                                }else{
                                    System.out.println("Oops! There's a typo!");
                                }
                            default:
                                System.out.println("Oops! There's a typo!");
                        }
                    }
                }else if(answ.toUpperCase().equals("RIVAL")){
                    System.out.println(rival.getName().toUpperCase()+": Oh....it's you...");
                    scanner.nextLine();
                    System.out.println(rival.getName().toUpperCase()+": Gramps isn't here, he's out looking for you.");
                    scanner.nextLine();
                    System.out.println(rival.getName().toUpperCase()+": Well I dunno where he is. Leave me alone, this match is good. This GENGAR is going to destroooyyy this JIGGLYPUFF.\nWhat kind of a moron would send out a FAIRY type against a POISON type??");
                    scanner.nextLine();
                    System.out.println("He looks busy, you should probably get going to find PROF LIVEOAK");
                    scanner.nextLine();
                    System.out.println("You wave goodbye to the research associates");
                    scanner.nextLine();
                    northernLoop = false;
                    System.out.println(" ");
                    System.out.println("You head back to the center of Pallet Town");
                    scanner.nextLine();
                }else{
                    System.out.println("Oops, there might be a typo!");
                    System.out.println("");
                }
            }
        }
        if(yesNo.toLowerCase().equals("n")||yesNo.toLowerCase().equals("no")){
            System.out.println("You peek inside and can't see PROF LIVEOAK, maybe he's somewhere else in town");
            scanner.nextLine();
            System.out.println("You head back to the center of town");
            scanner.nextLine();
        }
        //ifno
    }
}
