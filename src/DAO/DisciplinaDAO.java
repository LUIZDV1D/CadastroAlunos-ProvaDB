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
    
}
