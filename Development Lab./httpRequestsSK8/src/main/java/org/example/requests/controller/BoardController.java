package org.example.requests.controller;

import org.example.requests.model.Board;
import org.example.requests.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/boards")
@CrossOrigin("*")
public class BoardController {

    @Autowired
    private BoardRepository boardRepository;

    @GetMapping
    public List<Board> getAllBoards() {
        return boardRepository.findAll();
    }

    @PostMapping
    public Board createBoard(@RequestBody Board board) {
        return boardRepository.save(board);
    }

    @PutMapping("/{id}")
    public Board updateBoard(@PathVariable Long id, @RequestBody Board updatedBoard) {
        return boardRepository.findById(id).map(board -> {
            board.setBrand(updatedBoard.getBrand());
            board.setSize(updatedBoard.getSize());
            board.setImgUrl(updatedBoard.getImgUrl());
            return boardRepository.save(board);
        }).orElseThrow(() -> new RuntimeException("Board não encontrado"));
    }

    @DeleteMapping("/{id}")
    public void deleteBoard(@PathVariable Long id) {
        boardRepository.deleteById(id);
    }
}

