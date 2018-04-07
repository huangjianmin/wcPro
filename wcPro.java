package wcPro;
import wcPro.wordFre;
import  java.io.*; 
import  java.lang.*; 
import java.nio.file.Files; 
import java.nio.file.Path; 
import java.util.ArrayList; 
import java.util.HashSet; 
import java.util.Scanner;

public class wcPro {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String curPath=System.getProperty("user.dir");  
		Scanner s = new Scanner(System.in);  
		String name = s.nextLine();  
		
		s.close();
		if(name.indexOf(".txt")==-1)
		{
			System.out.println("文件不是以txt结尾");
		}
		else {
			//String name ="test2.txt";
			File file = new File(name);
			//String targetStr="";
			FileInputStream fis=new FileInputStream(file);
			byte[] inputStream=new byte[fis.available()];
			String targetStr="";
			while(fis.read(inputStream)!=-1) 
			{ 
				 targetStr=new String(inputStream,0,inputStream.length); 
			} 
			fis.close();
			//System.out.println(targetStr);
			wordFre mainFunction=new wordFre();
			//String saveData="";
			ArrayList<String> saveData=new ArrayList<String>();
			ArrayList<String> SaveData=new ArrayList<String>();
			SaveData=mainFunction.diviWord(targetStr);
			int i=0;
			/*while(i<saveData.size()-1) {
				
				System.out.println(saveData.get(i)+" "+saveData.get(++i));
				i++;
			}*/
			
			saveData=mainFunction.sort(SaveData);
			File outfile=new File("result.txt"); 
			PrintStream ps=new PrintStream(new FileOutputStream(outfile)); 
			i=0;
			while(i<saveData.size()-1) {
				String str=saveData.get(i)+" "+saveData.get(++i);
				System.out.println(str);
				ps.println(str); 
				i++;
			}
			ps.close();
		}
	}

}
