package com.example.books;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import com.example.mymobileapp.R;

public class AlBidayaWaNahayaVolume5 extends AppCompatActivity {

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
        setContentView(R.layout.activity_al_bidaya_wa_nahaya_volume5);

        Intent i =new Intent(AlBidayaWaNahayaVolume5.this, md_book_reading.class);

        View first = findViewById(R.id.first_chap);
        first.setTag("1|Compilation of the Quran Under Uthman|Standardization of the Quranic text.");
        populateChapter(first);

        View second = findViewById(R.id.second_chap);
        second.setTag("2|Internal Strife Begins|Describes growing tensions within the Muslim community.");
        populateChapter(second);

        View third = findViewById(R.id.third_chap);
        third.setTag("3|The Assassination of Uthman|Details the tragic killing and its consequences.");
        populateChapter(third);

        View fourth = findViewById(R.id.fourth_chap);
        fourth.setTag("4|Caliphate of Ali|Explores Ali’s rise to leadership and early actions.");
        populateChapter(fourth);

        View fifth = findViewById(R.id.fifth_chap);
        fifth.setTag("5|Battle of Jamal|Covers the conflict with Aisha, Talha, and Zubair.");
        populateChapter(fifth);

        View sixth = findViewById(R.id.sixth_chap);
        sixth.setTag("6|Battle of Siffin|Describes the standoff between Ali and Muawiyah.");
        populateChapter(sixth);

        View seventh = findViewById(R.id.seventh_chap);
        seventh.setTag("7|The Death of Abu Bakr|Narrates his final days and succession planning.");
        populateChapter(seventh);

        View eighth = findViewById(R.id.eighth_chap);
        eighth.setTag("8|Kharijite Rebellion|Explains the rise and ideology of the Kharijites.");
        populateChapter(eighth);

        View ninth = findViewById(R.id.ninth_chap);
        ninth.setTag("9|Assassination of Ali|Narrates Ali’s martyrdom and aftermath.");
        populateChapter(ninth);

        View tenth = findViewById(R.id.tenth_chap);
        tenth.setTag("10|Establishment of Umayyad Rule|Describes Muawiyah’s leadership and centralization.");
        populateChapter(tenth);

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
    }
}
