package br.com.cwi.crescer.api.services.alternativamultiplaescolha;

import br.com.cwi.crescer.api.domain.questao.AlternativaMultiplaEscolha;
import br.com.cwi.crescer.api.exception.ValidacaoDeAplicacaoException;
import br.com.cwi.crescer.api.repository.questao.AlternativaMultiplaEscolhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuscarAlternativaMultiplaEscolhaPorIdService {

    @Autowired
    private AlternativaMultiplaEscolhaRepository repository;

    public AlternativaMultiplaEscolha buscar(Long id){
        return repository.findById(id).orElseThrow(() -> new ValidacaoDeAplicacaoException("Alternativa não encontrada"));
    }
}
