package jedis.test;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

import org.junit.jupiter.api.Test;

public class Testss {
	
	/*
	 * 
	 * 找出字符串中出现最多的字母和次数
	 * 
	 * */
	@Test
	public class FindMax {
		
	    String chars = "aabbccdda";
	    String result = findMax(chars);
	    System.out.println(result);
	}
	
	
	public static String findMax(String str){
        char[] chars = str.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        for(char i : chars){
            if(map.get(i)==null){
                map.put(i, 1);
            } else {
                int num =map.get(i);
                num++;
                map.put(i, num);
            }
        }
        LinkedList<Object[]> list =new LinkedList<Object[]>();
        for(Iterator<Character> iterator = map.keySet().iterator();iterator.hasNext();){
            Object[] arr = new Object[2];
            char charac = iterator.next();
            int num = map.get(charac);
            arr[0] = charac;
            arr[1] = num;
            list.add(arr);
        }

        int first = (Integer)list.get(0)[1];
        for(int j=1;j<list.size();j++){
            int second = (Integer)list.get(j)[1];
            if(first < second){
                Object[] bb = list.get(j);
                list.remove(0);
                list.add(0, bb);
            }
        }
        String ss = "出现次数最多的字母是：" + list.get(0)[0].toString() + ",出现次数是：" + list.get(0)[1].toString();
        return ss;
    }
	
	public static void main(String[] args) {
		/*try {
			ServerSocket serverSocket =new ServerSocket (8080);
			Socket client =  serverSocket.accept();
			//PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(client.getOutputStream())));
			//writer.close();
            //writer.println（“Welcome！”）

		} catch (Exception e) {
			// TODO: handle exception
		}*/
	}

}
