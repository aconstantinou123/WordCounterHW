package com.wordcounter.codeclan.wordcounterhw;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class WordCounterActivity extends AppCompatActivity {

    EditText editText;
    Button wordCountButton;
    Button wordOccurrenceButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_counter);

        editText = findViewById(R.id.inputText);
        wordCountButton = findViewById(R.id.wordCountButton);
        wordOccurrenceButton = findViewById(R.id.occurencesButton);
    }

    public void onButtonWordCounterButtonClick(View view){
        InputMethodManager inputManager = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);
        inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                InputMethodManager.HIDE_NOT_ALWAYS);
        String sentence = editText.getText().toString();
        Log.d(getClass().toString(), "The question asked was " + sentence );
        WordCounter wordCounter = new WordCounter();
        String answer = wordCounter.getWordCount(sentence);
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("wordCount", answer);
        startActivity(intent);

    }

    public void onButtonClickOccurrence(View view){
        InputMethodManager inputManager = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);
        inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                InputMethodManager.HIDE_NOT_ALWAYS);
        String sentence = editText.getText().toString();
        WordCounter wordCounter = new WordCounter();
        String answer = wordCounter.countWordOccurence(sentence);
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("wordCount", answer);
        startActivity(intent);

    }


}
