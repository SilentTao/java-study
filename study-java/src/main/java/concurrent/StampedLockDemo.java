package concurrent;

import java.util.concurrent.locks.StampedLock;

/**
 * @author liutao
 * Date 2021/7/19 7:09 下午
 * Description:
 * Version: 1.0
 **/
public class StampedLockDemo {

    private final StampedLock stampedLock = new StampedLock();
    int x = 0;

    private void add() {
        //读锁
        long write = stampedLock.writeLock();
        try {
            x = x + 1;
        } finally {
            stampedLock.unlockWrite(write);
        }
    }
    //获取乐观锁
    private Integer getX() {
        //尝试乐观读
        long stemp = stampedLock.tryOptimisticRead();
        int currentX = x;
        if (!stampedLock.validate(stemp)) {
            long stempBei = stampedLock.readLock();
            try {
                currentX = x;
            } finally {
                stampedLock.unlockRead(stempBei);
            }
        }
        return currentX;
    }


}
