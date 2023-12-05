package tests;import org.testng.Assert;import org.testng.annotations.DataProvider;import org.testng.annotations.Test;import pages.CompxHomePage;import pages.CompxProductPage;public class CompXSearchFieldNegativeTest extends TestInit {    @DataProvider(parallel = true)    public Object[][] searchInvalidText() {        return new Object[][]{                {"zdgsfgdfhjr"}//                {"dvscv562cvv"}//                {"2565465656566"},//                {"@@@@"}, {"........"}, {"%%%%%%"}, {"******"}, {"}}}}}}"}, {")))))"}, {"((((("}, {"!!!!!"},//                {"+++++"}, {"-----"}, {"____"},//                {"$$$$"}, {"#####"}, {"&&&&&"}, {"^^^^^"}, {">>>>>"}, {"<<<<"}, {";;;;;"}, {":::::"}, {"  "},//                {"====="}, {",,,,,,,"}, {""}        };    }    @Test(dataProvider = "searchInvalidText")    public void Test1(String invalidText) {        String expextedTextBadSearchTitle = "Пошук - " + "\"" + invalidText + "\"";        CompxHomePage compxHomePage = new CompxHomePage(getDriver());        compxHomePage.openCompX()                .inputProductInSearchField(invalidText);        CompxProductPage compXProductPage = new CompxProductPage(getDriver());        String actualTextBadSearchTitle = compXProductPage.getTextBadSearchTitle();//        System.out.println(expextedTextBadSearchTitle);//        System.out.println(productPage.getTextBadSearchTitle());        Assert.assertEquals(actualTextBadSearchTitle,(expextedTextBadSearchTitle));    }}