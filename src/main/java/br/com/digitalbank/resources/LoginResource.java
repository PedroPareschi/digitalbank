package br.com.digitalbank.resources;

import br.com.digitalbank.repositories.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginResource {

    @Autowired
    private ContaRepository contaRepository;

//    @GetMapping("/login")
//    public String fazerlogin() {
//        return "conta";
//    }
}
