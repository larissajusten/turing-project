package br.com.cwi.crescer.api.services.questaodissertativa;

import br.com.cwi.crescer.api.controller.requests.questoes.QuestaoUnicaAlternativaRequest;
import br.com.cwi.crescer.api.domain.enums.Perfil;
import br.com.cwi.crescer.api.domain.questao.QuestaoDissertativa;
import br.com.cwi.crescer.api.domain.usuario.Usuario;
import br.com.cwi.crescer.api.mapper.QuestaoDissertativaMapper;
import br.com.cwi.crescer.api.repository.questao.QuestaoDissertativaRepository;
import br.com.cwi.crescer.api.services.usuario.BuscarUsuarioPorIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class AdicionarQuestaoDissertativaService {

    @Autowired
    private QuestaoDissertativaMapper mapper;

    @Autowired
    private QuestaoDissertativaRepository repository;

    @Autowired
    private BuscarUsuarioPorIdService buscarUsuarioPorIdService;

    public QuestaoDissertativa adicionar(QuestaoUnicaAlternativaRequest request) {
        QuestaoDissertativa questaoDissertativa = mapper.transformar(request);

        questaoDissertativa.setDataCriacao(LocalDate.now());

        //TODO mudar quando tiver o usuário real
        Usuario usuario = buscarUsuarioPorIdService.buscar(1L);
        questaoDissertativa.setUsuario(usuario);

        return repository.save(questaoDissertativa);
    }
}
