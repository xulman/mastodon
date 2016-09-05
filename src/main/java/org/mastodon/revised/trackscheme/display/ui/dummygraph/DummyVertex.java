package org.mastodon.revised.trackscheme.display.ui.dummygraph;

import java.util.concurrent.atomic.AtomicInteger;

import org.mastodon.graph.object.AbstractObjectVertex;
import org.mastodon.revised.model.HasLabel;
import org.mastodon.spatial.HasTimepoint;

public class DummyVertex extends AbstractObjectVertex< DummyVertex, DummyEdge > implements HasTimepoint, HasLabel
{
	private static final AtomicInteger idGenerator = new AtomicInteger();

	private final int id;

	private String label;

	private int timepoint;

	DummyVertex()
	{
		id = idGenerator.getAndIncrement();
	}

	@Override
	public int getTimepoint()
	{
		return timepoint;
	}

	@Override
	public String getLabel()
	{
		return label;
	}

	@Override
	public void setLabel( final String label )
	{
		this.label = label;
	}

	public DummyVertex init( final String label, final int timepoint )
	{
		this.label = label;
		this.timepoint = timepoint;
		return this;
	}

	@Override
	public String toString()
	{
		return label + " @t=" + timepoint;
	}

	public int getId()
	{
		return id;
	}
}