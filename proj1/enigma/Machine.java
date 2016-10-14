package enigma;


import java.util.ArrayList;

import java.util.Collection;

import static enigma.EnigmaException.*;

/**
 * Class that represents a complete enigma machine.
 *
 * @author Zhipeng Yu
 */
class Machine {

    /**
     * Common alphabet of my rotors.
     */
    private final Alphabet _alphabet;
    /**
     * Zhipeng Yu.
     */
    private int numRotorss;
    /**
     * Zhipeng Yu.
     */
    private int numPawls;
    /**
     * Zhipeng Yu.
     */
    private ArrayList<Rotor> rRotors;
    /**
     * Zhipeng Yu.
     */
    private Permutation plugboardd;

    /**
     * A new Enigma machine with alphabet ALPHA, 1 < NUMROTORS rotor slots,
     * and 0 <= PAWLS < NUMROTORS pawls.  ALLROTORS contains all the
     * available rotors.
     */
    Machine(Alphabet alpha, int numRotors, int pawls,
            Collection<Rotor> allRotors) {
        _alphabet = alpha;
        this.numRotorss = numRotors;
        this.numPawls = pawls;
        this.rRotors = new ArrayList<Rotor>(allRotors);

    }

    /**
     * Return the number of rotor slots I have.
     */
    int numRotors() {
        /**
         * Zhipeng Yu.
         */
        return numRotorss;

    }

    /**
     * Return the number pawls (and thus rotating rotors) I have.
     */
    int numPawls() {
        /**
         * Zhipeng Yu.
         */
        return numPawls;

    }

    /**
     * Set my rotor slots to the rotors named ROTORS from my set of
     * available rotors (ROTORS[0] names the reflector).
     * Initially, all rotors are set at their 0 setting.
     */
    void insertRotors(String[] rotors) {

    }

    /**
     * Set my rotors according to SETTING, which must be a string of four
     * upper-case letters. The first letter refers to the leftmost
     * rotor setting (not counting the reflector).
     */
    void setRotors(String setting) {

        char[] pos = setting.toCharArray();
        for (int i = 0; i < pos.length; i++) {
            rRotors.get(i).set(pos[i]);
        }

    }

    /**
     * Set the plugboard to PLUGBOARD.
     */
    void setPlugboard(Permutation plugboard) {
        /**
         * Zhipeng Yu.
         */
        this.plugboardd = plugboard;

    }

    /**
     * Returns the result of converting the input character C (as an
     * index in the range 0..alphabet size - 1), after first advancing
     * the machine.
     */
    int convert(int c) {
        c = plugboardd.permute(c);
        for (int i = 0; i < rRotors.size(); i++) {
            if (i == rRotors.size() - 1) {
                rRotors.get(i).advance();
                break;
            }
            if (rRotors.get(i).atNotch() || rRotors.get(i + 1).atNotch()) {
                rRotors.get(i).advance();
            }
        }
        for (int j = rRotors.size() - 1; j >= 0; j--) {
            c = rRotors.get(j).convertForward(c);
        }
        for (int i = 1; i < rRotors.size(); i++) {
            c = rRotors.get(i).convertBackward(c);
        }
        c = plugboardd.permute(c);
        return c;

    }

    /**
     * Returns the encoding/decoding of MSG, updating the state of
     * the rotors accordingly.
     */
    String convert(String msg) {
        /**
         * Zhipeng Yu.
         */
        char[] cc = msg.toCharArray();
        for (int i = 0; i < cc.length; i++) {
            if (cc[i] == ' ') {
                continue;
            }
            int c = _alphabet.toInt(cc[i]);
            c = convert(c);
            cc[i] = _alphabet.toChar(c);
        }

        return new String(cc);

    }


}
