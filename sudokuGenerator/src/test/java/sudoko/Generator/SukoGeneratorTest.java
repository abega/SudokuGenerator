package sudoko.Generator;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class SukoGeneratorTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public SukoGeneratorTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( SukoGeneratorTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testSudokuGenerator()
    {
        assertTrue( true );
    }
}
