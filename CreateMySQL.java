// Importação de todos os itens da biblioteca 'SQL'
import java.sql.*;
// // Declaração da Classe/Objeto CreateMySQL
public class CreateMySQL { // Inicia Classe/Objeto
    /* 
     * Declação do metodo Executor main.
     * Public : Pode ser Invocado por outras Classes/Objetos.
     * Static : Não pode ser alterado ou sobrescritos.
     * Void : Um metodo sem retorno.
     * Strings[] : Pode ser invocados métodos do tipo String e Matrizes[].
     * args : porque podera ser invocado o objeto args da biblioteca java.lang
    */ 
    public static void main(String[] args) { // inicia o metodo [main]
        // variavel String 'status' recebendo um valor.
        String status = "Nada aconteceu ainda";
        // Ação para tentar pegar uma exceção.
        try { // inicia o [try]
            // variavel String recebendo o comando para criar uma tabela no MySQL.
            String strCreateTable = "CREATE TABLE `mysql_connector`.`tbl_create` (`id` INT NOT NULL AUTO_INCREMENT, `nome` VARCHAR(255) NULL, PRIMARY KEY (`id`));";
            // variavel recebendo o Objeto App com o metodo conectar(). Essa ação ira realizar a conexão ao MySQL.
            Connection conn = App.conectar();
            // variavel 'stmSql' recebendo a criação de uma declaração que esta conectada no banco de dados.
            Statement stmSql = conn.createStatement();
            // essa ação adiciona mais um comando a ser executado em grupo.
            stmSql.addBatch(strCreateTable);
            // essa ação executa as declarações.
            stmSql.executeBatch();
            // fechando o 'stmSql' que tem o valor de criar declarações.
            stmSql.close();
            // variavel String 'status' sendo atualizada.
            status = "Ok! Tabela criada com sucesso";
        } // encerrando o [try]
        // ação que ira executar a exceção. 
        catch (Exception e) { // inicia o catch
            // imprime na tela avisando que ocorreu um erro e exibindo qual erro foi.
            System.err.println("Ops! Ocorreu o erro " + e);
        } // encerra o catch
        // imprime na tela a variavel String 'status'
        System.out.println(status);
    } // encerra o metodo [main]
} // encerra a Classe/Objeto
