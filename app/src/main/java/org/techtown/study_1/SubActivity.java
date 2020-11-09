package org.techtown.study_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SubActivity extends AppCompatActivity {
    private TextView tView;
    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_sub);

            tView = findViewById(R.id.text_getIntent);

            Intent intent = getIntent();
            String str = intent.getStringExtra("str");
            tView.setText(str);

    }
}