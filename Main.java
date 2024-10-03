// YOUR NAME: 
// COLLABORATORS: 
// DATE: 

public class Main
{
        static String ASCII_ART_0 = "    .----.    .----.  ",
        ASCII_ART_1 = "   (  --  \\  /  --  )",
        ASCII_ART_2 = "          |  |        ",
        ASCII_ART_3 = "         _/  \\_      ",
        ASCII_ART_4 = "        (_    _)      ",
        ASCII_ART_5 = "     ,    `--`    ,   ",
        ASCII_ART_6 = "     \\'-.______.-'/  ",
        ASCII_ART_7 = "      \\          /   ",
        ASCII_ART_8 = "       '.--..--.'     ",
        ASCII_ART_9 = "         `\"\"\"\"\"` ",
        ASCII_CREDIT = "   ascii art by: jgs    ";

        static String TITLE_USA = "UNITED STATES OF AMERICA",
                TITLE_EAC = "EMPLOYMENT AUTHORIZATION CARD";
        static String LABEL_SURNAME = "Surname", LABEL_GIVEN_NAME = "Given Name", LABEL_USCIS_NUM = "USCIS#",
                LABEL_CATEGORY = "Category", LABEL_CARD_NUM = "Card#", LABEL_BIRTH_COUNTRY = "Country of Birth",
                LABEL_TERMS_CONDITIONS = "Terms and Conditions", LABEL_BIRTH_DATE = "Date of Birth",
                LABEL_SEX = "Sex", LABEL_VALID_DATE = "Valid From:", LABEL_EXPIRE_DATE = "Card Expires:",
                LABEL_REENTRY_DISCLAIMER = "NOT VALID FOR REENTRY TO U.S.";
    public static void main(String[] args)
    {
        //ascii art credit: http://www.oocities.org/spunk1111/bodypart.htm

        //DECLARATION SECTION
        //complete fields

        String surname, givenName, category, cardNum, birthCountry, termsAndConditions;
        char sex;

        //parts of fields
        String birthMonth;
        int uscisNum1, uscisNum2, uscisNum3, birthDay, birthYear,
                validDay, validMonth, validYear, expireMonth, expireDay, expireYear;

        //extra vars to help with formatting of Strings (not raw data like above vars)
        String uscisNum, dateOfBirth, validDate, expireDate;

        //INITIALIZATION SECTION
        //surname = "CHAPETON-LAMAS";
        surname = UtilityBelt.readString("Surname: ", 1, 30);
        //givenName = "NERY";
        givenName = UtilityBelt.readString("Given Name: ", 1, 20);
        //uscisNum1 = 12;
        uscisNum1 = UtilityBelt.readInt("uscisNum1:" , 0, 99);
        //uscisNum2 = 4;
        uscisNum2 = UtilityBelt.readInt("uscisNum2:" , 0, 99);
        //uscisNum3 = 789;
        uscisNum3 = UtilityBelt.readInt("uscisNum3:" , 0, 999);
        //category = "C09";
        category = UtilityBelt.readString("category: ", 3, 3);
        //cardNum = "SRC9876543210";
        cardNum = UtilityBelt.readString("cardNum: ", 13, 13);
        //birthCountry = "Guatemala";
        birthCountry = UtilityBelt.readString("Birth country: ", 0, 50);
        //termsAndConditions = "None";
        termsAndConditions = UtilityBelt.readString("Terms and Conditions: ", 0, 9);

        //birthDay = 1;
        birthDay = UtilityBelt.readInt("Birthday: ", 0, 31);
        //birthMonth = "JAN";
        birthMonth = UtilityBelt.readString("Birth Month: ", 3, 3);
        //birthYear = 1970;
        birthYear = UtilityBelt.readInt("Birth Year: ", 0, 9999);

        //sex = 'M'; //note single quotes
        sex = UtilityBelt.readChar("Sex: ", "MmFf");
        //validMonth = 2;
        validMonth = UtilityBelt.readInt("Valid Month: ", 1, 12);
        //validDay = 2;
        validDay = UtilityBelt.readInt("Valid Day: ", 1, 31);
        //validYear = 2020;
        validYear = UtilityBelt.readInt("Vaid Year: ", 1, 9999);

       // expireMonth = 2;
        expireMonth = UtilityBelt.readInt("Expire Month: ", 1, 12);
        //expireDay = 2;
        expireDay = UtilityBelt.readInt("Expire Day:", 1, 31);
        //expireYear = 2022;
        expireYear = UtilityBelt.readInt("Expire Year: ", 1, 9999);

        //Strings to help clean up long printf's below
        uscisNum = String.format("%03d-%03d-%03d", uscisNum1, uscisNum2, uscisNum3);
        dateOfBirth = String.format("%02d %s %d", birthDay, birthMonth, birthYear);
        validDate = formatDate(validMonth, validDay, validYear);
        expireDate = formatDate(expireMonth, expireDay, expireYear);
        String card = formatCard(surname, givenName,
     category,  cardNum,  birthCountry, 
     termsAndConditions,  sex,  uscisNum, 
     dateOfBirth,  validDate,  expireDate);
     System.out.print(card);

        //INPUT + CALCULATION SECTION
        //N/A

        //OUTPUT SECTION

    }

