package enigma;

import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.Timeout;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;

import static enigma.TestUtils.*;

/**
 * The suite of all JUnit tests for the Permutation class.
 *
 * @author
 */
public class MovingRotorTest {

    /**
     * Testing time limit.
     */
    @Rule
    public Timeout globalTimeout = Timeout.seconds(5);

    /* ***** TESTING UTILITIES ***** */

    private Rotor rotor;
    /**
     * Zhipeng Yu.
     */
    private Rotor rotor2;
    /**
     * Zhipeng Yu.
     */
    private Rotor rotor3;
    /**
     * Zhipeng Yu.
     */
    private Rotor rotor4;
    /**
     * Zhipeng Yu.
     */
    private Rotor rotor5;
    /**
     * Zhipeng Yu.
     */
    private String alpha = UPPER_STRING;

    /**
     * Check that rotor has an alphabet whose size is that of
     * FROMALPHA and TOALPHA and that maps each character of
     * FROMALPHA to the corresponding character of FROMALPHA, and
     * vice-versa. TESTID is used in error messages.
     */
    private void checkRotor(String testId,
                            String fromAlpha, String toAlpha) {
        int N = fromAlpha.length();
        assertEquals(testId + " (wrong length)", N, rotor.size());
        for (int i = 0; i < N; i += 1) {
            char c = fromAlpha.charAt(i), e = toAlpha.charAt(i);
            int ci = alpha.indexOf(c), ei = alpha.indexOf(e);
            assertEquals(msg(testId, "wrong translation of %d (%c)", ci, c),
                    ei, rotor.convertForward(ci));
            assertEquals(msg(testId, "wrong inverse of %d (%c)", ei, e),
                    ci, rotor.convertBackward(ei));
        }
    }

    /**
     * Set the rotor to the one with given NAME and permutation as
     * specified by the NAME entry in ROTORS, with given NOTCHES.
     */
    private void setRotor(String name, HashMap<String, String> rotors,
                          String notches) {
        rotor = new MovingRotor(name, new Permutation(rotors.get(name), UPPER),
                notches);
    }

    /* ***** TESTS ***** */

    @Test
    public void checkRotorAtA() {
        setRotor("I", NAVALA, "");
        checkRotor("Rotor I (A)", UPPER_STRING, NAVALA_MAP.get("I"));
    }

    @Test
    public void checkRotorAdvance() {
        setRotor("I", NAVALA, "");
        rotor.advance();
        checkRotor("Rotor I advanced", UPPER_STRING, NAVALB_MAP.get("I"));
    }

    @Test
    public void checkRotorSet() {
        setRotor("I", NAVALA, "");
        rotor.set(25);
        checkRotor("Rotor I set", UPPER_STRING, NAVALZ_MAP.get("I"));
    }

    /**
     * Zhipeng Yu
     */
    @Test
    public void testMachine1() {
        setRotor("I", NAVALA, "Y");

        ArrayList<Rotor> allRotors1 = new ArrayList<Rotor>();
        allRotors1.add(rotor);
        Machine mac1 = new Machine(new UpperCaseAlphabet(), 1, 1, allRotors1);
        int t1 = mac1.convert(0);
        assertEquals(0, t1);
    }
    /**
     * Zhipeng Yu.
     */
    @Test
    public void testMachine2() {

        rotor2 = new MovingRotor("II", new Permutation(NAVALA.get("II"),
                UPPER), "A");
        setRotor("I", NAVALA, "A");
        ArrayList<Rotor> allRotors2 = new ArrayList<Rotor>();
        allRotors2.add(rotor2);
        allRotors2.add(rotor);
        Machine mac2 = new Machine(new UpperCaseAlphabet(),
                2, 2, allRotors2);
        int t2 = mac2.convert(0);
        assertEquals(0, t2);
    }

    /**
     * Zhipeng Yu.
     */
    @Test
    public void testMachine3() {

        rotor2 = new MovingRotor("I",
                new Permutation(NAVALA.get("I"), UPPER), "A");
        rotor3 = new MovingRotor("I",
                new Permutation(NAVALA.get("I"), UPPER), "B");
        rotor4 = new FixedRotor("Beta",
                new Permutation(NAVALA.get("Beta"), UPPER));
        rotor5 = new Reflector("B",
                new Permutation(NAVALA.get("B"), UPPER));
        setRotor("I", NAVALA, "C");
        ArrayList<Rotor> allRotors4 = new ArrayList<Rotor>();
        allRotors4.add(rotor5);
        allRotors4.add(rotor4);
        allRotors4.add(rotor3);
        allRotors4.add(rotor2);
        allRotors4.add(rotor);
        Machine mac4 = new Machine(new UpperCaseAlphabet(),
                5, 3, allRotors4);
        int t4 = mac4.convert(0);
        assertEquals(14, t4);
    }
}
