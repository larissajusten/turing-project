package br.com.cwi.crescer.api.services.questaoTecnicaService;

import br.com.cwi.crescer.api.domain.enums.Especificidade;
import br.com.cwi.crescer.api.domain.enums.NivelDeDificuldade;
import br.com.cwi.crescer.api.domain.questao.QuestaoTecnica;
import br.com.cwi.crescer.api.exception.questoes.QuestaoNaoEncontradaException;
import br.com.cwi.crescer.api.repository.questao.QuestaoTecnicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuscarQuestoesTecnicasFiltradasService {

    private final static int TAMANHO_PARA_LANCAR_EXCEPTION_LISTA = 0;

    @Autowired
    private QuestaoTecnicaRepository repository;

    public List<QuestaoTecnica> buscar(Especificidade especificidade, NivelDeDificuldade nivelDeDificuldade){

        if(repository.acharPorNivelEEspecificidade(especificidade, nivelDeDificuldade).size() == TAMANHO_PARA_LANCAR_EXCEPTION_LISTA) {
            throw new QuestaoNaoEncontradaException("Nenhuma questão com essa especificidade e nivel de dificuldade foi encontrada.");
        }

        return repository.acharPorNivelEEspecificidade(especificidade,nivelDeDificuldade);
    }
}
