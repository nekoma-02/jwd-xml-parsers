package by.epam.tc.dao;

import by.epam.tc.dao.impl.dom.DOMParserImpl;
import by.epam.tc.dao.impl.sax.SAXParser;
import by.epam.tc.dao.impl.stax.STAXParser;

public class DAOParserFactory {

	private static final DAOParserFactory instance = new DAOParserFactory();

	private DAOParserFactory() {
	}

	public static DAOParserFactory getInstance() {
		return instance;
	}

	public DAOParser getParser(String type) {
		TypeParser typeParser = TypeParser.valueOf(type.toUpperCase());
		DAOParser parser = null;
		
		switch (typeParser) {
		case SAX:
			parser = new SAXParser();
			break;
		case STAX:
			parser = new STAXParser();
			break;
		case DOM:
			parser = new DOMParserImpl();
			break;
		}
		return parser;

	}
}

enum TypeParser {
	SAX, STAX, DOM;
}
