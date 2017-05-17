Deploy the war on EAP 7 directly if you trust me or you can build it again and deploy it.

resteasy acts weirdly when we return an object and use the accept http header.

The weird behavior is:

1) this works: 

$ curl -H 'Accept: text/plain' http://localhost:8080/resteasy-accept-header/obj
java.lang.Object@412b34b4

2) this will not work:

$ curl -H 'Accept: foo/bar,text/plain' http://localhost:8080/resteasy-accept-header/obj
Could not find MessageBodyWriter for response object of type: java.lang.Object of media type: foo/bar 

3) It seems to also not completely resteasy the `Accept: */*` - it should work "give me what you have for this endpoint", but it throws an exception even having a text message body writer

curl -H 'Accept: */*' http://localhost:8080/resteasy-accept-header/obj
Could not find MessageBodyWriter for response object of type: java.lang.Object of media type: application/octet-stream

4) For String types it works well, see the http://localhost:8080/resteasy-accept-header/str  endpoint
