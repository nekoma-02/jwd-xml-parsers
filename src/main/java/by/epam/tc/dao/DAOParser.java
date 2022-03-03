package by.epam.tc.dao;

import java.io.File;
import java.util.List;

import by.epam.tc.entity.Application;

public interface DAOParser {
	
	List<Application> getApplications(File inputXml) throws DAOException;


}
