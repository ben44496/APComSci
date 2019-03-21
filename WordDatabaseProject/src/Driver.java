import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Driver {

	public static void main(String[] args) {
		Driver d = new Driver();
		//d.testStringWithCount();
		d.testStringWithCountList();

	}
	/**
	 * Make some StringWithCounts and compare them.  
	 */
	private void testStringWithCount() {
		StringWithCount swc1 = new StringWithCount("help"),
						swc2 = new StringWithCount("heavy", 3),
						swc3 = new StringWithCount("howdy"),
						swc4 = new StringWithCount("high", 2),
						swc5 = new StringWithCount("hit",6),
						swc6 = new StringWithCount("help", 4);
		StringWithCount[] array = new StringWithCount[] {swc1, swc2,swc3,swc4,swc5,swc6};
		ArrayList<StringWithCount> list = 
				new ArrayList<StringWithCount>(Arrays.asList(array));
		System.out.println(list);
		
		StringWithCount.compareByAlpha();
		Collections.sort(list);
		System.out.println(list);
		compareThem(swc1, swc2, 0);
		compareThem(swc1, swc2, 1);
		compareThem(swc1, swc2, 2);
	
		// TODO: add in getter for the count and word from StringWithCount
		// then uncomment the lines below and test
		while(swc1.getCount() <= swc2.getCount()) {
			swc1.increment();
			System.out.println("Just incremented: "+swc1.getWord());
		}
		compareThem(swc1, swc2, 0);
		compareThem(swc1, swc2, 1);
		compareThem(swc1, swc2, 2);
		
	}
	private void compareThem(StringWithCount swc1, StringWithCount swc2, int type) {
		String msg = "Based on ";
		if(type == 0) {
			StringWithCount.compareByAlpha();
			msg+="alphabetical ";
		}
		else if(type == 1) {
			StringWithCount.compareByFrequency();
			msg+="frequency ";
		}
		else {
			StringWithCount.compareByLength();
			msg+="length ";
		}
		
		if(swc1.compareTo(swc2) > 0) {
			msg+=swc1 +" is bigger than "+swc2;
		}
		else if(swc1.compareTo(swc2) < 0) {
			msg+=swc2 +" is bigger than "+swc1;
		}
		else{
			msg+=swc1 +" is equal to "+swc2;
		}
		System.out.println(msg);
	}
	/**
	 * Make a StringWithCountList and add some Strings and test
	 * the other functionality of the List.
	 */
	private void testStringWithCountList() {
		StringWithCount swc1 = new StringWithCount("help"),
				swc2 = new StringWithCount("heavy", 3),
				swc3 = new StringWithCount("howdy"),
				swc4 = new StringWithCount("high", 2),
				swc5 = new StringWithCount("hit",6),
				swc6 = new StringWithCount("help", 4);
		StringWithCount[] array = new StringWithCount[] {swc1, swc2,swc3,swc4,swc5,swc6};
		ArrayList<StringWithCount> list =
				new ArrayList<StringWithCount>(Arrays.asList(array));
		System.out.println(list);
	}
}
