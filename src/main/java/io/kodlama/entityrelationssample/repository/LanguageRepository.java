package io.kodlama.entityrelationssample.repository;

import io.kodlama.entityrelationssample.model.Language;
import org.springframework.data.jpa.repository.JpaRepository;

// extends JpaRepository<Brand, Integer>  Spring Data Jpa'in özelliklerini kullanmak için bunu extends ediyoruz.
public interface LanguageRepository extends JpaRepository<Language,Integer> {


}
