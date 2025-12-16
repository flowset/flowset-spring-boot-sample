package io.flowset.springbootsample.utils;

import net.datafaker.Faker;
import net.datafaker.providers.base.Address;
import net.datafaker.providers.base.Internet;
import net.datafaker.providers.base.Name;
import net.datafaker.providers.base.PhoneNumber;

import java.util.Locale;
import java.util.Random;

public class DatafakerUtils {

    protected static Faker faker = new Faker(Locale.ENGLISH);

    public static Name getName() {
        return faker.name();
    }

    public static Address getAddress() {
        return faker.address();
    }

    public static Internet getInternet() {
        return faker.internet();
    }

    public static PhoneNumber getPhone() {
        return faker.phoneNumber();
    }

    public static int getCreditScore() {
        Random random = new Random();
        return random.nextInt(100);
    }

}
