package com.domenicosp.projectoop;


public class Metadato {
	
	/**
	 * Attributi della classe Metadato
	 */
	
	private String alias;
	private String sourcefield;
	private String type;
	
	public Metadato(String alias, String sourcefield, String type) {
		this.alias = alias;
		this.sourcefield = sourcefield;
		this.type = type;
	}

	public Metadato() {	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getSourcefield() {
		return sourcefield;
	}

	public void setSourcefield(String sourcefield) {
		this.sourcefield = sourcefield;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Metadato [alias=" + alias + ", sourcefield=" + sourcefield + ", type=" + type + "]";
	}
	
}
