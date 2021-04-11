package acr.browser.presearch.search

import acr.browser.presearch.di.SuggestionsClient
import acr.browser.presearch.log.Logger
import acr.browser.presearch.preference.UserPreferences
import acr.browser.presearch.search.engine.*
import acr.browser.presearch.search.suggestions.*
import android.app.Application
import dagger.Reusable
import io.reactivex.Single
import okhttp3.OkHttpClient
import javax.inject.Inject

/**
 * The model that provides the search engine based
 * on the user's preference.
 */
@Reusable
class SearchEngineProvider @Inject constructor(
    private val userPreferences: UserPreferences,
    @SuggestionsClient private val okHttpClient: Single<OkHttpClient>,
    private val requestFactory: RequestFactory,
    private val application: Application,
    private val logger: Logger
) {

    /**
     * Provide the [SuggestionsRepository] that maps to the user's current preference.
     */
    fun provideSearchSuggestions(): SuggestionsRepository =
        when (userPreferences.searchSuggestionChoice) {
            0 -> NoOpSuggestionsRepository()
            1 -> GoogleSuggestionsModel(okHttpClient, requestFactory, application, logger)
            2 -> DuckSuggestionsModel(okHttpClient, requestFactory, application, logger)
            3 -> BaiduSuggestionsModel(okHttpClient, requestFactory, application, logger)
            4 -> NaverSuggestionsModel(okHttpClient, requestFactory, application, logger)
            else -> GoogleSuggestionsModel(okHttpClient, requestFactory, application, logger)
        }

    /**
     * Provide the [BaseSearchEngine] that maps to the user's current preference.
     */
    fun provideSearchEngine(): BaseSearchEngine =
        when (userPreferences.searchChoice) {
            0 -> CustomSearch(userPreferences.searchUrl)
            1 -> PreSearch()
            2 -> GoogleSearch()
            3 -> AskSearch()
            4 -> BingSearch()
            5 -> YahooSearch()
            6 -> StartPageSearch()
            7 -> StartPageMobileSearch()
            8 -> DuckSearch()
            9 -> DuckLiteSearch()
            10 -> BaiduSearch()
            11 -> YandexSearch()
            12 -> NaverSearch()
            else -> PreSearch()
        }

    /**
     * Return the serializable index of of the provided [BaseSearchEngine].
     */
    fun mapSearchEngineToPreferenceIndex(searchEngine: BaseSearchEngine): Int =
        when (searchEngine) {
            is CustomSearch -> 0
            is PreSearch -> 1
            is GoogleSearch -> 2
            is AskSearch -> 3
            is BingSearch -> 4
            is YahooSearch -> 5
            is StartPageSearch -> 6
            is StartPageMobileSearch -> 7
            is DuckSearch -> 8
            is DuckLiteSearch -> 9
            is BaiduSearch -> 10
            is YandexSearch -> 11
            is NaverSearch -> 12
            else -> throw UnsupportedOperationException("Unknown search engine provided: " + searchEngine.javaClass)
        }

    /**
     * Provide a list of all supported search engines.
     */
    fun provideAllSearchEngines(): List<BaseSearchEngine> = listOf(
        CustomSearch(userPreferences.searchUrl),
        PreSearch(),
        GoogleSearch(),
        AskSearch(),
        BingSearch(),
        YahooSearch(),
        StartPageSearch(),
        StartPageMobileSearch(),
        DuckSearch(),
        DuckLiteSearch(),
        BaiduSearch(),
        YandexSearch(),
        NaverSearch()
    )

}
