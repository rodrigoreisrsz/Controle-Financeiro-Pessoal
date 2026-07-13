# Gerenciador de Registros (Java CLI)

Aplicação de linha de comando em Java para cadastrar, listar e remover registros financeiros simples (nome, valor, data e descrição), com persistência em arquivo JSON usando Gson.

## ✨ Funcionalidades

- **Listar registros** — exibe todos os registros salvos
- **Criar registro** — cadastra nome, valor, data e descrição
- **Deletar registro** — remove um registro pelo ID
- **Persistência automática** — os dados são salvos em `registros.json` a cada alteração, e recarregados automaticamente ao iniciar o programa

## 🛠️ Tecnologias

- Java (Scanner para entrada via terminal)
- [Gson](https://github.com/google/gson) — serialização/desserialização JSON
- Arquitetura em camadas: `manager` (regras de negócio) e `repository` (persistência)

## 📁 Estrutura do projeto

```
src/
├── main/
│   └── Main.java              # Ponto de entrada e menu interativo
├── manager/
│   ├── Menu.java              # Exibição do menu no terminal
│   ├── RegistroManager.java   # Regras de negócio (criar, listar, deletar)
│   └── Registros.java         # Modelo de domínio (entidade Registro)
└── repository/
    └── Repository.java        # Leitura e escrita em registros.json
```

## ▶️ Como executar

1. Certifique-se de ter o **JDK** instalado (11+) e a dependência **Gson** no classpath (via Maven/Gradle ou o `.jar` baixado manualmente).
2. Compile e execute a classe `main.Main`.
3. Use o menu interativo para escolher uma opção:

```
1 - Listar registros
2 - Criar registro
3 - Deletar registro
0 - Sair
```

Os dados ficam salvos automaticamente em `registros.json`, na raiz do projeto.

## 🧾 Exemplo de registro salvo (JSON)

```json
[
  {
    "id": 1,
    "nome": "Aluguel",
    "valor": 850.0,
    "descricao": "Pagamento mensal",
    "data": "2026-07-01"
  }
]
```

## 🚧 Pontos conhecidos para melhoria

Este projeto está em desenvolvimento como parte de um estudo de Java/POO. Alguns pontos já identificados para uma próxima iteração:

- A ordem dos parâmetros em `criarRegistro(nome, valor, descricao, data)` está diferente da ordem em que o construtor de `Registros(nome, valor, data, descricao)` espera — isso troca os valores de `data` e `descricao` ao salvar.
- O `case 3` (deletar) no `Main` não tem `break`, o que faz o fluxo "cair" para o `case 0` e encerrar o programa.
- `Repository.carregarRegistros()` pode lançar `NullPointerException` se o arquivo `registros.json` não existir ainda na primeira execução.
- Poderia ser adicionado tratamento de exceções para entradas inválidas do usuário (ex.: `input.nextInt()` com texto).
- Um método de soma total dos valores (`total()`) já está esboçado, comentado, no `RegistroManager` — pode ser finalizado como próxima funcionalidade.

## 🎯 Próximos passos sugeridos

- [ ] Corrigir a ordem dos parâmetros de `criarRegistro`
- [x] Adicionar `break` no `case 3`
- [x] Tratar arquivo inexistente na primeira execução
- [ ] Implementar validação de entrada no menu
- [x] Finalizar o método de soma total dos registros
- [ ] Adicionar testes unitários para `RegistroManager`

---

Projeto desenvolvido como parte de estudos de Java, Programação Orientada a Objetos e persistência de dados.