package MavenTestNg;

import org.testng.annotations.Test;

public class SkipTest {
	@Test(priority=0)
	public void startthecar() {
	System.out.println(" start the car");
	
}
@Test(priority=4,enabled=false)
public void turnthemusicon() {
	System.out.println(" music turned on");
}

@Test(priority=1)
public void putfirstgear() {
	System.out.println(" first gear");
	
	
}
@Test(priority=2)
public void putsecondgear() {
	System.out.println(" second gear");
	
}
@Test(priority=3)
public void putthirdgear() {
	System.out.println(" third gear");
}
}
