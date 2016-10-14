package enigma;

import java.io.File;

import java.io.IOException;
import java.io.PrintStream;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

import static enigma.EnigmaException.*;

/**
 * Enigma simulator.
 *
 * @author Zhipeng Yu
 */
public final class Main {

    /**
     * Alphabet used in this machine.
     */
    private Alphabet _alphabet;
    /**
     * Source of input messages.
     */
    private Scanner _input;
    /**
     * Source of machine configuration.
     */
    private Scanner _config;
    /**
     * File for encoded/decoded messages.
     */
    private PrintStream _output;
    /**
     * Zhipeng Yu.
     */
    private String[] rRotorsName;
    /**
     * Zhipeng Yu.
     */
    private String rRotorspos;
    /**
     * Zhipeng Yu.
     */
    private String message;
    /**
     * Zhipeng Yu.
     */
    private String[] permutations;
    /**
     * Zhipeng Yu.
     */
    private String notches;
    /**
     * Zhipeng Yu.
     */
    private Machine machine;
    /**
     * Zhipeng Yu.
     */
    private int numrotors;
    /**
     * Zhipeng Yu.
     */
    private int numreflector;
    /**
     * Zhipeng Yu.
     */
    private int numfixed;
    /**
     * Zhipeng Yu.
     */
    private int nummoving;
    /**
     * Zhipeng Yu.
     */
    private String plugboard;
    /**
     * Zhipeng Yu.
     */
    private String config;

    /**
     * Check ARGS and open the necessary files (see comment on main).
     */
    Main(String[] args) {

        if (args.length < 1 || args.length > 3) {
            throw error("Only 1, 2, or 3 command-line arguments allowed");
        }
        _config = getInput(args[0]);
        if (args.length > 1) {
            _input = getInput(args[1]);

        } else {
            _input = new Scanner(System.in);
        }
        if (args.length > 2) {
            _output = getOutput(args[2]);
        } else {
            _output = System.out;
        }
    }

    /**
     * Process a sequence of encryptions and decryptions, as
     * specified by ARGS, where 1 <= ARGS.length <= 3.
     * ARGS[0] is the name of a configuration file.
     * ARGS[1] is optional; when present, it names an input file
     * containing messages.  Otherwise, input comes from the standard
     * input.  ARGS[2] is optional; when present, it names an output
     * file for processed messages.  Otherwise, output goes to the
     * standard output. Exits normally if there are no errors in the input;
     * otherwise with code 1.
     */
    public static void main(String... args) {
        try {
            new Main(args).process();
            return;
        } catch (EnigmaException excp) {
            System.err.printf("Error: %s%n", excp.getMessage());
        }
        System.exit(1);
    }

    /**
     * Return a Scanner reading from the file named NAME.
     */
    private Scanner getInput(String name) {
        try {
            return new Scanner(new File(name));
        } catch (IOException excp) {
            throw error("could not open %s", name);
        }
    }

    /**
     * Return a PrintStream writing to the file named NAME.
     */
    private PrintStream getOutput(String name) {
        try {
            return new PrintStream(new File(name));
        } catch (IOException excp) {
            throw error("could not open %s", name);
        }
    }

    /**
     * Configure an Enigma machine from the contents of configuration
     * file _config and apply it to the messages in _input, sending the
     * results to _output.
     */
    private void process() {


        config = "";
        _config.nextLine();
        _config.nextLine();
        while (_config.hasNext()) {
            config = config.concat(_config.nextLine());
            config = config.concat("\n");
        }
        config = config.toUpperCase();


        String input = "";
        while (_input.hasNext()) {
            input = input.concat(_input.nextLine());
            input = input.concat("\n");
        }
        input = input.toUpperCase();
        String[] splitedinp = input.split("\n");

        for (int i = 0; i < splitedinp.length - 1; i += 2) {
            String[] spitedline1 = splitedinp[i].split(" ");

            rRotorsName = getRotorsName(spitedline1);
            numrotors = rRotorsName.length;
            rRotorspos = spitedline1[numrotors + 1];
            numfixed = 1;
            if (numrotors + 3 < spitedline1.length) {
                plugboard = spitedline1[numrotors + 2]
                        + spitedline1[numrotors + 3];
            }
            message = splitedinp[i + 1];

            machine = readConfig();

            setUp(machine, plugboard);
            String output1 = machine.convert(message);
            printMessageLine(output1);
            _output.println(output1);
        }


    }

