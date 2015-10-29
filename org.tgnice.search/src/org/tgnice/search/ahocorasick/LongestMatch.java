package org.tgnice.search.ahocorasick;

import java.util.ArrayList;
import java.util.List;

public class LongestMatch extends Ahocorasick {

	public List<String> generateSuffixPatterns(String base) {
		List<String> str = new ArrayList<>();
		for (int i = 0; i < base.length(); i++) {
			for (int j = i + 1; j < base.length() + 1; j++) {
				String tmp = base.substring(i, j);
				str.add(tmp);
			}
		}

		return str;
	}

	public SearchResult match(String pt) {
		return match(pt.getBytes());
	}

	public SearchResult match(byte[] buf) {
		List<Pattern> searchList = new ArrayList<>();
		SearchResult result = new SearchResult();
		List<Integer> pos = new ArrayList<>();
		int longestLength = 0;
		Trie cur = root;
		for (int i = 0; i < buf.length; i++) {
			if (cur.getNextMap().get(buf[i]) == null) {
				cur = findSearchNode(cur, buf[i]);
				if (cur == root && (cur.getNextMap().get(buf[i]) == null)) {
					continue;
				}
			}
			cur = cur.getNextMap().get(buf[i]);
			if (cur.getPattern() != null && cur.getPattern().getByte().length >= longestLength) {
				if (longestLength != 0 && longestLength <cur.getPattern().getByte().length) {
					searchList.remove(0);
					pos.remove(0);
				}
				longestLength = cur.getPattern().getByte().length;
				searchList.add(cur.getPattern());
				pos.add((int) (i - cur.getPattern().getByte().length + 1));
			}

		}
		result.setPatternList(searchList);
		result.setPosList(pos);
		return result;
	}
}
