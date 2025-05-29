# Calculadora de Derivadas e Integrais

Projeto desenvolvido por Cristiano Alves, Arthur Ferreira e Gustavo Lima. [cite: 1, 28]

## 📜 Descrição

Esta é uma calculadora desenvolvida em **Java** que utiliza a biblioteca **Symja (Matheclipse)** para realizar a manipulação simbólica de expressões matemáticas. [cite: 1, 28] O principal objetivo da aplicação é permitir o cálculo automático de:

* Derivadas de primeira ordem [cite: 2, 29]
* Derivadas de segunda ordem [cite: 2, 29]
* Integrais indefinidas [cite: 2, 29]
* Integrais definidas [cite: 2, 29]

O sistema foi projetado para processar a entrada do usuário, garantindo que a sintaxe da expressão matemática esteja correta. [cite: 3, 30] Em seguida, ele utiliza o método `evaluate` da biblioteca Symja para efetuar o cálculo. [cite: 3, 30] Por fim, o resultado é formatado para ser exibido de forma clara ao usuário. [cite: 4, 31]

## ✨ Funcionalidades Principais

* **Cálculo de Derivadas:**
    * Calcula a derivada de primeira ordem de uma função em relação a `x`.
    * Calcula a derivada de segunda ordem de uma função em relação a `x`.
* **Cálculo de Integrais:**
    * Calcula a integral indefinida de uma função em relação a `x` (adicionando a constante de integração `+ C`).
    * Calcula a integral definida de uma função em relação a `x`, dados os limites inferior (`a`) e superior (`b`).
* **Formatação de Expressões:**
    * As expressões resultantes são formatadas para melhor legibilidade. [cite: 4, 31] Por exemplo, `Pi` é convertido para o símbolo `π`. [cite: 8, 35]
    * Operadores como `**` são convertidos para `^` para representar potência. [cite: 14, 41]
* **Tratamento de Erros:**
    * O sistema informa ao usuário caso a função de entrada esteja vazia. [cite: 15, 42]
    * Em caso de erros durante o cálculo (ex: sintaxe incorreta), uma mensagem de erro é exibida, orientando o usuário a verificar a função e os limites fornecidos. [cite: 18, 21, 26, 45, 48, 53]

## ⚙️ Tecnologias Utilizadas

* **Java:** Linguagem de programação principal do projeto.
* **Symja (Matheclipse):** Biblioteca Java para matemática simbólica, utilizada para:
    * Avaliar expressões (`ExprEvaluator`). [cite: 16, 19]
    * Formatar a saída das expressões (`OutputFormFactory`). [cite: 5, 6, 32, 33]

## 🚀 Como Usar (Exemplo da Lógica Interna)

O código possui métodos estáticos para cada operação:

* `CalculadoraMatematica.derivar(String funcao)`
* `CalculadoraMatematica.derivarSegundaOrdem(String funcao)`
* `CalculadoraMatematica.integralIndefinida(String funcao)`
* `CalculadoraMatematica.integralDefinida(String funcao, String a, String b)`

**Exemplo de chamada interna para derivada:**
```java
// Para calcular a derivada de "x^2 + 2x"
String resultado = CalculadoraMatematica.derivar("x^2 + 2*x");
// Saída esperada (formatada):
// Derivada de: x^2 + 2*x
// Resultado: 2*x + 2
