package data


import com.google.gson.annotations.SerializedName

data class funFact(
    @SerializedName("data")
    val `data`: Data?,
    @SerializedName("status")
    val status: Boolean?
)