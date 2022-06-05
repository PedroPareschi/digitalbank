package br.com.digitalbank.resources;

import br.com.digitalbank.domain.Conta;
import br.com.digitalbank.dtos.ContaDTO;
import br.com.digitalbank.services.ContaService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/conta")
public class ContaResource {

    @Autowired
    private ContaService service;

    @ApiOperation(value = "Cadastrando nova conta")
    @PostMapping()
    public ResponseEntity<Void> insert(@Valid @RequestBody ContaDTO contaDTO) {
        Conta conta = service.insert(new Conta(null, contaDTO.getCpf(), contaDTO.getNome(), contaDTO.getCelular(), contaDTO.getEmail(), contaDTO.getSenha(), null, null));
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(conta.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @ApiOperation(value = "Buscando conta por id")
    @GetMapping(value = "/{id}")
    public ResponseEntity<Conta> find(@PathVariable Integer id) {
        Conta conta = service.find(id);
        return ResponseEntity.ok().body(conta);
    }
}
