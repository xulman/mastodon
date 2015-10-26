package net.trackmate.revised.trackscheme;

import static net.trackmate.graph.mempool.ByteUtils.DOUBLE_SIZE;
import net.trackmate.graph.Pool;
import net.trackmate.graph.PoolObject;
import net.trackmate.graph.mempool.ByteMappedElement;
import net.trackmate.graph.mempool.ByteMappedElementArray;
import net.trackmate.graph.mempool.MemPool;
import net.trackmate.graph.mempool.SingleArrayMemPool;

/**
 * Layouted dense vertex area.
 *
 * @author Tobias Pietzsch &lt;tobias.pietzsch@gmail.com&gt;
 */
public class ScreenVertexRange extends PoolObject< ScreenVertexRange, ByteMappedElement >
{
	protected static final int MIN_X_OFFSET = 0;
	protected static final int MAX_X_OFFSET = MIN_X_OFFSET + DOUBLE_SIZE;
	protected static final int MIN_Y_OFFSET = MAX_X_OFFSET + DOUBLE_SIZE;
	protected static final int MAX_Y_OFFSET = MIN_Y_OFFSET + DOUBLE_SIZE;
	protected static final int SIZE_IN_BYTES = MAX_Y_OFFSET + DOUBLE_SIZE;

	protected ScreenVertexRange( final Pool< ScreenVertexRange, ByteMappedElement > pool )
	{
		super( pool );
	}

	public ScreenVertexRange init( final double minX, final double maxX, final double minY, final double maxY )
	{
		setMinX( minX );
		setMaxX( maxX );
		setMinY( minY );
		setMaxY( maxY );
		return this;
	}

	public double getMinX()
	{
		return access.getDouble( MIN_X_OFFSET );
	}

	protected void setMinX( final double minX )
	{
		access.putDouble( minX, MIN_X_OFFSET );
	}

	public double getMaxX()
	{
		return access.getDouble( MAX_X_OFFSET );
	}

	protected void setMaxX( final double maxX )
	{
		access.putDouble( maxX, MAX_X_OFFSET );
	}

	public double getMinY()
	{
		return access.getDouble( MIN_Y_OFFSET );
	}

	protected void setMinY( final double minY )
	{
		access.putDouble( minY, MIN_Y_OFFSET );
	}

	public double getMaxY()
	{
		return access.getDouble( MAX_Y_OFFSET );
	}

	protected void setMaxY( final double maxY )
	{
		access.putDouble( maxY, MAX_Y_OFFSET );
	}

	@Override
	protected void setToUninitializedState()
	{}

	public static class ScreenVertexRangePool extends Pool< ScreenVertexRange, ByteMappedElement >
	{
		public ScreenVertexRangePool( final int initialCapacity )
		{
			this( initialCapacity, new ScreenVertexRangeFactory() );
		}

		private ScreenVertexRangePool( final int initialCapacity, final ScreenVertexRangeFactory f )
		{
			super( initialCapacity, f );
			f.edgePool = this;
		}

		@Override
		public ScreenVertexRange create( final ScreenVertexRange edge )
		{
			return super.create( edge );
		}

		public void delete( final ScreenVertexRange edge )
		{
			deleteByInternalPoolIndex( edge.getInternalPoolIndex() );
		}

		private static class ScreenVertexRangeFactory implements PoolObject.Factory< ScreenVertexRange, ByteMappedElement >
		{
			private ScreenVertexRangePool edgePool;

			@Override
			public int getSizeInBytes()
			{
				return ScreenVertexRange.SIZE_IN_BYTES;
			}

			@Override
			public ScreenVertexRange createEmptyRef()
			{
				return new ScreenVertexRange( edgePool );
			}

			@Override
			public MemPool.Factory< ByteMappedElement > getMemPoolFactory()
			{
				return SingleArrayMemPool.factory( ByteMappedElementArray.factory );
			}
		};
	}
}