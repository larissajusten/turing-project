package br.com.cwi.crescer.api.services.questaotecnica;

import br.com.cwi.crescer.api.controller.requests.questoes.QuestaoTecnicaRequest;
import br.com.cwi.crescer.api.domain.questao.QuestaoTecnica;
import br.com.cwi.crescer.api.domain.usuario.Usuario;
import br.com.cwi.crescer.api.mapper.QuestaoTecnicaMapper;
import br.com.cwi.crescer.api.repository.questao.QuestaoTecnicaRepository;
import br.com.cwi.crescer.api.security.LoggedUser;
import br.com.cwi.crescer.api.services.autenticacao.VerificarPerfilUsuarioLogadoService;
import br.com.cwi.crescer.api.services.usuario.BuscarUsuarioPeloEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class AdicionarQuestaoTecnicaService {

    @Autowired
    private QuestaoTecnicaRepository repository;

    @Autowired
    private QuestaoTecnicaMapper mapper;

    @Autowired
    private BuscarUsuarioPeloEmailService buscarUsuarioPeloEmailService;

    @Autowired
    private VerificarPerfilUsuarioLogadoService verificarPerfilUsuarioLogadoService;

    @Autowired
    private LoggedUser loggedUser;

    public void adicionar(QuestaoTecnicaRequest request) {

        verificarPerfilUsuarioLogadoService.verificar(loggedUser);
        Usuario usuario = buscarUsuarioPeloEmailService.buscar(loggedUser.getEmail());

        QuestaoTecnica questaoTecnica = mapper.transformar(request);
        questaoTecnica.setDataCriacao(LocalDate.now());
        questaoTecnica.setUsuario(usuario);

        repository.save(questaoTecnica);
    }

}
