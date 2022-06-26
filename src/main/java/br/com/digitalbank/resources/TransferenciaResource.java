package br.com.digitalbank.resources;

import br.com.digitalbank.domain.Conta;
import br.com.digitalbank.dtos.TransferenciaDTO;
import br.com.digitalbank.services.ContaService;
import br.com.digitalbank.services.CustomUserDetails;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/transferencia")
public class TransferenciaResource {

    @Autowired
    private ContaService service;

    @GetMapping()
    public ModelAndView findTransferencia(Authentication authentication) {
        CustomUserDetails user = (CustomUserDetails) authentication.getPrincipal();
        Conta conta = user.getConta();
        ModelAndView modelAndView = new ModelAndView("transferencia.html");
        modelAndView.addObject("conta", conta);
        return modelAndView;
    }

    @PostMapping()
    public ModelAndView transferir(@ModelAttribute("TransferenciaDto") TransferenciaDTO transferenciaDTO, Authentication authentication) {
        CustomUserDetails user = (CustomUserDetails) authentication.getPrincipal();
        Conta conta = user.getConta();
        service.transferir(conta, transferenciaDTO);
        ModelAndView modelAndView = new ModelAndView("transferencia.html");
        return modelAndView;
    }
}
