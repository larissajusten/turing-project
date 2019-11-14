package br.com.cwi.crescer.api.services.questaoTecnicaService;

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

    public void adicionar(QuestaoUnicaAlternativaRequest request){
        QuestaoTecnica questaoTecnica = mapper.transformar(request);
        questaoTecnica.setDataCriacao(LocalDate.now());

        //Precisa salvar um usuário no banco para poder usar ele,
        //dá erro porque está tentando usar um usuário que não existe
        //Para resolver agora: é só salvar manualmente um Usuario no banco
       questaoTecnica.setUsuario(new Usuario(1L));

        repository.save(questaoTecnica);
    }

}
