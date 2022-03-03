package by.epam.tc.dao.impl.sax;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import by.epam.tc.dao.AppTagName;
import by.epam.tc.entity.Application;

public class ApplicationSAXHandler extends DefaultHandler {
	private List<Application> appList = new ArrayList<Application>();
	private StringBuilder data = null;
	private Application app = null;
	
	public List<Application> getApplicationList() {
		return appList;
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		data.append(ch, start, length);
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		AppTagName appTagName = AppTagName.valueOf(localName.toUpperCase());
		switch (appTagName) {
		case NAME:
			app.setName(data.toString());
			break;
		case EMAIL:
			app.setEmail(data.toString());
			break;
		case PRIVELEGE:
			app.setPrivelege(data.toString());
			break;
		case SCHOOL:
			app.setSchool(data.toString());
			break;
		case SPECIALTY:
			app.setSpecialty(data.toString());
			break;
		case APPLICATION:
			appList.add(app);
			app = null;
			break;
		default:
			break;
		}
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		data = new StringBuilder();
		if (localName.equals("application")) {
			app = new Application();
			app.setId(Integer.parseInt(attributes.getValue("id")));
		}
		
	}

}

