package enigma;

import static enigma.EnigmaException.*;

/**
 * Class that represents a rotor that has no ratchet and does not advance.
 *
 * @author Zhipeng Yu
 */
class FixedRotor extends Rotor {

    /** A non-moving rotor named NAME whose permutation at the 0 setting
     * is given by PERM. */
    /**
     * Zhipeng Yu.
     */
    private int position;
    /**
     *  _permutation.
     */
    private Permutation _permutation;

    /**
     *  @param name name
     *  @param  perm perm
     */
    FixedRotor(String name, Permutation perm) {
        super(name, perm);
        position = 0;
        _permutation = perm;
    }

    /**
     * Zhipeng Yu.
     */
    @Override
    void advance() {
    }

    @Override
    /** Return the conversion of P (an integer in the range 0..size()-1)
     *  according to my permutation cosidering about position. */
    int convertForward(int p) {
        /**
         * Zhipeng Yu.
         */
        p = _permutation.wrap(position + p);
        p = _permutation.permute(p);
        p = _permutation.wrap(p - position);
        return p;
    }

    @Override
    /** Return the conversion of E (an integer in the range 0..size()-1)
     *  according to the inverse of my permutation cosidering about position. */
    int convertBackward(int e) {
        /**
         * Zhipeng Yu.
         */
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
        /**
         * Zhipeng Yu.
         */
        position = posn;

    }

    /**
     * Set setting() to character CPOSN. for moving Rotor
     */
    @Override
    void set(char cposn) {
        /**
         * Zhipeng Yu.
         */
        position = _permutation.alphabet().toInt(cposn);

    }

}
