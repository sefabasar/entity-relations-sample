package io.kodlama.entityrelationssample.service;

import io.kodlama.entityrelationssample.model.Framework;
import io.kodlama.entityrelationssample.model.Language;
import io.kodlama.entityrelationssample.repository.FrameworkRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FrameworkService {

    private final FrameworkRepository frameworkRepository;
    private final LanguageService languageService;

    public FrameworkService(FrameworkRepository frameworkRepository, LanguageService languageService) {
        this.frameworkRepository = frameworkRepository;
        this.languageService = languageService;
    }

    public Framework update(Framework framework) {

        Framework frameworkOnDb = frameworkRepository.findById(framework.getId())
                .orElseThrow(() -> new RuntimeException("Verilen id geçersiz."));

        frameworkOnDb.setName(framework.getName());
        return frameworkRepository.save(frameworkOnDb);
    }

    public void delete(Integer langId, Integer fwId) {

        Language language = languageService.getById(langId);
        Framework framework = frameworkRepository.findById(fwId)
                .orElseThrow(() -> new RuntimeException("Verilen id geçersiz."));

        List<Framework> frameworks = language.getFrameworks();

        if(!frameworks.contains(framework)){
            throw new RuntimeException("Verilen dilde bu framework yok.");
        }

        frameworks.remove(framework);

        languageService.save(language);
    }
}
