// Importação de todos os itens da biblioteca 'SQL'
import java.sql.*;

// Declaração da Classe/Objeto App
public class App { // inicia a classe App
    /* 
     * Declação do metodo Executor main.
     * Public : Pode ser Invocado por outras Classes/Objetos.
     * Static : Não pode ser alterado ou sobrescritos.
     * Void : Um metodo sem retorno.
     * Strings[] : Pode ser invocados métodos do tipo String e Matrizes[].
     * args : porque podera ser invocado o objeto args da biblioteca java.lang
    */ 
    public static void main(String[] args) { // inicia o metodo [main]
        // Imprime na tela que esta conectando com o banco de dados.
        System.out.println("Conectando ao banco de dados.");
        // Chamando o metodo  -- conectar() --
        conectar();
    } // encerra o metodo [main]
    // metodo publico para conectar ao banco de dados.
    public static Connection conectar() {
        // variavel do tipo String.
        String status = "Nada aconteceu ainda...";
        // variavel do tipo String recebendo o host local.
        String mysqlHost = "127.0.0.1";
        // variavel do tipo String recebendo qual banco de dados se conectar.
        String mysqlDb = "mysql_connector";
        // variavel do tipo String recebendo o User do banco de dados.
        String mysqlUser = "AllissonFelipe";
        // variavel do tipo String recebendo a senha do User.
        String mysqlPassword = "";
        // variavel do tipo String recebendo a URL do banco de dados.
        String mysqlUrl = "jdbc:mysql://" + mysqlHost + "/" + mysqlDb + "?user=" + mysqlUser + "&password=" + mysqlPassword;
        // variavel conn recebendo valor nulo.
        Connection conn = null;
        // Ação para tentar pegar uma exceção.
        try { // inicia o [try]
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            // variavel que recebe a conexão com o valor da variavel mysqlUrl.
            conn = DriverManager.getConnection(mysqlUrl);
            // variavel String 'status' sendo atualizada
            status = "Conexão realida com sucesso!";
        } // encerra o [try]
        // Onde a exceção é executada
        catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) { // inicia o [catch]
            // variavel String 'status' sendo atualizada.
            status = "Ops! Algo de errado não está certo com a conexão com o banco de dados MYSQL! mensagem do servidor: " + e;
        } // encerra o [catch]
        // comando para imprimir na tela a variavel 'status'
        System.out.println(status);
        // comando para retornar o valor de 'conn' a quem chamar esse objeto.
        return conn;
    } // encerra o metodo  -- conectar() --
} // encerra a classe/objeto App

