package com.wordcounter.codeclan.wordcounterhw;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    TextView results;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        results = findViewById(R.id.result_view);
        results.setMovementMethod(new ScrollingMovementMethod());
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String answer = extras.getString("wordCount");
        results.setText(answer);
    }
}
