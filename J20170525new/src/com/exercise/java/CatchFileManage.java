package com.exercise.java;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CatchFileManage {
	
	
	public String getCatchFromLocalFile(String path){
		String count = "";
		File countFile = new File(path);
		
		if(!countFile.exists()){
			count = "0";
			return count;
		}else{
			try {
				BufferedReader br = new BufferedReader(new FileReader(countFile));
				count = br.readLine();
				br.close();
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return count;
	}
	
	public void updataCatchToFile(String path, String count){
		File countFile = new File(path);
		BufferedWriter bw;
		try {
			bw = new BufferedWriter(new FileWriter(countFile));
			bw.write(count);
			bw.flush();
			bw.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}
