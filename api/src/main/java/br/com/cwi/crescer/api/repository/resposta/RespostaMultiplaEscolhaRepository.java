package br.com.cwi.crescer.api.repository.resposta;

import br.com.cwi.crescer.api.domain.questao.AlternativaMultiplaEscolha;
import br.com.cwi.crescer.api.domain.resposta.RespostasMultiplaEscolhaProva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface RespostaMultiplaEscolhaRepository extends JpaRepository<RespostasMultiplaEscolhaProva, Long> {

    List<RespostasMultiplaEscolhaProva> findAllByProvaIdEquals(Long id);
}
