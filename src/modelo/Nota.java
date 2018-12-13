/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author aluno
 */
public class Nota {
    private int idN;
    private int idAl;
    private int idDis;
    private String nomeAl;
    private double notaAl;

    
    
    public int getIdN() {
        return idN;
    }

    public void setIdN(int idN) {
        this.idN = idN;
    }

    public int getIdAl() {
        return idAl;
    }

    public void setIdAl(int idAl) {
        this.idAl = idAl;
    }

    public int getIdDis() {
        return idDis;
    }

    public void setIdDis(int idDis) {
        this.idDis = idDis;
    }

    public String getNomeAl() {
        return nomeAl;
    }

    public void setNomeAl(String nomeAl) {
        this.nomeAl = nomeAl;
    }

    public double getNotaAl() {
        return notaAl;
    }

    public void setNotaAl(double notaAl) {
        this.notaAl = notaAl;
    }
    
}
