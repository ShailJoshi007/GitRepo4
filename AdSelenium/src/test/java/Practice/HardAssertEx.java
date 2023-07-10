package Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertEx {
	@Test
	public void m1()
	{
		//hard Assert
		System.out.println("Step1");
		String expData= "Qspider";
		String actData="Qspider";
		Assert.assertEquals(actData, expData);
		System.out.println("Step2");
		System.out.println("Step3");
	}
	
@Test
	public void m2()
	{
		//hard Assert
		System.out.println("Step4");
		Assert.assertEquals(true, true);
		System.out.println("Step5");
	}
}
