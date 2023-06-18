//package name
package glca.da.w1.d3.lab;

/* Q2.b) In the Table class create a parameterized constructor accepting two 
 * values multiplicand  and range of multiplier and print the table.
 */
public class Table {

//	1. create a parameterized constructor accepting two values
	public Table(int multiplicand, int multiplier){
		
//		2. print the table till the given multiplier.
		for(int i=1;i<=multiplier;i++) {
			System.out.println(multiplicand +" x "+i+" = "+(multiplicand*i));
		}
	}
	
}
