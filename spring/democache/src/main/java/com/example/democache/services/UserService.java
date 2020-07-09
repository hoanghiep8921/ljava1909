package com.example.democache.services;

import com.example.democache.model.User;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    //lưu cache đối tượng user theo id truyền vào
    @Cacheable("user")
    public User findUserById(int id) {
        simulateSlowService();
        return new User(id, "Any name");
    }
    //giả lập truy cập DB, thực hiện logic
    private void simulateSlowService() {
        try {
            long time = 3000L;
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }

    //xóa cache user theo id
    @CacheEvict("user")
    public void clearCacheById(int id) {
        System.out.println("Đã xóa cache với Id : " + id);
    }

    //xóa toàn bộ dữ liệu cache
    @CacheEvict(value = "user", allEntries = true)
    public void clearCache() {
        System.out.println("Xóa toàn bộ cache lưu trong bộ nhớ");
    }

    //ghi đè dữ liệu user theo id vào cache
    //luôn luôn thực thi
    @CachePut(value = "user")
    public User putUserById(int id) {
        simulateSlowService();
        return new User(id, "new User putted");
    }
}