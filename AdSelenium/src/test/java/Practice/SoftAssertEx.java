package Practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertEx {
	
	@Test
	public void m1()
	{
		
		//Soft Assert
		System.out.println("Step1");
		System.out.println("Step2");
		System.out.println("Step3");
	
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(false, true);
		System.out.println("Step4");
		System.out.println("Step5");
		soft.assertAll();
	}
	
	@Test
	public void m2()
	{
		//Soft Assert
		String expData= "Qspider";
		String actData="qspider";
		
		SoftAssert soft = new SoftAssert();
		System.out.println("Step6");
		soft.assertEquals(actData, expData);
		soft.assertAll();
		//System.out.println("Step7");
	}

}
