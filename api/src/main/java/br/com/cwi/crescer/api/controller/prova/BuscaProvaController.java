package br.com.cwi.crescer.api.controller.prova;

import br.com.cwi.crescer.api.controller.responses.ProvaComRespostasResponse;
import br.com.cwi.crescer.api.controller.responses.ProvaCorrigidaResponse;
import br.com.cwi.crescer.api.controller.responses.ProvaParaCorrecaoResponse;
import br.com.cwi.crescer.api.controller.responses.ProvaResponse;
import br.com.cwi.crescer.api.services.prova.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/buscar-prova")
public class BuscaProvaController {

    @Autowired
    private BuscarProvasPorNomeOuEmailCorrigidasComNotaService buscarProvasPorNomeOuEmailCorrigidasComNotaService;

    @Autowired
    private BuscarProvaPorIdParaCorrecaoService buscarProvaComRespostasDoUsuario;

    @Autowired
    private BuscarProvaPorIdCorrigidaService buscarProvaPorIdCorrigidaService;

    @Autowired
    private BuscarProvasParaCorrecaoService buscarProvasParaCorrecaoService;

    @Autowired
    private BuscarProvaPorIdComQuestoesService buscarProvaPorIdComQuestoesService;

    @Autowired
    private BuscarProvaPorTokenComQuestoesService buscarProvaPorTokenComQuestoesService;

    //TODO mudou(/buscar-prova/${idProva})
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id-prova}")
    public ProvaResponse buscarProva(@PathVariable("id-prova") Long idProva) {
        return buscarProvaPorIdComQuestoesService.buscar(idProva);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{token}")
    public ProvaResponse buscarProvaPeloToken(@PathVariable("token") String token) {
        return buscarProvaPorTokenComQuestoesService.buscar(token);
    }

    //TODO mudou(/buscar-prova/para-correcao)
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/para-correcao")
    public Page<ProvaParaCorrecaoResponse> buscarProvasParaCorrcao(@PageableDefault Pageable pageable) {
        return buscarProvasParaCorrecaoService.buscar(pageable);
    }

    //TODO mudou(/buscar-prova/corrigidas)
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/corrigidas")
    public List<ProvaCorrigidaResponse> provaCompletaComRespostas(@RequestParam("pesquisa") String nomeOuEmail) {
        return buscarProvasPorNomeOuEmailCorrigidasComNotaService.buscar(nomeOuEmail);
    }

    //TODO mudou(/buscar-prova/${idProva}/completa-corrigida)
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("{id-prova}/completa-corrigida")
    public ProvaCorrigidaResponse provaCompletaDoCandidatoComRespostas(@PathVariable("id-prova") Long idProva) {
        return buscarProvaPorIdCorrigidaService.buscar(idProva);
    }

    //TODO mudou(/buscar-prova/${idProva}/respostas)
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id-prova}-respostas")
    public ProvaComRespostasResponse provaComRespostas(@PathVariable("id-prova") Long idProva) {
        return buscarProvaComRespostasDoUsuario.buscar(idProva);
    }
}
