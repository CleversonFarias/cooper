package br.com.cleverson.cooper.pauta.application.api;

import br.com.cleverson.cooper.pauta.domain.Pauta;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class PautaApplicationService implements PautaService {
    private final PautaRepository pautaRepository;

    @Override
    public PautaCadastradaResponse cadastraPauta(NovaPautaRequest novaPauta) {
        log.info("[inicia] PautaApplicationService - cadastraPauta ");
        log.info("[novaPauta] ", novaPauta);
        Pauta pauta = pautaRepository.salva(new Pauta(novaPauta));
        log.info("[finaliza] PautaApplicationService - cadastraPauta ");
        return new PautaCadastradaResponse(pauta);
    }
}
