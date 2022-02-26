package data


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("cat")
    val cat: String?,
    @SerializedName("fact")
    val fact: String?,
    @SerializedName("hits")
    val hits: String?,
    @SerializedName("id")
    val id: String?
)