package com.smms.service;

import org.eclipse.persistence.sessions.JNDIConnector;
import org.eclipse.persistence.sessions.Session;

public class JPAEclipseLinkSessionCustomizer implements
		org.eclipse.persistence.config.SessionCustomizer {

	@Override
	public void customize(Session session) throws Exception {
		 JNDIConnector conn = (JNDIConnector)session.getLogin().getConnector();
		 conn.setLookupType(JNDIConnector.STRING_LOOKUP);
		 System.out.println(">>>>>>>>> "+JNDIConnector.STRING_LOOKUP);
	}
}
