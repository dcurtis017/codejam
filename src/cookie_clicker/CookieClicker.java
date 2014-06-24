package cookie_clicker;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

import codejam.InputOutput;

public class CookieClicker {

	private static final double COOKIES_PER_SECOND = 2.0;
	
	public double findCookieCount(double cookiesGoal, double farmCost, double extraCookiesPerFarm)
	{
		double runningTimer = cookiesGoal/COOKIES_PER_SECOND;
		double proposedTimer = 0.0;
		int sanity = 0;
		double cookieProduction = 0.0;//
		boolean cont = true;
		double numFarms = 1.0;
		while(cont)
		{	
			cookieProduction = (COOKIES_PER_SECOND+(numFarms*extraCookiesPerFarm));
			proposedTimer =  cookiesGoal/cookieProduction;
			for(double i = numFarms; i > 0.0; --i)
			{
				proposedTimer+=(farmCost/(COOKIES_PER_SECOND+((i-1.0)*extraCookiesPerFarm)));
			}
			if(proposedTimer > runningTimer){
				return runningTimer;
			}else{
				runningTimer = proposedTimer;
			}
			++numFarms;
			++sanity;
			if(sanity > 10000)
			{
				cont = false;
			}
		}
		return -1.00;
	}
	
	
	
	public static void main(String[] args)
	{
		CookieClicker cc = new CookieClicker();
		InputOutput io = new InputOutput();
		ArrayList<String> lines = io.loadInputFile("c:\\eclipse-workspace\\codejam\\src\\cookie_clicker\\io_files\\B-large-practice.in");
		List<String> parts;
		int numCases = Integer.parseInt(lines.get(0));
		int offset = 0;
		ArrayList<String> output = new ArrayList<String>();
		DecimalFormat formatter = new DecimalFormat("#0.0000000");
		System.out.println("Starting...");
		for(int i = 1; i <= numCases; ++i){
			System.out.println("Test Case "+i);
			parts = Arrays.asList(lines.get(i).split(" "));
			output.add("Case #"+i+": "+formatter.format(cc.findCookieCount(Double.parseDouble(parts.get(2)),Double.parseDouble(parts.get(0)),Double.parseDouble(parts.get(1)))));
		}
		System.out.println(io.writeOutputFile("c:\\eclipse-workspace\\codejam\\src\\cookie_clicker\\io_files\\B-large-practice.out", output));
		System.out.println("Finished...");
	}
}
