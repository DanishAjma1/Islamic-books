package com.example.books;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.example.mymobileapp.R;

public class AlBidayaWaNahayaVolume3 extends AppCompatActivity {

    private void populateChapter(View includedLayout) {
        String tag = (String) includedLayout.getTag();
        if (tag != null) {
            String[] parts = tag.split("\\|");
            if (parts.length == 3) {
                TextView number = includedLayout.findViewById(R.id.chap_Number);
                TextView title = includedLayout.findViewById(R.id.chapEnglishName);
                TextView details = includedLayout.findViewById(R.id.chapDetails);
                number.setText(parts[0] + ".");
                title.setText(parts[1]);
                details.setText(parts[2]);
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_al_bidaya_wa_nahaya_volume3);

        Intent i =new Intent(AlBidayaWaNahayaVolume3.this, md_book_reading.class);

        View first = findViewById(R.id.first_chap);
        first.setTag("1|The Caliphate of Abu Bakr|Explores the early challenges and accomplishments of Abu Bakr’s leadership.");
        populateChapter(first);

        View tenth = findViewById(R.id.tenth_chap);
        tenth.setTag("10|The Death of Abu Bakr|Narrates his final days and succession planning.");
        populateChapter(tenth);

        View second = findViewById(R.id.second_chap);
        second.setTag("2|The Ridda Wars|Details the campaigns against tribes who abandoned Islam after the Prophet’s death.");
        populateChapter(second);

        View third = findViewById(R.id.third_chap);
        third.setTag("3|Compilation of the Quran|Discusses the collection of the Quran under Abu Bakr’s rule.");
        populateChapter(third);

        View fourth = findViewById(R.id.fourth_chap);
        fourth.setTag("4|Conquests Under Abu Bakr|Covers the expansion of the Islamic state into Persia and the Levant.");
        populateChapter(fourth);

        View fifth = findViewById(R.id.fifth_chap);
        fifth.setTag("5|The Death of Abu Bakr|Narrates his final days and succession planning.");
        populateChapter(fifth);

        View sixth = findViewById(R.id.sixth_chap);
        sixth.setTag("6|Beginning of Umar’s Caliphate|Introduces the leadership style and reforms of Caliph Umar ibn al-Khattab.");
        populateChapter(sixth);

        View seventh = findViewById(R.id.seventh_chap);
        seventh.setTag("7|Campaigns in Iraq and Persia|Details the early Muslim conquests in the Persian territories.");
        populateChapter(seventh);

        View eighth = findViewById(R.id.eighth_chap);
        eighth.setTag("8|Conquests in Greater Syria|Covers battles and treaties in the Levant region.");
        populateChapter(eighth);

        View ninth = findViewById(R.id.ninth_chap);
        ninth.setTag("9|Battle of Yarmouk|Describes the decisive clash with the Byzantine Empire.");
        populateChapter(ninth);

        first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i.putExtra("chap_number","1");
                startActivity(i);
            }
        });

        second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i.putExtra("chap_number","2");
                startActivity(i);
            }
        });

        third.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i.putExtra("chap_number","3");
                startActivity(i);
            }
        });

        fourth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i.putExtra("chap_number","4");
                startActivity(i);
            }
        });

        fifth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i.putExtra("chap_number","5");
                startActivity(i);
            }
        });

        sixth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i.putExtra("chap_number","6");
                startActivity(i);
            }
        });

        seventh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i.putExtra("chap_number","7");
                startActivity(i);
            }
        });


        eighth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i.putExtra("chap_number","8");
                startActivity(i);
            }
        });

        ninth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i.putExtra("chap_number","9");
                startActivity(i);
            }
        });
        tenth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i.putExtra("chap_number","10");
                startActivity(i);
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
