package br.com.cwi.crescer.api.repository.resposta;

import br.com.cwi.crescer.api.domain.resposta.RespostasDissertativaProva;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RespostasDissertativaRepository extends JpaRepository<RespostasDissertativaProva, Long> {
}
