package com.bong.component.backend.server;

import javax.enterprise.context.ApplicationScoped;

import com.bong.component.model.MyModel;
import com.bong.component.service.MyService;
import org.jboss.errai.bus.server.annotations.Service;

@Service
@ApplicationScoped
public class MyServiceImpl implements MyService {

    @Override
    public MyModel execute( String param ) {
        return new MyModel( "Value from Cooltech server! " + param );
    }
}
