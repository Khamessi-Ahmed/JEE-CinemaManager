package modele.entities;

public class Film {
    private int id;
    private String nom;
    private double budget;
    private String categorie;
    private int age;

    public Film() {
        super();
    }

    public Film(int id, String nom, double budget, String categorie, int age) {
        this.id = id;
        this.nom = nom;
        this.budget = budget;
        this.categorie = categorie;
        this.age = age;
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

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Film [id=" + id + ", nom=" + nom + ", budget=" + budget + ", categorie=" + categorie + ", age=" + age + "]";
    }
}
