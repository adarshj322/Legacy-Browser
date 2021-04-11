package acr.browser.presearch.search.engine

import acr.browser.presearch.R

/**
 * A custom search engine.
 */
class CustomSearch(queryUrl: String) : BaseSearchEngine(
    "file:///android_asset/engine.browser.presearch.png",
    queryUrl,
    R.string.search_engine_custom
)
