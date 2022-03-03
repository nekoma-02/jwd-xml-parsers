package by.epam.tc.dao.impl.dom;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.sun.org.apache.xerces.internal.parsers.DOMParser;

import by.epam.tc.dao.AppTagName;
import by.epam.tc.dao.DAOException;
import by.epam.tc.dao.DAOParser;
import by.epam.tc.entity.Application;

public class DOMParserImpl implements DAOParser {

	@Override
	public List<Application> getApplications(File inputXml) throws DAOException {
		DOMParser parser = new DOMParser();
		List<Application> appList = new ArrayList<Application>();
		try {
			parser.parse(inputXml.getAbsolutePath());
			Document doc = parser.getDocument();
			Element root = doc.getDocumentElement();
			NodeList appNodes = root.getElementsByTagName(AppTagName.APPLICATION.toString().toLowerCase());
			
			for (int i = 0; i < appNodes.getLength(); i++) {
				Application app = new Application();
				Element appElement = (Element)appNodes.item(i);
				app.setId(Integer.parseInt(appElement.getAttribute("id")));
				app.setEmail(getSingleChild(appElement, "email").getTextContent().trim());
				app.setName(getSingleChild(appElement, "name").getTextContent().trim());
				app.setPrivelege(getSingleChild(appElement, "privelege").getTextContent().trim());
				app.setSchool(getSingleChild(appElement, "school").getTextContent().trim());
				app.setSpecialty(getSingleChild(appElement, "specialty").getTextContent().trim());

				appList.add(app);

			}
			return appList;
			
		} catch (SAXException e) {
			throw new DAOException(e);
		} catch (IOException e) {
			throw new DAOException(e);
		}

	}
	
	private static Element getSingleChild(Element element, String name){

        NodeList nodeList = element.getElementsByTagName(name);
        Element child = (Element) nodeList.item(0);
        return child;
    }

}
