package acr.browser.presearch.search.engine

import acr.browser.presearch.R

/**
 * The Presearch engine.
 */
class PreSearch : BaseSearchEngine (
        "file:///android_asset/presearch.png",
        "https://engine.presearch.org/search?client=lightning&ie=UTF-8&oe=UTF-8&q=",
        R.string.search_engine_presearch
)