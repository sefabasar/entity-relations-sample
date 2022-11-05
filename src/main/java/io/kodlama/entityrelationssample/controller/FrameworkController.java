package io.kodlama.entityrelationssample.controller;

import io.kodlama.entityrelationssample.model.Framework;
import io.kodlama.entityrelationssample.service.FrameworkService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/framework")
public class FrameworkController {
    private final FrameworkService frameworkService;


    public FrameworkController(FrameworkService frameworkService) {
        this.frameworkService = frameworkService;
    }

    @PutMapping("/update")
    public ResponseEntity<Framework> update(@RequestBody @Validated Framework framework) {
        return ResponseEntity.ok(frameworkService.update(framework));
    }

    @DeleteMapping("/delete/{langId}/{fwId}")
    public ResponseEntity<String> delete(@PathVariable Integer langId, @PathVariable Integer fwId) {
        frameworkService.delete(langId,fwId);
        return ResponseEntity.ok(fwId + " numaralı framework başarıyla silindi.");
    }
}
