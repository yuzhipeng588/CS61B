package enigma;

import static enigma.EnigmaException.*;

/**
 * Represents a permutation of a range of integers starting at 0 corresponding
 * to the characters of an alphabet.
 *
 * @author Zhipeng Yu
 */
class Permutation {

    /** Set this Permutation to that specified by CYCLES, a string in the
     *  form "(cccc) (cc) ..." where the c's are characters in ALPHABET, which
     *  is interpreted as a permutation in cycle notation.  Characters not
     *  included in any cycle map to themselves. Whitespace is ignored. */
    /**
     * Zhipeng Yu.
     */
    private char[] cc;
    /**
     * Zhipeng Yu.
     */
    private String cCycles;
    /**
     * Alphabet of this permutation.
     */
    private Alphabet _alphabet;

    /**
     * Zhipeng Yu.
     * @param alphabet al
     * @param cycles cy
     */
    Permutation(String cycles, Alphabet alphabet) {

        _alphabet = alphabet;
        if (cycles == null) {
            cCycles = "";
        } else {
            cc = cycles.toCharArray();
            cCycles = "";
            int from = 0;
            int end = 0;
            for (int i = 0; i < cycles.length(); i++) {
                if (i < cycles.length()) {
                    if (cc[i] == ' ') {
                        continue;
                    }
                    if (cc[i] == '(') {
                        from = i + 1;
                        continue;
                    }
                    if (cc[i] == ')') {
                        end = i;
                        addCycle(cycles.substring(from, end));
                    }
                } else {
                    char c = alphabet.toChar(i);
                    char[] ccc = {c};
                    addCycle(new String(ccc));
                }
            }

        }
    }

    /**
     * Add the cycle c0->c1->...->cm->c0 to the permutation, where CYCLE is
     * c0c1...cm.
     */
    private void addCycle(String cycle) {
        String ss = cycle.concat(cycle.substring(0, 1));
        cCycles = cCycles.concat(ss);
    }

    /**
     * Return the value of P modulo the size of this permutation.
     */
    final int wrap(int p) {
        int r = p % size();
        if (r < 0) {
            r += size();
        }
        return r;
    }

    /**
     * Returns the size of the alphabet I permute.
     */
    int size() {
        return _alphabet.size();
    }

    /**
     * Return the result of applying this permutation to P modulo the
     * alphabet size.
     */
    int permute(int p) {
        int q = 0;
        p = wrap(p);
        char[] cc1 = new char[1];
        cc1[0] = _alphabet.toChar(p);
        if (cCycles.contains(new String(cc1))) {
            q = cCycles.indexOf(cc1[0]) + 1;
        } else {
            return _alphabet.toInt(cc1[0]);
        }
        return _alphabet.toInt(cCycles.charAt(q));
    }

    /**
     * Return the result of applying the inverse of this permutation
     * to  C modulo the alphabet size.
     */
    int invert(int c) {
        int q = 0;
        c = wrap(c);
        char[] cc1 = new char[1];
        cc1[0] = _alphabet.toChar(c);
        if (cCycles.contains(new String(cc1))) {
            q = cCycles.lastIndexOf(cc1[0]) - 1;
        } else {
            return _alphabet.toInt(cc1[0]);
        }
        return _alphabet.toInt(cCycles.charAt(q));
    }

    /**
     * Return the result of applying this permutation to the index of P
     * in ALPHABET, and converting the result to a character of ALPHABET.
     */
    char permute(char p) {
        int a = _alphabet.toInt(p);
        int b = permute(a);
        return _alphabet.toChar(b);
    }

    /**
     * Return the result of applying the inverse of this permutation to C.
     */
    int invert(char c) {
        int a = _alphabet.toInt(c);
        int b = permute(a);
        return _alphabet.toChar(b);
    }

    /**
     * Return the alphabet used to initialize this Permutation.
     */
    Alphabet alphabet() {
        return _alphabet;
    }

    /**
     * Return true iff this permutation is a derangement (i.e., a
     * permutation for which no value maps to itself).
     */
    boolean derangement() {
        char[] cc1 = cCycles.toCharArray();
        for (int i = 0; i < cc1.length - 1; i++) {
            if (cc1[i] == cc1[i + 1]) {
                return false;
            }
        }
        return true;
    }


}

