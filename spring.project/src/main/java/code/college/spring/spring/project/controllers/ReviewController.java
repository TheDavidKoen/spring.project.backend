package code.college.spring.spring.project.controllers;

import code.college.spring.spring.project.models.Review;
import code.college.spring.spring.project.services.ReviewService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Tag(name = "Reviews' APIs", description = "Here are all the controllers for the reviews' data.")
@RestController
@RequestMapping("/reviews")
public class ReviewController {
    @Autowired
    private ReviewService service;

    @Operation(
            summary = "Posts a review.",
            description = "Sends a POST request that creates a review.",
            tags = { "Reviews", "Post Request" })
    @PostMapping()
    public ResponseEntity<Review> createReview(@RequestBody Map<String, String> payload) {

        return new ResponseEntity<Review>(service.createReview(payload.get("reviewBody"), payload.get("imdbId")), HttpStatus.OK);
    }

}