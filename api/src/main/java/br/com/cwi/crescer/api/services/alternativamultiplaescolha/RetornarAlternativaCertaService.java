package br.com.cwi.crescer.api.services.alternativamultiplaescolha;

import br.com.cwi.crescer.api.repository.questao.AlternativaMultiplaEscolhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RetornarAlternativaCertaService {

    @Autowired
    private AlternativaMultiplaEscolhaRepository repository;

    public boolean retornar(Long idAlternativa){
        return repository.isAlternativaCerta(idAlternativa);
    }
}
