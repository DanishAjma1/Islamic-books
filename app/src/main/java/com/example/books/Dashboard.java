package com.example.books;

import android.content.Intent;
import android.media.Image;
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
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.example.mymobileapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

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
    private ImageButton profileBtn;
    private LinearLayout dashboardLayout;
    private Button backBtn;
    private ImageButton editBtn;
    private Button saveBtn;
    private EditText editName;
    private EditText editDescription;
    ImageView profileImage;
    private TextView username;
    private TextView description;
    private ImageView imageUriString;
    String uid;
    private void showProfileInputDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(Dashboard.this);
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.profile_dialog_input, null);
        builder.setView(dialogView);

        editName = dialogView.findViewById(R.id.editName);
        editDescription = dialogView.findViewById(R.id.editDescription);
        profileImage = dialogView.findViewById(R.id.profileImageView);

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
                storeData(name,description,imageUri.toString());
                readData();
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
    void storeData(String name,String description,String uri){
        getCurrentUser();
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        Map<String,Object> user = new HashMap<>();
        user.put("uid",uid);
        user.put("name",name);
        user.put("description",description);
        user.put("imageUri",uri);

        db.collection("users").add(user).addOnCompleteListener(task -> {
            if(task.isSuccessful()){
                Toast.makeText(Dashboard.this, "Data inserted", Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(Dashboard.this, "Error"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    void readData(){
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        getCurrentUser();
        db.collection("users").document(uid).get().addOnCompleteListener(documentSnapShot->{
        if(documentSnapShot.isSuccessful()){
            username.setText(documentSnapShot.getResult().getString("name"));
            description.setText(documentSnapShot.getResult().getString("description"));
            String uri = documentSnapShot.getResult().getString("imageUri");
            if(uri!=null){
                imageUriString.setImageURI(Uri.parse(uri));
            }
            else{
                imageUriString.setImageResource(R.drawable.logo);
            }
        }
    else{
        Toast.makeText(Dashboard.this, "Error"+documentSnapShot.getException().getMessage(), Toast.LENGTH_SHORT).show();
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
        profileBtn = findViewById(R.id.profileBtn);
        dashboardLayout = findViewById(R.id.dashboard_layout);
        backBtn =findViewById(R.id.backBtn);
        editBtn = findViewById(R.id.editBtn);
        username = findViewById(R.id.userName);
        description = findViewById(R.id.userDescription);
        imageUriString = findViewById(R.id.userImage);

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