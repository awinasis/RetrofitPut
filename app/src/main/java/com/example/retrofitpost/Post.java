package com.example.retrofitpost;

public class Post {

    private String id_siswa;
    private String nama;
    private String alamat;
    private String jenis_kelamin;
    private String no_telp;


    public Post(String id_siswa, String nama, String alamat, String jenis_kelamin, String no_telp) {
        this.id_siswa = id_siswa;
        this.nama = nama;
        this.alamat = alamat;
        this.jenis_kelamin = jenis_kelamin;
        this.no_telp = no_telp;
    }

    public void setId_siswa(String id_siswa) {
        this.id_siswa = id_siswa;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public void setJenis_kelamin(String jenis_kelamin) {
        this.jenis_kelamin = jenis_kelamin;
    }

    public void setNo_telp(String no_telp) {
        this.no_telp = no_telp;
    }

    public String getId_siswa() {
        return id_siswa;
    }

    public String getNama() {
        return nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getJenis_kelamin() {
        return jenis_kelamin;
    }

    public String getNo_telp() {
        return no_telp;
    }

}
