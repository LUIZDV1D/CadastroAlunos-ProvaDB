package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.*;

/**
 *
 * @author aluno
 */
public class AlunoDAO extends ExecuteSQL {
    
    public AlunoDAO(Connection con) {
        super(con);
    }
    
    
    
    public boolean Verifica_linhas (){
        String sql = "SELECT * FROM alunos";
        boolean num = false;
        try {
            
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs.getRow() > 0){
                num = true;
            }
            
        }catch(Exception e){
                e.getMessage();
        }
        
        return num;
    }
    
    public String Inserir_Aluno(Aluno a) {
        String sql = "insert into alunos values(0,?,?,?,?,?,?)";
        
        try {
           
            PreparedStatement ps = getCon().prepareStatement(sql);
            
            ps.setString(1, a.getNome());
            ps.setInt(2, a.getIdade());
            ps.setString(3, a.getNpai());
            ps.setString(4, a.getNmae());
            ps.setString(5, a.getCidade());
            ps.setString(6, a.getRua());
            
            
            if (ps.executeUpdate() > 0) {
                return "Inserido com sucesso";
            }else {
                return "Erro ao inserir";
            }
            
            
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    
    
    
    
    public List<Aluno> ListarComboAluno() {
        String sql = "select nome from alunos order by nome asc";
        List<Aluno> lista = new ArrayList<>();
        
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {                    
                    Aluno a = new Aluno();
                    a.setNome(rs.getString(1));
                    lista.add(a);
                }
                return lista;
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }
    
    
    
    public List<Aluno> ConsultarCodigoAluno(String nome) {
        String sql = "select id from alunos where nome = '" + nome + "'";
        List<Aluno> lista = new ArrayList<>();
        
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {                    
                    Aluno a = new Aluno();
                    a.setIdaluno(rs.getInt(1));
                    lista.add(a);
                }
                return lista;
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }
    
    
    
    public String Excluir_Aluno(Aluno a) {
        String sql = "delete from alunos where id = ? and nome = ? ";
        
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setInt(1, a.getIdaluno());
            ps.setString(2, a.getNome());
            
            if (ps.executeUpdate() > 0) {
                return "Excluido com sucesso";
            } else {
                return "Erro ao excluir";
            }
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
}
