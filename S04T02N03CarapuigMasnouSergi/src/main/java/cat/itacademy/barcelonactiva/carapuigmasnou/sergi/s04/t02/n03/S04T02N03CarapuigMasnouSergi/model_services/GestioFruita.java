package cat.itacademy.barcelonactiva.carapuigmasnou.sergi.s04.t02.n03.S04T02N03CarapuigMasnouSergi.model_services;

import cat.itacademy.barcelonactiva.carapuigmasnou.sergi.s04.t02.n03.S04T02N03CarapuigMasnouSergi.model_domain.Fruita;

import java.util.List;

public interface GestioFruita {
    Fruita afegirFruita(Fruita fruita);

    Fruita actualitzarFruita(Fruita fruita);

    void eliminarFruita(Long id);

    Fruita obtenirFruitaPerId(Long id);

    List<Fruita> obtenirTotesLesFruites();
}