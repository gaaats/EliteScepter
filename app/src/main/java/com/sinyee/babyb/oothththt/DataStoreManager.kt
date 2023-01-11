package com.sinyee.babyb.oothththt

import android.app.Application
import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.first
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DataStoreManager @Inject constructor(context: Application) {

    companion object {
        val appsCheckerDataStoreKey = stringPreferencesKey("appsChecker")
        val linkCheckerDataStoreKey = stringPreferencesKey("link")
        val userGeoDataStoreKey = stringPreferencesKey("userGeo")
        val listOfAllGeoDataStoreKey = stringPreferencesKey("listOfAllGeo")


        val namingDataStoreKey = stringPreferencesKey("naming")
        val randomUUIDDataStoreKey = stringPreferencesKey("randomId")
        val instIDDataStoreKey = stringPreferencesKey("instID")
        val firstStartDataStoreKey = stringPreferencesKey("firstStart")

        val advertIDDataStoreKey = stringPreferencesKey("advertID")





    }

    private val Context.datasote: DataStore<Preferences> by preferencesDataStore("SETTINGS")
    private val dataStore = context.datasote


    suspend fun readStringFromDataStore(key: Preferences.Key<String>): String? {
        val pref = dataStore.data.first()
        return pref[key]
    }

    //todo:make later
//
//    suspend fun readStringFromDataStoreVithOutSuspend(key: Preferences.Key<String>): String? {
//        var res : String? = "loading"
//        CoroutineScope(Dispatchers.IO).launch {
//            val pref = dataStore.data.first()
//            res = pref[key]
//
//
//        }
//
//        return res
//    }

    suspend fun saveStringToDataStore(key: Preferences.Key<String>, value: String) {
        dataStore.edit {
            it[key] = value
        }
    }
}