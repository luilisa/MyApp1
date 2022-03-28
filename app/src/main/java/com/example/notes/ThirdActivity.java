package com.example.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            TextView textView = findViewById(R.id.textView);
            String text = extras.getString(SecondActivity2.TEXT_KEY);
            textView.setText("Провертье правильность набранного текста: " +  text);
        }

    }
    //выход
    public void onClick(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
    }

//    public void onClickBack(View view) {
//        Intent intent = new Intent(this, SecondActivity2.class);
//        startActivity(intent);
//    }
    //подтвердить
    public void onClickBack(View v) {
        sendMessage("Сообщение отправлено");
    }

    private void sendMessage(String message){

        Intent data = new Intent();
        data.putExtra(SecondActivity2.MESSAGE, message);
        setResult(RESULT_OK, data);
        finish();
    }

}