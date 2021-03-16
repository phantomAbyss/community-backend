package com.wy.community.dao;

import com.wy.community.model.LoginTicket;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginTicketDao {

    /**
     * 将登录凭证存入到数据库中
     * @param loginTicket
     */
    void insertLoginTicket(LoginTicket loginTicket);
}
