package org.bshg.librarysystem.utils.console;

import java.util.Arrays;

import static java.lang.System.out;

public final class Console {
    private Console() {
    }

    public static void log() {
        out.println();
    }

    public static void log(Object msg) {
        out.println(msg);
    }

    public static void log(String sep, Object... msgs) {
        String msg = Arrays.stream(msgs)
                .map(Object::toString)
                .reduce((init, cur) -> init + sep + cur)
                .orElse(null);
        out.println(msg);
    }

    public static void log(Object... msgs) {
        log(" ", msgs);
    }
}
