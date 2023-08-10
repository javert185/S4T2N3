package cat.itacademy.barcelonactiva.carapuigmasnou.sergi.s04.t02.n03.S04T02N03CarapuigMasnouSergi.model_services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cat.itacademy.barcelonactiva.carapuigmasnou.sergi.s04.t02.n03.S04T02N03CarapuigMasnouSergi.model_domain.Fruita;
import cat.itacademy.barcelonactiva.carapuigmasnou.sergi.s04.t02.n03.S04T02N03CarapuigMasnouSergi.model_repository.RepositoriFruita;

@Service
public class ServeiFruita {

    @Autowired
    private RepositoriFruita repositoriFruita;

    public Fruita afegirFruita(Fruita fruita) {
        return repositoriFruita.save(fruita);
    }

    public Fruita actualitzarFruita(Fruita fruita) {
        return repositoriFruita.save(fruita);
    }

    public void eliminarFruita(Long id) {
    	repositoriFruita.deleteById(id);
    }

    public Fruita obtenirFruitaPerId(Long id) {
        return repositoriFruita.findById(id).orElse(null);
    }

    public List<Fruita> obtenirTotesLesFruites() {
        return repositoriFruita.findAll();
    }
}