package com.example.testingproject.data.proto_datastore

import androidx.datastore.core.CorruptionException
import androidx.datastore.core.Serializer
import androidx.datastore.preferences.protobuf.InvalidProtocolBufferException
import com.example.testingproject.EmployeeList
import java.io.InputStream
import java.io.OutputStream
import javax.inject.Inject

class EmployeeInfoSerializer @Inject constructor() : Serializer<EmployeeList> {
    override val defaultValue: EmployeeList = EmployeeList.getDefaultInstance()

    override suspend fun readFrom(input: InputStream): EmployeeList {
        try {
            return EmployeeList.parseFrom(input)
        } catch (exception: InvalidProtocolBufferException) {
            throw CorruptionException("Cannot read proto.", exception)
        }
    }

    override suspend fun writeTo(
        t: EmployeeList,
        output: OutputStream
    ) = t.writeTo(output)
}
