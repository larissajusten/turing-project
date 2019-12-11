package br.com.cwi.crescer.api.services.prova;

import br.com.cwi.crescer.api.domain.prova.Prova;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GerarNotaDaProvaComDiferencialDePesoDasQuestoesService {

    @Autowired
    private GerarNotaDasQuestoesDissertativaDeAcordoComPesoService gerarNotasDissertativas;

    @Autowired
    private GerarNotaDasQuestoesTecnicaDeAcordoComPesoService gerarNotasTecnicas;

    @Autowired
    private GerarNotaDasQuestoesMultiplaEscolhaDeAcordoComPesoService gerarNotasMutiplaEscolha;

    @Autowired
    private GerarDivisorFinalParaNotaDaProvaService buscarQuantidadeDeQuestoes;


    public double gerarNotaDaProva(Prova prova) {

        double nota = 0;

        nota = gerarNotasDissertativas.gerar(prova) +
                gerarNotasTecnicas.gerar(prova) +
                gerarNotasMutiplaEscolha.gerar(prova);

        return nota / buscarQuantidadeDeQuestoes.retornarTotalDeQuestoesDaProva(prova);
    }
}
