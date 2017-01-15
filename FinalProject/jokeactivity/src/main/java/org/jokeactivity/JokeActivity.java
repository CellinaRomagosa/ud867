package org.jokeactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {

  public static final String INTENT_JOKE_KEY = "intentJokeKey";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_joke);
    String joke = getIntent().getExtras().getString(INTENT_JOKE_KEY, "emtpy joke");
    displayJoke(joke);
  }

  private void displayJoke(String joke){
    TextView jokeTextView = (TextView)this.findViewById(R.id.textJoke);
    jokeTextView.setText(joke);
  }
}