    /**
     * Return an Enigma machine configured from the contents of configuration
     * file _config.
     */
    private Machine readConfig() {
        try {
            permutations = getpermutation(rRotorsName, config);
            notches = getNotches(rRotorsName, config);
            numreflector = 1;
            nummoving = notches.length();
            _alphabet = new UpperCaseAlphabet();

            ArrayList<Rotor> ar = new ArrayList<Rotor>();
            for (int i = 0; i < numrotors; i++) {
                if (i < numreflector) {
                    Rotor rotor = new Reflector(rRotorsName[i],
                            new Permutation(permutations[i], _alphabet));
                    ar.add(rotor);
                } else if (i < numfixed + numreflector) {
                    Rotor rotor = new FixedRotor(rRotorsName[i],
                            new Permutation(permutations[i], _alphabet));
                    ar.add(rotor);
                } else {
                    Rotor rotor = new MovingRotor(rRotorsName[i],
                            new Permutation(permutations[i], _alphabet),
                            notches.substring(i - numfixed - numreflector,
                                    i - numfixed - numreflector + 1));
                    ar.add(rotor);
                }
            }
            return new Machine(_alphabet, numrotors, nummoving, ar);
        } catch (NoSuchElementException excp) {
            throw error("configuration file truncated");
        }
    }

    /**
     * Return a rotor, reading its description from _config.
     */
    private Rotor readRotor() {
        try {

            return null;
        } catch (NoSuchElementException excp) {
            throw error("bad rotor description");
        }
    }

    /**
     * Set M according to the specification given on SETTINGS,
     * which must have the format specified in the assignment.
     */
    private void setUp(Machine M, String settings) {

        M.setPlugboard(new Permutation(settings, _alphabet));

    }

    /**
     * Print MSG in groups of five (except that the last group may
     * have fewer letters).
     */
    private void printMessageLine(String msg) {

        try {
            char[] c = msg.toCharArray();
            int count = 0;
            for (int i = 0; i < c.length; i++) {
                if (_alphabet.contains(c[i])) {
                    count++;
                    System.out.print(c[i]);
                    if (count % 5 == 0) {
                        System.out.print(" ");
                    }
                }
            }
        } catch (NoSuchElementException excp) {
            throw error("bad rotor description");
        }


    }

    /**
     * return permutation from  config file.
     * @param configs con
     * @param reRotorsName rr
     */
    public String[] getpermutation(String[] reRotorsName, String configs) {
        String[] permutation = new String[reRotorsName.length];
        try {
            for (int j = 0; j < reRotorsName.length; j++) {
                int k;
                if (j == 0) {
                    k = configs.indexOf(reRotorsName[j] + " R");
                    k += 2;
                } else {
                    k = configs.indexOf(reRotorsName[j]);
                }
                if (k == -1) {
                    System.out.print("bad rotor description");
                    break;
                }
                int a = configs.indexOf("\n", k);
                if (j == 0) {
                    a = configs.indexOf("\n", a + 1);
                }
                String s = configs.substring(k, a);
                int m = s.indexOf("(");
                int n = s.lastIndexOf(")");
                permutation[j] = s.substring(m, n + 1);
            }
            return permutation;
        } catch (NoSuchElementException excp) {
            throw error("bad rotor description");
        }

    }

    /**
     * return Rotor's name in a string[] from  config file.
     * @param spitedline1 ss
     */
    public String[] getRotorsName(String[] spitedline1) {
        String[] rRotorsName1 = new String[5];
        for (int i = 1; i < rRotorsName1.length + 1; i++) {
            rRotorsName1[i - 1] = spitedline1[i];
        }
        return rRotorsName1;
    }

    /**
     * return Rotor's notches in a string from  config file.
     * @param rrRotorsName rr
     * @param configs con
     */
    public String getNotches(String[] rrRotorsName, String configs) {
        try {
            String notchess = "";
            for (int j = 0; j < rrRotorsName.length; j++) {
                String find = rrRotorsName[j] + " M";
                int k = configs.indexOf(find);
                if (k == -1) {
                    continue;
                }
                int a = configs.indexOf(" ", k + find.length());
                String s = configs.substring(k + find.length(), a);
                notchess = notchess.concat(s);
            }
            return notchess;
        } catch (NoSuchElementException excp) {
            throw error("bad rotor description");
        }

    }


}
