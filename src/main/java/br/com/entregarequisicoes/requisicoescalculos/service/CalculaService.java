package br.com.entregarequisicoes.requisicoescalculos.service;

import br.com.entregarequisicoes.requisicoescalculos.dto.CalculoDTO;
import br.com.entregarequisicoes.requisicoescalculos.dto.EntradaDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class CalculaService {

    public CalculoDTO calcular (EntradaDTO entradaDTO){

        if (entradaDTO.getNumeros().size() < 20){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }else {
            CalculoDTO calculoDTO = new CalculoDTO();
            calculoDTO.setQtdNumeros(entradaDTO.getNumeros().size());

            calculoDTO.setMedia(this.media(entradaDTO));
            calculoDTO.setMediana(this.mediana(entradaDTO));
            calculoDTO.setDesvioPadrao(this.desvioPadrao(entradaDTO));

            return calculoDTO;
        }
    }

    public double media (EntradaDTO entradaDTO){

        int soma = 0;

        for (int i = 0; i<entradaDTO.getNumeros().size(); i++){
            soma += entradaDTO.getNumeros().get(i);
        }

        return soma / entradaDTO.getNumeros().size();
    }

    public double somatotal(EntradaDTO entradaDTO){
        int soma = 0;

        for (int i = 0; i<entradaDTO.getNumeros().size(); i++){
            soma += entradaDTO.getNumeros().get(i);
        }

        return soma;
    }

    public double maiorNumero(EntradaDTO entradaDTO){
        int maiorNum = entradaDTO.getNumeros().get(0);

        for (int num: entradaDTO.getNumeros()){
            if (num > maiorNum) {
                maiorNum = num;
            }
        }
        return maiorNum;
    }

    public double menorNumero(EntradaDTO entradaDTO){
        int menorNum = entradaDTO.getNumeros().get(0);

        for (int num: entradaDTO.getNumeros()){
            if (num < menorNum){
                menorNum = num;
            }
        }
        return menorNum;
    }

    public double mediana (EntradaDTO entradaDTO){

        List<Integer> numerosOrdenaveis = new ArrayList<>(entradaDTO.getNumeros());
        Collections.sort(numerosOrdenaveis);

        if (entradaDTO.getNumeros().size() % 2 == 0) {
            int posicaoDir = entradaDTO.getNumeros().size() / 2;
            int posicaoEsq = posicaoDir - 1;
            double medianaEsq = entradaDTO.getNumeros().get(posicaoEsq);
            double medianaDir = entradaDTO.getNumeros().get(posicaoDir);
            return (medianaEsq + medianaDir) / 2;
        }else{
            double result = entradaDTO.getNumeros().size() / 2;


            int posicao = entradaDTO.getNumeros().size() / 2;
            return entradaDTO.getNumeros().get(posicao);
        }
    }

    public double desvioPadrao (EntradaDTO entradaDTO){

        double soma = 0;

        for (int i = 0; i<entradaDTO.getNumeros().size(); i++){
            double aux = (entradaDTO.getNumeros().get(i) - this.media(entradaDTO));
            double resultado = aux * aux;
            soma += resultado;
        }

        double result = soma/entradaDTO.getNumeros().size();

        return Math.sqrt(result);
    }
}
