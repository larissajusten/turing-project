package br.com.cwi.crescer.api.services.questaoMultiplaEscolhaService;

import br.com.cwi.crescer.api.controller.requests.questoes.QuestaoMultiplaEscolhaRequest;
import br.com.cwi.crescer.api.domain.questao.QuestaoMultiplaEscolha;
import br.com.cwi.crescer.api.domain.usuario.Usuario;
import br.com.cwi.crescer.api.mapper.QuestaoMultiplaEscolhaMapper;
import br.com.cwi.crescer.api.repository.questao.QuestaoMultiplaEscolhaRepository;
import br.com.cwi.crescer.api.services.alternativaMultiplaEscolhaService.AdicionarAlternativaMultiplaEscolhaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class AdicionarQuestaoMultiplaEscolhaService {

    @Autowired
    private QuestaoMultiplaEscolhaMapper mapper;

    @Autowired
    private QuestaoMultiplaEscolhaRepository repository;

    @Autowired
    private AdicionarAlternativaMultiplaEscolhaService adicionarAlternativaMultiplaEscolha;

    public void adicionar(QuestaoMultiplaEscolhaRequest questaoMultiplaEscolhaRequest) {

        QuestaoMultiplaEscolha questaoMultiplaEscolha = mapper.mapperToQuestao(questaoMultiplaEscolhaRequest);

        questaoMultiplaEscolha.setDataCriacao(LocalDate.now());
        questaoMultiplaEscolha.setUsuario(new Usuario(1L));

        QuestaoMultiplaEscolha questaoSalva = repository.save(questaoMultiplaEscolha);

        adicionarAlternativaMultiplaEscolha
                .adicionarAlternativa(questaoMultiplaEscolhaRequest.getAlternativaA(), questaoSalva.getId());
        adicionarAlternativaMultiplaEscolha
                .adicionarAlternativa(questaoMultiplaEscolhaRequest.getAlternativaB(), questaoSalva.getId());
        adicionarAlternativaMultiplaEscolha
                .adicionarAlternativa(questaoMultiplaEscolhaRequest.getAlternativaC(), questaoSalva.getId());
        adicionarAlternativaMultiplaEscolha
                .adicionarAlternativa(questaoMultiplaEscolhaRequest.getAlternativaD(), questaoSalva.getId());
        adicionarAlternativaMultiplaEscolha
                .adicionarAlternativa(questaoMultiplaEscolhaRequest.getAlternativaE(), questaoSalva.getId());


    }
}
