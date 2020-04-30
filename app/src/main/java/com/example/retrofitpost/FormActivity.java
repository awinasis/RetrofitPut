package com.example.retrofitpost;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FormActivity extends AppCompatActivity {

    //menambahkan beberapa variabel
    private TextView txtnim, txtnama, txtalamat, txtjk, txtnotelp;
    private EditText editnim, editnama, editalamat, editjk, editnotelp;
    private Button proses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        //menyambungkan variabel dengan id yang pada xml
        txtnim = (TextView)findViewById(R.id.txt_nim);
        txtnama = (TextView)findViewById(R.id.txt_nama);
        txtalamat = (TextView)findViewById(R.id.txt_alamat);
        txtjk = (TextView)findViewById(R.id.txt_jk);
        txtnotelp = (TextView)findViewById(R.id.txt_telp);
        editnim = (EditText)findViewById(R.id.edit_nim);
        editnama = (EditText)findViewById(R.id.edit_nama);
        editalamat = (EditText)findViewById(R.id.edit_alamat);
        editjk = (EditText)findViewById(R.id.edit_jk);
        editnotelp = (EditText)findViewById(R.id.edit_telp);
        proses = (Button)findViewById(R.id.btn_add);

        //handler ketika button proses diklik dan memanggil method kirimData
        proses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submit();
                Intent intent = new Intent(FormActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void submit() {
        String id_siswa = editnim.getText().toString().trim();
        String nama = editnama.getText().toString().trim();
        String alamat = editalamat.getText().toString().trim();
        String jenis_kelamin = editjk.getText().toString().trim();
        String no_telp = editnotelp.getText().toString().trim();

        //inisialisasi retrofit dan api interface untuk mengirimkan variabel2nya
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.43.7/mahasiswa/Api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Post post = new Post(id_siswa, nama, alamat, jenis_kelamin, no_telp);

        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);
        Call<ResponseBody> call = jsonPlaceHolderApi.createPost(post);

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(FormActivity.this, "Berhasil", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(FormActivity.this, "Gagal", Toast.LENGTH_SHORT).show();
            }
        });
    }


}
