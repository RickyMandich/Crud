# Mercoledì 2025 04 09
## Argomenti trattati
- Aggiunta di hibernate
  - Hibernate è un ORM (Object Relational Mapping) che permette di mappare le classi Java su tabelle del database.
  - noi la aggiungiamo al build.gradle dal link https://mvnrepository.com/artifact/org.hibernate/hibernate-core dove troviamo la riga di codice `implementation group: 'org.hibernate', name: 'hibernate-core', version: '5.6.9.Final'`
- Aggiunta di JPA
  - JPA (Java Persistence API) è una specifica Java per la gestione della persistenza dei dati.
  - noi la aggiungiamo al build.gradle dal link // https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-data-jpa dove troviamo la riga di codice `implementation group: 'org.springframework.boot', name: 'spring-boot-starter-data-jpa', version: '2.5.5'`
- strutturazione di servizio con entità usando Jpa per una migliore gestione delle interazioni con il DB