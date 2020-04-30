package com.example.retrofitpost;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UpdateActivity extends AppCompatActivity {

    private TextView txtnim, txtnama, txtalamat, txtjk, txtnotelp;
    private EditText updatenim, updatenama, updatealamat, updatejk, updatetelp;
    private Button btnUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        txtnim = (TextView)findViewById(R.id.txt_nim);
        txtnama = (TextView)findViewById(R.id.txt_nama);
        txtalamat = (TextView)findViewById(R.id.txt_alamat);
        txtjk = (TextView)findViewById(R.id.txt_jk);
        txtnotelp = (TextView)findViewById(R.id.txt_telp);

        updatenim = (EditText)findViewById(R.id.update_nim);
        updatenama = (EditText)findViewById(R.id.update_nama);
        updatealamat = (EditText)findViewById(R.id.update_alamat);
        updatejk = (EditText)findViewById(R.id.update_jk);
        updatetelp = (EditText)findViewById(R.id.update_telp);

        btnUpdate = (Button)findViewById(R.id.btnUpdate);

        //mengambil data dari intent menggunakan bundle
        Bundle bundle = getIntent().getExtras();
        updatenim.setText(bundle.getString("Nim"));
        updatenama.setText(bundle.getString("Nama"));
        updatealamat.setText(bundle.getString("Alamat"));
        updatejk.setText(bundle.getString("Jenis Kelamin"));
        updatetelp.setText(bundle.getString("No Telp"));

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateData();
                Intent intent = new Intent(UpdateActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    public void updateData(){
        String id_siswa = updatenim.getText().toString();
        String nama = updatenama.getText().toString();
        String alamat = updatealamat.getText().toString();
        String jenis_kelamin = updatejk.getText().toString();
        String no_telp = updatetelp.getText().toString();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.43.7/mahasiswa/Api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Post post = new Post(id_siswa, nama, alamat, jenis_kelamin, no_telp);

        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);
        Call<Post> call = jsonPlaceHolderApi.updatePost(post);

        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if(response.isSuccessful()){
                    Toast.makeText(UpdateActivity.this, "Data berhasil diupdate", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(UpdateActivity.this, MainActivity.class);
                    startActivity(i);
                }
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                Toast.makeText(UpdateActivity.this, "Data gagal diupdate", Toast.LENGTH_SHORT).show();
            }
        });


    }

}
