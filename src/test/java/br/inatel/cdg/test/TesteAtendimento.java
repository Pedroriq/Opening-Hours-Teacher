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
        boolean atendimentoAdicionado = this.atendimento.adicionaAtendimentoNaLista("Chris", "Quinta - 15:30 - 17:00", "Integral", 3);
        assertEquals(true, atendimentoAdicionado);
    }

    @Test
    public void testeAdicionaAtendimentoSalaInvalida(){
        assertThrows(IllegalArgumentException.class, () -> {
            this.atendimento.adicionaAtendimentoNaLista("Chris", "Sexta - 19:30 - 21:10", "Noturno", -1);
        });
    }

    @Test
    public void testeAdicionaBuscaAtendimento(){
        boolean atendimentoAdicionado = this.atendimento.adicionaAtendimentoNaLista("Renzo", "Terça - 15:30 - 17:00", "Integral", 14);
        assertEquals(true, atendimentoAdicionado);

        String atendimento = this.atendimento.buscaAtendimento("Renzo");
        String expectedJson = "{\"nomeDoProfessor\":\"Renzo\",\"horarioDeAtendimento\":\"Terça - 15:30 - 17:00\",\"periodo\":\"Integral\",\"sala\":14,\"predio\":3}";
        assertEquals(expectedJson, atendimento);
    }

    @Test
    public void testeBuscaAtendimentoChris(){
        String atendimento = this.atendimento.buscaAtendimento("Chris");
        String expectedJson = "{\"nomeDoProfessor\":\"Chris\",\"horarioDeAtendimento\":\"Sexta - 19:30 - 21:10\",\"periodo\":\"Noturno\",\"sala\":3,\"predio\":1}";
        assertEquals(expectedJson, atendimento);
    }

    @Test
    public void testeBuscaAtendimentoAquino(){
        String atendimento = this.atendimento.buscaAtendimento("Aquino");
        String expectedJson = "{\"nomeDoProfessor\":\"Aquino\",\"horarioDeAtendimento\":\"Quarta - 10:00 - 11:40\",\"periodo\":\"Integral\",\"sala\":22,\"predio\":6}";
        assertEquals(expectedJson, atendimento);
    }

    @Test
    public void testeBuscaAtendimentoVitor(){
        String atendimento = this.atendimento.buscaAtendimento("Vitor");
        String expectedJson = "{\"nomeDoProfessor\":\"Vitor\",\"horarioDeAtendimento\":\"Quinta - 13:30 - 15:00\",\"periodo\":\"Integral\",\"sala\":15,\"predio\":3}";
        assertEquals(expectedJson, atendimento);
    }

    @Test
    public void testeBuscaAtendimentoProfessorInexistente(){
        String atendimento = this.atendimento.buscaAtendimento("Phyllipe");
        assertNull(atendimento);
    }

    @Test
    public void testeBuscaAtendimentoPredioInvalido(){
        String atendimento = this.atendimento.buscaAtendimento("Vitor");
        String expectedJson = "{\"nomeDoProfessor\":\"Vitor\",\"horarioDeAtendimento\":\"Quinta - 13:30 - 15:00\",\"periodo\":\"Integral\",\"sala\":15,\"predio\":4}";
        assertNotEquals(expectedJson, atendimento);
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

    @Test
    public void testeAtualizaHorarioDeAtendimentoProfessorInexistente(){
        String atendimentoAtualizado = this.atendimento.atualizaAtendimento("Phyllipe", "Quinta - 08:00 - 09:40");
        assertNull(atendimentoAtualizado);
    }

    @Test
    public void testeDeletaUmAtendimento(){
        boolean deleteVerify = this.atendimento.deletaAtendimento("Chris");
        assertTrue(deleteVerify);
    }

    @Test
    public void testeDeletaDoisAtendimentos(){
        boolean deleteVerify = this.atendimento.deletaAtendimento("Chris");
        assertTrue(deleteVerify);

        deleteVerify = this.atendimento.deletaAtendimento("Chris");
        assertFalse(deleteVerify);
    }

    @Test
    public void testeDeletaUmAtendimentoProfessorInexistente(){
        boolean deleteVerify = this.atendimento.deletaAtendimento("Phyllipe");
        assertFalse(deleteVerify);
    }

    @Test
    public void testeDeletaTodosAtendimentos(){
        boolean deleteVerify = Atendimento.deletaTodosAtendimentos();
        assertTrue(deleteVerify);
    }

    @Test
    public void testeBuscaDeletaTodosAtendimentosBuscaAtendimento(){
        String atendimento = this.atendimento.buscaAtendimento("Chris");
        String expectedJson = "{\"nomeDoProfessor\":\"Chris\",\"horarioDeAtendimento\":\"Sexta - 19:30 - 21:10\",\"periodo\":\"Noturno\",\"sala\":3,\"predio\":1}";
        assertEquals(expectedJson, atendimento);
    
        boolean deleteVerify = Atendimento.deletaTodosAtendimentos();
        assertTrue(deleteVerify);
        
        atendimento = this.atendimento.buscaAtendimento("Chris");
        assertNull(atendimento);
    }

    @Test
    public void testeAdicionaBuscaAtualizaAtendimento(){
        boolean atendimentoAdicionado = this.atendimento.adicionaAtendimentoNaLista("Renzo", "Terça - 15:30 - 17:00", "Integral", 17);
        assertEquals(true, atendimentoAdicionado);

        String atendimento = this.atendimento.buscaAtendimento("Renzo");
        String expectedJson = "{\"nomeDoProfessor\":\"Renzo\",\"horarioDeAtendimento\":\"Terça - 15:30 - 17:00\",\"periodo\":\"Integral\",\"sala\":17,\"predio\":4}";
        assertEquals(expectedJson, atendimento);

        String atendimentoAtualizado = this.atendimento.atualizaAtendimento("Renzo", "Quinta - 10:00 - 11:40");
        String expectedJsonAtualizado = "{\"nomeDoProfessor\":\"Renzo\",\"horarioDeAtendimento\":\"Quinta - 10:00 - 11:40\",\"periodo\":\"Integral\",\"sala\":17,\"predio\":4}";
        assertEquals(expectedJsonAtualizado, atendimentoAtualizado);
    }

    @Test
    public void testeAdicionaBuscaDeletaBuscaAtendimento(){
        boolean atendimentoAdicionado = this.atendimento.adicionaAtendimentoNaLista("Renzo", "Quinta - 15:30 - 17:00", "Integral", 7);
        assertEquals(true, atendimentoAdicionado);

        String atendimento = this.atendimento.buscaAtendimento("Renzo");
        String expectedJson = "{\"nomeDoProfessor\":\"Renzo\",\"horarioDeAtendimento\":\"Quinta - 15:30 - 17:00\",\"periodo\":\"Integral\",\"sala\":7,\"predio\":2}";
        assertEquals(expectedJson, atendimento);
    
        boolean deleteVerify = Atendimento.deletaAtendimento("Renzo");
        assertTrue(deleteVerify);
        
        atendimento = this.atendimento.buscaAtendimento("Renzo");
        assertNull(atendimento);
    }

    @Test
    public void testeAdicionaDeletaBuscaAtendimento(){
        boolean atendimentoAdicionado = this.atendimento.adicionaAtendimentoNaLista("Renzo", "Terça - 15:30 - 17:00", "Integral", 17);
        assertEquals(true, atendimentoAdicionado);

        boolean deleteVerify = Atendimento.deletaAtendimento("Renzo");
        assertTrue(deleteVerify);

        String atendimento = this.atendimento.buscaAtendimento("Renzo");
        assertNull(atendimento);
    }

    @Test
    public void testeDeletaTodosAtendimentosAdicionaBuscaAtendimento(){
        boolean deleteVerify = Atendimento.deletaTodosAtendimentos();
        assertTrue(deleteVerify);

        boolean atendimentoAdicionado = this.atendimento.adicionaAtendimentoNaLista("Chris", "Quinta - 15:30 - 17:00", "Integral", 3);
        assertEquals(true, atendimentoAdicionado);

        String atendimento = this.atendimento.buscaAtendimento("Chris");
        String expectedJson = "{\"nomeDoProfessor\":\"Chris\",\"horarioDeAtendimento\":\"Quinta - 15:30 - 17:00\",\"periodo\":\"Integral\",\"sala\":3,\"predio\":1}";
        assertEquals(expectedJson, atendimento);
    }

    @Test
    public void testeDeletaTodosAtendimentosEBuscaAtendimento(){
        boolean deleteVerify = Atendimento.deletaTodosAtendimentos();
        assertTrue(deleteVerify);

        String atendimento = this.atendimento.buscaAtendimento("Chris");
        assertNull(atendimento);
    }
    
    @After // tearDown()
    public void after() throws Exception {
        boolean atendimentosDeletados = Atendimento.deletaTodosAtendimentos();
        assertTrue(atendimentosDeletados);
    }   
}
