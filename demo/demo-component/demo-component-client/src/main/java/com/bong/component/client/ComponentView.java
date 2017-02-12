package com.bong.component.client;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;

import org.gwtbootstrap3.client.ui.Button;
import org.gwtbootstrap3.client.ui.Label;
import org.gwtbootstrap3.client.ui.constants.IconType;
import org.gwtbootstrap3.extras.notify.client.constants.NotifyType;
import org.gwtbootstrap3.extras.notify.client.ui.Notify;
import org.uberfire.client.workbench.widgets.notifications.NotificationManager;
import org.uberfire.workbench.events.NotificationEvent;
import org.uberfire.workbench.events.NotificationEvent.NotificationType;

@Dependent
public class ComponentView extends Composite implements ComponentPresenter.View {
	
	private ComponentPresenter presenter;

    private FlowPanel container = new FlowPanel();

    private Label label = new Label( "Empty" );
    
    private Label label2 = new Label( "Empty" );
    
    private Label label3 = new Label( "Empty" );
    
    private Button btn = new Button("spring jpa test");
    
    private Button btn2 = new Button("toast test");
    
    private ToastNotificationView tNotiView = new ToastNotificationView();
    
    @Inject
    private NotificationManager notificationManager;

    @PostConstruct
    public void setup() {
        initWidget( container );
        container.add( label );
        container.add( label2 );
        container.add( label3 );
        container.add(btn);
        container.add(btn2);
        //container.add(tNotiView);
        
        
        btn.addClickHandler(new ClickHandler(){

			@Override
			public void onClick(ClickEvent event) {
				presenter.testJPA();
			}
        });
        
        btn2.addClickHandler(new ClickHandler(){

			@Override
			public void onClick(ClickEvent event) {
				
				//notificationManager.addNotification( new NotificationEvent( message, NotificationType.WARNING ) );
				//Notify.notify("", "noti!!!", IconType.CHECK_CIRCLE_O, NotifyType.SUCCESS);
				Notify.notify("", "noti!!!", "pficon pficon-ok", NotifyType.SUCCESS);
				/*
				tNotiView.setPopupPosition(100, 100);
				tNotiView.setNotification("noti!!!!");
				tNotiView.show(new Command() {
					
					@Override
					public void execute() {
						
					}
				});*/
			}
        });
    }

    @Override
    public void setValue( String value ) {
        label.setText( value );
    }

	@Override
	public void setHelloWorld(String value) {
		label2.setText( value );
		
	}

	@Override
	public void setHelloWorld2(String value) {
		label3.setText( value );
		
	}

	@Override
	public void init(ComponentPresenter presenter) {
		this.presenter = presenter;
		
	}
}