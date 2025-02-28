package conway;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
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
	@Before
	public void up() {
		System.out.println("inizio di un test-up");
		life.resetGrids();
	}

	@Test
	public void test1() {
		System.out.println("inizio test 1");
		cc.displayGrid();
		System.out.println("");
		
		/*
			da
		 * 0 0 0
		 * 1 1 1
		 * 0 0 0
		 * a
		 * 0 1 0
		 * 0 1 0
		 * 0 1 0
		 */
		life.switchCellState(1, 0);
		life.switchCellState(1, 1);
		life.switchCellState(1, 2);
		
		life.computeNextGen();
		//assert
		assertFalse(life.isCellAlive(0, 0));
		assertTrue(life.isCellAlive(0, 1));
		assertFalse(life.isCellAlive(0, 2));
		assertFalse(life.isCellAlive(1, 0));
		assertTrue(life.isCellAlive(1, 1));
		assertFalse(life.isCellAlive(1, 2));
		assertFalse(life.isCellAlive(2, 0));
		assertTrue(life.isCellAlive(2, 1));
		assertFalse(life.isCellAlive(2, 2));
		cc.displayGrid();
	}
	@Test
	public void test2() {
		System.out.println("inizio test 2");
		cc.displayGrid();
		System.out.println("");
		/*
			da
		 * 0 1 0
		 * 0 1 0
		 * 0 1 0
		 * a
		 * 0 0 0
		 * 1 1 1
		 * 0 0 0
		 */
		life.switchCellState(0, 1);
		life.switchCellState(1, 1);
		life.switchCellState(2, 1);
		
		life.computeNextGen();
		//assert
		assertFalse(life.isCellAlive(0, 0));
		assertFalse(life.isCellAlive(0, 1));
		assertFalse(life.isCellAlive(0, 2));
		assertTrue(life.isCellAlive(1, 0));
		assertTrue(life.isCellAlive(1, 1));
		assertTrue(life.isCellAlive(1, 2));
		assertFalse(life.isCellAlive(2, 0));
		assertFalse(life.isCellAlive(2, 1));
		assertFalse(life.isCellAlive(2, 2));
		cc.displayGrid();
	}
	@Test
	public void test3(){
		//calcolare fino alla seconda generazione
		System.out.println("inizio test 3");
		cc.displayGrid();
		System.out.println("");
		/*
			da
		 * 0 1 0
		 * 0 1 0
		 * 0 1 0
		 * a
		 * 0 0 0
		 * 1 1 1
		 * 0 0 0
		 * a
		 * 0 1 0
		 * 0 1 0
		 * 0 1 0
		 */
		life.switchCellState(0, 1);
		life.switchCellState(1, 1);
		life.switchCellState(2, 1);

		life.computeNextGen();
		//assert
		assertFalse(life.isCellAlive(0, 0));
		assertFalse(life.isCellAlive(0, 1));
		assertFalse(life.isCellAlive(0, 2));
		assertTrue(life.isCellAlive(1, 0));
		assertTrue(life.isCellAlive(1, 1));
		assertTrue(life.isCellAlive(1, 2));
		assertFalse(life.isCellAlive(2, 0));
		assertFalse(life.isCellAlive(2, 1));
		assertFalse(life.isCellAlive(2, 2));
		cc.displayGrid();
		System.out.println("");
		life.computeNextGen();
		//assert
		assertFalse(life.isCellAlive(0, 0));
		assertTrue(life.isCellAlive(0, 1));
		assertFalse(life.isCellAlive(0, 2));
		assertFalse(life.isCellAlive(1, 0));
		assertTrue(life.isCellAlive(1, 1));
		assertFalse(life.isCellAlive(1, 2));
		assertFalse(life.isCellAlive(2, 0));
		assertTrue(life.isCellAlive(2, 1));
		assertFalse(life.isCellAlive(2, 2));
		cc.displayGrid();

	}

	@Test
	public void oneCellDies(){
		System.out.println("inizio test oneCellDies");
		cc.displayGrid();
		System.out.println("");
		/*
			da
		 * 0 0 0
		 * 0 1 0
		 * 0 0 0
		 * a
		 * 0 0 0
		 * 0 0 0
		 * 0 0 0
		 */
		life.switchCellState(1, 1);
		life.computeNextGen();
		//assert
		assertFalse(life.isCellAlive(0, 0));
		assertFalse(life.isCellAlive(0, 1));
		assertFalse(life.isCellAlive(0, 2));
		assertFalse(life.isCellAlive(1, 0));
		assertFalse(life.isCellAlive(1, 1));
		assertFalse(life.isCellAlive(1, 2));
		assertFalse(life.isCellAlive(2, 0));
		assertFalse(life.isCellAlive(2, 1));
		assertFalse(life.isCellAlive(2, 2));
		cc.displayGrid();
	}
	@Test

	@After
	public void down() {
		System.out.println("FINE di un test-down\n");
	}
	

	
	@Test
	public void yyy() {
		System.out.println("ok yyy");
	}
}

//Con gradlew test, controllare - logs/apptest.log - build/reports/tests/test/index.html

