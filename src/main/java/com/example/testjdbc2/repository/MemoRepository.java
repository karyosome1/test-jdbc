package com.example.testjdbc2.repository;

import com.example.testjdbc2.entity.Memo;

import java.util.List;
import java.util.Optional;

public interface MemoRepository {
    Memo save(Memo memo);                          // Create
    Optional<Memo> findById(Long id);              // Read 단건. Optional 사용 이유: Null 처리. 없을 수도 있으니까
    List<Memo> findAll();                          // Read 다건
    Memo updateContent(Long id, String content);   // Update
    void deleteById(Long id);                      // Delete
}