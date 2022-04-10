package com.yapi.rentku.dm;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DaftarRequest {

    @SerializedName("nama")
    @Expose
    private String nama;
    @SerializedName("alamat")
    @Expose
    private String alamat;
    @SerializedName("telp")
    @Expose
    private String telp;
    @SerializedName("sandi")
    @Expose
    private String sandi;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("level")
    @Expose
    private String level;
    @SerializedName("api_token")
    @Expose
    private String apiToken;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("relasi")
    @Expose
    private String relasi;

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getTelp() {
        return telp;
    }

    public void setTelp(String telp) {
        this.telp = telp;
    }

    public String getSandi() {
        return sandi;
    }

    public void setSandi(String sandi) {
        this.sandi = sandi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getApiToken() {
        return apiToken;
    }

    public void setApiToken(String apiToken) {
        this.apiToken = apiToken;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRelasi() {
        return relasi;
    }

    public void setRelasi(String relasi) {
        this.relasi = relasi;
    }
}
