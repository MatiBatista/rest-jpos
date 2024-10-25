package org.jpos.rest.logListeners;

import org.jpos.util.LogEvent;
import org.jpos.util.LogListener;

import java.io.PrintStream;


public class SimpleLogListener implements LogListener {
    PrintStream p = System.out;

    public SimpleLogListener() {}

    public SimpleLogListener(PrintStream p) {
        this();
        setPrintStream(p);
    }

    public synchronized void setPrintStream(PrintStream p) {
        this.p = p;
    }

    public synchronized void close() {
        if (this.p != null) {
            this.p.close();
            this.p = null;
        }
    }

    public synchronized LogEvent log(LogEvent ev) {
        if (this.p != null) {
            ev.dump(this.p, "");
            this.p.flush();
        }
        return ev;
    }
}