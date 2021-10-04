package com.example.practiceapp.note

import android.os.Parcel
import android.os.Parcelable


class Notes(var title: String?, var message: String?) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString())

    override fun describeContents(): Int {
        return 0;
    }

    override fun writeToParcel(dest: Parcel?, flags: Int) {
    }

    companion object CREATOR : Parcelable.Creator<Notes> {
        override fun createFromParcel(parcel: Parcel): Notes {
            return Notes(parcel)
        }

        override fun newArray(size: Int): Array<Notes?> {
            return arrayOfNulls(size)
        }
    }

}