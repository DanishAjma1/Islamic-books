package com.example.books;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import com.example.mymobileapp.R;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class md_book_reading extends AppCompatActivity {

    private WebView webView;

    public String loadMarkdownFromAsset(String filename) {
        StringBuilder builder = new StringBuilder();
        try {
            InputStream is = getAssets().open("books/al-bidaya-wanahaya/" + filename);
            BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line).append("\n");
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }

    public String convertIntoHtml() {

        Intent i = getIntent();
        String markdownString = loadMarkdownFromAsset("chap"+i.getStringExtra("chap_number")+".md");

        Parser parser = Parser.builder().build();
        org.commonmark.node.Node document = parser.parse(markdownString);
        HtmlRenderer renderer = HtmlRenderer.builder().build();
        String htmlBody = renderer.render(document);
        String html = "<html dir='rtl' lang='ur'>" +
                "<head>" +
                "<meta charset='UTF-8'>" +
                "<style>" +
                "body { font-family: sans-serif; font-size: 18px; line-height: 1.7; color: #333; direction: rtl; text-align: right; padding: 16px; }" +
                "</style>" +
                "</head>" +
                "<body>" +
                htmlBody +
                "</body></html>";
        return html;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_md_book_reading);

        webView = findViewById(R.id.webview);
        String html = convertIntoHtml();
        webView.loadDataWithBaseURL(null, html, "text/html", "UTF-8", null);
    }
}
