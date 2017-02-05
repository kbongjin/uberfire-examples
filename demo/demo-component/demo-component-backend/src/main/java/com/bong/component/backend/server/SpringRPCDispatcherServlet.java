package com.bong.component.backend.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.google.gwt.user.client.rpc.IncompatibleRemoteServiceException;
import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.server.rpc.RPC;
import com.google.gwt.user.server.rpc.RPCRequest;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class SpringRPCDispatcherServlet extends RemoteServiceServlet
{
    private static final long serialVersionUID = 1L;
    private static final Logger logger = LoggerFactory.getLogger(SpringRPCDispatcherServlet.class);
 
    private WebApplicationContext applicationContext;
 
    
    @Override
    public void init()
    {
        applicationContext = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
        if (applicationContext == null)
        {
            throw new IllegalStateException("No Spring web application context found");
        }
        
        logger.info("SpringRPCDispatcherServlet deployed");
    }
    
 
    @Override
    public String processCall(String payload) throws SerializationException
    {
    	logger.debug("payload:{}", payload);
        try
        {
        	RPCRequest rpcRequest = RPC.decodeRequest(payload);
        	logger.debug("RPCRequest:{}", rpcRequest);
        	
        	
        	Object handler = applicationContext.getBean(rpcRequest.getMethod().getDeclaringClass());
            onAfterRequestDeserialized(rpcRequest);
            
            return RPC.invokeAndEncodeResponse(handler, rpcRequest.getMethod(), rpcRequest.getParameters(), rpcRequest.getSerializationPolicy());
        }
        catch (IncompatibleRemoteServiceException ex)
        {
            logger.error("An IncompatibleRemoteServiceException was thrown while processing this call.", ex);
            return RPC.encodeResponseForFailure(null, ex);
        }
    }
    
    
}