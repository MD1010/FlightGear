package readers;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import models.XmlNode;

public class FileReader {
    public static List<XmlNode> xmlVariables = new ArrayList<XmlNode>();
    public static String[] readFile(String fileName) {
        List<String> fileData = new ArrayList<String>();
        try {
            File fileDescriptor = new File(fileName);
            Scanner fileReader = new Scanner(fileDescriptor);
            while (fileReader.hasNextLine()) {
                String data = fileReader.nextLine();
                fileData.add(data);
            }
            fileReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return fileData.toArray(new String[0]);
    }

    public static List<XmlNode> readXMLFile(String fileName) {
        try {
            File fXmlFile = new File(fileName);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);

            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("chunk");

            for (int temp = 0; temp < nList.getLength(); temp++) {

                Node nNode = nList.item(temp);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement = (Element) nNode;
                    String name =  eElement.getElementsByTagName("name").item(0).getTextContent();
                    String format = eElement.getElementsByTagName("format").item(0).getTextContent();
                    String type = eElement.getElementsByTagName("type").item(0).getTextContent();
                    String node = eElement.getElementsByTagName("node").item(0).getTextContent();
                    xmlVariables.add(new XmlNode(name, format, type, node));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return xmlVariables;
    }
}
