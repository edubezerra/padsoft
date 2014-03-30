package br.cefetrj.sca.dominio;

public enum DiaSemana {
	DOMINGO, SEGUNDA, TERCA, QUARTA, QUINTA, SEXTA, SABADO;
	
	public static DiaSemana findByText(String abbr){
	    for(DiaSemana v : values()){
	        if( v.toString().equals(abbr)){
	            return v;
	        }
	    }
	    return null;
	}
}
