import org.w3c.dom.Document;
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

    public void aboveAverageSalary() {
        try (InputStream inputStream = new FileInputStream("./src/main/resources/employee.xml")) {
            Document xmlDocument = getXML(inputStream);
            XPath xPath = XPathFactory.newInstance().newXPath();
            double avg = (double) xPath
                    .compile("sum(//post/salary) div count(//employees_list/employee)")
                    .evaluate(xmlDocument, XPathConstants.NUMBER);
            System.out.println("СРЕДНЯЯ ЗАРПЛАТА В КОМПАНИИ: " + avg);
            System.out.println("--------------------------------------------------------");
            System.out.println("СПИСОК СОТРУДНИКОВ С ЗАРПЛАТОЙ ВЫШЕ СРЕДНЕЙ В КОМПАНИИ:");
            String expression = "//post/salary";
            NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(xmlDocument, XPathConstants.NODESET);
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE && avg < Double.valueOf(node.getChildNodes().item(0).getTextContent())) {
                    System.out.print("--------------------------------------------------------");
                    System.out.print(node.getParentNode().getParentNode().getTextContent());
                }
            }
        } catch (ParserConfigurationException | SAXException | IOException | XPathExpressionException e) {
            e.printStackTrace();
        }
    }

    private static Document getXML(InputStream inputStream) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = builderFactory.newDocumentBuilder();
        return builder.parse(inputStream);
    }

}

