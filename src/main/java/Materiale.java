public class Materiale {

	private int idMateriale;
	private String nome;
	private float costo;
	private String desc;

	public String getNome() {
		return this.nome;
	}

	/**
	 * 
	 * @param nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getCosto() {
		return this.costo;
	}

	/**
	 * 
	 * @param costo
	 */
	public void setCosto(float costo) {
		this.costo = costo;
	}

	public String getDesc() {
		return this.desc;
	}

	/**
	 * 
	 * @param desc
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}

	public int getIdMateriale() {
		return this.idMateriale;
	}

}