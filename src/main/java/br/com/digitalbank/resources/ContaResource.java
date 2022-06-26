package br.com.digitalbank.resources;

import br.com.digitalbank.domain.Atividade;
import br.com.digitalbank.domain.Conta;
import br.com.digitalbank.dtos.ContaDTO;
import br.com.digitalbank.services.ContaService;
import br.com.digitalbank.services.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class ContaResource {

    @Autowired
    private ContaService service;

    @PostMapping("/cadastro")
    public ResponseEntity<Void> insert(@Valid @RequestBody ContaDTO contaDTO) {
        Conta conta = service.fromDTO(contaDTO);
        conta = service.insert(conta);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(conta.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/conta")
    public ModelAndView find(Authentication authentication) {
        CustomUserDetails user = (CustomUserDetails) authentication.getPrincipal();
        Conta conta = user.getConta();
        ModelAndView modelAndView = new ModelAndView("paginainicial.html");
        modelAndView.addObject("conta", conta);
        List<Atividade> atividades = conta.getAtividades();
        modelAndView.addObject("atividades", atividades);
        return modelAndView;
    }
}
