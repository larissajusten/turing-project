package br.com.cwi.crescer.api.repository.resposta;

import br.com.cwi.crescer.api.domain.resposta.RespostasTecnicaProva;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RespostasTecnicaRepository extends JpaRepository<RespostasTecnicaProva, Long> {
    List<RespostasTecnicaProva> findAllByProvaIdEquals(Long id);
}
