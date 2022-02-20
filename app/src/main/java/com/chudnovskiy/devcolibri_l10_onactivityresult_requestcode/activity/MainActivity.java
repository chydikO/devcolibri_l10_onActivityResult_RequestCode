package com.chudnovskiy.devcolibri_l10_onactivityresult_requestcode.activity;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.chudnovskiy.devcolibri_l10_onactivityresult_requestcode.R;

import java.util.Objects;

import util.RequestCode;

public class MainActivity extends AppCompatActivity {

    private Intent intent;
    private TextView textViewName;
    private TextView textViewLanguage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Objects.requireNonNull(getSupportActionBar()).hide();

        Button buttonPresented = (Button) findViewById(R.id.button_presented);
        Button buttonLanguage = (Button) findViewById(R.id.button_language);
        textViewName = (TextView) findViewById(R.id.text_view_name);
        textViewLanguage = (TextView) findViewById(R.id.text_view_language);

        buttonPresented.setOnClickListener(view -> {
            intent = new Intent(getApplicationContext(), PresentedActivity.class);
            startActivityForResult(intent, RequestCode.REQUEST_CODE_PRESENTED);
        });

        buttonLanguage.setOnClickListener(view -> {
            intent = new Intent(getApplicationContext(), LanguageActivity.class);
            startActivityForResult(intent, RequestCode.REQUEST_CODE_LANGUAGE);
        });

        //TODO: не сохраняются данные приперевороте устроуста, необходимо переделать на ViewModel
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case RequestCode.REQUEST_CODE_PRESENTED: {
                    String name = data.getStringExtra(PresentedActivity.NAME);
                    textViewName.setText(textViewName.getText().toString() + " " + name);
                    break;
                }
                case RequestCode.REQUEST_CODE_LANGUAGE: {
                    String language = data.getStringExtra(LanguageActivity.LANGUAGE);
                    textViewLanguage.setText(textViewLanguage.getText().toString() + " " + language);
                    break;
                }
            }
        } else {
            Toast.makeText(getApplicationContext(), "Error !!!", Toast.LENGTH_LONG).show();
        }
    }
}