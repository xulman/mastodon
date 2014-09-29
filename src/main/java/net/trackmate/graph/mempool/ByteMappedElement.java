package net.trackmate.graph.mempool;

/**
 * A {@link MappedElement} that stores its data in a portion of a {@code byte[]}
 * array.
 *
 * <p>
 * Contract: A {@link ByteMappedElement} may be used on different
 * {@link ByteMappedElementArray}s but they all must have the same
 * bytesPerElement.
 *
 * @author Tobias Pietzsch <tobias.pietzsch@gmail.com>
 */
public class ByteMappedElement implements MappedElement
{
	/**
	 * How many bytes are required to store one element.
	 */
	private final int bytesPerElement;

	/**
	 * The current base offset (in bytes) into the underlying
	 * {@link ByteMappedElementArray#data storage array}.
	 */
	private int baseOffset;

	/**
	 * Contains the {@link ByteMappedElementArray#data storage array}.
	 */
	private ByteMappedElementArray dataArray;

	/**
	 * Create a new proxy for representing element is in the given
	 * {@link ByteMappedElementArray}.
	 *
	 * @param dataArray
	 *            initial storage.
	 * @param index
	 *            initial element index in storage.
	 */
	public ByteMappedElement( final ByteMappedElementArray dataArray, final int index )
	{
		this.dataArray = dataArray;
		this.bytesPerElement = dataArray.bytesPerElement;
		this.baseOffset = index * bytesPerElement;
	}

	void setDataArray( final ByteMappedElementArray dataArray )
	{
		this.dataArray = dataArray;
	}

	/**
	 * Set the index of the element that this {@link MappedElement} represents.
	 * Computes the base offset in the underlying memory area as
	 * <em>baseOffset = index * bytesPerElement</em>.
	 *
	 * @param index
	 *            index of the element that this {@link MappedElement} should
	 *            point to.
	 */
	void setElementIndex( final int index )
	{
		this.baseOffset = index * bytesPerElement;
	}

	@Override
	public void putByte( final byte value, final int offset )
	{
		ByteUtils.putByte( value, dataArray.data, baseOffset + offset );
	}

	@Override
	public byte getByte( final int offset )
	{
		return ByteUtils.getByte( dataArray.data, baseOffset + offset );
	}

	@Override
	public void putBoolean( final boolean value, final int offset )
	{
		ByteUtils.putBoolean( value, dataArray.data, baseOffset + offset );
	}

	@Override
	public boolean getBoolean( final int offset )
	{
		return ByteUtils.getBoolean( dataArray.data, baseOffset + offset );
	}

	@Override
	public void putInt( final int value, final int offset )
	{
		ByteUtils.putInt( value, dataArray.data, baseOffset + offset );
	}

	@Override
	public int getInt( final int offset )
	{
		return ByteUtils.getInt( dataArray.data, baseOffset + offset );
	}

	@Override
	public void putIndex( final int value, final int offset )
	{
		ByteUtils.putIndex( value, dataArray.data, baseOffset + offset );
	}

	@Override
	public int getIndex( final int offset )
	{
		return ByteUtils.getIndex( dataArray.data, baseOffset + offset );
	}

	@Override
	public void putLong( final long value, final int offset )
	{
		ByteUtils.putLong( value, dataArray.data, baseOffset + offset );
	}

	@Override
	public long getLong( final int offset )
	{
		return ByteUtils.getLong( dataArray.data, baseOffset + offset );
	}

	@Override
	public void putFloat( final float value, final int offset )
	{
		ByteUtils.putFloat( value, dataArray.data, baseOffset + offset );
	}

	@Override
	public float getFloat( final int offset )
	{
		return ByteUtils.getFloat( dataArray.data, baseOffset + offset );
	}

	@Override
	public void putDouble( final double value, final int offset )
	{
		ByteUtils.putDouble( value, dataArray.data, baseOffset + offset );
	}

	@Override
	public double getDouble( final int offset )
	{
		return ByteUtils.getDouble( dataArray.data, baseOffset + offset );
	}

	/**
	 * Two {@link ByteMappedElement} are equal if they refer to the same index
	 * in the same {@link ByteMappedElementArray}.
	 */
	@Override
	public boolean equals( final Object obj )
	{
		if ( obj instanceof ByteMappedElement )
		{
			final ByteMappedElement e = ( ByteMappedElement ) obj;
			return e.dataArray == dataArray && e.baseOffset == baseOffset;
		}
		else
			return false;
	}

	@Override
	public int hashCode()
	{
		return dataArray.hashCode() + baseOffset;
	}
}
