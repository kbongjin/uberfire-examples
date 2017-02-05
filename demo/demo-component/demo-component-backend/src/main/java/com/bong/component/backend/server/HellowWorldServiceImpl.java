/**
 * 
 */
package com.bong.component.backend.server;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.bong.component.service.HelloWorldService;

/**
 * <pre>
 * 
 * 
 * 
 * </pre>
 * @author Bongjin Kwon
 *
 */
@Service
public class HellowWorldServiceImpl implements HelloWorldService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(HellowWorldServiceImpl.class);

	/**
	 * 
	 */
	public HellowWorldServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	
	@PostConstruct
	public void init() {
		LOGGER.debug("-------------- inited!!!");
	}

	/* (non-Javadoc)
	 * @see com.bong.component.service.HelloWorldService#helloWorld(java.lang.String)
	 */
	@Override
	public String helloWorld(String message) {
		// TODO Auto-generated method stub
		return message + " HelloWorld! ";
	}

	@Override
	public String aaa(String message) {
		// TODO Auto-generated method stub
		return message + " aaaa! ";
	}

}
