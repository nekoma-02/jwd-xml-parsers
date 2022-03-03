package by.epam.tc.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

import by.epam.tc.dao.DAOException;
import by.epam.tc.dao.DAOParser;
import by.epam.tc.dao.DAOParserFactory;
import by.epam.tc.entity.Application;

public class ApplicationServiceImp {
	
	private static final String SCHEMA_PATH = "C:\\Users\\nekoma\\eclipse-workspace\\xml_parser\\src\\main\\resources\\applications.xsd";
	
	public List<Application> getApplications(String typeParser, InputStream inputXml) throws ServiceException {
		DAOParser parser = DAOParserFactory.getInstance().getParser(typeParser);
		try {
			File xmlFile = createFile(inputXml);
			
			if (!validate(xmlFile)) {
				return null;
			}
			
			return parser.getApplications(xmlFile);
			
		} catch (DAOException e) {
			throw new ServiceException(e);
		} catch (IOException e) {
			throw new ServiceException(e);
		}
	}
	
	private File createFile(InputStream inputXml) throws IOException {
		int read ;
        byte[] bytes = new byte[1024];

        File xmlFile = File.createTempFile("xml", null);
        OutputStream out  = new FileOutputStream(xmlFile);

        while ((read = inputXml.read(bytes)) != -1) {
            out.write(bytes, 0, read);
        }

        out.close();
        inputXml.close();

        return xmlFile;
	}
	
	private static boolean validate(File xmlFile) {
		SchemaFactory sFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		boolean isValid = false;
		try {
			Schema schema = sFactory.newSchema(new File(SCHEMA_PATH));
			Validator validator = schema.newValidator();
			validator.validate(new StreamSource(xmlFile));
			isValid = true;
		} catch (SAXException e) {
			isValid = false;
		} catch (IOException e) {
			//
		}
			return isValid;
	}

}
