/**
 * 
 */
package com.bong.component.client;

import com.google.gwt.user.client.ui.DecoratedPopupPanel;

/**
 * <pre>
 * 
 * 
 * 
 * </pre>
 * @author Bongjin Kwon
 *
 */
public class ToastNotificationView extends DecoratedPopupPanel {
	/*
	private final BongAlert notification = new BongAlert();

	*//**
	 * 
	 *//*
	public ToastNotificationView() {
		setWidget( notification );
        notification.setDismissable( true );
	}
	
	public void setNotification( final String text ) {
        notification.setText( text );

    }
	
	public void show( final Command onCompleteCommand ) {

        //Fade in the notification message
        final LinearFadeInAnimation fadeInAnimation = new LinearFadeInAnimation( this ) {

            @Override
            public void onStart() {
                super.onStart();
                ToastNotificationView.this.show();
            }

        };

        //Pause. Removal is handled by the NotificationPopupsManager
        final Pause pauseAnimation = new Pause() {

            @Override
            public void onComplete() {
                super.onComplete();
                onCompleteCommand.execute();
            }

        };
        final Sequencer s = new Sequencer();
        s.add( fadeInAnimation, 1000 );
        s.add( pauseAnimation, 2000 );
        s.run();
    }*/

}
