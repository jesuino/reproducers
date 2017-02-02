package com.redhat.gss.reproducer;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.jboss.resteasy.client.ClientResponse;
import org.jboss.resteasy.client.ProxyFactory;


public class LargeObjectClientTest {

	private static final String BASE_URL = "http://localhost:8080/RESTEASY-992-reproducer/rest";

	@SuppressWarnings("unchecked")
	@org.junit.Test
	public void test() throws FileNotFoundException, IOException {
		ReceiveLargeObjectResource service = ProxyFactory.create(
				ReceiveLargeObjectResource.class, BASE_URL);
		String file = "receivedJBoss.zip";
		String filename = "/tmp/" + file;
		ClientResponse<InputStream> response = (ClientResponse<InputStream>) service
				.serveLargeObject(filename);
		try (BufferedOutputStream out = new BufferedOutputStream(
				new FileOutputStream(file));
				InputStream in = response
						.getEntity(InputStream.class)) {
			int count;
			byte[] buffer = new byte[1024 * 8];
			long total = 0;
			int loop = 0;
			while ((count = in.read(buffer)) != -1) {
				out.write(buffer, 0, count);
				total += count;
				if (loop++ % 100 == 0) {
					System.out.println("wrote total = " + total / 1024 / 1024
							+ " Mb");
				}
			}
			System.out.println("transferred file with size: " + total);
		}
	}

}
