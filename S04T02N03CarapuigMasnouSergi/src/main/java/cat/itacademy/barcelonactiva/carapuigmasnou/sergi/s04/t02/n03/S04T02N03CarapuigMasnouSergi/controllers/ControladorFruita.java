package cat.itacademy.barcelonactiva.carapuigmasnou.sergi.s04.t02.n03.S04T02N03CarapuigMasnouSergi.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import cat.itacademy.barcelonactiva.carapuigmasnou.sergi.s04.t02.n03.S04T02N03CarapuigMasnouSergi.model_domain.Fruita;
import cat.itacademy.barcelonactiva.carapuigmasnou.sergi.s04.t02.n03.S04T02N03CarapuigMasnouSergi.model_services.ServeiFruita;


@RestController
@RequestMapping("/fruita")
public class ControladorFruita implements ControladorGestioFruita {

    @Autowired
    private ServeiFruita serveiFruita;
    
    @Override
    @PostMapping("/add")
    public Fruita afegirFruita(@RequestBody Fruita fruita) {
    	return serveiFruita.afegirFruita(fruita);
    }
    
    @Override
    @PostMapping("/update/{id}")
    public Fruita actualitzarFruita(@PathVariable Long id,@RequestBody Fruita fruita) {
    	return serveiFruita.actualitzarFruita(fruita);
    }
    
    @Override
    @GetMapping("/delete/{id}")
    public void eliminarFruita(@PathVariable("id") Long id) {
        serveiFruita.eliminarFruita(id);
    }
    
    @Override
    @GetMapping("/getOne/{id}")
    public Fruita obtenirFruitaPerId(@PathVariable Long id) {
        return serveiFruita.obtenirFruitaPerId(id);
    }
    
    @Override
    @GetMapping("/getAll")
    public List<Fruita> obtenirTotesLesFruites() {
        return serveiFruita.obtenirTotesLesFruites();
    }
}