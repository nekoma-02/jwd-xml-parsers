package by.epam.tc.dao.impl.sax;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import by.epam.tc.dao.DAOException;
import by.epam.tc.dao.DAOParser;
import by.epam.tc.entity.Application;

public class SAXParser implements DAOParser{

	@Override
	public List<Application> getApplications(File inputXml) throws DAOException {
		ApplicationSAXHandler handler = new ApplicationSAXHandler();

		try {

			XMLReader reader = XMLReaderFactory.createXMLReader();

			reader.setContentHandler(handler);
			reader.parse(inputXml.getAbsolutePath());

		} catch (SAXException e) {
			throw new DAOException(e);
		} catch (IOException e) {
			throw new DAOException(e);
		}

		return handler.getApplicationList();

	}
}
