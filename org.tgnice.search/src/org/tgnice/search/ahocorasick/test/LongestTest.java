package org.tgnice.search.ahocorasick.test;

import java.util.List;

import org.junit.Test;
import org.tgnice.search.ahocorasick.LongestMatch;
import org.tgnice.search.ahocorasick.SearchResult;

public class LongestTest {

	@Test
	public void test() {
		long start;
		long end;
		String a = "ababba";
		String b = "ababaaaabab";
		
		start = System.currentTimeMillis();
		LongestMatch matchTest = new LongestMatch();
		List<String> strList = matchTest.generateSuffixPatterns(a);
		
		for(String tmp : strList){
			matchTest.addKeyword(new testPattern(tmp));
		}

		matchTest.trieCompile();
		
		end = System.currentTimeMillis();
		System.out.println("SuffixArray making time " + (double) ((end - start) / 1000) + " seconds");
		start = System.currentTimeMillis();
		matchTest.trieCompile();
		end = System.currentTimeMillis();
		System.out.println("Trie compiple time " + (double) ((end - start) / 1000) + " seconds");
		
		start = System.currentTimeMillis();
		SearchResult test = matchTest.match(b);
		end = System.currentTimeMillis();
		System.out.println("Search time " + (double) ((end - start) / 1000) + " seconds");
		
		System.out.println(test);
	}

}
