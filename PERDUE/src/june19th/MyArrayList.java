package june19th;

import java.util.ArrayList;
import java.util.Arrays;

public class MyArrayList {
	private String[] strings;
	private int size;

	public MyArrayList() {
		strings = new String[10];
		size = 0;
	}

	public String get(int i) {
		return strings[i];
	}

	public void set(int i, String s) {
		strings[i] = s;
	}

	public void add(String string) {
		if (size >= strings.length)
			reallocate();

		strings[size++] = string;
	}

	private void reallocate() {
		String[] new_strings = Arrays.copyOf(strings, strings.length*2);
		for (int i = 0; i < strings.length; i++) {
			new_strings[i] = strings[i];
		}
		strings = new_strings;
	}

	public static void main(String[] args) {
		ArrayList<String> myList = new ArrayList<String>();
		for (char a = 65; a < 91; a++) {
		    if (a % 3 == 1)
		        myList.add(0,"" + a);
		    else
		        myList.add("" + a);
		}
		String x = myList.get(2);
		String y = myList.remove(10);
		String z = myList.set(15,x);
		System.out.println(x+y+z);
		
	}
}
