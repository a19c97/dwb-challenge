package wsc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class WealthSimpleChallenge {

	public static void main(String[] args) throws IOException {

		String csvFile = "src/wsc/in.csv";
		//String csvFile = "in.csv";
		BufferedReader br = null;
		ArrayList<String> data = new ArrayList<String>();
		String l;

		try {

			br = new BufferedReader(new FileReader(csvFile));
			//line = br.readLine();
			//System.out.println(line);
			while ((l = br.readLine()) != null) {
				data.add(l);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		ArrayList<String> dates = new ArrayList<String>();
		for(String i: data){
			String[] line = i.split(",");
			dates.add(line[0]);
		}
		
		//Write output
		ArrayList<String> output = new ArrayList<String>();
		output.add(dates.get(0) + "," + "1000" + "\n");
		for(int i=1; i<dates.size()-1; i++){
			String outLine = dates.get(i) + "," + "0" + "\n";
			output.add(outLine);
		}
		output.add(dates.get(dates.size() - 1) + "," + "-1000");
		
		String outFile = "/Users/AChen/Documents/workspace/WSC/dwb-challenge/src/wsc/out.csv";
		BufferedWriter bw = new BufferedWriter(new FileWriter(outFile));
		for(String outputLine: output){
			bw.write(outputLine);
		}

	}
}
