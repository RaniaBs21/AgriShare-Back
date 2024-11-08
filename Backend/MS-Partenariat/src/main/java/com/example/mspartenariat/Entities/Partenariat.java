package com.example.mspartenariat.Entities;


import jakarta.persistence.*;

@Entity
public class Partenariat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nom;
    private String prenom;
    private String email;
    private String numeroTelephone;
    @Lob // Indique qu'il s'agit d'un gros objet binaire (image)
    private byte[] image;
    @Transient
    private String imageBase64;
    // Constructeur par défaut (requis par JPA)
    public Partenariat() {}



    // Constructeur avec paramètres
    public Partenariat(String nom, String prenom, String email, String numeroTelephone, byte[] image) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.numeroTelephone = numeroTelephone;
        this.image = image;
    }

    // Getters et Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumeroTelephone() {
        return numeroTelephone;
    }

    public void setNumeroTelephone(String numeroTelephone) {
        this.numeroTelephone = numeroTelephone;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    // Méthode toString() pour afficher un résumé de l'objet
    @Override
    public String toString() {
        return "Partenariat{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", numeroTelephone='" + numeroTelephone + '\'' +
                ", image=" + (image != null ? "Image present" : "Pas d'image") +
                '}';
    }
    public void setImageBase64(String imageBase64) {
        this.imageBase64 = imageBase64;
    }
}
