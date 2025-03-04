package org.example.requests;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@SpringBootApplication
public class HttpRequestsApplication {

    public static void main(String[] args) {
        SpringApplication.run(HttpRequestsApplication.class, args);
    }

}

@CrossOrigin("*")
@RestController
@RequestMapping("/boards")
class BoardController {
    public List<Board> boards = new ArrayList<>();

    public BoardController() {
        boards.addAll(List.of(
                new Board("Santa Cruz", 8.25f),
                new Board("WoodLight", 8.5f),
                new Board("Element", 7.75f),
                new Board("Flip", 8.0f)
        ));
    }

    @GetMapping
    Iterable<Board> getBoards() {
        return boards;
    }

    @GetMapping("/{id}")
    Optional<Board> getBoardById(@PathVariable String id) {
        for (Board b : boards) {
            if (b.getId().equals(id))
            {
                return Optional.of(b);
            }
        }
        return Optional.empty();
    }


    @PostMapping
    Board postBoard(@RequestBody Board board) {
        boards.add(board);
        return board;
    }

    @PutMapping("/{id}")
    ResponseEntity<Board> putBoard(@PathVariable String id, @RequestBody Board board){
        int boardIndex = -1;

        for(Board b: boards){
            if (b.getId().equals(id)){
                boardIndex = boards.indexOf(b);
                boards.set(boardIndex, board);
            }
        }
        return (boardIndex == -1) ?
                new ResponseEntity<>(postBoard(board), HttpStatus.CREATED) :
                new ResponseEntity<>(board, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    void deleteBoard(@PathVariable String id) {
        boards.removeIf(b -> b.getId().equals(id));
    }
}

class Board{
    private float size;
    private String brand;
    private String id;

    public Board(String brand, float size, String id){
        this.brand = brand;
        this.size = size;
        this.id = id;
    }


    public Board(String brand, float size){
        this(brand ,size, UUID.randomUUID().toString());
    }

    public Board() {
    }

    public String getBrand(){
        return brand;
    }

    public float getSize(){
        return size;
    }

    public String getId(){
        return id;
    }

    public void setBrand(String brand){
        this.brand = brand;
    }

    public void setSize(float size){
        this.size = size;
    }
}