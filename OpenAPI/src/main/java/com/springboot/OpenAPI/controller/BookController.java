package com.springboot.OpenAPI.controller;

import com.springboot.OpenAPI.model.Book;
import com.springboot.OpenAPI.service.BookServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Books", description = "Books API")
@RequestMapping("/api")
@RestController
public class BookController {
    @Autowired
    BookServiceImpl bookService;

    @Operation(
            summary = "Get all books",
            description = "Get list Book in database. The response is a list Book with name, description and price information",
            tags = {"books", "get"}
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Book.class), mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) })
    })
    @GetMapping("/books")
    public ResponseEntity<?> getAllBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @Operation(
            summary = "Get a book by id",
            description = "Get a Book Object by specified id. The response is Book with name, description and price information",
            tags = {"books", "get"}
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Book.class), mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) })
    })
    @GetMapping("/books/{id}")
    public ResponseEntity<?> getBookById(@Parameter(description = " id for get a book") @PathVariable long id) {
        return ResponseEntity.ok(bookService.getBookById(id));
    }
    @Operation(
            summary = "Create a new book",
            description = "Create a Book Object. The response is a new Book with name, description and price information",
            tags = {"books", "post"}
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Book.class), mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) })
    })
    @PostMapping("/books")
    public ResponseEntity<?> createBookById(@Parameter(description = " Book object for create a book") @RequestBody Book book) {
        return ResponseEntity.ok(bookService.createBook(book));
    }

    @Operation(
            summary = "Update a book by id",
            description = "Update a Book Object by specified id. The response is successful notification!",
            tags = {"books", "put"}
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(), mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) })
    })
    @PutMapping("/books/{id}")
    public ResponseEntity<?> updateAllBooks(@Parameter(description = " id for update a book") @RequestBody Book book, @PathVariable long id) {
        return ResponseEntity.ok(bookService.updateBookById(id, book));
    }

    @Operation(
            summary = "Delete a book by id",
            description = "Delete a Book Object by specified id. The response is successful notification!",
            tags = {"books", "delete"}
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(), mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) })
    })
    @DeleteMapping("/books/{id}")
    public ResponseEntity<?> deleteBookById(@Parameter(description = " id for delete a book") @PathVariable Long id) {
        return ResponseEntity.ok(bookService.deleteBookById(id));
    }
    @Operation(
            summary = "Delete all books",
            description = "Delete all Book in database. The response is successful notification!",
            tags = {"books", "delete"}
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(), mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) })
    })
    @DeleteMapping("/books")
    public ResponseEntity<?> deleteAllBooks() {
        return ResponseEntity.ok(bookService.deleteAllBooks());
    }
}
