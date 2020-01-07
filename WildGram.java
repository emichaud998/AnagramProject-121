public class WildGram{

   public static int[] alphaString= new int[27];//Array scoreboard of alphabet (index 0-25 for a-z, and index 26 for *) 
   
   public static void alphaScore(String s){//Tallys each letter in the left string on the alphabet scoreboard
      s=s.toLowerCase();//Capitilization does not matter in anagrams (make all lowercase)
      char ch;
      int pos= 0;
      for (int j=0; j<s.length(); j++){
        ch= s.charAt(j);
        pos=ch-'a';//Gives each letter a number 0-25 for the array scoreboard
        if (Character.isLetter(ch)){//Ignores all spaces and punctuation
           alphaString[pos]++;//Increases the value of each numbered letter index by 1 each time the letter appears in the String 
        }
      } 
   }
   
   public static boolean whatsLeft(){//Adds up the amount of letters left and subtracts * in the right string
      int total=0;
      for (int j=0; j<=(alphaString.length-2); j++){
         total= total+ alphaString[j];
      }
      if (total-alphaString[26]==0){//*'s can act as any letter, if subtracting them from letters left=0 it is anagram 
         return true;}
      else{
         return false;
      } 
   }

   public static boolean isWildGram(String l, String r){//Passed left and right string and checks if it is an anagram
      alphaScore(l);//Tallys the left string letters on array scoreboard 
      r=r.toLowerCase();
      char ch;
      int pos=0;
      boolean anagram=true;
      for (int j=0; j<r.length(); j++){
        ch= r.charAt(j);
        pos= ch-'a';
        if (Character.isLetter(ch)){
           if (alphaString[pos]>0){//If index value of letter in right string has greater value than 1 in array then left string has at least one of those letters
            alphaString[pos]--;}//Lowers count of letter on scoreboard by 1
           else{
            anagram=false;//If letter in right string not found in left string- not anagram
            return anagram;}
        }
        if (ch=='*'){//If * found in right string- store the amount of * in index 26 of array
           alphaString[26]++;}
        }
      anagram=whatsLeft();
      return anagram;
  }  
}        