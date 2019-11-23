package br.com.cwi.crescer.api.services.alternativamultiplaescolha;

import br.com.cwi.crescer.api.domain.questao.AlternativaMultiplaEscolha;
import br.com.cwi.crescer.api.repository.questao.AlternativaMultiplaEscolhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuscarAlternativaQuestaoMultiplaEscolhaService {

    @Autowired
    private AlternativaMultiplaEscolhaRepository repository;

    public List<AlternativaMultiplaEscolha> buscar(Long id) {

        return repository.findAllByQuestaoMultiplaEscolhaIdEquals(id);
    }

}
