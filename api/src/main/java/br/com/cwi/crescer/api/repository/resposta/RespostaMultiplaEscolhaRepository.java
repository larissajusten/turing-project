package br.com.cwi.crescer.api.repository.resposta;

import br.com.cwi.crescer.api.domain.enums.NivelDeDificuldade;
import br.com.cwi.crescer.api.domain.resposta.RespostasMultiplaEscolhaProva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RespostaMultiplaEscolhaRepository extends JpaRepository<RespostasMultiplaEscolhaProva, Long> {

    List<RespostasMultiplaEscolhaProva> findAllByProvaIdEquals(Long id);

    List<RespostasMultiplaEscolhaProva> findAllByQuestaoMultiplaEscolhaIdEquals(Long id);

    @Query("SELECT count(*) FROM RespostasMultiplaEscolhaProva r " +
            "WHERE r.prova.id = ?1 " +
            "AND r.questaoMultiplaEscolha.nivelDeDificuldade = ?2 " +
            "AND r.alternativaMultiplaEscolha.respostaCorreta = TRUE " +
            "GROUP BY r.prova.id")
    Integer buscarQuestoesCorretasDeMultiplaEscolhaPorProvaFiltradasPorNivelDeDificuldade(Long idProva, NivelDeDificuldade nivelDeDificuldade);

}
