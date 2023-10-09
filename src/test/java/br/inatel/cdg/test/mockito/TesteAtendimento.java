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

import static org.junit.Assert.assertEquals;

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
}