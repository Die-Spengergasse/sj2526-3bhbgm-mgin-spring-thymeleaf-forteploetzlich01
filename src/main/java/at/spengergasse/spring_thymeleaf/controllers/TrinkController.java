package at.spengergasse.spring_thymeleaf.controllers;

import at.spengergasse.spring_thymeleaf.entities.Patient;
import at.spengergasse.spring_thymeleaf.entities.PatientRepository;
import at.spengergasse.spring_thymeleaf.entities.Trinkflaschen;
import at.spengergasse.spring_thymeleaf.entities.TrinkflaschenRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Optional;

import java.time.format.DateTimeFormatter;

@Controller
@RequestMapping("/trink")
public class TrinkController {
    private final TrinkflaschenRepository trinkflaschenRepository;

    public TrinkController(TrinkflaschenRepository trinkflaschenRepository) {
        this.trinkflaschenRepository = trinkflaschenRepository;
    }

    @GetMapping("/index")
    public String index(Model model) {
        return "TrinkIndex";
    }

    @GetMapping("/save")
    public String save(Model model) {
        model.addAttribute("trinkflasche", new Trinkflaschen()); // Leeres Objekt für Form
        return "TrinkSave";
    }

    // Speichert aus leerer Form eingegebene Daten in der Datenbank, danach Weiterleitung zur Liste aller Trinkflaschen
    @PostMapping("/save")
    public String save(@ModelAttribute("trinkflasche") Trinkflaschen trinkflasche) {
        trinkflaschenRepository.save(trinkflasche);
        return  "redirect:/trink/list";
    }

    // Zeigt alle Trinkflaschen an, die in der Datenbank gespeichert sind,
    // dazu wird die Methode findAll() des Repositories verwendet, um alle Einträge zu holen und
    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("trinkflaschen", trinkflaschenRepository.findAll());
        return "TrinkList"; // und dazu TrinkList.html erstellen
    }

    // Löscht eine Trinkflasche anhand der ID, die als Parameter übergeben wird, danach Weiterleitung zur Liste aller Trinkflaschen
    @GetMapping("/delete")
    public String delete(@RequestParam("id") Long id) {
        trinkflaschenRepository.deleteById(id);
        return "redirect:/trink/list";
    }

    // Zeigt ein Formular zum Aktualisieren einer Trinkflasche an, basierend auf der ID, die als Parameter übergeben wird.
    @GetMapping("/update")
    public String updateForm(@RequestParam("id") Long id, Model model) {
        Trinkflaschen trinkflasche = trinkflaschenRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID nicht gefunden"));
        model.addAttribute("trinkflasche", trinkflasche);
        return "TrinkUpdate";  // TrinkUpdate.html
    }

    // Aktualisiert die Daten einer Trinkflasche in der Datenbank basierend auf den Informationen,
    // die aus dem Formular übergeben werden, danach Weiterleitung zur Liste aller Trinkflaschen
    @PostMapping("/update")
    public String update(@ModelAttribute("trinkflasche") Trinkflaschen trinkflasche) {
        trinkflaschenRepository.save(trinkflasche);
        return "redirect:/trink/list";
    }

}
