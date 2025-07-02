package models;

//OrdemServico.java
public class OrdensServico {
private int idOS;
private int idOP;
private int idProcesso;
private int ordemRoteiro;
private int recursoID;
private String statusOS;
private java.sql.Time tempoExecucaoReal;

public int getIdOS() {
return idOS;
}

public void setIdOS(int idOS) {
this.idOS = idOS;
}



public int getIdOP() {
return idOP;
}

public void setIdOP(int idOP) {
this.idOP = idOP;
}



public int getIdProcesso() {
return idProcesso;
}

public void setIdProcesso(int idProcesso) {
this.idProcesso = idProcesso;
}



public int getOrdemRoteiro() {
return ordemRoteiro;
}

public void setOrdemRoteiro(int ordemRoteiro) {
this.ordemRoteiro = ordemRoteiro;
}



public int getRecursoID() {
return recursoID;
}

public void setRecursoID(int recursoID) {
this.recursoID = recursoID;
}



public String getStatusOS() {
return statusOS;
}

public void setStatusOS(String statusOS) {
this.statusOS = statusOS;
}



public java.sql.Time getTempoExecucaoReal() {
return tempoExecucaoReal;
}

public void setTempoExecucaoReal(java.sql.Time tempoExecucaoReal) {
this.tempoExecucaoReal = tempoExecucaoReal;
}
}
