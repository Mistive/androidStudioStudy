package org.techtown.study_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ListView;

            public class SharedPreferencesActivity extends AppCompatActivity {
                private ListView list;

                EditText et_save;
                String shared = "file";
                @Override
                protected void onCreate(Bundle savedInstanceState) {
                    super.onCreate(savedInstanceState);
                    setContentView(R.layout.activity_sharedpreferences);

                    et_save = findViewById(R.id.et_save);

                    SharedPreferences sharedPreferences = getSharedPreferences("file2", 0);
                    String value = sharedPreferences.getString("minsu", "");
                    et_save.setText(value);

        }

        @Override
        protected void onDestroy() {
            super.onDestroy();

            SharedPreferences sharedPreferences = getSharedPreferences("file2", 0);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            String value = et_save.getText().toString();
            editor.putString("minsu", value);
            editor.commit();

        }
    }