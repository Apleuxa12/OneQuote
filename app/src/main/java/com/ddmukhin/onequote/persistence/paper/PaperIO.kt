package com.ddmukhin.onequote.persistence.paper

import com.ddmukhin.onequote.persistence.DatabaseKey
import com.ddmukhin.onequote.ui.data.Language

fun PaperDatabase.setLanguage(language: Language) {
    write(DatabaseKey.Language, language.stringValue)
}

fun PaperDatabase.getLanguage(): Language = read(DatabaseKey.Language)