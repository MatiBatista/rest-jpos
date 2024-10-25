package org.jpos.rest.logListeners;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import org.jpos.core.Configurable;
import org.jpos.core.Configuration;
import org.jpos.core.ConfigurationException;
import org.jpos.rest.utils.Utils;
import org.jpos.util.DefaultTimer;
import org.jpos.util.Destroyable;
import org.jpos.util.LogEvent;

public class RotateLogListener extends SimpleLogListener implements Configurable, Destroyable {

    FileOutputStream f;

    String logName;

    int maxCopies;

    long sleepTime;

    long maxSize;

    int msgCount;

    Rotate rotate;

    public static final int CHECK_INTERVAL = 100;

    public static final long DEFAULT_MAXSIZE = 10000000L;

    private static String fs = System.getProperty("file.separator");

    public RotateLogListener(String logName, int sleepTime, int maxCopies, long maxSize) throws IOException {
        this.logName = logName;
        this.maxCopies = maxCopies;
        this.sleepTime = (sleepTime * 1000);
        this.maxSize = maxSize;
        this.f = null;
        openLogFile();
        Timer timer = DefaultTimer.getTimer();
        if (sleepTime != 0) {
            timer.schedule(this.rotate = new Rotate(), this.sleepTime, this.sleepTime);
        }
    }

    public RotateLogListener(String logName, int sleepTime, int maxCopies) throws IOException {
        this(logName, sleepTime, maxCopies, 10000000L);
    }

    public RotateLogListener() {
    }

    public void setConfiguration(Configuration cfg) throws ConfigurationException {
        CreateFolder createFolder = new CreateFolder();
        this.maxCopies = cfg.getInt("copies");
        this.sleepTime = (cfg.getInt("window") * 1000);
        this.logName = "jposlog" + fs + Utils.getHostname() + fs + cfg.get("file");
        this.maxSize = cfg.getLong("maxsize");
        this.maxSize = (this.maxSize <= 0L) ? 10000000L : this.maxSize;
        try {
            createFolder.createFolder();
            openLogFile();
        } catch (IOException e) {
            throw new ConfigurationException(e);
        }
        Timer timer = DefaultTimer.getTimer();
        if (this.sleepTime != 0L) {
            timer.schedule(this.rotate = new Rotate(), this.sleepTime, this.sleepTime);
        }
    }

    public synchronized LogEvent log(LogEvent ev) {
        if (this.msgCount++ > 100) {
            checkSize();
            this.msgCount = 0;
        }
        return super.log(ev);
    }

    protected synchronized void openLogFile() throws IOException {
        if (this.f != null) {
            this.f.close();
        }
        this.f = new FileOutputStream(this.logName, true);
        setPrintStream(new PrintStream(this.f));
        this.p.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        this.p.println("<logger class=\"" + getClass().getName() + "\">");
    }

    protected synchronized void closeLogFile() throws IOException {
        this.p.println("</logger>");
        if (this.f != null) {
            this.f.close();
        }
        this.f = null;
    }

    public synchronized void logRotate() throws IOException {
        closeLogFile();
        close();
        setPrintStream(null);
        for (int i = this.maxCopies; i > 0; ) {
            File dest = new File(this.logName + "." + i);
            File source = new File(this.logName + ((--i > 0) ? ("." + i) : ""));
            dest.delete();
            source.renameTo(dest);
        }
        openLogFile();
    }

    protected synchronized void logDebug(String msg) {
        if (this.p != null) {
            this.p.println("<log realm=\"rotate-log-listener\" at=\"" + (new Date()).toString() + "\">");
            this.p.println("   " + msg);
            this.p.println("</log>");
        }
    }

    protected void checkSize() {
        File logFile = new File(this.logName);
        if (logFile.length() > this.maxSize) {
            try {
                logDebug("maxSize (" + this.maxSize + ") threshold reached");
                logRotate();
            } catch (IOException e) {
                e.printStackTrace(System.err);
            }
        }
    }

    public class Rotate extends TimerTask {

        public void run() {
            try {
                RotateLogListener.this.logDebug("time exceeded - log rotated");
                RotateLogListener.this.logRotate();
            } catch (IOException e) {
                e.printStackTrace(System.err);
            }
        }
    }

    public void destroy() {
        if (this.rotate != null) {
            this.rotate.cancel();
        }
        try {
            closeLogFile();
        } catch (IOException e) {
        }
    }
}