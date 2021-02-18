package Gameplay;
import pc.Computer;
import trainers.Trainer;
import util.Input;

public class Hometown {
    Input io;
    public Hometown(){}

    public void navigateHomeTown(Trainer player, Trainer rival, Computer computer){
        boolean storyInput = false;
        io = new Input();
        System.out.println("You step outside and hear the buzz of NINJASKS in the trees");
        System.out.println("With your HOME behind you , to the EAST you see your rival, " + rival.getName() + "'s house. To the SOUTH you see PROFESSOR LIVEOAK'S lab and a small gulf. To the NORTH you see a lone road leading out of town to some fields.");
        System.out.println(" ");
        System.out.println("Which path do you choose?: NORTH -- EAST -- SOUTH -- HOME");
        String answ = io.getString();
        switch(answ.toUpperCase()){
            case "NORTH":
                leaveHomeTown(player, rival, computer);
                break;
            case "EAST":
                //go to rivals house
                break;
            case "SOUTH":
                //go to lab
                //go to gulf -- talk to dude by river
                break;
            case "HOME":
                //return home
                break;
        }
    }

    public void leaveHomeTown(Trainer player, Trainer rival, Computer computer){
        System.out.println(" - - - - - - - -");
        System.out.println("You start heading towards the grassy path leaving Pallet Town, excited to start your new adventure!");
        System.out.println("As soon as your foot steps into the tall grass you hear a voice shouting your name:");
        System.out.println("PROF LIVEOAK: " + player.getName() + "!!" + player.getName() + "!! Stop!!\n Don't go out!");
        System.out.println("PROF LIVEOAK runs up to you, slightly out of breath.");
        System.out.println("PROF LIVEOAK: It's unsafe! Wild POKEMON live in tall grass! You need your own\n POKEMON for your protection. I know! Here, come with me!");
        //go to lab method

    }

    public void headToRivalsHouse(Trainer player, Trainer rival, Computer computer){
        System.out.println("You head over to " + rival.getName() + "'s house. Everyone in town refers to y'all as rivals but you never really understood why. PROF LIVEOAK has been friends with your family since even your mom was very little./n" + rival.getName() + "'s father never really liked you or your family. Maybe that was why.");
        System.out.println(" ");
        System.out.println("You see DAISY, " + rival.getName() + "'s sister sitting inside. She sees you and waves and gestures to come inside. Would you like to go inside and say hello?");
        System.out.println(" ");
        String answ = io.getString();
        //if answ is yes
        System.out.println("You head inside the OAK residence and look around");
        System.out.println("The house is decorated with items and artifacts that PROF LIVEOAK has collected from around the world");
        System.out.println(" ");
        System.out.println("A small yellow totem with jagged white teeth, an old hand painted scroll of a giant bird POKEMON with golden feathers painted with mother of CLOYSTER so that the wings shine like rainbows.");
        System.out.println("...");
        System.out.println("You see a pedestal holding a small piece of rock inside a glass case");
        System.out.println("Something, curiosity perhaps, draws you towards it.");
        System.out.println("The rock looks almost volcanic, like the pieces that wash up from CINNABAR. On the rock are etchings, angular squarish things, writing perhaps? You can't read it. But you can faintly make out the shape of a POKEMON.\n It looks like it could be a MEOWTH....no, the tail is too long and slender, and where is the signature \"coin\" shaped crest on its forehead? You hear footsteps behind you...");
        System.out.println("DAISY: You know it's a good thing you're so nice and friendly. One of these days that curiosity is gonna get you into trouble!");
        System.out.println("You ask her how she's doing");
        System.out.println("DAISY: I'm fine, but you probably came by to see GRANDPA didn't you? Well I don't know where he is at the moment...\n But " + rival.getName() + " is at Grandpa's lab. Maybe he knows where he is!");
        System.out.println("DAISY: All right see you later!");
        //if no
        System.out.println("DAISY has always been like a big sister to you even when the whole town treats you kinda funny. But you have places to be!");
    }

    public void headToSouthernHalfOfTown(Trainer player, Trainer rival, Computer computer){
        boolean loop = true;
        System.out.println(" ");
        System.out.println("You head to the southern half of Pallet Town");
        System.out.println("You see PROF LIVEOAK's lab to the EAST side of town and to the WEST of town is the bay leading to the Kanjoh Sea. Town Center is behind you");
        System.out.println(" ");
        while(loop)
        System.out.println("Where would you like to go?");
        System.out.println("LAB -- BAY -- CENTER");
        String answ = io.getString();
        switch(answ.toUpperCase()){
            case "LAB":
                //visitLab
                loop = false;
                break;
            case "BAY":
                //visitBay
                loop = false;
                break;
            case "CENTER":
                //return to Town
                loop = false;
                break;
            default:
                System.out.println("Sorry, there might be a typo.");
        }

    }

