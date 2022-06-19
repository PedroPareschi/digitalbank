package br.com.digitalbank.resources;

import br.com.digitalbank.domain.Conta;
import br.com.digitalbank.dtos.ContaDTO;
import br.com.digitalbank.dtos.TransferenciaDTO;
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
        Conta conta = service.fromDTO(contaDTO);
        conta = service.insert(conta);
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

    @ApiOperation(value = "Transferir dinheiro")
    @PutMapping(value = "/{id}/transferencia")
    public ResponseEntity<Void> transferir(@PathVariable Integer id, @Valid @RequestBody TransferenciaDTO transferenciaDTO){
        service.transferir(id, transferenciaDTO);
        return ResponseEntity.ok().build();
    }
}
