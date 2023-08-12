package com.batch130.service;

import com.batch130.payload.request.CategoryRequest;
import com.batch130.payload.response.CategoryResponse;
import com.batch130.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryResponse add(CategoryRequest categoryRequest) {
        return null;
    }

    public Page<CategoryResponse> getAll(int page, int size, String sort, String type) {
        return null;
    }

    public Page<CategoryResponse> getAllEntryByCategory(int page, int size, String sort, String type) {
        return null;
    }

    public CategoryResponse delete(Long categoryId) {
        return null;
    }

    public CategoryResponse update(CategoryRequest categoryRequest, Long categoryId) {
        return null;
    }

    public Page<CategoryResponse> getEntriesCountByCategory(int page, int size, String sort, String type) {
        return null;
    }
}
