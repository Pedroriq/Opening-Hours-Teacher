package br.inatel.cdg.test;

import br.inatel.cdg.BuscaAtendimento;
import br.inatel.cdg.Atendimento;
import br.inatel.cdg.AtendimentoService;
import br.inatel.cdg.AtendimentoServiceImpl;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TesteAtendimento {
    AtendimentoService service;
    BuscaAtendimento buscaAtendimento;

    @Before
    public void setup(){
        service = new AtendimentoServiceImpl();
        buscaAtendimento = new BuscaAtendimento(service);
    }

    @Test
    public void testeNomeProfessor(){
        Atendimento atendimento = buscaAtendimento.buscaAtendimento("Chris");

        assertEquals("Chris", atendimento.getNomeDoProfessor());
    }
}
