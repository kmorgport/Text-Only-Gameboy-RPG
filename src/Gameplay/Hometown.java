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

    }
}
