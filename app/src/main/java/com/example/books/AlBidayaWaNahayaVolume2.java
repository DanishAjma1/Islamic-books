package com.example.books;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.mymobileapp.R;

public class AlBidayaWaNahayaVolume2 extends AppCompatActivity {

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
        setContentView(R.layout.activity_al_bidaya_wa_nahaya_volume2);

        Intent i =new Intent(AlBidayaWaNahayaVolume2.this, md_book_reading.class);

        View first = findViewById(R.id.first_chap);
        first.setTag("1|The Consolidation of Islam in Medina|Covers the strengthening of the Muslim community and governance.");
        populateChapter(first);

        View second = findViewById(R.id.second_chap);
        second.setTag("2|The Battle of the Trench|Describes the defensive strategies and outcomes of the siege of Medina.");
        populateChapter(second);

        View third = findViewById(R.id.third_chap);
        third.setTag("3|The Treaty of Hudaybiyyah Revisited|Discusses the aftermath and strategic value of the treaty.");
        populateChapter(third);

        View fourth = findViewById(R.id.fourth_chap);
        fourth.setTag("4|The Conquest of Mecca|Narrates the peaceful takeover of Mecca and its significance.");
        populateChapter(fourth);

        View fifth = findViewById(R.id.fifth_chap);
        fifth.setTag("5|The Farewell Pilgrimage|Covers the Prophet's final sermon and its message to the Ummah.");
        populateChapter(fifth);

        View sixth = findViewById(R.id.sixth_chap);
        sixth.setTag("6|The Passing of the Prophet (PBUH)|Reflects on the last days of the Prophet and the impact on the community.");
        populateChapter(sixth);

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

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
