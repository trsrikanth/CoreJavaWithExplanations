package glca.da.w1.d3.lab;

/*
 * Q5) Write a program to pass your friends names to a constructor. 
 * 		create a method sort which can group the names in ascending order based on 
 * 		the first letter of their names and return the sorted array. Print the sorted array.
 */
public class GroupNames {
	
//	1. declare array
	String[] friendsNames; 
	
//	2. create parameterized constructor and pass the array to variable friendsNames
	public GroupNames(String[] names) {
		friendsNames = names;
	}
	
//	3. create method sort()
	public String[] sort() {
		// create temporary variable
		String temp;
		
		// logic to group names in ascending order
		for(int i=friendsNames.length-1;i>0;i--) {
			for(int j = 0;j<i;j++) {
				char c1 = friendsNames[j].charAt(0);
				char c2 = friendsNames[j+1].charAt(0);
				
				if(c1>c2) {
					temp = friendsNames[j];
					friendsNames[j] = friendsNames[j+1];
					friendsNames[j+1] = temp;
				}
			}
		}
		
		return friendsNames;
	}
	
	public static void main(String[] args) {
		
//		1. create array of names
		String[] names = {"Zarina", "Sridhar", "Ramesh", "Anirudh", "Anirudh", "Raju", "Suresh", "Mukesh"};
		
//		2. create object and pass the names
		GroupNames groupNames = new GroupNames(names);
		
//		3. sort the names and capture the returned names
		names = groupNames.sort();
		
//		4. print the sorted names
		System.out.println("Array of names after sorting");
		for(int i = 0;i<names.length;i++) {
			System.out.println(names[i]);
		}
	}
}
