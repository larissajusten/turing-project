package br.com.cwi.crescer.api.controller;

import br.com.cwi.crescer.api.domain.enums.Especificidade;
import br.com.cwi.crescer.api.domain.enums.NivelDeDificuldade;
import br.com.cwi.crescer.api.domain.enums.TipoDeProva;
import br.com.cwi.crescer.api.domain.enums.TipoDeQuestao;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/dominio")
public class DominioController {

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/especificidade")
    public List<Especificidade> especificidades() {
        return Arrays.asList(Especificidade.values());
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/dificuldade")
    public List<NivelDeDificuldade> nivelDeDificuldades() {
        return Arrays.asList(NivelDeDificuldade.values());
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/tipoDeQuestao")
    public List<TipoDeQuestao> tipoDeQuestao() {
        return Arrays.asList(TipoDeQuestao.values());
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/tipoDeProva")
    public List<TipoDeProva> tipoDeProva() {
        return Arrays.asList(TipoDeProva.values());
    }
}