    public void visitLab(Trainer player, Trainer rival, Computer computer){
        boolean southernLoop = true;
        boolean northernLoop = true;
        boolean inspectLoop = true;
        System.out.println("You approach PROF LIVEOAK's lab. You look across the road to see a large pasture of POKEMON. A TAUROS feeds silently while a flock of PIDGEY flies by.");
        System.out.println("You approach the large glass doors of the laboratory, do you go inside? Y/N");
        //if yes
        System.out.println("You enter the lab, a giant metal and glass structure with large floor to ceiling windows that look out into the sprawling fields below.");
        System.out.println("You look around and see several research associates analyzing data on large monitors. Who do you want to talk to?");
        while(southernLoop){
            String rivalName = rival.getName();
            System.out.println("--ScientistA--ScientistB--ScientistC--");
            String answ = io.getString();
            switch(answ.toUpperCase()){
                case "SCIENTISTA":
                    System.out.println("I study POKEMON endemic to KANTO in PROF LIVEOAK's lab!");
                    System.out.println("Did you know that KANTO once had almost 300 kinds of POKEMON native to this region?");
                    System.out.println(" ");
                    System.out.println("Do you want to talk to anyone else? Y/N");
                    answ = io.getString();
                    if(answ.toLowerCase().equals("yes")||answ.toLowerCase().equals("y")){
                        break;
                    }else{
                        southernLoop = false;
                        break;
                    }
                case "SCIENTISTB":
                    System.out.println("I help PROF LIVEOAK study the KANTO POKEMON repopulation program!");
                    System.out.println("Did you know that many species that used to live in KANTO are still alive and thriving in other parts of the world?");
                    System.out.println(" ");
                    System.out.println("Do you want to talk to anyone else? Y/N");
                    answ = io.getString();
                    if(answ.toLowerCase().equals("yes")||answ.toLowerCase().equals("y")){
                        break;
                    }else{
                        southernLoop = false;
                        break;
                    }
                case "SCIENTISTC":
                    System.out.println("PROF LIVEOAK is the authority on POKEMON migrations! His colleagues across the world hold him in high regard!");
                    System.out.println("Did you know PROF LIVEOAK traveled the world to study where KANTO's POKEMON originated?");
                    System.out.println(" ");
                    System.out.println("Do you want to talk to anyone else? Y/N");
                    answ = io.getString();
                    if(answ.toLowerCase().equals("yes")||answ.toLowerCase().equals("y")){
                        break;
                    }else{
                        southernLoop = false;
                        break;
                    }
                default:
                    System.out.println("Sorry, there might be a typo.");

            }
        }
        System.out.println("You walk north further into the lab. You see a table with three POKEBALLS resting on top. " + rival.getName() + " is standing flipping thru his phone, it sounds like he is watching a match.");
        System.out.println(" ");
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
                            System.out.println("You reach out to touch one...actually....on second thought, maybe not");
                            System.out.println(" ");
                            System.out.println("Do you want to inspect anything else? Y/N");
                            answ = io.getString();
                            if(answ.toLowerCase().equals("yes")||answ.toLowerCase().equals("y")){
                                break;
                            }else{
                                inspectLoop = false;
                                break;
                            }
                        case "COMPUTER":
                            System.out.println("You approach the computer, the screen is locked");
                            System.out.println("You see a picture of PROF LIVEOAK with DAISY and " + rival.getName() + " MAGIKARP fishing.");
                            System.out.println("...");
                            System.out.println("There's another picture on his desk");
                            System.out.println("Huh, it's a picture of him with you and your mom from when you were very little. Your snowsuit makes you look like a little TEDIURSA and you're building snow SNORUNTS");
                            System.out.println("That's so weird.....you've never seen this picture before'....");
                            System.out.println(" ");
                            System.out.println("Do you want to inspect anything else? Y/N");
                            answ = io.getString();
                            if(answ.toLowerCase().equals("yes")||answ.toLowerCase().equals("y")){
                                break;
                            }else{
                                inspectLoop = false;
                                break;
                            }
                        case "DESK":
                            System.out.println("You approach the desk, you see what looks like a red tablet lying on top");
                            System.out.println("It looks expensive, best not to touch it");
                            System.out.println(" ");
                            System.out.println("Do you want to inspect anything else? Y/N");
                            answ = io.getString();
                            if(answ.toLowerCase().equals("yes")||answ.toLowerCase().equals("y")){
                                break;
                            }else{
                                inspectLoop = false;
                                break;
                            }
                        case "DISPLAY":
                            System.out.println("You see a glass display that looks like it's hooked up to expensive equipment, what's inside....");
                            System.out.println("...");
                            System.out.println("It's just....a single piece of pinkish-white hair? What's so special about that?");
                            System.out.println(" ");
                            System.out.println("Do you want to inspect anything else? Y/N");
                            answ = io.getString();
                            if(answ.toLowerCase().equals("yes")||answ.toLowerCase().equals("y")){
                                break;
                            }else{
                                inspectLoop = false;
                                break;
                            }
                        default:
                            System.out.println("Sorry, there might be a typo.");
                    }
                }
            }else if(answ.toUpperCase().equals("RIVAL")){
                System.out.println("Oh....it's you...");
                System.out.println("Gramps isn't here, he's out looking for you.");
                System.out.println("Well I dunno where he is, leave me alone, this match is good. This GENGAR is going to destroooyyy this JIGGLYPUFF.\n What kind of a moron would send out a FAIRY type against a POISON type??");
                System.out.println("");
                System.out.println("He looks busy, you should probably get going to find PROF LIVEOAK");
                System.out.println(" ");
                System.out.println("You wave goodbye to the research associates");
                northernLoop = false;
            }
        }
        //ifno
    }
}
