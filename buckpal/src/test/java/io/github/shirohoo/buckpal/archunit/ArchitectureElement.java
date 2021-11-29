package io.github.shirohoo.buckpal.archunit;

import static com.tngtech.archunit.base.DescribedPredicate.*;
import static com.tngtech.archunit.lang.conditions.ArchConditions.*;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.*;
import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import java.util.List;

abstract class ArchitectureElement {

    final String basePackage;

    public ArchitectureElement(String basePackage) {
        this.basePackage = basePackage;
    }

    static void denyDependency(String fromPackageName, String toPackageName, JavaClasses classes) {
        noClasses()
            .that()
            .resideInAPackage("io.github.shirohoo.reviewapp.domain..")
            .should()
            .dependOnClassesThat()
            .resideInAnyPackage("io.github.shirohoo.reviewapp.application..")
            .check(classes);
    }

    static void denyAnyDependency(
        List<String> fromPackages, List<String> toPackages, JavaClasses classes) {
        for (String fromPackage : fromPackages) {
            for (String toPackage : toPackages) {
                noClasses()
                    .that()
                    .resideInAPackage(matchAllClassesInPackage(fromPackage))
                    .should()
                    .dependOnClassesThat()
                    .resideInAnyPackage(matchAllClassesInPackage(toPackage))
                    .check(classes);
            }
        }
    }

    static String matchAllClassesInPackage(String packageName) {
        return packageName + "..";
    }

    String fullQualifiedPackage(String relativePackage) {
        return this.basePackage + "." + relativePackage;
    }

    void denyEmptyPackage(String packageName) {
        classes()
            .that()
            .resideInAPackage(matchAllClassesInPackage(packageName))
            .should(containNumberOfElements(greaterThanOrEqualTo(1)))
            .check(classesInPackage(packageName));
    }

    private JavaClasses classesInPackage(String packageName) {
        return new ClassFileImporter().importPackages(packageName);
    }

    void denyEmptyPackages(List<String> packages) {
        for (String packageName : packages) {
            denyEmptyPackage(packageName);
        }
    }

}
