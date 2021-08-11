//@author Maria
package dominio;

import bancodedados.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Deposito {
    //declaração de variáveis
    private int id;
    private String nome;
    private String fkCnpj;
    private int numeroBanco;
    private String banco;
    private int conta;
    
    //métodos
    
    //cadastro de conta para depósito
    public boolean cadastrarDeposito(){
        //comando de execução de banco de dados
        String sql = "INSERT INTO deposito " 
                   +"(nome, fkcnpj, numerobanco, banco, conta) " 
                   +"VALUES(?, ?, ?, ?, ?)";
        //conectando com o banco
        Connection con = Conexao.conectar();
        try{
            //preparando o comando sql com os dados
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, this.nome);
            stm.setString(2, this.fkCnpj);
            stm.setInt(3, this.numeroBanco);
            stm.setString(4, this.banco);
            stm.setInt(5, this.conta);
            //executando comando
            stm.execute();
        }catch(SQLException ex){
            System.out.println("Erro: "+ex.getMessage());
            return false;
        }
        
        return true;
    }
    
    //alteração de conta para depósito
    public boolean alterarDeposito(){
        //comando de execução de banco de dados 
        String sql = "UPDATE deposito " 
                + "SET nome=?, cnpj=?, numerobanco=?, fkagencia=?, conta=? "
                + "WHERE id=?";
        //conectando com o banco
        Connection con = Conexao.conectar();
        try {
            //preparando comando sql com os dados
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, this.nome);
            stm.setString(2, this.fkCnpj);
            stm.setInt(3, this.numeroBanco);
            stm.setString(4, this.banco);
            stm.setInt(5, this.conta);
            stm.setInt(6, this.id);
            //executando comando
            stm.execute();
        }catch(SQLException ex){
            System.out.println("Erro: "+ex.getMessage());
            return false;
        }
        
        return true;
    }
    
    //exclusão de conta para deposito
    public boolean excluirDeposito(){
        //comando de execução de banco de dados
        String sql = "DELETE FROM deposito " 
                + "WHERE id=?";
        //conectando com o banco
        Connection con = Conexao.conectar();
        try{
            //preparando o comando com os dados
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, this.id);
            //executando comando
            stm.execute();   
        } catch (SQLException ex) {
            System.out.println("Erro:" + ex.getMessage());
            return false; 
        }
        
        return true;
    }
    
    //método para verificar se pessoa juridica possui dados de pagamento
    public boolean verificaDados(String pCnpj){
        //comando de execução de banco de dados
        String sql = "select * from deposito where cnpj = ?";
        //conectando com o banco
        Connection con = Conexao.conectar();
        try {
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, pCnpj);
            ResultSet rs = stm.executeQuery();
            return rs.next();         
        }catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage());
        }
        return true;
    }
    
    //área de getters e setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return fkCnpj;
    }

    public void setCnpj(String cnpj) {
        this.fkCnpj = cnpj;
    }

    public int getNumeroBanco() {
        return numeroBanco;
    }

    public void setNumeroBanco(int numerobanco) {
        this.numeroBanco = numerobanco;
    }

    public String getFkAgencia() {
        return banco;
    }

    public void setFkAgencia(String fkAgencia) {
        this.banco = fkAgencia;
    }

    public int getConta() {
        return conta;
    }

    public void setConta(int conta) {
        this.conta = conta;
    }
    
}