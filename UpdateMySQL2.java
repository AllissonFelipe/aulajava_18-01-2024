// Importação de todos os itens da biblioteca SQL
import java.sql.*; 
// Importação de todos os itens da biblioteca UTIL
import java.util.*;
// Declaração da Classe/Objeto UpdateMySQL2
public class UpdateMySQL2 { // inicia class UpdateMySQL2
    
    /* 
     * Declação do metodo Executor main.
     * Public : Pode ser Invocado por outras Classes/Objetos.
     * Static : Não pode ser alterado ou sobrescritos.
     * Void : Um metodo sem retorno.
     * Strings[] : Pode ser invocados métodos do tipo String e Matrizes[].
     * args : porque podera ser invocado o objeto args da biblioteca java.lang
    */ 
    public static void main(String[] args) { // inicia metodo main
        // variavel scnLogin recebendo o scanner onde pode receber inputs do usuario.
        Scanner scnLogin = new Scanner(System.in);
        // variavel scnSenha recebendo o scanner onde pode receber inputs do usuario.
        Scanner scnSenha = new Scanner(System.in);
        // variavel scnResp recebendo o scanner onde pode receber inputs do usuario.
        Scanner scnResp = new Scanner(System.in);
        // variavel scnCadastroUpdate recebendo o scanner onde pode receber inputs do usuario.
        Scanner scnCadastroUpdate = new Scanner(System.in);
        // variaveis tipo string.
        String strLogin, strSenha, status = "Nada aconteceu ainda...", resp;
        // variaveis do tipo boleano, recebendo o valor falso.
        boolean update = false, validLogin = false;
        // variaveis do tipo string, recebendo valores vazios.
        String novoNome = "", novaSenha = "";
        // comando onde o bloco de comandos pode gerar uma exceção. 
        try { // inicia try
            // laço de repetição [Enquanto] que ira ocorrer enquanto a variavel for falsa.
            while (validLogin == false) { // inicia while
                // comando que ira envocar a conexão com o banco de dados. Invocando o Objeto App e executando o metodo Conectar.
                Connection conn = App.conectar();
                // Comando para imprimir uma pergunta ao usuario.
                System.out.println("\nDigite seu login: ");
                // variavel recebendo o input do usuario do tipo string.
                strLogin = scnLogin.nextLine();
                // Comando para imprimir uma pergunta ao usuario.
                System.out.println("Digite sua senha: ");
                // variavel recebendo o input do usuario do tipo string.
                strSenha = scnSenha.nextLine();
                // variavel recebendo o comando para selecionar no MySQL o login e a senha no banco de dados 'mysql_connector', na tabela 'tbl_login'
                String strSqlSelect = "select * from `mysql_connector`.`tbl_login` where `login` = '" + strLogin + "' and `senha` = '" + strSenha + "';";
                // variavel para realizar uma declaração que esta conectada no banco de dados.
                Statement stmSql = conn.createStatement();
                // variavel que ira executar a declaração com o valor da String strSqlSelect.
                ResultSet rsSql = stmSql.executeQuery(strSqlSelect);
                // variavel String login recebendo o valor vazio.
                String login = "";
                // variavel String senha recebendo o valor vazio.
                String senha = "";
                // laço de repetição que ira fazer as variaveis login e senha receber valores do banco de dados. So ira receber esses valores enquanto existir no MySQL    
                while (rsSql.next()) { // inicia while
                    // variavel tipo string que ira receber os dados no MySQL enquanto existir.    
                    login = "[" + rsSql.getString("login") + "] ";
                    // variavel tipo string que ira receber os dados no MySQL enquanto existir. 
                    senha = "[" + rsSql.getString("senha") + "] ";
                    } // encerra [while]
                    // condição que ira verificar se os dados existem no MySQL. Dando verdadeiro esses dados não esta presente no banco de dados. E ira retornar no primeiro laço de repetição.
                    if (login == "" || senha == "") { // inicia [if]
                        // variavel tipo string recebendo Login Invalido! Tente Novamente
                        status = "\nLogin Invalido! Tente Novamente.";
                        // comando para imprimir para o usuario o status que recebeu os valores acima
                        System.out.println(status);
                    } // encerra [if]   
                    // condição que quando da falsa ira mostrar que existem os dados no MySQL e ira realizar o login no programa.
                        else { // inicia [else]
                        // variavel do tipo string que esta recebendo o nome de login e senha que pegou no MySQL
                        status = "Login usado: " + login + "\nSenha usada: " + senha;
                        // Imprimindo para o usuario Bem vindo + o login usado.
                        System.out.println("\nBem vindo " + login);
                        // variavel boleana recebendo true para não realizar o laço de repetição da tela inicial de Login.
                        validLogin = true;
                        // variavel boleana recebendo falso para entrar no proxima laço de repetição, onde esta o menu.
                        update = false;
                        Thread.sleep(1000);
                        // laço de repetição Enquanto a variavel update for falsa ira realizar os comandos do bloco sem parar. Aqui esta presente o Menu.
                        while (update == false) { // inicia [while]
                            // comando para espera 1 segundo para realizar a proxima ação.
                            Thread.sleep(1000);
                            // imprimindo para o usuario que tipo de menu é esse.
                            System.out.println("\n--- Update de cadastro ---");
                            // comando para espera 1 segundo para realizar a proxima ação.
                            Thread.sleep(1000);
                            // imprimindo para o usuario quais opções existem nesse menu.
                            System.out.println("\nDigite [1] para alterar o nome.\nDigite [2] para alterar a senha.\nDigite [3] para sair.");
                            // variavel String para receber a resposta do que o usuario deseja.
                            resp = scnResp.nextLine();
                            // Uma ação que pega a escolha do usuario e a executa.
                            switch (resp) { // inicia [switch]
                                // Opção acionada caso o usuario escolha "1".
                                case "1":
                                    // comando para espera 1 segundo para realizar a proxima ação.
                                    Thread.sleep(1000);
                                    // Imprimindo para o usuario qual o novo nome ele deseja.
                                    System.out.println("Digite o novo nome:");
                                    // variavel String recebendo o input do usuario
                                    novoNome = scnCadastroUpdate.nextLine();
                                    // variavel String recebendo o valor para dar Update no banco de dados
                                    String stmSqlUpdate = "UPDATE `mysql_connector`.`tbl_login` SET `nome` = '" + novoNome + "' WHERE (`login` = '" + strLogin + "')";
                                    // variavel para preperar uma declaração com o valor da variavel acima'stmSqlUpdate' que esta conectada com o banco de dados.
                                    PreparedStatement preparedStm = conn.prepareStatement(stmSqlUpdate);
                                    // Acão que executa a variavel com uma declaração ja atribuida a ela.
                                    preparedStm.executeUpdate();
                                    // comando para espera 1 segundo para realizar a proxima ação.
                                    Thread.sleep(1000);
                                    // Imprimindo para o usuario que o nome ja foi alterado.
                                    System.out.println("\nNome alterado com sucesso para " + "[" + novoNome + "]");
                                // Comando para parar.
                                break;
                                // Comando realizado caso o usuario escolha "2".
                                case "2":
                                    // Comando para esperar 1 segundo para realizar a proxima ação.
                                    Thread.sleep(1000);
                                    // Perguntando ao usuario qual é a senha atual dele.
                                    System.out.println("Digite a senha atual:");
                                    // Comando para receber o Input do usuario em relação a sua senha atual.
                                    String senhaAtual = scnCadastroUpdate.nextLine();
                                            // Condição que ira realizar caso o teste logico é verdadeiro. Se a varivel 'strSenha' é igual a variavel 'senhaAtual' ou Se a variavel 'novaSenha' é igual a variavel 'senhaAtual'.
                                            if (strSenha.equals(senhaAtual) || novaSenha.equals(senhaAtual)) { // inicia [if]
                                            // Comando para esperar 1 segundo para realizar a proxima ação.
                                            Thread.sleep(1000);
                                            // Imprimindo uma pergunta ao usuario em relação a sua nova senha.
                                            System.out.println("Digite a nova senha: ");
                                            // varivel tipo String recebendo o Input do usuario.
                                            novaSenha = scnCadastroUpdate.nextLine();
                                            // Comando para esperar 1 segundo para realizar a proxima ação.
                                            Thread.sleep(1000);
                                            // Imprimindo para o usuario uma pergunta. Perguntando para confirmar uma nova senha.
                                            System.out.println("Confirme a nova senha:");
                                            // variavel tipo String recebendo a resposta do usuario.
                                            String novaSenhaConf = scnCadastroUpdate.nextLine();
                                                // Condição que ira realizar caso o teste logico é verdadeiro. Se a variavel String 'novaSenha' é igual a variavel String 'novaSenhaConf'.
                                                if (novaSenha.equals(novaSenhaConf)) { // inicia [if]
                                                    // Varivel String recebendo o codigo que irar dar Upgrade no banco de dados.
                                                    String stmSqlUpdate2 = "UPDATE `mysql_connector`.`tbl_login` SET `senha` = '" + novaSenha + "' WHERE (`login` = '" + strLogin + "')";
                                                    // variavel para preperar uma declaração com o valor da variavel acima'stmSqlUpdate2' que esta conectada com o banco de dados. 
                                                    PreparedStatement preparedStm2 = conn.prepareStatement(stmSqlUpdate2);
                                                    // Executando o Update preparado acima.
                                                    preparedStm2.executeUpdate();
                                                    // Comando para esperar 1 segundo para realizar a proxima ação.
                                                    Thread.sleep(1000);
                                                    // Imprimindo para o usuario que sua senha foi alterada com sucesso
                                                    System.out.println("\nSenha alterada com sucesso para " + "[" + novaSenha + "]");
                                                    // Comando para esperar 1 segundo para realizar a proxima ação.
                                                    Thread.sleep(1000);
                                                    // Imprimindo para o usuario se ele deseja continuar ou voltar à página inicial.
                                                    System.out.println("Deseja voltar à pagina inicial ou continuar? ['c' para continuar ou 's' para ir à pagina inicial]");
                                                    // Varivel String pegando a resposta do usuario.
                                                    String resp2 = scnCadastroUpdate.nextLine();
                                                        // Condição que ira ser realizada caso o teste logico for verdadeiro. Se a variavel String 'resp2' for igual à "s" ou Se a variavel String 'resp2' é igual à "S".
                                                        if (resp2.equals("s") || resp2.equals("S")) { // inicia [if]
                                                            // String boleana sendo atribuida falsa para entrar na pagina inicial de Login.
                                                            validLogin = false;
                                                            // String boleana sendo atribuida verdadeira para sair do laço de repetição do Menu.
                                                            update = true;
                                                        } // encerra [if]
                                                } // encerra [if]
                                                // Comando acionado caso a confirmação de senha do usuario seja falso.     
                                                else { // inicia o [else]
                                                    // Comando para esperar 1 segundo para realizar a proxima ação.
                                                    Thread.sleep(1000);
                                                    // Imprimindo para o usuario que a confirmação de senha esta errado.
                                                    System.out.println("Confirmação de senha errado. Tente novamente.");
                                                    // Comando para esperar 1 segundo para realizar a proxima ação.
                                                    Thread.sleep(1000);
                                                } // encerra [else]
                                        } // encerra [if]
                                        // Condição Falsa que explica ao Usuario que a sua senha atual esta errada.
                                        else { // inicia else
                                            // Comando para esperar 1 segundo para realizar a proxima ação.
                                            Thread.sleep(1000);
                                            // Imprimi a explicação ao Usuario.
                                            System.out.println("Senha atual errada. Tente novamente.");
                                            // Comando para esperar 1 segundo para realizar a proxima ação.
                                            Thread.sleep(1000);
                                        } // encerra else
                                // Força uma parada.
                                break;
                                // Ação realizada caso o Usuario escolha a Opção "3". Opção de sair do Menu.
                                case "3":
                                    // Variavel String recebendo [Volte Novamente!] + o login do Usuario.
                                    status = "\nVolte Novamente! " + login;
                                    // Variavel boleana recebendo o valor verdadeiro para sair do laço de repetição do Menu. Fechando assim o programa.
                                    update = true;
                                    // Comando para esperar 1 segundo para realizar a proxima ação.
                                    Thread.sleep(1000);
                                // Força uma parada.
                                break;
                                // Comando realizado caso o Usuario nao escolha as 3 opções acima.
                                default:
                                    // Informando ao Usuario que ele nao realizou nenhuma escolha.
                                    System.out.println("Nenhuma opção escolhida...");
                                    // Comando para esperar 1 segundo para realizar a proxima ação.
                                    Thread.sleep(1000);
                                    // Informando ao Usuario que ele ira voltar ao Menu.
                                    System.out.println("Voltando ao Menu!");
                                    // Comando para esperar 1 segundo para realizar a proxima ação.
                                    Thread.sleep(1000);
                                // Comando para esperar 1 segundo para realizar a proxima ação.
                                break;
                            } // encerra o switch
                        } // encerra o laço de repetição do Menu.
                    } // encerra o Primeiro [else]
                    // fecha a varivel com uma declaração
                    stmSql.close(); 
                    // fecha a variavel com uma execução de uma declaração nela.
                    rsSql.close();
                } // encerra o laço de repetição da Pagina inicial de Login.
                // fecha o scanner
                scnLogin.close();
                // fecha o scanner
                scnSenha.close();
                // fecha o scanner
                scnResp.close();
                // fecha o scanner
                scnCadastroUpdate.close();    
        } // encerra o try
        // Comando que ira pegar uma exceção
        catch (Exception e) { // inicia o catch
            System.out.println("Ops! Ocorreu o erro " + e);
        } // encerra o catch
        // Imprimindo o valor String da variavel 'status'
        System.out.println(status);
    } // fechando o metodo main.
} // fechando a classe UpdateMySQL2