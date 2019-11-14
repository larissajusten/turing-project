package br.com.cwi.crescer.api.controller.QuestoesControllers;

import br.com.cwi.crescer.api.controller.requests.questoes.QuestaoMultiplaEscolhaRequest;
import br.com.cwi.crescer.api.controller.responses.QuestaoMultiplaEscolhaResponse;
import br.com.cwi.crescer.api.domain.questao.QuestaoMultiplaEscolha;
import br.com.cwi.crescer.api.services.questaoMultiplaEscolhaService.AdicionarQuestaoMultiplaEscolhaService;
import br.com.cwi.crescer.api.services.questaoMultiplaEscolhaService.BuscarQuestoesMultiplaEscolhaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/questao-multipla-escolha")
public class QuestaoMultiplaEscolhaController {

    @Autowired
    private AdicionarQuestaoMultiplaEscolhaService adicionarQuestaoMultiplaEscolha;

    @Autowired
    private BuscarQuestoesMultiplaEscolhaService buscarQuestoesMultiplaEscolha;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public QuestaoMultiplaEscolha adicionarQuestaoMultiplaEscolha(@RequestBody @Valid QuestaoMultiplaEscolhaRequest questaoMultiplaEscolhaRequest) {
        return adicionarQuestaoMultiplaEscolha.adicionar(questaoMultiplaEscolhaRequest);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping("buscar-todas")
    public Page<QuestaoMultiplaEscolhaResponse> buscarQuestoesMultiplaEscolha(@PageableDefault Pageable pageable) {
        return buscarQuestoesMultiplaEscolha.buscarTodasQuestoes(pageable);
    }

}
