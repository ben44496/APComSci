import java.util.ArrayList;
import java.util.List;

/**
 * This class uses a List to store its StringWithCounts.
 * As we are adding to this List, it's a good idea to keep 
 * it in alphabetical order (makes searching easier).  Why?
 * 
 * 
 * 
 * @author RHanson
 *
 */
public class StringWithCountList {

	private List<StringWithCount> list;
	
	/**
	 * Adds the String to this StringWithCountList.  Uses the following
	 * algorithm:
	 * 1.  If the String is already in this List, the counter is incremented
	 * 2.  If the String is new to this List, then a new StringWithCount is created
	 *     with a count of 1 and it is then inserted into the List at an appropriate position.
	 *     
	 * @param s the String to add
	 */
	public void add(String s) {
		int half = list.size()/2;
		StringWithCount sw = new StringWithCount(s);
		//has to find the string in the list and add one.
		if (indexOf(s)!=-1) list.get(indexOf(s)).increment();
		else list.add(sw);
		binarySort();

	}
	/**
	 * This method finds the position in this List that contains
	 * the specified String.  It returns a negative number if it couldn't
	 * be found
	 * @param s  String we are searching for
	 * @return position in the List where it can be located, or a negative number
	 * related to the location where the String would be if it were in the List
	 */
	public int indexOf(String s) {
		int i=0;
		while (!s.equals(list.get(i))){
			i++;
		}
		return -1;
	}
	
	public int size() {
		return list.size();
	}
	/**
	 * This returns a new list with references to the same objects
	 * as are contains in this List.  If you make changes to the order
	 * of the cloned list, it doesn't change the order of this List.
	 */
	public List<StringWithCount> clone(){
		return new ArrayList(list);
	}
	public void binarySort(){

	}
}
