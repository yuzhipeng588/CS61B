package enigma;
import static enigma.EnigmaException.*;

/* Extra Credit Only */

/**
 * An alphabet of encodable characters.  Provides a mapping from characters
 * to and from indices into the alphabet.
 *
 * @author Zhipeng Yu
 */
class Alphabet {

    /** A new alphabet containing CHARS.  Character number #k has index
     *  K (numbering from 0). No character may be duplicated. */
    /**
     * Zhipeng Yu.
     */
    private String sS;

    /**
     *  @param chars chars
    */
    Alphabet(String chars) {

        sS = chars;

    }

    /**
     * Returns the size of the alphabet.
     */
    int size() {

        return sS.length();


    }

    /**
     * Returns true if C is in this alphabet.
     */
    boolean contains(char c) {
        /**
         * Zhipeng Yu.
         */
        char[] cc = new char[1];
        cc[0] = c;
        return sS.contains(new String(cc));

    }

    /**
     * Returns character number INDEX in the alphabet, where
     * 0 <= INDEX < size().
     */
    char toChar(int index) {
        /**
         * Zhipeng Yu.
         */
        if (index >= 0 && index < size()) {
            return sS.charAt(index);
        } else {
            return 0;
        }

    }

    /**
     * Returns the index of character C, which must be in the alphabet.
     */
    int toInt(char c) {
        /**
         * Zhipeng Yu.
         */
        if (contains(c)) {
            return sS.indexOf(c);
        } else {
            return -1;
        }
    }
}
