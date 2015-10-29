package org.tgnice.search.ahocorasick;

import java.util.List;

public class SearchResult {

	private List<Pattern> patternList;
	private List<Integer> posList;

	public SearchResult() {

	}

	public List<Pattern> getPatternList() {
		return patternList;
	}

	public void setPatternList(List<Pattern> patternList) {
		this.patternList = patternList;
	}

	public List<Integer> getPosList() {
		return posList;
	}

	public void setPosList(List<Integer> posList) {
		this.posList = posList;
	}

	public String toString() {

		if (patternList.size() != posList.size()) {
			return new String("cannot make string");
		}

		StringBuilder builder = new StringBuilder();

		for (int i = 0; i < patternList.size(); i++) {
			builder.append("pos = " + posList.get(i) + ", pattern = " + patternList.get(i) + "\n");
		}
		return builder.toString();
	}

	public int size() {
		if (patternList.size() != posList.size()) {
			return -1;
		}
		return patternList.size();
	}

}
