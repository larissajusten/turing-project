package br.com.cwi.crescer.api.services.respostaprova;

import br.com.cwi.crescer.api.domain.prova.Prova;
import br.com.cwi.crescer.api.domain.questao.AlternativaMultiplaEscolha;
import br.com.cwi.crescer.api.domain.questao.QuestaoMultiplaEscolha;
import br.com.cwi.crescer.api.domain.resposta.RespostasMultiplaEscolhaProva;
import br.com.cwi.crescer.api.domain.usuario.Usuario;
import br.com.cwi.crescer.api.repository.resposta.RespostaMultiplaEscolhaRepository;
import br.com.cwi.crescer.api.services.alternativamultiplaescolha.BuscarAlternativaMultiplaEscolhaPorIdService;
import br.com.cwi.crescer.api.services.provaservice.BuscarProvaPorIdService;
import br.com.cwi.crescer.api.services.questaomultiplaescolha.BuscarQuestaoMultiplaEscolhaPorIdService;
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

    @Autowired
    private BuscarAlternativaMultiplaEscolhaPorIdService buscarAlternativaMultiplaEscolhaPorIdService;

    public RespostasMultiplaEscolhaProva responder(Long idProva, Long idQuestao, Long idAlternativa){
        RespostasMultiplaEscolhaProva respostasMultiplaEscolhaProva = new RespostasMultiplaEscolhaProva();

        AlternativaMultiplaEscolha alternativaMultiplaEscolha = buscarAlternativaMultiplaEscolhaPorIdService.buscar(idAlternativa);
        respostasMultiplaEscolhaProva.setAlternativaMultiplaEscolha(alternativaMultiplaEscolha);

        Prova prova = buscarProvaPorIdService.buscar(idProva);
        respostasMultiplaEscolhaProva.setProva(prova);

        QuestaoMultiplaEscolha questaoMultiplaEscolha = buscarQuestaoMultiplaEscolhaPorIdService.buscar(idQuestao);
        respostasMultiplaEscolhaProva.setQuestaoMultiplaEscolha(questaoMultiplaEscolha);

        Usuario usuario = new Usuario();
        usuario.setId(1L);
        respostasMultiplaEscolhaProva.setUsuario(usuario);

        return repository.save(respostasMultiplaEscolhaProva);
    }
}
