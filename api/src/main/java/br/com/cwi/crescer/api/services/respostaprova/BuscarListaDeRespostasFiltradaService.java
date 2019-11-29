package br.com.cwi.crescer.api.services.respostaprova;

import br.com.cwi.crescer.api.domain.enums.Especificidade;
import br.com.cwi.crescer.api.domain.enums.NivelDeDificuldade;
import br.com.cwi.crescer.api.domain.questao.QuestaoMultiplaEscolha;
import br.com.cwi.crescer.api.domain.resposta.RespostasMultiplaEscolhaProva;
import br.com.cwi.crescer.api.repository.questao.QuestaoMultiplaEscolhaRepository;
import br.com.cwi.crescer.api.repository.resposta.RespostaMultiplaEscolhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BuscarListaDeRespostasFiltradaService {

    @Autowired
    private RespostaMultiplaEscolhaRepository repository;

    @Autowired
    private QuestaoMultiplaEscolhaRepository questaoRepository;

    public List<RespostasMultiplaEscolhaProva> retornar(Especificidade especificidade, NivelDeDificuldade nivelDeDificuldade) {

        List<QuestaoMultiplaEscolha> lista = questaoRepository.acharPorNivelEEspecificidadeListado(especificidade, nivelDeDificuldade);
        List<RespostasMultiplaEscolhaProva> listaResposta = new ArrayList<>();

        for (QuestaoMultiplaEscolha questaoMultiplaEscolha : lista) {
            Long idQuestao = questaoMultiplaEscolha.getId();
            List<RespostasMultiplaEscolhaProva> todasDessaQuestao = repository.findAllByQuestaoMultiplaEscolhaIdEquals(idQuestao);
            listaResposta.addAll(todasDessaQuestao);
        }

        return listaResposta;
    }
}
