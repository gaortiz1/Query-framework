package ec.gob.seps.query.criteria.delete.entidad.enums;

public enum EstructuraXsdEnum {
	
	SOCIO("socios.xsd"),
	BALANCE("balance.xsd"),
	GDEPOSITO("gdepositos.xsd"),
	D01("d01.xsd"),
	D02("d02.xsd"),
	CREDITO("creditos.xsd"),
	HALLAZGO("hallazgos.xsd"),
	R01("creditos/r01.xsd"),
	R02("creditos/r02.xsd"),
	R03("creditos/r03.xsd"),
	R04("creditos/r04.xsd"),
	R05("creditos/r05.xsd"),
	R06("creditos/r06.xsd"),
	R07("creditos/r07.xsd"),
	R08("creditos/r08.xsd"),
	R09("creditos/r09.xsd"),
	R20("creditos/r20.xsd"),
	R21("creditos/r21.xsd"),
	R22("creditos/r22.xsd"),
	L01("inversiones/l01.xsd"),
	L02("inversiones/l02.xsd"),
	L03("inversiones/l03.xsd"),
	L04("inversiones/l04.xsd");
	
	private final String estructuraXsd;

	/**
	 * @return the estructuraXsd
	 */
	public String getEstructuraXsd() {
		return estructuraXsd;
	}
	
	private EstructuraXsdEnum(String value){
		this.estructuraXsd = value;
	}
}
