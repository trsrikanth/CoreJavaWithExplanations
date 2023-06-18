package glca.da.w1.d3.selfpractice;

public class PrivateMain {

	public static void main(String[] args) {

		PrivateAccessModifierClass obj = new PrivateAccessModifierClass();
		
/*		the below line will throw error as we cannot access private 
		variables/methods from other classes. Hence proved.
*/
//		obj.id = 20;
		
//		we can access protected and public variables from other class of same package
//		if we try to do the same form a different package, we will get error.
		obj.name = "Hii";
		
//		we can have access to public variables from other packages also.
		obj.age = 20;
		
	}

}
