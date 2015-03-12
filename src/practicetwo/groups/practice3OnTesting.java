package practicetwo.groups;

import org.testng.annotations.Test;

public class practice3OnTesting {
	
	@Test(groups="groupsone")
	public void testgroup1(){
		System.out.println("test-----group1");
	}


	@Test(groups="groupstwo")
	public void testgroup2(){
		System.out.println("test-----group2");
	}
	

	@Test(groups="groupsthree")
	public void testgroup3(){
		System.out.println("test-----group3");
	}
	
	
}
