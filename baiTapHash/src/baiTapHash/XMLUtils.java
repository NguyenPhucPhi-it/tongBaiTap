package baiTapHash;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class XMLUtils {

    public static void exportUsers(List<User> users) {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.newDocument();
            Element root = doc.createElement("users");
            doc.appendChild(root);

            for (User user : users) {
                Element userElem = doc.createElement("user");

                Element name = doc.createElement("username");
                name.appendChild(doc.createTextNode(user.getUsername()));
                userElem.appendChild(name);

                root.appendChild(userElem);
            }

            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("users.xml"));
            transformer.transform(source, result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<User> importUsers() {
        List<User> userList = new ArrayList<>();
        try {
            File xmlFile = new File("users.xml");
            if (!xmlFile.exists()) return userList;

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            NodeList nodeList = doc.getElementsByTagName("user");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element elem = (Element) node;
                    String username = elem.getElementsByTagName("username").item(0).getTextContent();
                    userList.add(new User(username, "")); // Mật khẩu để trống vì không được lưu trong XML
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userList;
    }
}
