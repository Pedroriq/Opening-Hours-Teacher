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
    public void testeBuscaAtendimento(){
        Mockito.when(service.buscaAtendimento("Chris")).thenReturn(AtendimentoConst.CHRIS);

        String atendimento = this.atendimento.buscaAtendimento("Chris");
        String expectedJson = "{\"nomeDoProfessor\":\"Chris\",\"horarioDeAtendimento\":\"Sexta - 19:30 - 21:10\",\"periodo\":\"Noturno\",\"sala\":3,\"predio\":1}";
        
        assertEquals(expectedJson, atendimento);
    }
}