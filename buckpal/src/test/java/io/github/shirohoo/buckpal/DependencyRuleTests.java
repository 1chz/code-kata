package io.github.shirohoo.buckpal;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.*;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import io.github.shirohoo.buckpal.archunit.HexagonalArchitecture;
import org.junit.jupiter.api.Test;

class DependencyRuleTests {

    @Test
    void validateRegistrationContextArchitecture() {
        HexagonalArchitecture.boundedContext("io.github.shirohoo.buckpal.account")

            .withDomainLayer("domain")

            .withAdaptersLayer("adapter")
            .incoming("in.web")
            .outgoing("out.persistence")
            .and()

            .withApplicationLayer("application")
            .services("service")
            .incomingPorts("port.in")
            .outgoingPorts("port.out")
            .and()

            .withConfiguration("configuration")
            .check(new ClassFileImporter()
                .importPackages("io.github.shirohoo.buckpal.."));
    }

    @Test
    void testPackageDependencies() {
        noClasses()
            .that()
            .resideInAPackage("io.github.shirohoo.reviewapp.domain..")
            .should()
            .dependOnClassesThat()
            .resideInAnyPackage("io.github.shirohoo.reviewapp.application..")
            .check(new ClassFileImporter()
                .importPackages("io.github.shirohoo.reviewapp.."));
    }

}
