package com.dwsp.lock;

/**
 * @ClassName LockExecutor
 * @Description 分布式锁操作接口
 * @Author zhanguowei
 * @Date 2019/5/16 17:19
 **/
public interface LockExecutor {

    /**
     * 获取锁
     *
     * @param var1 key
     * @param var2 value
     * @param var3 expire
     * @return
     */
    boolean acquire(String var1, String var2, long var3);

    /**
     * 释放锁
     *
     * @param lockInfo
     * @return
     */
    boolean release(LockInfo lockInfo);
}
