package br.com.saks.interesseservice.controller;

import br.com.saks.interesseservice.model.Interesse;
import br.com.saks.interesseservice.model.InteresseIdentity;
import br.com.saks.interesseservice.repository.InteresseRepository;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/interesse")
public class InteresseController {
    
    @Autowired
    private InteresseRepository interesseRepository;
    
    @GetMapping
    public List<Interesse> listarTodos() {
        return interesseRepository.findAll();
    }
    
    @GetMapping(value="/{idCliente}")
    public Optional<Interesse> listarPeloIdCliente(@PathVariable Long idCliente) {
        return interesseRepository.findByInteresseIdentityIdCliente(idCliente);
    }
    
    @GetMapping(value = "/{idCliente}/{idImovel}")
    public Optional<Interesse> findByClienteImovel(@PathVariable Long idCliente, @PathVariable Long idImovel) {
        final InteresseIdentity identity = new InteresseIdentity(idCliente, idImovel);
        return interesseRepository.findById(identity);
    }
    
    @PostMapping
    public Interesse adicionar(@RequestBody Interesse interesse) {
        return interesseRepository.save(interesse);
    }
    
    @DeleteMapping(value="/{idCliente}/{idImovel}")
    public ResponseEntity deletar(@PathVariable Long idCliente, @PathVariable Long idImovel) {
        final InteresseIdentity identity = new InteresseIdentity(idCliente, idImovel);
        return interesseRepository.findById(identity)
            .map(record-> {
                interesseRepository.deleteById(identity);
                return ResponseEntity.ok().build();
            }).orElse(ResponseEntity.notFound().build());
    } 
}