import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by x3727349s on 26/09/16.
 */
public class Main {
    //throws es para controlar las excepciones sin poner try/catch
    public static void main (String[] args) throws IOException{

        SAXParserFactory factory = SAXParserFactory.newInstance();

        InputStream xmlInput = new FileInputStream("pokemons.xml");

        try {
            SAXParser saxParser = factory.newSAXParser();
            SAXHandler handler = new SAXHandler();
            saxParser.parse(xmlInput, handler);

            tractarllistat(handler);

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (org.xml.sax.SAXException e) {
            e.printStackTrace();
        }

    }

    public static void tractarllistat(SAXHandler sax){

        for(Pokemons b: sax.pkList) {
            System.out.println("El Nombre del pokemon es: "+b.getNombre()+"\nLa classe es: "+b.getClasse()+" \nPV: "+b.getPV()+"\nAtaque 1: "+b.getAtaque1()+"\nAtaque 2: "+b.getAtaque2()+"\nEtapa: "+b.getEtapa()+"\n\n");
        }
    }

}


