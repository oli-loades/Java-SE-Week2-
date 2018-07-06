package Tests;

import org.junit.*;
import static code.OfflineExercises.*;

import static org.junit.Assert.*;

public class tests {
    @Test
    public void doubleCharTest(){
        assertEquals("TThhee",doubleChar("The"));
        assertEquals("",doubleChar(""));
    }

    @Test
    public void sandwichTest(){
        assertEquals("ham",getSandwich("breadhambread"));
        assertEquals("",getSandwich(""));
        assertEquals("",getSandwich("breadooo"));
    }

    @Test
    public void evenlySpacedTest(){
        assertEquals(true,evenlySpaced(4,6,2));
        assertEquals(true,evenlySpaced(2,4,6));
        assertEquals(false,evenlySpaced(22,46,9));
    }

    @Test
    public void nTwiceTest(){
        assertEquals("helo",nTwice("hello",2));
        assertEquals("Choate",nTwice("Chocolate",3));
        assertEquals("Ce",nTwice("Chocolate",1));
    }

    @Test
    public void endLyTest(){
        assertEquals(false,endsly("hello"));
        assertEquals(true,endsly("Chocolately"));
        assertEquals(false,endsly(""));
    }

    @Test
    public void cleanTest(){
        assertEquals("helo",stringClean("hello"));
        assertEquals("abc",stringClean("aabbcc"));
        assertEquals("",stringClean(""));
    }

    @Test
    public void fibonacciTest(){
        assertEquals(0,fibonacci(0));
        assertEquals(2,fibonacci(3));
        assertEquals(75025,fibonacci(25));
    }

    @Test
    public void bunnyTest(){
        assertEquals(0,bunnyEars(0));
        assertEquals(4,bunnyEars(2));
        assertEquals(50,bunnyEars(25));
    }

    @Test
    public void superBlockTest(){
        assertEquals(1,superBlock("abc"));
        assertEquals(2,superBlock("aabc"));
        assertEquals(3,superBlock("aabbbc"));
        assertEquals(0,superBlock(""));
    }

}