    // Description: Prints out a card with formatted data 
    // Precondition: All data filled out correctly, non-void data, and all values are greater than 0.
    // Postconditon: Creates card with no new line afterwards, if fitted to 72 spaces. Data which exceeds this will warp card.
    public static String formatCard(String surname, String givenName,
    String category, String cardNum, String birthCountry, 
    String termsAndConditions, char sex, String uscisNum, 
    String dateOfBirth, String validDate, String expireDate)
    {
        return String.format("╔══════════════════════════════════════════════════════════════════════╗%n") + String.format("║%35s%35s║%n", TITLE_USA, "")
        + String.format("║%60s%10s║%n", TITLE_EAC, "") + String.format("║%-25s%-45s║%n", "", LABEL_SURNAME) + String.format("║%-25s%-45s║%n", "", surname) +
        String.format("║%-25s%-45s║%n", ASCII_ART_0, LABEL_GIVEN_NAME) + String.format("║%-25s%-45s║%n", ASCII_ART_1, givenName) + String.format("║%-25s%-15s%-15s%-15s║%n", ASCII_ART_2, LABEL_USCIS_NUM, LABEL_CATEGORY, LABEL_CARD_NUM)
        + String.format("║%-25s%-15s%-15s%-15s║%n", ASCII_ART_3, uscisNum, category, cardNum) + String.format("║%-25s%-45s║%n", ASCII_ART_4, LABEL_BIRTH_COUNTRY)
        + String.format("║%-25s%-45s║%n", ASCII_ART_5, birthCountry)
        + String.format("║%-25s%-45s║%n", ASCII_ART_6, LABEL_TERMS_CONDITIONS)
        + String.format("║%-25s%-45s║%n", ASCII_ART_7, termsAndConditions)
        + String.format("║%-25s%-15s%-30s║%n", ASCII_ART_8, LABEL_BIRTH_DATE, LABEL_SEX)
        + String.format("║%-25s%-15s%-30s║%n", ASCII_ART_9, dateOfBirth, sex)
        + String.format("║%-25s%-15s%-30s║%n", "", LABEL_VALID_DATE, validDate)
        + String.format("║%-25s%-15s%-30s║%n", "", LABEL_EXPIRE_DATE, expireDate)
        + String.format("║%-25s%-45s║%n", ASCII_CREDIT, LABEL_REENTRY_DISCLAIMER)
        + String.format("╚══════════════════════════════════════════════════════════════════════╝");
    }
    //Description: Formats the dates for experation and valid.
    //Precondition: All data filled out correctly without any void data, and all values are greater than 0.
    //Postcondition: Allows for user to input date for valid and experation, returns date in the format: 00/00/0000.
    public static String formatDate(int month, int day, int year)
    {

        return String.format("%02d/%02d/%4d", month, day, year);
    }
}