package Prog;

import java.util.Locale;

public class ChangeCharacter {

  public static void main(String[] args) {
    /*print string gAuTaM*/
      String str = "abcdjkjsjWWW".toLowerCase(Locale.ENGLISH);
    System.out.println(str);
    int length=str.length();
    String newString = "";
    char[] chars = str.toCharArray();
    for (int i=0;i<length;i++)
    {
        if(i%2==0)
        {
           newString+= chars[i];
        }
        else
            newString+=Character.toUpperCase(chars[i]);
    }

    System.out.println("New String = "+newString);
  }
}
