package com.example.membuataplikasipenilaiandosen;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 1. Ini yang bikin halaman Login muncul duluan!
        setContentView(R.layout.activity_panel);

        // 2. Hubungkan tombol Login
        Button btnLogin = findViewById(R.id.btnLogin);

        // 3. Perintah saat tombol Login diklik
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Pindah ke halaman Form Nama Dosen (MainActivity)
                Intent pindah = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(pindah);
            }
        });
    }
}