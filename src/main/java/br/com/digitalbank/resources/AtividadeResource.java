package br.com.digitalbank.resources;

import br.com.digitalbank.repositories.AtividadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/atividades")
public class AtividadeResource {

    @Autowired
    private AtividadeRepository repository;

    
}
