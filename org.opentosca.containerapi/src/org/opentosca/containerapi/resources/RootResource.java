package org.opentosca.containerapi.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.opentosca.containerapi.resources.utilities.ResourceConstants;
import org.opentosca.containerapi.resources.utilities.Utilities;
import org.opentosca.containerapi.resources.xlink.Reference;
import org.opentosca.containerapi.resources.xlink.References;
import org.opentosca.containerapi.resources.xlink.XLinkConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * RootResource at Uri: host/containerapi
 * 
 * Copyright 2012 IAAS University of Stuttgart <br>
 * <br>
 * 
 * @author Markus Fischer - fischema@studi.informatik.uni-stuttgart.de
 * @author Rene Trefft - trefftre@studi.informatik.uni-stuttgart.de
 * 
 */
@Path("")
public class RootResource {
	
	final private static Logger LOG = LoggerFactory.getLogger(RootResource.class);
	
	@Context
	UriInfo uriInfo;
	@Context
	Request request;
	
	
	public RootResource() {
		RootResource.LOG.debug("{} created: {}", this.getClass(), this);
	}
	
	@GET
	@Produces(ResourceConstants.TOSCA_XML)
	public Response getReferences() {
		References refs = new References();
		
		refs.getReference();
		refs.getReference().add(new Reference(Utilities.buildURI(this.uriInfo.getAbsolutePath().toString(), "CSARs"), XLinkConstants.SIMPLE, "CSARs"));
		
		// refs.getReference().add(new
		// Reference(Utilities.buildURI(this.uriInfo.getAbsolutePath().toString(),
		// "AllDefinitions"), XLinkConstants.SIMPLE, "AllDefinitions"));
		// refs.getReference().add(new
		// Reference(Utilities.buildURI(this.uriInfo.getAbsolutePath().toString(),
		// "CSARFiles"), XLinkConstants.SIMPLE, "CSARFiles"));
		refs.getReference().add(new Reference(Utilities.buildURI(this.uriInfo.getAbsolutePath().toString(), "CSARControl"), XLinkConstants.SIMPLE, "CSARControl"));
		refs.getReference().add(new Reference(Utilities.buildURI(this.uriInfo.getAbsolutePath().toString(), "Credentials"), XLinkConstants.SIMPLE, "Credentials"));
		refs.getReference().add(new Reference(Utilities.buildURI(this.uriInfo.getAbsolutePath().toString(), "StorageProviders"), XLinkConstants.SIMPLE, "StorageProviders"));
		
		// InstanceData API and PortabilityAPI
		refs.getReference().add(new Reference(Utilities.buildURI(this.uriInfo.getAbsolutePath().toString(), "instancedata"), XLinkConstants.SIMPLE, "instancedata"));
		refs.getReference().add(new Reference(Utilities.buildURI(this.uriInfo.getAbsolutePath().toString(), "portability"), XLinkConstants.SIMPLE, "portability"));
		
		RootResource.LOG.debug("Number of References in Root: {}", refs.getReference().size());
		// selflink
		
		refs.getReference().add(new Reference(this.uriInfo.getAbsolutePath().toString(), XLinkConstants.SIMPLE, XLinkConstants.SELF));
		
		return Response.ok(refs.getXMLString()).build();
		
	}
}
