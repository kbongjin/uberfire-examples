package com.bong.component.client;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;

import org.jboss.errai.common.client.api.Caller;
import org.jboss.errai.common.client.api.RemoteCallback;
import org.uberfire.client.annotations.WorkbenchPartTitle;
import org.uberfire.client.annotations.WorkbenchPartView;
import org.uberfire.client.annotations.WorkbenchScreen;

import com.bong.component.model.MyModel;
import com.bong.component.model.User;
import com.bong.component.service.HelloWorldService;
import com.bong.component.service.HelloWorldServiceAsync;
import com.bong.component.service.MyService;
import com.bong.component.service.UserServiceAsync;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.IsWidget;

@WorkbenchScreen(identifier = "ComponentPresenter")
@Dependent
public class ComponentPresenter {

    public interface View extends IsWidget {
    	
    	void init(ComponentPresenter presenter);

        void setValue( String value );
        
        void setHelloWorld( String value );
        
        void setHelloWorld2( String value );
    }

    @Inject
    private Caller<MyService> myService;
    
    HelloWorldServiceAsync helloWorldService = HelloWorldServiceAsync.Util.getInstance();
    
    UserServiceAsync userService = UserServiceAsync.Util.getInstance();


    @Inject
    private View view;

    @PostConstruct
    private void init() {
    	
    	view.init(this);
    	
        myService.call( new RemoteCallback<MyModel>() {
            @Override
            public void callback( MyModel response ) {
                view.setValue( response.getValue() );
            }
        } ).execute( "hi" );
        
        helloWorldService.helloWorld("hello", new AsyncCallback<String>() {

            public void onFailure(Throwable caught) {
              Window.alert("RPC to helloWorld() failed.");
            }

            public void onSuccess(String result) {
            	view.setHelloWorld(result);
            }
        });
        
        helloWorldService.aaa("hello", new AsyncCallback<String>() {

            public void onFailure(Throwable caught) {
              Window.alert("RPC to aaa() failed.");
            }

            public void onSuccess(String result) {
            	view.setHelloWorld2(result);
            }
        });
    }

    @WorkbenchPartTitle
    public String getTitle() {
        return "Remote Greetings";
    }

    @WorkbenchPartView
    public IsWidget getView() {
        return view;
    }
    
    public void testJPA() {
    	
    	userService.save(new User(null, "name", "loginId", "pass"), new AsyncCallback<User>(){

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("RPC to save() failed.");
				
			}

			@Override
			public void onSuccess(User result) {
				view.setHelloWorld2("saved user.id="+ result.getId());
			}
    		
    	});
    }

}
