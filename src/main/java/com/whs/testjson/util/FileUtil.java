package com.whs.testjson.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Iterator;
import java.util.List;

public class FileUtil {
	
	public static String readContent( String fileName ) {
		FileReader fr = null;
		BufferedReader br = null;
		StringBuffer sb = new StringBuffer();
		try {
			fr = new FileReader(new File(fileName));
			br = new BufferedReader(fr);
			String line = null;
			while( (line=br.readLine()) != null ) {
				sb.append(line);
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {br.close();}catch(Exception e) {}
			try {fr.close();}catch(Exception e) {}
		}
		return sb.toString();
	}
	
	public static void writeContent(List<String> list, String fileName, boolean append) {
		FileWriter fw = null;
		BufferedWriter bw = null;
		StringBuffer sb = new StringBuffer();
		try {
			fw = new FileWriter(new File(fileName),append);
			bw = new BufferedWriter(fw);
			for( int i = 0; i < list.size(); i++ ){
				bw.write(list.get(i));
				if( i > 0 && i % 1000 == 0 )
					bw.flush();
			}
			bw.flush();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {bw.close();}catch(Exception e) {}
			try {fw.close();}catch(Exception e) {}
		}
	}
	
	public static boolean delete( String fileName ) {
		boolean ret = false;
		ret = new File(fileName).delete();
		if( !ret )
			new File(fileName).deleteOnExit();
		return ret;
	}
}
