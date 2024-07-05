package com.example.jooq.generation;

import org.jooq.codegen.GenerationTool;
import org.jooq.meta.jaxb.*;

public class JOOQGenerator {
    public static void main(String[] args) throws Exception {
        Configuration configuration = new Configuration()
                .withJdbc(new Jdbc()
                        .withDriver("org.postgresql.Driver")
                        .withUrl("jdbc:postgresql://localhost:5432/postgres")
                        .withUser("postgres")
                        .withPassword("root"))
                .withGenerator(new Generator()
                        .withName("org.jooq.codegen.DefaultGenerator")
                        .withDatabase(new Database()
                                .withName("org.jooq.meta.postgres.PostgresDatabase")
                                .withInputSchema("public")
                                .withIncludes(".*")
                                .withExcludes("")
                        )
                        .withTarget(new Target()
                                .withPackageName("com.example.jooq.generated")
                                .withDirectory("src/main/java")
                        )
                );

        GenerationTool.generate(configuration);
    }
}