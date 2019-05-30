package com.dwsp.lock;

import com.dwsp.lock.util.LockUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;

/**
 * @ClassName LockTemplate
 * @Description 锁操作模板
 * @Author zhanguowei
 * @Date 2019/5/16 17:41
 **/
@Slf4j
public class LockTemplate {

    private static final String PROCESS_ID = LockUtils.getLocalIP() + LockUtils.getJvmPid();
    private LockExecutor lockExecutor;

    public LockTemplate() {
    }

    public LockInfo lock(String key, long expire, long timeout) throws Exception {
        Assert.isTrue(timeout > 0L, "tryTimeout must more than 0");
        long start = System.currentTimeMillis();
        int acquireCount = 0;
        String value = PROCESS_ID + Thread.currentThread().getId();

        while (System.currentTimeMillis() - start < timeout) {
            boolean result = this.lockExecutor.acquire(key, value, expire);
            ++acquireCount;
            if (result) {
                return new LockInfo(key, value, expire, timeout, acquireCount);
            }

            Thread.sleep(50L);
        }

        log.info("lock failed, try {} times", acquireCount);
        return null;
    }

    public boolean unlock(LockInfo lockInfo) {
        return this.lockExecutor.release(lockInfo);
    }

    public void setLockExecutor(LockExecutor lockExecutor) {
        this.lockExecutor = lockExecutor;
    }
}
