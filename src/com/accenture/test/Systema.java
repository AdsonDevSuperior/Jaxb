package com.accenture.test;

import br.com.alura.Model.Produto;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class Systema {

//    Jaxb é a api java para processar aquivos test.xml

    public static void main(String[] args) throws Exception {
//        Para carregar o documento na memoria é necessario o "DocumentBuilderFactory", que carrega o documento na memoria
        DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();
        fabrica.setValidating(true);
        fabrica.setNamespaceAware(true);
//        adiciona a linguagem do atributo desejado
        fabrica.setAttribute("http://java.sun.com/xml/jaxp/properties/schemaLanguage", "http://www.w3.org/2001/XMLSchema");
//        DocumentBuilder é o responsavél em construir os objetos na memoria
        DocumentBuilder builder = fabrica.newDocumentBuilder();
//        Document é usado para criar, acessar, implementar, modificar
        Document document = builder.parse("src/document.test.xml");

        Element venda = document.getDocumentElement();
        String moeda = venda.getAttribute("moeda");
        System.out.println(moeda);
        NodeList produtos = document.getElementsByTagName("produto");

        for (int i = 0; i < produtos.getLength(); i++) {
            Element produto = (Element) produtos.item(i);

            String nome = produto.getElementsByTagName("nome").item(0).getTextContent();
            double preco = Double.parseDouble(produto.getElementsByTagName("preco").item(0).getTextContent());
            Produto prod = new Produto(nome, preco);

            System.out.println(prod);

//            xsd = test.xml schema Definition
        }
    }



    }
