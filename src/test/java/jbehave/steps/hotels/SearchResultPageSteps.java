package jbehave.steps.hotels;

import com.structure.core.pages.hotels.SearchResultPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

public class SearchResultPageSteps extends ScenarioSteps {

    private final SearchResultPage searchResultPage;

    public SearchResultPageSteps(final Pages pages) {
        super(pages);
        searchResultPage = getPages().getPage(SearchResultPage.class);
    }

    @Step
    public boolean isSearchResultListContainSearchText(final String searchedText) {
        return searchResultPage.getResultsPanel()
                .getResultItems()
                .stream().allMatch(s -> s.contains(searchedText));
    }
}
