package org.techtown.study_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button btn_move;
    private EditText et_id;
    private String str;

    Button btn_test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_move = findViewById(R.id.btn_move);
        et_id = findViewById(R.id.btn_id);
        btn_test = findViewById(R.id.btn_test);



        btn_move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                str = et_id.getText().toString();
                Intent intent = new Intent(MainActivity.this, SubActivity.class);
                intent.putExtra("str", str);
                startActivity(intent);  //액티비티의 이동
            }
        });


        btn_test.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            et_id.setText("나롱이 바보");
        }
    });
}
}