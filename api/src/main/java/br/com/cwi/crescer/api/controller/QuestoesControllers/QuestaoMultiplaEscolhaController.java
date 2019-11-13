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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/questao-multipla-escolha")
public class QuestaoMultiplaEscolhaController {

    @Autowired
    private AdicionarQuestaoMultiplaEscolhaService adicionarQuestaoMultiplaEscolha;

    @Autowired
    private BuscarQuestoesMultiplaEscolhaService buscarQuestoesMultiplaEscolha;

    public void adicionarQuestaoMultiplaEscolha(@RequestBody @Valid QuestaoMultiplaEscolhaRequest questaoMultiplaEscolhaRequest) {

        adicionarQuestaoMultiplaEscolha.adicionar(questaoMultiplaEscolhaRequest);

    }

    public Page<QuestaoMultiplaEscolhaResponse> buscarQuestoesMultiplaEscolha(@PageableDefault Pageable pageable) {

        return buscarQuestoesMultiplaEscolha.buscarTodasQuestoes(pageable);
    }
}
