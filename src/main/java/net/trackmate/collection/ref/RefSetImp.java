package net.trackmate.collection.ref;

import java.util.Collection;
import java.util.Iterator;

import gnu.trove.iterator.TIntIterator;
import gnu.trove.set.TIntSet;
import gnu.trove.set.hash.TIntHashSet;
import net.trackmate.Ref;
import net.trackmate.RefPool;
import net.trackmate.collection.RefSet;

public class RefSetImp< O extends Ref< O > > implements IntBackedRefCollection< O >, RefSet< O >
{
	private final TIntSet indices;

	private final RefPool< O > pool;

	public RefSetImp( final RefPool< O > pool )
	{
		this.pool = pool;
		indices = new TIntHashSet();
	}

	public RefSetImp( final RefPool< O > pool, final int initialCapacity )
	{
		this.pool = pool;
		indices = new TIntHashSet( initialCapacity );
	}

	protected RefSetImp( final RefPool< O > pool, final TIntSet indices )
	{
		this.pool = pool;
		this.indices = indices;
	}

	@Override
	public O createRef()
	{
		return pool.createRef();
	}

	@Override
	public void releaseRef( final O obj )
	{
		pool.releaseRef( obj );
	}

	@Override
	public TIntSet getIndexCollection()
	{
		return indices;
	}

	@Override
	public boolean add( final O obj )
	{
		return indices.add( obj.getInternalPoolIndex() );
	}

	@Override
	public boolean addAll( final Collection< ? extends O > objs )
	{
		if ( objs instanceof IntBackedRefCollection )
			return indices.addAll( ( ( IntBackedRefCollection< ? > ) objs ).getIndexCollection() );
		else
		{
			boolean changed = false;
			for ( final O obj : objs )
				if ( indices.add( obj.getInternalPoolIndex() ) )
					changed = true;
			return changed;
		}
	}

	@Override
	public void clear()
	{
		indices.clear();
	}

	@Override
	public boolean contains( final Object obj )
	{
		return ( obj instanceof Ref )
				? indices.contains( ( ( Ref< ? > ) obj ).getInternalPoolIndex() )
				: false;
	}

	@Override
	public boolean containsAll( final Collection< ? > objs )
	{
		if ( objs instanceof IntBackedRefCollection )
			return indices.containsAll( ( ( IntBackedRefCollection< ? > ) objs ).getIndexCollection() );
		else
		{
			for ( final Object obj : objs )
				if ( !contains( obj ) )
					return false;
			return true;
		}
	}

	@Override
	public boolean isEmpty()
	{
		return indices.isEmpty();
	}

	@Override
	public Iterator< O > iterator()
	{
		return new Iterator< O >()
		{
			final TIntIterator ii = indices.iterator();

			final O obj = pool.createRef();

			@Override
			public boolean hasNext()
			{
				return ii.hasNext();
			}

			@Override
			public O next()
			{
				pool.getByInternalPoolIndex( ii.next(), obj );
				return obj;
			}

			@Override
			public void remove()
			{
				ii.remove();
			}
		};
	}

	@Override
	public boolean remove( final Object obj )
	{
		if ( obj instanceof Ref )
		{
			final Ref< ? > o = ( Ref< ? > ) obj;
			return indices.remove( o.getInternalPoolIndex() );
		}
		else
			return false;
	}

	@Override
	public boolean removeAll( final Collection< ? > objs )
	{
		if ( objs instanceof IntBackedRefCollection )
			return indices.removeAll( ( ( IntBackedRefCollection< ? > ) objs ).getIndexCollection() );
		else
		{
			boolean changed = false;
			for ( final Object obj : objs )
				if ( remove( obj ) )
					changed = true;
			return changed;
		}
	}

	@Override
	public boolean retainAll( final Collection< ? > objs )
	{
		if ( objs instanceof IntBackedRefCollection )
			return indices.retainAll( ( ( IntBackedRefCollection< ? > ) objs ).getIndexCollection() );
		else
		{
			boolean changed = false;
			final Iterator< O > it = iterator();
			while ( it.hasNext() )
			{
				final O o = it.next();
				if ( !objs.contains( o ) )
				{
					it.remove();
					changed = true;
				}
			}
			return changed;
		}
	}

	@Override
	public int size()
	{
		return indices.size();
	}

	@Override
	public Object[] toArray()
	{
		final Object[] objs = new Object[ size() ];
		return toArray( objs );
	}

	@SuppressWarnings( "unchecked" )
	@Override
	public < A > A[] toArray( final A[] a )
	{
		final A[] array;
		if ( a.length < size() )
		{
			array = ( A[] ) new Object[ size() ];
		}
		else
		{
			array = a;
		}
		final TIntIterator it = indices.iterator();
		int index = 0;
		while ( it.hasNext() )
		{
			final int poolIndex = it.next();
			final O obj = pool.createRef();
			pool.getByInternalPoolIndex( poolIndex, obj );
			array[ index++ ] = ( A ) obj;
		}

		// nullify the rest
		for ( int i = index; i < array.length; i++ )
		{
			array[ i ] = null;
		}
		return array;
	}

	@Override
	public String toString()
	{
		final Iterator< O > i = iterator();
		if ( !i.hasNext() )
			return "[]";

		final StringBuilder sb = new StringBuilder();
		sb.append( '[' );
		for ( ;; )
		{
			final O e = i.next();
			sb.append( e );
			if ( !i.hasNext() )
				return sb.append( ']' ).toString();
			sb.append( ", " );
		}
	}
}
