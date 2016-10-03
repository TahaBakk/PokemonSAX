import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by x3727349s on 26/09/16.
 */
public class SAXHandler extends DefaultHandler {

    int contador_pokemon = 0;
    Pokemons pok = new Pokemons();
    public List<Pokemons> pkList = new ArrayList<Pokemons>();

    boolean is_Nombre=false;
    boolean is_pv = false;
    boolean is_Ataque1=false;
    boolean is_Ataque2=false;
    boolean is_Etapa=false;

    String Nombre="";
    String PV = "";
    String Ataque1="";
    String Ataque2="";
    String Etapa="";
    String Classe="";

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        if (qName.equalsIgnoreCase("pokemon"))
            contador_pokemon++;
        if (qName.equalsIgnoreCase("nombre")){
            is_Nombre=true;
            Classe=attributes.getValue(0);
        }
        if (qName.equalsIgnoreCase("pv"))
            is_pv=true;
        if (qName.equalsIgnoreCase("Ataque1"))
            is_Ataque1=true;
        if (qName.equalsIgnoreCase("Ataque2"))
            is_Ataque2=true;
        if (qName.equalsIgnoreCase("etapa"))
            is_Etapa=true;

    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {

        if (qName.equalsIgnoreCase("pokemon")){
            Pokemons pk = new Pokemons();
            pk.setNombre(Nombre);
            pk.setPV(PV);
            pk.setAtaque1(Ataque1);
            pk.setAtaque2(Ataque2);
            pk.setEtapa(Etapa);
            pk.setClasse(Classe);

            pkList.add(pk); }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String value = new String(ch, start, length).trim();

        if(value.length()==0)return;
        if (is_Nombre){
            Nombre = value;
            is_Nombre = false;
        }else if(is_pv){
            PV = value;
            is_pv= false;
        }else if(is_Ataque1){
            Ataque1 = value;
            is_Ataque1= false;
        } else if(is_Ataque2){
            Ataque2 = value;
            is_Ataque2= false;
        }else if(is_Etapa){
            Etapa = value;
            is_Etapa= false;
        }

    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Comença a llegir");    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("Acaba de llegir");    }
}
