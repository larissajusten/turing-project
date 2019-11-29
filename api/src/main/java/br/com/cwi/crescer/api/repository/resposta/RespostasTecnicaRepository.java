package br.com.cwi.crescer.api.repository.resposta;

import br.com.cwi.crescer.api.controller.responses.RespostaParaDashboardResponse;
import br.com.cwi.crescer.api.domain.dto.NotasDTO;
import br.com.cwi.crescer.api.domain.enums.Especificidade;
import br.com.cwi.crescer.api.domain.enums.NivelDeDificuldade;
import br.com.cwi.crescer.api.domain.resposta.RespostasTecnicaProva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RespostasTecnicaRepository extends JpaRepository<RespostasTecnicaProva, Long> {

    List<RespostasTecnicaProva> findAllByProvaIdEquals(Long id);

    List<RespostasTecnicaProva> findAllByQuestaoTecnicaIdEquals(Long id);

    @Query("SELECT new br.com.cwi.crescer.api.domain.dto.NotasDTO(SUM(r.nota), count(*)) " +
            "FROM RespostasTecnicaProva r " +
            "WHERE r.prova.id = ?1 " +
            "AND r.questaoTecnica.nivelDeDificuldade = ?2 " +
            "GROUP BY r.prova.id")
    NotasDTO buscarQuestoesTecnicasFiltradasPorNivelEPorProva(Long idProva, NivelDeDificuldade nivelDeDificuldade);

    @Query("SELECT new br.com.cwi.crescer.api.controller.responses.RespostaParaDashboardResponse(r.questaoTecnica.nivelDeDificuldade, r.nota, count(*)) " +
            "FROM RespostasTecnicaProva r " +
            "WHERE r.questaoTecnica.especificidade = ?1 " +
            "GROUP BY r.nota, r.questaoTecnica.nivelDeDificuldade")
    List<RespostaParaDashboardResponse> buscarQuestoesTecnicasAgrupadasPorNotaENivelDeDificuldade(Especificidade especificidade);
}
