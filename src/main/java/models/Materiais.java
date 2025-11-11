package models;

import java.sql.ResultSet;
import java.sql.SQLException;

// Material.java
public class Materiais {
    private int idMaterial;
    private String nomeMaterial;
    private float pontoRessuprimento;
    private float nivelEstoque;
    private String unidadeEstoque;
    private boolean statusObsolescencia;
    
    public Materiais() {
    }
    public Materiais(int idMaterial, String nomeMaterial, float pontoRessuprimento, float nivelEstoque, String unidadeEstoque, boolean statusObsolescencia) {
    	this.idMaterial = idMaterial;
    	this.nomeMaterial = nomeMaterial;
    	this.pontoRessuprimento = pontoRessuprimento;
    	this.nivelEstoque = nivelEstoque;
    	this.unidadeEstoque = unidadeEstoque;
    	this.statusObsolescencia = statusObsolescencia;
    }
    public Materiais(String nomeMaterial, float pontoRessuprimento, float nivelEstoque, String unidadeEstoque, boolean statusObsolescencia) {
    	this.nomeMaterial = nomeMaterial;
    	this.pontoRessuprimento = pontoRessuprimento;
    	this.nivelEstoque = nivelEstoque;
    	this.unidadeEstoque = unidadeEstoque;
    	this.statusObsolescencia = statusObsolescencia;
    }
    
    public Boolean buscaMaterial() {
    	MateriaisDAO ProdutoPesquisado = new MateriaisDAO();
    	ResultSet rs = ProdutoPesquisado.listarPorID(this.getIdMaterial() + "");
    	try {
			while (rs.next()) {
				if (rs.getInt("id_material") == this.getIdMaterial()) {
		    		this.setIdMaterial(rs.getInt("id_material"));
		    		this.setNomeMaterial(rs.getString("nome_material"));
		    		this.setNivelEstoque(rs.getFloat("Nivel_estoque"));
		    		this.setUnidadeEstoque(rs.getString("Unidade_estoque"));
		    		this.setPontoRessuprimento(rs.getFloat("Ponto_ressuprimento"));
		    		this.setStatusObsolescencia(rs.getBoolean("Status_Obsolescencia"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
    }
    
    public int salvaMaterial() {
    	MateriaisDAO MaterialSalvo = new MateriaisDAO();
    	this.setIdMaterial(MaterialSalvo.insert(this));
    	return this.getIdMaterial();
    }
    
    public int editaMaterial() {
    	MateriaisDAO MaterialSalvo = new MateriaisDAO();
    	return MaterialSalvo.update(this);
    }
    public int deletaMaterial() {
    	MateriaisDAO MaterialSalvo = new MateriaisDAO();
    	return MaterialSalvo.delete(this);
    }
    
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

    
    
    public boolean getStatusObsolescencia() {
        return statusObsolescencia;
    }

    public void setStatusObsolescencia(boolean statusObsolescencia) {
        this.statusObsolescencia = statusObsolescencia;
    }
}
