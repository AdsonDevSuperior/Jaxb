package com.accenture.test;

import br.com.alura.Model.Produto;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.stream.events.StartElement;
import java.util.ArrayList;
import java.util.List;

public class LeitorXML extends DefaultHandler {

    List<Produto> produtos = new ArrayList<>();
    Produto produto;
    StringBuilder conteudo;
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        if("produto".equals(qName)) {
            produto = new Produto();
        }

        conteudo = new StringBuilder();
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        conteudo.append(new String(ch, start, length));
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if("produto".equals(qName)) {
            produtos.add(produto);
        }

        else if(qName.equals("nome")) {
            produto.setNome(conteudo.toString());
        }
        else if(qName.equals("preco")) {
            Double preco = Double.parseDouble(conteudo.toString());
            produto.setPreco(preco);
        }
    }
    }
