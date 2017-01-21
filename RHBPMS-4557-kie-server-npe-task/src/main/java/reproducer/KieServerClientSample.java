package reproducer;

import org.kie.server.api.marshalling.MarshallingFormat;
import org.kie.server.api.model.KieContainerResource;
import org.kie.server.api.model.ReleaseId;
import org.kie.server.api.model.ServiceResponse;
import org.kie.server.api.model.ServiceResponse.ResponseType;
import org.kie.server.client.KieServicesClient;
import org.kie.server.client.KieServicesConfiguration;
import org.kie.server.client.KieServicesFactory;
import org.kie.server.client.UserTaskServicesClient;

public class KieServerClientSample {

	// container information
	private static final String G = "example";
	private static final String A = "rewards-project";
	private static final String V = "1.0";
	private static final String ID = "rewards";

	// kie server information
	private static final String URL = "http://localhost:8180/kie-server/services/rest/server";
	private static final String USR = "kieserver";
	private static final String PSW = "kieserver1!";

	// Kie server Java client classes
	private static KieServicesClient client;
	private static KieServicesConfiguration configuration;

	public static void main(String[] args) {
		configuration = KieServicesFactory.newRestConfiguration(URL, USR, PSW);
		// we can choose between XSTREAM, JSON and JAXB - default is JAXB
		configuration.setMarshallingFormat(MarshallingFormat.JAXB);
		// the time that the client can wait for a server response
		configuration.setTimeout(5000);
		client = KieServicesFactory.newKieServicesClient(configuration);
		UserTaskServicesClient taskClient = client.getServicesClient(UserTaskServicesClient.class);
		
		checkOrCreateContainer();
		
		// try to get a non existing task
		taskClient.findTaskById(123456l);
		
	}

	private static void checkOrCreateContainer() {
		ServiceResponse<KieContainerResource> containerInfo = client
				.getContainerInfo(ID);
		ResponseType result = containerInfo.getType();
		System.out.println();
		if (result == ResponseType.FAILURE) {
			ReleaseId release = new ReleaseId(G, A, V);
			KieContainerResource container = new KieContainerResource(ID,
					release);
			client.createContainer(ID, container);
		}
	}

}
