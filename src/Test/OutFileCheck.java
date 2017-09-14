package Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class OutFileCheck {
	
	public static void main(String argv[]){
	   String filePath = "./src/main/output.txt";
	   List list = readTxtFile(filePath);
	   String filePath2 = "./src/main/output3.txt";
	   List list2=readTxtFile(filePath2);
	   for(int i = 0; i < list.size(); i++) {
		   	if(!list2.contains(list.get(i))){
		   		System.out.println("the difference is:"+list.get(i));
			}else{
//				System.out.println("these two files are same");
			}
	   	}
	   }

	public static List readTxtFile(String filePath){
	     List list=new ArrayList();
	        try {
	                String encoding="GBK";
	                File file=new File(filePath);
	                if(file.isFile() && file.exists()){ 
	                    InputStreamReader read = new InputStreamReader(
	                    new FileInputStream(file),encoding);
	                    BufferedReader bufferedReader = new BufferedReader(read);
	                    String lineTxt = null;
	                    while((lineTxt = bufferedReader.readLine()) != null){                        
	                        list.add(lineTxt);
	                    }
	                    read.close();
	                }else{
	                	System.out.println("can not find the input.txt file");
	                }
	        } catch (Exception e) {
	            System.out.println("read file error");
	            e.printStackTrace();
	        }
	        return list;
	}     
	   
}
