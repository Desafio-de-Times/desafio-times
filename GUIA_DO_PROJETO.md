# Guia do Projeto: Backlog de Jogos

Este documento e um roteiro de construcao do sistema. A ideia e voce saber o que construir, em qual ordem e por que cada parte existe.

## 1. Objetivo do sistema

Construir um sistema simples de terminal para gerenciar backlog de jogos.

O sistema deve permitir:

- cadastrar ate 3 usuarios;
- cada usuario deve ter sua propria biblioteca;
- cada biblioteca pode guardar ate 3 jogos;
- adicionar jogo na biblioteca de um usuario;
- atualizar dados de um jogo;
- remover jogo;
- mostrar um resumo final do sistema.

Regra importante deste momento do projeto: nao usar array.

Por isso, o programa vai trabalhar com variaveis fixas:

```java
Usuario usuario1 = null;
Usuario usuario2 = null;
Usuario usuario3 = null;

Biblioteca biblioteca1 = null;
Biblioteca biblioteca2 = null;
Biblioteca biblioteca3 = null;
```

A relacao entre eles deve ser:

```text
usuario1 -> biblioteca1
usuario2 -> biblioteca2
usuario3 -> biblioteca3
```

## 2. Classes do projeto

### Usuario

Representa uma pessoa que usa o sistema.

Deve guardar:

- nome;
- jogo favorito;
- historico.

Responsabilidades:

- guardar dados do usuario;
- devolver o nome com `getNome()`;
- permitir alterar jogo favorito e historico;
- mostrar os dados no `toString()`.

O Usuario nao deve cadastrar jogos diretamente. Quem guarda jogo e a Biblioteca.

### Jogo

Representa um jogo.

Deve guardar:

- id;
- nome;
- desenvolvedora;
- preco.

Responsabilidades:

- guardar os dados do jogo;
- permitir consultar e alterar nome, desenvolvedora e preco;
- mostrar os dados no `toString()`.

### Biblioteca

Representa a biblioteca de um usuario.

Deve guardar:

- nome da biblioteca;
- jogo1;
- jogo2;
- jogo3.

Responsabilidades:

- cadastrar jogo no primeiro espaco vazio;
- mostrar os tres jogos;
- atualizar um jogo escolhido;
- remover um jogo escolhido;
- devolver o nome da biblioteca.

A Biblioteca nao precisa ter `usuario1`, `usuario2` ou `usuario3` dentro dela. A relacao usuario-biblioteca ja fica na `Main`.

## 3. Papel da Main

A `Main` deve ser o controle do programa.

Ela deve:

- criar o `Scanner`;
- guardar `usuario1`, `usuario2`, `usuario3`;
- guardar `biblioteca1`, `biblioteca2`, `biblioteca3`;
- mostrar o menu principal;
- chamar metodos para cada opcao.

A `Main` nao deveria fazer tudo dentro do `while`. O ideal e o menu chamar metodos:

```java
if (opcao == 1) {
    // cadastrar usuario
} else if (opcao == 2) {
    // adicionar jogo
} else if (opcao == 3) {
    // atualizar jogo
} else if (opcao == 4) {
    // remover jogo
} else if (opcao == 5) {
    // mostrar review
}
```

Depois, cada bloco pode virar um metodo.

## 4. Menu principal sugerido

```text
Bem-vindo ao Backlog de Jogos
1) Criar novo usuario
2) Adicionar novo jogo ao backlog
3) Atualizar jogo
4) Remover jogo
5) Mostrar usuarios e bibliotecas
6) Sair
```

Evite repetir numero no menu. Cada opcao precisa ter um numero unico.

## 5. Ordem recomendada de construcao

### Passo 1: Fazer o cadastro de usuario funcionar

Antes de cadastrar jogo, atualizar ou remover, garanta que isto funciona:

```text
1. Usuario escolhe a opcao "Criar novo usuario"
2. Programa mostra os tres espacos
3. Usuario escolhe 1, 2 ou 3
4. Programa pergunta o nome
5. Programa cria o Usuario
6. Programa pergunta o nome da biblioteca
7. Programa cria a Biblioteca correspondente
8. Ao mostrar usuarios, o usuario nao pode mais aparecer como null
```

Conceito importante:

Se um metodo cria um usuario, ele deve devolver esse usuario.

Exemplo de uso:

```java
usuario1 = cadastrarUsuario(in, usuario1);
```

Nao basta fazer:

```java
cadastrarUsuario(in, usuario1);
```

Porque nesse caso o `usuario1` da `Main` continua `null`.

### Passo 2: Fazer cada usuario ter sua biblioteca

