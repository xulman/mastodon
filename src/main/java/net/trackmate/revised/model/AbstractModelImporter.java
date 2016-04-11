package net.trackmate.revised.model;

import net.trackmate.revised.model.mamut.tgmm.TgmmImporter;

/**
 * Provides access to {@link AbstractModelGraph} methods that we don't want to
 * be {@code public} but that are needed by importers (for example
 * {@link TgmmImporter}).
 *
 * @param <M>
 *
 * @author Tobias Pietzsch &lt;tobias.pietzsch@gmail.com&gt;
 */
public abstract class AbstractModelImporter< M extends AbstractModel< ?, ?, ? > >
{
	private final M model;

	protected AbstractModelImporter( final M model )
	{
		this.model = model;
	}

	protected void startImport()
	{
		model.modelGraph.pauseListeners();
		model.modelGraph.clear();
	}

	protected void finishImport()
	{
		model.modelGraph.resumeListeners();
		model.modelGraph.notifyGraphChanged();
	}
}