package com.example.testjdbc2.service;

import com.example.testjdbc2.dto.MemoRequestDto;
import com.example.testjdbc2.dto.MemoResponseDto;
import com.example.testjdbc2.entity.Memo;
import com.example.testjdbc2.repository.MemoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemoService {
    private final MemoRepository memoRepository;

    @Transactional
    public MemoResponseDto save(MemoRequestDto dto) {
        Memo memo = new Memo(dto.getContent());     // 저장되기 전의 Memo
        Memo savedMemo = memoRepository.save(memo); // 저장된 Memo
        return new MemoResponseDto(savedMemo.getId(), savedMemo.getContent());
    }

    @Transactional(readOnly = true)
    public List<MemoResponseDto> findAll() {
        List<Memo> memos = memoRepository.findAll();

        List<MemoResponseDto> dtos = new ArrayList<>();
        for (Memo memo : memos) {
            MemoResponseDto dto = new MemoResponseDto(memo.getId(), memo.getContent());
            dtos.add(dto);
        }
        return dtos;
    }

    @Transactional(readOnly = true)
    public MemoResponseDto findById(Long id) {
        Memo memo = memoRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 id가 존재하지 않습니다.")
        );
        return new MemoResponseDto(memo.getId(), memo.getContent());
    }

    @Transactional
    public MemoResponseDto update(Long id, MemoRequestDto dto) {
        Memo updatedMemo = memoRepository.updateContent(id, dto.getContent());
        return new MemoResponseDto(updatedMemo.getId(), updatedMemo.getContent());
    }


    @Transactional
    public void deleteById(Long id) {
        // Memo memo = memoRepository.findById(id).orElseThrow(
        //        () -> new IllegalArgumentException("해당 id가 존재하지 않습니다.")
        //);
        memoRepository.deleteById(id);
    }

}