package acr.browser.presearch.di

import acr.browser.presearch.BrowserApp
import acr.browser.presearch.adblock.BloomFilterAdBlocker
import acr.browser.presearch.adblock.NoOpAdBlocker
import acr.browser.presearch.browser.SearchBoxModel
import acr.browser.presearch.browser.activity.BrowserActivity
import acr.browser.presearch.browser.activity.ThemableBrowserActivity
import acr.browser.presearch.browser.bookmarks.BookmarksDrawerView
import acr.browser.presearch.device.BuildInfo
import acr.browser.presearch.dialog.LightningDialogBuilder
import acr.browser.presearch.download.LightningDownloadListener
import acr.browser.presearch.reading.activity.ReadingActivity
import acr.browser.presearch.search.SuggestionsAdapter
import acr.browser.presearch.settings.activity.SettingsActivity
import acr.browser.presearch.settings.activity.ThemableSettingsActivity
import acr.browser.presearch.settings.fragment.*
import acr.browser.presearch.view.LightningChromeClient
import acr.browser.presearch.view.LightningView
import acr.browser.presearch.view.LightningWebClient
import android.app.Application
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [(AppModule::class), (AppBindsModule::class)])
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        @BindsInstance
        fun buildInfo(buildInfo: BuildInfo): Builder

        fun build(): AppComponent
    }

    fun inject(activity: BrowserActivity)

    fun inject(fragment: BookmarkSettingsFragment)

    fun inject(builder: LightningDialogBuilder)

    fun inject(lightningView: LightningView)

    fun inject(activity: ThemableBrowserActivity)

    fun inject(advancedSettingsFragment: AdvancedSettingsFragment)

    fun inject(app: BrowserApp)

    fun inject(activity: ReadingActivity)

    fun inject(webClient: LightningWebClient)

    fun inject(activity: SettingsActivity)

    fun inject(activity: ThemableSettingsActivity)

    fun inject(listener: LightningDownloadListener)

    fun inject(fragment: PrivacySettingsFragment)

    fun inject(fragment: DebugSettingsFragment)

    fun inject(suggestionsAdapter: SuggestionsAdapter)

    fun inject(chromeClient: LightningChromeClient)

    fun inject(searchBoxModel: SearchBoxModel)

    fun inject(generalSettingsFragment: GeneralSettingsFragment)

    fun inject(displaySettingsFragment: DisplaySettingsFragment)

    fun inject(adBlockSettingsFragment: AdBlockSettingsFragment)

    fun inject(bookmarksView: BookmarksDrawerView)

    fun provideBloomFilterAdBlocker(): BloomFilterAdBlocker

    fun provideNoOpAdBlocker(): NoOpAdBlocker

}
