package com.example.membuataplikasipenilaiandosen;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent; // WAJIB ADA
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etNamaDosen;
    private Button btnMasuk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Pastikan ini mengarah ke layout login kamu

        etNamaDosen = findViewById(R.id.etNamaDosen);
        btnMasuk = findViewById(R.id.btnMasuk);

        btnMasuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nama = etNamaDosen.getText().toString();

                if (nama.isEmpty()) {
                    etNamaDosen.setError("Nama Dosen tidak boleh kosong!");
                } else {
                    // PROSES PINDAH HALAMAN
                    Intent intent = new Intent(MainActivity.this, PenilaianActivity.class);
                    intent.putExtra("NAMA_DOSEN", nama); // Titip nama ke halaman sebelah
                    startActivity(intent);
                }
            }
        });
    }
}