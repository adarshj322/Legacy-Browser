package acr.browser.lightning._browser2.search

import acr.browser.lightning.search.SearchEngineProvider
import acr.browser.lightning.utils.QUERY_PLACE_HOLDER
import acr.browser.lightning.utils.smartUrlFilter
import android.app.SearchManager
import android.content.Intent
import javax.inject.Inject

/**
 * Created by anthonycr on 9/20/20.
 */
class IntentExtractor @Inject constructor(private val searchEngineProvider: SearchEngineProvider) {

    /**
     * TODO
     */
    fun extractUrlFromIntent(intent: Intent): String? {
        return if (intent.action == Intent.ACTION_WEB_SEARCH) {
            extractSearchFromIntent(intent)
        } else {
            intent.dataString
        }
    }

    private fun extractSearchFromIntent(intent: Intent): String? {
        val query = intent.getStringExtra(SearchManager.QUERY)
        val searchUrl = "${searchEngineProvider.provideSearchEngine().queryUrl}$QUERY_PLACE_HOLDER"

        return if (query?.isNotBlank() == true) {
            smartUrlFilter(query, true, searchUrl)
        } else {
            null
        }
    }

}