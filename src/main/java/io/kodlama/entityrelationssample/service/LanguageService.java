package io.kodlama.entityrelationssample.service;

import io.kodlama.entityrelationssample.model.Framework;
import io.kodlama.entityrelationssample.model.Language;
import io.kodlama.entityrelationssample.repository.LanguageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageService {

    private final LanguageRepository languageRepository;

    public LanguageService(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    public List<Language> getAll() {
        return languageRepository.findAll();
    }

    public Language getById(Integer lang_id) {
        return languageRepository.findById(lang_id).orElseThrow(() -> new RuntimeException("Verilen id geçersiz."));
    }

    public Language save(Language language) {

        return languageRepository.save(language);
    }

    public Language assignFramework(Integer lang_id, Framework framework) {
        Language language = languageRepository.findById(lang_id)
                .orElseThrow(() -> new RuntimeException("Verilen id geçersiz."));
        language.getFrameworks().add(framework);

        return languageRepository.save(language);
    }

    public Language update(Language language) {
        Language languageOnDb = languageRepository.findById(language.getId())
                .orElseThrow(() -> new RuntimeException("Verilen id geçersiz."));

        languageOnDb.setName(language.getName());

        return save(languageOnDb);
    }

    public void delete(Integer langId) {
        Language language = languageRepository.findById(langId)
                .orElseThrow(() -> new RuntimeException("Verilen id geçersiz."));
        languageRepository.delete(language);
    }
}
