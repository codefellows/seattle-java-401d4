/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package demo;

import org.junit.Test;
import static org.junit.Assert.*;

public class LibraryTest {
    @Test public void testAddTwo() {
        Library classUnderTest = new Library();
        assertEquals("adding two to two should give four", 4, classUnderTest.addTwo(2));
    }
}