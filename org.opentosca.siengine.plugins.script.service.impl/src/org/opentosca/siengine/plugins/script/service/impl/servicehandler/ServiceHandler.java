package org.opentosca.siengine.plugins.script.service.impl.servicehandler;

import org.opentosca.instancedata.service.IInstanceDataService;
import org.opentosca.siengine.plugins.service.ISIEnginePluginService;
import org.opentosca.toscaengine.service.IToscaEngineService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Helper class that handles all needed services for SIEngine-ScriptPlugin.<br>
 * <br>
 * 
 * Copyright 2013 IAAS University of Stuttgart <br>
 * <br>
 * 
 * In this class the from the ScriptPlugin needed services are binded an
 * unbinded.
 * 
 * 
 * @see ISIEnginePluginService
 * @see IToscaEngineService
 * @see ICoreEndpointService
 * 
 * @author Michael Zimmermann - zimmerml@studi.informatik.uni-stuttgart.de
 * 
 */

public class ServiceHandler {
	
	public static IInstanceDataService instanceDataService,
			oldInstanceDataService;
	public static IToscaEngineService toscaEngineService,
			oldToscaEngineService;
	
	private final static Logger LOG = LoggerFactory.getLogger(ServiceHandler.class);
	
	
	/**
	 * Bind ToscaEngineService
	 * 
	 * @param toscaEngineService
	 */
	public void bindToscaService(IToscaEngineService toscaEngineService) {
		if (toscaEngineService != null) {
			if (ServiceHandler.toscaEngineService == null) {
				ServiceHandler.toscaEngineService = toscaEngineService;
			} else {
				ServiceHandler.oldToscaEngineService = toscaEngineService;
				ServiceHandler.toscaEngineService = toscaEngineService;
			}
			
			ServiceHandler.LOG.debug("Bind ToscaEngineService: {} bound.", toscaEngineService.toString());
		} else {
			ServiceHandler.LOG.error("Bind ToscaEngineService: Supplied parameter is null!");
		}
	}
	
	/**
	 * Unbind ToscaEngineService
	 * 
	 * @param toscaEngineService
	 */
	public void unbindToscaService(IToscaEngineService toscaEngineService) {
		if (ServiceHandler.oldToscaEngineService == null) {
			toscaEngineService = null;
		} else {
			ServiceHandler.oldToscaEngineService = null;
		}
		
		ServiceHandler.LOG.debug("Unbind ToscaEngineService unbound.");
	}
	
	/**
	 * Bind InstanceDataService
	 * 
	 * @param instanceDataService
	 */
	public void bindInstanceDataService(IInstanceDataService instanceDataService) {
		if (instanceDataService != null) {
			if (ServiceHandler.instanceDataService == null) {
				ServiceHandler.instanceDataService = instanceDataService;
			} else {
				ServiceHandler.oldInstanceDataService = instanceDataService;
				ServiceHandler.instanceDataService = instanceDataService;
			}
			
			ServiceHandler.LOG.debug("Bind InstanceDataServiceInterface: {} bound.", ServiceHandler.instanceDataService.toString());
		} else {
			ServiceHandler.LOG.error("Bind InstanceDataServiceInterface: Supplied parameter is null!");
		}
	}
	
	/**
	 * Unbind InstanceDataServiceInterface
	 * 
	 * @param instanceDataService
	 */
	public void unbindInstanceDataService(IInstanceDataService instanceDataService) {
		if (ServiceHandler.oldInstanceDataService == null) {
			instanceDataService = null;
		} else {
			ServiceHandler.oldInstanceDataService = null;
		}
		
		ServiceHandler.LOG.debug("Unbind InstanceDataServiceInterface unbound.");
	}
	
}
