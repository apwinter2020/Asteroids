package main.java.Util;

import main.java.Intefaces.ObjectFactory;
import main.java.Intefaces.Pool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public abstract class ObjectPool<T> implements ObjectFactory<T>, Pool<T> {

    private int size;

    private boolean shutdown;

    private BlockingQueue<T> pool;

    public ObjectPool(int size) {
        this.size = size;
        shutdown = false;
        init();
    }

    private void init() {
        pool = new LinkedBlockingQueue<T>();
        for (int i = 0; i < size; i++) {
            T t = createNew();
            pool.add(t);
        }
    }

    @Override
    public T get() {
        if (!shutdown) {
            T t = null;

            try {
                t = pool.take();
            } catch (Exception e) {
                e.printStackTrace();
            }

            return t;
        }

        throw new IllegalStateException("Object pool is already shutdown.");
    }

    @Override
    public void release(T t) {
        try {
            pool.offer(t);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void shutdown() {
        pool.clear();
    }

    public int size() {
        return pool.size();
    }

    public BlockingQueue<T> getPool() {
        return pool;
    }
}
