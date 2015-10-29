package org.tgnice.search.ahocorasick;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Trie {

	private byte body;
	private HashMap<Byte, Trie> nextMap;
	private Trie previous;
	private Trie failure;
	private Pattern pattern;

	public Trie() {
		nextMap = new HashMap<>();
		previous = null;
		failure = null;
		pattern = null;
	}

	public void addNextNode(Trie node) {
		node.setPrevious(this);
		nextMap.put(node.getBody(), node);
	}

	public byte getBody() {
		return body;
	}

	public void setBody(byte body) {
		this.body = body;
	}

	public HashMap<Byte, Trie> getNextMap() {
		return nextMap;
	}

	public void setNextMap(HashMap<Byte, Trie> nextMap) {
		this.nextMap = nextMap;
	}

	public List<Trie> getNextAll() {
		Iterator<Trie> trieItor = nextMap.values().iterator();
		Trie cur;
		List<Trie> trieList = new LinkedList<>();
		while (trieItor.hasNext()) {
			cur = trieItor.next();
			trieList.add(cur);
		}

		return trieList;
	}

	public Trie getPrevious() {
		return previous;
	}

	public void setPrevious(Trie previous) {
		this.previous = previous;
	}

	public Trie getFailure() {
		return failure;
	}

	public void setFailure(Trie failure) {
		this.failure = failure;
	}

	public Pattern getPattern() {
		return pattern;
	}

	public void setPattern(Pattern pattern) {
		this.pattern = pattern;
	}

	public String toString() {
		if (pattern != null) {
			return new String("body = " + (char) body + " previous body = " + (char) previous.getBody()
					+ " failure body = " + (char) failure.getBody() + " pattern = " + pattern.toString());
		} else {
			return new String("body = " + (char) body + " previous body = " + (char) previous.getBody()
					+ " failure body = " + (char) failure.getBody() + " pattern = null");
		}
	}

}
