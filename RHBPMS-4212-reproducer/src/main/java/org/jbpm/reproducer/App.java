package org.jbpm.reproducer;

import org.kie.server.api.model.KieContainerResource;
import org.kie.server.api.model.ReleaseId;
import org.kie.server.client.KieServicesClient;
import org.kie.server.client.KieServicesConfiguration;
import org.kie.server.client.KieServicesFactory;
import org.kie.server.client.ProcessServicesClient;

/**
 * 
 * 
 * @author wsiqueir
 *
 */
public class App {
	
	private static final String CONTAINER = "RHBPMS-4212-reproducer";
	private static final String SERVER_URL = "http://localhost:8080/kie-server/services/rest/server";
	private static final String PSW = "kieserver1!";
	private static final String USR = "kieserver";

	public static void main(String[] args) {
		KieServicesConfiguration conf = KieServicesFactory.newRestConfiguration(SERVER_URL, USR, PSW);
		conf.setTimeout(100000);
		KieServicesClient client = KieServicesFactory.newKieServicesClient(conf);
		ProcessServicesClient processClient = client.getServicesClient(ProcessServicesClient.class);
		// creates the container
		ReleaseId releaseId = new ReleaseId("org.jbpm.reproducer", CONTAINER, "1.0");
		KieContainerResource resource = new KieContainerResource(releaseId);
		client.createContainer(CONTAINER, resource);
		try {
			// start the process, abort it and then try to query process variables
			Long piid = processClient.startProcess(CONTAINER, "receiveExternalEntity");
			processClient.abortProcessInstance(CONTAINER, piid);
			// NPE will the thrown here
			processClient.getProcessInstanceVariables(CONTAINER, piid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		client.disposeContainer(CONTAINER);
	}

}
