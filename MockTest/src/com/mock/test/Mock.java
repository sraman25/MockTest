package com.mock.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Mock {

	public static final String HIGH_SEV = "High";
	public static final String MEDIUM_SEV = "Medium";
	public static final String LOW_SEV = "Low";
	static Map<String, ExceptionType> exceptionMap = new HashMap<String, ExceptionType>();

	static {
		exceptionMap.put("IOException", new ExceptionType("IOException", 100, HIGH_SEV));
		exceptionMap.put("MemoryException", new ExceptionType("MemoryException", 110, HIGH_SEV));
		exceptionMap.put("ThreadAbortException", new ExceptionType("ThreadAbortException", 200, HIGH_SEV));
		exceptionMap.put("ResponseTimeoutException", new ExceptionType("ResponseTimeoutException", 300, LOW_SEV));
		exceptionMap.put("ParameterException", new ExceptionType("ParameterException", 301, LOW_SEV));
	}

	public static boolean isAnagram(String s1, String s2) {
		char[] c1 = s1.toCharArray();
		Arrays.sort(c1);
		char[] c2 = s2.toCharArray();
		Arrays.sort(c2);

		return Arrays.equals(c1, c2);

	}

	public static void main(String[] args) {
		
		
		
		
//		String line = "IOException|The file requested does not exist";
//		String key = line.substring(0, line.indexOf('|'));
//		String description = line.substring(line.indexOf('|'), line.length());
//		ExceptionType exceptionType = exceptionMap.get(key);
//		if (exceptionType != null)
//			System.out.println(exceptionType.getSeverity() + "|" + exceptionType.getErrorCode() + "|"
//					+ exceptionType.getExceptionType() + "|" + description);
//		// String line = "1001";
//		for (int index = 0; index < line.length(); index++) {
//			System.out.print(line.charAt(index) == '0' ? 1 : 0);
//		}

//		List<String> strings = Arrays.asList(new String[] { "one", "eno", "two","wot","man","sds","nam" });
//		List<List<String>> result = new ArrayList<List<String>>();
//
//		for (String s : strings) {
//			List<String> l = new ArrayList<String>();
//			boolean added = false;
//			for (List<String> l1 : result) {
//				if (isAnagram(l1.get(0), s)) {
//					l=l1;
//					l.add(s);
//					added = true;
//				}
//			}
//			if (!added) {
//				
//				l.add(s);
//				result.add(l);
// 			}
//			
//
//		}
//		System.out.println(result.toString());

	}

}

class ExceptionType {

	String exceptionType;
	int errorCode;
	String severity;

	public ExceptionType(String exceptionType, int errorCode, String severity) {
		super();
		this.exceptionType = exceptionType;
		this.errorCode = errorCode;
		this.severity = severity;
	}

	public String getExceptionType() {
		return exceptionType;
	}

	public void setExceptionType(String exceptionType) {
		this.exceptionType = exceptionType;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getSeverity() {
		return severity;
	}

	public void setSeverity(String severity) {
		this.severity = severity;
	}

}



class RainStorm extends Storm{


    public RainStorm(double eyeRadius, double eyePositionX, double eyePositionY) {
		 super(eyeRadius, eyePositionX, eyePositionY);
    }

    public boolean isInEyeOfTheStorm(double positionX, double positionY) {
        double distance = Math.sqrt(Math.pow(positionX - eyePositionX, 2) +
                                    Math.pow(positionY - eyePositionY, 2));
        return distance < eyeRadius;
    }

    public double amountOfRain() {
        return eyeRadius * 20;
    }

}

class SnowStorm extends Storm{
    

    private double amountOfSnow;

    public SnowStorm(double eyeRadius, double eyePositionX, double eyePositionY, double amountOfSnow) {
    	super(eyeRadius, eyePositionX, eyePositionY);
		this.amountOfSnow = amountOfSnow;
	}

	public double getAmountOfSnow() {
		return amountOfSnow;
	}
    
}


class Storm {
    protected double eyeRadius;
    protected double eyePositionX;
    protected double eyePositionY;
	
    
    public Storm(double eyeRadius, double eyePositionX, double eyePositionY) {
		this.eyeRadius = eyeRadius;
		this.eyePositionX = eyePositionX;
		this.eyePositionY = eyePositionY;
    }
    
	public double getEyeRadius() {
		return eyeRadius;
	}

	public double getEyePositionX() {
		return eyePositionX;
	}

	public double getEyePositionY() {
		return eyePositionY;
	}
	
	public boolean isInEyeOfTheStorm(double positionX, double positionY) {
        double distance = Math.sqrt(Math.pow(positionX - eyePositionX, 2) +
                                    Math.pow(positionY - eyePositionY, 2));
        return distance < eyeRadius;
    }
}
