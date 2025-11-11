package models;

//OrdemProducao.java
public class OrdensProducao {
private int idOP;
private int idProduto;
private float quantidadeProduzir;
private String statusOP;
private float volumeProduzido;

public int getIdOP() {
 return idOP;
}

public void setIdOP(int idOP) {
 this.idOP = idOP;
}



public int getIdProduto() {
 return idProduto;
}

public void setIdProduto(int idProduto) {
 this.idProduto = idProduto;
}



public float getQuantidadeProduzir() {
 return quantidadeProduzir;
}

public void setQuantidadeProduzir(float quantidadeProduzir) {
 this.quantidadeProduzir = quantidadeProduzir;
}



public String getStatusOP() {
 return statusOP;
}

public void setStatusOP(String statusOP) {
 this.statusOP = statusOP;
}



public float getVolumeProduzido() {
 return volumeProduzido;
}

public void setVolumeProduzido(float volumeProduzido) {
 this.volumeProduzido = volumeProduzido;
}
}
