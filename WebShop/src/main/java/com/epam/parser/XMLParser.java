package com.epam.parser;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class XMLParser {

    public static final Logger LOGGER = Logger.getLogger(XMLParser.class.getName());
    private static final String CONSTRAINT_TAG = "constraint";
    private static final String URL_PATTERN_TAG = "url-pattern";
    private static final String ROLE_TAG = "role";

    public SecurityProperties parse(File file) throws XMLException {
        List<SecurityConstraint> securityConstraints = new ArrayList<>();
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        try {
            documentBuilderFactory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(file);
            NodeList nodeList = document.getElementsByTagName(CONSTRAINT_TAG);
            for (int i = 0; i < nodeList.getLength(); i++) {
                Element element = (Element) nodeList.item(i);
                NodeList urlPatterns = element.getElementsByTagName(URL_PATTERN_TAG);
                NodeList roles = element.getElementsByTagName(ROLE_TAG);
                String urlPattern = urlPatterns.item(0).getTextContent();
                String regexPattern = urlPattern.replaceAll("\\*", "\\\\w+");
                List<String> rolesList = new ArrayList<>();
                for (int j = 0; j < roles.getLength(); j++) {
                    rolesList.add(roles.item(j).getTextContent());
                }
                securityConstraints.add(new SecurityConstraint(regexPattern, rolesList));
            }
            return new SecurityProperties(securityConstraints);
        } catch (ParserConfigurationException | IOException | SAXException e) {
            throw new XMLException(e);
        }
    }
}
