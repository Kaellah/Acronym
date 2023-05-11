package com.kaellah.acronym.feature.data.source.local

import androidx.collection.LruCache
import com.kaellah.acronym.feature.data.model.AcronymDefinition
import com.kaellah.acronym.feature.di.DiConstant
import javax.inject.Inject

/**
 * Contract for the caching storage of abbreviations and related definitions
 *  to prevent frequent use of the network
 */
interface AcronymsCache {

    operator fun get(acronym: String): List<AcronymDefinition>

    operator fun set(acronym: String, definitions: List<AcronymDefinition>)
}

/**
 * The actual implementation of [AcronymsCache] using [LruCache] for storage
 *
 * @param cacheSize the maximum number of cached objects that can be stored
 */
class AcronymsCacheImpl @Inject constructor(
    @DiConstant.AcronymsDefinitionsCacheSize
    cacheSize: Int,
) : AcronymsCache {

    private val cache: LruCache<String, List<AcronymDefinition>> = LruCache(cacheSize)

    override fun get(acronym: String): List<AcronymDefinition> =
        cache.get(acronym.uppercase()) ?: emptyList()

    override fun set(acronym: String, definitions: List<AcronymDefinition>) {
        cache.put(acronym.uppercase(), definitions)
    }
}
