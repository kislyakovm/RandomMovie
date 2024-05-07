package com.example.randomtext;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView mainText;
    ArrayList arrayList;
    Random random;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        mainText = findViewById(R.id.mainText);
        random = new Random();
        mediaPlayer = MediaPlayer.create(this, R.raw.jump);

        arrayList = new ArrayList();
        addTextToArray();

        mainText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();
                mainText.setText("" + arrayList.get(random.nextInt(arrayList.size())));
            }
        });
    }

    private void addTextToArray() {
        arrayList.add(getString(R.string.text_0000));
        arrayList.add(getString(R.string.text_0001));
        arrayList.add(getString(R.string.text_0002));
        arrayList.add(getString(R.string.text_0003));
        arrayList.add(getString(R.string.text_0004));
        arrayList.add(getString(R.string.text_0005));
    }
}