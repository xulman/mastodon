package net.trackmate.graph;

import net.trackmate.graph.mempool.MappedElement;
import net.trackmate.graph.mempool.MemPool;

public class AbstractVertexPool< V extends AbstractVertex< T, E >, T extends MappedElement, E extends AbstractEdge< ?, ? > > extends Pool< V, T >
{
	private AbstractEdgePool< E, ?, V > edgePool;

	public AbstractVertexPool(
			final int initialCapacity,
			final PoolObject.Factory< V > vertexFactory,
			final MemPool.Factory< T > poolFactory )
	{
		super( initialCapacity, vertexFactory, poolFactory );
	}

	public void linkEdgePool( final AbstractEdgePool< E, ?, V > edgePool )
	{
		this.edgePool = edgePool;
	}

	@Override
	public V createRef()
	{
		final V vertex = super.createRef();
		if ( edgePool != null )
			vertex.linkEdgePool( edgePool );
		return vertex;
	}

	public V create()
	{
		return create( createRef() );
	}

	@Override
	public V create( final V vertex )
	{
		return super.create( vertex );
	}

	public void release( final V vertex )
	{
		if ( edgePool != null )
			edgePool.releaseAllLinkedEdges( vertex );
		releaseByInternalPoolIndex( vertex.getInternalPoolIndex() );
	}
}