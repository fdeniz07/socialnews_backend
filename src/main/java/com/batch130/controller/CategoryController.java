package com.batch130.controller;
import com.batch130.payload.request.CategoryRequest;
import com.batch130.payload.response.CategoryResponse;
import com.batch130.repository.CategoryRepository;
import com.batch130.service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;
    private final CategoryRepository categoryRepository;

    // Add methodu *********************
    @PostMapping("/add") //http://localhost:8080/category/add
    public ResponseEntity<CategoryResponse> add(@RequestBody @Valid CategoryRequest categoryRequest){

        return ResponseEntity.ok((CategoryResponse) categoryService.add(categoryRequest));

    }


    // getAll() methodu *******************
    @GetMapping("/getAll") // http://localhost:8080/category/getAll
    public Page<CategoryResponse> getAll(
            @RequestParam(value = "page") int page,
            @RequestParam(value = "size") int size,
            @RequestParam(value = "sort") String sort,
            @RequestParam(value = "type") String type
    ){
        return categoryService.getAll(page, size, sort, type);
    }


    // getAllEntryByCategory() methodu *****************
    @GetMapping("/getAllEntryByCategory")  //http://localhost:8080/category/getAllEntryByCategory
    public Page<CategoryResponse> getAllEntryByCategory(
            @RequestParam(value = "page") int page,
            @RequestParam(value = "size") int size,
            @RequestParam(value = "sort") String sort,
            @RequestParam(value = "type") String type
    ){
        return categoryService.getAllEntryByCategory(page, size, sort, type);
    }

    // Delete() methodu ************************
    @DeleteMapping("/delete/{id}") //http://localhost:8080/category/delete/1
    public ResponseEntity<CategoryResponse> delete (@PathVariable Long categoryId){
        return ResponseEntity.ok(categoryService.delete(categoryId));
    }

    // Update() methodu ************************
    @PutMapping("/update/{categoryId}")
    public ResponseEntity<CategoryResponse> update(@RequestBody @Valid CategoryRequest categoryRequest, @PathVariable Long categoryId){
        return ResponseEntity.ok(categoryService.update(categoryRequest, categoryId));
    }

    //  getEntriesCountByCategory() ************************
    @GetMapping("/getEntriesCountByCategory")
    public Page<CategoryResponse> search(
            @RequestParam(value = "page") int page,
            @RequestParam(value = "size") int size,
            @RequestParam(value = "sort") String sort,
            @RequestParam(value = "type") String type
    ){
        return categoryService.getEntriesCountByCategory(page, size, sort, type);
    }

}
