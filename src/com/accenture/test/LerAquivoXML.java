package com.accenture.test;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.FileInputStream;
import java.io.InputStream;

public class LerAquivoXML {
    public static void main(String[] args) throws Exception {

//        SAX se trornou a principal api de manipulação de documento xml muito grande, pois ela não guarda nada em memoria
//        O que o processador SAX faz é simplesmente implementar um laço que varre o documento do início ao fim e dispara
//        eventos sempre que um “trecho interessante” do documento é encontrado

            XMLReader leitor = XMLReaderFactory.createXMLReader();
            LeitorXML logica = new LeitorXML();
            leitor.setContentHandler(logica);
            InputStream ips = new FileInputStream("src/vendas.xml");
            InputSource is = new InputSource(ips);
            leitor.parse(is);
        System.out.println(logica.produtos);
        }
    }

