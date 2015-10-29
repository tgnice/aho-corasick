package org.tgnice.search.ahocorasick.test;

import org.junit.Test;
import org.tgnice.search.ahocorasick.Ahocorasick;
import org.tgnice.search.ahocorasick.ImprovedAhocorasick;
import org.tgnice.search.ahocorasick.SearchResult;

public class AhoTest {

	@Test
	public void test() {
		Ahocorasick ah = new Ahocorasick();
		ImprovedAhocorasick iah = new ImprovedAhocorasick();
	/*	
		testPattern tp = new testPattern("c");
		testPattern tp2 = new testPattern("abcdefg");
		testPattern tp3 = new testPattern("cdef");
		testPattern tp4 = new testPattern("acdef");
		testPattern tp5 = new testPattern("acdgaf");
		testPattern tp6 = new testPattern("aaacdefg");
		testPattern tp7 = new testPattern("cde");
		testPattern tp8 = new testPattern("b");
		*/
		testPattern tp = new testPattern("aaa");
		testPattern tp2 = new testPattern("aaaabb");
		testPattern tp3 = new testPattern("aabbcc");
		testPattern tp4 = new testPattern("abb");
		testPattern tp5 = new testPattern("bcc");
		testPattern tp6 = new testPattern("bbcc");
		testPattern tp7 = new testPattern("aabbccdd");
		testPattern tp8 = new testPattern("aaabb");
		
		ah.addKeyword(tp);
		ah.addKeyword(tp2);
		ah.addKeyword(tp3);
		ah.addKeyword(tp4);
		ah.addKeyword(tp5);
		ah.addKeyword(tp6);
		ah.addKeyword(tp7);
		ah.addKeyword(tp8);
		ah.trieCompile();
		
		iah.addKeyword(tp);
		iah.addKeyword(tp2);
		iah.addKeyword(tp3);
		iah.addKeyword(tp4);
		iah.addKeyword(tp5);
		iah.addKeyword(tp6);
		iah.addKeyword(tp7);
		iah.addKeyword(tp8);
		iah.trieCompile();
		
		long start = System.currentTimeMillis();
		SearchResult pt1 = ah.search("aaaabbaabbccdd");
		long end = System.currentTimeMillis();
		System.out.println(pt1);
		System.out.println("it takes " + (double) ((end - start) / 1000) + " seconds");
		
		start = System.currentTimeMillis();
		SearchResult pt2 = iah.search("aaaabbaabbccdd");
		end = System.currentTimeMillis();
		System.out.println(pt2);
		System.out.println("it takes " + (double) ((end - start) / 1000) + " seconds");
	}

}
