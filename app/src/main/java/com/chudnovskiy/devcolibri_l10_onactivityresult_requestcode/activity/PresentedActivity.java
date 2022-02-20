package com.chudnovskiy.devcolibri_l10_onactivityresult_requestcode.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.chudnovskiy.devcolibri_l10_onactivityresult_requestcode.R;

import java.util.Objects;

public class PresentedActivity extends AppCompatActivity {
    public static final String NAME = "name";
    private EditText editTextName;
    private Button buttonPresent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_presented);
        Objects.requireNonNull(getSupportActionBar()).hide();

        editTextName = (EditText) findViewById(R.id.editText_Name);
        buttonPresent = (Button) findViewById(R.id.button_present);


        buttonPresent.setOnClickListener( view -> {
            Intent intent = new Intent();
            intent.putExtra(NAME, editTextName.getText().toString());
            setResult(RESULT_OK, intent);
            finish();
        });
    }
}