package cat.itacademy.barcelonactiva.carapuigmasnou.sergi.s04.t02.n03.S04T02N03CarapuigMasnouSergi.model_services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cat.itacademy.barcelonactiva.carapuigmasnou.sergi.s04.t02.n03.S04T02N03CarapuigMasnouSergi.model_domain.Fruita;
import cat.itacademy.barcelonactiva.carapuigmasnou.sergi.s04.t02.n03.S04T02N03CarapuigMasnouSergi.model_repository.RepositoriFruita;

@Service
public class ServeiFruita implements GestioFruita {

    @Autowired
    private RepositoriFruita repositoriFruita;
    
    @Override
    public Fruita afegirFruita(Fruita fruita) {
        return repositoriFruita.save(fruita);
    }
    
    @Override
    public Fruita actualitzarFruita(Fruita fruita) {
        return repositoriFruita.save(fruita);
    }
    
    @Override
    public void eliminarFruita(Long id) {
    	repositoriFruita.deleteById(id);
    }
    
    @Override
    public Fruita obtenirFruitaPerId(Long id) {
        return repositoriFruita.findById(id).orElse(null);
    }
    
    @Override
    public List<Fruita> obtenirTotesLesFruites() {
        return repositoriFruita.findAll();
    }
}