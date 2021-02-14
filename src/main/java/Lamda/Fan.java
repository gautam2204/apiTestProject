package Lamda;

public class Fan {




  public static void main(String[] args) {
      PrintLamdaExpression printLamda=()->System.out.println("Name is gautam");

      CHekMultiply checkMultiply=(int a, int b) ->{
          if(a==0 || b==0) return 0;
          return a*b;
      };
  }

}

interface PrintLamdaExpression
{
    public void FuntionalInterfaceMethod();
}

interface CHekMultiply
{
    public int multipy(int a,int b);
}
