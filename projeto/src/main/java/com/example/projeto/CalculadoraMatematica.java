package com.example.projeto;

import org.matheclipse.core.eval.ExprEvaluator;
import org.matheclipse.core.interfaces.IExpr;
import org.matheclipse.core.form.output.OutputFormFactory;
import java.io.StringWriter;

public class CalculadoraMatematica {

    private static final ExprEvaluator avaliadorDeExpressoes = new ExprEvaluator();
    private static final OutputFormFactory formatadorTradicional = OutputFormFactory.get(true);

    private static String formatarExpressao(IExpr expressaoMat) {
        // Esta função pega uma expressão matemática (IExpr) e tenta deixar mais legível
        // Primeiro tenta converter direto para texto. Se não der ou ficar estranho
        // usa um formatador mais tradicional. No final, sempre tenta melhorar alguns símbolos (tipo Pi vira π). Se der ruim em tudo,
        // devolve a expressão original como texto pra não quebrar o código
        if (expressaoMat == null) {
            return "";
        }
        try {
            String formaPadrao = expressaoMat.toString();
            if (formaPadrao != null && !formaPadrao.trim().isEmpty()) {
                return formatarExpressaoMatematica(formaPadrao);
            }
            StringWriter bufferSaida = new StringWriter();
            formatadorTradicional.convert(bufferSaida, expressaoMat);
            String formaTradicional = bufferSaida.toString();
            return formatarExpressaoMatematica(formaTradicional);
        } catch (Exception e) {
            return expressaoMat.toString(); // se der erro vai mostrar o básico.
        }
    }

    private static String formatarExpressaoMatematica(String expressao) {
        if (expressao == null || expressao.trim().isEmpty()) {
            return expressao;
        }
        String formatada = expressao.trim();
        formatada = formatada.replace("**", "^");
        formatada = formatada.replace("Pi", "π");

        return formatada;
    }

    public static String derivar(String funcao) {
        if (funcao == null || funcao.trim().isEmpty()) {
            return "Erro: A função para derivar não pode estar vazia.";
        }

        String funcaoOriginalParaExibicao = funcao;

        try {
            IExpr expressaoDerivada = avaliadorDeExpressoes.evaluate("D(" + funcao + ", x)");
            String resultadoFormatado = formatarExpressao(expressaoDerivada);

            return "Derivada de: " + funcaoOriginalParaExibicao + "\n" +
                    "Resultado: " + resultadoFormatado;
        } catch (Exception e) {
            return "Erro ao calcular a derivada: " + e.getMessage() +
                    "\nFunção: " + funcaoOriginalParaExibicao +
                    "\nVerifique a sintaxe da função (ex: use '*' para multiplicação, '^' para potência).";
        }
    }

    public static String derivarSegundaOrdem(String funcao) {
        if (funcao == null || funcao.trim().isEmpty()) {
            return "Erro: A função para derivar (segunda ordem) não pode estar vazia.";
        }
        String funcaoOriginalParaExibicao = funcao;

        try {
            IExpr expressaoDerivadaSegunda = avaliadorDeExpressoes.evaluate("D(" + funcao + ", {x, 2})");
            String resultadoFormatado = formatarExpressao(expressaoDerivadaSegunda);
            return "A derivada de segunda ordem de: " + funcaoOriginalParaExibicao + "\nResultado: " + resultadoFormatado;
        } catch (Exception e) {
            return "Erro ao calcular a derivada de segunda ordem: " + e.getMessage() +
                    "\nFunção: " + funcaoOriginalParaExibicao +
                    "\nVerifique a sintaxe da função.";
        }
    }

    public static String integralIndefinida(String funcao) {
        if (funcao == null || funcao.trim().isEmpty()) {
            return "Erro: A função para integrar não pode estar vazia.";
        }
        String funcaoOriginalParaExibicao = funcao;

        try {
            IExpr expressaoIntegral = avaliadorDeExpressoes.evaluate("Integrate(" + funcao + ", x)");
            String resultadoFormatado = formatarExpressao(expressaoIntegral);
            return "A integral indefinida de: " + funcaoOriginalParaExibicao + "\nResultado: " + resultadoFormatado + " + C";
        } catch (Exception e) {
            return "Erro ao calcular a integral indefinida: " + e.getMessage() +
                    "\nFunção: " + funcaoOriginalParaExibicao +
                    "\nVerifique a sintaxe da função.";
        }
    }

    public static String integralDefinida(String funcao, String a, String b) {
        if (funcao == null || funcao.trim().isEmpty()) {
            return "Erro: A função para integrar não pode estar vazia.";
        }
        if (a == null || a.trim().isEmpty() || b == null || b.trim().isEmpty()) {
            return "Erro: Os limites de integração (a e b) devem ser fornecidos para a integral definida.";
        }
        String funcaoOriginalParaExibicao = funcao;

        try {
            IExpr expressaoIntegral = avaliadorDeExpressoes.evaluate("Integrate(" + funcao + ", {x, " + a + ", " + b + "})");
            String resultadoFormatado = formatarExpressao(expressaoIntegral);
            return "A integral definida de: " + funcaoOriginalParaExibicao + " (de x=" + a + " a x=" + b + ")\nResultado: " + resultadoFormatado;
        } catch (Exception e) {
            return "Erro ao calcular a integral definida: " + e.getMessage() +
                    "\nFunção: " + funcaoOriginalParaExibicao + ", Limites: a=" + a + ", b=" + b +
                    "\nVerifique a sintaxe da função e os limites.";
        }
    }
}