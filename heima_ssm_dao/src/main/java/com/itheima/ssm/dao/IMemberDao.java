package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Member;

public interface IMemberDao {
    public Member findById(String memberId);
}
