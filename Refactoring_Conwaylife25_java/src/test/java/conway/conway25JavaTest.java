package conway;


import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

import conway.devices.ConwayInputMock;

//By default, JUnit comes with a bundled copy of hamcrest-core

public class conway25JavaTest {
private static ConwayInputMock cim;

private static Life life;
private static LifeController cc;

@BeforeClass
public static void setup() {
	System.out.println("inizio setup");
	
	life = new Life( 3,3 );
    cc = new LifeController(life);
}

	@Test
	public void test1() {
		System.out.println("inizio test 1");
		cc.displayGrid();
		
		life.switchCellState(1, 0);
		life.switchCellState(1, 1);
		life.switchCellState(1, 2);
		
		life.computeNextGen();
		
		cc.displayGrid();
	}
	@After
	public void down() {
		System.out.println("down");
	}
	

	
	@Test
	public void yyy() {
		System.out.println("ok yyy");
	}
}

//Con gradlew test, controllare - logs/apptest.log - build/reports/tests/test/index.html

