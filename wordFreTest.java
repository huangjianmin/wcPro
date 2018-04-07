package wcPro;

import static org.junit.Assert.*;

import org.junit.Test;

public class wordFreTest {

	@Test
	public void testDiviWord() {
		//fail("Not yet implemented");
		System.out.println(wordFre.diviWord("that,that,a,this")+"\nthat,2,a,1,this,1\n");
		System.out.println(wordFre.diviWord("that,that,a,this,this")+"\nthat,2,a,1,this,2\n");
		System.out.println(wordFre.diviWord("that,that,a,this,this,a,this")+"\nthat,2,a,2,this,3\n");
		System.out.println(wordFre.diviWord("that,that,a,-this,this,a,this")+"\nthat,2,a,2,-this,1,this,2\n");
		System.out.println(wordFre.diviWord("a,aa,aaa,aaa,aa,aaa")+"\na,1,aa,2,aaa,3\n");
		System.out.println(wordFre.diviWord("a,-aa,-aaa,aaa,aa,aaa")+"\na,1,-aa,1,-aaa,1,aaa,2,aa,1\n");
		System.out.println(wordFre.diviWord("-a,that,a,this")+"\n-a,1,that,1,a,1,this,1\n");
		System.out.println(wordFre.diviWord("that,that,a,this,this,is-")+"\nthat,2,a,1,this,2,is-,1\n");
		System.out.println(wordFre.diviWord("that,that,that,a,this,this,a,this")+"\nthat,3,a,2,this,3\n");
		System.out.println(wordFre.diviWord("that,that,a,-this,this,a,-this")+"\nthat,2,a,2,-this,2,this,1\n");
	}

	@Test
	public void testSort() {
		//fail("Not yet implemented");
		System.out.println(wordFre.diviWord("that,2,a,1,this,1")+"\nthat,2,a,1,this,1\n");
		System.out.println(wordFre.diviWord("that,2,a,1,this,2")+"\nthat,2,this,2,a,1\n");
		System.out.println(wordFre.diviWord("that,2,a,2,this,3")+"\nthis,3,a,2,that,2\n");
		System.out.println(wordFre.diviWord("that,2,a,2,-this,1,this,2")+"\na,2,that,2,this,2,-this,1\n");
		System.out.println(wordFre.diviWord("a,1,aa,2,aaa,3")+"\naaa,3,aa,2,a,1\n");
		System.out.println(wordFre.diviWord("na,1,-aa,1,-aaa,1,aaa,2,aa,1")+"\naaa,2,a,1,aa,1,-aa,1,-aaa,1\n");
		System.out.println(wordFre.diviWord("-a,1,that,1,a,1,this,1")+"\na,1,that,1,this,1,-a,1\n");
		System.out.println(wordFre.diviWord("that,2,a,1,this,2,is-,1")+"\nthat,2,this,2,a,1,is-,1\n");
		System.out.println(wordFre.diviWord("that,3,a,2,this,3")+"\nthat,3,this,3,a,2\n");
		System.out.println(wordFre.diviWord("that,2,a,2,-this,2,this,1")+"\na,2,that,2,-this,2,this,1\n");
	}

}
