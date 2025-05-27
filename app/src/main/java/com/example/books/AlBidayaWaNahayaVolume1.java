package com.example.books;

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

public class AlBidayaWaNahayaVolume1 extends AppCompatActivity {

    private void populateChapter(View includedLayout) {
        String tag = (String) includedLayout.getTag();

        if (tag != null) {
            Toast.makeText(this, tag, Toast.LENGTH_SHORT).show();
            String[] parts = tag.split("|");
            if (parts.length == 3) {
                TextView number = includedLayout.findViewById(R.id.chap_Number);
                TextView title = includedLayout.findViewById(R.id.chapEnglishName);
                TextView details = includedLayout.findViewById(R.id.chapDetails);
                Toast.makeText(this, parts[0], Toast.LENGTH_SHORT).show();

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
        setContentView(R.layout.activity_al_bidaya_wa_nahaya_volume1);

        populateChapter(findViewById(R.id.first_chap));
        populateChapter(findViewById(R.id.second_chap));
        populateChapter(findViewById(R.id.third_chap));
        populateChapter(findViewById(R.id.fourth_chap));
        populateChapter(findViewById(R.id.fifth_chap));
        populateChapter(findViewById(R.id.sixth_chap));


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}