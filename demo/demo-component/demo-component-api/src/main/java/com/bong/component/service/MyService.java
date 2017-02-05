package com.bong.component.service;

import com.bong.component.model.MyModel;
import org.jboss.errai.bus.server.annotations.Remote;

@Remote
public interface MyService {

    MyModel execute( final String param );

}
