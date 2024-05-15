package com.example.petcareapp;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.util.HashMap; import java.util.Map;
public class AddpetActivity extends AppCompatActivity
{
    private EditText edPetname;
    private EditText edPettype;
    private EditText edPetbreed;
    private Button btnSave;
    private DatabaseReference mPostDatabase;
    private FirebaseAuth mAuth;
    private FirebaseUser mUser;
    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addpet);
        edPetname=findViewById(R.id.edPetname);
        edPettype=findViewById(R.id.edPettype);
        edPetbreed=findViewById(R.id.edPetbreed);
        btnSave=findViewById(R.id.btnSave);
        FirebaseDatabase database=FirebaseDatabase.getInstance();
        mPostDatabase=database.getReference().child("MyPet");
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                addPetToDatabase();
                edPetname.setText("");
                edPettype.setText("");
                edPetbreed.setText("");
                Toast.makeText(AddpetActivity.this, "Pet Added", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void addPetToDatabase(){
        String petname=edPetname.getText().toString();
        String pettype=edPettype.getText().toString();
        String petbreed=edPetbreed.getText().toString();
        MyPet mypet=new MyPet(petname,pettype,petbreed);
        mPostDatabase.push().setValue(mypet);
    }
}