package org.joke;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class JokeTeller {

  private static final String joke1 = "I dreamt I was forced to eat a giant marshmallow. When I woke up, my pillow was gone.";
  private static final String joke2 = "For Sale: Parachute. Used once, never opened, small stain.";
  private static final String joke3 = "A German, an American and a Russian walk into a bar.\n" +
      "The bartender looks at them suspiciously and says, “Is this some kind of a joke?";
  private static final String joke4 = "What do you call people who use the temperature method of contraception? \n Parents";


  private List<String> jokeList;

  public JokeTeller(){
    jokeList = new ArrayList<>(4);
    jokeList.add(joke1);
    jokeList.add(joke2);
    jokeList.add(joke3);
    jokeList.add(joke4);

  }

  public String getRandomJoke(){
    Random random = new Random();
    return jokeList.get(random.nextInt(jokeList.size()));
  }
}
