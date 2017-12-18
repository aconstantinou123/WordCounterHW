package com.wordcounter.codeclan.wordcounterhw;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class WordCounterActivity extends AppCompatActivity {

    EditText editText;
    TextView textView;
    Button wordCountButton;
    Button wordOccurenceButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_counter);

        editText = findViewById(R.id.inputText);
        textView = findViewById(R.id.answer);
        wordCountButton = findViewById(R.id.wordCountButton);
        wordOccurenceButton = findViewById(R.id.occurencesButton);
    }

    public void onButtonWordCounterButtonClick(View view){
        String sentence = editText.getText().toString();
        Log.d(getClass().toString(), "The question asked was " + sentence );
        WordCounter wordCounter = new WordCounter();
        textView.setText(wordCounter.getWordCount(sentence));

    }

    @TargetApi(Build.VERSION_CODES.O)
    public void onButtonClickOccurence(View view){
        String sentence = editText.getText().toString();
        WordCounter wordCounter = new WordCounter();
        textView.setText(wordCounter.countWordOccurence(sentence));
    }


}
