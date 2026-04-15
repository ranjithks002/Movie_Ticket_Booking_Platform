package com.example.bookingSystem.controller;

import com.example.bookingSystem.model.Movie;
import com.example.bookingSystem.model.Users;
import com.example.bookingSystem.service.MovieService;
import com.example.bookingSystem.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@CrossOrigin(origins = "*")
public class crud {

    private final UserService userService;
    private final MovieService movieService;

    public crud(UserService userService, MovieService movieService) {
        this.userService  = userService;
        this.movieService = movieService;
    }

    // Page routes
    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("users", new Users());
        return "home";
    }
    @GetMapping("/booking")
    public String booking() {
        return "booking";
    }
    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }
    // User: Signup

    @PostMapping("/home/save")
    @ResponseBody
    public ResponseEntity<?> saveUser(@RequestBody Users user) {
        Optional<Users> existing = userService.findByEmail(user.getEmail());
        if (existing.isPresent()) {
            return ResponseEntity.badRequest().body(Map.of("error", "Email already registered."));
        }
        Users saved = userService.saveUser(user);
        return ResponseEntity.ok(Map.of("message", "Account created!", "id", saved.getId()));
    }

    // User: Login

    @PostMapping("/home/login")
    @ResponseBody
    public ResponseEntity<?> login(@RequestBody Map<String, String> body) {
        String email    = body.get("email");
        String password = body.get("password");
        Optional<Users> userOpt = userService.findByEmail(email);

        if (userOpt.isEmpty() || !userOpt.get().getPassword().equals(password)) {
            return ResponseEntity.status(401).body(Map.of("error", "Invalid email or password."));
        }

        Users u = userOpt.get();
        return ResponseEntity.ok(Map.of("message", "Login successful", "name", u.getFullName(), "id", u.getId()));
    }

    // Movies: Get all

    @GetMapping("/api/movies")
    @ResponseBody
    public ResponseEntity<List<Movie>> getAllMovies() {
        return ResponseEntity.ok(movieService.getAllMovies());
    }

    // Movies: Get by ID

    @GetMapping("/api/movies/{id}")
    @ResponseBody
    public ResponseEntity<?> getMovie(@PathVariable int id) {
        return movieService.getMovieById(id)
                .<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Movies: Add

    @PostMapping("/api/movies")
    @ResponseBody
    public ResponseEntity<?> addMovie(@RequestBody Movie movie) {
        try {
            Movie saved = movieService.saveMovie(movie);
            return ResponseEntity.ok(saved);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(Map.of("error", e.getMessage()));
        }
    }

    // Movies: Delete

    @DeleteMapping("/api/movies/{id}")
    @ResponseBody
    public ResponseEntity<?> deleteMovie(@PathVariable int id) {
        movieService.deleteMovie(id);
        return ResponseEntity.ok(Map.of("message", "Deleted"));
    }
}
