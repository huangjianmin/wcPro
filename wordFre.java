package wcPro;
import  java.io.*; 
import  java.lang.*; 
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap; 

public class wordFre {
	public static ArrayList<String> diviWord(String targetStr) {  
		int curPosition=0; 
		//System.out.println(targetStr);
		ArrayList<String> words=new ArrayList<String>();  //划分单词
		while(curPosition<targetStr.length()) 
		{ 
			while(curPosition<targetStr.length()&&!(targetStr.charAt(curPosition)>='a'&&targetStr.charAt(curPosition)<='z'||targetStr.charAt(curPosition)>='A'&&targetStr.charAt(curPosition)<='Z'||targetStr.charAt(curPosition)=='-')) 
			{ 
				curPosition++; 
			}//去掉非字母
			boolean isWord=false; 
			String thisWord=""; 
			while (curPosition<targetStr.length()&&(targetStr.charAt(curPosition)>='a'&&targetStr.charAt(curPosition)<='z'||targetStr.charAt(curPosition)>='A'&&targetStr.charAt(curPosition)<='Z'||targetStr.charAt(curPosition)=='-')) 
			{ 
				isWord=true; 
				thisWord+=targetStr.charAt(curPosition); 
				curPosition++; 
			} 
			if (isWord)  //只有isWord为真时，才将单词计入words 
			{
				words.add(thisWord);				
			}
			else
			{
				thisWord="";
			}
			
		} 
		int size=words.size();
		int m=0;
		ArrayList<String> cword=new ArrayList<String>();  //统计单词数
		ArrayList<Integer> num=new ArrayList<Integer>();
		//ArrayList<String> cnum=new ArrayList<String>(); 
		//cword.add(words.get(0));
		//num.add(1);
		ArrayList<String> wordNum=new ArrayList<String>();
		for(int i=0;i<size;i++) {
			String aa=words.get(i);
			wordNum.add(2*i, aa);
			wordNum.add(2*i+1,"1");
			/*
			String a=words.get(i);
			m=0;
			for(int j=0;j<i;j++) {
				if(cword.get(j)==a)
				{
					num.set(j,num.get(j)+1);
					m=1;
					//System.out.printf("eroor");
				}
				
			}
			if(m==0) {
				cword.add(a);
				num.add(1);
			}*/
		}

		for(int i=0;i<size;i++) {
			//System.out.println(wordNum.get(0));
			for(int j=i+1;j<size;j++)
				if(wordNum.get(2*i).equals(wordNum.get(2*j)))
				{
					int a=Integer.parseInt(wordNum.get(2*i+1))+1;
					wordNum.set(2*i+1,Integer.toString(a));
					wordNum.remove(2*j+1);
					wordNum.remove(2*j);
					j--;
					size-=1;
				}
			/*System.out.println(i);
			System.out.println(wordNum.get(2*i));
			System.out.print(wordNum.get(2*i+1));
			*/
		}
		/*
		ArrayList<String> wordNum=new ArrayList<String>();
		int sizec=cword.size();
		for(int i=0;i<sizec;i++) {
			wordNum.add(cword.get(i));
			String s=num.get(i)+"";			
			wordNum.add(s);
		}
		*/
		return wordNum;
	} 
	//public static String wordFre(String word) {
		//String word1="";
		//return word1;
	//}
	public static ArrayList<String> sort(ArrayList<String> str){
		HashMap<String, Integer> map=new HashMap<> ();
		int i=0;
		while(i<str.size()-1) {
			map.put(str.get(i), Integer.parseInt(str.get(++i)));
			i++;
		}
		// Step2 排序
		// 以Key进行排序
		TreeMap treemap = new TreeMap(map);
		// 以value进行排序
		ArrayList<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(
				treemap.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
			public int compare(Map.Entry<String, Integer> o1,
					Map.Entry<String, Integer> o2) {
				return o2.getValue() - o1.getValue();// 降序
				// 升序 o1.getValue() - o2.getValue()）
			}
		});
		i=0;
		for (Map.Entry<String, Integer> string : list) {
			// 排除-与空格
			if (!(string.getKey().equals(""))
					&& !(string.getKey().equals("-"))) {
				// 换行"\r\n"不是"\n
				str.set(i, string.getKey());
				str.set(++i, string.getValue().toString());
				i++;
			}
	}
		return str;
	}
}
