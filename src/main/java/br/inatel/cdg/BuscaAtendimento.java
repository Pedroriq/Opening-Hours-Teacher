package br.inatel.cdg;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class BuscaAtendimento {

    AtendimentoService atendimentoService;

    public BuscaAtendimento(AtendimentoService service){
        this.atendimentoService = service;
    }

    public Atendimento buscaAtendimento(String nomeDoProfessor){
        Atendimento atendimento = atendimentoService.buscaAtendimentos(nomeDoProfessor);
        return atendimento;

        /* 
        JsonObject jsonObject = JsonParser.parseString(atendimentoJson).getAsJsonObject();

        return new Atendimento(jsonObject.get("nomeDoProfessor").getAsString(),
                jsonObject.get("horarioDeAtendimento").getAsString(),
                jsonObject.get("periodo").getAsString(),
                jsonObject.get("sala").getAsString(),
                jsonObject.get("predio").getAsJsonArray());
        */
    }
}
