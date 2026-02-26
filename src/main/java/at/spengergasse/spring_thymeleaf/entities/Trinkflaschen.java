package at.spengergasse.spring_thymeleaf.entities;


import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
@Table(name = "trinkflaschen")
public class Trinkflaschen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // ← Long statt int!

    private String marke;
    private Double liter;
    private Double preis;
    private Boolean isolated;
    private LocalDate herstellungsdatum;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarke() {
        return marke;
    }

    public void setMarke(String marke) {
        this.marke = marke;
    }

    public Double getLiter() {
        return liter;
    }

    public void setLiter(Double liter) {
        this.liter = liter;
    }

    public Double getPreis() {
        return preis;
    }

    public void setPreis(Double preis) {
        this.preis = preis;
    }

    public Boolean getIsolated() {
        return isolated;
    }

    public void setIsolated(Boolean isolated) {
        this.isolated = isolated;
    }

    public LocalDate getHerstellungsdatum() {
        return herstellungsdatum;
    }

    public void setHerstellungsdatum(LocalDate herstellungsdatum) {
        this.herstellungsdatum = herstellungsdatum;
    }
}