Quando cadastrar no espaco 1:

```java
usuario1 = cadastrarUsuario(in, usuario1);
biblioteca1 = cadastrarBiblioteca(in, biblioteca1);
```

Quando cadastrar no espaco 2:

```java
usuario2 = cadastrarUsuario(in, usuario2);
biblioteca2 = cadastrarBiblioteca(in, biblioteca2);
```

Quando cadastrar no espaco 3:

```java
usuario3 = cadastrarUsuario(in, usuario3);
biblioteca3 = cadastrarBiblioteca(in, biblioteca3);
```

### Passo 3: Adicionar jogo

Fluxo esperado:

```text
1. Usuario escolhe "Adicionar novo jogo"
2. Programa mostra usuario1, usuario2, usuario3
3. Usuario escolhe em qual biblioteca adicionar
4. Programa pede nome do jogo
5. Programa cria o Jogo
6. Programa chama cadastrarJogo na biblioteca correta
```

Exemplo conceitual:

```java
if (escolherUsuario == 1 && usuario1 != null) {
    Jogo jogo = criarJogo(in);
    biblioteca1.cadastrarJogo(jogo);
}
```

### Passo 4: Mostrar jogos da biblioteca

Crie um metodo simples:

```java
mostrarJogos(biblioteca1);
```

Esse metodo deve imprimir:

```text
1) jogo1
2) jogo2
3) jogo3
```

### Passo 5: Atualizar jogo

Fluxo esperado:

```text
1. Escolher usuario
2. Mostrar jogos da biblioteca desse usuario
3. Escolher jogo 1, 2 ou 3
4. Digitar novos dados
5. Substituir o jogo antigo pelo novo
```

Para isso, a Biblioteca pode ter um metodo como:

```java
public void atualizarJogo(int opcao, Jogo jogoNovo)
```

### Passo 6: Remover jogo

Fluxo esperado:

```text
1. Escolher usuario
2. Mostrar jogos da biblioteca desse usuario
3. Escolher jogo 1, 2 ou 3
4. Colocar aquele jogo como null
```

Para isso, a Biblioteca pode ter um metodo como:

```java
public void removerJogo(int opcao)
```

## 6. Cuidados importantes com Scanner

Quando usar:

```java
int opcao = in.nextInt();
```

logo depois use:

```java
in.nextLine();
```

Isso limpa o Enter que ficou pendente.

Mas nao coloque `in.nextLine()` sem necessidade depois de toda leitura. Isso pode fazer o programa pular perguntas ou ficar esperando entrada extra.

Padrao recomendado:

```java
int opcao = in.nextInt();
in.nextLine();

String nome = in.nextLine();
```

## 7. Erros comuns que voce deve evitar

### Criar objeto dentro do metodo e nao devolver

Errado:

```java
private static void cadastrarUsuario(Scanner in, Usuario usuarioAtual) {
    usuarioAtual = new Usuario("Ana");
}
```

Isso nao muda `usuario1` na `Main`.

Certo:

```java
private static Usuario cadastrarUsuario(Scanner in, Usuario usuarioAtual) {
    usuarioAtual = new Usuario("Ana");
    return usuarioAtual;
}
```

E na `Main`:

```java
usuario1 = cadastrarUsuario(in, usuario1);
```

### Fazer getter static para dado que pertence ao objeto

Se cada biblioteca tem um nome diferente, o metodo nao deve ser static.

Preferivel:

```java
public String getNomeBiblioteca() {
    return nomeBiblioteca;
}
```

Uso:

```java
System.out.println(biblioteca1.getNomeBiblioteca());
```

## 8. Roteiro de teste manual

Depois de implementar, teste nesta ordem:

```text
1. Rodar o programa
2. Criar usuario no espaco 1
3. Mostrar usuarios e confirmar que usuario1 nao e null
4. Criar usuario no espaco 2
5. Adicionar jogo para usuario1
6. Adicionar jogo para usuario2
7. Confirmar que os jogos ficaram em bibliotecas diferentes
8. Atualizar um jogo do usuario1
9. Remover um jogo do usuario2
10. Sair do programa
```

Se o passo 3 nao funcionar, nao continue para jogos ainda. Primeiro corrija cadastro de usuario.

## 9. Meta final

O projeto estara bom para esta fase quando voce conseguir demonstrar:

```text
Tenho tres usuarios possiveis.
Cada usuario tem sua propria biblioteca.
Cada biblioteca guarda ate tres jogos.
Consigo adicionar, atualizar, remover e listar jogos.
O programa nao usa array.
```

Essa e a versao que voce deve buscar antes de pensar em melhorias maiores.
