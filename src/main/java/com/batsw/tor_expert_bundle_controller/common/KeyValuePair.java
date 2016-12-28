package com.batsw.tor_expert_bundle_controller.common;

public class KeyValuePair<K, V> {
	private K mKey;
	private V mValue;

	public KeyValuePair(K key, V value) {
		mKey = key;
		mValue = value;
	}

	public K getKey() {
		return mKey;
	}

	public void setKey(K mKey) {
		this.mKey = mKey;
	}

	public V getValue() {
		return mValue;
	}

	public void setValue(V mValue) {
		this.mValue = mValue;
	}

	@Override
	public String toString() {
		return "TriplePair [mKey=" + mKey + ", mValue1=" + mValue + "]";
	}
}