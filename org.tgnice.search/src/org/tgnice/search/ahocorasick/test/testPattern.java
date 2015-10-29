package org.tgnice.search.ahocorasick.test;

import org.tgnice.search.ahocorasick.Pattern;

public class testPattern implements Pattern {

	private String stringPattern;

	public testPattern(String str) {
		this.stringPattern = str;
	}

	@Override
	public byte[] getByte() {
		return stringPattern.getBytes();
	}

	public String toString() {
		return stringPattern;
	}
}
