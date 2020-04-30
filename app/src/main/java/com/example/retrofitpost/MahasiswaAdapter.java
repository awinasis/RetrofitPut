package com.example.retrofitpost;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MahasiswaAdapter extends RecyclerView.Adapter<MahasiswaAdapter.ViewHolder> {

    private List<Post> dataMahasiswa;
    private Context context;

    public MahasiswaAdapter(List<Post> dataMahasiswa, Context context) {
        this.dataMahasiswa = dataMahasiswa;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View Siswaview = layoutInflater.inflate(R.layout.item_mahasiswa, parent, false);

        ViewHolder viewHolder = new ViewHolder(Siswaview);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MahasiswaAdapter.ViewHolder holder, final int position) {
        final Post mhs = dataMahasiswa.get(position);

        TextView textView = holder.idsiswa;
        TextView textView1 = holder.namasiswa;
        TextView textView2 = holder.alamatsiswa;
        TextView textView3 = holder.jksiswa;
        TextView textView4 = holder.notelpsiswa;

        textView.setText(mhs.getId_siswa());
        textView1.setText(mhs.getNama());
        textView2.setText(mhs.getAlamat());
        textView3.setText(mhs.getJenis_kelamin());
        textView4.setText(mhs.getNo_telp());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //mengirim data berupa nim yaitu idsiswa, nama, alamat, jenis kelamin, dan no telp
                Bundle bundle = new Bundle();
                bundle.putString("Nim", mhs.getId_siswa());
                bundle.putString("Nama", mhs.getNama());
                bundle.putString("Alamat", mhs.getAlamat());
                bundle.putString("Jenis Kelamin", mhs.getJenis_kelamin());
                bundle.putString("No Telp", mhs.getNo_telp());
                Intent intent = new Intent(context, UpdateActivity.class);
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {

        return dataMahasiswa.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView idsiswa;
        public TextView namasiswa;
        public TextView alamatsiswa;
        public TextView jksiswa;
        public TextView notelpsiswa;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            idsiswa = (TextView)itemView.findViewById(R.id.id_siswa);
            namasiswa = (TextView)itemView.findViewById(R.id.nama);
            alamatsiswa = (TextView)itemView.findViewById(R.id.alamat);
            jksiswa = (TextView)itemView.findViewById(R.id.jk);
            notelpsiswa = (TextView)itemView.findViewById(R.id.noTelp);
        }
    }

}
