package com.example.appwibu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.lang.ref.Cleaner;

public class screenDoiPass extends AppCompatActivity {
    TextInputEditText passwordET , passwordETNew;
    Button buttonEdit;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_doi_pass);
        EditText passwordET = findViewById(R.id.doipass);
        EditText passwordETNew = findViewById(R.id.doipassnew);
        Button buttonEdit = findViewById(R.id.doipass_btxacnhan);

        buttonEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pass = passwordET.getText().toString().trim();
                String passNew = passwordETNew.getText().toString().trim();
                if (TextUtils.isEmpty(pass)){
                    Toast.makeText(screenDoiPass.this,"nhập mật khẩu hiện tại ...",Toast.LENGTH_LONG).show();
                    return;
                }
                buttonEdit(pass,passNew);
                }
            }
        );
    }

    private void buttonEdit(String pass, String passNew) {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        AuthCredential authCredential = EmailAuthProvider.getCredential(user.getEmail(),pass);
        user.reauthenticate(authCredential)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        user.updatePassword(passNew)
                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void aVoid) {
                                        Toast.makeText(screenDoiPass.this,"mật khẩu được cập nhập",Toast.LENGTH_LONG).show();
                                    }
                                })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(screenDoiPass.this,""+e.getMessage(),Toast.LENGTH_LONG).show();
                                    }
                                });
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(screenDoiPass.this,""+e.getMessage(),Toast.LENGTH_LONG).show();
                    }
                });
    }
}