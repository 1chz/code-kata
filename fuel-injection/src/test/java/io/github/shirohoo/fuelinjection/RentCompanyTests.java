package io.github.shirohoo.fuelinjection;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

class RentCompanyTests {
    private static final String NEW_LINE = System.lineSeparator();

    @Test
    void report() throws Exception {
        RentCompany company = RentCompany.create();
        company.addCar(new Sonata(150));
        company.addCar(new K5(260));
        company.addCar(new Sonata(120));
        company.addCar(new Avante(300));
        company.addCar(new K5(390));

        String report = company.generateReport();
        assertThat(report).isEqualTo(
            "Sonata : 15.0리터" + NEW_LINE +
            "K5 : 20.0리터" + NEW_LINE +
            "Sonata : 12.0리터" + NEW_LINE +
            "Avante : 20.0리터" + NEW_LINE +
            "K5 : 30.0리터" + NEW_LINE
        );
    }
}
