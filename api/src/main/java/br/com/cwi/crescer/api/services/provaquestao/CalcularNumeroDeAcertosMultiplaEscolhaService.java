package br.com.cwi.crescer.api.services.provaquestao;

import br.com.cwi.crescer.api.domain.questao.AlternativaMultiplaEscolha;
import br.com.cwi.crescer.api.domain.questaoprova.ProvaQuestaoMultiplaEscolha;
import br.com.cwi.crescer.api.domain.resposta.RespostasMultiplaEscolhaProva;
import br.com.cwi.crescer.api.exception.ValidacaoDeAplicacaoException;
import br.com.cwi.crescer.api.repository.questao.AlternativaMultiplaEscolhaRepository;
import br.com.cwi.crescer.api.repository.resposta.RespostaMultiplaEscolhaRepository;
import br.com.cwi.crescer.api.services.alternativamultiplaescolha.BuscarAlternativaQuestaoMultiplaEscolhaService;
import br.com.cwi.crescer.api.services.alternativamultiplaescolha.RetornarAlternativaCertaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalcularNumeroDeAcertosMultiplaEscolhaService {

    @Autowired
    private ListarQuestoesMultiplaEscolhaDaProvaService listarQuestoesMultiplaEscolhaDaProvaService;

    @Autowired
    private BuscarAlternativaQuestaoMultiplaEscolhaService buscarAlternativaQuestaoMultiplaEscolhaService;

    @Autowired
    private RetornarAlternativaCertaService retornarAlternativaCertaService;

    @Autowired
    private RespostaMultiplaEscolhaRepository repository;

    @Autowired
    private AlternativaMultiplaEscolhaRepository alternativaMultiplaEscolhaRepository;

    public int calcular(Long idProva){
        int corretas = 0;

        List<RespostasMultiplaEscolhaProva> listaRespostas = repository.findAllByProvaIdEquals(idProva);

        for (RespostasMultiplaEscolhaProva respostasMultiplaEscolhaProva : listaRespostas) {
            AlternativaMultiplaEscolha alternativaEscolhida = respostasMultiplaEscolhaProva.getAlternativaMultiplaEscolha();

            if(alternativaEscolhida.isRespostaCorreta()){
                corretas++;
            }
        }

        return corretas;
    }
}
