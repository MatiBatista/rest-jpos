package org.jpos.rest.logListeners;



import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.jpos.core.Configurable;
import org.jpos.core.Configuration;
import org.jpos.core.ConfigurationException;

//import ar.cabal.jpos.space.SpaceFactory;
import org.jpos.rest.utils.Utils;
import org.jpos.space.TSpace;
import org.jpos.transaction.Context;
import org.jpos.util.Destroyable;
import org.jpos.util.LogEvent;
import org.jpos.util.LogListener;

/*
 * @author Straguzzi
 */
public class LogTagFilter implements LogListener, Configurable, Destroyable {

    TSpace sp;
    String level;
    String DBLevel;
    String lockLevel;
    Long lockTimeout;
    String nodo;
    String hostname;
    int timeout;
    String[] specialTags;
    String[] excluded;
    String[] alarms;
    static final Map<String, Integer> LEVELS = new HashMap();
    long spaceLimit;

    @Override
    public synchronized LogEvent log(LogEvent evt) {
        LogEvent aux = null;
        try {
            // Aqui se procesan las excepciones ancapsuladas en otros tags
            if ((evt.getTag().equals("abort") || evt.getTag().equals("warn")) && permitLogging("error")) {
                aux = dump(evt);
            }
            // Aqui se procesan los tags especiales
            Iterator it1;
            if (hasSpecialTag(evt)) {
                for (it1 = evt.getPayLoad().iterator(); it1.hasNext(); ) {
                    LogEvent event = new LogEvent("error", evt.getRealm());
                    Object o = it1.next();
                    event.addMessage(o);
                    evt = event;
                }
            }
            // Aqui se guardan en la base los logs con el tag configurado en DBLevel
            //  if (DBPermitLogging(evt.getTag()) && !isExcluded(evt)) {
            //   logPersistAndLock(evt);
            //  }
            // Aqui se devuelven al logger siguiente los logs con el tag configurado en level
            if (permitLogging(evt.getTag())) {
                return evt;
            }
        } catch (Exception ex) {
            return evt;
        }
        return aux;
    }

    @Override
    public void setConfiguration(Configuration cfg) throws ConfigurationException {
        //sp = (TSpace) SpaceFactory.getSpace();
        spaceLimit = cfg.getLong("space-limit", 10000);
        level = cfg.get("level") != null ? cfg.get("level") : "warn";
        DBLevel = cfg.get("DBLevel") != null ? cfg.get("DBLevel") : "error";
        lockLevel = cfg.get("lockLevel") != null ? cfg.get("lockLevel") : "error";
        nodo = Utils.getNode() != null ? Utils.getNode() : "NN";
        hostname = Utils.getHostname();
        timeout = cfg.getInt("tx-timeout", 2000);
        lockTimeout = cfg.getLong("lock-timeout", 10000);
        specialTags = cfg.getAll("special-tag");
        excluded = cfg.getAll("excluded");
        alarms = cfg.getAll("alarm");
        LEVELS.put("trace", 1);
        LEVELS.put("debug", 2);
        LEVELS.put("info", 3);
        LEVELS.put("warn", 4);
        LEVELS.put("error", 5);
        LEVELS.put("fatal", 6);
    }

    public synchronized LogEvent dump(LogEvent evt) {
        Iterator i$;
        synchronized (evt.getPayLoad()) {
            for (i$ = evt.getPayLoad().iterator(); i$.hasNext(); ) {
                Object o = i$.next();
                if (o.getClass().getName().equals("org.jpos.transaction.Context")) {
                    Object obj = ((Context) o).getLogEvent();
                    return dump((LogEvent) obj);
                }
                if (o instanceof String) {
                    String s = (String) o;
                    for (String a : alarms) {
                        if (s.contains(a)) {
                            LogEvent event = new LogEvent("error", evt.getRealm());
                            event.addMessage(s);
                            //  logPersistAndLock(event);
                        }
                    }
                }
//                System.out.println("Instance of: " + o.getClass().toGenericString());
                if (o instanceof Throwable) {
                    if (evt.getTag().equals("log")) {
                        LogEvent event = new LogEvent("error", evt.getRealm());
                        Iterator it1;
                        for (it1 = evt.getPayLoad().iterator(); it1.hasNext(); ) {
                            event.addMessage(it1.next());
                        }
                        evt = event;
                    }
                    // logPersistAndLock(evt);
                    return evt;
                } else {
                    return evt;
                }
            }
            return null;
        }
    }

    /*
    public void logPersistAndLock(LogEvent evt) {
        String log = evt.toString();
        if (log.length() > 2000) {
            log = log.substring(0, 1999);
        }
        if (PermitLocking(evt.getTag())) {
            addAlarm();
        }
        Transaction tx = db.beginTransaction(timeout);
        tx.begin();
        ExceptionLog bdLog = new ExceptionLog();
        bdLog.setEventType(evt.getTag());
        bdLog.setCaptureDate(new Date());
        bdLog.setLogException(log);
        bdLog.setNodo(nodo);
        bdLog.setHostname(hostname);
        db.save(bdLog);
        db.session().flush();
        tx.commit();
    }
    */


    private boolean PermitLocking(String tagLevel) {
        Integer I = LEVELS.get(tagLevel);
        if (I == null) {
            I = LEVELS.get("info");
        }
        Integer J = LEVELS.get(this.lockLevel);
        return I >= J;
    }

    public boolean permitLogging(String tagLevel) {
        Integer I = LEVELS.get(tagLevel);
        if (I == null) {
            I = LEVELS.get("info");
        }
        Integer J = LEVELS.get(this.level);
        return I >= J;
    }

    public boolean DBPermitLogging(String tagLevel) {
        Integer I = LEVELS.get(tagLevel);
        if (I == null) {
            I = LEVELS.get("info");
        }
        Integer J = LEVELS.get(this.DBLevel);
        return I >= J;
    }

    @Override
    public void destroy() {
    }

    private boolean isSpecialTag(String tag) {
        for (Object o : specialTags) {
            return o.equals(tag);
        }
        return false;
    }

    private boolean hasSpecialTag(LogEvent evt) {
        Iterator it1;
        for (it1 = evt.getPayLoad().iterator(); it1.hasNext(); ) {
            if (isSpecialTag(it1.next().toString())) {
                return true;
            }
        }
        return false;
    }

    private void addAlarm() {
        if (sp.size("ALARM") < spaceLimit) {
            sp.out("ALARM", new Object(), lockTimeout);
        }
    }

    private boolean isExcluded(LogEvent evt) {
        Iterator i$;
        synchronized (evt.getPayLoad()) {
            for (i$ = evt.getPayLoad().iterator(); i$.hasNext(); ) {
                Object o = i$.next();
                if (o instanceof String) {
                    String s = (String) o;
                    for (String a : excluded) {
                        if (s.contains(a)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

}

