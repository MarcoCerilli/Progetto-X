package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyController {

    private List<Cesto> listaC = new ArrayList<>();
    private List<CestoA> listaP = new ArrayList<>();
    private List<Cesti> listaD = new ArrayList<>();
    private List<CestiA> listaE = new ArrayList<>();

    @GetMapping("/")
    public String getHome(Model model) {
        return "home";
    }

    @PostMapping("/submit")
    public String postSubmit(
        Model model,
        @RequestParam("nome") String nome,
        @RequestParam("marca") String marca,
        @RequestParam("prezzo") double prezzo,
        @RequestParam("luogo") String luogo,
        @RequestParam("immagine") String url
    ) {
        model.addAttribute("nome", nome);
        model.addAttribute("marca", marca);
        model.addAttribute("prezzo", prezzo);
        model.addAttribute("luogo", luogo);
        model.addAttribute("immagine", url);

        listaC.add(new Cesto(nome, marca, prezzo, luogo, url));
        return "submit";
    }

    @PostMapping("/submitSimple")
    public String postSubmitSimple(
        Model model,
        @RequestParam("nome") String nome,
        @RequestParam("prezzo") double prezzo
    ) {
        model.addAttribute("nome", nome);
        model.addAttribute("prezzo", prezzo);

        listaD.add(new Cesti(nome, prezzo));
        return "submit";
    }

    @GetMapping("/store")
    public String getStore(Model model) {
        listaC.clear();
        listaC.add(new Cesto("Porchetta", "Ariccia", 20, "Lazio", "https://m.media-amazon.com/images/I/61h4HpJmnyL.AC_SL1000.jpg"));
        listaC.add(new Cesto("Bonet di cioccolato", "Torino", 30, "Piemonte", "https://www.giallozafferano.it/images/2-220/Bonet_650x433_wm.jpg"));
        listaC.add(new Cesto("Panettone con canditi", "Bauli", 40, "Lombardia", "https://m.media-amazon.com/images/I/614OjEvhJ4L.AC_UL320.jpg"));
        listaC.add(new Cesto("Sigari", "H-Upman", 40, "Cuba", "https://shorturl.at/9WKWa"));

        listaD.clear();
        listaD.add(new Cesti("Cesto in vimini", 40));
        listaD.add(new Cesti("Cesto in legno", 35));
        listaD.add(new Cesti("Cesto in rattan", 45));
        listaD.add(new Cesti("Cesto in cartone", 15));

        model.addAttribute("listaC", listaC);
        model.addAttribute("listaD", listaD);

        return "store";
    }

    @PostMapping("/buyProducts")
    public String recapProducts(
        @RequestParam("selected") List<Integer> selected,
        Model model
    ) {
        int somma = 0;
        listaP.clear();

        for (int i = 0; i < listaC.size(); i++) {
            if (selected.get(i) > 0) {
                somma += selected.get(i) * listaC.get(i).getPrezzo();
                CestoA c1 = new CestoA(
                    listaC.get(i).getNome(),
                    listaC.get(i).getMarca(),
                    listaC.get(i).getPrezzo(),
                    listaC.get(i).getLuogo(),
                    listaC.get(i).getUrl(),
                    selected.get(i)
                );
                listaP.add(c1);
            }
        }

        model.addAttribute("lista", listaP);
        model.addAttribute("somma", somma);
        return "recap";
    }

    @PostMapping("/buyBaskets")
    public String recapBaskets(
        @RequestParam("selected") List<Integer> selected,
        Model model
    ) {
        int somma1 = 0;
        listaE.clear();

        for (int j = 0; j < listaD.size(); j++) {
            if (selected.get(j) > 0) {
                somma1 += selected.get(j) * listaD.get(j).getPrezzo();
                CestiA d1 = new CestiA(
                    listaD.get(j).getNome(),
                    listaD.get(j).getPrezzo(),
                    selected.get(j)
                );
                listaE.add(d1);
            }
        }

        model.addAttribute("lista1", listaE);
        model.addAttribute("somma1", somma1);
        return "recap";
    }
}
