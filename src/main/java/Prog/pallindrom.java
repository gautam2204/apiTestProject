package Prog;

import org.junit.Assert;

public class pallindrom {
  public static void main(String[] args) {

      String check = "02/02/20/20";
      char[] chars = check.toCharArray();
      StringBuilder rev = new StringBuilder();

      for (int i=chars.length-1;i>=0;i--)
      {
          rev.append(chars[i]);
      }

    System.out.println("Rev String = "+rev);

      Boolean val =  checkPallindrom(check, rev.toString());
    Assert.assertEquals("Check the value",true,val);
  }

    private static Boolean checkPallindrom(String check, String rev) {
      return check.equals(rev);

    }
}
