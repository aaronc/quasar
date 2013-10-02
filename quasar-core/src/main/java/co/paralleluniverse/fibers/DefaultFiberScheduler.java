/*
 * Quasar: lightweight threads and actors for the JVM.
 * Copyright (C) 2013, Parallel Universe Software Co. All rights reserved.
 * 
 * This program and the accompanying materials are dual-licensed under
 * either the terms of the Eclipse Public License v1.0 as published by
 * the Eclipse Foundation
 *  
 *   or (per the licensee's choosing)
 *  
 * under the terms of the GNU Lesser General Public License version 3.0
 * as published by the Free Software Foundation.
 */
package co.paralleluniverse.fibers;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

/**
 *
 * @author pron
 */
public class DefaultFiberScheduler {
    private static final FiberTimedScheduler timer = new FiberTimedScheduler(DefaultFiberPool.getInstance(),
            new ThreadFactoryBuilder().setNameFormat("default-fiber-timed-scheduler").setDaemon(true).build());
    private static final FiberScheduler instance = new FiberScheduler(DefaultFiberPool.getInstance(), timer);

    public static FiberScheduler getInstance() {
        return instance;
    }
}