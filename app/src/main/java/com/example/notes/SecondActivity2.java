package com.example.notes;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity2 extends AppCompatActivity {

    static final String MESSAGE="MESSAGE";
    static final String TEXT_KEY = "TEXT";

    ActivityResultLauncher<Intent> mStartForResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {

                    TextView textView = findViewById(R.id.textView);
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent intent = result.getData();
                        String accessMessage = intent.getStringExtra(MESSAGE);
                        textView.setText(accessMessage);
                    }
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second2);

    }
    public void onClick(View view) {
        Intent intent = new Intent(this, ThirdActivity.class);
        startActivity(intent);
        EditText textBox = findViewById(R.id.text);
        String text = textBox.getText().toString();
        intent.putExtra(TEXT_KEY, text);
        mStartForResult.launch(intent);
    }

    public void onClickBack(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


}