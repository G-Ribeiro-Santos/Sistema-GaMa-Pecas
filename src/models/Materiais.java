package models;

// Material.java
public class Materiais {
    private int idMaterial;
    private String nomeMaterial;
    private float pontoRessuprimento;
    private float nivelEstoque;
    private String unidadeEstoque;
    private boolean statusObsolescencia;

    public int getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(int idMaterial) {
        this.idMaterial = idMaterial;
    }

    
    
    public String getNomeMaterial() {
        return nomeMaterial;
    }

    public void setNomeMaterial(String nomeMaterial) {
        this.nomeMaterial = nomeMaterial;
    }

    
    
    public float getPontoRessuprimento() {
        return pontoRessuprimento;
    }

    public void setPontoRessuprimento(float pontoRessuprimento) {
        this.pontoRessuprimento = pontoRessuprimento;
    }

    
    
    public float getNivelEstoque() {
        return nivelEstoque;
    }

    public void setNivelEstoque(float nivelEstoque) {
        this.nivelEstoque = nivelEstoque;
    }

    
    
    public String getUnidadeEstoque() {
        return unidadeEstoque;
    }

    public void setUnidadeEstoque(String unidadeEstoque) {
        this.unidadeEstoque = unidadeEstoque;
    }

    
    
    public boolean isStatusObsolescencia() {
        return statusObsolescencia;
    }

    public void setStatusObsolescencia(boolean statusObsolescencia) {
        this.statusObsolescencia = statusObsolescencia;
    }
}
