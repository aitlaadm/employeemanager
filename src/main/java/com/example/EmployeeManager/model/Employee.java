package com.example.EmployeeManager.model;
import javax.persistence.*;
import java.io.Serializable;
/*permet le mapping de la classe dans une bd*/
@Entity
public class Employee implements Serializable {
    /*identifiant de la table*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false,updatable = false)
    /*^cela permet de dir que la variable id doit etre lidentifiant de la table ainsi qu'elle doit pas etre null ni modifiable et doit etre generer^*/
    private Long id;
    private String nom;
    private String prenom;
    private String mail;
    private String telephone;
    private String poste;
    private String imageUrl;
    /*v code d'employé(e) ne peut pas etre modifié ou null v*/
    @Column(nullable = false,updatable = false)
    private String codeEmploye;

    public Employee(){}

    public Employee(Long id, String nom, String prenom, String imageUrl, String mail, String telephone, String poste, String codeEmploye){
        this.id=id;
        this.nom=nom;
        this.prenom=prenom;
        this.imageUrl=imageUrl;
        this.mail=mail;
        this.telephone=telephone;
        this.poste=poste;
        this.codeEmploye=codeEmploye;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public String getCodeEmploye() {
        return codeEmploye;
    }

    public void setCodeEmploye(String codeEmploye) {
        this.codeEmploye = codeEmploye;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    @Override
    public String toString(){
        return "Employé = { id "+id+" nom "+nom+" " +
                "prénom "+prenom+" image URl "+imageUrl+
                " mail "+mail+" téléphone "
                +telephone+" Poste "+poste+" code employé "+codeEmploye+"}";
    }
}
