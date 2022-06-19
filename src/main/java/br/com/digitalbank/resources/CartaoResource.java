package br.com.digitalbank.resources;

import br.com.digitalbank.domain.Cartao;
import br.com.digitalbank.services.CartaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
public class CartaoResource {

    @Autowired
    private CartaoService service;

    @PostMapping("conta/{id}/cartao")
    public ResponseEntity<Void> insert(@PathVariable Integer id){
        Cartao cartao = service.insert(id);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(cartao.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
