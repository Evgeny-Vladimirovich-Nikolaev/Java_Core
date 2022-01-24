import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class EmployeesUtil {

    private final String path;

    public EmployeesUtil(String path) {
        this.path = path;
    }

    public double avgSalary() {
        System.out.println("ищем среднее");
        try (InputStream inputStream = EmployeesUtil.class.getResourceAsStream("employee.xml")) {
            System.out.println("znachenie");
            Document xmlDocument = getXML(inputStream);
            XPath xPath = XPathFactory.newInstance().newXPath();
            String expression = "//post//salary";
            NodeList valutesNode = (NodeList) xPath.compile(expression).evaluate(xmlDocument, XPathConstants.NODESET);
            Node valuteNode = (Node) xPath.compile(expression).evaluate(xmlDocument, XPathConstants.NODE);
            System.out.println("ID узла: " + valuteNode.getAttributes().getNamedItem("//post//salary").getNodeValue());
            NodeList childNodes = valuteNode.getChildNodes();
            System.out.println("количество узлов - " + childNodes.getLength());
            for (int i = 0; i < childNodes.getLength(); i++) {
                Node node = childNodes.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE && "salary".equals(node.getNodeName())) {
                    Element element = (Element) node;
                    System.out.println("Курс валюты: " + element.getTextContent());
                }
            }
            System.out.println("Содержимое тега Value: " + xPath.compile("//Valute[@ID='R01020A']/Value/text()").evaluate(xmlDocument, XPathConstants.STRING));
            System.out.println("Среднее значение валют: ");
            double avg = (Double) xPath.compile("sum(//salary) div count(//salary)").evaluate(xmlDocument, XPathConstants.NUMBER);
            System.out.println("Среднее значение валют: " + avg);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void aboveAverageSalary() {
        try (InputStream inputStream = new FileInputStream("./src/main/resources/employee.xml")) {
            Document xmlDocument = getXML(inputStream);
            XPath xPath = XPathFactory.newInstance().newXPath();
            double avg = (double) xPath.compile("sum(//employees_list//employee//post//salary) div count(//employees_list//employee//post//salary)")
                    .evaluate(xmlDocument, XPathConstants.NUMBER);
            System.out.println("Среднее значение: " + avg);
            String expression = "//employees_list//employee//post//salary";
            NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(xmlDocument, XPathConstants.NODESET);
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = (Node) nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE && avg < Double.valueOf(node.getChildNodes().item(10).getTextContent())) {
                    Element element = (Element) node;
                    System.out.println(element.getTextContent());
                }
            }
            System.out.println(avg);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Document getXML(InputStream inputStream) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = builderFactory.newDocumentBuilder();
        return builder.parse(inputStream);
    }

    public void showOverAvgSalary() {

    }
}

