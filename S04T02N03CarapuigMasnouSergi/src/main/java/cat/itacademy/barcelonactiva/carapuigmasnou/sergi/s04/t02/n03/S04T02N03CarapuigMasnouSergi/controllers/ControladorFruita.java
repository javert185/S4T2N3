package cat.itacademy.barcelonactiva.carapuigmasnou.sergi.s04.t02.n03.S04T02N03CarapuigMasnouSergi.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import cat.itacademy.barcelonactiva.carapuigmasnou.sergi.s04.t02.n03.S04T02N03CarapuigMasnouSergi.model_domain.Fruita;
import cat.itacademy.barcelonactiva.carapuigmasnou.sergi.s04.t02.n03.S04T02N03CarapuigMasnouSergi.model_services.GestioFruita;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/fruita")
public class ControladorFruita {

    @Autowired
    private GestioFruita gestioFruita;

    @PostMapping("/add")
    public ResponseEntity<?> afegirFruita(@RequestBody Fruita fruita) {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        try {
            Fruita addedFruita = gestioFruita.afegirFruita(fruita);
            map.put("status", 1);
            map.put("message", "Record is Saved Successfully!");
            map.put("data", addedFruita);
            return new ResponseEntity<>(map, HttpStatus.CREATED);
        } catch (Exception ex) {
            map.clear();
            map.put("status", 0);
            map.put("message", "Error occurred while saving data");
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> actualitzarFruita(@PathVariable Long id, @RequestBody Fruita fruita) {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        try {
            Fruita existingFruita = gestioFruita.obtenirFruitaPerId(id);
            if (existingFruita != null) {
                existingFruita.setNom(fruita.getNom());
                existingFruita.setQuantitatQuilos(fruita.getQuantitatQuilos());
                gestioFruita.actualitzarFruita(existingFruita);
                map.put("status", 1);
                map.put("data", existingFruita);
                return new ResponseEntity<>(map, HttpStatus.OK);
            } else {
                map.put("status", 0);
                map.put("message", "Data is not found");
                return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
            }
        } catch (Exception ex) {
            map.clear();
            map.put("status", 0);
            map.put("message", "Error occurred while updating data");
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> eliminarFruita(@PathVariable("id") Long id) {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        try {
            gestioFruita.eliminarFruita(id);
            map.put("status", 1);
            map.put("message", "Record is deleted successfully!");
            return new ResponseEntity<>(map, HttpStatus.OK);
        } catch (Exception ex) {
            map.clear();
            map.put("status", 0);
            map.put("message", "Data is not found");
            return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<Fruita> obtenirFruitaPerId(@PathVariable Long id) {
        Map<String, Object> map = new LinkedHashMap<>();
        Fruita fruita = gestioFruita.obtenirFruitaPerId(id);
        if (fruita != null) {
            map.put("status", 1);
            map.put("data", fruita);
            return new ResponseEntity<>(fruita, HttpStatus.OK);
        } else {
            map.clear();
            map.put("status", 0);
            map.put("message", "Data is not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Fruita>> obtenirTotesLesFruites() {
        Map<String, Object> map = new LinkedHashMap<>();
        List<Fruita> fruites = gestioFruita.obtenirTotesLesFruites();
        if (!fruites.isEmpty()) {
            map.put("status", 1);
            map.put("data", fruites);
            return new ResponseEntity<>(fruites, HttpStatus.OK);
        } else {
            map.clear();
            map.put("status", 0);
            map.put("message", "Data is not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
