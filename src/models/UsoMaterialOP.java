package models;

//UsoMaterialOP.java
public class UsoMaterialOP {
private int idOP;
private int idProduto;
private float quantidadeReservada;
private float quantidadeConsumida;

public int getIdOP() {
return idOP;
}

public void setIdOP(int idOP) {
this.idOP = idOP;
}

public float getQuantidadeReservada() {
return quantidadeReservada;
}

public void setQuantidadeReservada(float quantidadeReservada) {
this.quantidadeReservada = quantidadeReservada;
}



public float getQuantidadeConsumida() {
return quantidadeConsumida;
}

public void setQuantidadeConsumida(float quantidadeConsumida) {
this.quantidadeConsumida = quantidadeConsumida;
}

public int getIdProduto() {
	return idProduto;
}

public void setIdProduto(int idProduto) {
	this.idProduto = idProduto;
}
}