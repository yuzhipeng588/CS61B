package enigma;

import static enigma.EnigmaException.*;

/**
 * Class that represents a reflector in the enigma.
 *
 * @author Zhipeng Yu
 */
class Reflector extends FixedRotor {

    /**
     * Zhipeng Yu.
     */
    private int position;
    /**
     * Zhipeng Yu.
     */
    private int notch;

    /**
     * A non-moving rotor named NAME whose permutation at the 0 setting
     * is PERM.
     */
    Reflector(String name, Permutation perm) {
        super(name, perm);
        position = 0;

    }

    /**
     * Zhipeng Yu.
     */
    @Override
    /** Reflector's advance() does nothing. */
    void advance() {
    }

    @Override
    /** Reflector's Backward() doesn't change signal.*/
    int convertBackward(int e) {
        return e;
    }

    /**
     * Zhipeng Yu.
     */


    @Override
    void set(int posn) {
        if (posn != 0) {
            throw error("reflector has only one position");
        }
    }


}
