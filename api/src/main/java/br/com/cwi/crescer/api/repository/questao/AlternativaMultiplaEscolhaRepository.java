package br.com.cwi.crescer.api.repository.questao;

import br.com.cwi.crescer.api.domain.questao.AlternativaMultiplaEscolha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AlternativaMultiplaEscolhaRepository extends JpaRepository<AlternativaMultiplaEscolha, Long> {

    List<AlternativaMultiplaEscolha> findAllByQuestaoMultiplaEscolhaIdEquals(Long id);

    @Query("SELECT a FROM AlternativaMultiplaEscolha a " +
            "WHERE a.respostaCorreta = TRUE " +
            "AND a.id = ?1")
    boolean isAlternativaCerta(Long idAlternativa);

}
