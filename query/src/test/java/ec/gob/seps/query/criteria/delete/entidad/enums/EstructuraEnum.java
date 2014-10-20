/**
 * 
 */
package ec.gob.seps.query.criteria.delete.entidad.enums;

/**
 * Enumeraci�n para identificar la estructura
 * @author eron
 *
 */
public enum EstructuraEnum {
	
	SOCIO("SOCIOS"),
	BALANCE("BALANCES"),
	GDEPOSITO("DEPOSITOS GARANTIZADOS"),
	CREDITO("CREDITOS"),
	INVERSION("INVERSIONES"),
	HALLAZGOS("HALLAZGOS"),
	CREDITOS_R01("CREDITO - SUJETO DE RIESGO");
	
	private String estructura;
	
	public synchronized String getEstructura(){
		return this.estructura;
	}

	public synchronized void setEstructura(String estructura){
		this.estructura = estructura;
	}
	
	private EstructuraEnum(String estructura){
		this.estructura = estructura;
	}
}
