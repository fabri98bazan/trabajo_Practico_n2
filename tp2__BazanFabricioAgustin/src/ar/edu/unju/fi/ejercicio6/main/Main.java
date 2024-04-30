package ar.edu.unju.fi.ejercicio6.main;

import ar.edu.unju.fi.ejercicio6.interfaces.funcionales.Converter;
import ar.edu.unju.fi.ejercicio6.model.FelinoDomestico;
import ar.edu.unju.fi.ejercicio6.model.FelinoSalvaje;

public class Main {

	public static void main(String[] args) {
		
		FelinoSalvaje gato = new FelinoSalvaje("Kiwi", (byte)13, 9f);
		Converter<FelinoSalvaje, FelinoDomestico> converter = x -> new FelinoDomestico(x.getNombre(),
		x.getEdad(), x.getPeso());
		if(Converter.isNotNull(gato.getNombre()) && gato.getEdad()>0 && gato.getPeso()>0)
		{
			System.out.print(gato.toString());
			//se realiza la conversión
			FelinoDomestico felino1 = converter.convert(gato);
			//mostramos los datos del objeto felino salvaje felino1
			converter.mostrarObjeto(felino1);
		}else
			System.out.println("Alguno de los atributos es nulo");

	}

}
