package by.epam.tc.dao.impl.stax;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import by.epam.tc.dao.AppTagName;
import by.epam.tc.dao.DAOException;
import by.epam.tc.dao.DAOParser;
import by.epam.tc.entity.Application;

public class STAXParser implements DAOParser {

	@Override
	public List<Application> getApplications(File inputXml) throws DAOException {
		XMLInputFactory inputFactory = XMLInputFactory.newInstance();
		XMLStreamReader reader = null;
		List<Application> appList = null;
		try {
			reader = inputFactory.createXMLStreamReader(new FileInputStream(inputXml.getAbsoluteFile()));
			appList = process(reader);
			return appList;
		} catch (XMLStreamException e) {
			throw new DAOException(e);
		} catch (FileNotFoundException e) {
			throw new DAOException(e);
		}
	}

	private static List<Application> process(XMLStreamReader reader) throws XMLStreamException {
		List<Application> appList = new ArrayList<Application>();
		Application app = null;
		AppTagName elementName = null;
		while (reader.hasNext()) {
			int type = reader.next();

			switch (type) {
			case XMLStreamConstants.START_ELEMENT:
				elementName = AppTagName.valueOf(reader.getLocalName().toUpperCase());

				switch (elementName) {
				case APPLICATION:
					app = new Application();
					app.setId(Integer.parseInt(reader.getAttributeValue(null, "id")));
					break;
				default:
					break;
				}
				break;

			case XMLStreamConstants.CHARACTERS:
				String text = reader.getText().trim();

				if (text.isEmpty()) {
					break;
				}

				switch (elementName) {
				case NAME:
					app.setName(text);
					break;
				case PRIVELEGE:
					app.setPrivelege(text);
					break;
				case SPECIALTY:
					app.setSpecialty(text);
					break;
				case EMAIL:
					app.setEmail(text);
					break;
				case SCHOOL:
					app.setSchool(text);
					break;
				default:
					break;
				}
				break;

			case XMLStreamConstants.END_ELEMENT:
				elementName = AppTagName.valueOf(reader.getLocalName().toUpperCase());

				switch (elementName) {
				case APPLICATION:
					appList.add(app);
					break;
				default:
					break;
				}
				break;

			}
		}
		return appList;

	}

}
