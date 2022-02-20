package com.chudnovskiy.devcolibri_l10_onactivityresult_requestcode.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.chudnovskiy.devcolibri_l10_onactivityresult_requestcode.R;

import java.util.Objects;

public class LanguageActivity extends AppCompatActivity {
    public static final String LANGUAGE = "language";
    private Button buttonEng;
    private Button buttonRus;
    private Button buttonUkr;
    private final Intent intent = new Intent();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language);
        Objects.requireNonNull(getSupportActionBar()).hide();

        buttonEng = (Button) findViewById(R.id.button_eng);
        buttonRus = (Button) findViewById(R.id.button_rus);
        buttonUkr = (Button) findViewById(R.id.button_ukr);

        buttonEng.setOnClickListener(view -> {
            intent.putExtra(LANGUAGE, buttonEng.getText().toString());
            setResult(RESULT_OK, intent);
            finish();
        });

        buttonRus.setOnClickListener(view -> {
            intent.putExtra(LANGUAGE, buttonRus.getText().toString());
            setResult(RESULT_OK, intent);
            finish();
        });

        buttonUkr.setOnClickListener(view -> {
            intent.putExtra(LANGUAGE, buttonUkr.getText().toString());
            setResult(RESULT_OK, intent);
            finish();
        });
    }
}