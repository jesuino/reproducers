package com.redhat.gss.reproducer;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;

public class ReceiveLargeObjectResourceImpl implements ReceiveLargeObjectResource {

	// update here for your large file  - mine has 300mb
	private static final String LARGE_FILE = "/opt/dados_transparencia/dados_backup.zip";

	public Response serveLargeObject(String filename) {
		System.out.println("== Serving file ==");
		StreamingOutput streamingOutput = output -> transfer(output);
		return Response.ok(streamingOutput).build();
	}

	private void transfer(OutputStream output)
			throws IOException {
		try (BufferedInputStream in = new BufferedInputStream(
				new FileInputStream(LARGE_FILE))) {
			int count;
			byte[] buffer = new byte[8 * 1024];
			while ((count = in.read(buffer)) != -1) {
				output.write(buffer, 0, count);
			}
		}
	}

}
