package enigma;

import static enigma.EnigmaException.*;

/**
 * Class that represents a rotating rotor in the enigma machine.
 *
 * @author Zhipeng Yu
 */
class MovingRotor extends Rotor {

    /**
     * position for MovingRotor.
     */
    private int position;
    /**
     * _permutation for MovingRotor.
     */
    private Permutation _permutation;
    /**
     * Zhipeng Yu.
     */
    private int notch;
    /**
     * Zhipeng Yu.
     */
    public static final int MAX_SIZE = 25;

    /**
     * A rotor named NAME whose permutation in its default setting is
     * PERM, and whose notches are at the positions indicated in NOTCHES.
     * The Rotor is initally in its 0 setting (first character of its
     * alphabet).
     */
    MovingRotor(String name, Permutation perm, String notches) {
        super(name, perm);
        _permutation = perm;
        notch = _permutation.alphabet().toInt(notches.charAt(0));
        position = 0;

    }

    /**
     * Zhipeng Yu.
     */
    @Override
    void advance() {
        if (position == MAX_SIZE) {
            position = 0;
        } else {
            position = position + 1;
        }
    }

    @Override
    /** Return the conversion of P (an integer in the range 0..size()-1)
     *  according to my permutation cosidering about position. */
    int convertForward(int p) {
        p = _permutation.wrap(position + p);
        p = _permutation.permute(p);
        p = _permutation.wrap(p - position);
        return p;
    }
    /**
     * Zhipeng Yu.
     */

    @Override
    /** Return the conversion of E (an integer in the range 0..size()-1)
     *  according to the inverse of my permutation cosidering about position. */
    int convertBackward(int e) {
        e = _permutation.wrap(e + position);
        e = _permutation.invert(e);
        e = _permutation.wrap(e - position);
        return e;
    }


    /**
     * Set setting() to POSN. for moving Rotor
     */
    @Override
    void set(int posn) {
        position = posn;
    }

    /**
     * Set setting() to character CPOSN. for moving Rotor
     */
    @Override
    void set(char cposn) {
        position = _permutation.alphabet().toInt(cposn);
    }

    /**
     * Returns true iff I am positioned to allow the rotor to my left
     * to advance.
     */
    @Override
    boolean atNotch() {
        return position == notch;
    }


}
