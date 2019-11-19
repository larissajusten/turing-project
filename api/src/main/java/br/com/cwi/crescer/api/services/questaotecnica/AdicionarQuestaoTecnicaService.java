package br.com.cwi.crescer.api.services.questaotecnica;

import br.com.cwi.crescer.api.controller.requests.questoes.QuestaoTecnicaRequest;
import br.com.cwi.crescer.api.controller.requests.questoes.QuestaoUnicaAlternativaRequest;
import br.com.cwi.crescer.api.domain.questao.QuestaoTecnica;
import br.com.cwi.crescer.api.domain.usuario.Usuario;
import br.com.cwi.crescer.api.mapper.QuestaoTecnicaMapper;
import br.com.cwi.crescer.api.repository.questao.QuestaoTecnicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class AdicionarQuestaoTecnicaService {

    @Autowired
    private QuestaoTecnicaRepository repository;

    @Autowired
    private QuestaoTecnicaMapper mapper;

    public void adicionar(QuestaoTecnicaRequest request) {
        QuestaoTecnica questaoTecnica = mapper.transformar(request);
        questaoTecnica.setDataCriacao(LocalDate.now());

        questaoTecnica.setUsuario(new Usuario(1L, "a"));

        repository.save(questaoTecnica);
    }

}
