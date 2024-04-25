package com.example.testingproject.data.proto_datastore

import androidx.datastore.core.CorruptionException
import androidx.datastore.core.Serializer
import androidx.datastore.preferences.protobuf.InvalidProtocolBufferException
import com.example.testingproject.AppPreference
import com.example.testingproject.EmployeeData
import com.example.testingproject.EmployeeList
import java.io.InputStream
import java.io.OutputStream
import javax.inject.Inject

class AppPreferenceSerializer @Inject constructor() : Serializer<AppPreference> {
    override val defaultValue: AppPreference = AppPreference.getDefaultInstance()

    override suspend fun readFrom(input: InputStream): AppPreference {
        try {
            return AppPreference.parseFrom(input)
        } catch (exception: InvalidProtocolBufferException) {
            throw CorruptionException("Cannot read proto.", exception)
        }
    }

    override suspend fun writeTo(
        t: AppPreference,
        output: OutputStream
    ) = t.writeTo(output)
}
