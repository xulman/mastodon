package net.trackmate.trackscheme;

import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;

public class KeyHandler
{
	private final ShowTrackScheme trackscheme;

	public KeyHandler( final ShowTrackScheme trackscheme )
	{
		this.trackscheme = trackscheme;
		install();
	}

	private void install()
	{
		final KeyStroke ks = KeyStroke.getKeyStroke( 'd' );
		registerAction( ks, ActionBank.getDeleteSelectionAction( trackscheme ) );

		final KeyStroke arrowDown = KeyStroke.getKeyStroke( KeyEvent.VK_DOWN, 0 );
		registerAction( arrowDown, ActionBank.getNavigateToChildAction( trackscheme, true ) );

		final KeyStroke arrowUp = KeyStroke.getKeyStroke( KeyEvent.VK_UP, 0 );
		registerAction( arrowUp, ActionBank.getNavigateToParentAction( trackscheme, true ) );

		final KeyStroke arrowRight = KeyStroke.getKeyStroke( KeyEvent.VK_RIGHT, 0 );
		registerAction( arrowRight, ActionBank.getNavigateToRightSibblingAction( trackscheme, true ) );

		final KeyStroke arrowLeft = KeyStroke.getKeyStroke( KeyEvent.VK_LEFT, 0 );
		registerAction( arrowLeft, ActionBank.getNavigateToLeftSibblingAction( trackscheme, true ) );
	}

	private void registerAction( final KeyStroke ks, final AbstractNamedAction action )
	{
		trackscheme.canvas.getInputMap().put( ks, action.name() );
		AbstractNamedAction.put( trackscheme.canvas.getActionMap(), action );
	}


}
