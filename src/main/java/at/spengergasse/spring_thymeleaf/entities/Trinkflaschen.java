package at.spengergasse.spring_thymeleaf.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Trinkflaschen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    // Das ist eine ganz einfache Klasse mit Attributen und den dazugehörigen Getter und Setter Methoden.
    private String marke;
    private int liter;
    private double preis;
    private boolean isIsolated;
    private LocalDate herstellungsdatum;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarke() {
        return marke;
    }

    public void setMarke(String marke) {
        this.marke = marke;
    }

    public int getLiter() {
        return liter;
    }

    public void setLiter(int liter) {
        this.liter = liter;
    }

    public double getPreis() {
        return preis;
    }

    public void setPreis(double preis) {
        this.preis = preis;
    }

    public boolean isIsolated() {
        return isIsolated;
    }

    public void setIsolated(boolean isolated) {
        isIsolated = isolated;
    }

    public LocalDate getHerstellungsdatum() {
        return herstellungsdatum;
    }

    public void setHerstellungsdatum(LocalDate herstellungsdatum) {
        this.herstellungsdatum = herstellungsdatum;
    }
}
