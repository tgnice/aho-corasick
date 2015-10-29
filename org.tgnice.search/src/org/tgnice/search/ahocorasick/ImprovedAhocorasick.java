package org.tgnice.search.ahocorasick;

import java.util.ArrayList;
import java.util.List;

public class ImprovedAhocorasick extends Ahocorasick {

	public SearchResult search(byte[] buf) {
		List<Pattern> searchList = new ArrayList<>();
		SearchResult result = new SearchResult();
		List<Integer> pos = new ArrayList<>();
		Trie cur = root;
		for (int i = 0; i < buf.length; i++) {
			ArrayList<Pattern> tmp = new ArrayList<>();
			if (cur.getNextMap().get(buf[i]) == null) {
				cur = findSearchNode(cur, buf[i]);
				if (cur == root && (cur.getNextMap().get(buf[i]) == null)) {
					continue;
				}
			}
			cur = cur.getNextMap().get(buf[i]);
			findSubpattern(cur, buf[i], tmp);
			if (tmp.size() != 0) {
				searchList.addAll(tmp);
				for (Pattern p : tmp) {
					pos.add((int) (i - p.getByte().length + 1));
				}
			}
			if (cur.getPattern() != null) {
				searchList.add(cur.getPattern());
				pos.add((int) (i - cur.getPattern().getByte().length + 1));
			}

		}
		result.setPatternList(searchList);
		result.setPosList(pos);
		return result;
	}

	private void findSubpattern(Trie node, byte body, ArrayList<Pattern> pt) {

		if (node.getFailure() != root) {
			if (node.getFailure().getPattern() != null) {
				pt.add(node.getFailure().getPattern());
			}
			findSubpattern(node.getFailure(), body, pt);
		}
	}
}
