package util;

import java.util.Scanner;

public class Input {
    protected Scanner scanner;

    public Input(){
        this.scanner = new Scanner(System.in);
    }

    public String getString(){
//        System.out.println("Enter a string:");
        return this.scanner.nextLine();
    }

    public boolean yesNo(){
        System.out.println("Enter yes or no");
        String answer = this.scanner.nextLine();
        return(answer.toLowerCase().equals("y")||answer.toLowerCase().equals("yes"));
    }

    public int getInt() throws NumberFormatException{
//        System.out.println("Enter an integer");
        String s = getString();
        try{
            return Integer.parseInt(s);
        } catch(NumberFormatException e){
            System.err.println("This is not an integer");
            return getInt();
        }
    }

    public int getInt(int min, int max){
        while(true){
            System.out.println("Enter an integer between "+min+" and "+max+".");
            int answer = this.scanner.nextInt();
            if(answer>= min && answer<= max)
                return answer;
        }
    }

    public double getDouble() throws NumberFormatException{
        System.out.println("Enter a double: ");
        String s = getString();
        try{
            return Double.parseDouble(s);
        } catch(NumberFormatException e){
            System.err.println("This is not a Double");
            return getDouble();
        }
    }

}