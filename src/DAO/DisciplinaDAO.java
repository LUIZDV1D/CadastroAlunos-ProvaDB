/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.naming.spi.DirStateFactory;
import modelo.*;

/**
 *
 * @author aluno
 */
public class DisciplinaDAO extends ExecuteSQL {
    
    public DisciplinaDAO(Connection con) {
        super(con);
    }
    
    
    
    public List<Disciplina> ConsultarCodigoDisciplina(String disciplina) {
        String sql = "select id from disciplinas where disciplina = '" + disciplina + "'";
        List<Disciplina> lista = new ArrayList<>();
        
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {                    
                    Disciplina a = new Disciplina();
                    a.setIdDi(rs.getInt(1));
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
    
    
    
    public List<Disciplina> ListarComboDisciplina() {
        String sql = "select disciplina from disciplinas order by id asc";
        List<Disciplina> lista = new ArrayList<>();
        
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {                    
                    Disciplina a = new Disciplina();
                    a.setDisciplina(rs.getString(1));
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
    
    
    
     public String Inserir_Nota(Nota a) {
         String sql = "insert into notas values(0,?,?,?,?)";
        
        try {
           
            PreparedStatement ps = getCon().prepareStatement(sql);
            
            ps.setInt(1, a.getIdAl());
            ps.setInt(2, a.getIdDis());
            ps.setString(3, a.getNomeAl());
            ps.setDouble(4, a.getNotaAl());
            
            
            if (ps.executeUpdate() > 0) {
                return "Inserido com sucesso";
            }else {
                return "Erro ao inserir";
            } 
            
        } catch (Exception e) {
            return e.getMessage();
        }
    }
     
     
     public List<Nota> Procura_Notas(int id, int idDis) {
         String sql = "SELECT nota FROM notas n INNER JOIN disciplinas d ON (n.idDisciplina = "+idDis+") WHERE idAluno = "+id;
         List<Nota> lista = new ArrayList<>();
         
         try {
             PreparedStatement ps = getCon().prepareStatement(sql);
             ResultSet rs = ps.executeQuery();
             
             if (rs != null) {
                 while (rs.next()) {                     
                     Nota no = new Nota();
                     no.setNotaAl(rs.getDouble(1));
                     lista.add(no);
                 }
             }
             
         } catch (Exception e) {
             return lista;
         }
         return lista;
     }
     
     
     
     
     //Alterar nota
    public String Alterar_Nota(Nota a) {
        String sql = "UPDATE notas set nota = ? WHERE idAluno = ? AND idDisciplina = ?";
        
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setDouble(1, a.getNotaAl());
            ps.setInt(2, a.getIdAl());
            ps.setInt(3, a.getIdDis());
            
            if (ps.executeUpdate() > 0) {
                return "Atualizado com sucesso";
            } else {
                return "Erro ao atualizar";
            }
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
}
