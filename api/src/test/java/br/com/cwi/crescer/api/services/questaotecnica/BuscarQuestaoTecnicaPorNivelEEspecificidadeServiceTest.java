package br.com.cwi.crescer.api.services.questaotecnica;

import br.com.cwi.crescer.api.domain.enums.Especificidade;
import br.com.cwi.crescer.api.domain.enums.NivelDeDificuldade;
import br.com.cwi.crescer.api.domain.questao.QuestaoTecnica;
import br.com.cwi.crescer.api.repository.questao.QuestaoTecnicaRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class BuscarQuestaoTecnicaPorNivelEEspecificidadeServiceTest {

    @InjectMocks
    BuscarQuestoesTecnicasFiltradasService buscarQuestaoTecnicaPorNivelEEspecificidadeService;

    @Mock
    QuestaoTecnicaRepository repository;

    @Test
    public void deveChamarQuestaoTecnicaRepositoryQuandoBuscarQuestaoTecnicaPorNivelEEspecificidadeServiceForChamada() {

        QuestaoTecnica questaoTecnica = new QuestaoTecnica();
        questaoTecnica.setEspecificidade(Especificidade.JAVASCRIPT);
        questaoTecnica.setNivelDeDificuldade(NivelDeDificuldade.FACIL);

        List<QuestaoTecnica> questoesTecnicas = new ArrayList<>();
        questoesTecnicas.add(questaoTecnica);

        Pageable quantos = PageRequest.of(0, 10);
        Mockito.when(repository
                .findByEspecificidadeAndNivelDeDificuldadeOrderByVezesUsadaAsc(Especificidade.JAVASCRIPT, NivelDeDificuldade.FACIL, quantos))
                .thenReturn(questoesTecnicas);

        buscarQuestaoTecnicaPorNivelEEspecificidadeService.buscar(Especificidade.JAVASCRIPT, NivelDeDificuldade.FACIL, 10);

        Mockito.verify(repository, Mockito.times(1)).findByEspecificidadeAndNivelDeDificuldadeOrderByVezesUsadaAsc(Especificidade.JAVASCRIPT, NivelDeDificuldade.FACIL, quantos);
    }


}