
/*
    SWAPI API - Star wars API
    This is main function
    This will be used to run API tests from APICallTest.
 */
public class Main {
    public static void main(String[] args) {
        APICallTest apiCallTest = new APICallTest();
        apiCallTest.countAllAPITest();
        apiCallTest.invalidUrlTest();
        apiCallTest.searchReturnsEmptyResultsForIncorrectSearchTerm();
        apiCallTest.searchReturnsMoreThanOneResults();
        apiCallTest.searchReturnsAllResultsforEmptySearchTerm();
        apiCallTest.getFilmById();
        apiCallTest.getPlanetByUsingIdWhichDoesNotExist();
    }
}