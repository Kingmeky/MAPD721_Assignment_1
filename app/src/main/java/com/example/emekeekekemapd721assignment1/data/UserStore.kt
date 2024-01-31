package com.example.emekeekekemapd721assignment1.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart

class UserStore(private val context: Context) {
    companion object {
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("user_data")
        private val NAME_KEY = stringPreferencesKey("name")
        private val USERID_KEY = stringPreferencesKey("userid")
        private val EMAIL_KEY = stringPreferencesKey("email")
    }
    val getSavedData: Flow<String> = context.dataStore.data.map { preferences ->
        val name = preferences[NAME_KEY] ?: ""
        val userid = preferences[USERID_KEY] ?: ""
        val email = preferences[EMAIL_KEY] ?: ""
        "Name: $name, Userid: $userid, Email: $email"
    }.onStart { emit("") }

    suspend fun saveData(name: String, userid: String, email: String) {
        context.dataStore.edit { preferences ->
            preferences[NAME_KEY] = name
            preferences[USERID_KEY] = userid
            preferences[EMAIL_KEY] = email
        }
    }

    suspend fun clearData() {
        context.dataStore.edit { preferences ->
            preferences.remove(NAME_KEY)
            preferences.remove(USERID_KEY)
            preferences.remove(EMAIL_KEY)
        }
    }
}


