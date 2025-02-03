package com.example.testjdbc2.controller;

import com.example.testjdbc2.dto.MemoRequestDto;
import com.example.testjdbc2.dto.MemoResponseDto;
import com.example.testjdbc2.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemoController {
    private final MemoService memoService;

    // Create API
    @PostMapping("/memos")
    public MemoResponseDto save(@RequestBody MemoRequestDto dto) {
        return memoService.save(dto);
    }

    // Read All API
    @GetMapping("/memos")
    public List<MemoResponseDto> findAll() {
        return memoService.findAll();
    }

    // Read One API
    @GetMapping("/memos/{memoId}")
    public MemoResponseDto findById(@PathVariable Long memoId) {
        return memoService.findById(memoId);
    }

    // Update API
    @PutMapping("/memos/{memoId}")
    public MemoResponseDto update(
            @PathVariable Long memoId,
            @RequestBody MemoRequestDto dto
    ) {
        return memoService.update(memoId, dto);
    }

    // Delete API
    @DeleteMapping("/memos/{memoId}")
    public void deleteById(@PathVariable Long memoId) {
        memoService.deleteById(memoId);
    }

}

