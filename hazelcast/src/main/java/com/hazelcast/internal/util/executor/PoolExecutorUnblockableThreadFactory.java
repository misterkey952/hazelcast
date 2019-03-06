/*
 * Copyright (c) 2008-2019, Hazelcast, Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hazelcast.internal.util.executor;

import com.hazelcast.util.executor.PoolExecutorThreadFactory;

/**
 * This factory is implemented to have a thread factory that creates threads with `UnblockableThread` interface.
 * see @{@link UnblockableThread}
 */
public class PoolExecutorUnblockableThreadFactory extends PoolExecutorThreadFactory {

    public PoolExecutorUnblockableThreadFactory(String threadNamePrefix, ClassLoader classLoader) {
        super(threadNamePrefix, classLoader);
    }

    @Override
    protected ManagedThread createThread(Runnable r, String name, int id) {
        return new UnblockableManagedThread(r, name, id);
    }

    private class UnblockableManagedThread extends ManagedThread implements UnblockableThread {

        UnblockableManagedThread(Runnable target, String name, int id) {
            super(target, name, id);
        }
    }
}
