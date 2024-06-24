package com.IgorAntonio22.service;

import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;
import org.springframework.stereotype.Service;

@Service
public class ConsultaChatGPT {

    public static String obterDadosSobreUmArtista(String nomeDoArtista) {
        OpenAiService service = new OpenAiService("cole aqui sua chave");


        CompletionRequest requisicao = CompletionRequest.builder()
                .model("gpt-3.5-turbo-instruct")
                .prompt("Dados do artista:" + nomeDoArtista)
                .maxTokens(1000)
                .temperature(0.7)
                .build();


        var resposta = service.createCompletion(requisicao);
        return resposta.getChoices().get(0).getText();
    }
}
