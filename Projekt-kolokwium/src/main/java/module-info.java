module Projekt.kolokwium {
    // JavaFX
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.media;

    // Hibernate & JPA
    requires jakarta.persistence;
    requires org.hibernate.orm.core;
    requires java.sql; // wymagane przez Hibernate do połączenia z bazą
    requires java.naming;
    // PostgreSQL JDBC
    requires org.postgresql.jdbc;

    // (opcjonalnie) dla hashów i logowania
    requires jbcrypt;
    requires org.slf4j;

    // Dla Lombok
    requires static lombok;

    // Otwarcie pakietów (wymagane do działania refleksji Hibernate i JavaFX)
    opens pl.filip.util to org.hibernate.orm.core, javafx.fxml;
    opens pl.filip.controller to javafx.fxml;

    // Eksportuj pakiety (jeśli będą używane przez inne moduły)
    exports pl.filip.util;
    exports pl.filip.controller;
    exports pl.filip;
    opens pl.filip to javafx.fxml, org.hibernate.orm.core;
}