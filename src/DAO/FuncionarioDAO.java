/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import modelo.*;

/**
 *
 * @author aluno
 */
public class FuncionarioDAO extends ExecuteSQL {
    
    public FuncionarioDAO(Connection con) {
        super(con);
    }
    
    
    
    public boolean Logar(String L, String S) {
        boolean finalResult = false;
        
        try {
            String consulta = "SELECT login, senha FROM funcionario "
                + "WHERE login = '"+L+"' AND senha = '"+S+"'";
        
            PreparedStatement ps = getCon().prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {                    
                    Funcionario a = new Funcionario();
                    a.setLogin(rs.getString(1));
                    a.setSenha(rs.getString(2));
                    finalResult = true;
                }
            }
            
        } catch (Exception e) {
            e.getMessage();
        }
        return finalResult;
    }
    
}
