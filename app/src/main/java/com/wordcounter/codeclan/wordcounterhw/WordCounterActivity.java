package com.wordcounter.codeclan.wordcounterhw;

import android.content.Context;
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
    TextView textView;
    Button wordCountButton;
    Button wordOccurrenceButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_counter);

        editText = findViewById(R.id.inputText);
        textView = findViewById(R.id.answer);
        wordCountButton = findViewById(R.id.wordCountButton);
        wordOccurrenceButton = findViewById(R.id.occurencesButton);
        textView.setMovementMethod(new ScrollingMovementMethod());
    }

    public void onButtonWordCounterButtonClick(View view){
        InputMethodManager inputManager = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);
        inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                InputMethodManager.HIDE_NOT_ALWAYS);
        String sentence = editText.getText().toString();
        Log.d(getClass().toString(), "The question asked was " + sentence );
        WordCounter wordCounter = new WordCounter();
        textView.setText(wordCounter.getWordCount(sentence));

    }

    public void onButtonClickOccurence(View view){
        InputMethodManager inputManager = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);
        inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                InputMethodManager.HIDE_NOT_ALWAYS);
        String sentence = editText.getText().toString();
        WordCounter wordCounter = new WordCounter();
        textView.setText(wordCounter.countWordOccurence(sentence));
    }


}
