package acr.browser.presearch.di

import acr.browser.presearch.adblock.allowlist.AllowListModel
import acr.browser.presearch.adblock.allowlist.SessionAllowListModel
import acr.browser.presearch.adblock.source.AssetsHostsDataSource
import acr.browser.presearch.adblock.source.HostsDataSource
import acr.browser.presearch.adblock.source.HostsDataSourceProvider
import acr.browser.presearch.adblock.source.PreferencesHostsDataSourceProvider
import acr.browser.presearch.browser.cleanup.DelegatingExitCleanup
import acr.browser.presearch.browser.cleanup.ExitCleanup
import acr.browser.presearch.database.adblock.HostsDatabase
import acr.browser.presearch.database.adblock.HostsRepository
import acr.browser.presearch.database.allowlist.AdBlockAllowListDatabase
import acr.browser.presearch.database.allowlist.AdBlockAllowListRepository
import acr.browser.presearch.database.bookmark.BookmarkDatabase
import acr.browser.presearch.database.bookmark.BookmarkRepository
import acr.browser.presearch.database.downloads.DownloadsDatabase
import acr.browser.presearch.database.downloads.DownloadsRepository
import acr.browser.presearch.database.history.HistoryDatabase
import acr.browser.presearch.database.history.HistoryRepository
import acr.browser.presearch.ssl.SessionSslWarningPreferences
import acr.browser.presearch.ssl.SslWarningPreferences
import dagger.Binds
import dagger.Module

/**
 * Dependency injection module used to bind implementations to interfaces.
 */
@Module
interface AppBindsModule {

    @Binds
    fun bindsExitCleanup(delegatingExitCleanup: DelegatingExitCleanup): ExitCleanup

    @Binds
    fun bindsBookmarkModel(bookmarkDatabase: BookmarkDatabase): BookmarkRepository

    @Binds
    fun bindsDownloadsModel(downloadsDatabase: DownloadsDatabase): DownloadsRepository

    @Binds
    fun bindsHistoryModel(historyDatabase: HistoryDatabase): HistoryRepository

    @Binds
    fun bindsAdBlockAllowListModel(adBlockAllowListDatabase: AdBlockAllowListDatabase): AdBlockAllowListRepository

    @Binds
    fun bindsAllowListModel(sessionAllowListModel: SessionAllowListModel): AllowListModel

    @Binds
    fun bindsSslWarningPreferences(sessionSslWarningPreferences: SessionSslWarningPreferences): SslWarningPreferences

    @Binds
    fun bindsHostsDataSource(assetsHostsDataSource: AssetsHostsDataSource): HostsDataSource

    @Binds
    fun bindsHostsRepository(hostsDatabase: HostsDatabase): HostsRepository

    @Binds
    fun bindsHostsDataSourceProvider(preferencesHostsDataSourceProvider: PreferencesHostsDataSourceProvider): HostsDataSourceProvider
}
