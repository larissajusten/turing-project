package br.com.cwi.crescer.api.repository.resposta;

import br.com.cwi.crescer.api.domain.resposta.RespostasMutiplaEscolhaProva;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RespostaMultiplaEscolhaRepository extends JpaRepository<RespostasMutiplaEscolhaProva, Long> {
}
