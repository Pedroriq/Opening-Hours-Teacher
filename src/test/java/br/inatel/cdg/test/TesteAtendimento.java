package br.inatel.cdg.test;

import br.inatel.cdg.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TesteAtendimento {
    AtendimentoService service;
    BuscaAtendimento buscaAtendimento;

    CriaAtendimento criarAtendimento;

    @Test
    public void testeNomeProfessor(){


        Atendimento atendimento = buscaAtendimento.buscaAtendimento("Chris");

        assertEquals("Chris", atendimento.getNomeDoProfessor());
    }

    @Test
    public void testCriarAtendimento() throws CriacaoAtendimentoInvalida{

        boolean atendimento = criarAtendimento.criaAtendimento("Teste_professor", "Sexta - 19:30 - 21:10", "Noturno", 1000);

    }
}
