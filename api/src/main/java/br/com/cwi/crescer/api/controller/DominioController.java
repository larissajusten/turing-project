package br.com.cwi.crescer.api.controller;

import br.com.cwi.crescer.api.domain.enums.Especificidade;
import br.com.cwi.crescer.api.domain.enums.NivelDeDificuldade;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/dominio")
public class DominioController {

    @GetMapping("/especificidades")
    public List<Especificidade> especificidades() {

        return Arrays.asList(Especificidade.values());

    }

    @GetMapping("/niveis-dificuldade")
    public List<NivelDeDificuldade> nivelDeDificuldades() {

        return Arrays.asList(NivelDeDificuldade.values());
    }
}
