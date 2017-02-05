package com.bong.component.client;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;

import org.gwtbootstrap3.client.ui.Button;
import org.gwtbootstrap3.client.ui.Label;

@Dependent
public class ComponentView extends Composite implements ComponentPresenter.View {
	
	private ComponentPresenter presenter;

    private FlowPanel container = new FlowPanel();

    private Label label = new Label( "Empty" );
    
    private Label label2 = new Label( "Empty" );
    
    private Label label3 = new Label( "Empty" );
    
    private Button btn = new Button("spring jpa test");

    @PostConstruct
    public void setup() {
        initWidget( container );
        container.add( label );
        container.add( label2 );
        container.add( label3 );
        container.add(btn);
        
        
        btn.addClickHandler(new ClickHandler(){

			@Override
			public void onClick(ClickEvent event) {
				presenter.testJPA();
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