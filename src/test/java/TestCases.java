import static org.junit.Assert.*;
import org.junit.*;
import test.Addition;

public class TestCases {

    @BeforeClass
    public static void setUpBeforeAllTests(){
        System.out.println("set up before all test is running");
    }
    @Before
    public void setUpBeforeTest(){
        System.out.println("set up before any test is running");
    }
    @Test
    public void testCaseSum() {
        Addition addition = new Addition();
        int actual = addition.mySum(5, 6);
        int expected = 11;
        assertEquals(actual, expected);
        System.out.println("executed");

    }
    @Test
    public void testAddition(){
        int [] array = new int[]{-1,-3,6};
        int expected = 6;
        int actual = Addition.myMax(array);
 //       assertFalse(array==null);
        assertEquals(-1,Addition.myMax(new int[]{-12,-1,-3,-4,-2}));
        assertEquals(expected,actual);
    }
    @Test
    public  void testReverseWord(){
        String x = "ghazal";
        String expected = "aazahg";
        String y = "abc";
        String expected2 = "bac";
        assertEquals(expected,Addition.reverseWord(x));
        assertEquals(expected2,Addition.reverseWord(y));
    }

    @After
    public void setUpAfterTest(){
        System.out.println("set up after any test is running");
    }
    @AfterClass
    public static void setUpAfterAllTest(){
        System.out.println("set up after all test is running");
    }

}
