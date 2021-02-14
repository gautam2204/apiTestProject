package OOPS;

public class Greeter {

    public void helloWorld(Greeting greeting)
    {
    greeting.perform();
    }

  public static void main(String[] args) {
    Greeter greeter = new Greeter();
    Greeting helloWorldGreeting = new HelloWorldGreeting();
    greeter.helloWorld(helloWorldGreeting);
    Greeting newWorldGreeting = new NewWorldGreeting();
    greeter.helloWorld(newWorldGreeting);
  }
}
