package jbehave.steps;

import com.structure.core.pages.SearchResultPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;
import org.openqa.selenium.support.ui.Wait;

public class FilterPanelSteps extends ScenarioSteps {

    private SearchResultPage searchResultPage;

    public FilterPanelSteps(final Pages pages) {
        super(pages);
        this.searchResultPage = getPages().getPage(SearchResultPage.class);
    }

    @Step
    public void checkAmasingFiltr() {
        searchResultPage.getFilterPanel()
                .checkFirstFiltr();
    }

    @Step
    public void checkCancellationFiltr() {
        searchResultPage.getFilterPanel()
                .checkSecondFiltr();
    }

    @Step
    public boolean isSearchResultListContainsFirstFilterParameter(final String firstFilter){

        return searchResultPage.getResultsPanel()
                .getResultItemsByFirstFiltr().stream().allMatch(s -> s.contains(firstFilter));
    }

    @Step
    public boolean isSearchResultListContainsSecondFilterParameter(final String secondFilter) {
        return searchResultPage.getResultsPanel().getResultBySecondFiltr().stream().allMatch(s -> s.contains(secondFilter));
    }
}
