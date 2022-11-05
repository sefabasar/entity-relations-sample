package io.kodlama.entityrelationssample.controller;

import io.kodlama.entityrelationssample.model.Framework;
import io.kodlama.entityrelationssample.model.Language;
import io.kodlama.entityrelationssample.service.LanguageService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/language")
public class LanguageController {
    private final LanguageService languageService;

    public LanguageController(LanguageService languageService) {
        this.languageService = languageService;
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<Language>> getAll() {
        return ResponseEntity.ok(languageService.getAll());
    }

    @PostMapping("/save")
    public ResponseEntity<Language> save(@RequestBody @Validated Language language) {
        return ResponseEntity.ok(languageService.save(language));
    }

    @PostMapping("/assign-framework/{lang_id}")
    public ResponseEntity<Language> assignFramework(@PathVariable Integer lang_id,
                                                    @RequestBody @Validated Framework framework) {
        return ResponseEntity.ok(languageService.assignFramework(lang_id, framework));
    }
    @PutMapping("/update")
    public ResponseEntity<Language> update(@RequestBody @Validated Language language) {
        return ResponseEntity.ok(languageService.update(language));
    }

    @DeleteMapping("/delete/{langId}")
    public ResponseEntity<String> delete(@PathVariable Integer langId) {
        languageService.delete(langId);
        return ResponseEntity.ok(langId + " numaralı dil başarıyla silindi.");
    }
}
