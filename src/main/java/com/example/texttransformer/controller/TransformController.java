package com.example.texttransformer.controller;

import com.example.texttransformer.model.TextRequest;
import com.example.texttransformer.model.TextResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transform")
public class TransformController {

    @PostMapping
    public TextResponse transformText(@RequestBody TextRequest request) {
        String cleaned = request.getText().replaceAll("\\s+", " ");
        StringBuilder reversed = new StringBuilder(cleaned).reverse();
        StringBuilder transformed = new StringBuilder();
        boolean[] uppers = new boolean[cleaned.length()] ;
        for (int i = 0; i < cleaned.length(); i++) {
            char c = cleaned.charAt(i);
            if ("aeiouAEIOUáéíóúů".indexOf(c) >= 0)
                uppers[i] = true;
            }

        for (int i = 0; i < reversed.length(); i++) {
            char c = reversed.charAt(i);
            if (uppers[i]) {
                transformed.append(Character.toUpperCase(c));
            } else {
                transformed.append(Character.toLowerCase(c));
            }
        }

        return new TextResponse(transformed.toString());
    }
}