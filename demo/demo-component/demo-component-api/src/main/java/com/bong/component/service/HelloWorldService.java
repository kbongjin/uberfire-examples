package com.bong.component.service;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("rpc/HelloWorldService")
public interface HelloWorldService extends RemoteService {
	String helloWorld(String message);
	
	String aaa(String message);
}