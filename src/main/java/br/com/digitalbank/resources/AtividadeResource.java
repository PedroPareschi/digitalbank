package br.com.digitalbank.resources;

import br.com.digitalbank.domain.Atividade;
import br.com.digitalbank.services.AtividadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AtividadeResource {

    @Autowired
    private AtividadeService service;


    @GetMapping("conta/{conta_id}/atividades")
    public ResponseEntity<Page<Atividade>> findPage(@PathVariable Integer conta_id,
                                                    @RequestParam(value = "page", defaultValue = "0") Integer page,
                                                    @RequestParam(value = "linesPerPage", defaultValue = "8") Integer linesPerPage,
                                                    @RequestParam(value = "orderBy", defaultValue = "data") String orderBy,
                                                    @RequestParam(value = "direction", defaultValue = "DESC") String direction) {
        Page<Atividade> list = service.search(conta_id, page, linesPerPage, orderBy, direction);
        return ResponseEntity.ok().body(list);
    }
}
