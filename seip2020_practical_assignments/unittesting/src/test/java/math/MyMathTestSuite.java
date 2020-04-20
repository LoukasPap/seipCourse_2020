package math;

/**
 * 
 * @author louka (loukas.pap@hotmail.gr)
 * @since April 2020
 */

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * A class used as a holder of the @RunWith and @Suite 
 * annotations, that include all test of the MyMath class.
 * 
 * @author loukas (loukas.pap@hotmail.gr)
 * April 2020
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({MyMathTest.class, MyMathFactorialParameterizedTest.class})
public class MyMathTestSuite {
	/*
	 * This class remains empty. Is used only as a holder 
	 * of the above annotations.
	 */
}
