package br.inatel.cdg.test.mockito;

import br.inatel.cdg.AtendimentoImpl;
import br.inatel.cdg.AtendimentoService;
import br.inatel.cdg.test.AtendimentoConst;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class TesteAtendimento {

    @Mock
    private AtendimentoService service;
    private AtendimentoImpl atendimento;

    @Before
    public void setup(){
        atendimento = new AtendimentoImpl(service);
    }

    @Test
    public void testeBuscaAtendimentoChris(){
        Mockito.when(service.buscaAtendimento("Chris")).thenReturn(AtendimentoConst.CHRIS);

        String atendimento = this.atendimento.buscaAtendimento("Chris");
        String expectedJson = "{\"nomeDoProfessor\":\"Chris\",\"horarioDeAtendimento\":\"Sexta - 19:30 - 21:10\",\"periodo\":\"Noturno\",\"sala\":3,\"predio\":1}";
        
        assertEquals(expectedJson, atendimento);
    }

    @Test
    public void testeBuscaAtendimentoAquino(){
        Mockito.when(service.buscaAtendimento("Aquino")).thenReturn(AtendimentoConst.AQUINO);

        String atendimento = this.atendimento.buscaAtendimento("Aquino");
        String expectedJson = "{\"nomeDoProfessor\":\"Aquino\",\"horarioDeAtendimento\":\"Segunda - 13:30 - 15:10\",\"periodo\":\"Integral\",\"sala\":10,\"predio\":2}";
        
        assertEquals(expectedJson, atendimento);
    }

    @Test
    public void testeBuscaAtendimentoVitor(){
        Mockito.when(service.buscaAtendimento("Vitor")).thenReturn(AtendimentoConst.VITOR);

        String atendimento = this.atendimento.buscaAtendimento("Vitor");
        String expectedJson = "{\"nomeDoProfessor\":\"Vitor\",\"horarioDeAtendimento\":\"Quarta - 15:30 - 17:10\",\"periodo\":\"Noturno\",\"sala\":8,\"predio\":2}";
        
        assertEquals(expectedJson, atendimento);
    }

    @Test
    public void testeAdicionaAtendimento(){
        Mockito.when(service.adicionaAtendimentoNaLista("Chris", "Quinta - 15:30 - 17:00", "Integral", 3)).thenReturn(true);

        Boolean atendimento = this.atendimento.adicionaAtendimentoNaLista("Chris", "Quinta - 15:30 - 17:00", "Integral", 3);

        assertTrue(atendimento);
    }

    @Test
    public void testeAdicionaBuscaAtendimento(){
        Mockito.when(service.adicionaAtendimentoNaLista("Renzo", "Terça - 15:30 - 17:00", "Integral", 14)).thenReturn(true);

        boolean atendimentoAdicionado = this.atendimento.adicionaAtendimentoNaLista("Renzo", "Terça - 15:30 - 17:00", "Integral", 14);

        assertTrue(atendimentoAdicionado);

        String expectedJson = "{\"nomeDoProfessor\":\"Renzo\",\"horarioDeAtendimento\":\"Terça - 15:30 - 17:00\",\"periodo\":\"Integral\",\"sala\":14,\"predio\":3}";

        Mockito.when(service.buscaAtendimento("Renzo")).thenReturn(expectedJson);

        String atendimento = this.atendimento.buscaAtendimento("Renzo");

        assertEquals(expectedJson, atendimento);

    }

    @Test
    public void testeBuscaAtendimentoProfessorInexistente(){
        Mockito.when(service.buscaAtendimento("Phyllipe")).thenReturn(null);
        String atendimento = this.atendimento.buscaAtendimento("Phyllipe");
        assertNull(atendimento);
    }

    @Test
    public void testeBuscaAtendimentoPredioInvalido(){

        Mockito.when(service.buscaAtendimento("Vitor")).thenReturn("{\"nomeDoProfessor\":\"Vitor\",\"horarioDeAtendimento\":\"Quinta - 13:30 - 15:00\",\"periodo\":\"Integral\",\"sala\":15,\"predio\":3}");

        String atendimento = this.atendimento.buscaAtendimento("Vitor");

        String expectedJson = "{\"nomeDoProfessor\":\"Vitor\",\"horarioDeAtendimento\":\"Quinta - 13:30 - 15:00\",\"periodo\":\"Integral\",\"sala\":15,\"predio\":4}";

        assertNotEquals(expectedJson, atendimento);
    }

    @Test
    public void testeAtualizaHorarioDeAtendimento(){
        Mockito.when(service.buscaAtendimento("Chris")).thenReturn("{\"nomeDoProfessor\":\"Chris\",\"horarioDeAtendimento\":\"Sexta - 19:30 - 21:10\",\"periodo\":\"Noturno\",\"sala\":3,\"predio\":1}");
        String atendimento = this.atendimento.buscaAtendimento("Chris");
        String expectedJson = "{\"nomeDoProfessor\":\"Chris\",\"horarioDeAtendimento\":\"Sexta - 19:30 - 21:10\",\"periodo\":\"Noturno\",\"sala\":3,\"predio\":1}";
        assertEquals(expectedJson, atendimento);

        Mockito.when(service.atualizaHorarioAtendimento("Chris", "Quinta - 08:00 - 09:40")).thenReturn("{\"nomeDoProfessor\":\"Chris\",\"horarioDeAtendimento\":\"Quinta - 08:00 - 09:40\",\"periodo\":\"Noturno\",\"sala\":3,\"predio\":1}");
        String atendimentoAtualizado = this.atendimento.atualizaAtendimento("Chris", "Quinta - 08:00 - 09:40");
        String expectedJsonAtualizado = "{\"nomeDoProfessor\":\"Chris\",\"horarioDeAtendimento\":\"Quinta - 08:00 - 09:40\",\"periodo\":\"Noturno\",\"sala\":3,\"predio\":1}";
        assertEquals(expectedJsonAtualizado, atendimentoAtualizado);
    }

    @Test
    public void testeAtualizaHorarioDeAtendimentoProfessorInexistente(){
        Mockito.when(service.atualizaHorarioAtendimento("Phyllipe", "Quinta - 08:00 - 09:40")).thenReturn(null);
        String atendimentoAtualizado = this.atendimento.atualizaAtendimento("Phyllipe", "Quinta - 08:00 - 09:40");
        assertNull(atendimentoAtualizado);
    }

    @Test
    public void testeDeletaUmAtendimento(){
        Mockito.when(service.deletaAtendimento("Chris")).thenReturn(true);
        boolean deleteVerify = this.atendimento.deletaAtendimento("Chris");
        assertTrue(deleteVerify);
    }

}