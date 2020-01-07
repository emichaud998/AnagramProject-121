import java.util.Scanner;

public class WildTester{
   public static void main(String[] args){
  
      Scanner scan= new Scanner(System.in);
      System.out.println("Enter First Phrase:");
      String left= scan.nextLine();
      System.out.println("Enter Second Phrase:");
      String right= scan.nextLine();
      
      boolean anagram= WildGram.isWildGram(left, right);//places if true or false into variable anagram
      System.out.println("Wild Anagram?"+ anagram); 
   }
}