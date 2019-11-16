package br.com.cwi.crescer.api.services.respostaprova;

import br.com.cwi.crescer.api.domain.prova.Prova;
import br.com.cwi.crescer.api.domain.questao.QuestaoMultiplaEscolha;
import br.com.cwi.crescer.api.domain.questao.QuestaoTecnica;
import br.com.cwi.crescer.api.domain.resposta.RespostasMutiplaEscolhaProva;
import br.com.cwi.crescer.api.domain.resposta.RespostasTecnicaProva;
import br.com.cwi.crescer.api.domain.usuario.Usuario;
import br.com.cwi.crescer.api.repository.resposta.RespostaMultiplaEscolhaRepository;
import br.com.cwi.crescer.api.repository.resposta.RespostasTecnicaRepository;
import br.com.cwi.crescer.api.services.provaservice.BuscarProvaPorIdService;
import br.com.cwi.crescer.api.services.questaomultiplaescolha.BuscarQuestaoMultiplaEscolhaPorIdService;
import br.com.cwi.crescer.api.services.questaotecnica.BuscarQuestaoTecnicaPorIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResponderQuestaoMultiplaEscolhaService {

    @Autowired
    private RespostaMultiplaEscolhaRepository repository;

    @Autowired
    private BuscarProvaPorIdService buscarProvaPorIdService;

    @Autowired
    private BuscarQuestaoMultiplaEscolhaPorIdService buscarQuestaoMultiplaEscolhaPorIdService;

    public RespostasMutiplaEscolhaProva responder(Long idProva, Long idQuestao, String resposta){
        RespostasMutiplaEscolhaProva respostasMutiplaEscolhaProva = new RespostasMutiplaEscolhaProva();
        respostasMutiplaEscolhaProva.setResposta(resposta);

        Prova prova = buscarProvaPorIdService.buscar(idProva);
        respostasMutiplaEscolhaProva.setProva(prova);

        QuestaoMultiplaEscolha questaoMultiplaEscolha = buscarQuestaoMultiplaEscolhaPorIdService.buscar(idQuestao);
        respostasMutiplaEscolhaProva.setQuestaoMultiplaEscolha(questaoMultiplaEscolha);

        Usuario usuario = new Usuario();
        usuario.setId(1L);
        respostasMutiplaEscolhaProva.setUsuario(usuario);

        return repository.save(respostasMutiplaEscolhaProva);
    }
}
