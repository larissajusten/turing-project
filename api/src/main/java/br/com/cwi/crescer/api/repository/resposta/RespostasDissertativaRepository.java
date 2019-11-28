package br.com.cwi.crescer.api.repository.resposta;

import br.com.cwi.crescer.api.controller.responses.RespostaParaDashboardResponse;
import br.com.cwi.crescer.api.domain.dto.NotasDTO;
import br.com.cwi.crescer.api.domain.enums.Especificidade;
import br.com.cwi.crescer.api.domain.enums.NivelDeDificuldade;
import br.com.cwi.crescer.api.domain.prova.Prova;
import br.com.cwi.crescer.api.domain.resposta.RespostasDissertativaProva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RespostasDissertativaRepository extends JpaRepository<RespostasDissertativaProva, Long> {

    List<RespostasDissertativaProva> findAllByProvaIdEquals(Long id);

    List<RespostasDissertativaProva> findAllByQuestaoDissertativaIdEquals(Long id);

    @Query("Select new br.com.cwi.crescer.api.domain.dto.NotasDTO(SUM(r.nota), count(*)) FROM RespostasDissertativaProva r " +
            "WHERE r.prova.id = ?1 AND r.questaoDissertativa.nivelDeDificuldade = ?2 GROUP BY r.prova.id")
    NotasDTO buscarQuestoesDissertativasDeNivelFacilPorProva(Prova prova, NivelDeDificuldade nivelDeDificuldade);

    @Query("Select new br.com.cwi.crescer.api.controller.responses.RespostaParaDashboardResponse(r.questaoDissertativa.nivelDeDificuldade, r.nota, count(*)) " +
            "FROM RespostasDissertativaProva r " +
            "WHERE r.questaoDissertativa.especificidade = ?1" +
            " GROUP BY r.nota, r.questaoDissertativa.nivelDeDificuldade" )
    List<RespostaParaDashboardResponse> findAllByGroupByNotaWhereQuestaoDissertativaEspecificidadeEquals(Especificidade especificidade);
}
