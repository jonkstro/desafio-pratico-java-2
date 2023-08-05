
### Exercício Avançado para a Prova de Conhecimentos Aplicados

Contexto:

Uma empresa financeira deseja desenvolver um sistema de gerenciamento de transações. Esse sistema será responsável por registrar, listar e analisar transações financeiras realizadas por seus clientes em diferentes modalidades e moedas.

Requisitos:

O sistema deve permitir a inserção de uma nova transação financeira com os seguintes dados: cliente, valor, moeda (USD, EUR, BRL, etc.) e tipo de transação (Depósito, Retirada, Transferência).
Deve ser possível filtrar e listar transações por cliente e/ou tipo de transação.
O sistema deve calcular a taxa de câmbio para transações em moedas estrangeiras.
Deve ser possível calcular o saldo total de um cliente em sua moeda local.
Implementar um mecanismo de detecção de transações suspeitas. Uma transação é considerada suspeita se um cliente realiza três ou mais retiradas num período de 24 horas.

**Questão 1:** Desenvolva uma classe Transacao que represente uma transação financeira, considerando os atributos e métodos necessários para atender aos requisitos acima.

**Questão 2:** Desenvolva uma funcionalidade que permita filtrar e listar transações por cliente e/ou tipo de transação, usando estruturas de dados eficientes para filtragem e ordenação.

**Questão 3:** Implemente uma classe ConversorMoeda que use uma API externa (ou uma simulação de uma) para pegar as taxas de câmbio atualizadas e realize a conversão entre diferentes moedas.

**Questão 4:** No sistema, crie uma funcionalidade que, ao consultar o saldo total de um cliente, faça a conversão de todas as suas transações para sua moeda local, considerando as taxas de câmbio do dia.

**Questão 5:** Implemente a detecção de transações suspeitas. Crie testes unitários para validar essa funcionalidade.

**Questão 6:** O código a seguir é parte do sistema de transações. Identifique possíveis falhas de performance, vulnerabilidades ou erros e corrija-os, detalhando cada problema encontrado e sua solução:


	public class Transacao {
	    public String cliente;
	    public double valor;
	    public String moeda;
	    public String tipo;
	    
	    public List<Transacao> todasTransacoes = new ArrayList<>();

	    public void adicionarTransacao(Transacao t) {
	        todasTransacoes.add(t);
	    }
	    
	    public double getSaldo(String cliente) {
	        double saldo = 0.0;
	        for (Transacao t : todasTransacoes) {
	            if (t.cliente.equals(cliente)) {
	                saldo += t.valor;
	            }
	        }
	        return saldo;
	    }
	}
**Questão 7:** Suponha que o sistema tenha que lidar com milhões de transações diariamente. Propor e justificar otimizações no design do sistema e/ou no uso de tecnologias específicas para garantir eficiência e escalabilidade.

Instruções:

Utilize a linguagem Java para o desenvolvimento da solução.
Atenção às práticas de programação segura, principalmente ao lidar com informações financeiras.
Avalie a saída do software e garanta a correta execução do software a partir dos requisitos descritos.
Boa sorte!

