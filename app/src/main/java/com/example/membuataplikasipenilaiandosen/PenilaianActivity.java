package com.example.membuataplikasipenilaiandosen;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PenilaianActivity extends AppCompatActivity {

    // Variabel untuk menyimpan kumpulan riwayat data
    private String daftarRiwayatNilai = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_penilaian);

        TextView tvGreeting = findViewById(R.id.tvGreeting);
        EditText etNamaMhs = findViewById(R.id.etNamaMhs);
        EditText etRataNilai = findViewById(R.id.etRataNilai);
        Button btnSimpanHasil = findViewById(R.id.btnSimpanHasil);

        // 1. Hubungkan TextView untuk daftar nilai
        TextView tvDaftarNilai = findViewById(R.id.tvDaftarNilai);

        if (getIntent() != null && getIntent().hasExtra("NAMA_DOSEN")) {
            String namaDosen = getIntent().getStringExtra("NAMA_DOSEN");
            if (namaDosen != null && !namaDosen.isEmpty()) {
                tvGreeting.setText("Halo, " + namaDosen + "!");
            }
        }

        btnSimpanHasil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String namaMahasiswa = etNamaMhs.getText().toString();
                String nilai = etRataNilai.getText().toString();

                if (namaMahasiswa.isEmpty() || nilai.isEmpty()) {
                    Toast.makeText(PenilaianActivity.this, "Mohon isi semua data!", Toast.LENGTH_SHORT).show();
                } else {
                    // 2. Tambahkan data baru ke string riwayat ( \n artinya enter/baris baru )
                    daftarRiwayatNilai = daftarRiwayatNilai + "• " + namaMahasiswa + " - Nilai: " + nilai + "\n";

                    // 3. Tampilkan riwayat terbaru ke layar
                    tvDaftarNilai.setText(daftarRiwayatNilai);

                    Toast.makeText(PenilaianActivity.this, "Nilai " + namaMahasiswa + " Disimpan!", Toast.LENGTH_SHORT).show();

                    // 4. Kosongkan kembali kotak inputan untuk mahasiswa selanjutnya
                    etNamaMhs.setText("");
                    etRataNilai.setText("");
                    etNamaMhs.requestFocus(); // Mengembalikan kursor ketik ke kotak nama
                }
            }
        });
    }
}