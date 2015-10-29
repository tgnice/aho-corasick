package org.tgnice.search.ahocorasick;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Ahocorasick {

	protected Trie root;

	public Ahocorasick() {
		this.root = new Trie();
		root.setFailure(root);
		root.setPrevious(root);
	}

	public Ahocorasick addKeyword(Pattern pattern) {
		Trie current = root;
		byte[] buf = pattern.getByte();
		for (int i = 0; i < buf.length; i++) {
			if (current.getNextMap().get(buf[i]) == null) {
				Trie node = new Trie();
				node.setBody(buf[i]);
				current.addNextNode(node);
			}
			current = current.getNextMap().get(buf[i]);
		}
		current.setPattern(pattern);
		return this;
	}

	public void trieCompile() {
		Queue<Trie> qQueue = new LinkedList<>();
		qQueue.add(root);
		while (!qQueue.isEmpty()) {
			Trie p = qQueue.poll();
			p.setFailure(this.findFailure(p));
			qQueue.addAll(p.getNextAll());
		}
	}

	private Trie findFailure(Trie node) {
		Trie travel = node.getPrevious();

		if (travel == root) {
			return root;
		}
		do {
			travel = travel.getFailure();
			if (travel.getNextMap().get(node.getBody()) != null) {
				return travel.getNextMap().get(node.getBody());
			}
		} while (travel != root);

		return root;
	}

	public SearchResult search(String pt) {
		return search(pt.getBytes());
	}

	public SearchResult search(byte[] buf) {
		List<Pattern> searchList = new ArrayList<>();
		List<Integer> pos = new ArrayList<>();
		SearchResult result = new SearchResult();

		Trie cur = root;
		for (int i = 0; i < buf.length; i++) {
			if (cur.getNextMap().get(buf[i]) == null) {
				cur = findSearchNode(cur, buf[i]);
				if (cur == root && (cur.getNextMap().get(buf[i]) == null)) {
					continue;
				}
			}
			cur = cur.getNextMap().get(buf[i]);
			if (cur.getPattern() != null) {
				searchList.add(cur.getPattern());
				pos.add((int) (i - cur.getPattern().getByte().length + 1));
			}

		}
		
		result.setPatternList(searchList);
		result.setPosList(pos);
		return result;
	}

	protected Trie findSearchNode(Trie node, byte body) {
		Trie cur = node;
		while (cur != root) {
			cur = cur.getFailure();
			if (cur.getNextMap().get(body) != null) {
				return cur;
			}
		}
		return root;
	}

	public void travel() {
		Queue<Trie> qQueue = new LinkedList<>();
		qQueue.add(root);
		while (!qQueue.isEmpty()) {
			Trie p = qQueue.poll();
			System.out.println(p);
			qQueue.addAll(p.getNextAll());
		}
	}
}
