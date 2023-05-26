package common.util;

public class DataProvider {

    @org.testng.annotations.DataProvider(name = "adminInvalidValues")
    public static Object[][] adminInvalidValues() {
        return new Object[][] {
                {"string.com", "marko", "peric"},
                {"string@com", "Marko", "peric", },
                {"string@emailcom", "Marko", "Peric"},
                {"", "Marko", "Peric"},
                {"strinzxczasxcg@asd.com", "", "Peric"},
                {"string@test.com", "Marko", ""},
        };
    }

    @org.testng.annotations.DataProvider(name = "mentorInvalidValues")
    public static Object[][] mentorInvalidValues() {
        return new Object[][] {
                {"marko", "peric", "string.com", 0},
                {"Marko", "peric", "string.com", 0},
                {"marko", "Peric", "string.com", 0},
                {"Marko", "Peric", "stringtest@.com", 0},
                {"", "Peric", "string@gmail.com", 0},
                {"Marko", "", "mentortest@gmailcom", 0},
                {"marko", "Peric", "", 0},
        };
    }

    @org.testng.annotations.DataProvider(name = "internInvalidValues")
    public static Object [][] internInvalidValues() {
        return new Object[][] {
                {"marko", "ilic", "string.com", 0},
                {"Marko", "ilic", "string@com", 15023},
                {"marko", "Ilic", "String@.asd", 0},
                {"Marko", "Ilic", "@gmail.com", 0},
                {"", "Ilic", "internmailkojinepostoji@gmail.com", 1},
                {"Marko", "", "differentemail@gmail.com", 1},
                {"Marko", "Ilic", "", 1},
        };
    }
}