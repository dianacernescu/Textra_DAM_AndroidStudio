package com.example.textra_cernescudiana;

public class Contact {
    private String nume;
    private String nr_telefon;

    public Contact(String nume, String nt_telefon) {
        this.nume = nume;
        this.nr_telefon = nt_telefon;
    }

    public Contact() {
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getNr_telefon() {
        return nr_telefon;
    }

    public void setNr_telefon(String nt_telefon) {
        this.nr_telefon = nt_telefon;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "nume='" + nume + '\'' +
                ", nr_telefon='" + nr_telefon + '\'' +
                '}';
    }
}
