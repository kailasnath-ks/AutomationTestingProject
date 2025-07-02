package MavenTestNg;

import org.testng.annotations.Test;

public class priority {


@Test(priority=3)
public void startthecar() {
	System.out.println(" start the car");
	
}

@Test(priority=1)
public void putfirstgear() {
	System.out.println(" first gear");
	
}
@Test(priority=2)
public void putsecondgear() {
	System.out.println(" second gear");
	
}
@Test(priority=0)
public void putthirdgear() {
	System.out.println(" third gear");
	
}


}