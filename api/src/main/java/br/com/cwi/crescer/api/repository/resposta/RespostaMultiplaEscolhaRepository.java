package br.com.cwi.crescer.api.repository.resposta;

import br.com.cwi.crescer.api.domain.questao.QuestaoMultiplaEscolha;
import br.com.cwi.crescer.api.domain.resposta.RespostasMultiplaEscolhaProva;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RespostaMultiplaEscolhaRepository extends JpaRepository<RespostasMultiplaEscolhaProva, Long> {

    List<RespostasMultiplaEscolhaProva> findAllByProvaIdEquals(Long id);

    List<RespostasMultiplaEscolhaProva> findAllByQuestaoMultiplaEscolhaIdEquals(Long id);

}
