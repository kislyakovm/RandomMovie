package com.example.randomtext;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView mainText;
    ImageView imageView;
    ArrayList<Films> arrayList;
    ArrayList<String> pictures;
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
        imageView = findViewById(R.id.imageView);

        random = new Random();
        mediaPlayer = MediaPlayer.create(this, R.raw.jump);

        arrayList = new ArrayList();
        pictures = new ArrayList<>();
        addTextToArray();

    }

    private void addTextToArray() {
        for (int i = 0; i <= 5; i++) {
            String filmId = "film_" + String.format("%04d", i);
            String textId = "text_" + String.format("%04d", i);
            int filmResId = getResources().getIdentifier(filmId, "string", getPackageName());
            int textResId = getResources().getIdentifier(textId, "string", getPackageName());
            arrayList.add(new Films(getString(filmResId), getString(textResId)));
        }
    }

    public void onClickButton(View view) {
        mediaPlayer.start();
        int i = random.nextInt(arrayList.size());

        String title = arrayList.get(i).getName();
        String imageUrl = arrayList.get(i).getImgUrl();
        int imageID = getResources().getIdentifier(imageUrl, "drawable", getPackageName());
        imageView.setImageResource(imageID);

        mainText.setText("" + title);
    }
}