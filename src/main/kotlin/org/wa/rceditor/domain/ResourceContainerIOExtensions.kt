package org.wa.rceditor.domain

import io.reactivex.Completable
import io.reactivex.Maybe
import org.wycliffeassociates.resourcecontainer.ResourceContainer
import org.wycliffeassociates.resourcecontainer.entity.Checking
import org.wycliffeassociates.resourcecontainer.entity.DublinCore
import org.wycliffeassociates.resourcecontainer.entity.Manifest
import java.io.File

fun ResourceContainer.Companion.open(file: File): Maybe<ResourceContainer> {
    return Maybe.fromCallable {
        ResourceContainer.load(file)
    }
}

fun ResourceContainer.Companion.create(file: File): Maybe<ResourceContainer> {
    return Maybe.fromCallable {
        ResourceContainer.create(file) {
            this.manifest = Manifest(DublinCore(), listOf(), Checking())
        }
    }
}

fun ResourceContainer.Companion.save(container: ResourceContainer): Completable {
    return Completable.fromCallable {
        container.write()
    }
}