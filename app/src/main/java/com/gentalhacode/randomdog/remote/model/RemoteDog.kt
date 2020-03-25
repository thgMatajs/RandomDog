package com.gentalhacode.randomdog.remote.model

import com.gentalhacode.randomdog.model.Dog
import com.google.gson.annotations.SerializedName

/**
 * .:.:.:. Created by @thgMatajs on 25/03/20 .:.:.:.
 */
class RemoteDog(
    @SerializedName("url")
    override val photoUrl: String
) : Dog