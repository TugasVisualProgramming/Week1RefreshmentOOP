package Model

import android.os.Parcel
import android.os.Parcelable

class Hewan (
    var namaHewan: String?,
    var jenisHewan: String?,
    var usiaHewan: String?
    ): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
    ) {
    }

    var imageUri:String = ""

    override fun writeToParcel(parcel: Parcel, flaags: Int) {
        parcel.writeString(namaHewan)
        parcel.writeString(jenisHewan)
        parcel.writeString(usiaHewan)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Hewan> {
        override fun createFromParcel(parcel: Parcel): Hewan {
            return Hewan(parcel)
        }

        override fun newArray(size: Int): Array<Hewan?> {
            return arrayOfNulls(size)
        }
    }


}