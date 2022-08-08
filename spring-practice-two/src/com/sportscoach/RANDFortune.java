package com.sportscoach;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RANDFortune implements FortuneService {

	@Override
	public String getFortune() {
		ArrayList<String> fortuneList = new ArrayList<String>();
		try {
			File file = new File("./src/Fortunes.txt");
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String tempLine;
			while ((tempLine = bufferedReader.readLine()) != null) {
				fortuneList.add(tempLine);
			}
			bufferedReader.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		Random random = new Random();
		return fortuneList.get(random.nextInt(fortuneList.size()-1));
	}
	
}
