package org.techtown.study_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = findViewById(R.id.list);   //이거 왜 추가해야 되는거야? ListView ID로 가져오는데 왜 typecasting을?
        List<String> data = new ArrayList<>();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, data);
        list.setAdapter(adapter);

        data.add("안녕하세요.");
        data.add("감사해요.");
        data.add("잘있어요.");
        data.add("다시만나요.");
        adapter.notifyDataSetChanged();


    }
}