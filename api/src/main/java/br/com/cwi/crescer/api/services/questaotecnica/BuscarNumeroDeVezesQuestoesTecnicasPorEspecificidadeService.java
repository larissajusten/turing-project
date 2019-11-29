package br.com.cwi.crescer.api.services.questaotecnica;

import br.com.cwi.crescer.api.domain.enums.Especificidade;
import br.com.cwi.crescer.api.domain.questao.QuestaoTecnica;
import br.com.cwi.crescer.api.repository.questao.QuestaoTecnicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuscarNumeroDeVezesQuestoesTecnicasPorEspecificidadeService {

    @Autowired
    private QuestaoTecnicaRepository repository;


    public int buscar(Especificidade especificidade) {

        List<QuestaoTecnica> lista = repository.findByEspecificidade(especificidade);

        int vezes = 0;
        for (QuestaoTecnica questaoTecnica : lista) {
            if (questaoTecnica.getVezesUsada() > 0) {
                vezes++;
            }
        }

        return vezes;
    }
}
