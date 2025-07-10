package com.example.EvidencijaPolaznika.dto;

public class PolaznikDTO {
    private String ime;

    private String prezime;

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public PolaznikDTO(String ime, String prezime) {
        this.ime = ime;
        this.prezime = prezime;
    }

    public PolaznikDTO() {
    }
}
