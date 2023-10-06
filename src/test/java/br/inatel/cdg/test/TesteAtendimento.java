package br.inatel.cdg.test;

import br.inatel.cdg.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TesteAtendimento {
    AtendimentoService service;
    AtendimentoImpl atendimento;

    @Before
    public void setup(){
        //service = new MockAtendimentoService();
        service = new AtendimentoServiceImpl();
        atendimento = new AtendimentoImpl(service);
        this.atendimento.adicionaAtendimentoNaLista("Chris", "Sexta - 19:30 - 21:10", "Noturno", 3);
        this.atendimento.adicionaAtendimentoNaLista("Aquino", "Quarta - 10:00 - 11:40", "Integral", 22);
        this.atendimento.adicionaAtendimentoNaLista("Vitor", "Quinta - 13:30 - 15:00", "Integral", 15);
    }

    @Test
    public void testeAdicionaAtendimento(){
        boolean atendimentoAdicionado = this.atendimento.adicionaAtendimentoNaLista("Chris", "Sexta - 19:30 - 21:10", "Noturno", 3);
        assertEquals(true, atendimentoAdicionado);
    }

    @Test
    public void testeAdicionaAtendimentoSalaInvalida(){
        assertThrows(IllegalArgumentException.class, () -> {
            this.atendimento.adicionaAtendimentoNaLista("Chris", "Sexta - 19:30 - 21:10", "Noturno", -1);
        });
    }

    @Test
    public void testeBuscaAtendimento(){
        String atendimento = this.atendimento.buscaAtendimento("Chris");
        String expectedJson = "{\"nomeDoProfessor\":\"Chris\",\"horarioDeAtendimento\":\"Sexta - 19:30 - 21:10\",\"periodo\":\"Noturno\",\"sala\":3,\"predio\":1}";
        assertEquals(expectedJson, atendimento);
    }

    @Test
    public void testeBuscaAtendimentoProfessorInexistente(){
        String atendimento = this.atendimento.buscaAtendimento("Pedro");
        assertNull(atendimento);
    }

    @Test
    public void testeAtualizaHorarioDeAtendimento(){
        String atendimento = this.atendimento.buscaAtendimento("Chris");
        String expectedJson = "{\"nomeDoProfessor\":\"Chris\",\"horarioDeAtendimento\":\"Sexta - 19:30 - 21:10\",\"periodo\":\"Noturno\",\"sala\":3,\"predio\":1}";
        assertEquals(expectedJson, atendimento);
        
        String atendimentoAtualizado = this.atendimento.atualizaAtendimento("Chris", "Quinta - 08:00 - 09:40");
        String expectedJsonAtualizado = "{\"nomeDoProfessor\":\"Chris\",\"horarioDeAtendimento\":\"Quinta - 08:00 - 09:40\",\"periodo\":\"Noturno\",\"sala\":3,\"predio\":1}";
        assertEquals(expectedJsonAtualizado, atendimentoAtualizado);
    }
    
    @After // tearDown()
    public void after() throws Exception {
        boolean atendimentosDeletados = Atendimento.deletaTodosAtendimentos();
        assertTrue(atendimentosDeletados);
    }   
}
