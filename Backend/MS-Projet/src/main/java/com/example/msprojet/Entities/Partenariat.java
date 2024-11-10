package com.example.msprojet.Entities;

public class Partenariat {
    private int id;
    private String nom;
    private String prenom;
    private String email;
    private String numeroTelephone;


    public Partenariat() {
    }

    public Partenariat(int id, String nom, String prenom, String email, String numeroTelephone) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.numeroTelephone = numeroTelephone;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNumeroTelephone(String numeroTelephone) {
        this.numeroTelephone = numeroTelephone;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getEmail() {
        return email;
    }

    public String getNumeroTelephone() {
        return numeroTelephone;
    }


}
