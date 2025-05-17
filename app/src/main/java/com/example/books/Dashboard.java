package com.example.books;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.bumptech.glide.Glide;
import com.example.mymobileapp.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import android.app.AlertDialog;
import android.view.LayoutInflater;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class Dashboard extends AppCompatActivity {

    private static final int PICK_IMAGE_REQUEST = 1;
    private boolean image_picked;
    private Uri imageUri;
    private ImageButton button1;
//    private ImageButton button2= findViewById(R.id.imageButton2);
//    private ImageButton button3= findViewById(R.id.imageButton3);
//    private ImageButton button4= findViewById(R.id.imageButton4);
//    private ImageButton button5= findViewById(R.id.imageButton5);
//    private ImageButton button6= findViewById(R.id.imageButton6);
    private Button logoutBtn;
    private LinearLayout profileLayout;
    private LinearLayout profileBtn;
    private LinearLayout supportBtn;
    private LinearLayout helpBtn;
    private LinearLayout allBooks;
    private LinearLayout dashboardLayout;
    private Button backBtn;
    private ImageButton editBtn;
    private Button saveBtn;
    private EditText editName;
    private EditText editDescription;
    private ImageView profileImage;
    private TextView username;
    private TextView description;
    private ImageView imageUriString;
    String uid;
    String uri;
    private void showProfileInputDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(Dashboard.this);
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.profile_dialog_input, null);
        builder.setView(dialogView);

        editName = dialogView.findViewById(R.id.editName);
        editDescription = dialogView.findViewById(R.id.editDescription);
        profileImage = dialogView.findViewById(R.id.profileImageView);

        editName.setText(username.getText().toString());;
        editDescription.setText(description.getText().toString());
        Glide.with(Dashboard.this).load(uri).into(profileImage);

        profileImage.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.setType("image/*");
            intent.setAction(Intent.ACTION_GET_CONTENT);
            startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
        });

        builder.setTitle("Update Profile");
        builder.setPositiveButton("Save", (dialog, which) -> {
            String name = editName.getText().toString();
            String description = editDescription.getText().toString();

            if (name.isEmpty() || description.isEmpty()) {
                Toast.makeText(this, "Fields cannot be empty", Toast.LENGTH_SHORT).show();
            } else {
                if (image_picked) {
                    imageUriString.setImageURI(imageUri);
                    storeData(name, description, imageUri.toString());
                    readData();
                }
            }
        });
        builder.setNegativeButton("Cancel", (dialog, which) -> dialog.dismiss());
        AlertDialog dialog = builder.create();
        dialog.show();
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            imageUri = data.getData();
            if (profileImage != null) {
                Toast.makeText(this, "Image uploaded", Toast.LENGTH_SHORT).show();
                image_picked = true;
                profileImage.setImageURI(imageUri);
                profileImage.setScaleType(ImageView.ScaleType.CENTER_CROP);
                profileImage.setClipToOutline(true);
                profileImage.setBackground(ContextCompat.getDrawable(this, R.drawable.profile_image_design));
            }
        }
    }
    private void getCurrentUser(){
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            uid = user.getUid();
            Log.d("UserID", "Signed-in user UID: " + uid);
        } else {
            Log.d("UserID", "No user is signed in.");
        }
    }
    void storeData(String name, String description, String uri) {
        getCurrentUser();
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        Map<String, Object> userData = new HashMap<>();
        userData.put("uid", uid);
        userData.put("name", name);
        userData.put("description", description);
        userData.put("imageUri", uri);

        DocumentReference userRef = db.collection("users").document(uid);

        userRef.get().addOnSuccessListener(documentSnapshot -> {
            if (documentSnapshot.exists()) {
                userRef.set(userData)
                        .addOnSuccessListener(aVoid -> Toast.makeText(Dashboard.this, "Data updated", Toast.LENGTH_SHORT).show())
                        .addOnFailureListener(e -> Toast.makeText(Dashboard.this, "Update failed: " + e.getMessage(), Toast.LENGTH_SHORT).show());
            } else {
                userRef.set(userData)
                        .addOnSuccessListener(aVoid -> Toast.makeText(Dashboard.this, "Data inserted", Toast.LENGTH_SHORT).show())
                        .addOnFailureListener(e -> Toast.makeText(Dashboard.this, "Insert failed: " + e.getMessage(), Toast.LENGTH_SHORT).show());
            }
        }).addOnFailureListener(e -> {
            Toast.makeText(Dashboard.this, "Error checking user: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        });
    }

    void readData() {
        getCurrentUser();
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        db.collection("users").document(uid).get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                if (task.getResult() != null && task.getResult().exists()) {
                    username.setText(task.getResult().getString("name"));
                    description.setText(task.getResult().getString("description"));

                    uri = task.getResult().getString("imageUri");
                    if (uri != null && !uri.isEmpty()) {
                        Glide.with(Dashboard.this).load(uri).into(imageUriString);
                    } else {
                        imageUriString.setImageResource(R.drawable.logo);
                    }
                } else {
                    Toast.makeText(Dashboard.this, "User data not found", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(Dashboard.this, "Error: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        setContentView(R.layout.activity_dashboard);

        button1= findViewById(R.id.imageButton1);
        logoutBtn = findViewById(R.id.logoutBtn);
        profileLayout = findViewById(R.id.profile_layout);
        profileBtn = findViewById(R.id.profileIcon);
        supportBtn = findViewById(R.id.supportIcon);
        helpBtn = findViewById(R.id.helpIcon);
        allBooks = findViewById(R.id.booksIcon);
        dashboardLayout = findViewById(R.id.dashboard_layout);
        backBtn =findViewById(R.id.backBtn);
        editBtn = findViewById(R.id.editBtn);
        username = findViewById(R.id.userName);
        description = findViewById(R.id.userDescription);
        imageUriString = findViewById(R.id.userImage);

        readData();
        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent i= new Intent(Dashboard.this,Login.class);
                startActivity(i);
                finish();
            }
        });

        editBtn.setOnClickListener(v->showProfileInputDialog());

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                profileLayout.setVisibility(View.GONE);
                dashboardLayout.setVisibility(View.VISIBLE);
            }
        });

        profileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dashboardLayout.setVisibility(View.GONE);
                profileLayout.setVisibility(View.VISIBLE);
                readData();
            }
        });
        supportBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
        helpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dashboardLayout.setVisibility(View.GONE);
                profileLayout.setVisibility(View.VISIBLE);
                readData();
            }
        });
        allBooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dashboardLayout.setVisibility(View.GONE);
                profileLayout.setVisibility(View.VISIBLE);
                readData();
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(Dashboard.this,AlBidayaWaNahaya.class);
                startActivity(i);
            }
        });
    }
}