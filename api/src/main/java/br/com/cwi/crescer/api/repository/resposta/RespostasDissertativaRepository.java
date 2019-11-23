package br.com.cwi.crescer.api.repository.resposta;

import br.com.cwi.crescer.api.domain.resposta.RespostasDissertativaProva;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RespostasDissertativaRepository extends JpaRepository<RespostasDissertativaProva, Long> {

    List<RespostasDissertativaProva> findAllByProvaIdEquals(Long id);

    List<RespostasDissertativaProva> findAllByQuestaoDissertativaIdEquals(Long id);

}
