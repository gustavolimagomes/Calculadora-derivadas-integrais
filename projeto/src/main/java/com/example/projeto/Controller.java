package com.example.projeto;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {

    @FXML private TextField inputFunctionField; // Campo para o usuário inserir a função
    @FXML private TextField lowerLimitField;    // Campo para o limite inferior da integral definida
    @FXML private TextField upperLimitField;    // Campo para o limite superior da integral definida
    @FXML private TextArea resultArea;         // Área para exibir os resultados dos cálculos


     // Aciona quando o botão de Derivar é clicado.
     // Calcula e exibe a primeira e a segunda derivada da função fornecida.

    @FXML
    protected void onDerivar() {
        String func = inputFunctionField.getText();

        // Validação básica da entrada da função
        if (func == null || func.trim().isEmpty()) {
            resultArea.setText("Erro: Por favor, insira uma função no campo 'Função:'.");
            return;
        }

        // Calcula a primeira derivada
        String resultadoPrimeiraDerivada = CalculadoraMatematica.derivar(func);

        // Se o cálculo da primeira derivada resultou em erro, exibe o erro e não prossegue.
        if (resultadoPrimeiraDerivada.startsWith("Erro:")) {
            resultArea.setText(resultadoPrimeiraDerivada);
            return;
        }

        // Calcula a segunda derivada
        String resultadoSegundaDerivada = CalculadoraMatematica.derivarSegundaOrdem(func);

        // Concatena os resultados da primeira e segunda derivadas para exibição.
        resultArea.setText(resultadoPrimeiraDerivada + "\n\n" + resultadoSegundaDerivada);
    }


     //Método acionado quando o botão "Integral Indefinida" é clicado.
     // Calcula e exibe a integral indefinida da função fornecida.

    @FXML
    protected void onIntegralIndefinida() {
        String func = inputFunctionField.getText();

        if (func == null || func.trim().isEmpty()) {
            resultArea.setText("Erro: Por favor, insira uma função no campo 'Função:'.");
            return;
        }
        // Integral indefinida não utiliza os campos de limite.
        String resultado = CalculadoraMatematica.integralIndefinida(func);
        resultArea.setText(resultado);
    }

    /**
     * Método acionado quando o botão "Integral Definida" é clicado.
     * Calcula e exibe a integral definida da função fornecida, utilizando os limites informados.
     */
    @FXML
    protected void onIntegralDefinida() {
        String func = inputFunctionField.getText();
        String a = lowerLimitField.getText(); // Pega o limite inferior do campo correspondente
        String b = upperLimitField.getText(); // Pega o limite superior do campo correspondente

        if (func == null || func.trim().isEmpty()) {
            resultArea.setText("Erro: Por favor, insira uma função no campo 'Função:'.");
            return;
        }
        if (a == null || a.trim().isEmpty() || b == null || b.trim().isEmpty()) {
            resultArea.setText("Erro: Por favor, insira os limites inferior (a) e superior (b) para a integral definida.");
            return;
        }

        String resultado = CalculadoraMatematica.integralDefinida(func, a, b);
        resultArea.setText(resultado);
    }
}
