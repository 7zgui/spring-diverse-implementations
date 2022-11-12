package com.ecommerce.micrommerce.model;

/**
 * @author Mohamed ouokki on 11/10/22
 * @project micrommerce
 */
public class Product {

    private int id;
    private String nom;
    private int prix;
    private int prixAchats;

    public Product() {
    }

    public Product(int id, String nom, int prix,int prixAchats) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
        this.prixAchats=prixAchats;
    }

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

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public int getPrixAchats() {
        return prixAchats;
    }

    public void setPrixAchats(int prixAchats) {
        this.prixAchats = prixAchats;
    }

    @Override
    public String toString() {

        return "Product{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prix=" + prix +
                '}';
    }


}
