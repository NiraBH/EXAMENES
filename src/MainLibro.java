import java.util.HashMap;

import org.xml.sax.XMLReader;
import java.io.FileInputStream;

import org.xml.sax.InputSource;
import org.xml.sax.helpers.XMLReaderFactory;

public class MainLibro {

	private static HashMap<String, Libro> mapaLibros;

	public static void setMapaLibros(HashMap<String, Libro> hashmap) {
		mapaLibros = hashmap;
	}

	public static void mostrar() {
		
		
		for (String nombre : mapaLibros.keySet()) {
			String value = mapaLibros.get(nombre).toString();
			System.out.println(value);
		}

	}

	public static int getNLibros() {
		
		int nLibros = 0;

		for (String nombre : mapaLibros.keySet()) {
			nLibros++;
		}
		return nLibros;

	}

	public static void main(String[] args) throws Throwable {

		XMLReader reader = XMLReaderFactory.createXMLReader();
		ParserLibroXML parserlibro = new ParserLibroXML();

		reader.setContentHandler(parserlibro);

		reader.parse(new InputSource(new FileInputStream("libros.xml")));

		mostrar();
		System.out.println(getNLibros());

	}

}