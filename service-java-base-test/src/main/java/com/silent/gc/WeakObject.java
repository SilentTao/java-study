package com.silent.gc;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 * \* User: silent
 * \* Date: 07/03/19 Time: 10:10
 * \* Description:
 * \
 */
public class WeakObject extends WeakReference<Student>{



    public WeakObject(Student referent) {
        super(referent);
    }

    public WeakObject(Student referent, ReferenceQueue<? super Student> q) {
        super(referent, q);
    }

    /**
     * 重写finalize方法,在被gc时会进行回收
     * @throws Throwable
     */
    @Override
    protected void finalize() throws Throwable {
        System.out.println("weakObject 被GC了");
    }
}
