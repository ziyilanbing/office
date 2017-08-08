package com.glad.collections;

import java.util.Map.Entry;

public class FrozenEntry<TKey, TValue> implements Entry<TKey, TValue> {

	protected final TKey key;

	protected final TValue value;

	public FrozenEntry(TKey key, TValue value) {
		this.key = key;
		this.value = value;
	}

	@Override
	public TKey getKey() {
		return this.key;
	}

	@Override
	public TValue getValue() {
		return this.value;
	}

	@Override
	@Deprecated
	public final TValue setValue(TValue value) {
		throw new UnsupportedOperationException("The instance of this class has frozen.");
	}
}